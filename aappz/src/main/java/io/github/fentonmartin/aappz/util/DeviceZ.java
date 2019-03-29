package io.github.fentonmartin.aappz.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.UUID;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * DeviceZ
 * <p>
 * To identify a particular installation by using UUID solution. If you want absolutely identify
 * device physically, use the ANDROID_ID (It's not 100% reliable, but better than other solutions).
 */
@SuppressWarnings("unused")
public class DeviceZ {

    /**
     * Get Android ID from device
     * <p>
     * Sometimes be null, can change upon factory reset. This value can be altered on a rooted phone.
     *
     * @param context the application context
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    private static String uniqueID = null;

    /**
     * Get UUID from device
     * <p>
     * Identify a particular installation (not a physical device). Method generates an unique
     * identifier for a specific installation. You have just to store that value and your
     * user will be identified at the next launch of your application.
     */
    public static String getUUID() {
        if (uniqueID == null) {
            PrefZ.setString("UUID", null);
            if (uniqueID == null) {
                uniqueID = UUID.randomUUID().toString();
                PrefZ.setString("UUID", uniqueID);
            }
        }
        return uniqueID;
    }

    /**
     * Get IMEI Address from device
     * <p>
     * Identify GSM, WCDMA mobile phones as well as some satellite phones. This solution is
     * limited to smart-phones because some tablets don’t have telephony services.
     * One advantage is that the value survives to factory resets on devices.
     * <p>
     * WARNING: 'android.permission.READ_PHONE_STATE' permission needed
     *
     * @param context the application context
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getIMEI(Context context) {
        TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        return TelephonyMgr.getDeviceId();
    }

    /**
     * Get MAC Address from device
     * <p>
     * Not all of the device have Wi-Fi connection. Even if the user have a Wi-Fi connection,
     * it must be turned on to retrieve the data. Otherwise, the call not report the MAC Address.
     * <p>
     * WARNING: 'android.permission.ACCESS_WIFI_STATE' permission needed
     *
     * @param context the application context
     */
    @SuppressLint("HardwareIds")
    public static String getMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getMacAddress();
    }

    /**
     * Get Pseudo-Unique ID from device
     * <p>
     * It read details like ROM Version, Manufacturer name, CPU type, and other hardware details.
     * This is possible get two devices with the same ID, based on the same hardware and rom image.
     * No special permission are required, making this approach very convenient.
     */
    public static String getPseudoUniqueID() {
        return "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
                Build.USER.length() % 10;
    }
}
