package com.store.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUsingListener implements ITestListener {

	ReadConfig readconfig = new ReadConfig();
	
	ExtentSparkReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;

	public void configuration() {
		
		String timestamp = new SimpleDateFormat("yyyy,mm,dd hh.mm.ss ").format(new Date());
		String reportname="MyStoreTestReport-"+timestamp+".html";
		
		
		htmlReport = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportname);
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);

		// add system information environment info to report
		reports.setSystemInfo("Machine", "TestPC 1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", readconfig.getBrowser());
		reports.setSystemInfo("user name", "Md Ashif");

		// configuration to change look and feel of report
		htmlReport.config().setDocumentTitle("Report of Test cases ");
		htmlReport.config().setReportName("MyStore report");
		htmlReport.config().setTheme(Theme.DARK);

	}

	@Override// this method call when any test case start
	public void onStart(ITestContext arg0) {
		configuration();
		System.out.println("On start method invoked........");
	}

	@Override// call when all test are executed
	public void onFinish(ITestContext arg0) {
		System.out.println("On Finish method invoked........");
		reports.flush();// isko call karna zarori hai
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println("On Test failure method invoked........" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the fail test case is : " + Result.getName(), ExtentColor.RED));
		
		String screenshotpath =System.getProperty("user.dir")+"//screenshot//"+Result.getName()+".png";
		File screenshotfile = new File(screenshotpath);
		
		if(screenshotfile.exists()) {
			test.fail("Cpatured screenshot is : " + test.addScreenCaptureFromPath(screenshotpath));
		}
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("On Test Skipped method invoked........" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is : " + Result.getName(), ExtentColor.ORANGE));

	}

	
	public void onTestStart(ITestResult Result) {
		System.out.println("Test Method is Started : " + Result.getName());
	}

	
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Test Method is successfully exucted : " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the pass test case is : " + Result.getName(), ExtentColor.GREEN));
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}
}
