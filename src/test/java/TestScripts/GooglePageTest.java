package TestScripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GooglePageTest {
	WebDriver driver;
	private WebElement searchBox;
  /**
 * 
 */
/**
 * 
 */
@Test
  public void SearchJavaTest() {
	  
//	  ChromeOptions options = new ChromeOptions();
//	  options.addArguments("--headless");
//	  options.setBrowserVersion("115");
//	  driver = new ChromeDriver(options);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();	  
//	  driver.get("https://www.google.com/");
	  driver.navigate().to("https://www.google.com/");
	  
//	  WebElement searchBox = driver.findElement(By.id("APjFqb"));
	//  WebElement searchBox = driver.findElement(By.name("q"));
	  //WebElement searchBox = driver.findElement(By.className("gLFyf"));
	  
	//  WebElement searchBox = driver.findElement(By.tagname(""));
	  
	searchBox.sendKeys("Java Tutorial");
	  searchBox.sendKeys(Keys.ENTER);
	  System.out.println("Page Title : after back()... "+ driver.getTitle());
	  driver.navigate().forward();
	  driver.navigate().refresh();
	  System.out.println("Page Title : after forward()... "+ driver.getTitle());
	  driver.close();
  }
}
