package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplictWaitTest {
  @Test
  public void waitTest() {
	  
	  WebDriver driver = new ChromeDriver();
 	  driver.manage().window().maximize();
	  driver.get("https://uitestingplayground.com/ajax");
	  
	  driver.findElement(By.id("details-button")).click(); //given for unsecure
	  driver.findElement(By.id("proceed-link")).click(); //given for unsecure
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  
//	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ajaxButton")));
	  driver.findElement(By.id("ajaxButton")).click();
	  
//	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#context > p"))));
	  
	  wait.until(ExpectedConditions.textToBePresentInElement(
			  driver.findElement(By.cssSelector("div#content")), "Data loaded with AJAX get request."));
	  
	  String strTxt = driver.findElement(By.cssSelector("div#content")).getText();
	  System.out.println(strTxt);
	  
	  
	  
  }
}
