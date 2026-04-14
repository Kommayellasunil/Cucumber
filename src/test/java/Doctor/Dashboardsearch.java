package Doctor;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Dashboardsearch {
	WebDriver driver = null;

	@Given("navigate NH_URL {string}")
//	public void navigate_nh_url(String string) {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
	public void launchBrowser(String url) {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(co);
//		co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://customer.nanohealthplan.com/users/sign_in");
//		driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}
//	}

	@Then("enter email6 {string} password7 {string}")
	public void enter_email6_password7(String email6, String password7) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys(email6);
		driver.findElement(By.id("user_password")).sendKeys(password7);
		Thread.sleep(15000);
	}

	@Then("sign_in_button is clicked")
	public void sign_in_button_is_clicked() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("doctor dashboard opens")
	public void doctor_dashboard_opens() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on CDPAdmin
		driver.findElement(By.xpath("(//div[normalize-space(text())='Doctor'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("searching with the calendar view")
	public void searching_with_the_calendar_view() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Calendar View'])[1]"))).click();
		Thread.sleep(1000);
		// clicking on the < button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[@class='fc-icon fc-icon-left-single-arrow'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[@class='fc-icon fc-icon-right-single-arrow'])[1]"))).click();
		Thread.sleep(1000);
		// clicking on the week
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Week'])[1]"))).click();
		Thread.sleep(1000);
		// Scroll the page down by 200 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -200)");
		Thread.sleep(2000);
		// clicking on the month
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Month'])[1]"))).click();
		Thread.sleep(1000);
		// Scroll the page down by 200 pixels
//        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -200)");
		Thread.sleep(2000);
		try {
			if (driver.findElement(By.xpath("(//a[@class='fc-more'])[1]")).isDisplayed()) {
				driver.findElement(By.xpath("(//a[@class='fc-more'])[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class='fc-event-container'])[1]/a[1]/div[1]/span[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@id='modal_consult'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
				Thread.sleep(1000);
			} else {
				driver.findElement(By.xpath("(//span[@class='fc-title'])[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@id='modal_consult'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
//		// clicking on the list view
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='List View'])[1]"))).click();
//		Thread.sleep(2000);
	}

	@Then("seaching with the list view")
	public void seaching_with_the_list_view() throws Exception {
		// clicking on the < button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space(text())='<'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the > button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space(text())='>'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the today button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space(text())='Today'])[1]")))
				.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		// clicking on the date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='date_filter'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(1000);
		// clicking on the today button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space(text())='Today'])[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the week
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Week'])[1]"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -200)");
		Thread.sleep(2000);
		// clicking on the month
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Month'])[1]"))).click();
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -200)");
		Thread.sleep(2000);
		// mouse hover on all apts & clicking
		Actions all = new Actions(driver);
		all.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All Appointments'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		all.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All Appointments'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);

		// mouse hover on doctor apts & clicking
		Actions doc = new Actions(driver);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Appointments'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Appointments'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);

		// mouse hover on op apts & clicking
		Actions op = new Actions(driver);
		op.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='OP Appointments'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		op.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='OP Appointments'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);

		// mouse hover on ip apts & clicking
		Actions ip = new Actions(driver);
		ip.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='IP Appointments'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		ip.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='IP Appointments'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
	}

	@And("searching with the ophosptial")
	public void searching_with_the_ophosptial() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='doctor-oplist'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='NanoHealth_OPD'])[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
				.sendKeys("Test");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).sendKeys("Test");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Prescription'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

//	@Then("searching with the iphospital")
//	public void searching_with_the_iphospital() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='doctor-iplist'])[1]"))).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='NanoHealth_IPD'])[2]"))).click();
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
//				.sendKeys("ip");
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
//		Thread.sleep(5000);
//		if (driver.findElement(By.xpath("(//a[@data-tooltip='Discharge Summary'])[1]")).isDisplayed()) {
//
//			// Click the link (opens new window/tab)
//			driver.findElement(By.xpath("(//a[@data-tooltip='Discharge Summary'])[1]")).click();
//
//			// Store parent window handle
//			String parentWindow = driver.getWindowHandle();
//
//			// Get all window handles
//			Set<String> allWindows = driver.getWindowHandles();
//
//			for (String window : allWindows) {
//				if (!window.equals(parentWindow)) {
//					// Switch to child window
//					driver.switchTo().window(window);
//					Thread.sleep(2000);
////					System.out.println("Switched to child window: " + driver.getTitle());
//
//					// Close child window
//					driver.close();
////					System.out.println("Child window closed");
//				}
//			}
//
//			// Switch back to parent window
//			driver.switchTo().window(parentWindow);
////			System.out.println("Back to parent window: " + driver.getTitle());
//
//		} else {
//			driver.findElement(By.xpath("(//a[@data-tooltip='Add Prescription'])[1]/img[1]")).click();
//			Thread.sleep(2000);
//		}
//
//		driver.navigate().back();
//		Thread.sleep(1000);
//		driver.navigate().refresh();
//		Thread.sleep(1000);
//	}

	@And("search with the mypatients")
	public void search_with_the_mypatients() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[@id='doctor-careteam'])[1]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
				.sendKeys("test");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("search patient using filter button")
	public void search_patient_using_filter_button() throws Exception {
		// clicking on the mycalendar
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-calendar'])[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='filter_ico'])[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[@id='q_patient_master_frst_nm_or_patient_master_lst_nm_cont'])[1]")))
				.sendKeys("Cucum");
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='filter_ico minus'])[2]"))).click();
		Thread.sleep(2000);
	}

	@And("search patient using top search bar")
	public void search_patient_using_top_search_bar() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='frst_nm'])[1]")))
				.sendKeys("Cucum" + Keys.ENTER);
		Thread.sleep(2000);
	}

}
