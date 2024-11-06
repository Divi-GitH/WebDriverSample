package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ToolTipTest {
  @Test
  public void ToolTipTC() {
	  WebDriver driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
		 driver.get("https://jqueryui.com/tooltip/");
		 driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		 
		 driver.findElement(By.id("age")).sendKeys(Keys.ARROW_DOWN);
		 actions.moveToElement(driver.findElement(By.id("age"))).perform();
		 String strtxt = driver.findElement(By.className("ui-tooltip-content")).getText();
		 System.out.println("Text from Frame.... : " + strtxt);
		 WebElement age = driver.findElement(By.id("age"));
		 age.sendKeys("28");
  }
}
