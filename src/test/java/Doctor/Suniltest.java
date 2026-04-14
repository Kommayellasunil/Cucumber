package Doctor;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Suniltest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver146.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		co.addArguments("--remote-allow-origins=*");
		co.setPageLoadStrategy(PageLoadStrategy.EAGER);
//				driver.manage().window().minimize();
		driver.get("https://google.com");

		// Famous football teams
		String[] teams = { "Real Madrid", "FC Barcelona", "Manchester United", "Liverpool FC", "Bayern Munich",
				"Paris Saint-Germain", "Chelsea FC", "Juventus", "AC Milan", "Arsenal FC" };

		// Pick random team
		Random random = new Random();
		String randomTeam = teams[random.nextInt(teams.length)];

		// Search in Google
		driver.findElement(By.name("q")).sendKeys(randomTeam + Keys.ENTER);

		System.out.println("Searched for team: " + randomTeam);

		// Wait to see results
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		driver.quit();
	}
}