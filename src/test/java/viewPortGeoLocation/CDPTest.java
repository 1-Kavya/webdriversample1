package viewPortGeoLocation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	
  @BeforeMethod
  public void setup() {
	  driver = new ChromeDriver();
	  
	  devTools = driver.getDevTools();
	  devTools.createSession(driver.getWindowHandle());
	  
  }
  
  @Test
  public void deviceModeTest () {
	  
	  Map deviceMetrics = new HashMap() {{
		  put("width", 500);
		  put("height", 1200);
		  put("deviceScaleFactor", 50);
		  put("mobile", true);
	  }};
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	  driver.get("http://selenium.dev/");
      driver.manage().window().maximize();
	  
  }
  
  
}
