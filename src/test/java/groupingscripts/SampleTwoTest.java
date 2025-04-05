package groupingscripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test(groups="featureOne")
  public void testOne() {
	  
	  System.out.println("Test 21 in SampleTwo.....");
  	}
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  
	  System.out.println("Test 22 in SampleTwo.....");
	  
  	}

  @Test(groups="featureThree")
  public void testThree() {
	   
	  System.out.println("Test 23 in SampleTwo.....");
	  
  	}
 
  @Test(groups="featureFour")
  public void testFour() {
	  
	  System.out.println("Test 24 in SampleTwo.....");
	  
  	}  

}
