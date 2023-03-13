package com.qa.amazon.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.amazon.factory.DriverFactory;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.SearchResultsPage;

public class BaseTest {

	DriverFactory df;
	private WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public SearchResultsPage seachResultsPage;
	public Properties prop;
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_Prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
