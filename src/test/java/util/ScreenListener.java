package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

 ;import java.io.IOException;

public class ScreenListener implements ITestListener {
    AndroidDriver<AndroidElement> androidDriver;
    public ScreenListener(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            Commands.takeScreenShots(androidDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            Commands.takeScreenShots(androidDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        try {
            Commands.takeScreenShots(androidDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        try {
            Commands.takeScreenShots(androidDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
