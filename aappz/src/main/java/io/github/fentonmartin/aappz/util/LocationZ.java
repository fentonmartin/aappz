package io.github.fentonmartin.aappz.util;

import android.content.Context;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.location.DetectedActivity;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import io.github.fentonmartin.aappz.location.LocationGeocoding;
import io.github.fentonmartin.aappz.location.LocationGeofencing;
import io.github.fentonmartin.aappz.location.listener.GeocodingListener;
import io.github.fentonmartin.aappz.location.listener.GeofencingListener;
import io.github.fentonmartin.aappz.location.listener.LocationListener;
import io.github.fentonmartin.aappz.location.listener.OnActivityUpdatedListener;
import io.github.fentonmartin.aappz.location.listener.OnGeocodingListener;
import io.github.fentonmartin.aappz.location.listener.OnGeofencingTransitionListener;
import io.github.fentonmartin.aappz.location.listener.OnLocationUpdatedListener;
import io.github.fentonmartin.aappz.location.listener.OnReverseGeocodingListener;
import io.github.fentonmartin.aappz.location.provider.ActivityProvider;
import io.github.fentonmartin.aappz.location.provider.LocationFallbackProvider;
import io.github.fentonmartin.aappz.location.util.ActivityParams;
import io.github.fentonmartin.aappz.location.util.GeofenceModel;
import io.github.fentonmartin.aappz.location.util.LocationParams;
import io.github.fentonmartin.aappz.location.util.LocationState;

/**
 * Managing class for LocationZ library.
 */
public class LocationZ {

    private Context context;
    private LogZ.Logger logger;
    private boolean preInitialize;

    /**
     * Creates the LocationZ basic instance.
     *
     * @param context       execution context
     * @param logger        logger interface
     * @param preInitialize TRUE (default) if we want to instantiate directly the default providers. FALSE if we want to initialize them ourselves.
     */
    private LocationZ(Context context, LogZ.Logger logger, boolean preInitialize) {
        this.context = context;
        this.logger = logger;
        this.preInitialize = preInitialize;
    }

    public static LocationZ with(Context context) {
        return new Builder(context).build();
    }

    /**
     * @return request handler for location operations
     */
    public LocationControl location() {
        return location(new LocationFallbackProvider(context));
    }

    /**
     * @param listener location provider we want to use
     * @return request handler for location operations
     */
    public LocationControl location(LocationListener listener) {
        return new LocationControl(this, listener);
    }

    /**
     * Builder for activity recognition. Use activity() instead.
     *
     * @return builder for activity recognition.
     * @deprecated
     */
    @Deprecated
    public ActivityRecognitionControl activityRecognition() {
        return activity();
    }

    /**
     * @return request handler for activity recognition
     */
    public ActivityRecognitionControl activity() {
        return activity(new ActivityProvider());
    }

    /**
     * @param provider activity provider we want to use
     * @return request handler for activity recognition
     */
    public ActivityRecognitionControl activity(ActivityProvider provider) {
        return new ActivityRecognitionControl(this, provider);
    }

    /**
     * @return request handler for geofencing operations
     */
    public GeofencingControl geofencing() {
        return geofencing(new LocationGeofencing());
    }

    /**
     * @param listener geofencing provider we want to use
     * @return request handler for geofencing operations
     */
    public GeofencingControl geofencing(GeofencingListener listener) {
        return new GeofencingControl(this, listener);
    }

    /**
     * @return request handler for geocoding operations
     */
    public GeocodingControl geocoding() {
        return geocoding(new LocationGeocoding());
    }

    /**
     * @param listener geocoding provider we want to use
     * @return request handler for geocoding operations
     */
    public GeocodingControl geocoding(GeocodingListener listener) {
        return new GeocodingControl(this, listener);
    }

    public static class Builder {

        private final Context context;
        private boolean loggingEnabled;
        private boolean preInitialize;

        public Builder(@NonNull Context context) {
            this.context = context;
            this.loggingEnabled = false;
            this.preInitialize = true;
        }

        public Builder logging(boolean enabled) {
            this.loggingEnabled = enabled;
            return this;
        }

        public Builder preInitialize(boolean enabled) {
            this.preInitialize = enabled;
            return this;
        }

        public LocationZ build() {
            return new LocationZ(context, LogZ.build(loggingEnabled), preInitialize);
        }
    }

    public static class LocationControl {

        private static final Map<Context, LocationListener> MAPPING = new WeakHashMap<>();

        private final LocationZ locationZ;
        private LocationParams params;
        private LocationListener provider;
        private boolean oneFix;

        public LocationControl(@NonNull LocationZ locationZ, @NonNull LocationListener listener) {
            this.locationZ = locationZ;
            params = LocationParams.BEST_EFFORT;
            oneFix = false;

            if (!MAPPING.containsKey(locationZ.context)) {
                MAPPING.put(locationZ.context, listener);
            }
            provider = MAPPING.get(locationZ.context);

            if (locationZ.preInitialize) {
                provider.init(locationZ.context, locationZ.logger);
            }
        }

        public LocationControl config(@NonNull LocationParams params) {
            this.params = params;
            return this;
        }

        public LocationControl oneFix() {
            this.oneFix = true;
            return this;
        }

        public LocationControl continuous() {
            this.oneFix = false;
            return this;
        }

        public LocationState state() {
            return LocationState.with(locationZ.context);
        }

        @Nullable
        public Location getLastLocation() {
            return provider.getLastLocation();
        }

        public LocationControl get() {
            return this;
        }

        public void start(OnLocationUpdatedListener listener) {
            if (provider == null) {
                throw new RuntimeException("A provider must be initialized");
            }
            provider.start(listener, params, oneFix);
        }

        public void stop() {
            provider.stop();
        }
    }

    public static class GeocodingControl {

        private static final Map<Context, GeocodingListener> MAPPING = new WeakHashMap<>();

        private final LocationZ locationZ;
        private GeocodingListener provider;
        private boolean directAdded = false;
        private boolean reverseAdded = false;

        public GeocodingControl(@NonNull LocationZ locationZ, @NonNull GeocodingListener listener) {
            this.locationZ = locationZ;

            if (!MAPPING.containsKey(locationZ.context)) {
                MAPPING.put(locationZ.context, listener);
            }
            provider = MAPPING.get(locationZ.context);

            if (locationZ.preInitialize) {
                provider.init(locationZ.context, locationZ.logger);
            }
        }

        public GeocodingControl get() {
            return this;
        }

        public void reverse(@NonNull Location location, @NonNull OnReverseGeocodingListener listener) {
            add(location);
            start(listener);
        }

        public void direct(@NonNull String name, @NonNull OnGeocodingListener listener) {
            add(name);
            start(listener);
        }

        public GeocodingControl add(@NonNull Location location) {
            reverseAdded = true;
            provider.addLocation(location, 1);
            return this;
        }

        public GeocodingControl add(@NonNull Location location, int maxResults) {
            reverseAdded = true;
            provider.addLocation(location, maxResults);
            return this;
        }

        public GeocodingControl add(@NonNull String name) {
            directAdded = true;
            provider.addName(name, 1);
            return this;
        }

        public GeocodingControl add(@NonNull String name, int maxResults) {
            directAdded = true;
            provider.addName(name, maxResults);
            return this;
        }

        public void start(OnGeocodingListener listener) {
            start(listener, null);
        }

        public void start(OnReverseGeocodingListener listener) {
            start(null, listener);
        }

        /**
         * Starts the geocoder conversions, for either direct geocoding (name to location) and reverse geocoding (location to address).
         *
         * @param geocodingListener        will be called for name to location queries
         * @param reverseGeocodingListener will be called for location to name queries
         */
        public void start(OnGeocodingListener geocodingListener, OnReverseGeocodingListener reverseGeocodingListener) {
            if (provider == null) {
                throw new RuntimeException("A provider must be initialized");
            }
            if (directAdded && geocodingListener == null) {
                locationZ.logger.w("Some places were added for geocoding but the listener was not specified!");
            }
            if (reverseAdded && reverseGeocodingListener == null) {
                locationZ.logger.w("Some places were added for reverse geocoding but the listener was not specified!");
            }
            provider.start(geocodingListener, reverseGeocodingListener);
        }

        /**
         * Cleans up after the geocoder calls. Will be needed for avoiding possible leaks in registered receivers.
         */
        public void stop() {
            provider.stop();
        }
    }

    public static class ActivityRecognitionControl {

        private static final Map<Context, ActivityProvider> MAPPING = new WeakHashMap<>();

        private final LocationZ locationZ;
        private ActivityParams params;
        private ActivityProvider provider;

        public ActivityRecognitionControl(@NonNull LocationZ locationZ, @NonNull ActivityProvider provider) {
            this.locationZ = locationZ;
            params = ActivityParams.NORMAL;

            if (!MAPPING.containsKey(locationZ.context)) {
                MAPPING.put(locationZ.context, provider);
            }
            this.provider = MAPPING.get(locationZ.context);

            if (locationZ.preInitialize) {
                this.provider.init(locationZ.context, locationZ.logger);
            }
        }

        public ActivityRecognitionControl config(@NonNull ActivityParams params) {
            this.params = params;
            return this;
        }

        @Nullable
        public DetectedActivity getLastActivity() {
            return provider.getLastActivity();
        }

        public ActivityRecognitionControl get() {
            return this;
        }

        public void start(OnActivityUpdatedListener listener) {
            if (provider == null) {
                throw new RuntimeException("A provider must be initialized");
            }
            provider.start(listener, params);
        }

        public void stop() {
            provider.stop();
        }
    }

    public static class GeofencingControl {

        private static final Map<Context, GeofencingListener> MAPPING = new WeakHashMap<>();

        private final LocationZ locationZ;
        private GeofencingListener provider;

        public GeofencingControl(@NonNull LocationZ locationZ, @NonNull GeofencingListener listener) {
            this.locationZ = locationZ;

            if (!MAPPING.containsKey(locationZ.context)) {
                MAPPING.put(locationZ.context, listener);
            }
            provider = MAPPING.get(locationZ.context);

            if (locationZ.preInitialize) {
                provider.init(locationZ.context, locationZ.logger);
            }
        }

        public GeofencingControl add(@NonNull GeofenceModel geofenceModel) {
            provider.addGeofence(geofenceModel);
            return this;
        }

        public GeofencingControl remove(@NonNull String geofenceId) {
            provider.removeGeofence(geofenceId);
            return this;
        }

        public GeofencingControl addAll(@NonNull List<GeofenceModel> geofenceModelList) {
            provider.addGeofences(geofenceModelList);
            return this;
        }

        public GeofencingControl removeAll(@NonNull List<String> geofenceIdsList) {
            provider.removeGeofences(geofenceIdsList);
            return this;
        }

        public void start(OnGeofencingTransitionListener listener) {
            if (provider == null) {
                throw new RuntimeException("A provider must be initialized");
            }
            provider.start(listener);
        }

        public void stop() {
            provider.stop();
        }
    }
}