package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver driver;

	public SearchResultPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify the element present in search result page
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
	WebElement searchResultProduct;
	
	//identify more button
	@FindBy(linkText  = "More")
	WebElement more;

	// method for present search result page
	public String getSearchResultProduct() {
		return searchResultProduct.getText();
	}
	
	//method for click on more button 
	public void clickOnMore() {
		Actions action1 = new Actions(driver);

		//hover action performed
		action1.moveToElement(searchResultProduct).perform();//is used to perform mouse hover action
		more.click();
	}

}
