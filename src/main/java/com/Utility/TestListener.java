package com.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestListener extends Keyword implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Execution Started : " + result.getName());
		extentLog = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Execution Successed : " + result.getName());
		extentLog.log(Status.PASS, "Passed TestCase: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Execution Failed : " + result.getName());
		extentLog.log(Status.FAIL, "Failed TestCase: " + result.getName());
		String failedTCScreenshotPath = screenshotforExtentReport(driver, result.getName());
		try {
			extentLog.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(failedTCScreenshotPath).build());
		} catch (IOException e) {
			System.out.println("File not not found");
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Execution Skipped : " + result.getName());
		extentLog.log(Status.PASS, "Skipped  TestCase: " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + "ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project", "IJMeet");
		tempextentLog = extent.createTest("Temporary Test");
		tempextentLog.log(Status.PASS, "Bhushan");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("remove testlog");
		extent.removeTest(tempextentLog);
		extent.flush();
	}

	public String screenshotforExtentReport(WebDriver driver, String tcName) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tcName + " dated " + datetime
				+ ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotPath));
		} catch (IOException e) {
			log.info("Screenshot file not found!!");
			e.printStackTrace();
		}
		log.info("Screenshot taken Successfully!!");

		return screenshotPath;

	}

}
