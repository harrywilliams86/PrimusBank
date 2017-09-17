package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.primusbank.constants.PrimusBankConstants;

public class Generics extends PrimusBankConstants
{
	public void selector(WebDriver driver, String locator, String item)
	{
		WebElement element;
		 element = driver.findElement(By.xpath(locator));
		 Select list = new Select(element);
		 list.selectByVisibleText(item);
	}
	public void textBoxInput(WebDriver driver, String locator, String data)
	{
		driver.findElement(By.xpath(locator)).sendKeys(data);
	}
}
