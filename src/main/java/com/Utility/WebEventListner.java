package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListner extends Keyword implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		Constants.log.info("Try to accept alert");
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		Constants.log.info("Alert accepted");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		Constants.log.info("Alert dismissed");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		Constants.log.info("Try to dismiss alert");
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		Constants.log.info("Try to navigate "+url+" url");
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		Constants.log.info("Navigate to "+url+" url");
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		Constants.log.info("Try to navigate backward");
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		Constants.log.info("Navigated to backward");
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		Constants.log.info("Try to navigate forward");
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		Constants.log.info("Navigated to forward");
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		Constants.log.info("Try to refresh the DOM");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		Constants.log.info("DOM refreshed");
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		if(element==null) {
			 Constants.log.info("Just before finding element: " + by.toString() + " on browser: " + driver.toString() );
		}else {
            Constants.log.info("Just before finding element: " + by.toString() + " inside " + element.toString() + " Web element on browser: " + driver.toString());
		}
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		if(element==null) {
			 Constants.log.info("Just after finding element: " + by.toString() + " on browser: " + driver.toString() );
		}else {
           Constants.log.info("Just after finding element: " + by.toString() + " inside " + element.toString() + " Web element on browser: " + driver.toString());
		}
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		Constants.log.info("Trying to click on "+element.getText()+" "+element.getTagName());		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
	//	log.info("Clicked on "+element.getText()+" "+element.getTagName());			
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Constants.log.info("Before Change the value of "+element.getText()+" from "+keysToSend);
			}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Constants.log.info("After Change the value of "+element.getText()+" as "+keysToSend);
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		Constants.log.info("Trying to execute script :"+script);
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		Constants.log.info("Script exeuted :"+script);
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		Constants.log.info("Trying to switch on window : "+windowName);
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		Constants.log.info("Switch on window : "+windowName);
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		Constants.log.info("Exception received as "+ throwable.getMessage());
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		Constants.log.info("Trying to get screenshot of : "+target.toString());
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		Constants.log.info("Taking screenshot succesfully");
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		Constants.log.info("Trying to read text from : "+element.getTagName());
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		Constants.log.info("Read text from : "+text+" from "+element.getTagName());
	}

}
