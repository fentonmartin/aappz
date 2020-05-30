package io.github.fentonmartin.aappz.location.listener;

import android.location.Address;
import android.location.Location;

import java.util.List;

public interface OnReverseGeocodingListener {

    void onAddressResolved(Location original, List<Address> results);

}