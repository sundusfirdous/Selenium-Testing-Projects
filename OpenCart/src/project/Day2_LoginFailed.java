package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_LoginFailed {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.opencart.com/");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[text()='Login'])[2]")).click();
	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("sundusfirdous7@gmail.com");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Sundus@123");
	driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg hidden-xs']"));

}
}
