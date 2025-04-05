package parallelscripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test
  public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 31 in SampleThree....."+id);
  	}
  
  @Test
  public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 32 in SampleThree....."+id);
	  
  	}
  
  @Test(invocationCount=6, threadPoolSize = 3, timeOut=10000)
  public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 33 in SampleThree....."+id);
	  
  	}
 
  @Test
  public void testFour() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 34 in SampleThree....."+id);
	  
  	}  

}
