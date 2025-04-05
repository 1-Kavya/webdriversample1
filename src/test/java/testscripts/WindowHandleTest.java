package testscripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WindowHandleTest {
  @Test
  public void windowpop() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.get("https://demoqa.com/browser-windows");
	  String parentwin = driver.getWindowHandle();
	  Thread.sleep(3000);
	  
	  WebElement txtField = driver.findElement(By.xpath("//span[contains(text(), 'Alerts')]"));
	  actions.scrollToElement(txtField).perform(); //can use scroll to element or scroll by amount
	  
//	  actions.scrollByAmount(100,1200).perform();
	  System.out.println("Parent Win......"+parentwin);
	  
	  driver.findElement(By.id("tabButton")).click();
	  System.out.println("page title......"+driver.getTitle());

	  Set<String> wins = driver.getWindowHandles();
	  System.out.println("No. of Windows......"+wins.size());
	  for(String child : wins) {
		  System.out.println("Wind Handles......"+child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  Thread.sleep(2000);
			  String h1TagText = driver.findElement(
					  By.cssSelector("h1#sampleHeading")).getText();
			  System.out.println("Textin the tab win......"+h1TagText);
			}		  
	  }
	  
//	  driver.close();
	  driver.switchTo().window(parentwin);
	  driver.findElement(By.id("windowButton")).click();
	  
	  Set<String> popwins = driver.getWindowHandles();
	  System.out.println("No. of Windows......"+popwins.size());
	  for(String child : popwins) {
		  System.out.println("Wind Handles......"+child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  Thread.sleep(2000);
			  String h1TagText = driver.findElement(
					  By.cssSelector("h1#sampleHeading")).getText();
			  System.out.println("Textin the popup win......"+h1TagText);
			}		  
	  }
	  
	  driver.close();
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.get("https://testautomationpractice.blogspot.com/");
	  driver.quit();
	  
  }
}

//handle of all window
//driver will create unique id for all the opened windows
//using id we have to return to the opened window
//getwindownhanlde for current window
//getwindowshandles for multiple windowss
//driver.close will close the current focused window. now any action on the parent window fails though we have declared the action 
//we have to bring back the control to parent window using switch back
//driver.quit will close the entire session