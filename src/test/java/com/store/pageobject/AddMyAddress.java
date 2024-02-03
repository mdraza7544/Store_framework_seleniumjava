package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddMyAddress {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public AddMyAddress(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify address button
	@FindBy(xpath = "//a[@title='Add my first address']")
	WebElement addmyadd;

	// identify company text field
	@FindBy(xpath = "//input [@id = 'company']")
	WebElement company;

	// identify address text field
	@FindBy(xpath = "//input [@id = 'address1']")
	WebElement address1;

	// identify address line 2 text field
	@FindBy(xpath = "//input [@id = 'address2']")
	WebElement line2;

	// identify city text field
	@FindBy(xpath = "//input [@id = 'city']")
	WebElement city;

	// identify state drop down
	@FindBy(xpath = "//select[@id = 'id_state']")
	WebElement state;

	// identify zip code text field
	@FindBy(xpath = "//input [@id = 'postcode']")
	WebElement zipcode;

	// identify country drop down
	@FindBy(xpath = "//select[@id = 'id_country']")
	WebElement country;

	// identify home phone number text field
	@FindBy(xpath = "//input [@id = 'phone']")
	WebElement homephone;

	// identify home phone number text field
	@FindBy(xpath = "//input [@id = 'phone_mobile']")
	WebElement phone;

	// identify additional information
	@FindBy(xpath = "//*[@id=\"other\"]")
	WebElement addiotnalinformation;

	// identify address title
	@FindBy(xpath = "//*[@id=\"alias\"]")
	WebElement addresstitle;

	// identify save button
	@FindBy(xpath = "//button [@id='submitAddress']")
	WebElement savebtn;

	// identify to home button
	@FindBy(css = ".footer_links > li:nth-child(2) > a")
	WebElement home;

	// click on addmyadd button
	public void clickOnAddMyAddress() {
		addmyadd.click();
	}

	// enter value company text filed
	public void enterCompany(String comp) {
		company.sendKeys(comp);
	}

	// enter value company text filed
	public void enteraddress(String add) {
		address1.sendKeys(add);
	}

	// enter value company text filed
	public void enterLine2(String line) {
		line2.sendKeys(line);
	}

	// enter value company text filed
	public void enterCity(String cit) {
		city.sendKeys(cit);
	}

	// enter value company text filed
	public void enterState(String stat) {
		Select obj = new Select(state);
		obj.selectByVisibleText(stat);
	}

	// enter value company text filed
	public void enterZipCode(String zip) {
		zipcode.sendKeys(zip);
	}

	// enter value company text filed
	public void enterCountry(String count) {
		Select obj = new Select(country);
		obj.selectByVisibleText(count);
	}

	// enter value company text filed
	public void enterHomePhone(String homep) {
		homephone.sendKeys(homep);
	}

	// enter value company text filed
	public void enterMonilePhone(String mobilep) {
		phone.sendKeys(mobilep);
	}

	// enter value company text filed
	public void enterAdditinolInformation(String additionalinforma) {
		addiotnalinformation.sendKeys(additionalinforma);
	}

	// enter value in address title
	public void enterAddressTitle(String addtitle) {
		addresstitle.clear();
		addresstitle.sendKeys(addtitle);
	}

	// click on save button
	public void clickOnSaveBtn() {
		savebtn.click();
	}

	// method for home button
	public void clickOnHomeBtn() {
		home.click();
	}

}
