package com.qa.quickstart.TeaTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {

	WebDriver driver;
	TeaHomePage homePage;
	TeaMenuPage menuPage;
	ExtentTest test;
	ExtentReports report = new ExtentReports(Constants.extentReportLocation, true);
	static int count = 0;

	
	
	@Before
	public void setup() {
		System.setProperty(Constants.chromeDriver, Constants.chromeDriverLocation);
		driver = new ChromeDriver();
		test = report.startTest("This is a test");
		driver.manage().window().maximize();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		
		driver.get(Constants.websiteURL);
		test.log(LogStatus.INFO, "Reached Home Page");
		Assert.assertEquals("Welcome", driver.getTitle());
		homePage = PageFactory.initElements(driver, TeaHomePage.class);

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		homePage.clickMenu();
		test.log(LogStatus.INFO, "Reached menu page");
		Assert.assertEquals("Menu", driver.getTitle());
		menuPage = PageFactory.initElements(driver, TeaMenuPage.class);
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		if(menuPage.checkMenu().equals("Green Tea")) {
			test.log(LogStatus.PASS, "Menu displayed correctly");
		} else {
			test.log(LogStatus.FAIL, "Menu fail");
		}
		Assert.assertEquals("Green Tea", menuPage.checkMenu());
		TeaSteps.count++;
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		homePage.clickCheckout();
		test.log(LogStatus.INFO, "Reached checkout page");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		if(driver.getTitle().equals("Check Out")) {
			test.log(LogStatus.PASS, "Checkout success");
		} else {
			test.log(LogStatus.FAIL, "Checkout fail");
		}
		Assert.assertEquals("Check Out", driver.getTitle());
		TeaSteps.count++;
	}

	@After
	public void teardown() {
		report.endTest(test);
		System.out.println(count);
		if(TeaSteps.count == 2) {
			report.flush();
		}
		driver.quit();
	}

}
