package groupingscripts;

import org.testng.annotations.Test;

public class SampleOneTest {
  @Test(groups="featureOne")
  public void testOne() {
	  
	  System.out.println("Test 11 in SampleOne.....");
  	}
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  
	  System.out.println("Test 12 in SampleOne.....");
	  
  	}

  @Test(groups="featureThree")
  public void testThree() {
	  
	  System.out.println("Test 13 in SampleOne.....");
	  
  	}
 
  @Test(groups="featureFour")
  public void testFour() {
	  
	  System.out.println("Test 14 in SampleOne.....");
	  
  	}  

}




//featureone -- test 11, test 21, test 31 
//may have test classes in different classes and belongs to one category. we have to group it.
//configure testNG.xml file. have to run only featureone. in xml have to modify to include groups  
//<include name="featureOne"/>
//other than feature one want to run the other then have to use exclude
//<exclude name="featureOne"/>
//creating group of groups ----- define --- can define multiple in testNG.xml
//
//in the below case then common feature between them will not execute
//
//<define name="SmokeTest">
//<include name="featureOne"/>
//<include name="featureTwo"/>
//</define>	
//
//<define name="RegressionTest">
//<include name="featureOne"/>
//<include name="featureThree"/>
//<include name="featureFour"/>
//</define>	
//
//<run>
//<include name="SmokeTest"/>
//<exclude name="RegressionTest"/>
//</run>