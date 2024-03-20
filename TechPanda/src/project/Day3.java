/*      
Test Steps:
1. Goto http://live.techpanda.org/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed 
   "The requested quantity for "Sony Xperia" is not available.
5. Verify the error message
6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify cart is empty
*/
package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Day3 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Project\\driver\\chromedriver.exe" );
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/");
	    driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		Thread.sleep(2000);
		List <WebElement> mobile2 = driver.findElements(By.xpath("//div[contains(text(),'T')]//following::select[1]/option"));
		System.out.println("Total Dropdown values : " + mobile2.size());
		mobile2.get(2).click();
		Thread.sleep(2000);
		
		List <WebElement> addToCart = driver.findElements(By.xpath("//button[@title = 'Add to Cart']"));
		System.out.println("Total Dropdown values : " + addToCart.size());
		addToCart.get(0).click();
		Thread.sleep(2000);
		
		//To clear previous text from Text box
		driver.findElement(By.xpath("//input[@title = 'Qty']")).clear();
		//Passing new valUe to Text Box
		driver.findElement(By.xpath("//input[@title = 'Qty']")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@title= 'Update']")).click();
		
		//Verify an Error Message [My Method]
		//Expected error text
		String exp = "* The maximum quantity allowed for purchase is 500.";
		//Identify actual error
		WebElement errorMsg1 = driver.findElement(By.xpath("//p[@class= 'item-msg error']"));
		String act = errorMsg1.getText();
		System.out.println("Error Message : "+ act);
		//verify message with assertion
	    Assert.assertEquals(exp, act);
	    System.out.println("ERROR Text Verified");
		Thread.sleep(2000);
		
		//To Fetch the text
		WebElement  errorMsg2 = driver.findElement(By.xpath("//span[contains(text(),'So')]"));
		System.out.println(errorMsg2.getText());
	    driver.findElement(By.xpath("//span[contains(text(),'Em')]")).click();
	    WebElement cartEmpty1 = driver.findElement(By.xpath("//h1[contains(text(),'S')]"));
		System.out.println(cartEmpty1.getText());
	   
		
		//Verify Message
		//Expected error text
		String exp1 = "You have no items in your shopping cart.";
		//Identify actual  Message
		WebElement cartEmpty2 = driver.findElement(By.xpath("//h1[contains(text(),'S')]//following::p[1]"));
		String act1 = cartEmpty2.getText();
	    System.out.println("Cart Message : " + act1);	    
	   //verify message with assertion
	    Assert.assertEquals(exp1, act);
	    System.out.println("Empty cart Text Verified");
		Thread.sleep(2000);
		
		
		driver.quit();
		 
}

}
