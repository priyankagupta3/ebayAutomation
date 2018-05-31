package com.ebay.Driver;

import ObjectRepository.Login;
import ObjectRepository.Search;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

        androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        Thread.sleep(5000);


        return androidDriver;
    }
}
