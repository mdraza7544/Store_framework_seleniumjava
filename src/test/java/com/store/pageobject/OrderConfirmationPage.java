package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public OrderConfirmationPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify I confirm my order
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement iconfirmmyorder;

	// identify alert success message
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement succesalert;

	// identify sign out button
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement signout;

	// method for click on I confirm my order
	public void clickOnIConfirmMyOrder() {
		iconfirmmyorder.click();
	}

	// method for order success message confirmation
	public String getOrderSuccessMessage() {
		return succesalert.getText();
	}
	
	public void clickOnSignOutButton() {
		signout.click();
	}
}
