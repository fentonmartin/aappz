package io.github.fentonmartin.aappz.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.fentonmartin.aappz.implementation.OnPermissionListener;

@Deprecated
public class PermissionZ {

    private final Activity activity;
    private final OnPermissionListener onPermissionListener;

    @Deprecated
    private PermissionZ(Builder builder) {
        this.activity = builder.activity;
        this.onPermissionListener = builder.listener;
    }

    @Deprecated
    public void onRequestPermissionsResult(String[] permissions, int[] grantResults) {
        List<String> grantedPermissions = new ArrayList<>();
        List<String> deniedPermissions = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permissions[i]);
            } else {
                grantedPermissions.add(permissions[i]);
            }
        }
        if (grantedPermissions.size() == permissions.length) {
            onPermissionListener.onAllPermissionsGranted(Arrays.asList(permissions));
        } else {
            onPermissionListener.onPermissionsGranted(grantedPermissions);
            onPermissionListener.onPermissionsDenied(deniedPermissions);
        }
    }

    @Deprecated
    public void request(String... permissions) {
        List<String> permissionNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionNeeded.add(permission);
            }
        }
        if (permissionNeeded.size() > 0) {
            ActivityCompat.requestPermissions(activity, permissionNeeded.toArray(new String[0]), 10002);
        }
    }

    @Deprecated
    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static class Builder {

        private Activity activity;
        private OnPermissionListener listener;

        @Deprecated
        public Builder with(@NonNull Activity activity) {
            this.activity = activity;
            return this;
        }

        @Deprecated
        public Builder listener(@NonNull OnPermissionListener listener) {
            this.listener = listener;
            return this;
        }

        @Deprecated
        public PermissionZ build() {
            return new PermissionZ(this);
        }
    }
}
