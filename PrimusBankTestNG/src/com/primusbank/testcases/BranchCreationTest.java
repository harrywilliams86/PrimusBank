package com.primusbank.testcases;

import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.AdminHomePage;
import com.primusbank.library.PrimusBankHome;

public class BranchCreationTest extends PrimusBankConstants
{
	@Test(description = "This test case will check the New Branch Creation")
	public void branchCreationTest()
	{
		boolean res;
		PrimusBankHome phome = new PrimusBankHome();
		phome.admid = "Admin";
		phome.admpwd = "Admin";
		phome.adminLogin(phome.admid, phome.admpwd);
		phome.branchname = "DemoName10";
		phome.add1 = "DemoAdd7";
		phome.zip = "12345";
		phome.country = "INDIA";
		phome.state = "Andhra Pradesh";
		phome.city = "Hyderabad";
		res = phome.createBranch(phome.branchname, phome.add1, phome.zip, phome.country, phome.state, phome.city);
		Assert.assertTrue(res);
		AdminHomePage ahome = new AdminHomePage();
		ahome.adminLogout();
		Sleeper.sleepTightInSeconds(2);
	}
}
