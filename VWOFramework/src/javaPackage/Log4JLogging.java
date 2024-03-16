package javaPackage;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4JLogging {
	public static Logger logger;
public static void main(String[] args) {
		
		//Create Logger Instance
		Logger logger = Logger.getLogger("Log4JLogging");
		
		//Configure log4j properties file
		PropertyConfigurator.configure("C:\\Users\\HP\\eclipse-workspace\\Framework2\\log4j.properties");
		
		//Open Browser Instance
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		logger.info("chrome broser instance opened");
		
		//Maximise the window
		driver.manage().window().maximize();
		logger.info("Window Maximized");
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger.info("Implicit wait given");
		
		//check if the web element  is displayed or not
		try
		{
			driver.findElement(By.id("eemail")).isDisplayed();
			logger.info("Web element found");
		}
		catch(Exception e) {
		logger.info("Failure  - Web Element not found");
			
		}
		
		
		
		
		
		

	}
}
