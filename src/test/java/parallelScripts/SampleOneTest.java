package parallelScripts;

import org.testng.annotations.Test;

public class SampleOneTest {
  @Test(invocationCount =4,threadPoolSize =2, timeOut=10000)
  public void testOne() {
	  System.out.println("Test11 in SampleOne...");
  }
  @Test(groups="FeatureOne")
  public void testTwo() {
	  System.out.println("Test12 in SampleOne...");
  }
  
	  @Test
	  public void testThree() {
		  System.out.println("Test13 in SampleOne...");
}
	  @Test(groups="FeatureOne")
	  public void testFour() {
		  System.out.println("Test14 in SampleOne...");
}
	  @Test(groups="FeatureThree")
	  public void testFive() {
		  System.out.println("Test15 in SampleOne...");
}
}