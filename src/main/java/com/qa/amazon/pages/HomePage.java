package com.qa.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.amazon.utils.Constants;
import com.qa.amazon.utils.ElementUtil;

public class HomePage {
	
	ElementUtil elementUtil;
	private WebDriver driver;
	private By logo = By.id("nav-logo");
	private By headers = By.cssSelector("#nav-xshop a");
	private By searchField = By.id("twotabsearchtextbox");
	private By searchBtn = By.id("nav-search-submit-button");
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		return elementUtil.waitForTitleContains(5, Constants.HOMEPAGE_PAGE_TITLE);
	}
	public boolean isHomePageLogoExist() {
		return elementUtil.doIsDisplayed(logo);
	}
	public int getHomePageHeadersCount() {
		return elementUtil.getElements(headers).size();
	}
	public  List<String> getHomePageHeadersList() {
		List<WebElement> headersList= elementUtil.getElements(headers);
		List<String> sectionList= new ArrayList<String>();
		for(WebElement e:headersList) {
			sectionList.add(e.getText());
		}
		return sectionList;
	}
	public SearchResultsPage doSearch(String productName) {
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchBtn);
		return new SearchResultsPage(driver);
	}
}
