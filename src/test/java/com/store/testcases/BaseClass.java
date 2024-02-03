package com.store.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.store.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// create object of ReadConfig class
	ReadConfig readconfig = new ReadConfig();

	// we store the url of web site
	String baseUrl = readconfig.getBaseUrl();

	// we store the browser of web site
	String browser = readconfig.getBrowser();

	// create object of web driver
	public static WebDriver driver;

	// create object of logger class
	public static Logger logger;

	// create a method to launch the web browser
	@BeforeClass
	public void launchBrowser() {

		// and make choice for to access different web browser
		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;

		}
		// implicit wait for all element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		// for logging
		logger = LogManager.getLogger("Store");

		// open url
		driver.get(baseUrl);// this string is define in base class
		logger.info("........url opened........");// logger is also define in base class

	}

	// close the browser
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public void captureScreenShot(WebDriver driver, String testname) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//screenshot//" + testname + ".png");

		FileUtils.copyFile(src, dest);
	}

}
