package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteWebSampleTest {
	RemoteWebDriver driver;
	
	@Test
	public void storiessearch() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
//		options.setBrowserVersion("120");
//		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		
		String strhub = "http://10.0.12.11:4444";
		
		driver = new RemoteWebDriver(new URL(strhub), options);
		
	      driver.manage().window().maximize();
	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	      driver.get("https://danube-webshop.herokuapp.com/");
		  driver.findElement(By.xpath("//a[contains(text(), 'Horror')]")).click();
		  String strURL = driver.getCurrentUrl();
		  Assert.assertTrue(strURL.contains("horror"));
		  driver.close();
		  
	}
}
