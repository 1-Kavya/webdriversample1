package testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoCompleteTest {
	
	public final String expValue = "applescript";
	
  @Test
  public void autoCompleteTest() throws InterruptedException {
	  
	  //to do auto generated method stub
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://jqueryui.com/autocomplete/");
	  WebElement frame1 = driver.findElement(By.cssSelector(".demo-frame"));
	  driver.switchTo().frame(frame1);
	  WebElement inp = driver.findElement(By.cssSelector("#tags"));
	  
	  inp.sendKeys("ap"); //input can be any
	  Thread.sleep(2000);
	  List<WebElement> items = driver.findElements(By.cssSelector("ul#ui-id-1 > li"));
	  //to know the number of matching items
	  System.out.println("Number of Matching items......."+items.size());
	  //to get the text of each item
	  for(WebElement item : items) {
		  //to get the text of each item
		  System.out.println(item.getText());
		  //to select expected value
		  if(item.getText().equalsIgnoreCase(expValue)) {
			  item.click();
			  break;
		  }
		  
		  
	  }
	  
  }
}
