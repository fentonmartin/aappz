package io.github.fentonmartin.aappz;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.List;

import io.github.fentonmartin.aappz.implementation.OnPermissionListener;
import io.github.fentonmartin.aappz.util.ActivityZ;
import io.github.fentonmartin.aappz.util.PermissionZ;
import io.github.fentonmartin.aappz.util.PrefZ;

public class AappZ extends ActivityZ {

    public PermissionZ permissionZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* PrefZ Initialization */
        new PrefZ.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        /* PermissionZ Initialization */
        permissionZ = new PermissionZ
                .Builder()
                .with(this)
                .listener(new OnPermissionListener() {
                    @Override
                    public void onAllPermissionsGranted(@NonNull List<String> permissions) {
                        setLog("PermissionZ: All permissions granted: " + permissions.toString());
                    }

                    @Override
                    public void onPermissionsGranted(@NonNull List<String> permissions) {
                        setLog("PermissionZ: Permissions is granted: " + permissions.toString());
                    }

                    @Override
                    public void onPermissionsDenied(@NonNull List<String> permissions) {
                        setLog("PermissionZ: Permissions is denied: " + permissions.toString());
                    }
                })
                .build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.permissionZ.onRequestPermissionsResult(permissions, grantResults);
    }
}
