package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTwoTest {
	WebDriver driver;
  @Test
  public void testOne() {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test21 in SampleTwo..." + id);
  }
  @Test(groups="FeatureOne")
  public void testTwo() {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test22 in SampleTwo..." + id);
  }
  
	  @Test(groups="FeatureOne")
	  public void testThree() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test23 in SampleTwo..." + id);
}
	  @Test(groups="FeatureOne")
	  public void testFour() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test24 in SampleTwo..." + id);
}
	  @Test(groups="FeatureThree")
	  public void testFive() {
		  System.out.println("Test25 in SampleTwo...");
}
}