package io.github.fentonmartin.aappz.location.listener;

public interface GooglePlayServicesListener {

    void onConnected(android.os.Bundle bundle);

    void onConnectionSuspended(int i);

    void onConnectionFailed(com.google.android.gms.common.ConnectionResult connectionResult);

}
