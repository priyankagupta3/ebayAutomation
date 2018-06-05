package Drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import util.PropertiesReader;

public class MobileDriver {


    AndroidDriver<AndroidElement> androidDriver;

    public AndroidDriver<AndroidElement> initializeDriver() throws InterruptedException, MalformedURLException {


        String  platformName ;
        String  deviceName;
        String  versionName;
        String  appiumServerURL;
        PropertiesReader propertiesReader;


        propertiesReader = PropertiesReader.getInstance();
        platformName = propertiesReader.getProperty("platformName");
        deviceName = propertiesReader.getProperty("DEVICE_NAME");
        versionName = propertiesReader.getProperty("PLATFORM_VERSION");
        appiumServerURL = propertiesReader.getProperty("APPIUM_SERVER_URL");


        File f = new File("src");
        File appPath = new File(f, "com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, versionName);
        capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());

        androidDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return androidDriver;
    }
}
