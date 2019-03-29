package io.github.fentonmartin.aappz.implementation;

import android.support.annotation.NonNull;

import java.util.List;

@Deprecated
public interface OnPermissionListener {

    void onAllPermissionsGranted(@NonNull List<String> permissions);

    void onPermissionsGranted(@NonNull List<String> permissions);

    void onPermissionsDenied(@NonNull List<String> permissions);
}
