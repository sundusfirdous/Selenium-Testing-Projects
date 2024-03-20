/*      
Test Steps:
1. Goto http://live.techpanda.org/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/
package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4 {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Project\\driver\\chromedriver.exe" );
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/");
	    driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		Thread.sleep(2000);
		List <WebElement> mobileCompare1 = driver.findElements(By.xpath("//a[text() = 'Add to Compare']"));
		System.out.println("Total Dropdown values : " + mobileCompare1.size());
		mobileCompare1.get(0).click();
		Thread.sleep(2000);
		List <WebElement> mobileCompare2 = driver.findElements(By.xpath("//a[text() = 'Add to Compare']"));
		System.out.println("Total Dropdown values : " + mobileCompare2.size());
		mobileCompare2.get(1).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text() = 'Compare']")).click();
	    Thread.sleep(2000);

	  		// Switching to New Window
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		    Thread.sleep(2000);

		    //JavascriptExecutor
	  		JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("window.scrollBy(0, 500)");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[text()='Close Window']")).click();
	        Thread.sleep(2000);

	        // switching to new window
		    for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);
		    }	    
		  
	        driver.quit();
		
	}
}
