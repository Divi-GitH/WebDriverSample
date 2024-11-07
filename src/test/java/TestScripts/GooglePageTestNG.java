package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GooglePageTestNG {
	WebDriver driver;
	
//@BeforeMethod
@BeforeTest
	public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
}
//@Test(priority=1)
//@Test(dependsOnMethods ="seleniumSearchTC")
@Test(alwaysRun = true, dependsOnMethods ="seleniumSearchTC")
  public void javaSearchTC() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Java Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
  }
//@Test(enabled = false)
//@Test(priority=-1)
@Test
public void seleniumSearchTC() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Selenium Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Selenium Tutorial - Google Search", driver.getTitle());
}  
//removed 2 @Test
	  public void cucumberSearchTC() {
	  	  driver = new ChromeDriver();
	  	  driver.manage().window().maximize();
	  	  driver.get("https://www.google.com/");
	  	  WebElement searchBox = driver.findElement(By.name("q"));
	  	  searchBox.sendKeys("cucumber Tutorial");
	  	  searchBox.submit();
	  	  Assert.assertEquals("cucumber Tutorial - Google Search", driver.getTitle());
	  	  
	  }	  	  

	  	public void appiumSearchTC() {
	  		  driver = new ChromeDriver();
	  		  driver.manage().window().maximize();
	  		  driver.get("https://www.google.com/");
	  		  WebElement searchBox = driver.findElement(By.name("q"));
	  		  searchBox.sendKeys("appium Tutorial");
	  		  searchBox.submit();
	  		  Assert.assertEquals("appium Tutorial - Google Search", driver.getTitle());
}
	  //@AfterMethod
	  	@AfterTest
	  	public void tearDown() {
	  		driver.quit();
	  	{
}


}
}

