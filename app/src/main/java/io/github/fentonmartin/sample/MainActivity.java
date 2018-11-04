package io.github.fentonmartin.sample;

import android.os.Bundle;
import android.widget.Button;

import io.github.fentonmartin.aappz.AappZ;

public class MainActivity extends AappZ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        setViewEnabled(button, false);
    }
}
