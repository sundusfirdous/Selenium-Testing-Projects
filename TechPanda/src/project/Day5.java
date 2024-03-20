/*     Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.  
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST 
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully. 

*/
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Day5 {
	public static String firstName = "SUNDUS";    // Firstname and Lastname will be placed    
    public  static String lastName = "FIRDOUS";  // in a TestData EXCEL file at some stage
	  

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Project\\driver\\chromedriver.exe" );
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/");
		Thread.sleep(2000);
  
		 driver.findElement(By.xpath("//div[@class='footer']//following::a[@title='My Account']")).click();
		 
		 
		 driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// switching to new window
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    }
		    driver.findElement(By.id("firstname")).clear();
		 driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("SUNDUS");		
		 
		 driver.findElement(By.id("lastname")).clear();
		 driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("FIRDOUS");
		    driver.findElement(By.id("email_address")).clear();
		 driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("sundusfirdous1186@gmail.com");
		 driver.findElement(By.id("password")).clear();
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sundus@123");
		 driver.findElement(By.id("confirmation")).clear();
		 driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("Sundus@123");
			
			 // 4. Click Register
			    driver.findElement(By.xpath("//button[@title='Register']//span[text()='Register']")).click();
			    Thread.sleep(2000);
			 // switching to new window
			    for (String handle : driver.getWindowHandles()) {
			    	driver.switchTo().window(handle);
			    	}
			    // 5. Verify Registration is done. Expected account registration done.
			    String vWelcome = ("WELCOME, " + firstName + " " + lastName + "!");
			    String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
			   Assert.assertEquals(tWelcome, vWelcome);
			    System.out.println("tWelcome = "+tWelcome);
		
		    // 6. Go to TV menu	    
		    driver.findElement(By.xpath(".//*[@id='nav']/ol/li[2]/a")).click();
		    Thread.sleep(2000);
		    
		    // switching to new window
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		    
		    // 7. Add product in your wish list - use product - LG LCD	    
		    driver.findElement(By.xpath("//li/a[@class='link-wishlist']")).click();
		    
		    Thread.sleep(2000);
		    
		    // switching to new window
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		    
		    // 8. Click SHARE WISHLIST 
		    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		    
		    Thread.sleep(2000);
		    
		    // switching to new window
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		    
		    // 9. In next page enter Email and a message and click SHARE WISHLIST
		    driver.findElement(By.id("email_address")).clear();
		    driver.findElement(By.id("email_address")).sendKeys("support@guru99.com");
		    driver.findElement(By.id("message")).clear();
		    driver.findElement(By.id("message")).sendKeys("Hey Sundus!! this LCD TV looks ok, check it out !!.. cheers .. Berry");
		    
		    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		    // the above click will still be in the same page as prior page, so no need take another handle to another window	    
		    
		    Thread.sleep(2000);
		    
		    // 10. Check wishlist is shared. Expected wishlist shared successfully. 
		    String vWishList = "Your Wishlist has been shared.";
		    String wishList = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
		    Assert.assertEquals(vWishList, wishList);
		    System.out.println("wishList = "+wishList);
		  	    	
		    	
			   
		    Thread.sleep(2000);
		    driver.quit();
		  }
		
	
			
		  
		}
