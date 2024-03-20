/*  Verify you are able to change or reorder previously added product
 *  Test Data = QTY = 10
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Login in application using previously created credential
4. Click on 'REORDER' link , change QTY & click Update
5. Verify Grand Total is changed
6. Complete Billing & Shipping Information
7. Verify order is generated and note the order number

Expected outcomes:
1) Grand Total is Changed
2) Order number is generated
*/
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Day8 {
	 public String firstName = "SUNDUS";    // These testdata stuff will be placed    
	  public String lastName = "FIRDOUS";  // in a TestData EXCEL file at some stage
	  public String vEmail = "sundusfirdous1186@gmail.com";
	  public static String vPW = "Sundus@123";
	  public static String vPrice, sPrice;
public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.geko.driver","C:\\Users\\HP\\eclipse-workspace\\Project\\driver\\geckodriver.exe" );
	WebDriver driver  = new FirefoxDriver();
	driver.manage().window().maximize();
  driver.get("http://live.techpanda.org/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='footer']//following::a[@title='My Account']")).click();
	 driver.findElement(By.xpath("//label[@for='email']//following::input[1]")).sendKeys("sundusfirdous1186@gmail.com");
	 driver.findElement(By.xpath("//label[@for='email']//following::input[2]")).sendKeys("Sundus@123");
	 driver.findElement(By.xpath("//button[@title='Login']")).click();
	 driver.findElement(By.linkText("MY ORDERS")).click();
	 driver.findElement(By.linkText("REORDER")).click();
	 // *  Get the Grand Total Price 
	    vPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	    
	 driver.findElement(By.xpath("//input[@title='Qty']")).clear();
	 driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("10");
	 driver.findElement(By.xpath("//button[@title='Update']")).click();
	    
   // this will check the Grand Total price after being updated 			    
	  sPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();			    
	    System.out.println("sPrice ="+sPrice);
	    
	    // verify the before and after Grand Total price, to confirm it has changed
	    if (vPrice== sPrice){
	    	   System.out.println("*** Grand Total price has not changed. ***");
	    }else{
		       System.out.println("*** Grand Total price has changed. ***");
		}
	    
	    driver.findElement(By.xpath("//ul[@class='checkout-types top']//button")).click();
	    driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@title='Credit Card (saved)']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@title='Name on Card']")).sendKeys("Sundus Firdous");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.xpath("//select[@title='Credit Card Type']"))).selectByVisibleText("American Express");
	    Thread.sleep(1000);
	    
	  
driver.findElement(By.xpath("//input[@title='Credit Card Number']")).sendKeys("4897346775756");
Thread.sleep(1000);
new Select(driver.findElement(By.xpath("//select[@name='payment[cc_exp_month]']"))).selectByVisibleText("06 - June");
Thread.sleep(1000);
new Select(driver.findElement(By.xpath("//select[@name='payment[cc_exp_year]']"))).selectByVisibleText("2027");
Thread.sleep(1000);
driver.findElement(By.xpath("//input[@title='Card Verification Number']")).sendKeys("1827");
Thread.sleep(1000);
driver.findElement(By.xpath("//input[@title='Check / Money order']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@title='Place Order']")).click();

Thread.sleep(2000);  
//Verify Order is generated. Note the order number 
WebElement orderNum = driver.findElement(By.xpath("//p[text()='Your order # is: ']/a"));	
System.out.println("Your order # is: "+orderNum.getText());
	

Thread.sleep(2000);
driver.quit();

} 
}
