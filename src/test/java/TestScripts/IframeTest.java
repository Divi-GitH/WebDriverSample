package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class IframeTest {
  @Test
  public void iframeTC() {
	  WebDriver driver = new EdgeDriver();
	  driver.manage().window().maximize();
		 driver.get("https://the-internet.herokuapp.com/iframe");
		 
	 WebElement iFrame= driver.findElement(By.id("mce_0_ifr"));
		//		 driver.switchTo().frame("mce_0_ifr");
	 driver.switchTo().frame(iFrame); 
	 WebElement inputTxt = driver.findElement(By.id("tinymce"));
	 String strtxt = inputTxt.getText();
	 System.out.println("Text from Frame.... : " + strtxt);
	 
	 //switch back to main p-age
	 
	 driver.switchTo().defaultContent();
	 WebElement LinkTxt= driver.findElement(By.cssSelector("span.tox-statusbar__branding"));
	 LinkTxt.click();		
	// driver.close();
	// driver.quit();
  }
  
}
