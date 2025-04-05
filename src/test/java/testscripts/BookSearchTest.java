package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookSearchTest {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
//	@BeforeTest
	public void setup(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
		}
		else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	      driver.manage().window().maximize();
	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	      driver.get("https://danube-webshop.herokuapp.com/");
		
	}
	
	
	@AfterMethod
//	@AfterTest
public void teardown() {
driver.close();
 
	}
	
	
  @Test
  public void crimeNovelSearch() {
//      driver.get("https://danube-webshop.herokuapp.com/");
      driver.findElement(By.xpath("//a[contains(text(), 'Crime & Thrillers')]")).click();
      String strURL = driver.getCurrentUrl();
      Assert.assertTrue(strURL.contains("crime"));
	  
		}


	@Test(alwaysRun = true, dependsOnMethods = "crimeNovelSearch")
	public void HorrorSearch() {
//	  driver.get("https://danube-webshop.herokuapp.com/");
	  driver.findElement(By.xpath("//a[contains(text(), 'Horror')]")).click();
	  String strURL = driver.getCurrentUrl();
	  Assert.assertTrue(strURL.contains("horror"));
			}

  
//  @Test(priority=1)
  public void StoriesSearch() {
	  
	  
//      driver.get("https://danube-webshop.herokuapp.com/");
      driver.findElement(By.xpath("//a[contains(text(),'Novels & Stories')]")).click();
      String strURL = driver.getCurrentUrl();
      Assert.assertTrue(strURL.contains("novel"));
  		}
 

//	@Test
	public void fantasySearch() {
//	  driver.get("https://danube-webshop.herokuapp.com/");
	  driver.findElement(By.xpath("//a[contains(text(), 'Fantasy')]")).click();
	  String strURL = driver.getCurrentUrl();
	  Assert.assertTrue(strURL.contains("fantasy"));
			}
	
	
	
}




//before and after test initialize the browser and all the test methods will be executed in single browser
//before and after method will initialize the browser and for every test  new browser will be opened
//dependsOnMethods -- if the dependent method fails,then only the dependent test will run and the other test will be skipped
//if dependendsOnMethod passed or fails but want to run the current scenario then use true (alwaysRun = true, dependsOnMethods = "...") 
//(priority=1)
//(enabled=false)






//want to run in differentbrowser.Instead of giving in the methods.we can create Parameter in testng.xml file 
//define the parameter before the method in script.
//parameter is helpful for cross browser testing. while browser initialization is done in testNG.XML file
//Paramters imported from testNG annotations package