package parallelScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test
  public void testOne() {
	  System.out.println("Test21 in SampleTwo...");
  }
  @Test(groups="FeatureOne")
  public void testTwo() {
	  System.out.println("Test22 in SampleTwo...");
  }
  
	  @Test(groups="FeatureOne")
	  public void testThree() {
		  System.out.println("Test23 in SampleTwo...");
}
	  @Test(groups="FeatureOne")
	  public void testFour() {
		  System.out.println("Test24 in SampleTwo...");
}
	  @Test(groups="FeatureThree")
	  public void testFive() {
		  System.out.println("Test25 in SampleTwo...");
}
}