package project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1_Registration {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.opencart.com/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='btn btn-black navbar-btn']")).click();
	driver.findElement(By.id("input-username")).sendKeys("sundusF");
	driver.findElement(By.id("input-firstname")).sendKeys("sundus");
	driver.findElement(By.id("input-lastname")).sendKeys("firdous");
	driver.findElement(By.id("input-email")).sendKeys("sundusfirdous70@gmail.com");
	WebElement cnt = driver.findElement(By.xpath("//select[@id= 'input-country']"));
	Select countryName = new Select(cnt);
	countryName.selectByVisibleText("India");
	driver.findElement(By.id("input-password")).sendKeys("Sundus@123");
	driver.findElement(By.id("//button[text()='Register'])[1]")).click();
	
	
}
}
