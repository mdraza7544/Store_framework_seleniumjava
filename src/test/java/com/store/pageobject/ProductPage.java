package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	// create web driver object
	WebDriver driver;

	// This constructor take web driver type object
	public ProductPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify size
	@FindBy(xpath = "//*[@id=\"group_1\"]")
	WebElement size;

	// identify quantity
	@FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
	WebElement quantity;

	// identify add to cart button
	@FindBy(xpath = "//button [@class = 'exclusive']")
	WebElement addtocatrbutton;

	// identify proceed to checkout
	@FindBy(linkText = "Proceed to checkout")
	WebElement proceedtocheckout;

	// method for select size
	public void setSize(String sizeTy) {
		Select obj = new Select(size);
		obj.selectByVisibleText(sizeTy);
	}

	// method for set quantity
	public void setQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}

	// method for click on add to cart button
	public void clickAddTOCart() {
		addtocatrbutton.click();
	}

	// method for click to proceed to checkout button
	public void clickTOProceedButton() {

		proceedtocheckout.click();
	}
}
