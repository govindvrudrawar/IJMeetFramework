package com.Utility;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.ashot.AShot;

public class Constants {
	

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
	public static EventFiringWebDriver edriver;
	public static WebEventListner eventlistener;

	public static FluentWait wait;
	public static WebDriverWait webdriverWait;

}
