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
		Constants.extentLog = Constants.extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Execution Successed : " + result.getName());
		Constants.extentLog.log(Status.PASS, "Passed TestCase: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Execution Failed : " + result.getName());
		Constants.extentLog.log(Status.FAIL, "Failed TestCase: " + result.getName());
		String failedTCScreenshotPath = screenshotforExtentReport(Constants.driver, result.getName());
		try {
			Constants.extentLog.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(failedTCScreenshotPath).build());
		} catch (IOException e) {
			System.out.println("File not not found");
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Execution Skipped : " + result.getName());
		Constants.extentLog.log(Status.PASS, "Skipped  TestCase: " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		Constants.htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + "ExtentReport.html");
		Constants.extent = new ExtentReports();
		Constants.extent.attachReporter(Constants.htmlReporter);
		Constants.extent.setSystemInfo("Project", "IJMeet");
		Constants.tempextentLog = Constants.extent.createTest("Temporary Test");
		Constants.tempextentLog.log(Status.PASS, "Bhushan");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("remove testlog");
		Constants.extent.removeTest(Constants.tempextentLog);
		Constants.extent.flush();
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
			Constants.log.info("Screenshot file not found!!");
			e.printStackTrace();
		}
		Constants.log.info("Screenshot taken Successfully!!");

		return screenshotPath;

	}

}
