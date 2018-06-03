package Screens;


import ObjectRepository.SearchObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Commands;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProduct {


    public static void searchProduct(SearchObjects search, String productName) throws InterruptedException {

        Commands.waitUntilElementIsClickable( search.getSearchBox(),60);
        Commands.click(search.getSearchBox());
        Commands.waitUntilElementIsClickable(search.getSearchTextBox(),60);
        Commands.textBoxType(search.getSearchTextBox(),productName);
        Thread.sleep(7000);
        List searchOptionslist =  search.getSearchOptions();
        Commands.click((WebElement)searchOptionslist.get(0));

    }

    public static void saveSearch(SearchObjects search){

        Commands.waitUntilElementIsClickable(search.getSaveIcon(),60);

        if(search.getSaveIcon().getText().equalsIgnoreCase("Saved")){
            Commands.click(search.getSaveIcon());
            Commands.waitUntilElementIsClickable(search.getSaveIcon(),60);
            Commands.click(search.getSaveIcon());
            Commands.waitUntilElementIsClickable(search.getSaveButton(),60);
            Commands.click(search.getSaveButton());
        }
        else{
            Commands.click(search.getSaveIcon());
            Commands.waitUntilElementIsClickable(search.getSaveButton(),60);
            Commands.click(search.getSaveButton());
        }
    }

    public static void selectFromSearchListResult(SearchObjects search){
        Commands.waitUntilvisibilityOfAllElements(search.getSearchResults(),60);
        List searchResultslist =  search.getSearchResults();
        ((WebElement)searchResultslist.get(1)).click();
    }
}
