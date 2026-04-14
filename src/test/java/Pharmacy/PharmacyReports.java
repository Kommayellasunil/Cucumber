package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PharmacyReports {
	WebDriver driver = null;

	@Given("naviagate to portal {string}")
	public void launchBrowser(String url) {
//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
//	ChromeOptions co = new ChromeOptions();
//	co.addArguments("--remote-allow-origins=*");
//	driver = new ChromeDriver(co);
//	co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	driver.get("https://customer.nanohealthplan.com/users/sign_in");
//	driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);

	}

	@Then("enter username5 {string} and password6 {string}")
	public void enter_username5_and_password6(String username5, String password6) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(username5);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password6);
		Thread.sleep(10000);
	}

	@Then("click on the button sign in")
	public void click_on_the_button_sign_in() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the role as the pharmacist role")
	public void select_the_role_as_the_pharmacist_role() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting pharmacist role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("pharmacist dashboard opens click on the reports and select the receipt button")
	public void pharmacist_dashboard_opens_click_on_the_reports_and_select_the_receipt_button() throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacist_reports'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='pharmacist_receipts'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("receipt button is selected dashboard opens")
	public void receipt_button_is_selected_dashboard_opens() {

	}

	@Then("search with from and to dates")
	public void search_with_from_and_to_dates() throws Exception {
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='from-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='to-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/preceding-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='OP'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on the received at counter and close")
	public void click_on_the_received_at_counter_and_close() throws Exception {
		driver.findElement(By.xpath("(//span[@id='total'])[1]")).click();
		Thread.sleep(3000);
		// mouse hovering on the icon
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Cash'])[1]/img[1]"))).build().perform();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='totalPaymentModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@Then("tclick on the received at counter and download the report")
	public void tclick_on_the_received_at_counter_and_download_the_report() throws Exception {
//		driver.findElement(By.xpath("(//div[@id='sales_count'])[1]")).click();
//		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		// Store parent window handle
////		String parentWindow = driver.getWindowHandle();
//		// Open link in new tab (example with CTRL+Click)
//		WebElement link = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"));
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[@id='sales_count'])[1]")).click();
//		Thread.sleep(3000);
////		// Get all window handles
////		Set<String> allWindows = driver.getWindowHandles();
////
////		for (String window : allWindows) {
////			if (!window.equals(parentWindow)) {
////				// Switch to new tab
////				driver.switchTo().window(window);
////
////				// Close the new tab
////				driver.close();
////
////				// Switch back to parent tab
////				driver.switchTo().window(parentWindow);
////			}
////		}
//
////		// clicking on the invoice id
////		WebElement link1 = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"));
////		// Hold CTRL key and click (for Windows/Linux). Use Keys.COMMAND for Mac
////		Actions action1 = new Actions(driver);
////		action1.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).build().perform();
////		Thread.sleep(2000);
//
//		// Store parent window handle
////		String parentWindow1 = driver.getWindowHandle();
//		// Open link in new tab (example with CTRL+Click)
//		WebElement link11 = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]"));
//		Actions action11 = new Actions(driver);
//		action11.keyDown(Keys.CONTROL).click(link11).keyUp(Keys.CONTROL).build().perform();
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[@id='sales_count'])[1]")).click();
//		Thread.sleep(3000);
////		// Get all window handles
////		Set<String> allWindows1 = driver.getWindowHandles();
////
////		for (String window : allWindows1) {
////			if (!window.equals(parentWindow1)) {
////				// Switch to new tab
////				driver.switchTo().window(window);
////
////				// Close the new tab
////				driver.close();
////
////				// Switch back to parent tab
////				driver.switchTo().window(parentWindow1);
////			}
////		}
//		// closing popup
//		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//		Thread.sleep(2000);
	}

	@Then("click on the internal transfer and close")
	public void click_on_the_internal_transfer_and_close() throws Exception {
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the delivered and download the report")
	public void click_on_the_delivered_and_download_the_report() throws Exception {
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[2]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// Open link in new tab (example with CTRL+Click)
		WebElement link = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[2]")).click();
		Thread.sleep(3000);

		// Open link in new tab (example with CTRL+Click)
		WebElement link11 = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[4]/a[1]"));
		Actions action11 = new Actions(driver);
		action11.keyDown(Keys.CONTROL).click(link11).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[2]")).click();
		Thread.sleep(3000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);

	}

	@Then("click on the redeem and download the report")
	public void click_on_the_redeem_and_download_the_report() throws Exception {
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[3]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the reports and select the expiry report button")
	public void click_on_the_reports_and_select_the_expiry_report_button() throws Exception {
		try {
			driver.findElement(By.xpath("(//a[@id='pharmacist_reports'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@id='admin-expiry-report'])[1]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("search a brand with expiry dates selection and download the report")
	public void search_a_brand_with_expiry_dates_selection_and_download_the_report() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='from-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[contains(text(),'Jan')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='to-date'])[1]")).click();
		Thread.sleep(1000);
		WebElement year = driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[2]"));
		Select yr = new Select(year);
		yr.selectByVisibleText("2026");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[text()='Dec'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the reports and select the pharmacy price contracts")
	public void click_on_the_reports_and_select_the_pharmacy_price_contracts() throws Exception {
		try {
			driver.findElement(By.xpath("(//a[@id='pharmacist_reports'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@id='hospital_brand_costs'])[1]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Then("add a brand and select the dates and save")
	public void add_a_brand_and_select_the_dates_and_save() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add new brand'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).sendKeys("Sunil");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/span[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='hospital_brand_cost_master_qty_per_pck'])[1]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='hospital_brand_cost_master_pck_cost'])[1]")).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='hospital_brand_cost_master_start_date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='q_brand_master_brand_name_start'])[1]")).sendKeys("Sunil");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='hospital_brand_cost_master_qty_per_pck'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='hospital_brand_cost_master_qty_per_pck'])[1]"))
				.sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the reports and select the brand consumptions")
	public void click_on_the_reports_and_select_the_brand_consumptions() throws Exception {
		try {
			driver.findElement(By.xpath("(//a[@id='pharmacist_reports'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@id='brand-consumptions'])[1]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Then("enter any brand and select the dates and search the brand consumption")
	public void enter_any_brand_and_select_the_dates_and_search_the_brand_consumption() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).sendKeys("Sunil");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li/span[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.xpath("(//input[@id='from-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.xpath("(//input[@id='to-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the billing and select the dialyreport")
	public void clicking_on_the_billing_and_select_the_dialyreport() throws Exception {
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_daywise_report"))).click().build().perform();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Test Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		// from date
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the bookings
		WebElement booking = driver.findElement(By.xpath("//label[text()='Bookings']"));
		booking.click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the profilt
		WebElement profit = driver.findElement(By.xpath("//label[text()='Profit']"));
		profit.click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(5000);

	}

	@Then("search and download the reports for dialyreport")
	public void search_and_download_the_reports_for_dialyreport() throws Exception {

	}

	@And("clicking on the billing and select the patientwisereport")
	public void clicking_on_the_billing_and_select_the_patientwisereport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_revenue_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);

		// Open link in new tab (example with CTRL+Click)
		WebElement link = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"));
		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// name
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(10000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// Open link in new tab (example with CTRL+Click)
		WebElement link1 = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]"));
		Actions action11 = new Actions(driver);
		action11.keyDown(Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the bookings.
		// Bookings
		WebElement bookings = driver.findElement(By.xpath("//label[text()='Bookings']"));
		bookings.click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// doctor name
		driver.findElement(By.cssSelector("input#q_prescription_sale_order_headers_doctor_name_cont"))
				.sendKeys("Doctor one");
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
	}

	@Then("search and download the reports for patientwisereport")
	public void search_and_download_the_reports_for_patientwisereport() {

	}

	@And("clicking on the billing and select the monthlyreport")
	public void clicking_on_the_billing_and_select_the_monthlyreport() {

	}

	@Then("search and download the reports for monthlyreport")
	public void search_and_download_the_reports_for_monthlyreport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_monthwise_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		WebElement dropdown = driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]"));
		Select select = new Select(dropdown);
		// Select by visible text
		select.selectByVisibleText("2025");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[text()='Jan'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
//		// reset
//		driver.findElement(By.xpath("//a[text()='Reset']")).click();
//		Thread.sleep(2000);
//		// selecting the pharmacy
//		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
//		Thread.sleep(1000);
//		// selecting the date
//		driver.findElement(By.id("from-date")).click();
//		Thread.sleep(1000);
//		WebElement dropdown1 = driver
//				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]"));
//		Select select1 = new Select(dropdown1);
//		// Select by visible text
//		select1.selectByVisibleText("2025");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[text()='Jan'])[1]")).click();
//		Thread.sleep(2000);
//		// to date
//		driver.findElement(By.id("to-date")).click();
//		Thread.sleep(1000);
//		WebElement dropdown11 = driver
//				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[2]"));
//		Select select11 = new Select(dropdown11);
//		// Select by visible text
//		select11.selectByVisibleText("2025");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[text()='Mar'])[2]")).click();
//		Thread.sleep(2000);
//		// search
//		driver.findElement(By.xpath("//input[@value='Search']")).click();
//		Thread.sleep(1000);
////		// download
////		driver.findElement(By.xpath("//i[text()='file_download']")).click();
////		Thread.sleep(2000);
		// selecting the bookings radio btn
		WebElement bookings = driver.findElement(By.xpath("(//label[text()='Bookings'])[1]"));
		bookings.click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// selecting the bookings radio btn
		WebElement profit = driver.findElement(By.xpath("(//label[text()='Profit'])[1]"));
		profit.click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the billing and select the gstreport")
	public void clicking_on_the_billing_and_select_the_gstreport() {

	}

	@Then("search and download the reports for gstreport")
	public void search_and_download_the_reports_for_gstreport() throws Exception {
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_gst_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("month_filter")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='select-wrapper select-month'])[1]/input[1]")).click();
		Thread.sleep(1000);
		// march
		driver.findElement(By.xpath("(//td[contains(text(),'Jan')])[1]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='1']")).click();
//		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// status
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// status
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
	}

	@And("clicking on the billing and select the brandwisereport")
	public void clicking_on_the_billing_and_select_the_brandwisereport() {

	}

	@Then("search and download the reports for brandwisereport")
	public void search_and_download_the_reports_for_brandwisereport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacist_reports'])[1]")).click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='BrandWise GST Report']")).click();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("month_filter")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[contains(text(),'Jan')])[1]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
//		// selecting the pharmacy
//		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
//		Thread.sleep(1000);
//		// selecting the date [last month]
//		driver.findElement(By.id("month_filter")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='select-wrapper select-month'])[1]/input[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("//li/span[text()='January']")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("//button[text()='1']")).click();
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("//input[@value='Submit']")).click();
//		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		// reset
//		driver.findElement(By.xpath("//a[text()='Reset']")).click();
//		Thread.sleep(3000);
	}

	@And("clicking on the billing and select the distributorwisereport")
	public void clicking_on_the_billing_and_select_the_distributorwisereport() {

	}

	@Then("search and download the reports for distributorwisereport")
	public void search_and_download_the_reports_for_distributorwisereport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='DistributorWise GST Report']"))).click().build()
				.perform();
		Thread.sleep(1000);
		// clicking on the distributor
		driver.findElement(By.xpath("(//label[text()='Distributor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("month_filter")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[text()='Jan'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
//		// clicking on the distributor
//		driver.findElement(By.xpath("(//label[text()='Distributor'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("month_filter")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='1']")).click();
//		Thread.sleep(1000);
//		// search
//		driver.findElement(By.xpath("//input[@value='Submit']")).click();
//		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(1000);
//		// reset
//		driver.findElement(By.xpath("//a[text()='Reset']")).click();
//		Thread.sleep(2000);

	}

	@And("clicking on the billing and select the annualgstreport")
	public void clicking_on_the_billing_and_select_the_annualgstreport() {

	}

	@Then("search and download the reports for annualgstreport")
	public void search_and_download_the_reports_for_annualgstreport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Year'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the billing and select the dueamountreport")
	public void clicking_on_the_billing_and_select_the_dueamountreport() {

	}

	@Then("search and download the reports for dueamountreport")
	public void search_and_download_the_reports_for_dueamountreport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("due_amount_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// test
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(2000);
//		//to-date
//		driver.findElement(By.cssSelector("input#q_order_date_lteq")).click();
//		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the billing and select the profitreport")
	public void clicking_on_the_billing_and_select_the_profitreport() {
	}

	@Then("search and download the reports for profitreport")
	public void search_and_download_the_reports_for_profitreport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_brndwise_report"))).click().build().perform();
		Thread.sleep(2000);
		// brand selection
		driver.findElement(By.xpath("(//label[text()='Brandname'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='A2B'])[1]")).click();
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// brand selection
		driver.findElement(By.xpath("(//label[text()='Brandname'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the billing and select the reorderplan")
	public void clicking_on_the_billing_and_select_the_reorderplan() {

	}

	@Then("search and download the reports for reorderplan")
	public void search_and_download_the_reports_for_reorderplan() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
