package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterDetails {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public EnterDetails(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify title
	@FindBy(xpath = "//input[@id ='id_gender1']")
	WebElement title;

	// identify firstname
	@FindBy(xpath = "//input[@id ='customer_firstname']")
	WebElement firstname;

	// identify lastname
	@FindBy(xpath = "//input[@id ='customer_lastname']")
	WebElement lastname;

	// identify password
	@FindBy(xpath = "//input[@id ='passwd']")
	WebElement password;

	// identify news later
	@FindBy(xpath = "//input [@id='newsletter']")
	WebElement newslater;

	// identify register button
	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement register;

	// identify days
	@FindBy(xpath = "//select [@id='days']")
	WebElement days;

	// identify months
	@FindBy(xpath = "//select [@id='months']")
	WebElement months;

	// identify years
	@FindBy(xpath = "//select [@id='years']")
	WebElement years;

	// select title
	public void selectTitle() {
		title.click();
	}

	// enter first name
	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}

	// enter last name
	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}

	// enter password
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

/*
	// select date
	public void selectDate(String date) {
		Select obj = new Select(days);
		obj.selectByVisibleText(date);
	}

	// select months
	public void selectMonths(String month) {
		Select obj = new Select(months);
		obj.selectByVisibleText(month);
	}

	// select years
	public void selectYear(String year) {
		Select obj = new Select(years);
		obj.selectByVisibleText(year);
	}
*/
	// click on news later
	public void newsLater() {
		newslater.click();
	}

	// click on register button
	public void registerButton() {
		register.click();
	}
}
