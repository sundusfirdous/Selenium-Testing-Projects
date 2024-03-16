package com.facebook.pages;

import com.facebook.genericPage.CommonMethods;


public class LoginPage extends CommonMethods{
	
	public LoginPage() throws Exception{
		super();
	}
	
	//Click Email
	public void clickEmail(){
		clickWebElement("EmailorPhone");
	//	handleLogger("LoginPage","Clicked on Email");
		logger.info("Entered EmailorPhone");
	}
	//Enter Email
		 public void enterEmail(){
			enterData("EmailOrPhone", "TestData1");
			logger.info("Entered Email");
		}

	
	//Clear Email
     public void clearEmail(){
        clickWebElement("EmailOrPhone");
        //handleLogger("LoginPage", "Entered Password");
        logger.info("Cleared EmailOrPhone");
	}
     
	//Click Password
     public void clickPassword(){
        clickWebElement("Password");
   //     handleLogger("LoginPage", "Cleared Password");
        logger.info("Clicked Password");
	}
		
 	//Enter Password
      public void enterPassword(){
        enterData("Password", "TestData2");
        logger.info("Entered Password");
 	}
    //Clear Password
      public void clearPassword(){
         clickWebElement("Password");
         logger.info("Cleared Password");
 	}
 	
    //Click LoginButton
      public void clickLoginButton(){
         clickWebElement("LoginButton");
     //    handleLogger("LoginPage", "Clicked on Login Button");
         logger.info("Clicked on Login Button");
 	}
    //Get Text
  	public void getFacebookText(){
  		getWebElementText("FacebookText");
  	//	 handleLogger("LoginPage", "Fetched Facebook Text");
  		 logger.info("Fetched Facebook Text");
  	}
      
}
