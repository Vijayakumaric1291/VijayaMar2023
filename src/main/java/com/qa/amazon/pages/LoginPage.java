package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.utils.Constants;
import com.qa.amazon.utils.ElementUtil;

public class LoginPage {

	private ElementUtil elementUtil;
	private WebDriver driver;
	// Page objects-By locators -OR
	private By username = By.id("ap_email");
	private By continueBtn = By.id("continue");
	private By password = By.id("ap_password");
	private By loginBtn = By.id("signInSubmit");
	private By forgotPwd = By.id("auth-fpp-link-bottom");
	
	

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}

	// page actions:
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(5, Constants.LOGIN_PAGE_TITLE);
	}

	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwd);
	}
	
	public HomePage doLogin(String un,String pwd) {
		System.out.println("User name is: "+un+" and Password is: "+pwd);
		elementUtil.doSendKeys(username, un);
		elementUtil.waitForElementToBeClickable(continueBtn, 5);
		elementUtil.doClick(continueBtn);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new HomePage(driver);
	}
}
