package com.vwo.tests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import com.vwo.genericPage.MasterPage;
import com.vwo.pages.LoginPage;

public class LoginTest {

	@Test
	public void loginTest() throws Exception
	{
		LoginPage lp = new LoginPage();
		
		try {
			lp.clickEmail();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			lp.enterEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.clickPassword();
		lp.enterPassword();
		lp.getFacebookText();
		Thread.sleep(3000);
		lp.clearEmail();
		Thread.sleep(3000);
		try {
			lp.readExcelData("EmailorPhone", 3, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(3000);
		lp.clearPassword();
		Thread.sleep(3000);
		try {
			lp.readExcelData("Password", 3, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void takeScreeshot(ITestResult result2) throws Exception{
	LoginPage lp = new LoginPage();
	lp.captureScreenshot(result2);
	}
		@AfterClass
	public static void closeLoginPage()
	{
		MasterPage.driver.close();
	}
	
}
