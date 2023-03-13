package com.qa.amazon.pages;

import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.ElementUtil;

public class ProductInfoPage {

	ElementUtil elementUtil;

	public ProductInfoPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}

}
