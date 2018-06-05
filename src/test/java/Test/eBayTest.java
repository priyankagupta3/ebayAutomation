package Test;

import java.net.MalformedURLException;
import java.util.Map;
import Models.Buy;
import Models.Login;
import Models.Search;
import ObjectRepository.LoginObjects;
import Screens.ProductDetail;
import Screens.LoginOperation;
import Screens.SearchProduct;
import Screens.CheckOut;
import org.openqa.selenium.By;
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
import util.ScreenListener;

public class EBayTest {


    AndroidDriver<AndroidElement> androidDriver;
    LoginObjects logino;
    SearchObjects search;
    PropertiesReader propertiesReader;

    /**
     * Before Executing the Suite, 1. Initialize the AndroidDriver 2. Initialize Page Object Repositories
     * 3. Set the Screen Orientation to Portrait Mode 4. Create Data Structure from External file
     * @throws InterruptedException
     */
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
      //  new ScreenListener(androidDriver);
    }

    /**
     * This Test Perform Login Operation from the Navigation Home > Hamburger Menu > SignIn > Login Page
     * and It has Test Execution Priority 1
     * @throws InterruptedException
     */
    @Test(priority = '1')
    public void Login() throws InterruptedException {

        LoginOperation.clickHomeMenu(logino,androidDriver);
        Login login = null;
        for (Map.Entry<String, Login> entry : ExcelUtility.loginMap.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase("Login")) {
                login = entry.getValue();
            }
        }
        LoginOperation.performLogin(logino,androidDriver,login);
    }

    /**
     * This Test Search particular product and perform checkout operation and it has priority = 2
     * @throws InterruptedException
     */
    @Test(priority = '2')
    public void performSearchandCheckout() throws InterruptedException {

        Search searchData = null;
        for (Map.Entry<String, Search> entry : ExcelUtility.searchMap.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase("Search")) {
                searchData = entry.getValue();
            }
        }
        SearchProduct.searchProduct(search, searchData.getSearchtext(),androidDriver);
        SearchProduct.saveSearch(search,androidDriver);
        SearchProduct.selectFromSearchListResult(search,androidDriver);
        String productPrice = ProductDetail.getProductPrice(search,androidDriver).concat("00");
        ProductDetail.clickProductBuyItNowButton(search,androidDriver);
        ProductDetail.clickProductReviewButton(search,androidDriver);
        CheckOut.scrollCheckOutPage(search, androidDriver);
        String ActualResult = Commands.getText(CheckOut.getItemPrice(androidDriver)) ;
        Assert.assertEquals(search.splitString(productPrice.trim()).toString() , search.splitString(ActualResult.trim()).toString());
        CheckOut.clickProceedToPayButton(search, androidDriver);
        CheckOut.selectPaymentMethod(search,androidDriver);
        Buy buy = null;
        for (Map.Entry<String, Buy> entry : ExcelUtility.buyMap.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase("Buy")) {
                buy = entry.getValue();
            }
        }
        CheckOut.payNow(search,buy,androidDriver);
    }
}

