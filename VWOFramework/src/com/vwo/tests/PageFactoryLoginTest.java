package com.vwo.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vwo.genericPage.CommonMethods;
import com.vwo.pages.PageFactoryLoginPage;

public class PageFactoryLoginTest extends CommonMethods{

	public PageFactoryLoginTest() throws Exception {
		super();
		
	}

 @Test
 public void loginTest()
 {
	 PageFactoryLoginPage pfc =  PageFactory.initElements(driver,  PageFactoryLoginPage.class); 
     pfc.enterEmail();
     pfc.enterPassword();
 
 }
}
