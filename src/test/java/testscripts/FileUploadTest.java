package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadTest {
  @Test
  public void uploadfile() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	  WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
	  String strPath = System.getProperty("user.dir")
			  + "/screenshots/" + "1743068531794.png";
	  addFile.sendKeys(strPath);
	  
	  driver.findElement(By.xpath("//span[text()='Start upload']")).click();
	  
	  //download we have to override the settings perferance---- map
	  
	  
	  
  }
}
