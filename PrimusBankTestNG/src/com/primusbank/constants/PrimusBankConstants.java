package com.primusbank.constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PrimusBankConstants
{
	public static WebDriver driver;
	public static String url = "http://primusbank.qedgetech.com";
	
	@BeforeTest
	public static void launchApplication()
	{
		System.setProperty("webdriver.chrome.driver", "//Users//williamsharry//Documents//workspace//chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public static void closeApplication()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
