package testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertPopup {
  @Test
  public void variousAlerts() throws InterruptedException {
	  
	  SoftAssert softAssert = new SoftAssert(); //declared here can be used anywhere in the code
	  
	  WebDriver driver = new ChromeDriver();	  
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  
	  driver.findElement(By.id("alertBtn")).click();
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  Assert.assertEquals(alert.getText(),"I am an alert box!"); //confirm if the text is excepted. Hard assert
	  softAssert.assertEquals(alert.getText(), "I am an alert box!!");
	  alert.accept();
	  
	  
	  driver.findElement(By.id("confirmBtn")).click();
	  Alert confirm = driver.switchTo().alert();
	  System.out.println(confirm.getText());
//	  Assert.assertEquals(alert.getText(),"Press a button"); //failed when used this as expected [Press a button] but found [Press a button!]
	  softAssert.assertEquals(confirm.getText(), "Press a button"); //if provided the correct text then no failure and all pass. 
	  confirm.dismiss();
	  
	  driver.findElement(By.id("promptBtn")).click();
	  Alert prompt = driver.switchTo().alert();
	  System.out.println(prompt.getText());
	  prompt.sendKeys("Hello Kavya!!");
	  Thread.sleep(5000);
	  prompt.accept();
	  
//	  System.out.println(confirm.getText()); -- check on how to print the text Hello Kavya! how are you ? text from the page
	  
	  
	  
	  softAssert.assertAll();
	  
	  
	  
	  //inbuild methods in alert class
	  //send keys for prompt alert, get alert text, clikc on ok/cancel
	  //create alert object and invoke methods to perform actions
	  //checkpoint assert confirmation is mandatory in testing  
	  //without assert it just browser testing
	  //In case of any failure but still want to proceed have to use soft assert in other case used is hard assert 
	  //when mismatch in text in confirmation scripts has to fail but passed, so have to use softAssert.assertall at the end
	  //when assert all is used, scripts would execute but will be able to see the failure too
	  //The following asserts failed:
	  //expected [I am an alert box!!] but found [I am an alert box!],
	  //expected [Press a button] but found [Press a button!]
	  
	  
	  
  }
}
