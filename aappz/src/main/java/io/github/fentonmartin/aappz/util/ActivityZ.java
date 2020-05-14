package io.github.fentonmartin.aappz.util;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import io.github.fentonmartin.aappz.R;
import io.github.fentonmartin.aappz.anim.BounceAnimation;
import io.github.fentonmartin.aappz.dialog.InputDialog;
import io.github.fentonmartin.aappz.dialog.LoadingDialog;
import io.github.fentonmartin.aappz.dialog.NormalDialog;

@SuppressWarnings({"unused"})
public class ActivityZ extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private InputDialog dialogInput;
    private LoadingDialog dialogLoading;
    private NormalDialog dialogNormal;

    private IntentZ intentZ;
    private LogZ logZ;
    private ToastZ toastZ;
    private ViewZ viewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Initializations */
        intentZ = new IntentZ();
        logZ = new LogZ();
        toastZ = new ToastZ();
        viewZ = new ViewZ();

        /* Initiate Fragment Transaction */
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        /* Initiate Loading Dialog */
        dialogInput = InputDialog.create();
        dialogInput.setCancelable(false);
        /* Initiate Loading Dialog */
        dialogLoading = LoadingDialog.create();
        dialogLoading.setCancelable(false);
        /* Initiate Normal Dialog */
        dialogNormal = NormalDialog.create();
        dialogNormal.setCancelable(false);

        setLog(this, "ActivityZ: onCreate");
    }

    @Override
    protected void onStart() {
        setLog(this, "ActivityZ: onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        setLog(this, "ActivityZ: onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        setLog(this, "ActivityZ: onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        setLog(this, "ActivityZ: onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        setLog(this, "ActivityZ: onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        setLog(this, "ActivityZ: onDestroy");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        setLog(this, "ActivityZ: onBackPressed");
        super.onBackPressed();
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

    /* HERE: ActionBarZ --------------------------------------------------------------------------*/

    /**
     * Set action bar for non main activity
     * <p>
     * Include home as up enabled and home button enabled
     */
    public void setActionBar() {
        setActionBar(false);
    }

    /**
     * Set action bar with main setter
     * <p>
     * Include home as up enabled and home button enabled
     *
     * @param isMain set activity is the main activity
     */
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

    /**
     * Set action bar hidden
     */
    public void setActionBarHide() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }

    /**
     * Set action bar hidden
     * <p>
     * WARNING: You have to put in onCreate (before setContentView)
     */
    public void setActionBarFull() {
        /* WARNING: You have to put in onCreate (before setContentView) */
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (AndroidRuntimeException exception) {
            setLog(exception.getMessage());
        }
    }

    /**
     * Set title on action bar
     *
     * @param title being set to be title
     */
    public void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    /**
     * Set subtitle on action bar
     *
     * @param subtitle being set to be title
     */
    public void setSubtitle(String subtitle) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(subtitle);
        }
    }

    /* HERE: ExceptionZ --------------------------------------------------------------------------------*/

    /**
     * Set default uncaught exception
     *
     * @param activity default activity after crashed
     */
    public void setDefaultUncaughtException(Class activity) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionZ(activity));
    }

    /**
     * Set default uncaught exception
     *
     * @param handler default handler after crashed
     */
    public void setDefaultUncaughtException(Thread.UncaughtExceptionHandler handler) {
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    /**
     * Set default uncaught exception
     *
     * @param throwable throwable after crashed
     * @param activity  default activity after crashed
     */
    public void setUncaughtExceptionHandler(Throwable throwable, Class activity) {
        setLog("ExceptionZ " + getRootException(throwable).getMessage());
        throwable.printStackTrace();

        Intent intent = new Intent(this, activity);
        intent.putExtra(CONSTANT_INTENT_CRASH, true);
        intent.putExtra(CONSTANT_INTENT_CRASH_LOG, getRootException(throwable).getMessage());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 100, pendingIntent);
        }
        finish();
        System.exit(2);
    }

    /**
     * Get the root exception
     *
     * @param exception exception after crashed
     */
    private static Throwable getRootException(Throwable exception) {
        Throwable rootException = exception;
        while (rootException.getCause() != null) {
            rootException = rootException.getCause();
        }
        return rootException;
    }

    /**
     * Default class for ExceptionZ
     */
    private class ExceptionZ implements Thread.UncaughtExceptionHandler {

        final Class activity;

        ExceptionZ(Class activity) {
            this.activity = activity;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            setUncaughtExceptionHandler(e, activity);
        }
    }

    /* HERE: LogZ --------------------------------------------------------------------------------*/

    /**
     * Set logger from activity
     *
     * @param log the message is being logged.
     */
    public void setLog(String log) {
        logZ.setLog(log);
    }

    /**
     * Set logger from selected activity
     *
     * @param activity the activity logger from
     * @param log      the message is being logged.
     */
    public void setLog(Activity activity, String log) {
        logZ.setLog(activity, log);
    }

    /* HERE: ToastZ ------------------------------------------------------------------------------*/

    /**
     * Set toast from id string resource
     *
     * @param id the id string resource
     */
    public void setToast(int id) {
        toastZ.setToast(getApplicationContext(), getString(id));
    }

    /**
     * Set toast from string message
     *
     * @param message the string message
     */
    public void setToast(String message) {
        toastZ.setToast(getApplicationContext(), message);
    }

    /**
     * Set toast from char sequence message
     *
     * @param message the char sequence message
     */
    public void setToast(CharSequence message) {
        toastZ.setToast(getApplicationContext(), message);
    }

    /* HERE: IntentZ -----------------------------------------------------------------------------*/

    /**
     * Set activity from current activity
     *
     * @param activity with no options specified
     */
    public void setActivity(Class activity) {
        startActivity(intentZ.intent(getApplicationContext(), activity));
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param bool     the boolean extra
     */
    public void setActivity(Class activity, boolean bool) {
        startActivity(intentZ.intent(getApplicationContext(), activity, CONSTANT_INTENT, bool));
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param text     the string extra
     */
    public void setActivity(Class activity, String text) {
        startActivity(intentZ.intent(getApplicationContext(), activity, CONSTANT_INTENT, text));
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param text1    the 1st string extra
     * @param text2    the 2nd string extra
     */
    public void setActivity(Class activity, String text1, String text2) {
        Intent intent = new Intent(getApplicationContext(), activity);
        intent.putExtra(CONSTANT_INTENT, text1);
        intent.putExtra(CONSTANT_INTENT_2, text2);
        startActivity(intent);
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param text1    the 1st string extra
     * @param text2    the 2nd string extra
     * @param text3    the 3rd string extra
     */
    public void setActivity(Class activity, String text1, String text2, String text3) {
        Intent intent = new Intent(getApplicationContext(), activity);
        intent.putExtra(CONSTANT_INTENT, text1);
        intent.putExtra(CONSTANT_INTENT_2, text2);
        intent.putExtra(CONSTANT_INTENT_3, text3);
        startActivity(intent);
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param text1    the 1st string extra
     * @param text2    the 2nd string extra
     * @param text3    the 3rd string extra
     * @param text4    the 4th string extra
     */
    public void setActivity(Class activity, String text1, String text2, String text3, String text4) {
        Intent intent = new Intent(getApplicationContext(), activity);
        intent.putExtra(CONSTANT_INTENT, text1);
        intent.putExtra(CONSTANT_INTENT_2, text2);
        intent.putExtra(CONSTANT_INTENT_3, text3);
        intent.putExtra(CONSTANT_INTENT_4, text4);
        startActivity(intent);
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param text1    the 1st string extra
     * @param text2    the 2nd string extra
     * @param text3    the 3rd string extra
     * @param text4    the 4th string extra
     * @param text5    the 5th string extra
     */
    public void setActivity(Class activity, String text1, String text2, String text3, String text4, String text5) {
        Intent intent = new Intent(getApplicationContext(), activity);
        intent.putExtra(CONSTANT_INTENT, text1);
        intent.putExtra(CONSTANT_INTENT_2, text2);
        intent.putExtra(CONSTANT_INTENT_3, text3);
        intent.putExtra(CONSTANT_INTENT_4, text4);
        intent.putExtra(CONSTANT_INTENT_5, text5);
        startActivity(intent);
    }

    /**
     * Set activity from current activity with extra
     *
     * @param activity the targeted activity
     * @param bundle   the bundle extra
     */
    public void setActivity(Class activity, Bundle bundle) {
        startActivity(intentZ.intent(getApplicationContext(), activity, CONSTANT_INTENT, bundle));
    }

    /**
     * Set activity from current activity with flag
     *
     * @param activity the targeted activity
     * @param flag     the flag of activity
     */
    public void setActivityFlag(Class activity, int flag) {
        startActivity(intentZ.intent(getApplicationContext(), activity, flag));
    }

    /**
     * Set activity from current activity without activity stack history
     *
     * @param activity the targeted activity
     */
    public void setActivityClear(Class activity) {
        startActivity(intentZ.intentClear(getApplicationContext(), activity));
    }

    /**
     * Set email activity from current activity
     *
     * @param email   the email destination
     * @param subject the email subject
     */
    public void setActivityEmail(String email, String subject) {
        startActivity(intentZ.intentEmail(email, subject));
    }

    /**
     * Set store activity from current activity
     *
     * @param id the id string resource
     */
    public void setActivityMarket(int id) {
        startActivity(intentZ.intentMarket(getString(id)));
    }

    /**
     * Set store activity from current activity
     *
     * @param id the string store id
     */
    public void setActivityMarket(String id) {
        startActivity(intentZ.intentMarket(id));
    }

    /**
     * Set share intent from current activity
     *
     * @param subject the subject of chooser
     * @param text    the text of chooser
     */
    public void setActivityShare(String subject, String text) {
        startActivity(Intent.createChooser(intentZ.intentSend(subject, text), subject));
    }

    /**
     * Set share intent from current activity
     *
     * @param subject the subject of chooser
     * @param text    the text of chooser
     * @param chooser the chooser text string
     */
    public void setActivityShare(String subject, String text, String chooser) {
        startActivity(Intent.createChooser(intentZ.intentSend(subject, text), chooser));
    }

    /**
     * Set url intent from current activity
     *
     * @param website the url string
     */
    public void setActivityWebsite(String website) {
        startActivity(intentZ.intentWebsite(website));
    }

    /**
     * Get the 1st string from intent
     *
     * @param intent the intent with setActivity
     */
    public String getIntentFrom(Intent intent) {
        if (intent.getStringExtra(CONSTANT_INTENT) != null)
            return intent.getStringExtra(CONSTANT_INTENT);
        else return "";
    }

    /**
     * Get the 2nd string from intent
     *
     * @param intent the intent with setActivity
     */
    public String getIntent2From(Intent intent) {
        if (intent.getStringExtra(CONSTANT_INTENT_2) != null)
            return intent.getStringExtra(CONSTANT_INTENT_2);
        else return "";
    }

    /**
     * Get the 3rd string from intent
     *
     * @param intent the intent with setActivity
     */
    public String getIntent3From(Intent intent) {
        if (intent.getStringExtra(CONSTANT_INTENT_3) != null)
            return intent.getStringExtra(CONSTANT_INTENT_3);
        else return "";
    }

    /**
     * Get the 4th string from intent
     *
     * @param intent the intent with setActivity
     */
    public String getIntent4From(Intent intent) {
        if (intent.getStringExtra(CONSTANT_INTENT_4) != null)
            return intent.getStringExtra(CONSTANT_INTENT_4);
        else return "";
    }

    /**
     * Get the 5th string from intent
     *
     * @param intent the intent with setActivity
     */
    public String getIntent5From(Intent intent) {
        if (intent.getStringExtra(CONSTANT_INTENT_5) != null)
            return intent.getStringExtra(CONSTANT_INTENT_5);
        else return "";
    }

    /* HERE: ViewZ -------------------------------------------------------------------------------*/

    /**
     * Get string value from EditText
     *
     * @param editText the current view
     * @return the result
     */
    public String getValue(EditText editText) {
        return viewZ.getValue(editText);
    }

    /**
     * Get boolean value from EditText
     *
     * @param editText the current view
     * @return the result
     */
    public boolean getValueBoolean(EditText editText) {
        return viewZ.getValueBoolean(editText);
    }

    /**
     * Get integer value from EditText
     *
     * @param editText the current view
     * @return the result
     */
    public int getValueInt(EditText editText) {
        return viewZ.getValueInt(editText);
    }

    /**
     * Get long value from EditText
     *
     * @param editText the current view
     * @return the result
     */
    public long getValueLong(EditText editText) {
        return viewZ.getValueLong(editText);
    }

    /**
     * Get number only value from EditText
     *
     * @param editText the current view
     * @return the result
     */
    public String getValueNumber(EditText editText) {
        return viewZ.getValueNumber(editText);
    }

    /**
     * Set current view enabled
     *
     * @param view      the current focused view
     * @param isEnabled the status of enabled view
     */
    public void setViewEnabled(View view, boolean isEnabled) {
        viewZ.setViewEnabled(view, isEnabled);
    }

    /**
     * Set current view bounced
     *
     * @param view the current focused view
     */
    public void setViewBounce(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        BounceAnimation interpolator = new BounceAnimation(0.3, 20);
        animation.setInterpolator(interpolator);
        view.startAnimation(animation);
    }

    /**
     * Dismiss all dialog types
     */
    public void setViewDialogDismiss() {
        try {
            if (fragmentTransaction != null) {
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogInput).commit();
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogNormal).commit();
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogLoading).commit();
            }
            dialogInput.dismiss();
            dialogNormal.dismiss();
            dialogLoading.dismiss();
        } catch (IllegalStateException ignored) {
        }
    }

    /**
     * Set loading dialog
     *
     * @param isShow set loading dialog
     */
    public void setViewLoadingDialog(boolean isShow) {
        setViewLoadingDialog(isShow, "");
    }

    /**
     * Set loading dialog
     *
     * @param isShow set loading dialog
     * @param title  set title dialog
     */
    public void setViewLoadingDialog(boolean isShow, String title) {
        try {
            if (isShow) {
                if (fragmentTransaction != null)
                    getSupportFragmentManager().beginTransaction()
                            .remove(dialogLoading).commit();
                if (title.isEmpty())
                    dialogLoading = LoadingDialog.create();
                else
                    dialogLoading = LoadingDialog.create(title);
                dialogLoading.setCancelable(false);
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(dialogLoading, "DIALOG_LOADING");
                fragmentTransaction.commitAllowingStateLoss();
            } else {
                if (fragmentTransaction != null)
                    getSupportFragmentManager().beginTransaction()
                            .remove(dialogLoading).commit();
                dialogLoading.dismiss();
            }
        } catch (NullPointerException | IllegalStateException ignored) {
        }
    }

    /**
     * Set normal dialog
     *
     * @param message set dialog message
     */
    public void setViewNormalDialog(String message) {
        setViewNormalDialog(null, message);
    }

    /**
     * Set normal dialog
     *
     * @param message set dialog message
     */
    public void setViewNormalDialog(String message, NormalDialog.Callback callback) {
        setViewNormalDialog(null, message, callback);
    }

    /**
     * Set normal dialog
     *
     * @param title   set dialog title
     * @param message set dialog message
     */
    public void setViewNormalDialog(String title, String message) {
        setViewNormalDialog(title, message, null, null);
    }

    /**
     * Set normal dialog
     *
     * @param title   set dialog title
     * @param message set dialog message
     */
    public void setViewNormalDialog(String title, String message, NormalDialog.Callback callback) {
        setViewNormalDialog(title, message, null, callback);
    }

    /**
     * Set normal dialog
     *
     * @param title   set dialog title
     * @param message set dialog message
     * @param button  set dialog button
     */
    public void setViewNormalDialog(String title, String message, String button) {
        setViewNormalDialog(title, message, button, null);
    }

    /**
     * Set normal dialog
     *
     * @param title    set dialog title
     * @param message  set dialog message
     * @param button   set dialog button
     * @param callback set dialog callback
     */
    public void setViewNormalDialog(String title, String message, String button, NormalDialog.Callback callback) {
        try {
            if (fragmentTransaction != null)
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogNormal).commit();
            dialogNormal = NormalDialog.create(title, message, button);
            dialogNormal.setCancelable(false);
            dialogNormal.setDialogCallback(callback);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(dialogNormal, "DIALOG_NORMAL");
            fragmentTransaction.commitAllowingStateLoss();
        } catch (NullPointerException | IllegalStateException ignored) {
        }
    }

    /**
     * Set normal dialog
     *
     * @param title    set dialog title
     * @param message  set dialog message
     * @param button1   set 1st dialog button
     * @param button2   set 2nd dialog button
     * @param callback set dialog callback
     */
    public void setViewNormalDialog(String title, String message, String button1, String button2, NormalDialog.CallbackTwo callback) {
        try {
            if (fragmentTransaction != null)
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogNormal).commit();
            dialogNormal = NormalDialog.create(title, message, button1, button2, null);
            dialogNormal.setCancelable(false);
            dialogNormal.setDialogTwoCallback(callback);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(dialogNormal, "DIALOG_NORMAL");
            fragmentTransaction.commitAllowingStateLoss();
        } catch (NullPointerException | IllegalStateException ignored) {
        }
    }

    /**
     * Set normal dialog
     *
     * @param title    set dialog title
     * @param message  set dialog message
     * @param button1   set 1st dialog button
     * @param button2   set 2nd dialog button
     * @param button3   set 3rd dialog button
     * @param callback set dialog callback
     */
    public void setViewNormalDialog(String title, String message, String button1, String button2, String button3, NormalDialog.CallbackThree callback) {
        try {
            if (fragmentTransaction != null)
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogNormal).commit();
            dialogNormal = NormalDialog.create(title, message, button1, button2, button3);
            dialogNormal.setCancelable(false);
            dialogNormal.setDialogThreeCallback(callback);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(dialogNormal, "DIALOG_NORMAL");
            fragmentTransaction.commitAllowingStateLoss();
        } catch (NullPointerException | IllegalStateException ignored) {
        }
    }

    /**
     * Set input dialog
     *
     * @param message set dialog message
     */
    public void setViewInputDialog(String message, InputDialog.Callback callback) {
        setViewInputDialog(null, message, callback);
    }

    /**
     * Set input dialog
     *
     * @param title   set dialog title
     * @param message set dialog message
     */
    public void setViewInputDialog(String title, String message, InputDialog.Callback callback) {
        setViewInputDialog(title, message, null, callback);
    }

    /**
     * Set input dialog
     *
     * @param title   set dialog title
     * @param message set dialog message
     * @param button  set dialog button
     */
    public void setViewInputDialog(String title, String message, String button, InputDialog.Callback callback) {
        try {
            if (fragmentTransaction != null)
                getSupportFragmentManager().beginTransaction()
                        .remove(dialogInput).commit();
            dialogInput = InputDialog.create(title, message, button);
            dialogInput.setCancelable(false);
            dialogInput.setDialogCallback(callback);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(dialogInput, "DIALOG_INPUT");
            fragmentTransaction.commitAllowingStateLoss();
        } catch (NullPointerException | IllegalStateException ignored) {
        }
    }

    /**
     * Hide current appeared keyboard
     *
     * @param view the current focused view
     */
    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* Intent Constants --------------------------------------------------------------------------*/

    public static final String CONSTANT_INTENT = "CONSTANT_INTENT";
    public static final String CONSTANT_INTENT_2 = "CONSTANT_INTENT_2";
    public static final String CONSTANT_INTENT_3 = "CONSTANT_INTENT_3";
    public static final String CONSTANT_INTENT_4 = "CONSTANT_INTENT_4";
    public static final String CONSTANT_INTENT_5 = "CONSTANT_INTENT_5";
    public static final String CONSTANT_INTENT_CRASH = "CONSTANT_INTENT_CRASH";
    public static final String CONSTANT_INTENT_CRASH_LOG = "CONSTANT_INTENT_CRASH_LOG";
}
