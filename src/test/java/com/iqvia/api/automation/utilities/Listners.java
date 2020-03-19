package com.iqvia.api.automation.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		// htmlReporter=new
		// ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myreport.html");
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/IQVIARestAssuredAutomation/Reports/myreport.html");

		htmlReporter.config().setDocumentTitle("Automation Report"); // Title of the Report
		htmlReporter.config().setReportName("Rest API Testing Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Countries API testing");
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "jogendra");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // Create new Entry in the report
		test.log(Status.PASS, "Test Case PASSED IS" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());// Create new Entry in the report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // To Add Name in the report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // To Add error/exception in the extent
																				// Report

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); // Create new Entry in the report
		test.log(Status.SKIP, "Test case SKIPPED IS " + result.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
