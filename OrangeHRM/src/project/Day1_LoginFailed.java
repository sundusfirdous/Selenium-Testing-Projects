package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1_LoginFailed {
	public static void main(String[] args) throws Exception {
		
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	// Scenario- To feed the wrong password and check for error message
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	Thread.sleep(2000);
	
	WebElement userName = driver.findElement(By.name("username"));
	userName.sendKeys("Admin");
	Thread.sleep(2000);  
	WebElement pass = driver.findElement(By.name("password"));
	pass.sendKeys("admin5675");
	Thread.sleep(2000);
	WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	login.click();
	
	String expectedMess="Invalid credentials";
	Thread.sleep(2000);
	WebElement acmessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
	String actualMess=acmessage.getText();
	
	if(actualMess.equals(expectedMess))
	{
		System.out.println("PASS");
	}
	else {
		System.out.println("FAIL");		
	}
	
	driver.close();
	
}
	
}
