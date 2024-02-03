package com.store.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.pageobject.AddMyAddress;
import com.store.pageobject.CreateAccount;
import com.store.pageobject.EnterDetails;
import com.store.pageobject.IndexPage;
import com.store.pageobject.MyAccount;
import com.store.utility.ReadDataFromExcle;



public class DatadrivenTesting extends BaseClass {// extend base class which is same packeg

	@Test(enabled = false)
	public void veriyfUserCreationAndLogin() throws InterruptedException {

		logger.info("veriyfUserCreationAndLogin test executed started........");
		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailCreate("ramban324@gmail.com");
		logger.info("Enter email address ");
		
		createAccount.clickSubmitCreate();
		logger.info("Enter email address ");

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

		// enter details on Add my address page
		AddMyAddress addMyAddress = new AddMyAddress(driver);
		addMyAddress.clickOnAddMyAddress();
		logger.info("clickOnAddMyAddress");
		
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

		// validate user is created or not
		MyAccount myAccount = new MyAccount(driver);
		String usernameinfo = myAccount.getUserName();// this string store

		// use Assert class for validate user is created or not
		logger.info("Verify user is validate or not");
		Assert.assertEquals("Raja Babu", usernameinfo);

	}

	

	@DataProvider(name = "loginDataProvider")
	public String[][] LoginDataProvider(){
		
		String filename = System.getProperty("user.dir")+"\\TestData\\testdata.xlsx";
		
		int ttrow =ReadDataFromExcle.getRowCount(filename,"Sheet1");
		int ttcolumn =ReadDataFromExcle.getColumnCount(filename,"Sheet1");
		
		String data[][]= new String[ttrow-1][ttcolumn];
		
		for(int i=1;i<ttrow;i++) {
			for(int j = 0;j<ttcolumn;j++) {
				data[i-1][j]=ReadDataFromExcle.getCellValue(filename, "Sheet1", i, j);
			}
		}
		return data;
	}
	
	
	
	@Test(dataProvider  = "loginDataProvider")
	public void verifyLogin(String useremail,String password,String expectedusername) throws InterruptedException ,IOException{

		logger.info("verifyLogin test executed started........");
		
		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailLogin(useremail);
		logger.info("Enter emial address......");
		
		createAccount.enterPasswordLogin(password);
		logger.info("Enter password.....");
		
		createAccount.clickOnSigninBtn();
		logger.info("Clicked on signin");
		
//		Thread.sleep(3000);

		// validate user is login  or not
		MyAccount myAccount = new MyAccount(driver);
		String usernameinfo = myAccount.getUserName();// this string store

		if(usernameinfo.equals(expectedusername)) {
			logger.info("verify login - Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("verify login - Failed");
			captureScreenShot(driver,"verifyLogin");
			Assert.assertTrue(false);
		}
		
		//click on sign out btn
		myAccount.clickOnSignOtuBtn();

	}

	
}
