package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4_Admin {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		
		//Click on URL
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	    //Enter on Username
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		Thread.sleep(2000);  
		
		//Enter Password
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		System.out.println("Login Successfully");
		
		//Click on Admin
		Thread.sleep(2000);
		WebElement admin = driver.findElement(By.linkText("Admin"));
		admin.click();
		
		//Click on Add button
		Thread.sleep(2000);
		WebElement addButton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		addButton.click();
		Thread.sleep(2000);
		
		//Select User Role Dropdown
		WebElement userRoledrpArrow = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
		userRoledrpArrow.click();
		Thread.sleep(2000);
		
		//Select User Role
		WebElement userRole1 = driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[2]"));
		userRole1.click();
		Thread.sleep(2000);
		
		//Enter Employee Name
		WebElement employeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		employeeName.sendKeys("sundus firdous");
		
		//Select Status Dropdown
		Thread.sleep(2000);
		WebElement statusdrpArrow = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
		statusdrpArrow.click();
		Thread.sleep(2000);
		
		//Select Status
		WebElement status = driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[2]"));
		status.click();
		Thread.sleep(2000);
		
		//Enter Username
		WebElement userName1 = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		userName1.sendKeys("sundusF");
		
		//Enter Password
		WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		password.sendKeys("sundusF@123");
		Thread.sleep(2000);
		
		//Enter Confirm Password
		WebElement confirmpassword = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		confirmpassword.sendKeys("sundusF@123");
		
		//Click on Submit Button
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitBtn.click();
		Thread.sleep(2000);
		//Close current browser
		driver.close();
	}

	}
