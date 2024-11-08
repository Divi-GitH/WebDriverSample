package TestScripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class LocatorTNG{
	WebDriver driver;
	
   @Parameters("browser")
	@BeforeMethod
  public void setup(String StrBrowser) {
	  if(StrBrowser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
	  }else if (StrBrowser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
	@Test
	public void loginTest() {
		driver.navigate().to("http://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();

}
}
