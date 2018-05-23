package com.qa.quickstart.TeaTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaHomePage {
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a") WebElement menuButton;
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a") WebElement checkoutButton;

	
	public void clickMenu() {
		menuButton.click();
	}
	
	public void clickCheckout() {
		checkoutButton.click();
	}
	


}
