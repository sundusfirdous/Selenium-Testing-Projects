package project;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Day1 {
	public static void main(String[] args) throws Exception {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\E-commerce\\driver\\chromedriver.exe" );
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/");
	    System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
			
		//1st way dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'T')]//following::select[1]/option[2]")).click();
			
		//2nd way dropdown
		WebElement mm = driver.findElement(By.xpath("//div[contains(text(),'T')]//following::select[1]"));
		Select mobile1 = new Select(mm);
		Thread.sleep(2000);
		mobile1.selectByVisibleText("Name");
			
		//3rd way dropdown
		List <WebElement> mobile2 = driver.findElements(By.xpath("//div[contains(text(),'T')]//following::select[1]/option"));
		System.out.println("Total Dropdown values : " + mobile2.size());
		mobile2.get(1).click();
		Thread.sleep(2000);
		    
		driver.quit();
			
		}

	}



