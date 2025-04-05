package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioChkBoxTest {
  @Test
  public void selectRadioTest() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
//	  driver.get("https://the-internet.herokuapp.com/checkboxes");
//	  
//	  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click(); 
//	  //If selected then enter the loop and unselect the checkbox
//	  boolean isSel = driver.findElement(
//			  By.xpath("(//input[@type='checkbox'])[2]")).isSelected(); 
//	  if(isSel) {
//		  
//		  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
//	  }
	  
	  //For Radio Button -- Have to check on how to use isSelected
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  driver.findElement(By.id("male")).click();
//	  boolean selectState = driver.findElement(By.id("(male")).isSelected();
//	  if(selectState == True) {
		  
		  driver.findElement(By.id("female")).click();
//	  }
  
  
  
  
  
  }
}
