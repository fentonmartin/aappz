package io.github.fentonmartin.sample;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.fentonmartin.aappz.AappZ;

public class PermissionActivity extends AappZ implements View.OnClickListener {

    private static final String[] ALL_PERMISSIONS = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private Button mStorageButton, mCameraButton, mSmsButton, mAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initializeUI();
        setListener();
    }

    private void setListener() {
        mStorageButton.setOnClickListener(this);
        mCameraButton.setOnClickListener(this);
        mSmsButton.setOnClickListener(this);
        mAllButton.setOnClickListener(this);
    }

    private void initializeUI() {
        mStorageButton = findViewById(R.id.storage_button);
        mCameraButton = findViewById(R.id.camera_button);
        mSmsButton = findViewById(R.id.location_button);
        mAllButton = findViewById(R.id.all_button);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(mCameraButton)) {
            if (permissionZ.hasPermission(Manifest.permission.CAMERA)) {
                Toast.makeText(PermissionActivity.this, Manifest.permission.CAMERA + " already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissionZ.request(Manifest.permission.CAMERA);
            }
        } else if (v.equals(mStorageButton)) {
            if (permissionZ.hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(PermissionActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE + " already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissionZ.request(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        } else if (v.equals(mSmsButton)) {
            if (permissionZ.hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION) && permissionZ.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(PermissionActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION + " already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissionZ.request(Manifest.permission.READ_SMS);
            }
        } else if (v.equals(mAllButton)) {
            if (permissionZ.hasPermission(ALL_PERMISSIONS)) {
                Toast.makeText(PermissionActivity.this, "All permissionZ already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissionZ.request(ALL_PERMISSIONS);
            }
        }
    }
}
