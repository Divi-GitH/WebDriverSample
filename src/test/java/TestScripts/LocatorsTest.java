package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LocatorsTest {
  @Test
  public void SearchNewpage() {
	  RemoteWebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();	  
	  driver.navigate().to("http://the-internet.herokuapp.com/login");
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
//	  driver.findElement(By.className("radius")).click();
//	  driver.findElement(By.className("")).click();
//	  driver.findElement(By.linkText("Elemental Selenium")).click();
	  driver.findElement(By.partialLinkText("Elemental")).click();
	  driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
	  
  }
}
