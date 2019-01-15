package io.github.fentonmartin.sample;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import io.github.fentonmartin.aappz.implementation.OnPermissionListener;
import io.github.fentonmartin.aappz.util.PermissionZ;

public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String[] ALL_PERMISSIONS = {
            Manifest.permission.READ_SMS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    private Button mStorageButton, mCameraButton, mSmsButton, mAllButton;
    private PermissionZ permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        permissions = new PermissionZ.Builder()
                .with(this)
                .listener(new OnPermissionListener() {
                    @Override
                    public void onAllPermissionsGranted(@NonNull List<String> permissions) {
                        Toast.makeText(PermissionActivity.this, "All permissions granted", Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onPermissionsGranted(@NonNull List<String> permissions) {
                        Toast.makeText(PermissionActivity.this, "permissions granted", Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onPermissionsDenied(@NonNull List<String> permissions) {
                        Toast.makeText(PermissionActivity.this, "permissions denied", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .build();
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
        mSmsButton = findViewById(R.id.sms_button);
        mAllButton = findViewById(R.id.all_button);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.permissions.onRequestPermissionsResult(permissions, grantResults);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(mCameraButton)) {
            if (permissions.hasPermission(Manifest.permission.CAMERA)) {
                Toast.makeText(PermissionActivity.this, Manifest.permission.CAMERA + " already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissions.request(Manifest.permission.CAMERA);
            }
        } else if (v.equals(mStorageButton)) {
            if (permissions.hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(PermissionActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE + " already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        } else if (v.equals(mSmsButton)) {
            if (permissions.hasPermission(Manifest.permission.READ_SMS)) {
                Toast.makeText(PermissionActivity.this, Manifest.permission.READ_SMS + " already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissions.request(Manifest.permission.READ_SMS);
            }
        } else if (v.equals(mAllButton)) {
            if (permissions.hasPermission(ALL_PERMISSIONS)) {
                Toast.makeText(PermissionActivity.this, "all permissions already granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                permissions.request(ALL_PERMISSIONS);
            }
        }
    }
}
