package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExpWaitTest {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("http:/uitestingplayground.com/ajax");
//	  Thread.sleep(2000);
	  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  driver.findElement(By.id("ajaxButton")).click();
	  wait.until(ExpectedConditions.textToBePresentInElement(
			  driver.findElement(By.cssSelector("div#content")),"Data loaded with AJAX get request"));
	  
	  
	  String strtxt = driver.findElement(By.cssSelector("div#content")).getText();
	  System.out.println(strtxt);
  }
}
