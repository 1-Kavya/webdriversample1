package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class DropDownTest {
  @Test
  public void selectValue() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  //dropdown value selection
	  Select sel = new Select(driver.findElement(By.id("country")));
	  sel.selectByIndex(9);
//	  sel.selectByValue("canada");
//	  sel.selectByVisibleText("usa");
	  
	  //multiple selection
	  Select mulSel = new Select(driver.findElement(By.id("colors")));
	  if(mulSel.isMultiple()) {
		  mulSel.selectByIndex(0);
		  mulSel.selectByValue("yellow");
		  mulSel.selectByVisibleText("Green");
		  
		  List<WebElement> items = mulSel.getAllSelectedOptions();
		  System.out.println(items.size());
		  mulSel.deselectByValue("yellow");
		  mulSel.deselectByIndex(0);
		  mulSel.deselectByVisibleText("Green");
	  }
	  
  }
}
