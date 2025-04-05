package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActions {
  @Test
  public void mouseactions() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions actions = new Actions(driver);
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  WebElement txtField = driver.findElement(By.id("field1"));
	  actions.scrollToElement(txtField).perform();

//	  WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Point Me']"));
	  WebElement btn = driver.findElement(By.xpath("//button[@class='dropbtn']"));
	  actions.moveToElement(btn).perform();
	  Thread.sleep(3000);
	  WebElement item2 = driver.findElement(By.linkText("Laptops']")); //Failing in this line have to chck
	  actions.click(item2).perform();
	  
	  Thread.sleep(3000);
	  actions.moveToElement(btn).click(item2).build().perform();
	  WebElement btnDbl = driver.findElement(
			  By.xpath("//button[contains(text(), 'Copy Text')]"));
	  actions.doubleClick(btnDbl).perform();
	  actions.contextClick(txtField).perform(); //Right click
	  
	  
	  //Drag and Drop
	  WebElement drag = driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  actions.dragAndDrop(drag, drop).perform();
	  
	  
	  
	  
	  
	  
  }
}
