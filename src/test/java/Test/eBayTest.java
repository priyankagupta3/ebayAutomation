    package Test;
    import java.net.MalformedURLException;
    import java.util.Map;

    import Models.Buy;
    import Models.Search;
    import ObjectRepository.LoginObjects;
    import Screens.ProductDetail;
    import Screens.LoginOperation;
    import Screens.SearchProduct;
    import Screens.CheckOut;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.Assert;
    import org.testng.annotations.BeforeSuite;
    import org.testng.annotations.Test;
    import Drivers.MobileDriver;
    import ObjectRepository.SearchObjects;
    import io.appium.java_client.android.AndroidDriver;
    import io.appium.java_client.android.AndroidElement;
    import util.Commands;
    import org.openqa.selenium.ScreenOrientation;
    import util.ExcelUtility;
    import util.PropertiesReader;

    public class eBayTest {


        AndroidDriver<AndroidElement> androidDriver;
        LoginObjects logino;
        SearchObjects search;
        String productName;
        PropertiesReader propertiesReader;

        @BeforeSuite
        public void setUp() throws InterruptedException {
            MobileDriver initialize = new MobileDriver();
            try {
                androidDriver = initialize.initializeDriver( );
                ExcelUtility.CreateDatabase();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            logino = PageFactory.initElements(androidDriver, LoginObjects.class);
            search = PageFactory.initElements(androidDriver,SearchObjects.class);
            propertiesReader = PropertiesReader.getInstance();
            androidDriver.rotate(ScreenOrientation.PORTRAIT);
       }

        @Test(priority = '1')
        public void Login() throws InterruptedException {

            LoginOperation.clickHomeMenu(logino);
            LoginOperation.performLogin(logino,androidDriver);
        }

        @Test(priority = '2')
        public void performSearchandCheckout() throws InterruptedException {
            Search searchData = null;

            for (Map.Entry<String, Search> entry : ExcelUtility.searchMap.entrySet()) {
                String key = entry.getKey();
                if (key.equalsIgnoreCase("Search")) {
                    searchData = entry.getValue();
                }
            }

                SearchProduct.searchProduct(search, searchData.getSearchtext());
                SearchProduct.saveSearch(search);
                SearchProduct.selectFromSearchListResult(search);
                String productPrice = ProductDetail.getProductPrice(search).concat("00");


                ProductDetail.clickProductBuyItNowButton(search);
                ProductDetail.clickProductReviewButton(search);

                CheckOut.scrollCheckOutPage(search, androidDriver, productPrice);
                   String ActualResult = Commands.getText(CheckOut.getItemPrice(androidDriver));
                   Assert.assertEquals(search.splitString(productPrice.trim()).toString() , search.splitString(ActualResult.trim()).toString());


                CheckOut.clickProceedToPayButton(search, androidDriver);

                CheckOut.selectPaymentMethod(search);

                Buy buy = null;
                for (Map.Entry<String, Buy> entry : ExcelUtility.buyMap.entrySet()) {
                    String key = entry.getKey();
                    if (key.equalsIgnoreCase("Buy")) {
                        buy = entry.getValue();
                    }
                }

                CheckOut.payNow(search,buy);

            }

        }

