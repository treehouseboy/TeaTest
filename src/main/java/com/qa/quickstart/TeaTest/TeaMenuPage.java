package com.qa.quickstart.TeaTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMenuPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong") WebElement greenTea;
	
	public String checkMenu() {
		return greenTea.getText();
	}
}
