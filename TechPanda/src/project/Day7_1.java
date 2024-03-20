/*Test Steps:
1. Go to http://live.techpanda.org/
2. Click on My Account link
3. Login in application using previously created credential 
4. Click on 'My Orders'
5. Click on 'View Order'
6. *** note: After steps 4 and 5, step 6 "RECENT ORDERS" was not displayed
   Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
7. Click on 'Print Order' link
8. *** note: the link was not found. 
   Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
9. *** unable to execute this step, due to issue with step 8 issue
   Click on 'Save' button and save the file in some location.
10. *** unable to execute this step, due to steps 8 and 9 issues.
    Verify Order is saved as PDF

*/
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Day7_1 {
	public static String firstName = "SUNDUS";    // These testdata stuff will be placed    
	public static  String lastName = "FIRDOUS";  // in a TestData EXCEL file at some stage
	public  static String vEmail = "sundusfirdous1186@gmail.com";
	public static String vPW = "Sundus@123";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.geko.driver","C:\\Users\\HP\\eclipse-workspace\\E-commerce\\driver\\geckodriver.exe" );
		WebDriver driver  = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='footer']//following::a[@title='My Account']")).click();
		 driver.findElement(By.xpath("//label[@for='email']//following::input[1]")).sendKeys("sundusfirdous1186@gmail.com");
		 driver.findElement(By.xpath("//label[@for='email']//following::input[2]")).sendKeys("Sundus@123");
		 driver.findElement(By.xpath("//button[@title='Login']")).click();
		 driver.findElement(By.linkText("MY ORDERS")).click();
		 driver.findElement(By.linkText("VIEW ORDER")).click();

		  
		    try {
		       Assert.assertEquals("RECENT ORDERS", driver.findElement(By.cssSelector("h2")).getText());
		      } catch (Error e) {
		    	  System.out.println("*** Recent Orders failed to get displayed ***");
		    	  e.printStackTrace();	
		      }
	  
						 System.out.println("*** Recent Orders to get displayed ***");
						 
				        driver.findElement(By.linkText("Print Order")).click();   	  
				        // switching to new window                                                                             
					    for (String handle : driver.getWindowHandles()) {
					    	driver.switchTo().window(handle);	        
					    }
					    driver.quit();
}
}
