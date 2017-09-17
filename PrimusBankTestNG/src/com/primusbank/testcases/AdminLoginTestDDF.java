package com.primusbank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.AdminHomePage;
import com.primusbank.library.PrimusBankHome;
import com.util.XLUtils;


public class AdminLoginTestDDF extends PrimusBankConstants
{
	String xlfile = "//Users//williamsharry//Documents//workspace//PrimusBank//src//com//primusbank//testdata//TestData.xlsx";
	//String xlsheet = "AdminLogin";
	int xlsheet = 1;
	int j=1;
	@Test(dataProvider ="adminData")
	public void adminLoginTest(String admid, String admpwd) throws IOException
	{
		PrimusBankHome phome = new PrimusBankHome();
		phome.admid = admid;
		phome.admpwd = admpwd;
		boolean res = phome.adminLogin(phome.admid, phome.admpwd);
		Assert.assertTrue(res);
		if(res)
		{
			XLUtils.setCellData(xlfile, xlsheet, j, 2, "Pass");
			XLUtils.setGreenColor(xlfile, xlsheet, j, 2);
		}
		else
		{
			XLUtils.setCellData(xlfile, xlsheet, j, 2, "Fail");
			XLUtils.setRedColor(xlfile, xlsheet, j, 2);
		}
		j++;
		AdminHomePage ahome = new AdminHomePage();
		ahome.adminLogout();
	}
	
	@DataProvider
	public Object[][] adminData() throws IOException
	{
		int rc = XLUtils.getRowCount(xlfile, xlsheet); 
		Object[][] data = new Object[rc][2];
		for(int i=1;i<=rc;i++)
		{
		data[i-1][0] = XLUtils.getCellData(xlfile, xlsheet,i ,0);
		data[i-1][1] = XLUtils.getCellData(xlfile, xlsheet, i, 1);
		}
		return data;
	}
	
}
