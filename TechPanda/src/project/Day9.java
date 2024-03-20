/*  Verify Discount Coupon works correctly
 *
Test Case Description:
1. Go to http://live.techpanda.org/
2. Go to Mobile and add IPHONE to cart
3. Enter Coupon Code
4. Verify the discount generated

TestData:  Coupon Code: GURU50
Expected result:
1) Price is discounted by 5%
*/
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Day9 {
	public double GURU50;
	public static void main(String[] args) throws Exception {
		Day9 d9 = new Day9();
		d9.GURU50 = 0.05;
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Project\\driver\\chromedriver.exe" );
	WebDriver driver  = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']/li[2]//button")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='coupon_code']")).clear();
    driver.findElement(By.xpath("//input[@name='coupon_code']")).sendKeys("GURU50");
    driver.findElement(By.xpath("//button[@title='Apply']")).click();
    
    
    //Verify the Discount 
    WebElement discount = driver.findElement(By.xpath(" //table[@id='shopping-cart-totals-table']//following::tr[3]"));	
    System.out.println(discount.getText());
    
    // this is the Sub Total amount displayed (e.g. $500.00)
    String vSubTot = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")).getText().trim(); 
    
    // this is the discount amount displayed (e.g. $50.00)
    String vDiscDisp = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText().trim();
    
    // this is the Generated discount amount displayed (e.g. $475.00)
    String vDiscountedAmtDisplayed = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText().trim();
    		    
    // Remove the $ sign 
    String sSubTot = vSubTot.replaceAll("\\$", " ");                // e.g. $500.00	        
    String sDiscDisp = vDiscDisp.replaceAll("\\$", " ");            // e.g. $25.00	        
    String sDiscountedAmtDisplayed = vDiscountedAmtDisplayed.replaceAll("\\$", " "); 
    
    // Remove the - negative sign
    String sNegDisc = sDiscDisp.replaceAll("\\-", " ");              // e.g. -25.00
    
    // trim the String variables to get it ready for calculation
    String fSubTot = sSubTot.trim();                                 // e.g. $500.00	        
    String fDiscDisp = sNegDisc.trim();                              // e.g. $25.00	        
    String fDiscountedAmtDisplayed = sDiscountedAmtDisplayed.trim(); // e.g. $475.00
    
    // ***************************************************************************************************************************
    // discount amount calculations and comparisons between the derived amount against the discount amount displayed on the page
    // ***************************************************************************************************************************		    
    
    double dSubTot = Double.parseDouble(fSubTot);                                 // e.g.        $500.00
    double dDiscDisp = Double.parseDouble(fDiscDisp);                             // e.g.         $25.00
    double dDiscountedAmtDisplayed = Double.parseDouble(fDiscountedAmtDisplayed); // e.g.        $475.00
    
    // multiply the dSubTot by the GURU50 discount rate (GURU50 = 5% = 0.05) 
    double discountedAmt = (dSubTot * d9.GURU50);     // discountedAmt is the calculated discounted amount (e.g. $25.00)	
    double dDiscPrice = (dSubTot - discountedAmt); // e.g. Discounted Price (e.g. $475) = Sub Total ($500.00) less the 5% discount amount ($25.00)
    
    // ************************************************************************************************
    //   compare & assert that the displayed discount amount is equal to the derived discount amount
    // ************************************************************************************************
    // the amount of discount (e.g. $25.00 = $500 * 5%) compared to the amount of discount as displayed on the page (e.g. $25)
    if (discountedAmt == dDiscDisp){
    		System.out.println("*** Derived discount amount   = " + discountedAmt);
    		System.out.println("*** Displayed discount amount = " + dDiscDisp);
    }else
      { System.out.println("*** Derived discount amount not equal displayed discount amount ***");
    }	
    
    String string_discountedAmt = Double.toString(discountedAmt);
    String string_dDiscDisp = Double.toString(dDiscDisp);
    try {
        Assert.assertEquals(string_discountedAmt, string_dDiscDisp);
      } catch (Error e) {
    	  System.out.println("*** Derived discount amount not equal displayed discount amount ***");
    	  e.printStackTrace();	
      }
 
    // **************************************************************************************************************************************
    // compare & assert that the displayed discounted price is equal to the derived discounted price
    // derived discounted price (e.g. $475.00 = $500 less $25)) compared to the displayed discounted price ($475.00) as displayed on the page
    // **************************************************************************************************************************************
    if (dDiscPrice == dDiscountedAmtDisplayed){
		System.out.println("*** Derived discounted price   = " + dDiscPrice);
		System.out.println("*** Displayed discounted price = " + dDiscountedAmtDisplayed);
    }else
    	{ System.out.println("*** Derived discounted price not equal displayed discounted price ***");
    }	
    
    String string_dDiscPrice = Double.toString(dDiscPrice);
    String string_discountedAmtDisplayed = Double.toString(dDiscountedAmtDisplayed);
    try {
        Assert.assertEquals(string_dDiscPrice, string_discountedAmtDisplayed);
      } catch (Error e) {
    	  System.out.println("*** Derived discount amount not equal displayed discount amount ***");
    	  e.printStackTrace();	
      }
}
    
	
 
	
	}
