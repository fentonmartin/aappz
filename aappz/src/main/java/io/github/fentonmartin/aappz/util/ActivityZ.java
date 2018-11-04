package io.github.fentonmartin.aappz.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivityZ extends AppCompatActivity {

    LogZ logZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logZ = new LogZ();
        setLog(this,"onCreate | ACTIVITY");
    }

    @Override
    protected void onStart() {
        setLog(this,"onStart | ACTIVITY");
        super.onStart();
    }

    @Override
    protected void onResume() {
        setLog(this,"onResume | ACTIVITY");
        super.onResume();
    }

    @Override
    protected void onPause() {
        setLog(this,"onPause | ACTIVITY");
        super.onPause();
    }

    @Override
    protected void onStop() {
        setLog(this,"onStop | ACTIVITY");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        setLog(this,"onRestart | ACTIVITY");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        setLog(this,"onDestroy | ACTIVITY");
        super.onDestroy();
    }

    public void setLog(String log) {
        logZ.setLog(log);
    }

    public void setLog(Activity activity, String log) {
        logZ.setLog(activity, log);
    }
}
