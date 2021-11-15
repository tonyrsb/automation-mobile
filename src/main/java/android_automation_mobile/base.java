package android_automation_mobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	
	public static AndroidDriver<AndroidElement> capabilities(String noReset) throws IOException {
	    // TODO Auto-generated method stub

		File f = new File("src/main/java/android_automation_mobile");
	    File fs = new File(f,"sample-android.apk");
	    
		AndroidDriver<AndroidElement> driver;
		
	    DesiredCapabilities cap = new DesiredCapabilities();
	    
	    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "140bf5c1");
	    cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	    cap.setCapability("appActivity", "com.loginmodule.learning.activities.LoginActivity");
	    cap.setCapability("appPackage", "com.loginmodule.learning");
	    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,0);
		cap.setCapability("noReset", noReset);
		
	    driver = new AndroidDriver<> (new URL("http://127.0.0.1:4723/wd/hub"),cap);
	    cap.setCapability("autoAcceptAlert",true);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    return driver;
	}


}
