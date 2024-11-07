package parallelScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test
  public void testOne() {
	  System.out.println("Test31 in SampleThree...");
  }
  @Test(groups="FeatureThree")
  public void testTwo() {
	  System.out.println("Test32 in SampleThree...");
  }
  
	  @Test
	  public void testThree() {
		  System.out.println("Test33 in SampleThree...");
}
	  @Test(groups="FeatureOne")
	  public void testFour() {
		  System.out.println("Test34 in SampleThree...");
}
	  @Test(groups="FeatureOne")
	  public void testFive() {
		  System.out.println("Test35 in SampleThree...");
}
}