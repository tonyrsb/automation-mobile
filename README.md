# Implement Automation Mobile using Appium Maven Java

## Steps Configuration to run Mobile Automation (Manual)
- Download Java and set JAVA_HOME
- Download [Android Studio](https://developer.android.com/studio)
- Set ANDROID_HOME path to SDK Location
- Download Node.js v12(LTS)
- Download [Appium Desktop](http://appium.io/downloads.html)
- Install Java IDE [Eclipse](https://www.eclipse.org/downloads/)
- Download [Appium GUI and Appium Inspector](https://appium.io/downloads.html)
- Download TestNG plugin from eclipse marketplace

## Library that needed (this step is optional because library was handled by Maven Library Dependencies on pom.xml)
- Download [Selenium Java Client](https://www.selenium.dev/downloads/)
- Download [Appium Java Client](http://appium.io/downloads.html)
- Download [commons-lang3](https://commons.apache.org/proper/commons-lang/download_lang.cgi)
- Download [TestNG](https://testng.org/doc/download.html)

## Inspect Element Tools

1. Appium Inspector & Appium Server GUI Dekstop
- Connect device to Mac or windows (make sure device is on developer option mode on, allow install usb debugging)
- Open Appium Server GUI Dekstop
- Start Server
- Open Appium Inspector (Use for inspect element of apps)
- Start Inspector Session by filled Desired Capabilities (change deviceName, appPackage, appActivity, app according to your device and apk)
- Start Session

2. Desired Capabilities:

```
{
  "platformName": "android",
  "appium:platformVersion": "10.0.0",
  "appium:deviceName": "140bf5c1",
  "appium:noReset": "True",
  "appium:appPackage": "com.loginmodule.learning",
  "appium:appActivity": "com.loginmodule.learning.activities.LoginActivity",
  "appium:automationName": "uiautomator2",
  "appium:app": "/Users/user/eclipse-workspace/automation-apps/src/sample-android.apk"
}
```

## How to setup
- Connect device to Mac or windows (make sure device is on developer option mode on and allow install usb debugging). Use adb devices to check it
- Open Appium Server GUI Dekstop
- Start Server
- Clone this repository
- Open Project with Eclipse
- Copy APK file to "src/main/java/android_automation_mobile" Appium Project
- Right click on testng.xml > Run as > TestNG Suite 

### Getting appPackage and appActivity for Desired Capabilities 
```
adb logcat > log.txt
```
when the code executed then press the tokoPOS apps on phone, then terminate the code.
It will show the logcat on log.txt
- Open log.txt
- find "for activity"
- or using APKInfo


### Notes 
Before running test, read this documentation<br/>
Reference :
- [TestNG Documentation](https://testng.org/doc/documentation-main.html#running-testng)
- [Maven Respository](https://mvnrepository.com/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Appium Documentation](https://appium.io/docs/en/about-appium/api/)


