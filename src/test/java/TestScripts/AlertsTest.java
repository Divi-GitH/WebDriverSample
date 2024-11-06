package TestScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AlertsTest {
  @Test
  public void AlertTest() throws InterruptedException {
	  WebDriver driver = new EdgeDriver();
	  Actions actions =  new Actions(driver);
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/alerts");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("alertButton")).click();
	  Alert alert = driver.switchTo().alert();
	  System.out.println("Alert Text... "+ alert.getText());
	  alert.accept();
	  
	  //Handling Confirmation Alert
	  
	  WebElement confirmBtn = driver.findElement(By.id("confirmButton"));
	  actions.scrollToElement(confirmBtn).perform();
	  Thread.sleep(3000);
	  confirmBtn.click();
	  Thread.sleep(2000);
	  Alert confirm = driver.switchTo().alert();
	  System.out.println("Confirm Text... "+ confirm.getText());
	  confirm.dismiss();
	  
	  
      //Handling prompt Alert
	  
	 // driver.findElement(By.id("promptButton")).click();
	  WebElement promptBtn = driver.findElement(By.id("promtButton"));
	  actions.scrollToElement(promptBtn).perform();
	  Thread.sleep(3000);
	  promptBtn.click();
	  Thread.sleep(2000);
	  Alert prompt = driver.switchTo().alert();
	  System.out.println("prompt Text... "+ prompt.getText());
	  prompt.sendKeys("Hello Divya");
      prompt.accept();
 }
}
