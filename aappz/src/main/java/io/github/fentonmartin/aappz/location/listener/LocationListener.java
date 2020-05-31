package io.github.fentonmartin.aappz.location.listener;

import android.content.Context;
import android.location.Location;

import io.github.fentonmartin.aappz.location.util.LocationParams;
import io.github.fentonmartin.aappz.LogZ;

public interface LocationListener {

    void init(Context context, LogZ.Logger logger);

    void start(OnLocationUpdatedListener listener, LocationParams params, boolean singleUpdate);

    void stop();

    Location getLastLocation();

}
