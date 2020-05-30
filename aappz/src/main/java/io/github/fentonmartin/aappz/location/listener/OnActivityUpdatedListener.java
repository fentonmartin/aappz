package io.github.fentonmartin.aappz.location.listener;

import com.google.android.gms.location.DetectedActivity;

public interface OnActivityUpdatedListener {

    void onActivityUpdated(DetectedActivity detectedActivity);

}