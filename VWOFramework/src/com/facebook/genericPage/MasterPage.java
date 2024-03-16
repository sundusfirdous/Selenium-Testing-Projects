package com.facebook.genericPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaPackage.Log4JLogging;

public class MasterPage{

	public static WebDriver driver;
	public static Logger logger;
	public Properties prop;
	public Properties or;
	public Properties td;
	
	//Constructor Implementation
	public MasterPage()throws Exception
	{
		
		
		
		//Create Logger Instance
				logger = Logger.getLogger("Log4JLogging");
				
				//Configure log4j properties file
				PropertyConfigurator.configure("./log4j.properties");
			
				
				
				
				
		//Configuration properties file implementation
		FileInputStream ip = new FileInputStream("./src/com/facebook/repository/configuration.properties");
		prop = new Properties();
		prop.load(ip);
		
		//locators properties file implementation
		FileInputStream fs = new FileInputStream("./src/com/facebook/repository/locators.properties");
		or = new Properties();
		or.load(fs);
		
		//Testdata properties file implementation
		FileInputStream ts = new FileInputStream("./src/com/facebook/repository/testdata.properties");
		td = new Properties();
		td.load(ts);
		
		//Added latest WebDriverManager Dependency (5. 5. 3) into pom.xml
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}	else if (prop.getProperty("browser").equalsIgnoreCase("edge")){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	   }	else if (prop.getProperty("browser").equalsIgnoreCase("firefox")){
	   WebDriverManager.firefoxdriver().setup();
	   driver = new FirefoxDriver();
		
	  }	else if (prop.getProperty("browser").equalsIgnoreCase("ie")){
	   WebDriverManager.iedriver().setup();
	   driver = new InternetExplorerDriver();
	   
	  }	else if (prop.getProperty("browser").equalsIgnoreCase("chrome2")){
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\com\\com.facebook.drivers\\chromedriver.exe");
		   driver = new ChromeDriver();	
	  } else {
		  System.out.println("No Browser Details Found");
	  }
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
		
	}
	
		
	

}

