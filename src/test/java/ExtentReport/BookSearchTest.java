package ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BookSearchTest {
	
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
		
	}
	
	
	@Parameters("browser")
	@BeforeMethod
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
	
	@AfterTest
	public void finishExtent() {
		extentReports.flush();
	}
	
	@AfterMethod
public void teardown() {
driver.close();
 
	}
	
	
  @Test
  public void crimeNovelSearch() {
//      driver.get("https://danube-webshop.herokuapp.com/");
	  extentReports.createTest("Crime & Thrillers Test");
      driver.findElement(By.xpath("//a[contains(text(), 'Crime & Thrillers')]")).click();
      String strURL = driver.getCurrentUrl();
      Assert.assertTrue(strURL.contains("crime"));
	  
		}


	@Test
	public void HorrorSearch() {
//	  driver.get("https://danube-webshop.herokuapp.com/");
		extentReports.createTest("Horror Test");
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

