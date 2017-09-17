package com.primusbank.library;
import org.openqa.selenium.By;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import com.primusbank.constants.PrimusBankConstants;
import com.util.Generics;

public class PrimusBankHome extends PrimusBankConstants 
{
	public String admid,admpwd;
	public String brname, bnuid, bnpwd;
	public String branchname, add1, zip, country, state, city; 
	
	public boolean adminLogin(String admid, String admpwd)
	{
		String expurl,acturl;
		expurl = "adminflow";
		driver.findElement(By.id("txtuId")).sendKeys(admid);
		driver.findElement(By.id("txtPword")).sendKeys(admpwd);
		driver.findElement(By.id("login")).click();
		acturl = driver.getCurrentUrl();
		try{
		if(acturl.toLowerCase().contains(expurl.toLowerCase()))
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e )
		{
			System.out.println("Handled the unexpected Alert");
		}
		return false;
	}
	
	
	public boolean bankerLogin(String brname, String bnuid, String bnpwd)
	{
		String expurl, acturl;
		expurl= "banker";
		Generics elements = new Generics();
		elements.selector(driver, "//*[@id='drlist']", brname);
		elements.textBoxInput(driver,"//*[@id='txtuId']", bnuid);
		elements.textBoxInput(driver,"//*[@id='txtPword']", bnuid);
		driver.findElement(By.id("login")).click();
		acturl = driver.getCurrentUrl();
		if(acturl.toLowerCase().contains(expurl.toLowerCase()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean createBranch(String branchname, String add1, String zip, String country, String state, String city)
	{
		String expmsg, actmsg;
		expmsg = "New Branch with id";
		driver.findElement(By.xpath("//img[contains(@src,'images/Branches_but.jpg')]")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys(branchname);
		driver.findElement(By.id("txtAdd1")).sendKeys(add1);
		driver.findElement(By.id("txtZip")).sendKeys(zip);
		Generics list = new Generics();
		list.selector(driver, "//*[@id='lst_counrtyU']", country);
		Sleeper.sleepTightInSeconds(2);
		list.selector(driver, "//*[@id='lst_stateI']", state);
		Sleeper.sleepTightInSeconds(2);
		list.selector(driver, "//*[@id='lst_cityI']", city);
		driver.findElement(By.id("btn_insert")).click();
		actmsg = driver.switchTo().alert().getText();
		Sleeper.sleepTightInSeconds(2);
		driver.switchTo().alert().accept();
		if(actmsg.toLowerCase().contains(expmsg.toLowerCase()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
