package com.primusbank.library;

import org.openqa.selenium.By;

import com.primusbank.constants.PrimusBankConstants;

public class AdminHomePage extends PrimusBankConstants
{
	public void adminLogout()
	{
		driver.findElement(By.xpath("//img[contains(@src,'images/admin_but_03.jpg')]")).click();
	}
}
