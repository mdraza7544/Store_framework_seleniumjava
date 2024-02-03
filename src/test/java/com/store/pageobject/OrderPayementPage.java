package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPayementPage {

	// create web driver object
		WebDriver driver;

		// This constructor take web driver type object
		public OrderPayementPage(WebDriver d) {
			driver = d;
			PageFactory.initElements(d, this);
		}

		// pay by bank element
		@FindBy(xpath = "//a[@title='Pay by bank wire']")
		WebElement paybybank;

		// identify Pay by check
		@FindBy(xpath = "//a[@title='Pay by check.']")
		WebElement paybycheck;
		
		// method for click on proceed to checkout
		public void clickOnPayByBank() {
			paybybank.click();
		}
		
		// method for click on proceed to checkout
		public void clickOnPayByCheck() {
			paybycheck.click();
		}
	
}
