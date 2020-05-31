package io.github.fentonmartin.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.fentonmartin.aappz.AappZ;
import io.github.fentonmartin.aappz.DateZ;
import io.github.fentonmartin.aappz.EncryptZ;
import io.github.fentonmartin.aappz.PrefZ;

public class MainActivity extends AappZ {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        setViewEnabled(button, false);

        TextView textView = findViewById(R.id.text);
        textView.setText(
                DateZ.getTimestampString() + "\n" +
                        DateZ.getTimestamp(910198934000L) + "\n" +
                        DateZ.getTimestamp("910198934000"));

        setDefaultUncaughtException(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // Send StackTrace of the errors

//                setUncaughtExceptionHandler(e, MainActivity.class);
            }
        });

        PrefZ.setString("test", "Hello! world ABCxyz");
        String a = "Hello! world ABCxyz";
        String b = "LP882A5&2e8m53~S";
        String c = "fxbUuMuMp5bPqxivp5C2uMRtqxz9vSH6";
        String encrypted, decrypted;

        encrypted = EncryptZ.encryptTo(a, EncryptZ.ENCRYPT_92);
        setLog("EncryptZ 92 EncryptTo " + encrypted);

        decrypted = EncryptZ.decryptTo(encrypted, EncryptZ.ENCRYPT_92);
        setLog("EncryptZ 92 DecryptTo " + decrypted);

        encrypted = EncryptZ.encryptTo(a, EncryptZ.ENCRYPT_184);
        setLog("EncryptZ 184 EncryptTo " + encrypted);

        decrypted = EncryptZ.decryptTo(encrypted, EncryptZ.ENCRYPT_184);
        setLog("EncryptZ 184 DecryptTo " + decrypted);

        setToast(decrypted);
        textView.setText(decrypted);

    }

    public void onBounceClick(View view) {
        setLog("onBounceClick: onClicked");
        setViewBounce(view);
    }

    public void onLoadingClick(View view) {
        setLog("onLoadingClick: onClicked");
    }
}
