package io.github.fentonmartin.aappz.util;

import android.widget.EditText;

class ViewZ {
    String getValue(EditText text) {
        return String.valueOf(text.getText());
    }
    boolean getValueBoolean(EditText text) {
        return Boolean.parseBoolean(getValue(text));
    }
    int getValueInt(EditText text) {
        return Integer.parseInt(getValue(text));
    }
}
