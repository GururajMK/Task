package Test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Set;
import javax.print.event.PrintJobListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Shop {
	
	@Test
	public void Watches() throws InterruptedException {
		
		System.setProperty("webDriver.chrome.driver", "C:\\Users\\india\\eclipse-selenium workspace\\Amazon\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&useRedirectOnSuccess=1&signIn=1&action=sign-out&ref_=nav_AccountFlyout_signout&");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Fastrack Analog Black Dial Men's Watch-NL3147KM01/NN3147KM01/NP3147KM01");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Fastrack Analog Black Dial Men's Watch-NL3147KM01/NN3147KM01/NP3147KM01\"]")).click();
		
		Set<String> s = driver.getWindowHandles();
		ArrayList<String> ar = new ArrayList<>(s);
		
		driver.switchTo().window((String)ar.get(1));
		
		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.switchTo().window((String)ar.get(0));
		
	    Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/71CEEzbDS-L._AC_UL400_.jpg']")).click();
		
		Set<String> st = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<>(st);
		
		driver.switchTo().window((String)al.get(2));
		
	    driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
	    
	    Thread.sleep(3000);
		
	    driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
	    driver.findElement(By.xpath("//span[@id='sc-buy-box-ptc-button']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("9113203701");
	    driver.findElement(By.xpath("//span[@id='continue']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Guru@1999");
	    driver.findElement(By.xpath("//span[@id='auth-signin-button']")).click();
	    WebElement ele = driver.findElement(By.xpath("//td[@class='a-color-price a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']"));
	 
	    System.out.println("Expected Amount = 5000.00");
	    System.out.println("Actual amount =" +ele.getText());
	    
	    
	    assertEquals( ele.getText(), 5000);
	    
	    driver.close();
	    
    	}

}

