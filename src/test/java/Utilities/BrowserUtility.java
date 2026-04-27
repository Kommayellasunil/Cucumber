package Utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	public static WebDriver launchBrowser(String url) {
		String browser = "chrome"; // Default
		if (org.testng.Reporter.getCurrentTestResult() != null) {
			String contextBrowser = org.testng.Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
					.getParameter("browser");
			if (contextBrowser != null) {
				browser = contextBrowser.toLowerCase();
			}
		}

		WebDriver driver = null;

		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo = new FirefoxOptions();
			fo.setPageLoadStrategy(PageLoadStrategy.EAGER);

			// Firefox preferences for permissions
			fo.addPreference("permissions.default.camera", 1);
			fo.addPreference("permissions.default.microphone", 1);
			fo.addPreference("permissions.default.desktop-notification", 1);
			fo.addPreference("permissions.default.geo", 1);

			driver = new FirefoxDriver(fo);

		} else {
			// Chrome by default
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			co.setPageLoadStrategy(PageLoadStrategy.EAGER);

			// Add preferences to auto allow camera & mic
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.media_stream_camera", 1); // 1 = Allow
			prefs.put("profile.default_content_setting_values.media_stream_mic", 1); // 1 = Allow
			prefs.put("profile.default_content_setting_values.notifications", 1); // Optional
			prefs.put("profile.default_content_setting_values.geolocation", 1); // Optional
			co.setExperimentalOption("prefs", prefs);

			co.addArguments("--use-fake-device-for-media-stream");
			co.addArguments("--disable-notifications");
			co.addArguments("--disable-extensions");
			co.addArguments("--disable-infobars");
			co.addArguments("--disable-dev-shm-usage");
			co.addArguments("--no-sandbox");

			driver = new ChromeDriver(co);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url); // Now accurately hits the supplied URL instead of hardcoded
		return driver;
	}

	public static BrowserUtility getInstance() {
		// Used to avoid compile errors if calling non-statically elsewhere
		return new BrowserUtility();
	}
}
