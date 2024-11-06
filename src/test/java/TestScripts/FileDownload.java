package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileDownload {
  @Test
  public void FileDownloadTC() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
	  Thread.sleep(2000);
	  WebElement btndownload = driver.findElement (By.xpath(".//a[text()='chromedriver_win32.zip']"));
	 btndownload.click();
	 Thread.sleep(7000);
  }
}
