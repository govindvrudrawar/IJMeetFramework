package com.Utility;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class Keyword {

	public static WebDriver driver;
	public static Actions action;
	public static Select select;
	public static WebElement element;
	public static List<WebElement> elements;
	public static AShot ashot;
	public static Alert alert;
	public static String parentwindowhandle;
	public static Set<String> allindowhandles;
	public static Logger log = Logger.getLogger(Keyword.class);
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentLog, tempextentLog;

	/*
	 * This method will launch the given Browser
	 * 
	 */
	public static void launchBrowser(String browserName) {

		switch (browserName) {

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		default:
			System.err.print("The Entered " + browserName + "is incorrect");
			System.out.println("Enter Correct browserName such as Chrome, IE or Firefox");
			break;

		}
	}

	/*
	 * This method will launch the url by the previously opened driver instance
	 * 
	 * @param:Accepts String url as a parameter which needs to be launched url
	 * should be in format https://www.applicationname.com
	 */
	public static void launchUrl(String url) {

		driver.get(url);
	}

	/*
	 * This method will maximize the window
	 */
	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}

	/*
	 * This method will delete all the  cookies i.e. the password, the id for all the websites stored in the browser
	 */
	public static void deleteCookies() {

		driver.manage().deleteAllCookies();
	}

	/*
	 * This method will hover the mouse over the WebElement which is passed
	 * 
	 * @param:Accepts WebElement as a parameter over which we need to hover the
	 * mouse
	 * 
	 */
	public static void hoverMouseOnWebElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	/*
	 * This method will fetch the WebElement for which we have passed the locator
	 * type and locator value
	 * 
	 * @param:Accpets parameter as String locator Type
	 * 
	 * @param:Accepts parameter as String locator Value
	 * 
	 * @returns:WebElement of our interest
	 */
	public static WebElement getWebElement(String locatorType, String locatorValue) {

		switch (locatorType) {

		case "CSS":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "XPATH":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "ID":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "NAME":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "CLASSNAME":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "PARTIALLINKTEXT":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		default:
			System.err.print("Either " + locatorType + "or its " + locatorValue + "is incorrect");
			System.out.println("Kindly Enter correct " + locatorType + "And" + locatorValue);
			break;

		}
		return element;

	}

	/*
	 * This is a overloaded method for fetching the WebElement directly from the POM
	 * Classes.We have to use the Object Reference of the respective POM class to
	 * fetch the WebElement
	 * 
	 * @returns:WebElement from the POM Class
	 */
	public static WebElement getWebElement(WebElement element) {

		return element;
	}

	/*
	 * This method will fetch us the List of WebElement for which we have passed the
	 * locator type and locator value
	 * 
	 * @param:Accepts parameter as locator type and locator value
	 * 
	 */
	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {

		switch (locatorType) {

		case "CSS":
			elements = driver.findElements(By.cssSelector(locatorValue));
			break;
		case "XPATH":
			elements = driver.findElements(By.xpath(locatorValue));
			break;
		case "ID":
			elements = driver.findElements(By.id(locatorValue));
			break;
		case "NAME":
			elements = driver.findElements(By.name(locatorValue));
			break;
		case "CLASSNAME":
			elements = driver.findElements(By.className(locatorValue));
			break;
		case "PARTIALLINKTEXT":
			elements = driver.findElements(By.partialLinkText(locatorValue));
			break;
		default:
			System.err.print("Either " + locatorType + "or its " + locatorValue + "is incorrect");
			System.out.println("Kindly Enter correct " + locatorType + "And" + locatorValue);
			break;

		}
		return elements;

	}

	/*
	 * This method accepts WebElement Name which we have fetched in our POM Class
	 * and returns List of WebElements
	 * 
	 * @Param:Accepts parameter as WebElement directly from our POM Class
	 * 
	 */
	public static List<WebElement> getWebElements(WebElement element) {

		return elements;
	}

	/*
	 * This method will fetch us the text for the WebElement which is passed as
	 * parameter
	 * 
	 * @param:Accepts WebElement for which the text is to be fetched
	 * 
	 * @return:Returns String for the given WebElement
	 */
	public static String getWebElementText(WebElement element) {

		String s = element.getText();
		return s;
	}

	/*
	 * This method will enter the text in the location which is passed as an
	 * argument
	 * 
	 * @Param:Accepts WebElement as an argument i.e. the Text Box/Text Field in
	 * which we need to pass the text
	 * 
	 * @Param:Accepts text which needs to be passed to the text box/text field
	 */
	public static void enterText(WebElement element, String textToBeEntered) {

		element.sendKeys(textToBeEntered);
	}

	/*
	 * This method selects value from DropDown which is designed using Select tag
	 * 
	 * @param:Accepts argument as WebElement for the value which we need to choose
	 * 
	 * @Param:Accepts argument as 1 of three methods of Select Class
	 * 
	 * @Param:Accepts argument as the value which is available in the dropDown
	 */
	public static void selectFromDropDown(WebElement element, String method, String valuefromDropDrown) {

		select = new Select(element);
		switch (method) {
		case "SelectByIndex":
			select.selectByIndex(Integer.parseInt(valuefromDropDrown));
			break;
		case "SelectByValue":
			select.selectByValue(valuefromDropDrown);
		case "SelectByVisibleText":
			select.selectByVisibleText(valuefromDropDrown);
			break;
		default:
			System.err.print("Value selected is not available in the dropdown");
			break;

		}
	}
	/*
	 * This method captures screenshot for the viewport using Yandex AShot library
	 * and returns the Image
	 * 
	 * @Param:Accepts parameter the file-format in which we need the output Image
	 * 
	 * @Param:Accepts parameter as the location in which we want to save the
	 * screenshot taken
	 */

	public static Screenshot captureScreenshot(String ImageFormatType, FileOutputStream filepath) throws IOException {

		ashot = new AShot();
		Screenshot sc = ashot.takeScreenshot(driver);
		ImageIO.write(sc.getImage(), ImageFormatType, filepath);

		return sc;

	}

	/*
	 * This method will capture the screenshot for the entire web-page by parsing it
	 * 
	 * @Param:Accepts int value as parameter i.e. the time in milliseconds for which
	 * the web-page will be parsed
	 * 
	 * @Param:Accepts parameter as the type of Image we want i.e. JPG or PNG
	 * 
	 * @Param:Accepts paramter as the location where we need to save the image
	 * output stream
	 */
	public static Screenshot captureFullScreenshot(int timeinMiliseconds, String formatName, FileOutputStream filepath)
			throws IOException {

		ashot = new AShot();
		Screenshot sc = ashot.shootingStrategy(ShootingStrategies.viewportPasting(timeinMiliseconds))
				.takeScreenshot(driver);
		ImageIO.write(sc.getImage(), formatName, filepath);

		return sc;

	}

	/*
	 * This method will capture the screenshot for the WebElement of our interest
	 * and which needs to be passed as a parameter
	 * 
	 * @Param:Accepts WebElement as a parameter for which we want the screenshot
	 * 
	 * @Param:Accepts Image format as a parameter the type of format which we want
	 * the image to be of
	 * 
	 * @Param:Accepts the parameter as location where we want our FileOutPut Stream
	 * to be stored at
	 */
	public static Screenshot captureWebElementScreenshot(WebElement element, String formatName,
			FileOutputStream filepath) throws IOException {

		ashot = new AShot();
		Screenshot sc = ashot.takeScreenshot(driver, element);
		ImageIO.write(sc.getImage(), formatName, filepath);
		return sc;

	}

	/*
	 * This method will fetch the exact Y location (vertical location on the WebPage
	 * for the stated WebElement)
	 * 
	 * @Param:Accepts parameter as WebElement as an argument for which we want the Y
	 * Location The value we get has to be verified against the specification for
	 * exact location of this WebElement
	 */
	public static int getYLocation(WebElement element) {

		int y = element.getLocation().getY();

		return y;

	}

	/*
	 * This method will fetch the exact X location (the horizontal location on the
	 * WebPage for the stated WebElement)
	 * 
	 * @Param:Accepts parameter as WebElement for which we want the exact X location
	 * for
	 * 
	 * @returns:The int X location (The horizontal location which we need for the
	 * WebElement of our interest ) The value we get has to be verified against the
	 * specification for exact location of this WebElement
	 */
	public static int getXLocation(WebElement element) {
		int x = element.getLocation().getX();
		return x;
	}

	/*
	 * This method will scroll the window by the length in pixel which is passed as
	 * argument both horizontally and vertically To scroll the WebPage vertically
	 * give i = 0;
	 * 
	 * @Param:Takes argument as int value j i.e. the length in pixel value by which
	 * the WebPage will be scrolled vertically
	 * 
	 * @Param:Takes argument as int value i i.e. the length in pixel value by which
	 * the WebPage will be scrolled horizontally. The value we get has to be verified
	 * against the specification for exact location of this WebElement
	 */
	public static void scrolltheWebPage(int i, int j) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(i,j)");
	}

	/*
	 * This method will close the current window to which the driver instance is
	 * pointing to
	 */
	public static void closeWindow() {
		driver.close();
	}

	/*
	 * This method will close all the windows which the driver instance has opened
	 * 
	 * 
	 */
	public static void closeAllWindows() {
		driver.quit();
	}
	
	public void switchToPopupWindow() {
		parentwindowhandle = driver.getWindowHandle();
		allindowhandles = driver.getWindowHandles();
		for (String window : allindowhandles) {
			if (!driver.switchTo().window(window).getWindowHandle().equals(parentwindowhandle)) {
				log.info("Switched to " + driver.getTitle() + " window");
				break;
			}
		}
	}

	public void switchToPopupWindow(String windowtitle) {
		parentwindowhandle = driver.getWindowHandle();
		allindowhandles = driver.getWindowHandles();
		for (String window : allindowhandles) {
			if (driver.switchTo().window(window).getTitle().contains(windowtitle)) {
				log.info("Switched to " + driver.getTitle() + " window");
				break;
			}
		}
	}

	public void switchToMainWindow() {
		driver.switchTo().window(parentwindowhandle);
		log.info("Switching to main window");
	}

}