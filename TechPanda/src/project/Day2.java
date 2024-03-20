/*      
Test Steps:


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
*/
package project;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day2 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Project\\driver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/");
	    driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		Thread.sleep(2000);
		List <WebElement> mobile1 = driver.findElements(By.xpath("//div[contains(text(),'T')]//following::select[1]/option"));
		mobile1.get(2).click();
		Thread.sleep(2000);
		
		//Create List - All  Mobile
	    List<WebElement> mobileName = driver.findElements(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']/li/a//following::h2/a"));//1 of 3
	    Thread.sleep(3000);
	    //Create List  - All Mobile Current Price
		 List<WebElement> currentPrice = driver.findElements(By.xpath("//span[@class = 'regular-price']"));//1 of 3
		    
		    //Using For Loop
		    Thread.sleep(3000);
		    String expMobileName = "Sony Xperia";
		    
		    for(int i = 0; i < mobileName.size(); i++)
		    
		    {
		    	if (mobileName.get(i).getText().equalsIgnoreCase(expMobileName))
		    	{
		    		System.out.println(mobileName.get(i).getText() + "====" + currentPrice.get(i).getText());
		    		mobileName.get(i).click();
		             
		             break;
		    	}
		    }
		    
		    //Using For Loop
		    Thread.sleep(3000);
		    List<WebElement> sonyXperiaName = driver.findElements(By.xpath("//div[contains(@class,'pro')]/span"));//1 of 1
		    Thread.sleep(3000);
		    List<WebElement> sonyXperiaPrice = driver.findElements(By.xpath("//span[@class= 'price']"));//1 of 1
		    Thread.sleep(3000);
	        String expMobileName1 = "Sony Xperia";
		    
		    for(int i = 0; i < sonyXperiaName.size(); i++)
		    
		    {
		    	if (sonyXperiaName.get(i).getText().equalsIgnoreCase(expMobileName1))
		    	{
		    		System.out.println(sonyXperiaName.get(i).getText() + "====" + sonyXperiaPrice.get(i).getText());
		             
		             break;
		    	}
	}
		
		    //Price of mobile Sony Xperia
		    String sonyXperiaP = driver.findElement(By.xpath("//span[@id='product-price-1']/span")).getText();//1 0f 1
		    String sonyXperiaPrice2 = driver.findElement(By.xpath("//span[@class= 'price']")).getText();
		    
		 
		    //Compare Two Products Price from different page
		    assertEquals(sonyXperiaP, sonyXperiaPrice2); 
		    System.out.println("Price Verified");
			Thread.sleep(2000);
			driver.quit();
	}

		private static void assertEquals(String sonyXperiaP, String sonyXperiaPrice2) {
			// TODO Auto-generated method stub
			
		}
		
		
}
