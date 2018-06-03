package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchObjects {


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

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"proceedToPay\"]")
    public WebElement ProceedtoPayButton;

    @FindBy(id = "//android.widget.Image[@text=\"item image\"]")
    public WebElement ItemImage;

    @FindBy(xpath = "//android.webkit.WebView[@text=\"Review your order | eBay Mobile\"]")
    public WebElement WebView;

    public WebElement getWebView() {
        return WebView;
    }

    public void setWebView(WebElement webView) {
        WebView = webView;
    }

    public WebElement getItemImage() {
        return ItemImage;
    }

    public void setItemImage(WebElement itemImage) {
        ItemImage = itemImage;
    }

    @FindBy(xpath = "//android.view.View[@text=\"Debit Card\"]")
    public WebElement DebitCardButton;

    @FindBy(xpath = "//android.widget.RadioButton[@text=\"BILL DESK\"]")
    public WebElement DebitCardType;

    @FindBy(id = "btnPay")
    public WebElement PayNow;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Card Number\"]")
    public WebElement CardNumber;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Name on Card\"]")
    public WebElement NameonCard;

    @FindBy(xpath = "//android.widget.Spinner[@text=\"MM\"]")
    public WebElement Month;


    @FindBy(xpath = "//android.widget.Spinner[@text=\"YY\"]")
    public WebElement Year;


    @FindBy(xpath = "//android.widget.EditText[@text=\"CVV\"]")
    public WebElement cvv;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text=\"01\"]")
    public WebElement MonthOption;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text=\"19\"]")
    public WebElement YearOption;

    @FindBy(id = "pay_button_mobile_debit")
    public WebElement PayNowButton;

    public WebElement getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(WebElement cardNumber) {
        CardNumber = cardNumber;
    }

    public WebElement getNameonCard() {
        return NameonCard;
    }

    public void setNameonCard(WebElement nameonCard) {
        NameonCard = nameonCard;
    }

    public WebElement getMonth() {
        return Month;
    }

    public void setMonth(WebElement month) {
        Month = month;
    }

    public WebElement getYear() {
        return Year;
    }

    public void setYear(WebElement year) {
        Year = year;
    }

    public WebElement getCvv() {
        return cvv;
    }

    public void setCvv(WebElement cvv) {
        this.cvv = cvv;
    }

    public WebElement getMonthOption() {
        return MonthOption;
    }

    public void setMonthOption(WebElement monthOption) {
        MonthOption = monthOption;
    }

    public WebElement getYearOption() {
        return YearOption;
    }

    public void setYearOption(WebElement yearOption) {
        YearOption = yearOption;
    }

    public WebElement getPayNowButton() {
        return PayNowButton;
    }

    public void setPayNowButton(WebElement payNowButton) {
        PayNowButton = payNowButton;
    }

    @FindBy(xpath = "//android.view.View[5]/android.widget.ListView/android.view.View[2]")
    public List<WebElement> ItemPrice;

    public List<WebElement> getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(List<WebElement> itemPrice) {
        ItemPrice = itemPrice;
    }

    public WebElement getPayNow() {
        return PayNow;
    }

    public void setPayNow(WebElement payNow) {
        PayNow = payNow;
    }

    public WebElement getDebitCardType() {
        return DebitCardType;
    }

    public void setDebitCardType(WebElement debitCardType) {
        DebitCardType = debitCardType;
    }

    public WebElement getDebitCardButton() {
        return DebitCardButton;
    }

    public void setDebitCardButton(WebElement debitCardButton) {
        DebitCardButton = debitCardButton;
    }

    public WebElement getProceedtoPayButton() {
        return ProceedtoPayButton;
    }

    public String getProceedtoPayButtonText() {
        return ProceedtoPayButton.getText();
    }

    public void setProceedtoPayButton(WebElement proceedtoPayButton) {
        ProceedtoPayButton = proceedtoPayButton;
    }

    @FindBy(className = "android.widget.TextView")
    public List<WebElement> SearchOptions;

    @FindBy(xpath = "//android.widget.ListView[@className = 'android.view.View']")
    public List<WebElement> PriceContainer;

    public List<WebElement> getPriceContainer() {
        return PriceContainer;
    }

    public void setPriceContainer(List<WebElement> priceContainer) {
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

    public String  getProductPriceText() {
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
