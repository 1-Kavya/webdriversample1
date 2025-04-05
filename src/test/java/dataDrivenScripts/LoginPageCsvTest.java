package dataDrivenScripts;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginPageCsvTest {
	WebDriver driver;
	Properties prop;	
	@BeforeMethod
	public void setup() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		String strBrowser = prop.getProperty("browser");
		if (strBrowser.equalsIgnoreCase("chrome")) {
			  driver = new ChromeDriver();
		}
		else if (strBrowser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver(); 
		}
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	  
		 driver.manage().window().maximize();
	}
  
	//to use csv file for reading the data
	@Test(dataProvider = "loginData")
  public void validLogin(String strUser, String strPwd) {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id("username")).sendKeys(strUser);
	  driver.findElement(By.name("password")).sendKeys(strPwd);
	  driver.findElement(By.className("radius")).click();
	  boolean isValidUser = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
	  Assert.assertTrue(isValidUser);
	  
  	}
  
  @DataProvider(name = "loginData")
  public Object[][] getData() throws IOException, CsvValidationException {
	  String path = System.getProperty("user.dir")+"//src//test//resources//testData//loginData.csv";
	  CSVReader reader = new CSVReader(new FileReader(path));
	  String cols[];
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  while ((cols = reader.readNext()) != null) {
		  	Object record[] = { cols[0], cols[1] };
		  	dataList.add(record);	  
	  }
	  reader.close();
	  return dataList.toArray(new Object[dataList.size()][]);  
  }
  
  //read from the csv
  //pass the data using the testNG annotation (datadProvider)
  //test method should know from which provider, so have to declare at test
  
  @AfterMethod
public void teardown() {
driver.close();
	}
  
  
  
}
