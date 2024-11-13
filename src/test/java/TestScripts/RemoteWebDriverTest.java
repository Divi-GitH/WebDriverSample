package TestScripts;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteWebDriverTest {
	WebDriver driver;

  @Test
  public void test() throws MalformedURLException {
	  ChromeOptions options = new ChromeOptions();
//	  options.setCapability(CapabilityType, PLATFORM_NAME, Platform.WINDOWS);
//	  
	  //java -jar selenium-server-4.26.0.jar standalone --selenium-manager true
	  String strHub = "http://";
	  
	  driver = new RemoteWebDriver(new URL(strHub), options);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Java Tutorial");
	  searchBox.submit();
	  System.out.println("page Title is..." + driver.getTitle());
	  Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
  }
}
