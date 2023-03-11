package com.qa.amazon.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.utils.Constants;
import com.qa.amazon.utils.Error;

public class HomePageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
		System.out.println("Before class is executing");
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void homePageTitleTest() {
		String actHomePageTitle=homePage.getHomePageTitle();                 
		System.out.println("Home page title is: "+actHomePageTitle);
		assertEquals(actHomePageTitle, Constants.HOMEPAGE_PAGE_TITLE, "Home Page is not correct");
	}
	@Test(priority = 2)
	public void homePageLogoTest() {
		Assert.assertTrue(homePage.isHomePageLogoExist(),Error.HOME_PAGE__LOGO_ERROR);              
	}
	@Test(priority = 3)
	public void homePageHeaderCountTest() {
		Assert.assertEquals(homePage.getHomePageHeadersCount(),Constants.HOMEPAGE_HEADER_COUNT, "Page logo is not exist");              
	}
	@Test(priority = 5)
	public void homePageHeaderListTest() {
		List<String> actHeaderList= homePage.getHomePageHeadersList();
		System.out.println("Home Page Header List: "+homePage.getHomePageHeadersList());
		Assert.assertEquals(actHeaderList, Constants.expHomePageHeaderList());
	}
	@Test(priority = 4)
	public void homePageSearchTest() {
		homePage.doSearch("macbook");            
	}
}
