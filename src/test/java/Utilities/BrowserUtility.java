package Utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtility {
	public static WebDriver launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver146.exe");
		// Create ChromeOptions
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.setPageLoadStrategy(PageLoadStrategy.EAGER);

		// ✅ Add preferences to auto allow camera & mic
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.media_stream_camera", 1); // 1 = Allow
		prefs.put("profile.default_content_setting_values.media_stream_mic", 1); // 1 = Allow
		prefs.put("profile.default_content_setting_values.notifications", 1); // Optional
		prefs.put("profile.default_content_setting_values.geolocation", 1); // Optional
		co.setExperimentalOption("prefs", prefs);
		// ✅ Add arguments to skip permission popup
//		co.addArguments("--use-fake-ui-for-media-stream"); // Automatically clicks "Allow"
		co.addArguments("--use-fake-device-for-media-stream"); // Use this if you
		// don't want to use real camera/mic (for CI runs)
		co.addArguments("--disable-notifications");
		co.addArguments("--disable-extensions");
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-dev-shm-usage");
		co.addArguments("--no-sandbox");
		// ✅ Launch browser
		WebDriver driver = new ChromeDriver(co);
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
//		driver.manage().window().minimize();
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		return driver;
	}

	public static BrowserUtility getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
