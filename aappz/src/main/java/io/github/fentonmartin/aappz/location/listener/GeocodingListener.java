package io.github.fentonmartin.aappz.location.listener;

import android.content.Context;
import android.location.Location;

import io.github.fentonmartin.aappz.util.LogZ;

public interface GeocodingListener {
    void init(Context context, LogZ.Logger logger);

    void addName(String name, int maxResults);

    void addLocation(Location location, int maxResults);

    void start(OnGeocodingListener geocodingListener, OnReverseGeocodingListener reverseGeocodingListener);

    void stop();

}
