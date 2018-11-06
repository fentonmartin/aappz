# AappZ | A to Z Application Functions in One Library

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub issues](https://img.shields.io/github/issues/fentonmartin/aappz.svg)](https://github.com/fentonmartin/aappz/issues)
[![Download](https://api.bintray.com/packages/fentonmartin/maven/AappZ/images/download.svg)](https://bintray.com/fentonmartin/maven/AappZ/_latestVersion)

<a href="https://play.google.com/store/apps/dev?id=7539335505101133203">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

Description
-----
AappZ library is an all in one library for android application.

Content
-----
AappZ library offers convenient tools for android application:
* ActivityZ: Activity class extends AppCompatActivity
* DateZ: Date class for datetime and timestamp
* IntentZ: Intent collections for any usage
* LogZ: Just log for debugging purpose
* TextZ: Text validation and formatting tools
* ToastZ: Just toast for create any messages
* ViewZ: Some functions for view and layout

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
**ActionBarZ**
* setActionBar
* setActionBar(boolean isMain)
* setActionBarHide()
* setActionBarFull()
* setTitle(String title)
* setSubtitle(String subtitle)

**ExceptionZ**
* setDefaultUncaughtException(Class activity)
* getRootException(Throwable exception)

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
* ToastZ
* setToast(String message)
* setToast(CharSequence message)

**ViewZ**
* getValue(EditText editText)
* getValueBoolean(EditText editText)
* getValueInt(EditText editText)
* setViewEnabled(View view, boolean isEnabled)
* hideKeyboard(View view)


[More check AappZ's wiki](https://github.com/fentonmartin/aappz/wiki)

License
-----

AappZ library by [Fenton Martin](https://www.linkedin.com/in/fentonmartin) is licensed under an [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
