package groupingscripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test(groups="featureOne")
  public void testOne() {
	  
	  System.out.println("Test 31 in SampleThree.....");
  	}
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  
	  System.out.println("Test 32 in SampleThree.....");
	  
  	}
  
  @Test(groups="featureThree")
  public void testThree() {
	   
	  System.out.println("Test 33 in SampleThree.....");
	  
  	}
 
  @Test(groups="featureFour")
  public void testFour() {
	  
	  System.out.println("Test 34 in SampleThree.....");
	  
  	}  

}
