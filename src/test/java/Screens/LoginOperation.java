package Screens;

import ObjectRepository.LoginObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import util.Commands;
import Models.Login;
import java.util.concurrent.TimeUnit;


public class LoginOperation {


    /**
     * Method to Click at Hamburger Menu being displayed at Home Page
     * @param loginObject
     * @param androidDriver
     */
    public static void clickHomeMenu(LoginObjects loginObject,AndroidDriver<AndroidElement> androidDriver){
        Commands.waitUntilElementIsClickable(loginObject.getMenu(),60,androidDriver);
        Commands.click(loginObject.getMenu());
    }

    /**
     * Method to Perform Login Operation at eBay Application
     * @param loginObject
     * @param androidDriver
     * @param login
     */
    public static void performLogin(LoginObjects loginObject,AndroidDriver<AndroidElement> androidDriver,Login login) {

        Commands.waitUntilElementIsClickable(loginObject.getSigninlogo(), 60,androidDriver);
        Commands.click(loginObject.getSigninlogo());
        Commands.waitUntilElementIsClickable(loginObject.getUsername(), 60,androidDriver);
        Commands.textBoxType(loginObject.getUsername(), login.getUsername());
        Commands.textBoxType(loginObject.getPassword(), login.getPassword());
        Commands.click(loginObject.getSignIn());
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Commands.waitUntilElementIsClickable(loginObject.getNoThanksLink(), 60,androidDriver);
        Commands.verify(loginObject.getNoThanksLink().getText(), "No thanks");
        Commands.click(loginObject.getNoThanksLink());
    }
}

