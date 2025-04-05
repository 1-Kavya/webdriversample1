package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicElemTest {
//	String expItem = "Iphone 6 32gb";
	String expItem = "Samsung galaxy s7";
	
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoblaze.com/");
	  Thread.sleep(5000);
	  List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
	  for (WebElement item:items) {
		  
		  if(item.getText().equalsIgnoreCase(expItem)) {
		  item.click();
		  break;
		  }
		  
	  }
  }
}
