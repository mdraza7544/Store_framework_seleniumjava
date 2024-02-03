package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver driver;

	// This constructor take web driver type object
	public CreateAccount(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}


	//	//Create an account section
	// Identify web elements in index page
	// this web element in create account section email address
	@FindBy(xpath = "//input [@id ='email_create']")
	WebElement email_create;

	// this web element in create account section ,create an account button
	@FindBy(xpath = "//button[@id ='SubmitCreate']")
	WebElement SubmitCreate;

	
	
	
	//Already registered? section
	// this web element in Already Registered section email address
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement loginusername;

	// this web element in Already Registered section password
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	WebElement loginpassword;

	// this web element in Already Registered login button
	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
	WebElement signinbutton;

	
	
	
	//Create an account
	// method for enter email in email box which take string type arrgumeant
	public void enterEmailCreate(String emailAddress) {
		email_create.sendKeys(emailAddress);
	}

	// method for click on create on account
	public void clickSubmitCreate() {
		SubmitCreate.click();
	}

	
	
	
	//Already registered?
	// method for enter email in email box which take string type arrgumeant
	public void enterEmailLogin(String emailAddress) {
		loginusername.sendKeys(emailAddress);
	}
	
	public void enterPasswordLogin(String emailAddress) {
		loginpassword.sendKeys(emailAddress);
	}
	
	public void clickOnSigninBtn() {
		signinbutton.click();
	}
}
