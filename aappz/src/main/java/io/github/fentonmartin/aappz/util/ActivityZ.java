package io.github.fentonmartin.aappz.util;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidRuntimeException;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import io.github.fentonmartin.aappz.constant.IntentConstant;

public class ActivityZ extends AppCompatActivity {

    IntentZ intentZ;
    LogZ logZ;
    ToastZ toastZ;
    ViewZ viewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Initializations */
        intentZ = new IntentZ();
        logZ = new LogZ();
        toastZ = new ToastZ();
        viewZ = new ViewZ();

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

    public void setActionBarHide() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }

    public void setActionBarFull() {
        /* WARNING: You have to put in onCreate (before setContentView) */
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (AndroidRuntimeException exception) {
            setLog(exception.getMessage());
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

    /* HERE: ExceptionZ --------------------------------------------------------------------------------*/

    public void setDefaultUncaughtException(Class activity) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionZ(activity));
    }

    private class ExceptionZ implements Thread.UncaughtExceptionHandler {

        Class activity;

        ExceptionZ(Class activity) {
            this.activity = activity;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            handleUncaughtException(e, activity);
        }
    }

    private void handleUncaughtException(Throwable e, Class activity) {
        setLog("ExceptionZ " + getRootException(e).getMessage());
        e.printStackTrace();

        Intent intent = new Intent(this, activity);
        intent.putExtra(IntentConstant.CONSTANT_INTENT_CRASH, true);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 100, pendingIntent);

        finish();
        System.exit(2);
    }

    public static Throwable getRootException(Throwable exception) {
        Throwable rootException = exception;
        while (rootException.getCause() != null) {
            rootException = rootException.getCause();
        }
        return rootException;
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
        startActivity(intentZ.intentMarket(getString(id)));
    }

    public void setActivityMarket(String id) {
        startActivity(intentZ.intentMarket(id));
    }

    public void setActivityWebsite(String website) {
        startActivity(intentZ.intentWebsite(website));
    }

    /* HERE: ViewZ -------------------------------------------------------------------------------*/

    public String getValue(EditText editText) {
        return viewZ.getValue(editText);
    }

    public boolean getValueBoolean(EditText editText) {
        return viewZ.getValueBoolean(editText);
    }

    public int getValueInt(EditText editText) {
        return viewZ.getValueInt(editText);
    }

    public void setViewEnabled(View view, boolean isEnabled) {
        viewZ.setViewEnabled(view, isEnabled);
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
