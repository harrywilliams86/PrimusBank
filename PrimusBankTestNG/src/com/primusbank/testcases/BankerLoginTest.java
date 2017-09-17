package com.primusbank.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.BankerHomePage;
import com.primusbank.library.PrimusBankHome;

public class BankerLoginTest extends PrimusBankConstants
{
	@Test(description = "This test will check the Bank Employee Login")
	public void bankLoginTest()
	{
		boolean res;
		PrimusBankHome phome = new PrimusBankHome();
		phome.brname = "Ameerpet";
		phome.bnuid = "harry";
		phome.bnpwd = "harry";
		res = phome.bankerLogin(phome.brname, phome.bnuid, phome.bnpwd);
		Assert.assertTrue(res);
		BankerHomePage bhome = new  BankerHomePage();
		bhome.bankerLogout();
	}
}
