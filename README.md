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
* ExceptionZ: Some functions for handle exceptions
* EncryptZ: Simple customizable encryption and decryption
* FirebaseZ: Firebase tools for your development
* GoogleAdsZ: Google Ads tools for your application
* IntentZ: Intent collections for any usage
* LogZ: Just log for debugging purpose
* PrefZ: Some functions for SharedPreferences
* TextZ: Text validation and formatting tools
* ToastZ: Just toast for create any messages
* ViewZ: Some functions for view and layout
Bonus library:
* SDP: Library of a scalable size unit (for non text views)
* SSP: Library of a scalable size unit (for text views)

Installation
-----
I suppose you already have jcenter() in your build.gradle. So, just add a dependency:
```
implementation 'io.github.fentonmartin:aappz:[$latest_version]'
```

Usage
-----
If you use AppCompatActivity, just extend AappZ:
```
public class MainActivity extends AappZ {...}
```

And that's it, now you can call any function directly:
```
setToast("Hello world!");
```

If want to use SDP or SSP libraries, just call it from xml:
```
android:layout_height="@dimen/_120sdp"
android:textSize="@dimen/_16ssp"
```

-----
If want to use FirebaseZ and GoogleAdsZ functions, just configure:
```
Firebase SDK: https://firebase.google.com/docs/android/setup
```

And copy FirebaseZ and GoogleAdsZ functions to your project:
```
- FirebaseZ
- GoogleAdsZ
```

If you only want to use basic functions without it, just leave it. :)

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

**ExceptionZ**
* setDefaultUncaughtException(Class activity)
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
* setActivityWebsite(String website)

**LogZ**
* setLog(String log)
* setLog(Activity activity, String log)

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
* isPasswordValid(String password, int min)
* isTextMatch(String text1, String text2)
* isTextContain(String text, String contain)
* getNumberClear(String number)
* getNumberFormat(String number)
* getNumberRandom()
* setFormatMoney(String number)
* setFormatName(String name)

**ToastZ**
* setToast(String message)
* setToast(CharSequence message)

**ViewZ**
* getValue(EditText editText)
* getValueBoolean(EditText editText)
* getValueInt(EditText editText)
* setViewEnabled(View view, boolean isEnabled)
* hideKeyboard(View view)

[More information: AappZ's wiki](https://github.com/fentonmartin/aappz/wiki)

License
-----

AappZ library by [Fenton Martin](https://www.linkedin.com/in/fentonmartin) is licensed under an [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
