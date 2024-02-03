package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public OrderSummaryPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify Proceed to checkout button element
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedtocheckout;

	// method for click on proceed to checkout
	public void clickOnProceedToCheckOutButton() {
		proceedtocheckout.click();
	}

}
