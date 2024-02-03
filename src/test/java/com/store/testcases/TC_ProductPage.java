package com.store.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.store.pageobject.CreateAccount;
import com.store.pageobject.IndexPage;
import com.store.pageobject.MyAccount;
import com.store.pageobject.OrderAddressPage;
import com.store.pageobject.OrderConfirmationPage;
import com.store.pageobject.OrderPayementPage;
import com.store.pageobject.OrderShippingPage;
import com.store.pageobject.OrderSummaryPage;
import com.store.pageobject.ProductPage;
import com.store.pageobject.SearchResultPage;

import junit.framework.Assert;

public class TC_ProductPage extends BaseClass {

	@Test(priority = 1)
	public void verifySearchProduct() throws IOException, InterruptedException {

		String searchkey = "T-shirt";
		logger.info("verifySearchProduct test executed started........");

		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailLogin("ramban324@gmail.com");
		logger.info("Enter emial address......");
		createAccount.enterPasswordLogin("RajaBabu123");
		logger.info("Enter password.....");
		createAccount.clickOnSigninBtn();
		logger.info("Clicked on signin");
		
		Thread.sleep(2000);

		// enter search in search box in my account page r my account class
		MyAccount myAccount = new MyAccount(driver);
		myAccount.enterDataInSearcBox(searchkey);
		logger.info("Enter T shirt data on search box");
		myAccount.clickOnSearchButton();
		logger.info("Clicked on search button");
		
		Thread.sleep(2000);

		// get name of search product
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		String searchresultText = searchResultPage.getSearchResultProduct();

		// verify the correct product show or not
		if (searchresultText.contains(searchkey)) {
			logger.info("search product test passed ");
			Assert.assertTrue(true);
			Thread.sleep(2000);
			myAccount.clickOnSignOtuBtn();
		} else {
			logger.info("search product test failed ");
			captureScreenShot(driver, searchresultText);
			Assert.assertTrue(true);
		}

	}

	@Test(priority = 10)
	public void verifyBuyProduct() throws IOException, InterruptedException {

		String searchkey = "T-shirt";
		logger.info("VerifyBuyProduct test executed started........");

		// click on sign in there method are define in IndexPage Class
		IndexPage indexPage = new IndexPage(driver);
		indexPage.signIn();
		logger.info("Clicked on sign in linked.......");

		// enter email address and click there method are define in CreateAccount Class
		CreateAccount createAccount = new CreateAccount(driver);
		createAccount.enterEmailLogin("ramban324@gmail.com");
		logger.info("Enter emial address......");

		createAccount.enterPasswordLogin("RajaBabu123");
		logger.info("Enter password.....");

		createAccount.clickOnSigninBtn();
		logger.info("Clicked on signin");
		
		Thread.sleep(2000);

		// enter search in search box
		MyAccount myAccount = new MyAccount(driver);
		myAccount.enterDataInSearcBox(searchkey);
		logger.info("Enter T-Shirt value on search box");
		myAccount.clickOnSearchButton();
		logger.info("Clicked on serch button");

		Thread.sleep(2000);
		
		// get name of search product
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickOnMore();
		logger.info("Clicked on more button");
		
		Thread.sleep(2000);

		// Access product class and set size,qty else
		ProductPage productPage = new ProductPage(driver);
		productPage.setSize("M");
		logger.info("Enter size = M");
		productPage.setQuantity("2");
		logger.info("Enter quantity = 2");
		productPage.clickAddTOCart();
		logger.info("Clicked on Add To Cart button");
		productPage.clickTOProceedButton();
		logger.info("Clicked on Proceed button in product page");
		
		Thread.sleep(2000);

		// Order summary class or summary page
		OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
		orderSummaryPage.clickOnProceedToCheckOutButton();
		logger.info("Clicked on Proceed To Checkout button in order summary page");
		
		Thread.sleep(2000);

		// order address class or address page
		OrderAddressPage orderAddressPage = new OrderAddressPage(driver);
		orderAddressPage.clickOnProceedToCheckOutButton();
		logger.info("Click on Proceed To Checkout button in Order Address page");
		
		Thread.sleep(2000);

		// order shipping class or shipping page
		OrderShippingPage orderShippingPage = new OrderShippingPage(driver);
		orderShippingPage.clickOnTermsBox();
		logger.info("Click on Proceed To Checkout button in Order shipping page");
		orderShippingPage.clickOnProceedToCheckOutButton();
		logger.info("Click on Proceed To Checkout button in Order shipping page");

		Thread.sleep(2000);
		
		// order payment class or order payement page
		OrderPayementPage orderPayementPage = new OrderPayementPage(driver);
		orderPayementPage.clickOnPayByCheck();
		logger.info("Click on Pay By Chrck in order payement page ");

		Thread.sleep(2000);
		
		// order confirmation class or page
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		orderConfirmationPage.clickOnIConfirmMyOrder();
		logger.info("Click on I confirm my order in confirmation page  ");
		String succesMessage = orderConfirmationPage.getOrderSuccessMessage();

		if (succesMessage.equals("Your order on My Shop is complete.")) {
			logger.info("Verify buy product - PASSED");
			Assert.assertTrue(true);
			Thread.sleep(3000);
			orderConfirmationPage.clickOnSignOutButton();
		} else {
			logger.info("Verify buy product - PASSED");
			captureScreenShot(driver, succesMessage);
			Assert.assertTrue(true);
		}
		logger.info("VerifyBuyProduct test End........");
	}

}
