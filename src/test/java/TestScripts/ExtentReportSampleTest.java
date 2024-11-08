package TestScripts;

import java.time.Duration;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSampleTest {
		WebDriver driver;
		ExtentReports extentReports;
		ExtentSparkReporter spark;
		ExtentTest extentTest;
		
		//@BeforeMethod
		@BeforeTest
			public void setupExtent() {
			 extentReports = new ExtentReports();
			 spark = new ExtentSparkReporter("test-output/SparkReport.html");
			 extentReports.attachReporter(spark);
		}
			 
@BeforeMethod
public void setup() {
			  driver = new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  
		}
		//@Test(priority=1)
		//@Test(dependsOnMethods ="seleniumSearchTC")
		@Test(alwaysRun = true, dependsOnMethods ="seleniumSearchTC")
		  public void javaSearchTC() {
			extentTest = extentReports.createTest("Java Search Test");
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
			  extentTest = extentReports.createTest("Selenium Search Test");
			  driver.get("https://www.google.com/");
			  WebElement searchBox = driver.findElement(By.name("q"));
			  searchBox.sendKeys("Selenium Tutorial");
			  searchBox.submit();
			  Assert.assertEquals("Selenium Tutorial - Google Search", driver.getTitle());
		}  
		//removed 2 @Test
		@Test
			  public void cucumberSearchTC() {
			   extentTest = extentReports.createTest("cucumber Search Test");
			  	  driver.get("https://www.google.com/");
			  	  WebElement searchBox = driver.findElement(By.name("q"));
			  	  searchBox.sendKeys("cucumber Tutorial");
			  	  searchBox.submit();
			  	  Assert.assertEquals("cucumber Tutorial - Google Search", driver.getTitle());
			  	  
			  }	  	  
		@Test
			  	public void appiumSearchTC() {
					extentTest = extentReports.createTest("appium Search Test");
			  		  driver.get("https://www.google.com/");
			  		  WebElement searchBox = driver.findElement(By.name("q"));
			  		  searchBox.sendKeys("appium Tutorial");
			  		  searchBox.submit();
			  		  Assert.assertEquals("appium Tutorial - Google Search", driver.getTitle());
		}
			 
			  	@AfterTest
			  	public void finishextent() {
			  	 extentReports.flush();
			  	}
			  	
			  	@AfterMethod
			  	public void tearDown() {
			  		driver.quit();
			  	{
		}


		}


  }