    package Screens;
    import ObjectRepository.LoginObjects;
    import io.appium.java_client.android.AndroidDriver;
    import io.appium.java_client.android.AndroidElement;
    import org.testng.Assert;
    import util.Commands;
    import Models.Login;
    import java.util.Map;
    import java.util.concurrent.TimeUnit;
    import util.ExcelUtility;

    public class LoginOperation {

        public static void clickHomeMenu(LoginObjects logino){
            Commands.waitUntilElementIsClickable(logino.getMenu(),60);
            Commands.click(logino.getMenu());
        }

        public static void performLogin(LoginObjects logino,AndroidDriver<AndroidElement> androidDriver) {

            Commands.waitUntilElementIsClickable(logino.getSigninlogo(), 60);
            Commands.click(logino.getSigninlogo());
            Commands.waitUntilElementIsClickable(logino.getUsername(), 60);
            Login b1 = null;
            for (Map.Entry<String, Login> entry : ExcelUtility.loginMap.entrySet()) {
                String key = entry.getKey();
                if (key.equalsIgnoreCase("Login")) {
                    b1 = entry.getValue();
                }


                Commands.textBoxType(logino.getUsername(), b1.getUsername());
                Commands.textBoxType(logino.getPassword(), b1.getPassword());
                Commands.click(logino.getSignIn());
                androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                Commands.waitUntilElementIsClickable(logino.getNoThanksLink(), 60);
                Commands.verify(logino.getNoThanksLink().getText(), "No thanks");
                Commands.click(logino.getNoThanksLink());
            }
        }
    }
