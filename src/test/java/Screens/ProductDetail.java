    package Screens;

    import ObjectRepository.SearchObjects;
    import io.appium.java_client.android.AndroidDriver;
    import io.appium.java_client.android.AndroidElement;
    import util.Commands;

    public class ProductDetail {


        /**
         * Method to get Product Price from Product Detail Page
         * @param searchObject
         * @param androidDriver
         * @return
         */
        public static String getProductPrice(SearchObjects searchObject,AndroidDriver<AndroidElement> androidDriver) {
            Commands.waitUntilElementIsVisible(searchObject.getProductPrice(), 60,androidDriver);
            return searchObject.getProductPriceText();
        }

        /**
         * Method to click at "Buy It Now" button being displayed at Product Detail Page
         * @param searchObject
         * @param androidDriver
         */
        public static void clickProductBuyItNowButton(SearchObjects searchObject,AndroidDriver<AndroidElement> androidDriver) {
            Commands.waitUntilElementIsClickable(searchObject.getBuyItNow(), 60,androidDriver);
            Commands.click(searchObject.getBuyItNow());
        }

        /**
         * Method to click at Review Button being displayed at Product Review Page
         * @param searchObject
         * @param androidDriver
         */
        public static void clickProductReviewButton(SearchObjects searchObject,AndroidDriver<AndroidElement> androidDriver) {
            Commands.waitUntilElementIsClickable(searchObject.getReview(), 60,androidDriver);
            Commands.click(searchObject.getReview());
        }
    }
