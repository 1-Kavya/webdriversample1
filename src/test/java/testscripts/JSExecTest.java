package testscripts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecTest {
  @Test
  public void test() throws InterruptedException {
	  //JAvaScript Executor
	  
	  
	  WebDriver driver = new ChromeDriver();	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.manage().window().maximize(); 
	  driver.get("https://testautomationpractice.blogspot.com/");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  String strTitle = (String) js.executeScript("return document.title");
	  System.out.println(strTitle);
	  WebElement inpName = (WebElement) js.executeScript("return document.getElementById('name')"); 
	  inpName.sendKeys("TestUser");
	  WebElement inpEmail = (WebElement) js.executeScript("return document.getElementById('email')");
	  inpEmail.sendKeys("testuser.com");
	  Thread.sleep(500);
	  js.executeScript("window.scrollBy(100, document.body.scrollHeight)");
	  WebElement inpInput = (WebElement) js.executeScript("return document.getElementById('input3')");
	  inpInput.sendKeys("Kavya");
	  
	  
	  
	  
	  
	  
  }
}



//In JavaScript (Console)
//Entire page is considered as Window or document
//forward and backward browser navigations using history history.go history.minus (previous)
//plus 1 2  goes 2 pges forwardbackward based on commands
//scroll to particular position or pass on the positions
//getelementsbyid or name or class 

