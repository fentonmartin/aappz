package io.github.fentonmartin.aappz.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.github.fentonmartin.aappz.constant.IntentConstant;

public class ActivityZ extends AppCompatActivity {

    IntentZ intentZ;
    LogZ logZ;
    ToastZ toastZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Initializations */
        intentZ = new IntentZ();
        logZ = new LogZ();
        toastZ = new ToastZ();

        setLog(this, "onCreate | ACTIVITY");
    }

    @Override
    protected void onStart() {
        setLog(this, "onStart | ACTIVITY");
        super.onStart();
    }

    @Override
    protected void onResume() {
        setLog(this, "onResume | ACTIVITY");
        super.onResume();
    }

    @Override
    protected void onPause() {
        setLog(this, "onPause | ACTIVITY");
        super.onPause();
    }

    @Override
    protected void onStop() {
        setLog(this, "onStop | ACTIVITY");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        setLog(this, "onRestart | ACTIVITY");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        setLog(this, "onDestroy | ACTIVITY");
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        setLog(this, "onBackPressed | ACTIVITY");
        super.onBackPressed();
    }

    /* HERE: ActionBarZ --------------------------------------------------------------------------*/

    public void setActionBar() {
        setActionBar(false);
    }

    public void setActionBar(boolean isMain) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            if (isMain) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setHomeButtonEnabled(false);
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
            }
        }
    }

    public void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setSubtitle(String subtitle) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(subtitle);
        }
    }

    /* HERE: LogZ --------------------------------------------------------------------------------*/

    public void setLog(String log) {
        logZ.setLog(log);
    }

    public void setLog(Activity activity, String log) {
        logZ.setLog(activity, log);
    }

    /* HERE: ToastZ ------------------------------------------------------------------------------*/

    public void setToast(String message) {
        toastZ.setToast(getApplicationContext(), message);
    }

    public void setToast(CharSequence message) {
        toastZ.setToast(getApplicationContext(), message);
    }

    /* HERE: IntentZ -----------------------------------------------------------------------------*/

    public void setActivity(Class activity) {
        startActivity(intentZ.intent(getApplicationContext(), activity));
    }

    public void setActivity(Class activity, int flag) {
        startActivity(intentZ.intent(getApplicationContext(), activity, flag));
    }

    public void setActivity(Class activity, boolean bool) {
        startActivity(intentZ.intent(getApplicationContext(), activity, IntentConstant.CONSTANT_INTENT, bool));
    }

    public void setActivity(Class activity, String text) {
        startActivity(intentZ.intent(getApplicationContext(), activity, IntentConstant.CONSTANT_INTENT, text));
    }

    public void setActivity(Class activity, Bundle bundle) {
        startActivity(intentZ.intent(getApplicationContext(), activity, IntentConstant.CONSTANT_INTENT, bundle));
    }

    public void setActivityClear(Class activity) {
        startActivity(intentZ.intentClear(getApplicationContext(), activity));
    }

    public void setActivityEmail(String email, String subject) {
        startActivity(intentZ.intentEmail(email, subject));
    }

    public void setActivityMarket(int id) {
        startActivity(intentZ.intentMarket(id));
    }

    public void setActivityWebsite(String website) {
        startActivity(intentZ.intentWebsite(website));
    }
}
