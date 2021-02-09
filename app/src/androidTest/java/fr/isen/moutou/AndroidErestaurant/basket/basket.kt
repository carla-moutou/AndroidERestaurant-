package fr.isen.moutou.AndroidErestaurant.basket

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package fr.isen.moutou.AndroidErestaurant.basket

<uses-permission android:name="android.permission.INTERNET" />

<application
android:allowBackup="true"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.Isen_2021"
android:usesCleartextTraffic="true">
<activity android:name=".basket.BasketActivity"></activity>
<activity android:name=".detail.DetailActivity" />
<activity android:name=".CategoryActivity" />
<activity android:name=".HomeActivity">
<intent-filter>
<action android:name="android.intent.action.MAIN" />

<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>
</application>

</manifest>