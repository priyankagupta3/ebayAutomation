    package Screens;

    import ObjectRepository.SearchObjects;
    import util.Commands;


    public class ProductDetail {

        public static String getProductPrice(SearchObjects search) {
            Commands.waitUntilElementIsVisible(search.getProductPrice(), 60);
            return search.getProductPriceText();
        }

        public static void clickProductBuyItNowButton(SearchObjects search) {
            Commands.waitUntilElementIsClickable(search.getBuyItNow(), 60);
            Commands.click(search.getBuyItNow());
        }

        public static void clickProductReviewButton(SearchObjects search) {
            Commands.waitUntilElementIsClickable(search.getBuyItNow(), 60);
            Commands.click(search.getReview());
        }
    }
