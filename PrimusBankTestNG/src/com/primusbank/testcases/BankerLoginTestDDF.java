package com.primusbank.testcases;
import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.BankerHomePage;
import com.primusbank.library.PrimusBankHome;
import com.util.XLUtils;

public class BankerLoginTestDDF extends PrimusBankConstants
{
	String xlfile = "//Users//williamsharry//Documents//workspace//PrimusBank//src//com//primusbank//testdata//TestData.xlsx";
	int xlsheet = 0;
	int j = 1;
	@Test(dataProvider = "loginData")
	public void bankerLoginTest(String branchname, String brname, String bnpwd ) throws IOException
	{
		boolean res;
		PrimusBankHome phome = new PrimusBankHome();
		phome.branchname = branchname;
		phome.brname = brname;
		phome.bnpwd = bnpwd;
		res = phome.bankerLogin(phome.branchname, phome.brname, phome.bnpwd);
		Assert.assertTrue(res);
		if(res)
		{
			XLUtils.setCellData(xlfile, xlsheet, j, 3, "Pass");
			XLUtils.setGreenColor(xlfile, xlsheet, j, 3);
		}
		else
		{
			XLUtils.setCellData(xlfile, xlsheet, j, 3, "Fail");
			XLUtils.setRedColor(xlfile, xlsheet, j, 3);
		}
		j++;
		BankerHomePage bhome = new BankerHomePage();
		bhome.bankerLogout();
	
	}
	@DataProvider
	public Object[][] loginData() throws IOException
	{
		int rc = XLUtils.getRowCount(xlfile, xlsheet);
		System.out.println(rc);
		Object[][] data = new Object[rc][3];
		for(int i =1;i<=rc;i++)
		{
			data[i-1][0] = XLUtils.getCellData(xlfile, xlsheet, i, 0);
			data[i-1][1] = XLUtils.getCellData(xlfile, xlsheet, i, 1);
			data[i-1][2] = XLUtils.getCellData(xlfile, xlsheet, i, 2);
			
		}
		return data;
	}
}
