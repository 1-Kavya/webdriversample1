package parallelscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleOneTest {
	
	WebDriver driver;
	
	  @Test
	  public void testOne() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 11 in SampleOne....."+id);
	  	}
	  
	  @Test
	  public void testTwo() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 12 in SampleOne....."+id);
		  
	  	}

	  @Test
	  public void testThree() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 13 in SampleOne....."+id);
		  
	  	}
	 
	  @Test
	  public void testFour() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 14 in SampleOne....."+id);
		  
	  	}  

	}





//thread will create a class and run internally. all methods are in same thread and will execute in sequential order
//to run the parallel we have to create required no. of threads and then run in 
//update needs to be run in the testNg.xml suite have to be updated
//Thread id provided in code for our understanding and also driver Edge and chrome for understanding
//parallel="methods" depends on how we want to execute
//Thread 4 output
//Test 13 in SampleOne.....17
//Test 14 in SampleOne.....15
//Test 11 in SampleOne.....16
//Test 12 in SampleOne.....18
//Thread 2 output
//Test 14 in SampleOne.....15
//Test 11 in SampleOne.....16
//Test 12 in SampleOne.....16
//Test 13 in SampleOne.....15

//parallel="classes"
//how many ever threads we have one class executes in one thread 
//available thread and available class would run and not sure which one. thread ensures to run the classes on the given no. of thread count
//thread 2 output
//Test 14 in SampleOne.....15
//Test 11 in SampleOne.....15
//Test 24 in SampleTwo.....16
//Test 13 in SampleOne.....15
//Test 12 in SampleOne.....15
//Test 21 in SampleTwo.....16
//Test 23 in SampleTwo.....16
//Test 22 in SampleTwo.....16

//parallel="tests"
//thread 2 output
//Test 14 in SampleOne.....15
//Test 11 in SampleOne.....15
//Test 24 in SampleTwo.....16
//Test 13 in SampleOne.....15
//Test 12 in SampleOne.....15
//Test 34 in SampleThree.....15
//Test 31 in SampleThree.....15
//Test 33 in SampleThree.....15
//Test 32 in SampleThree.....15
//Test 21 in SampleTwo.....16
//Test 23 in SampleTwo.....16
//Test 22 in SampleTwo.....16

//same test method to invoke multiple times with different data set, we can run in parallel
//we have to use (invocationCount=6) used in sample3 script. the same test runs 6 times
//want to run same test 6 times, but 3 at a time (invocationCount=6, threadPoolSize = 3)
//created a thread pool instead a thread and will execute
//we can give the timeout too (invocationCount=6, threadPoolSize = 3, timeOut=10000)
//we can use timeOut at test level or in suite level in the .xml
//timeout 10000
//Test 14 in SampleOne.....18
//Test 24 in SampleTwo.....17
//Test 11 in SampleOne.....44
//Test 13 in SampleOne.....72
//Test 12 in SampleOne.....92
//Test 34 in SampleThree.....112
//Test 31 in SampleThree.....113
//Test 33 in SampleThree.....117
//Test 33 in SampleThree.....118
//Test 33 in SampleThree.....119
//Test 33 in SampleThree.....120
//Test 33 in SampleThree.....121
//Test 33 in SampleThree.....122
//Test 32 in SampleThree.....123
//Test 21 in SampleTwo.....67

//timeout 15000
//Test 14 in SampleOne.....17
//Test 11 in SampleOne.....44
//Test 24 in SampleTwo.....18
//Test 13 in SampleOne.....63
//Test 12 in SampleOne.....92
//Test 34 in SampleThree.....111
//Test 31 in SampleThree.....112
//Test 33 in SampleThree.....116
//Test 33 in SampleThree.....117
//Test 33 in SampleThree.....118
//Test 33 in SampleThree.....119
//Test 33 in SampleThree.....120
//Test 33 in SampleThree.....121
//Test 32 in SampleThree.....122
//Test 21 in SampleTwo.....72
//Test 23 in SampleTwo.....130
//
//timeout 20000
//Test 14 in SampleOne.....17
//Test 11 in SampleOne.....44
//Test 24 in SampleTwo.....18
//Test 13 in SampleOne.....63
//Test 12 in SampleOne.....92
//Test 34 in SampleThree.....112
//Test 31 in SampleThree.....113
//Test 33 in SampleThree.....117
//Test 33 in SampleThree.....118
//Test 33 in SampleThree.....119
//Test 33 in SampleThree.....120
//Test 33 in SampleThree.....121
//Test 33 in SampleThree.....122
//Test 32 in SampleThree.....123
//Test 21 in SampleTwo.....72
//]Test 23 in SampleTwo.....131
//Test 22 in SampleTwo.....146