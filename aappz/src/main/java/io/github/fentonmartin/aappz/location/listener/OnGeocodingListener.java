package io.github.fentonmartin.aappz.location.listener;

import java.util.List;

import io.github.fentonmartin.aappz.location.util.LocationAddress;

public interface OnGeocodingListener {

    void onLocationResolved(String name, List<LocationAddress> results);

}