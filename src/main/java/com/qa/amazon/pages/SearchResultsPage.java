package com.qa.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.amazon.utils.ElementUtil;

public class SearchResultsPage {

	ElementUtil elementUtil;
	private WebDriver driver;
	By searchItemResultName = By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]");
	By searchItemResultsCount = By.xpath("//span[text()='1-16 of 551 results for']");
	By SearchItemResults = By.cssSelector("div.sg-col-20-of-24 h2");

	

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getSearchItemResultName() {
		return elementUtil.doGetElementText(searchItemResultName);
	}

	public String getSearchItemResultCount(int index) {
		elementUtil.waitForElementTextToBe(searchItemResultsCount, 5, getSearchItemResultName());
		return elementUtil.doGetElementText(searchItemResultsCount).split(" ")[index];
	}

	public ProductInfoPage selectFromResults(String productName) {
		List<WebElement> resultsItemList = elementUtil.getElements(SearchItemResults);
		System.out.println("Total number of products displayed for " + productName + " : " + resultsItemList.size());
		for (WebElement e : resultsItemList) {
			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}

}
