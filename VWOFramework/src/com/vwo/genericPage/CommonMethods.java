package com.vwo.genericPage;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

	public class CommonMethods extends MasterPage{

		public CommonMethods() throws Exception {
			super();
			
		}
		
		//Get text of Web Element
		public void getWebElementText(String xpathKey) {
		String getTextOfWebElement = driver.findElement(By.xpath(or.getProperty(xpathKey))).getText();
		System.out.println(getTextOfWebElement);
		}
		
		//Click Method
		public void clickWebElement(String xpathKey) {
	    driver.findElement(By.xpath(or.getProperty(xpathKey))).click();
		}
		
		//Clear Method
		public void clearData(String xpathKey) {
		    driver.findElement(By.xpath(or.getProperty(xpathKey))).clear();
		}
		
		//Enter Data
		public void enterData(String xpathKey, String testdata) {
		    driver.findElement(By.xpath(or.getProperty(xpathKey))).sendKeys(td.getProperty(testdata));
		}
		
		//Mouse Hover
		public void moveToElement(String xpathKey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathKey)))).build().perform();
		}
		
		//Click List of Web Element
		public void clickListElement(String xpathKey, String testdata) {
		List<WebElement> listOfElements = driver.findElements(By.xpath(or.getProperty(xpathKey)));
		for(int i = 0; i<listOfElements.size(); i++)
		{
			if(listOfElements.get(i).getText().equalsIgnoreCase(td.getProperty(testdata))){
				listOfElements.get(i).click();
			}
		}
		}
		
		//Select dropdown value using visible text
		public void selectDropdownValue(String xpathKey, String testdata) {
		   WebElement ele = driver.findElement(By.xpath(or.getProperty(xpathKey)));
		    Select webElem = new Select(ele);
		    webElem.selectByVisibleText(td.getProperty(testdata));
		}
		
		//ReadingExcel Data
		public void readExcelData(String xpathKey, int rowNo, int columnNo) throws Exception
		{
			File src = new File("C:\\Users\\HP\\git\\Selenium-Testing-Projects\\VWOFramework\\com.vwo.resorces\\ExcelTestdata.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(prop.getProperty("ExcelTestdata"));
			System.out.println(sh.getSheetName());
			String abc = sh.getRow(rowNo).getCell(columnNo).getStringCellValue();
			driver.findElement(By.xpath(or.getProperty(xpathKey))).sendKeys(abc);
			wb.close();
		}
		
		//Handling Explicit Wait - VisibilityOfElementLocated
		public void handleExplicitWait_visibilityOfElementLocated(String xpathKey, String testdata) {
		//Use Explicit Wit to check if password	field is visible
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty(xpathKey)))).sendKeys(td.getProperty(testdata));
		}
		
		//Handling Explicit Wit - elementToBeClickable
		public void handleExplicitWiat_elementToBeClickable(String xpathKey) {
			WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(xpathKey))));
		}
		
	/*	//Log4J
		public void handleLogger(String logClassName, String loggerText) {
			Logger logger = Logger.getLogger(logClassName);
			PropertyConfigurator.configure(prop.getProperty("log4JPropertiesFileLoc"));
		    logger.info(loggerText);
		}*/
		
		//Capture Screenshot
		public void captureScreenshot(ITestResult result) throws Exception
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				
				//Create  ref of TakeScreenshot Interface and type casting
				TakesScreenshot ts = (TakesScreenshot) driver;//Typecasting of 2 interface
			  
				//Use getScreenshotAs() to capture the screenshot in File Format
				//getScreenshotAs() method return type = FILE
				File sourceFile = ts.getScreenshotAs(OutputType.FILE);
				
				//Copy the file to specific location
				File destFolder = new File("./screenshots/" + result.getName() + ".png");
				FileUtils.copyFile(sourceFile, destFolder);
				System.out.println(result.getName()+ "method() screenshot captured");
				
			}
		}
		}
		    



