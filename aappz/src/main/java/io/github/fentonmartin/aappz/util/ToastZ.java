package io.github.fentonmartin.aappz.util;

import android.content.Context;
import android.widget.Toast;

class ToastZ {

    void setToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    void setToast(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
