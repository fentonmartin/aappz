package io.github.fentonmartin.aappz.location.listener;

import android.content.Context;

import java.util.List;

import io.github.fentonmartin.aappz.location.util.GeofenceModel;
import io.github.fentonmartin.aappz.util.LogZ;

public interface GeofencingListener {
    void init(Context context, LogZ.Logger logger);

    void start(OnGeofencingTransitionListener listener);

    void addGeofence(GeofenceModel geofence);

    void addGeofences(List<GeofenceModel> geofenceList);

    void removeGeofence(String geofenceId);

    void removeGeofences(List<String> geofenceIds);

    void stop();

}
