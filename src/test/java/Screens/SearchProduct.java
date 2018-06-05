package Screens;

import ObjectRepository.SearchObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import util.Commands;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProduct {

    /**
     * Method to Perform Search Operation from Home Page's Search TextBox
     * @param searchObject
     * @param productName
     * @param androidDriver
     * @throws InterruptedException
     */
    public static void searchProduct(SearchObjects searchObject, String productName,AndroidDriver<AndroidElement> androidDriver) throws InterruptedException {

        Commands.waitUntilElementIsClickable( searchObject.getSearchBox(),60,androidDriver);
        Commands.click(searchObject.getSearchBox());
        Commands.waitUntilElementIsClickable(searchObject.getSearchTextBox(),60,androidDriver);
        Commands.textBoxType(searchObject.getSearchTextBox(),productName);
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List searchOptionslist =  searchObject.getSearchOptions();
        Commands.click((WebElement)searchOptionslist.get(0));
    }

    /**
     * Method to Save particular Search, this method first check if particular search is saved or not, then it save the search
     * @param searchObject
     * @param androidDriver
     */
    public static void saveSearch(SearchObjects searchObject,AndroidDriver<AndroidElement> androidDriver){

        Commands.waitUntilElementIsClickable(searchObject.getSaveIcon(),60,androidDriver);

        if(searchObject.getSaveIcon().getText().equalsIgnoreCase("Saved")){
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        else{
            Commands.click(searchObject.getSaveIcon());
            Commands.waitUntilElementIsClickable(searchObject.getSaveButton(),60,androidDriver);
            Commands.click(searchObject.getSaveButton());
        }
    }

    /**
     * Method to Select any Product from the search list
     * @param searchObject
     * @param androidDriver
     */
    public static void selectFromSearchListResult(SearchObjects searchObject,AndroidDriver<AndroidElement> androidDriver){
        Commands.waitUntilvisibilityOfAllElements(searchObject.getSearchResults(),60,androidDriver);
        List searchResultslist =  searchObject.getSearchResults();
        ((WebElement)searchResultslist.get(0)).click();
    }
}
