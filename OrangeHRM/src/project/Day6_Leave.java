package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6_Leave {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Scenario- To feed the Valid username and password for successfull login
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		Thread.sleep(2000);  
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		System.out.println("Login Successfully");
		
		
		
		WebElement admin = driver.findElement(By.linkText("Leave"));
		admin.click();
		List<WebElement> userRole = driver.findElements(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		userRole.get(1).click();
		
		WebElement employeeName = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		employeeName.sendKeys("sundusF");
		
		List<WebElement> status = driver.findElements(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		status.get(1).click();
		
		WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		password.sendKeys("sundusF@123");
		
		
		//Click on Leave
		WebElement leave = driver.findElement(By.linkText("Leave"));
		leave.click();
		// to move to the ApplyFrom in Leave section
		WebElement applyFrom = driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
		applyFrom.sendKeys("2024-02-27");
		// to move to the ApplyTo in Leave section
		WebElement applyTo = driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]"));
		applyTo.sendKeys("2024-03-10");
		
		List<WebElement> showLeaveWithStatus = driver.findElements(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		showLeaveWithStatus.get(2).click();
		// to select the leave type
		List<WebElement> leaveType = driver.findElements(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		leaveType.get(3).click();
		// to print the leave balance
		WebElement nameEmployee = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']"));
		nameEmployee.sendKeys("Sundus Firdous");
		// to enter from,to and comment, click on apply
		WebElement fromDate = driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
		fromDate.click();
		fromDate.sendKeys("2020-11-26");
		Actions act2=new Actions(driver);
		act2.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		
		//WebElement toDate= driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
		act2.sendKeys(Keys.TAB).perform();
		//toDate.click();
		//toDate.clear();
		act2.sendKeys("2020-11-27").perform();
		//toDate.sendKeys("2020-11-27");
		act2.sendKeys(Keys.ESCAPE).perform();
		
		
		WebElement leaveComment = driver.findElement(By.xpath("//textarea[@id='applyleave_txtComment']"));
		leaveComment.sendKeys("Please approve leave ASAP");
		
		WebElement applyButton = driver.findElement(By.xpath("//input[@id='applyBtn']"));
		applyButton.click();
		
		Thread.sleep(3000);
		
		
		driver.close();
	}

	}
