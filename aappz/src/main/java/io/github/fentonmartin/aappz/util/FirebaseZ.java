package io.github.fentonmartin.aappz.util;

public class FirebaseZ {

    /* HERE: FirebaseZ -----------------------------------------------------------------------------
     *  Add FirebaseAnalytics.getInstance(this) from Activity onCreate
     *
     *  firebaseLog
     *  => Set logs for some events based on event on application
     *  firebaseScreen
     *  => Set screen name based on current context on application
     *  firebaseProperty
     *  => Set user property for event filter based on type
     *  */

//    private FirebaseAnalytics mFirebaseAnalytics;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
//    }

//    public void firebaseLog(String type, String log) {
//        setLog("FirebaseZ | firebaseLog: " + log);
//        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, log);
//        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, log);
//        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//    }
//
//    public void firebaseLog(String event, String type, String log) {
//        setLog("FirebaseZ | firebaseLog: " + log);
//        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, log);
//        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, log);
//        mFirebaseAnalytics.logEvent(event, bundle);
//    }
//
//    public void firebaseScreen() {
//        /* Note: Add firebaseScreen at onCreate and onResume */
//        setLog("FirebaseZ | firebaseScreen: " + getClass().getSimpleName());
//        mFirebaseAnalytics.setCurrentScreen(this, getClass().getSimpleName(), null);
//    }
//
//    public void firebaseProperty(String property, String type) {
//        setLog("FirebaseZ | firebaseProperty: " + type);
//        mFirebaseAnalytics.setUserProperty(property, type);
//    }

}
