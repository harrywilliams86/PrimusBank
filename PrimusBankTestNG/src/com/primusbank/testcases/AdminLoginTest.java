package com.primusbank.testcases;

import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.AdminHomePage;
import com.primusbank.library.PrimusBankHome;

public class AdminLoginTest extends PrimusBankConstants
{
	@Test(description = "This test will check the Admin Login")
	public void AdminLogin()
	{
		boolean res;
		PrimusBankHome phome = new PrimusBankHome();
		phome.admid = "Admin";
		phome.admpwd = "Admin";
		res = phome.adminLogin(phome.admid, phome.admpwd);
		Assert.assertTrue(res);
		AdminHomePage ahome = new AdminHomePage();
		ahome.adminLogout();
		Sleeper.sleepTightInSeconds(3);
	}
}
