package com.store.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.AddMyAddress;
import com.store.pageobject.CreateAccount;
import com.store.pageobject.EnterDetails;
import com.store.pageobject.IndexPage;
import com.store.pageobject.MyAccount;



public class TC_CreateAccountPage extends BaseClass {// extend base class which is same packeg

	@Test(priority = 1,enabled = true)
	public void veriyfUserCreationAndLogin() throws InterruptedException {

		logger.info("veriyfUserCreationAndLogin test executed started........");
		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		Thread.sleep(2000);

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailCreate("modiji420@gmail.com");
		logger.info("Enter email address ");

		createAccount.clickSubmitCreate();
		logger.info("Click on submit button");

		Thread.sleep(2000);

		// enter details on create account page
		EnterDetails enterDetails = new EnterDetails(driver);
		enterDetails.selectTitle();
		logger.info("Select title ");

		enterDetails.enterFirstName("Raja");
		logger.info("Enter first name ");

		enterDetails.enterLastName("Babu");
		logger.info("Enter last naame");

		enterDetails.enterPassword("RajaBabu123");
		logger.info("Enter password");

//		enterDetails.selectDate("15");
//		enterDetails.selectMonths("08");
//		enterDetails.selectYear("2005");
		enterDetails.newsLater();
		logger.info("Click on news latter");

		enterDetails.registerButton();
		logger.info("Clicked registration button");

		Thread.sleep(2000);

		// enter details on Add my address page
		AddMyAddress addMyAddress = new AddMyAddress(driver);
		addMyAddress.clickOnAddMyAddress();
		logger.info("clickOnAddMyAddress");

		Thread.sleep(2000);

		addMyAddress.enterCompany("it'S mE");
		logger.info("Enter company ");

		addMyAddress.enteraddress("Kasmar");
		logger.info("Enter address");

		addMyAddress.enterLine2("Street 2");
		logger.info("Enter street");

		addMyAddress.enterCity("Ranchi");
		logger.info("Enter city");

		addMyAddress.enterState("Hawaii");
		logger.info("Enter state");

		addMyAddress.enterZipCode("96719");
		logger.info("Enter Zip code");

		addMyAddress.enterCountry("United States");
		logger.info("Enter country");

		addMyAddress.enterHomePhone("326790");
		logger.info("Enter home phone number");

		addMyAddress.enterMonilePhone("512056");
		logger.info("Enter persnol phone number");

		addMyAddress.enterAdditinolInformation("This is My Address");
		logger.info("Enter additinol information");

		addMyAddress.enterAddressTitle("This is My Address");
		logger.info("Enter adress title");

		addMyAddress.clickOnSaveBtn();
		logger.info("Clicked on save button");

		addMyAddress.clickOnHomeBtn();
		logger.info("Click on home button");

		Thread.sleep(2000);

		// validate user is created or not
		MyAccount myAccount = new MyAccount(driver);
		String usernameinfo = myAccount.getUserName();// this string store

		// use Assert class for validate user is created or not
		logger.info("Verify user is validate or not");
		Assert.assertEquals("Raja Babu", usernameinfo);

		myAccount.clickOnSignOtuBtn();
		logger.info("......veriyfUserCreationAndLogin test end.......");

	}

	@Test(priority = 10)
	public void verifyLogin() throws InterruptedException, IOException {

		logger.info(".........verifyLogin test executed started........");

		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		Thread.sleep(2000);

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailLogin("cupoftea1@gmail.com");
		logger.info("Enter emial address......");

		createAccount.enterPasswordLogin("RajaBabu123");
		logger.info("Enter password.....");

		createAccount.clickOnSigninBtn();
		logger.info("Clicked on signin");

		Thread.sleep(2000);

		// validate user is login or not
		MyAccount myAccount = new MyAccount(driver);
		String usernameinfo = myAccount.getUserName();// this string store

		if (usernameinfo.equals("Raja Babu")) {
			logger.info("verify login - Passed");
			Assert.assertTrue(true);
		} else {
			logger.info("verify login - Failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}

		// click on sign out btn
		myAccount.clickOnSignOtuBtn();
		Thread.sleep(2000);
		logger.info(".........verifyLogin test end........");

	}

	@Test(priority = 30)
	public void verifySignOut() throws IOException, InterruptedException {

		logger.info("................verifySignOut Test Case start.................");

		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		Thread.sleep(2000);

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailLogin("babusons420@gmail.com");
		logger.info("Enter emial address......");

		createAccount.enterPasswordLogin("RajaBabu123");
		logger.info("Enter password.....");

		createAccount.clickOnSigninBtn();
		logger.info("Clicked on signin");

		//indeax page or class
		MyAccount myAccount = new MyAccount(driver);
		myAccount.clickOnSignOtuBtn();// click on sign out btn
		
		Thread.sleep(2000);
		
		if(indexPage.getIndeaxPageTitle().equals("Login - My Shop")) {
			logger.info("Verify sign out - PASSED");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Verify sign out - PASSED");
			captureScreenShot(driver, "Verify Sign Out");
			Assert.assertTrue(false);
		}
		
		logger.info("...............verifySignOut Test Case start................");

	}
}
