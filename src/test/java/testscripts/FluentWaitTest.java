package testscripts;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitTest {
  @Test
  public void f() {
	  
	  WebDriver driver = new ChromeDriver();
 	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");

	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  WebElement inpName = (WebElement) js.executeScript("return document.getElementById('name')"); 
	  inpName.sendKeys("TestUser");
	  
	  //fluent wait  total 30 and pooling means checking for every 5 seconds if found or not
	  Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)
		            .withTimeout(Duration.ofSeconds(30))
		            .pollingEvery(Duration.ofSeconds(5))
		            .ignoring(ElementNotInteractableException.class);
	  wait.until(ExpectedConditions.elementToBeClickable(inpName));
	  
	  
  }
}
