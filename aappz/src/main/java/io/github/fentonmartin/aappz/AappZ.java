package io.github.fentonmartin.aappz;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import io.github.fentonmartin.aappz.util.ActivityZ;

public class AappZ extends ActivityZ {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    /* HERE: FIREBASE FUNCTIONS ------------------------------------------------------------------
     *  LOG
     *  => Set logs for some events based on event on application
     *  SCREEN
     *  => Set screen name based on current context on application
     *  PROPERTY
     *  => Set user property for event filter based on type
     *  */
    public void firebaseLog(String type, String log) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, log);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, log);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    public void firebaseLog(String event, String type, String log) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, log);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, log);
        mFirebaseAnalytics.logEvent(event, bundle);
    }

    public void firebaseScreen() {
        mFirebaseAnalytics.setCurrentScreen(this, getClass().getSimpleName(), null);
    }

    public void firebaseProperty(String property, String type) {
        mFirebaseAnalytics.setUserProperty(property, type);
    }

}
