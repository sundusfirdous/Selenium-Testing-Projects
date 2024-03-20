package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5_LoginWithMyCredentials {
public static void main(String[] args) throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Scenario- To feed the Valid username and password for successfull login
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("sundusF");
		Thread.sleep(2000);  
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("sundusF@123");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		System.out.println("Login Successfully");
		Thread.sleep(2000);
		driver.close();
		
	}
}
