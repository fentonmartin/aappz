package io.github.fentonmartin.aappz.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

class IntentZ {
    Intent intent(Context context, Class activity) {
        return new Intent(context, activity);
    }
    Intent intent(Context context, Class activity, int flag) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(flag);
        return intent;
    }
    Intent intent(Context context, Class activity, String extra, boolean bool) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(extra, bool);
        return intent;
    }
    Intent intent(Context context, Class activity, String extra, int number) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(extra, number);
        return intent;
    }
    Intent intent(Context context, Class activity, String extra, String text) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(extra, text);
        return intent;
    }
    Intent intent(Context context, Class activity, String extra, Bundle bundle) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(extra, bundle);
        return intent;
    }
    Intent intentClear(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
    Intent intentMarket(int id) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.setData(Uri.parse("market://details?id=" + id));
        } catch (android.content.ActivityNotFoundException e) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + id));
        }
        return intent;
    }
}
