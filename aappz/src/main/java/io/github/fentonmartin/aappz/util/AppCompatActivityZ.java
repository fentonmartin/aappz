package io.github.fentonmartin.aappz.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AppCompatActivityZ extends AppCompatActivity {

    LogZ logZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logZ = new LogZ();
        logZ.setLog(this,"onCreate | ACTIVITY");
    }

    @Override
    protected void onStart() {
        logZ.setLog(this,"onStart | ACTIVITY");
        super.onStart();
    }

    @Override
    protected void onResume() {
        logZ.setLog(this,"onResume | ACTIVITY");
        super.onResume();
    }

    @Override
    protected void onPause() {
        logZ.setLog(this,"onPause | ACTIVITY");
        super.onPause();
    }

    @Override
    protected void onStop() {
        logZ.setLog(this,"onStop | ACTIVITY");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        logZ.setLog(this,"onRestart | ACTIVITY");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        logZ.setLog(this,"onDestroy | ACTIVITY");
        super.onDestroy();
    }
}
