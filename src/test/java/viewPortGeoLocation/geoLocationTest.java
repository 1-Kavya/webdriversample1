package viewPortGeoLocation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class geoLocationTest {
	ChromeDriver driver;
	DevTools devTools;
	
  @BeforeMethod
  public void setup() {
	  driver = new ChromeDriver();
	  
	  devTools = driver.getDevTools();
	  devTools.createSession(driver.getWindowHandle());
	  
  }
  
  @Test
  public void geoLocation() {
	  
	  Map deviceMetrics = new HashMap() {{
		  put("latitude", 27.664827);
		  put("longitude", -81.515755);
		  put("accuracy", 100);
	  }};
	  driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
	  driver.get("https://oldnavy.gap.com/stores");
      driver.manage().window().maximize();
	  
  }
  
}
