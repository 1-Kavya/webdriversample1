package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageLoadTest {
  @Test
  public void pageLoad() {
	  
	  WebDriver driver = new ChromeDriver();
 	  driver.manage().window().maximize();
 	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //if not displayed in this particular time then throws exception
	  driver.get("https://uitestingplayground.com/");
	  
	  driver.findElement(By.id("details-button")).click(); //given for unsecure
	  driver.findElement(By.id("proceed-link")).click(); //given for unsecure
	  
	  driver.findElement(By.linkText("Load Delay")).click();
	  driver.findElement(By.cssSelector("button#btn btn-primary")); //This is failing have to check later
	  
  }
}
