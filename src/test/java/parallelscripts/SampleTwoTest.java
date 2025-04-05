package parallelscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTwoTest {
	WebDriver driver;
  @Test
  public void testOne() {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 21 in SampleTwo....."+id);
  	}
  
  @Test
  public void testTwo() {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 22 in SampleTwo....."+id);
	  
  	}

  @Test
  public void testThree() {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 23 in SampleTwo....."+id);
	  
  	}
 
  @Test
  public void testFour() {
	  driver = new EdgeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test 24 in SampleTwo....."+id);
	  
  	}  

}
