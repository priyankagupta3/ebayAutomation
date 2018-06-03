    package util;

    import io.appium.java_client.android.AndroidDriver;
    import io.appium.java_client.android.AndroidElement;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;
    import java.util.List;
    public class Commands {

        public static AndroidDriver<AndroidElement> androidDriver;


        public static void Commands(AndroidDriver<AndroidElement> androidDriver) {

            if (androidDriver instanceof WebDriver && androidDriver != null) {
                androidDriver = androidDriver;
            }
        }

        public static void click(WebElement getButton)
        {
            getButton.click();
        }

        public static String getText(WebElement element)
        {
            return element.getText();
        }

        public static void verify(String getData,String value){

            Assert.assertEquals(value, getData);
        }

        public static void textBoxType(WebElement getTextfield,String value) {

            getTextfield.sendKeys(value);


        }
        public static void waitUntilElementIsClickable(WebElement getElement,int timeinseconds) {
            if (androidDriver != null) {
                WebDriverWait wait = new WebDriverWait(androidDriver, timeinseconds);
                wait.until(ExpectedConditions.elementToBeClickable(getElement));

            }
        }
        public static void waitUntilvisibilityOfAllElements (List<WebElement> getElements,int timeinseconds) {
            if (androidDriver != null) {
                WebDriverWait wait = new WebDriverWait(androidDriver, timeinseconds);
                wait.until(ExpectedConditions.visibilityOfAllElements(getElements));
        }
        }
        public static void waitUntilElementIsVisible(WebElement getElement, int timeinseconds) {
            if (androidDriver != null) {
                WebDriverWait wait = new WebDriverWait(androidDriver, timeinseconds);
                wait.until(ExpectedConditions.visibilityOf(getElement));
            }
        }
    }
