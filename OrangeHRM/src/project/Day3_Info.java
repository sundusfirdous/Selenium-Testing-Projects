package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3_Info {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		
		//Give URL
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    Thread.sleep(2000);
	   
	    //Enter username
	    WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		Thread.sleep(2000);
		
		//Enter Password
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("admin123");
		Thread.sleep(2000);
		
		//Click on Submit
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		System.out.println("Login Successfully");
	    Thread.sleep(2000);
	    
	    //Click on My Info
		driver.findElement(By.linkText("My Info")).click();
	    Thread.sleep(2000);
	    
	    //Clear Previous value of Textbox and Give First Name
		WebElement firstName = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']"));
		firstName.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		firstName.sendKeys("Sundus");
		Thread.sleep(2000);
		
		//Clear Previous value of Textbox of Middle Name
		WebElement middleName = driver.findElement(By.xpath("//input[@name='middleName']"));
		middleName.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));;
		Thread.sleep(2000);
		
		//Clear Previous value of Textbox and Give Last Name
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastName.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		lastName.sendKeys("Firdous");
		Thread.sleep(2000);
		
		//Clear Previous value of Textbox and Give EmployeeID
		WebElement empID = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		empID.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		empID.sendKeys("98");
		Thread.sleep(2000);
		
		//Click on Nationality Dropdown
		WebElement nationalitydrpArrow = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
		nationalitydrpArrow.click();
		Thread.sleep(2000);
		
		//Select Nationality
		WebElement nationality = driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[82]"));
		nationality.click();
		Thread.sleep(2000);
		
		//Select Marital Status
		WebElement maritalStatusdrpArrow = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
		maritalStatusdrpArrow.click();
		Thread.sleep(2000);
		WebElement maritalStatus = driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[3]"));
		maritalStatus.click();
		Thread.sleep(2000);
		
		//Date of Birth Calendar
		Actions act = new Actions(driver);
		WebElement dateOfBirth = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[2]"));
		act.moveToElement(dateOfBirth).click().build().perform();
		Thread.sleep(2000);
		WebElement dateOfBirthCalender = driver.findElement(By.xpath("//div[@class='oxd-date-input-link --clear']"));
		act.moveToElement(dateOfBirthCalender).click().build().perform();
		Thread.sleep(2000);
		act.sendKeys(dateOfBirth,"1996-28-04").build().perform();

		//Select Gender
		WebElement radioBtn = driver.findElement(By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]"));
	    radioBtn.click();

	    //Click on Save Button
		WebElement savebtn1 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		savebtn1.click();
		WebElement bloodTypedrpArrow = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]"));
		bloodTypedrpArrow.click();
		Thread.sleep(2000);
		
		//Choose Blood Type
		WebElement bloodType = driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[6]"));
		bloodType.click();
		Thread.sleep(2000);
		
		//Click on Save Button
		WebElement savebtn2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		savebtn2.click();
		
		//Close the current Browser
		driver.close();
		
	}
}
