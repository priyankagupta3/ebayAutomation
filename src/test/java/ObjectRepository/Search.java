package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Search {


    @FindBy(id = "com.ebay.mobile:id/search_box")
    public WebElement SearchBox;

    @FindBy(id = "com.ebay.mobile:id/search_src_text")
    public WebElement SearchTextBox;

    @FindBy(id = "com.ebay.mobile:id/cell_collection_item[1]")
    public WebElement FirstSearchResult;

    @FindBy(id = "com.ebay.mobile:id/button_bin")
    public WebElement BuyItNow;

    @FindBy(id = "com.ebay.mobile:id/take_action")
    public WebElement Review;

    @FindBy(className = "android.widget.TextView")
    public List<WebElement> SearchOptions;

    @FindBy(xpath = "//android.widget.ListView[contains(@className = 'android.view.View' and @index,'1')]")
    public WebElement PriceContainer;

    public WebElement getPriceContainer() {
        return PriceContainer;
    }

    public void setPriceContainer(WebElement priceContainer) {
        PriceContainer = priceContainer;
    }

    @FindBy(id = "com.ebay.mobile:id/cell_collection_item")

    public List<WebElement> SearchResults;

    @FindBy(id = "com.ebay.mobile:id/button_follow")
    public WebElement SaveIcon;

    @FindBy(id = "android:id/button1")
    public WebElement SaveButton;

    @FindBy(id = "com.ebay.mobile:id/textview_item_price")
    public WebElement ProductPrice;

    public WebElement getProductPrice() {
        return ProductPrice;
    }

    public String getProductPriceText() {
        return ProductPrice.getText();
    }

    public void setProductPrice(WebElement productPrice) {
        ProductPrice = productPrice;
    }

    public WebElement getSaveIcon() {
        return SaveIcon;
    }

    public void setSaveIcon(WebElement saveIcon) {
        SaveIcon = saveIcon;
    }

    public WebElement getSaveButton() {
        return SaveButton;
    }

    public void setSaveButton(WebElement saveButton) {
        SaveButton = saveButton;
    }

    public WebElement getSearchTextBox() {
        return SearchTextBox;
    }

    public void setSearchTextBox(WebElement searchTextBox) {
        SearchTextBox = searchTextBox;
    }




    // android.view.View price and index 1

    public List<WebElement> getSearchResults() {
        return SearchResults;
    }

    public List<WebElement> getSearchOptions() {
        return SearchOptions;
    }

    public void setSearchOptions(List<WebElement> searchOptions) {
        SearchOptions = searchOptions;
    }

    public void setSearchResults(List<WebElement> SearchResults) {
        SearchResults = SearchResults;
    }

    public WebElement getSearchBox() {
        return SearchBox;
    }

    public void setSearchBox(WebElement searchBox) {
        SearchBox = searchBox;
    }

    public WebElement getFirstSearchResult() {
        return FirstSearchResult;
    }

    public void setFirstSearchResult(WebElement firstSearchResult) {
        FirstSearchResult = firstSearchResult;
    }

    public WebElement getBuyItNow() {
        return BuyItNow;
    }

    public void setBuyItNow(WebElement buyItNow) {
        BuyItNow = buyItNow;
    }

    public WebElement getReview() {
        return Review;
    }

    public void setReview(WebElement review) {
        Review = review;
    }

    public StringBuffer splitString(String str) {
        StringBuffer alpha = new StringBuffer(),
                num = new StringBuffer(), special = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                num.append(str.charAt(i));
            else if (Character.isAlphabetic(str.charAt(i)))
                alpha.append(str.charAt(i));
            else
                special.append(str.charAt(i));
        }
        return num;
    }
}
