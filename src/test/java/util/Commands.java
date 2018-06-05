package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class Commands {


    /**
     * This Method is used to Perform Click Operation
     * @param getButton
     */
    public static void click(WebElement getButton)
    {
        getButton.click();
    }

    /**
     * This Method is used to get Text of Particular Element
     * @param element
     * @return
     */
    public static String getText(WebElement element)
    {
        return element.getText();
    }

    /**
     * This Method is used to verify whether actual and expected strings are equal or not
     * @param getData
     * @param value
     */
    public static void verify(String getData,String value){
        Assert.assertEquals(value, getData);
    }

    /**
     * This Method is used type text at TextBox
     * @param getTextfield
     * @param value
     */
    public static void textBoxType(WebElement getTextfield,String value) {
        getTextfield.sendKeys(value);
    }

    /**
     * This method wait explicitly till the element is clickable or till timeout
     * @param getElement
     * @param timeinseconds
     */
    public static void waitUntilElementIsClickable(WebElement getElement,int timeinseconds,AndroidDriver<AndroidElement> androidDriver) {
        if (androidDriver != null) {
            WebDriverWait wait = new WebDriverWait(androidDriver, timeinseconds);
            wait.until(ExpectedConditions.elementToBeClickable(getElement));
        }
    }

    /**
     * This method wait explicitly till the visibility of list of elements or till timeout
     * @param getElements
     * @param timeinseconds
     */
    public static void waitUntilvisibilityOfAllElements (List<WebElement> getElements,int timeinseconds,AndroidDriver<AndroidElement> androidDriver) {
        if (androidDriver != null) {
            WebDriverWait wait = new WebDriverWait(androidDriver, timeinseconds);
            wait.until(ExpectedConditions.visibilityOfAllElements(getElements));
        }
    }

    /**
     * This method wait explicitly till the visibility of element or till timeout
     * @param getElement
     * @param timeinseconds
     */
    public static void waitUntilElementIsVisible(WebElement getElement, int timeinseconds,AndroidDriver<AndroidElement> androidDriver) {
        if (androidDriver != null) {
            WebDriverWait wait = new WebDriverWait(androidDriver, timeinseconds);
            wait.until(ExpectedConditions.visibilityOf(getElement));
        }
    }

    public static void takeScreenShots(AndroidDriver<AndroidElement> androidDriver) throws IOException {
        String basePath = null;
        String path;
        try {
            File currentDir = new File(".");
            basePath = currentDir.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String destDir = "Screenshots";
        // Capture screenshot.
        File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
        // Set date format to set It as screenshot file name.
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // Create folder under project with name "screenshots" provided to destDir.
        path = basePath + "/src/"+ destDir;
        new File(path).mkdirs();
        // Set file name using current date time.
        String destFile = dateFormat.format(new Date()) + ".png";

        // Copy paste file at destination folder location
        FileUtils.copyFile(scrFile, new File(path + "/" + destFile));

    }
}
