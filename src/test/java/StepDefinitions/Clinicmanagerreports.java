package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Clinicmanagerreports {
	WebDriver driver = null;

	@Given("open test NH url {string}")
//	public void open_test_nh_url(String string) {
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

	@Then("enter  test mailid {string} and pswd {string}")
	public void enter_test_mailid_and_pswd(String mailid, String pswd) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys(mailid);
		driver.findElement(By.id("user_password")).sendKeys(pswd);
		Thread.sleep(10000);
	}

	@Then("clicked on signin button to login then")
	public void clicked_on_signin_button_to_login_then() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("clinic manager role was clicked")
	public void clinic_manager_role_was_clicked() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("change role to cdpadmin and delete existing patients")
	public void change_role_to_cdpadmin_and_delete_existing_patients() throws Exception {
//		// clicking on the brand logo
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting cdpadmin Role
//		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
//		Thread.sleep(5000);
//		Thread.sleep(2000);
//		driver.findElement(By.id("frst_nm")).sendKeys("8887779991");
//		Thread.sleep(3000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
//
//		// close for pending amount
//		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i")).click();
//			Thread.sleep(1000);
//		} else {
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		}
//
//		// deleteing
//		driver.findElement(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")).click();
//		Thread.sleep(5000);
//
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting Role as IPBillingManager
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
//		Thread.sleep(3000);
	}

	@And("click on the reports and select corporates")
	public void click_on_the_reports_and_select_corporates() throws Exception {
//		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@id='corprate-list'])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("click on plus button to create new corporate")
	public void click_on_plus_button_to_create_new_corporate() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add New'])[1]/i[1]"))).click();
//		Thread.sleep(1000);
//		// save
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
//		Thread.sleep(1000);
//		// entering the corporate name
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='corp_master_corp_name'])[1]")))
//				.sendKeys("Cucum corporate");
////		Thread.sleep(1000);
//		// selecting the demand program
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[2]"))).click();
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
//		Thread.sleep(1000);
//		// save
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
//		Thread.sleep(3000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
	}

	@And("search and click on the corporate name to add employees to corporate")
	public void search_and_click_on_the_corporate_name_to_add_employees_to_corporate() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//label[text()='Corporate Name'])[1]/following-sibling::span[1]")))
//				.click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Cucum corporate')])[1]")))
//				.click();
//		Thread.sleep(1000);
//		// search
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Employee'])[1]/img[1]")))
//				.click();
//		Thread.sleep(3000);
//		// mouse hover on the plus button to add employee
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//i[text()='add'])[1]"))).build().perform();
//		Thread.sleep(2000);
//		// download template
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Template Download'])[1]/i[1]"))).click()
//				.build().perform();
//		Thread.sleep(2000);
//		// mouse hover on the plus button to add employee
//		Actions action1 = new Actions(driver);
//		action1.moveToElement(driver.findElement(By.xpath("(//i[text()='add'])[1]"))).build().perform();
//		Thread.sleep(2000);
//		action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add One'])[1]/i[1]"))).click().build()
//				.perform();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='first_name'])[1]")))
//				.sendKeys("87900");
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[3]"))).click();
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Employee'])[1]"))).click();
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[4]"))).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Mr.')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='first_name'])[2]")).sendKeys("Cucum");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("Corporateemployee");
//		Thread.sleep(1000);
//		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
//		male.click();
//		Thread.sleep(1000);
//		// age
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='age'])[1]"))).sendKeys("45");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='+91'])[1]")).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='nmbr'])[1]")))
//				.sendKeys("8887779991");
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//input[@id='corp_master_employee_masters_joining_date'])[1]")))
//				.click();
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
//		Thread.sleep(2000);
//		// submit
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[2]"))).click();
//		Thread.sleep(3000);

	}

	@Then("add familymember for the employee in the corporate")
	public void add_familymember_for_the_employee_in_the_corporate() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Family Member'])[1]/i[1]"))).build()
//				.perform();
//		Thread.sleep(2000);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Family Member'])[1]/i[1]"))).click()
//				.build().perform();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Ms./Mrs.')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Corporate");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("Fammember");
//		Thread.sleep(1000);
//		WebElement f = driver.findElement(By.xpath("(//label[text()='F'])[1]"));
//		f.click();
//		Thread.sleep(1000);
//		// age
//		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("21");
//		Thread.sleep(1000);
//		// nmbr
//		driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).sendKeys("8887779992");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Sister')])[1]")).click();
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
//		Thread.sleep(3000);
//		// clicking on the family number count
//		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[6]/a[1]")).click();
//		Thread.sleep(2000);
//		// closing the popup
//		driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//p[contains(text(),'More')])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).sendKeys("Test");
//		Thread.sleep(2000);
//		// search
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//p[contains(text(),'More')])[1]")).click();
//		Thread.sleep(2000);
//		// reset
//		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
//		Thread.sleep(2000);

	}

	@And("convert employee to patient by filling registration form")
	public void convert_employee_to_patient_by_filling_registration_form() throws Exception {
//		// clicking on the register
//		driver.findElement(By.xpath("(//a[@data-tooltip='Register'])[1]/img[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("Test");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		driver.findElement(By.xpath("(//input[@id='autocomplete-input'])[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='autocomplete-input'])[1]")).sendKeys("Test");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("Test");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("090909");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// submit
//		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
//		Thread.sleep(8000);
	}

	@And("click on the reports and select formsreport")
	public void click_on_the_reports_and_select_formsreport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='forms_report'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("search the form and click on the download button")
	public void search_the_form_and_click_on_the_download_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Form'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Registration1')])[1]")))
				.click();
		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the count
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[4]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the download button
		driver.findElement(By.xpath("(//i[text()='file_download'])[1]")).click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[2]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='User'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='New'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the count
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[4]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the download button
		driver.findElement(By.xpath("(//i[text()='file_download'])[1]")).click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[2]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the pharmacy and select the dialyreport")
	public void click_on_the_pharmacy_and_select_the_dialyreport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(1000);
		// mouse hover on to the inventory
		Actions inventory = new Actions(driver);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='brand-sale-list'])[1]"))).build().perform();
		Thread.sleep(1000);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='phrmcy_daywise_report'])[1]"))).click().build()
				.perform();
		Thread.sleep(3000);

	}

	@Then("search and download the dialyreports")
	public void search_and_download_the_dialyreports() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// select the pharmacy
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Test Pharmacy'])[1]"))).click();
//		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// bookings
		WebElement bookings = driver.findElement(By.xpath("(//label[text()='Bookings'])[1]"));
		bookings.click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// profit
		WebElement profit = driver.findElement(By.xpath("(//label[text()='Profit'])[1]"));
		profit.click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the pharmacy and select the patientwisereport")
	public void click_on_the_pharmacy_and_select_the_patientwisereport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(1000);
		// mouse hover on to the inventory
		Actions inventory = new Actions(driver);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='brand-sale-list'])[1]"))).build().perform();
		Thread.sleep(1000);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='phrmcy_revenue_report'])[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
	}

	@Then("search and download the patientwisereports")
	public void search_and_download_the_patientwisereports() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// select the pharmacy
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Test Pharmacy'])[1]"))).click();
//		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// bookings
		WebElement bookings = driver.findElement(By.xpath("(//label[text()='Bookings'])[1]"));
		bookings.click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the pharmacy and select the monthlyreport")
	public void click_on_the_pharmacy_and_select_the_monthlyreport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(1000);
		// mouse hover on to the inventory
		Actions inventory = new Actions(driver);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='brand-sale-list'])[1]"))).build().perform();
		Thread.sleep(1000);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='phrmcy_monthwise_report'])[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
	}

	@Then("search and download the monthlyreport")
	public void search_and_download_the_monthlyreport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// select the pharmacy
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Test Pharmacy'])[1]"))).click();
//		Thread.sleep(1000);
		// selecting the pharmacy
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Test Pharmacy'])[1]"))).click();
		Thread.sleep(1000);
		// selecting the date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from-date"))).click();
		Thread.sleep(1000);
		WebElement dropdown = driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]"));
		Select select = new Select(dropdown);
		// Select by visible text
		select.selectByVisibleText("2025");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[text()='Jan'])[1]"))).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
//				// reset
//				driver.findElement(By.xpath("//a[text()='Reset']")).click();
//				Thread.sleep(2000);
//				// selecting the pharmacy
//				driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
//				Thread.sleep(1000);
//				// selecting the date
//				driver.findElement(By.id("from-date")).click();
//				Thread.sleep(1000);
//				WebElement dropdown1 = driver
//						.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]"));
//				Select select1 = new Select(dropdown1);
//				// Select by visible text
//				select1.selectByVisibleText("2025");
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("(//td[text()='Jan'])[1]")).click();
//				Thread.sleep(2000);
//				// to date
//				driver.findElement(By.id("to-date")).click();
//				Thread.sleep(1000);
//				WebElement dropdown11 = driver
//						.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[2]"));
//				Select select11 = new Select(dropdown11);
//				// Select by visible text
//				select11.selectByVisibleText("2025");
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("(//td[text()='Mar'])[2]")).click();
//				Thread.sleep(2000);
//				// search
//				driver.findElement(By.xpath("//input[@value='Search']")).click();
//				Thread.sleep(1000);
////				// download
////				driver.findElement(By.xpath("//i[text()='file_download']")).click();
////				Thread.sleep(2000);
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

	@And("click on the pharmacy and select the brandwisereport")
	public void click_on_the_pharmacy_and_select_the_brandwisereport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(1000);
		// mouse hover on to the inventory
		Actions inventory = new Actions(driver);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='brand-sale-list'])[1]"))).build().perform();
		Thread.sleep(1000);
		inventory.moveToElement(driver.findElement(By.xpath("(//a[@id='phrmcy_brndwise_report'])[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
	}

	@Then("search and download the brandwisereport")
	public void search_and_download_the_brandwisereport() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("click on the reports and select the recommendations")
	public void click_on_the_reports_and_select_the_recommendations() throws Exception {
		// clicking on the dashboard
		driver.findElement(By.xpath("(//a[@id='admin-dashboard'])[2]")).click();
		Thread.sleep(3000);
//		try {
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/a")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//a[@id='admin-recommendations'])[1]")).click();
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}

	@Then("assign care team to the patient and")
	public void assign_care_team_to_the_patient_and() throws Exception {
		driver.findElement(By.xpath("(//input[@id='q_patient_master_frst_nm_or_patient_master_lst_nm_cont'])[1]"))
				.sendKeys("Cucum");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// mouse hover on i icon
		Actions i = new Actions(driver);
		i.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[2]"))).build().perform();
		Thread.sleep(2000);
	}

	@And("add next engagement for the patient")
	public void add_next_engagement_for_the_patient() throws Exception {
		Actions nextengicon = new Actions(driver);
		nextengicon.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Patient Engagement'])[2]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		nextengicon.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Patient Engagement'])[2]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[text()='Phone'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Recommendation Status'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Pending'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@id='patient_engagement_detail_notes'])[1]"))
				.sendKeys("Testing description");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='patient_engagement_detail_prfrd_followup_date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-next'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='patient_engagement_detail_prfrd_followup_time'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Preferred Method'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Phone'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='engmtSubmitBtn'])[1]")).click();
		Thread.sleep(5000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='patient-engagement-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// enabling the checkbox
		WebElement checkbox = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[1]/label[1]"));
		checkbox.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Update Care Team'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[10]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Doctor One'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on the reports and select the patients")
	public void click_on_the_reports_and_select_the_patients() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-list-patients'])[1]")).click();
		Thread.sleep(10000);

	}

	@And("click on the group button and delete the existing group")
	public void click_on_the_group_button_and_delete_the_existing_group() throws Exception {
		// clicking on the groups
		WebElement element = driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div/div/div/ul/li[2]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		// search and delete the group
		driver.findElement(By.xpath("(//input[@id='q_group_name_cont'])[1]")).sendKeys("Cucum");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("create a new group and add some of the patients to the created group")
	public void create_a_new_group_and_add_some_of_the_patients_to_the_created_group() throws Exception {

		// clicking on the plus button to create new group
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='group_master_group_name'])[1]")).sendKeys("Cucum group");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='group_master_desc'])[1]")).sendKeys("Cucum group");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("send info to the patients using send info button from groups")
	public void send_info_to_the_patients_using_send_info_button_from_groups() throws Exception {
		// clicking on the patients button again to add patient s to the created group
		driver.findElement(By.xpath("(//a[text()='Patients'])[3]")).click();
		Thread.sleep(10000);
		// clicking on the checkbox
		WebElement checkbox1 = driver.findElement(By.xpath("(//tbody[@id='patient-list'])[1]/tr[2]/td[1]/label"));
		checkbox1.click();
		Thread.sleep(1000);
		WebElement checkbox2 = driver.findElement(By.xpath("(//tbody[@id='patient-list'])[1]/tr[4]/td[1]/label"));
		checkbox2.click();
		Thread.sleep(1000);
		WebElement checkbox3 = driver.findElement(By.xpath("(//tbody[@id='patient-list'])[1]/tr[6]/td[1]/label"));
		checkbox3.click();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement checkbox4 = driver.findElement(By.xpath("(//tbody[@id='patient-list'])[1]/tr[8]/td[1]/label"));
			checkbox3.click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		// clicking on the add to group
		driver.findElement(By.xpath("(//input[@value='Add To Group'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Cucum group'])[1]")).click();
		Thread.sleep(10000);
		// clicking on the groups
		WebElement element = driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div/div/div/ul/li[2]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		// search and delete the group
		driver.findElement(By.xpath("(//input[@id='q_group_name_cont'])[1]")).sendKeys("Cucum");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[1]/label[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Send Info'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='notification_title'])[1]")).sendKeys("Testing title");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='textarea1'])[1]"))
				.sendKeys("Testing type your message" + Keys.PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Send'])[1]")).click();
		Thread.sleep(10000);
	}

	@Then("click on the reports and select referrals")
	public void click_on_the_reports_and_select_referrals() throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-referrals'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("search with patient name or dates and download the data")
	public void search_with_patient_name_or_dates_and_download_the_data() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Hospital Name'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='q_patient_master_frst_nm_or_patient_master_lst_nm_cont'])[1]"))
				.sendKeys("Cucum");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Referral type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Self'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Referred by'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Self'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// clicking on the registration id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {

		}
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-referrals'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the reports and select consultations")
	public void click_on_the_reports_and_select_consultations() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='videoCall'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("search with patient name or dates and download consultations data")
	public void search_with_patient_name_or_dates_and_download_consultations_data() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Doctor'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Dr. Doctor One'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Consulted type'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Video'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='from-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='to-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// clicking on the appointment id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[1]/span/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the programutilization button and search with name and dates fileds")
	public void click_on_the_programutilization_button_and_search_with_name_and_dates_fileds() throws Exception {
		// clicking on the reports and selecting the program utilization
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-pckgUtilisation'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Packagename'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Test')])[1]")).click();
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.xpath("(//input[@id='q_schedule_date_time_gteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='q_schedule_date_time_lteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Pending'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("(//a[text()='Book'])[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//a[text()='Book'])[1]")).click();
			Thread.sleep(2000);

		} else {
			// reset
			driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
			Thread.sleep(2000);
		}

	}

	@And("click on reports and select carts and search with dates")
	public void click_on_reports_and_select_carts_and_search_with_dates() throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-carts'])[1]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@id='q_patient_master_frst_nm_or_patient_master_lst_nm_cont'])[1]"))
//				.sendKeys("Test");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='q_created_at_gteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='q_created_at_lteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);

		// This is a common and robust way to implement if-else logic in Selenium.
		try

		{
			// Check if the 'View' button exists
			WebElement viewButton = driver.findElement(By.xpath("(//a[text()='View'])[1]"));

			System.out.println("View button found, proceeding with viewing and checkout.");

			// --- First Scenario: View, then Checkout ---

			// Click the 'View' button
			viewButton.click();

			// Wait for the next element to be clickable before interacting with it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[@id='cart_items_modal'])[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[6]/a[1]")))
					.click();
			// Wait for the 'Checkout' button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Checkout'])[1]"))).click();
			// Click on the lab and select the slot and pay the amount and share to mail id
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h6[text()='Lab'])[1]"))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
			Thread.sleep(3000);
			Robot robot12 = new Robot();
			robot12.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
//			WebElement cash = driver.findElement(By.xpath(""));
//			cash.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='advance_field'])[1]")))
					.sendKeys("1");
			Thread.sleep(2000);
			robot12.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
			Thread.sleep(2000);
			driver.findElement(By.id("emails")).clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("phone")).clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("phone")).sendKeys("8790098500");
			Thread.sleep(1000);
			// submit
			WebElement sub = driver
					.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
			sub.click();
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {

			System.out.println("View button not found, proceeding with booking and checkout.");

			// --- Second Scenario: Book, then Checkout ---

			// Find and click the 'Book' button
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Book'])[1]"))).click();

			// Wait for the 'Checkout' button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Checkout'])[1]"))).click();
			// Click on the lab and select the slot and pay the amount and share to mail id
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h6[text()='Lab'])[1]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='slot'])[1]/span[1]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
			Thread.sleep(3000);
			Robot robot11 = new Robot();
			robot11.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
//			WebElement cash = driver.findElement(By.xpath(""));
//			cash.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='advance_field'])[1]")))
					.sendKeys("1");
			Thread.sleep(3000);
			robot11.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
			// share invoice
			driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("emails")).clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("phone")).clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
			Thread.sleep(1000);
			// submit
			WebElement sub = driver
					.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
			sub.click();
			Thread.sleep(10000);
		}

	}
}
