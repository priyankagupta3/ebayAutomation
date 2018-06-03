        package Screens;

        import ObjectRepository.SearchObjects;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.PerformsTouchActions;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.AndroidElement;
        import io.appium.java_client.touch.TapOptions;
        import io.appium.java_client.touch.WaitOptions;
        import io.appium.java_client.touch.offset.PointOption;
        import org.openqa.selenium.*;
        import org.testng.Assert;
        import util.Commands;
        import io.appium.java_client.TouchAction;
        import Models.Buy;
        import java.time.Duration;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

        public class CheckOut {


            public static void scrollCheckOutPage(SearchObjects search, AndroidDriver<AndroidElement> androidDriver, String price) throws InterruptedException {

                Commands.waitUntilElementIsVisible(search.getWebView(), 60);
                System.out.println(search.getWebView().getText());
                androidDriver.findElementByAndroidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Proceed to Pay\"));");
                int pressX = androidDriver.manage().window().getSize().width / 2;
                int bottomY = androidDriver.manage().window().getSize().height * 4 / 5;
                int topY = androidDriver.manage().window().getSize().height / 4;
                TouchAction touchAction = new TouchAction(androidDriver);
                touchAction.longPress(PointOption.point(pressX, bottomY)).moveTo(PointOption.point(pressX, topY)).release().perform();

            }


            public static WebElement getItemPrice(AndroidDriver<AndroidElement> androidDriver) {
                androidDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
                List list = androidDriver.findElements(By.xpath("//android.view.View[5]/android.widget.ListView/android.view.View[2]"));
                return ((WebElement) list.get(0));
            }


            public static void clickProceedToPayButton(SearchObjects search, AndroidDriver<AndroidElement> androidDriver) throws InterruptedException {
                Commands.waitUntilElementIsClickable(search.getProceedtoPayButton(), 60);
                int x1 = (int) (search.getProceedtoPayButton().getLocation().getX());
                int y1 = (int) (search.getProceedtoPayButton().getLocation().getY());
                new TouchAction(androidDriver).press(PointOption.point(x1, y1)).waitAction().release().perform();
                Commands.click(search.getProceedtoPayButton());
            }

            public static void selectPaymentMethod(SearchObjects search) {
                Commands.waitUntilElementIsClickable(search.getDebitCardButton(), 60);
                Commands.click(search.getDebitCardButton());
                Commands.waitUntilElementIsClickable(search.getDebitCardType(), 60);
                Commands.click(search.getDebitCardType());
                Commands.waitUntilElementIsClickable(search.getPayNow(), 60);
                Commands.click(search.getPayNow());
            }

            public static void payNow(SearchObjects search,Buy b1){

                Commands.waitUntilElementIsClickable(search.getMonth(),60);
                Commands.click(search.getMonth());

                Commands.waitUntilElementIsClickable(search.getMonthOption(),60);
                Commands.click(search.getMonthOption());

                Commands.waitUntilElementIsClickable(search.getYear(),60);
                Commands.click(search.getYear());

                Commands.waitUntilElementIsClickable(search.getYearOption(),60);
                Commands.click(search.getYearOption());

                Commands.waitUntilElementIsClickable(search.getCvv(),60);
                Commands.textBoxType(search.getCvv(),b1.getcvc());

                Commands.waitUntilElementIsClickable(search.getNameonCard(),60);
                Commands.textBoxType(search.getNameonCard(),b1.getCardName());

                Commands.waitUntilElementIsClickable(search.getCardNumber(),60);
                Commands.textBoxType(search.getCardNumber(),b1.getCardNumber());


                Commands.waitUntilElementIsClickable(search.getPayNow(),60);
                Commands.click(search.getPayNow());
        }
        }