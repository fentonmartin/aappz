# AappZ | A to Z Application Functions in One Library

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub issues](https://img.shields.io/github/issues/fentonmartin/aappz.svg)](https://github.com/fentonmartin/aappz/issues)
[![Size](https://img.shields.io/github/size/webcaetano/craft/build/phaser-craft.min.js.svg)](https://github.com/fentonmartin/aappz/)
[![Download](https://api.bintray.com/packages/fentonmartin/maven/AappZ/images/download.svg)](https://bintray.com/fentonmartin/maven/AappZ/_latestVersion)

<a href="https://play.google.com/store/apps/dev?id=7539335505101133203">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

Description
-----
AappZ library is an A-Z all in one library for android application.

Content
-----
AappZ library offers convenient tools for android application:
* ActionBarZ: Some functions for customize ActionBar
* ActivityZ: Activity class extends AppCompatActivity
* DateZ: Date class for datetime and timestamp
* DayZ: Get current day state with custom 24 hours
* DelayZ: Create post delayed handler easily
* DeviceZ: Get identify installation/device ids
* DialogZ: Show dialog loading easily
* ExceptionZ: Some functions for handle exceptions
* EncryptZ: Simple customizable encryption and decryption
* FirebaseZ: Firebase tools for your development
* GoogleAdsZ: Google Ads tools for your application
* IntentZ: Intent collections for any usage
* LogZ: Just log for debugging purpose
* NumberZ: Number converter and formatting tools
* PermissionZ: Some new runtime permissions functions
* PrefZ: Some functions for SharedPreferences
* TextZ: Text validation and formatting tools
* ToastZ: Just toast for create any messages
* ViewZ: Some functions for view and layout

**Bonus library:**
* SDP: Library of a scalable size unit (for non text views)
* SSP: Library of a scalable size unit (for text views)

Installation
-----
If you already have jcenter() in your build.gradle. So, just add a dependency:
```
implementation 'io.github.fentonmartin:aappz:1.3.0'
```

Usage
-----
Extend the AappZ in your base activity (recommended):
```
public class MainActivity extends AappZ {...}
```

Or you could just extend ActivityZ instead:
```
public class MainActivity extends ActivityZ{...}
```

And that's it, now you can call any function directly:
```
setToast("Hello world!");
```

If want to use SDP or SSP, just call it from xml:
```
android:layout_height="@dimen/_120sdp"
android:textSize="@dimen/_16ssp"
```

If want to use PermissionZ, add this to your AndroidManifest.xml:
```
<activity android:name="io.github.fentonmartin.aappz.permission.PermissionActivity" />
Note: Remember to pass context using 'MainActivity.this', DO NOT pass 'getApplicationContext()'
```

-----
RecyclerView Click and Snap Helper:
```
RecyclerItemClickListener (addOnItemTouchListener)
RecyclerViewSnapHelper (snapping any child view)
```

-----
If want to use FirebaseZ and GoogleAdsZ functions, just configure:
```
Firebase SDK: https://firebase.google.com/docs/android/setup
```

And copy FirebaseZ and GoogleAdsZ functions to your project:
```
- FirebaseZ  (manual configuration)
- GoogleAdsZ (manual configuration)
```

If you only want to use basic functions (without it), just leave it. :)

Functions
-----
**ActionBarZ**
* setActionBar
* setActionBar(boolean isMain)
* setActionBarHide()
* setActionBarFull()
* setTitle(String title)
* setSubtitle(String subtitle)

**DateZ**
* getDatetime()
* getDatetime(String pattern)
* getDatetimeSimple()
* getTimestamp()
* getTimestampString()
* getTimestampTime(long timestamp)
* getTimestampTime(String timestamp)
* getTimestampTime(String pattern, long timestamp)
* getTimestampTime(String pattern, String timestamp)
* getTimestampDateFrom(String pattern, String text) 
* getTimestampLongFrom(String pattern, String text)
* getTimestampStringFrom(String pattern, String text)

**DayZ**
* getCurrentDay()
* getCurrentDay(Calendar calendar)
* getCurrentDay(int morning, int afternoon, int evening, int night)
* getCurrentDay(Calendar calendar, int m, int a, int e, int n)

**DelayZ**
* post(long millis, final Callback callback)
* post(long millis, Runnable runnable)
* cancel(Runnable runnable)
* cancel()

**DeviceZ**
* getAndroidID(Context context)
* getUUID()
* getIMEI(Context context)
* getMacAddress(Context context)
* getPseudoUniqueID()

**DialogZ**
* setViewLoadingDialog(boolean isShow)

**ExceptionZ**
* setDefaultUncaughtException(Class activity)
* setDefaultUncaughtException(UncaughtExceptionHandler..)
* setUncaughtExceptionHandler(Throwable throwable, Class activity) 
* getRootException(Throwable exception)

**EncryptZ**
* encryptTo(String text, String key)
* decryptTo(String text, String key)

**FirebaseZ**
* firebaseLog(String type, String log)
* firebaseLog(String event, String type, String log)
* firebaseScreen()
* firebaseProperty(String property, String type)

**GoogleAdsZ**
* adsGoogleBanner(String unitId, int id)
* adsGoogleBanner(String unitId, int id, AdListener listener)
* adsGoogleInterstitial(final String unitId)
* adsGoogleInterstitial(String unitId, AdListener listener)
* adsGoogleInterstitialShow()
* adsGoogleVideo(final String unitId)
* adsGoogleVideo(String unitId, RewardedVideoAdListener listener)
* adsGoogleVideoLoad(String unitId)
* adsGoogleVideoShow()

**IntentZ**
* setActivity(Class activity)
* setActivity(Class activity, int flag)
* setActivity(Class activity, boolean bool)
* setActivity(Class activity, String text)
* setActivity(Class activity, Bundle bundle)
* setActivityClear(Class activity)
* setActivityEmail(String email, String subject)
* setActivityMarket(int id)
* setActivityMarket(String id)
* setActivityShare(String subject, String text)
* setActivityShare(String subject, String text, String chooser)
* setActivityWebsite(String website)

**LogZ**
* setLog(String log)
* setLog(Activity activity, String log)

**NumberZ**
* getRandom()
* toHex(int number)
* toHex(long number)
* toOctal(int number)
* toOctal(long number)
* toBinary(int number)
* toBinary(long number)
* fromHex(String number)
* fromOctal(String number)

**PermissionZ**
* check(Context context, String permission)
* check(Context context, String perms, PermissionHandler handler)
* check(Context context, String perms, String rat, PermissionHandler..)
* check(Context context, String perms, int ratId, PermissionHandler..)
* check(final Context c, String[] perms)
* check(final Context c, String[] perms, PermissionHandler..)
* check(final Context c, String[] perms, String rat, Options o, PermsH..) {
* check(final Context c, String[] perms, int ratId, Options o, PermsH..) {
* hasPermission(String... permissions)

**PrefZ**
* getAll()
* contains(final String key)
* remove(final String key)
* setInt(final String key, final int value)
* setBoolean(final String key, final boolean value)
* setLong(final String key, final long value)
* setDouble(final String key, final double value)
* setFloat(final String key, final float value)
* setString(final String key, final String value)
* setStringSet(final String key, final Set<String> value)
* setStringSetOrdered(String key, Set<String> value)
* getInt(final String key, final int defValue)
* getBoolean(final String key, final boolean defValue)
* getLong(final String key, final long defValue)
* getDouble(final String key, final double defValue)
* getFloat(final String key, final float defValue)
* getString(final String key, final String defValue)
* getStringSet(final String key, final Set<String> defValue)
* getStringSetOrdered(String key, final Set<String> defValue)

**TextZ**
* isEmailValid(String email)
* isPhoneValid(String phone)
* isTextLength(String text, int min)
* isTextLength(String text, int min, int max)
* isTextMatch(String text1, String text2)
* isTextContain(String text, String contain)
* getDecimalFormat(int number, int digits)
* getDecimalFormat(float number, int digits)
* getDecimalFormat(double number, int digits)
* getDecimalFormat(long number, int digits)
* getNumber(String number)
* getNumberFormat(String number)
* getNumberFormat(String number, boolean isUseDotSeparator)
* getNumberRandom()
* getMoneyFormat(String number)
* getMoneyFormat(String currency, String number)
* getMoneyFormat(String currency, String number, String postCurrency)
* getMoneyFormat(String number, boolean isUseDotSeparator)
* getMoneyFormat(String curr, String num, boolean isUseDotSeparator)
* getMoneyFormat(String curr, String num, String postCurr, boolean isDot)
* getFormatAll(String text)
* getFormatName(String name)
* getFormatSpace(String text)
* getFormatEnter(String text)
* getArrayCharFrom(String text)
* getArrayFrom(String text, int n)
* getArrayFrom(String text)
* getStringFrom(List<String> list)
* getStringFrom(List<String> list, String delimiter)
* getListFrom(String text)
* getListFrom(String text, String delimiter)

**ToastZ**
* setToast(String message)
* setToast(CharSequence message)

**ViewZ**
* getValue(EditText editText)
* getValueBoolean(EditText editText)
* getValueInt(EditText editText)
* getValueLong(EditText text)
* getValueNumber(EditText text)
* setViewBounce(View view)
* setViewEnabled(View view, boolean isEnabled)
* hideKeyboard(View view)

[More information: AappZ's wiki](https://github.com/fentonmartin/aappz/wiki)

License
-----

AappZ library by [Fenton Martin](https://www.linkedin.com/in/fentonmartin) is licensed under an [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
