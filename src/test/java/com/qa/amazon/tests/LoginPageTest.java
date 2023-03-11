package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
//	@Test(priority = 2)
//	public void forgotPwdLinkTest() {
//		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
//	}
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
