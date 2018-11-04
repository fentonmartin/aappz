package io.github.fentonmartin.aappz.util;

import android.content.Context;
import android.content.Intent;

class IntentZ {
    Intent intent(Context context, Class activity) {
        return new Intent(context, activity);
    }

    Intent intent(Context context, Class activity, int flag) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(flag);
        return intent;
    }
}
