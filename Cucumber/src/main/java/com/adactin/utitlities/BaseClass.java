package com.adactin.utitlities;

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    /**
     * Setproperty browser
     * get
     * getcurrenturl
     * Gettitle
     * Window maximize
     * Switchtowindow (window handling), switchtonewtab and switchtooldtab
     * Switchtoalert ( multiple alert)
     * Simple, Confirmation, prompt
     * Switchtoframe
     * Switchtodefaultcontent
     * Navigate to url forward backward
     * Refresh
     * Close
     * Quit
     * Clear
     * Send keys
     * Click
     * Gettext
     * Getattribute
     * Is displayed
     * Is enabled
     * Is selected
     * Dropdown selectbyvalue
     * Selectbyindex
     * SelectbyVisibletext
     * Deselect all
     * Getoptions
     * Getfirstselectedoption
     * Getallselectedoption
     * Ismultiple
     * Actions
     * Mouse hover
     * Double click
     * Right-click
     * Drag and drop
     * Javascript executor scrollwindow, scrollIntoelement
     * SCREENSHOT
     * Sleep
     * Implicit wait
     * Explicit wait
     * Wait for element to be visible
     * To be clickable
     * Robot class enter tab and backspace
     */
    public static WebDriver driver;

    public static WebDriver setChromeBrowser() {
        if(driver == null) {
        System.setProperty("webdriver.chrome.driver","D:\\TestingB\\MayAuto\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * To maximize broswer window
     */
    public static void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }
    public static void loadURL(String url) {
        driver.get(url);
    }
    public static String getCurrentURl() {
        return driver.getCurrentUrl();
    }
    public static String getPageTitle() {
        return driver.getTitle();
    }
    public static String captureWindowHandle() {
        return driver.getWindowHandle();
    }
    public static List<String> captureWindowHandles() {
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        return windowHandles;
    }
    public static void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public static void switchToAlertAccept() {
        driver.switchTo().alert().accept();
    }

    public static void switchToAlertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public static void switchToAlertEnterValueAndAccept(String value) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }

    public static void switchToFrameWithIdOrName(String idOrName) {
        driver.switchTo().frame(idOrName);
    }

    public static void switchToFrameElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateToUrl(String url) {
       driver.navigate().to(url);
    }

    public static void closeTab() {
        driver.close();
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void clearValue(WebElement element) {
        element.clear();
    }

    public static void sendValueToTextBox(WebElement element,String value) {
        clearValue(element);
        element.sendKeys(value);
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static String getElementText(WebElement element) {
        return element.getText();
    }

    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public static String getTextBoxValue(WebElement element) {
        return element.getAttribute("value");
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public static void selectDropDownByText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public static void selectDropDownByIndex(WebElement element, int a) {
        Select select = new Select(element);
        select.selectByIndex(a);
    }
    public static void selectDropDown(WebElement element,String selectMethod, String value) {
        Select select = new Select(element);
        if(selectMethod.equalsIgnoreCase("byvalue")) {
            select.selectByValue(value);
        }else if(selectMethod.equalsIgnoreCase("bytext")) {
            select.selectByVisibleText(value);
        }else if(selectMethod.equalsIgnoreCase("byindex")) {
            select.selectByIndex(Integer.parseInt(value));
        } else  {
            System.out.println("Please use valid select method for dropdown");
        }
    }

    public static void deselectAll(WebElement element) {
        Select select = new Select(element);
        select.deselectAll();
    }

    public static List<String> getDropDownOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> dropDownElements = select.getOptions();
        List<String> dropDownValues = new ArrayList<String>();
        for(WebElement e:dropDownElements) {
            dropDownValues.add(e.getText());
        }
        return dropDownValues;
    }
    public static List<String> getAllSelectedOptions(WebElement element) {
        Select select = new Select(element);
        if(select.isMultiple()) {
            List<WebElement> dropDownElements = select.getAllSelectedOptions();
            List<String> dropDownValues = new ArrayList<String>();
            for (WebElement e : dropDownElements) {
                dropDownValues.add(e.getText());
            }
            return dropDownValues;
        }else {
            System.out.println("Please use getSelectedOption method instead");
            return null;
        }
    }
    
    public static String getSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public static void mouseHover(WebElement element) {
        Actions a = new Actions(driver);
        a.moveToElement(element).perform();
    }

    public static void doubleClick(WebElement element) {
        Actions a = new Actions(driver);
        a.doubleClick(element).perform();
    }

    public static void rightClick(WebElement element) {
        Actions a = new Actions(driver);
        a.contextClick(element).perform();
    }

    public static void dragAndDrop(WebElement source,WebElement target) {
        Actions a = new Actions(driver);
        a.dragAndDrop(source,target).perform();
    }

    public static void scrollWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)","");
    }

    public static void scrollIntoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void waitForLoad(int waitTime) throws InterruptedException {
        Thread.sleep(waitTime);
    }

    public static void waitForPageToBeLoaded(int wait) {
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }
//
//    public static void waitForElementToAppear(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver,);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

//    public static void waitForElementToBeClickable(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }

    public static void keyboardTabKey() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_TAB);
    }

    public static void keyboardEnterKey() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
    }

    public static void takeScreenshot() throws IOException {
        String filename = "Screenshot_"+new SimpleDateFormat("ddMMyyyy_HHmmss_SSS").format(new Date())+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File f1 = ts.getScreenshotAs(OutputType.FILE);
        File f2 = new File("D:\\TestingB\\Cucumber\\screenshots"+File.separator+filename);
        FileHandler.copy(f1,f2);
    }

    public static void takeFullScreenScreenShot(String location) throws IOException {
        Screenshot scr = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(scr.getImage(),"png",new File(location));
    }

    public static void assertTrue(String actual,String expected,String msg) {
        Assert.assertEquals(actual,expected);
        System.out.println(msg);
    }

}
