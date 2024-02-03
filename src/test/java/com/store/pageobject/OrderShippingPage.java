package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public OrderShippingPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify terms and condition
	@FindBy(xpath = "//*[@id=\"cgv\"]")
	WebElement termscheckbox;

	// identify Proceed to checkout button element
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedtocheckout;

	//method for click on terms and condition checkbox
	public void clickOnTermsBox() {
		termscheckbox.click();
	}
	
	// method for click on proceed to checkout
	public void clickOnProceedToCheckOutButton() {
		proceedtocheckout.click();
	}

}
