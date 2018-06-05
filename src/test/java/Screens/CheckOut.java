        package Screens;

        import ObjectRepository.SearchObjects;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.AndroidElement;
        import io.appium.java_client.touch.offset.PointOption;
        import org.openqa.selenium.*;
        import util.Commands;
        import io.appium.java_client.TouchAction;
        import Models.Buy;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

        public class CheckOut {

            /**
             * Method to Scroll down the "Review your order" Page
             * @param searchObject
             * @param androidDriver
             * @throws InterruptedException
             */
            public static void scrollCheckOutPage(SearchObjects searchObject, AndroidDriver<AndroidElement> androidDriver) throws InterruptedException {
                Commands.waitUntilElementIsVisible(searchObject.getWebView(), 60,androidDriver);
                int pressX = androidDriver.manage().window().getSize().width / 2;
                int bottomY = androidDriver.manage().window().getSize().height * 4 / 5;
                int topY = androidDriver.manage().window().getSize().height / 8;
                TouchAction touchAction = new TouchAction(androidDriver);
                touchAction.longPress(PointOption.point(pressX, bottomY)).moveTo(PointOption.point(pressX, topY)).release().perform();
            }

            /**
             * Method to get the Item Price being displayed at "Review your order" Page
             * @param androidDriver
             * @return
             */
            public static WebElement getItemPrice(AndroidDriver<AndroidElement> androidDriver) {
                androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                int pressX = androidDriver.manage().window().getSize().width / 2;
                int bottomY = androidDriver.manage().window().getSize().height * 4 / 5;
                int topY = androidDriver.manage().window().getSize().height / 8;
                TouchAction touchAction = new TouchAction(androidDriver);
                touchAction.longPress(PointOption.point(pressX, bottomY)).moveTo(PointOption.point(pressX, topY)).release().perform();
                List list = androidDriver.findElements(By.xpath("//android.widget.ListView[@index='0']/android.view.View[2]"));
                return ((WebElement) list.get(0));
            }

            /**
             * Method to get at "Proceed To Pay" button being displayed at "Review your order" Page
             * @param searchObject
             * @param androidDriver
             * @throws InterruptedException
             */
            public static void clickProceedToPayButton(SearchObjects searchObject, AndroidDriver<AndroidElement> androidDriver) throws InterruptedException {
                Commands.waitUntilElementIsClickable(searchObject.getProceedtoPayButton(), 60,androidDriver);
                int x1 = (int) (searchObject.getProceedtoPayButton().getLocation().getX());
                int y1 = (int) (searchObject.getProceedtoPayButton().getLocation().getY());
                new TouchAction(androidDriver).press(PointOption.point(x1, y1)).waitAction().release().perform();
                Commands.click(searchObject.getProceedtoPayButton());
            }

            /**
             * Method to Select Payment Method, if Selected Payment Method as Debit Card, then to Select Debit Card Type/Bank
             * @param searchObject
             * @param androidDriver
             */
            public static void selectPaymentMethod(SearchObjects searchObject,AndroidDriver<AndroidElement> androidDriver) {
                Commands.waitUntilElementIsClickable(searchObject.getDebitCardButton(), 60,androidDriver);
                Commands.click(searchObject.getDebitCardButton());
                Commands.waitUntilElementIsClickable(searchObject.getDebitCardType(), 60,androidDriver);
                Commands.click(searchObject.getDebitCardType());
                Commands.waitUntilElementIsClickable(searchObject.getPayNow(), 60,androidDriver);
                Commands.click(searchObject.getPayNow());
            }

            /**
             * Method to enter the Card Details - Card Number,Name on Card,
             * Expiry Month/Year and CVV Code to Purchase the products
             * @param searchObject
             * @param buy
             * @param androidDriver
             */

            public static void payNow(SearchObjects searchObject,Buy buy,AndroidDriver<AndroidElement> androidDriver){

                Commands.waitUntilElementIsClickable(searchObject.getMonth(),60,androidDriver);
                Commands.click(searchObject.getMonth());
                Commands.waitUntilElementIsClickable(searchObject.getMonthOption(),60,androidDriver);
                Commands.click(searchObject.getMonthOption());
                Commands.waitUntilElementIsClickable(searchObject.getYear(),60,androidDriver);
                Commands.click(searchObject.getYear());
                Commands.waitUntilElementIsClickable(searchObject.getYearOption(),60,androidDriver);
                Commands.click(searchObject.getYearOption());
                Commands.waitUntilElementIsClickable(searchObject.getCvv(),60,androidDriver);
                Commands.textBoxType(searchObject.getCvv(),buy.getcvc());
                Commands.waitUntilElementIsClickable(searchObject.getNameonCard(),60,androidDriver);
                Commands.textBoxType(searchObject.getNameonCard(),buy.getCardName());
                Commands.waitUntilElementIsClickable(searchObject.getCardNumber(),60,androidDriver);
                Commands.textBoxType(searchObject.getCardNumber(),buy.getCardNumber());
                Commands.waitUntilElementIsClickable(searchObject.getPayNow(),60,androidDriver);
                Commands.click(searchObject.getPayNow());
        }
        }