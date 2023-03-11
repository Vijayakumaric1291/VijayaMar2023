package com.qa.amazon.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author vijay
 *
 */
public class DriverFactory {

	WebDriver driver;
	Properties prop;
/**
 * This method is used to initiate the driver on the basis of given browser value
 * @param prop
 * @return this returns WebDriver
 */
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: " + prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Browser is not correct...please pass the correct browser name" + browserName);
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());
		return driver;
	}
/**
 * This method is initiate the properties from .properties file
 * @return Properties (prop)
 */
	public Properties init_Prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
