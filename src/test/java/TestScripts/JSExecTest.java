package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecTest {
  @Test
  public void JSExecTC() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	  driver.get("https:/demo.opencart.com/");
	  JavascriptExecutor js =(JavascriptExecutor)driver;
	  
	  String strTitle = (String)js.executeScript("return document.title");
	  System.out.println(strTitle);
	  WebElement searchBox = (WebElement)js.executeScript(
			  "return document.getElementsByName('search')[0]");
			  searchBox.sendKeys("Phone");
	  driver.findElement(By.cssSelector("#search > button")).click();
	  js.executeScript("history.go(-1)");
	  js.executeScript("window.scrollBy(10, 700)");
	  js.executeScript("window.scrollBy(10, document.body.scrollheight)");	  
  }
}
