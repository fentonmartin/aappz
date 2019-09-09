package io.github.fentonmartin.aappz.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

class IntentZ {

    Intent intent(Context context, Class activity) {
        return new Intent(context, activity);
    }

    Intent intent(Context context, Class activity, String extra, boolean bool) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(extra, bool);
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

    Intent intent(Context context, Class activity, int flag) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(flag);
        return intent;
    }

    Intent intentClear(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    Intent intentEmail(String email, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "");
        return intent;
    }

    Intent intentMarket(String id) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.setData(Uri.parse("market://details?id=" + id));
        } catch (android.content.ActivityNotFoundException e) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + id));
        }
        return intent;
    }

    Intent intentSend(String subject, String text) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        return intent;
    }

    Intent intentWebsite(String website) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(website));
        return intent;
    }
}
