package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFramesTest {
  @Test
  public void switchFrames() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.get("https://jqueryui.com/tooltip/");
	  driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
//	  driver.switchTo().frame(0);
	  driver.findElement(By.id("age")).sendKeys(Keys.ARROW_DOWN);
	  actions.moveToElement(driver.findElement(By.id("age"))).perform();
	  
	  String strTxt = driver.findElement(By.className("ui-tooltip-content")).getText();//age tooltip 
	  System.out.println("Tooltip text is...."+strTxt);
	  Assert.assertEquals(strTxt, "We ask for your age only for statistical purposes.");
	  driver.findElement(By.id("age")).sendKeys("20");
	  
	  driver.switchTo().defaultContent();
	  
	  String strHeader = driver.findElement(By.tagName("h1")).getText();
	  System.out.println(strHeader);
	  
  }
}




//iframe - adds page gets embedded in the main page
//new html doc will be in the inline frame
//irctc has nested iframe. we have to switch from level1 iframe to level2 iframe
//if we are in inner frame we can use the main content using default content. Parent frame is immediate parent frame.
//arrow down used to move down similar to scroll down kinda