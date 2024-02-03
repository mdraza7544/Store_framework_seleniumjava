package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public MyAccount(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify user info
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userinfo;

	// identify signout
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement signout;
	
	// identify searchbox
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	WebElement searchbox;
	
	// identify search icon
	@FindBy(xpath = "//button [@class='btn btn-default button-search']")
	WebElement searchbutton;
	
	

	// method for click on user info account
	public String getUserName() {
		String text = userinfo.getText();
		return text;
	}

	//click on sign in button
	public void clickOnSignOtuBtn() {
		signout.click();
	}
	
	//method for enter data in search box
	public void enterDataInSearcBox(String searchkey) {
		searchbox.sendKeys(searchkey);
	}
	
	//click on search button
	public void clickOnSearchButton() {
		searchbutton.click();
	}

}
