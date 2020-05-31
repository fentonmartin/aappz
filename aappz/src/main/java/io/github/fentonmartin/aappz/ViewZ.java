package io.github.fentonmartin.aappz;

import android.view.View;
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

    long getValueLong(EditText text) {
        return Long.parseLong(getValue(text));
    }

    String getValueNumber(EditText text) {
        return TextZ.getNumber(getValue(text));
    }

    void setViewEnabled(View view, boolean isEnabled) {
        if (isEnabled) {
            view.setAlpha(1);
            view.setEnabled(true);
        } else {
            view.setAlpha((float) 0.3);
            view.setEnabled(false);
        }
    }

    void setViewEnabled(View view, float alpha, boolean isEnabled) {
        view.setAlpha(alpha);
        view.setEnabled(isEnabled);
    }
}
