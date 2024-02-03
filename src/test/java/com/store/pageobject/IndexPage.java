package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public IndexPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Identify web elements in index page
	@FindBy(xpath = "//a [@class = 'login']")
	WebElement sign_in;

	// create method for perform action sign_in Button
	public void signIn() {
		sign_in.click();
	}

	public String getIndeaxPageTitle() {
		return driver.getTitle();
	}
}
