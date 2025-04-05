package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDOMTest {
  @Test
  public void shadowdom() {
	  
	  WebDriver driver = new ChromeDriver();	  
	  driver.manage().window().maximize();
	  
	  
	  
	  driver.get("https://the-internet.herokuapp.com/shadowdom");
	  WebElement shadowHost = driver.findElement(By.xpath("(//my-paragraph)[1]"));
	  SearchContext context = shadowHost.getShadowRoot();
	  WebElement txt = context.findElement(By.cssSelector("slot[name='my-text']"));
	  System.out.println(txt.getText());
	  
	  String strtxt = driver.findElement(By.xpath("//span[contains(text(), 'different')]")).getText();
	  System.out.println(strtxt);
	  
	  	  
	  //under the shadow root we see the element (like a bank account no/balance amt/ not shown on UI)
	  //my paragraph -- shadow --- root -- span -- slot
	  //Shadow root ends with style and root. we have to use it using the context
	  //we can see shadow roots with same name. so used the index to select the first element
	  //shadow path support only in cssselector and not in xpath
	  
  }
}