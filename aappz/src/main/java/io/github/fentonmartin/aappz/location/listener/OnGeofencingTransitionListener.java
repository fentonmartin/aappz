package io.github.fentonmartin.aappz.location.listener;

import io.github.fentonmartin.aappz.location.util.TransitionGeofence;

public interface OnGeofencingTransitionListener {

    void onGeofenceTransition(TransitionGeofence transitionGeofence);

}