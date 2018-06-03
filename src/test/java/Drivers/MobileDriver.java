package com.ebay.Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {


    AndroidDriver<AndroidElement> androidDriver;

    public AndroidDriver<AndroidElement> initializeDriver() throws InterruptedException, MalformedURLException {
        File f = new File("src");
        File appPath = new File(f, "com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);


        return androidDriver;
    }
}
