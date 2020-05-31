package io.github.fentonmartin.sample;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.fentonmartin.aappz.AappZ;
import io.github.fentonmartin.aappz.permission.PermissionHandler;
import io.github.fentonmartin.aappz.util.PermissionZ;

public class PermissionV2Activity extends AappZ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_v2);
    }

    public void requestPhone(View view) {
        PermissionZ.check(this, Manifest.permission.CALL_PHONE, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                Toast.makeText(PermissionV2Activity.this, "Phone granted.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void requestCameraAndStorage(View view) {
        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        PermissionZ.check(this, permissions, null, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                Toast.makeText(PermissionV2Activity.this, "Camera & Storage granted.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void requestLocation(View view) {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
        String rationale = "Please provide location permission so that you can ...";
        PermissionZ.Options options = new PermissionZ.Options()
                .setRationaleDialogTitle("Info")
                .setSettingsDialogTitle("Warning");

        PermissionZ.check(this, permissions, rationale, options, new PermissionHandler() {
            @Override
            public void onGranted() {
                Toast.makeText(PermissionV2Activity.this, "Location granted.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDenied(Context context, ArrayList<String> deniedPermissionZ) {
                Toast.makeText(PermissionV2Activity.this, "Location denied.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openSettings(View view) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
    }
}
