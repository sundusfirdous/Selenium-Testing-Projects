package javaPackage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class WebDriverManager1 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
	//Add latest WebDriverManager Dependency into pom.xml file
		
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.facebook.com/");
	}

}
