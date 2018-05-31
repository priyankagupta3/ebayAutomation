package Test;

import static org.testng.AssertJUnit.assertEquals;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import json.reader.JSONReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ebay.Driver.MobileDriver;
import Models.Data;
import ObjectRepository.Login;
import ObjectRepository.Search;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class eBayTest {

	
	AndroidDriver<AndroidElement> androidDriver;
	Login logino;
	Search search;
	
	@BeforeSuite
	public void setUp() throws InterruptedException {
		MobileDriver initialize = new MobileDriver();
        try {
            androidDriver = initialize.initializeDriver( );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        logino = PageFactory.initElements(androidDriver,Login.class);
		search = PageFactory.initElements(androidDriver,Search.class);
	}
	
	@Test(priority = '1')
	public void performLogin() throws InterruptedException {
        JSONReader JSONReader = new JSONReader();
        List list = JSONReader.read("Data.json", Data.class);
        Data data = (Data)list.get(0);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    logino.getMenu().click();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logino.getSigninlogo().click();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logino.getUsername().sendKeys(data.getUsername());
        logino.getPassword().sendKeys(data.getPassword());
        logino.getSignIn().click();
        androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(logino.getNoThanksLink().getText(), "No thanks");
        logino.getNoThanksLink().click();
	}

    @Test(priority = '2')
	public void performSearchandCheckout() throws InterruptedException {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        search.getSearchBox().click();
        search.getSearchTextBox().sendKeys("65-inch TV");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List searchOptionslist =  search.getSearchOptions();
        ((WebElement)searchOptionslist.get(0)).click();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if(search.getSaveIcon().getText().equalsIgnoreCase("Saved")){
            search.getSaveIcon().click();
            search.getSaveIcon().click();
                androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            search.getSaveButton().click();
                androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else{
            search.getSaveIcon().click();
                androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            search.getSaveButton().click();
                androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        List searchResultslist =  search.getSearchResults();
        ((WebElement)searchResultslist.get(0)).click();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualresult = search.getProductPriceText();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        search.getBuyItNow().click();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        search.getReview().click();
         androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Proceed to Pay\"));");
        androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
   
        Assert.assertEquals(search.splitString(actualresult), search.splitString(search.getPriceContainer().getText()));

}

}
