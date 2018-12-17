package io.github.fentonmartin.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import io.github.fentonmartin.aappz.AappZ;
import io.github.fentonmartin.aappz.constant.DateConstant;
import io.github.fentonmartin.aappz.constant.EncryptConstant;
import io.github.fentonmartin.aappz.util.DateZ;
import io.github.fentonmartin.aappz.util.EncryptZ;
import io.github.fentonmartin.aappz.util.PrefZ;

public class MainActivity extends AappZ {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        setViewEnabled(button, false);

        TextView textView = findViewById(R.id.text);
        textView.setText(DateZ.getDatetime() + "\n" +
                DateZ.getDatetime(DateConstant.DATE_FULL_REVERSE) + "\n" +
                DateZ.getDatetime(DateConstant.DATE_DAY) + "\n" +
                DateZ.getDatetime(DateConstant.DATE_DAY_REVERSE) + "\n" +
                DateZ.getDatetime(DateConstant.DATE_DAY_FULL) + "\n" +
                DateZ.getDatetime(DateConstant.DATE_DAY_FULL_REVERSE) + "\n" +
                DateZ.getDatetime(DateConstant.TIME) + "\n" +
                DateZ.getDatetime(DateConstant.TIME_FULL) + "\n" +
                DateZ.getDatetime(DateConstant.TIME_12) + "\n" +
                DateZ.getDatetime(DateConstant.TIME_12_FULL) + "\n" +
                DateZ.getTimestampString() + "\n" +
                DateZ.getTimestampTime(910198934000L) + "\n" +
                DateZ.getTimestampTime("910198934000") + "\n" +
                DateZ.getDatetimeSimple());

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

        encrypted = EncryptZ.encryptTo(a, EncryptConstant.ENCRYPT_92);
        setLog("EncryptZ 92 EncryptTo " + encrypted);

        decrypted = EncryptZ.decryptTo(encrypted, EncryptConstant.ENCRYPT_92);
        setLog("EncryptZ 92 DecryptTo " + decrypted);

        encrypted = EncryptZ.encryptTo(a, EncryptConstant.ENCRYPT_184);
        setLog("EncryptZ 184 EncryptTo " + encrypted);

        decrypted = EncryptZ.decryptTo(encrypted, EncryptConstant.ENCRYPT_184);
        setLog("EncryptZ 184 DecryptTo " + decrypted);

        setToast(decrypted);
        textView.setText(decrypted);

    }
}
