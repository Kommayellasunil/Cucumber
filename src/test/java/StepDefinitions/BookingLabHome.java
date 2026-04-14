package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingLabHome {
	WebDriver driver = null;

	@Given("navigate to the nanohealth url by opening chromebrowser {string}")
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

	@Then("enter the emailormobile3 {string} and password3 {string}")
	public void enter_the_emailormobile3_and_password3(String emailormobile3, String password3) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobile3);
		driver.findElement(By.id("user_password")).sendKeys(password3);
		Thread.sleep(15000);
	}

	@And("click on the sign in button to select profile")
	public void click_on_the_sign_in_button_to_select_profile() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the profile of clinic manager from the roles")
	public void select_the_profile_of_clinic_manager_from_the_roles() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on CDPAdmin
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@And("deleting the exists patient using search bar from clinic manager role")
	public void deleting_the_exists_patient_using_search_bar_from_clinic_manager_role() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("6717767678");
		Thread.sleep(3000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i")).click();
			Thread.sleep(1000);
		} else {
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
			Thread.sleep(1000);
		}

		// deleteing
		driver.findElement(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
	}

	@When("existing patient got deleted")
	public void existing_patient_got_deleted() {

	}

	@And("click on add patient icon to register a new patient")
	public void click_on_add_patient_icon_to_register_a_new_patient() throws Exception {

		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select the title of patient to mrs")
	public void select_the_title_of_patient_to_mrs() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).sendKeys(Keys.DOWN);
//		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("user enters following details into registration form to register a new patient")
	public void user_enters_following_details_into_registration_form_to_register_a_new_patient(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);

		// firstname
		driver.findElement(By.id("first_name")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		driver.findElement(By.id("lst_name")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.id("age")).sendKeys(regData.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		driver.findElement(By.id("nmbr")).sendKeys(regData.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
//		driver.findElement(By.id("email")).sendKeys(regData.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// addressline
		driver.findElement(By.id("address-line1")).sendKeys(regData.get(4).get(1));
		driver.findElement(By.id("autocomplete-input")).sendKeys(regData.get(5).get(1));
		driver.findElement(By.id("landmark")).sendKeys(regData.get(6).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys(regData.get(7).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys(regData.get(8).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys(regData.get(9).get(1));
//		// aadharcardnumber
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[9]/div[2]/input"))
//				.sendKeys(regData.get(11).get(1));
	}

	@Then("enter the necessary details to register a new patient")
	public void enter_the_necessary_details_to_register_a_new_patient() throws Exception {
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
//		// abhacard
//		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
//		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("767676");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
//		// profession
//		driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test profession");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// referred by
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
		Thread.sleep(1000);
		// self
		driver.findElement(By.xpath("(//div[@class='icon'])[3]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
		Thread.sleep(2000);

	}

	@And("enter the height weight details so that bmi will calculate automatically")
	public void enter_the_height_weight_details_so_that_bmi_will_calculate_automatically() throws Exception {
		driver.findElement(By.xpath("(//input[@id='Cms_'])[1]")).sendKeys("180");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[13]/div[2]/div/div[2]/input"))
				.sendKeys("73");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			Thread.sleep(1000);
		}

	}

	@And("click on submit button to register a new patient")
	public void click_on_submit_button_to_register_a_new_patient() throws Exception {
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(1000);
		Robot robot11 = new Robot();
		robot11.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@Then("it will redirects to the new registered patient profile")
	public void it_will_redirects_to_the_new_registered_patient_profile() throws Exception {
//		// clicking on the add program
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Program'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input#pckg_nm")).sendKeys("Cucum testpackage");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='duration'])[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='duration'])[1]")).sendKeys("31");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Sync Data'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Diagnostic");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[text()='Diagnostics'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Diagnostic");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[text()='Diagnostics'])[2]")).click();
//		Thread.sleep(2000);
//		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
//		repeat.click();
//		Thread.sleep(2000);
//		driver.findElement(
//				By.xpath("(//label[text()='Frequency'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Weekly'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='repeat_count'])[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='repeat_count'])[1]")).sendKeys("3");
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Monday')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Wednesday')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Friday')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Sunday')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='repeat_count'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='repeat_from'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='repeat_start_time'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
//				.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
//		Thread.sleep(2000);
//		// mouse-hovering on the i icon
//		Actions action1 = new Actions(driver);
//		action1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]"))).build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Doctor");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[contains(text(),'Doctor')])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Minor");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[contains(text(),'Minor')])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='pkg_price'])[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='pkg_price'])[1]")).sendKeys("1000");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
//		Thread.sleep(5000);
//		Robot robot3 = new Robot();
//		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='advance_field'])[1]")).sendKeys("1000");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(5000);
//		// generate the invoice
//		Actions id = new Actions(driver);
//		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]"))).build()
//				.perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
//		Thread.sleep(2000);
//		// converting to tax invoice
//		Actions taxinv = new Actions(driver);
//		taxinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")).click();
//		Thread.sleep(4000);
//		// OP invoice
//		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
//		Thread.sleep(2000);
//		Robot robot4 = new Robot();
//		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("phone")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// clicking on the submit button
//		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
//		Thread.sleep(10000);
//		// clicking on the patient name
//		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
//		Thread.sleep(5000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
//			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//			Thread.sleep(1000);
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//		// clicking on the programs
//		driver.findElement(By.xpath("(//a[contains(text(),'Programs')])[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[contains(text(),'Cucum testpackage')])[1]")).click();
//		Thread.sleep(5000);
//		// clicking on the book button
//		String parentWindow = driver.getWindowHandle();
//		driver.findElement(By.xpath("//table[@id='example']//tr[td[normalize-space()='Dr. Doctor One']][1]/td[7]/a[1]"))
//				.click();
//		Thread.sleep(3000);
//		// Switch to child tab
//		for (String window : driver.getWindowHandles()) {
//			if (!window.equals(parentWindow)) {
//				driver.switchTo().window(window);
//				break;
//			}
//		}
//		// clicking on the book appointment
//		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait11.until(ExpectedConditions.visibilityOf(
//				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)"))))
//				.click();
//		// driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
//		Thread.sleep(2000);
//		// selecting the type - clinic type
//		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
//		Thread.sleep(1000);
//		// selecting the clinic
//		element.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]/div[1]/div[1]/div[1]")))
//				.click();
//		Thread.sleep(1000);
//		// Try AM first
//		JavascriptExecutor js11 = (JavascriptExecutor) driver;
//		List<WebElement> am = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));
//		boolean selected = false;
//		for (WebElement slot : am) {
//			if (slot.isDisplayed() && slot.isEnabled()) {
//				js11.executeScript("arguments[0].click();", slot);
//				selected = true;
//				break;
//			}
//		}
//		if (!selected) {
//			// Try PM next
//			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));
//			for (WebElement slot : pm) {
//				if (slot.isDisplayed() && slot.isEnabled()) {
//					js11.executeScript("arguments[0].click();", slot);
//					break;
//				}
//			}
//		}
//		Thread.sleep(1000);
//		// clicking on the submit
//		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
//		Thread.sleep(5000);
//		// Close child tab & return
//		driver.close();
//		driver.switchTo().window(parentWindow);
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//
//		// close for pending amount
//		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
//			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//			Thread.sleep(1000);
//			try {
//				Thread.sleep(2000);
//			} catch (Exception e) {
//			}
//		}
//		// clicking on the programs
//		driver.findElement(By.xpath("(//a[contains(text(),'Programs')])[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[contains(text(),'Cucum testpackage')])[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
//		Thread.sleep(3000);
//		// closing popup
//		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//div[@id='package-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//		Thread.sleep(3000);

	}

	@And("click on the Book Diagnostic Appointment from the Book Appointment")
	public void click_on_the_book_diagnostic_appointment_from_the_book_appointment() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the lab from the dropdown")
	public void selecting_the_lab_from_the_dropdown() throws Exception {
		// clicking on the drop down
		driver.findElement(By.cssSelector("span.selection")).click();
		Thread.sleep(2000);
		// thyrocare
		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
		Thread.sleep(10000);
	}

	@When("thyrocare lab is selected tests that are avaible in thyrocare lab will reflect")
	public void thyrocare_lab_is_selected_tests_that_are_avaible_in_thyrocare_lab_will_reflect() {
	}

	@Then("mouse hovering and selecting the test from type of pathology")
	public void mouse_hovering_and_selecting_the_test_from_type_of_pathology() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("a.dropbtn.btn.btn_lab.btn-loader.test_type_btn")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.cssSelector("a.btn_lab.btn-loader.pathalogyBtn.pathology_search")))
				.click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		// removing last added pathology test
		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		Thread.sleep(3000);
//		// clicking on the drop down
//		driver.findElement(By.cssSelector("span.selection")).click();
//		Thread.sleep(2000);
//		// thyrocare
//		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
//		Thread.sleep(10000);
	}

	@And("mouse hovering again and selecting the test from type of radiology")
	public void mouse_hovering_again_and_selecting_the_test_from_type_of_radiology() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("a.dropbtn.btn.btn_lab.btn-loader.test_type_btn")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.cssSelector("a.btn_lab.btn-loader.radiologyBtn.radiology_search")))
				.click().build().perform();
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//input[@id='myInput'])[1]")).sendKeys("CT Hip");
		Thread.sleep(5000);
		WebElement invoiceIcon = driver
				.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/div/div[3]/ul/li[7]/div/div[3]/a/i"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute a JavaScript command to click the element
		js.executeScript("arguments[0].click();", invoiceIcon);
//		driver.findElement(By.xpath("(//i[text()='add'])[6]")).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the checkout button from lab_home add to cart popup")
	public void clicking_on_the_checkout_button_from_lab_home_add_to_cart_popup() throws Exception {
		// clicking on the checkout button
		driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
	}

	@And("select the appointment type as lab_home from the type popup")
	public void select_the_appointment_type_as_lab_home_from_the_type_popup() throws InterruptedException {
		// selecting the type - Lab+Home
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(2000);
	}

	@When("patient address is one then it will redirect to the selection of lab address")
	public void patient_address_is_one_then_it_will_redirect_to_the_selection_of_lab_address() {
	}

	@And("if patient has two or more home address it will redirect to the home address seletion")
	public void if_patient_has_two_or_more_home_address_it_will_redirect_to_the_home_address_seletion() {
	}

	@Then("selecting the lab address for booking lab_home appointment")
	public void selecting_the_lab_address_for_booking_lab_home_appointment() throws Exception {
		driver.findElement(By.xpath("(//div[@id='saved-addresses'])[2]/ul/li/div[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the date and time slot for the pathology tests")
	public void select_the_date_and_time_slot_for_the_pathology_tests() throws Exception {
		// Try AM first
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		boolean selected = false;
		// Try AM slots first
		List<WebElement> am = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));

		for (WebElement slot : am) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				// 🔽 Scroll slot into view
				js11.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
				// Optional small wait for stability
				Thread.sleep(300);
				// ✅ Click using JS
				js11.executeScript("arguments[0].click();", slot);
				selected = true;
				break;
			}
		}

		// If no AM slot found, try PM
		if (!selected) {
			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));

			for (WebElement slot : pm) {
				if (slot.isDisplayed() && slot.isEnabled()) {

					js11.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);

					Thread.sleep(300);
					js11.executeScript("arguments[0].click();", slot);

					break;
				}
			}
		}

	}

	@Then("select the date and time slot for the radiology tests")
	public void select_the_date_and_time_slot_for_the_radiology_tests() throws Exception {

		// Try AM first
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		boolean selected = false;
		// Try AM slots first
		List<WebElement> am = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));

		for (WebElement slot : am) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				// 🔽 Scroll slot into view
				js11.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
				// Optional small wait for stability
				Thread.sleep(300);
				// ✅ Click using JS
				js11.executeScript("arguments[0].click();", slot);
				selected = true;
				break;
			}
		}

		// If no AM slot found, try PM
		if (!selected) {
			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));

			for (WebElement slot : pm) {
				if (slot.isDisplayed() && slot.isEnabled()) {

					js11.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);

					Thread.sleep(300);
					js11.executeScript("arguments[0].click();", slot);

					break;
				}
			}
		}

	}

	@And("select the perfomring doctor using search")
	public void select_the_perfomring_doctor_using_search() throws Exception {
		driver.findElement(By.xpath("(//input[@id='performed_by1'])[1]")).sendKeys("Dr");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Dr')])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the referred by and enter delivery charges")
	public void select_the_referred_by_and_enter_delivery_charges() throws Exception {
//		// entering referred by
//		driver.findElement(By.id("referred_by")).sendKeys("d");
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[text()='Dr.Sneha R , , ']")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Referred By'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[normalize-space(text())='Self'])[1]")).click();
		Thread.sleep(2000);
		// entering the delivery charges
		driver.findElement(By.id("delivery_charges")).sendKeys("50");
		Thread.sleep(2000);
	}

	@And("enable the notify patient checkboxes from the invoice popup")
	public void enable_the_notify_patient_checkboxes_from_the_invoice_popup() throws Exception {
		// clicking on the check boxes
		WebElement cbox1 = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		cbox1.click();
		WebElement cbox2 = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		cbox2.click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button from the invoice popup")
	public void click_on_the_submit_button_from_the_invoice_popup() throws Exception {
		// clicking on the submit
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(2000);
	}

	@And("click on the appointments present in the above of the page")
	public void click_on_the_appointments_present_in_the_above_of_the_page() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Appointments'])[5]")).click();
//		Thread.sleep(2000);
	}

	@When("appointments is clicked alert will be open")
	public void appointments_is_clicked_alert_will_be_open() {
	}

	@And("click on the appointment id of Home")
	public void click_on_the_appointment_id_of_Home() throws InterruptedException {
//		driver.findElement(By.xpath("(//tbody[@class='lab_row'])[1]/tr[1]/td[2]/a")).click();
//		Thread.sleep(2000);
	}

	@Then("close the popup opened right side of the page1")
	public void close_the_popup_opened_right_side_of_the_page1() throws Exception {
//		driver.findElement(By.xpath("(//div[@class='modal-content appointment_content_modal'])[1]/div[1]/span/i[1]"))
//				.click();
//		Thread.sleep(4000);
	}

	@And("click on the appointments present in the above again")
	public void click_on_the_appointments_present_in_the_above_again() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Appointments'])[5]")).click();
//		Thread.sleep(2000);
	}

	@Then("click on the appointment id of Lab Visit")
	public void click_on_the_appointment_id_of_Lab_Visit() throws Exception {
//		driver.findElement(By.xpath("(//tbody[@class='lab_row'])[1]/tr[1]/td[2]/a")).click();
//		Thread.sleep(2000);
	}

	@And("close the popup opened right side of the page2")
	public void close_the_popup_opened_right_side_of_the_page2() throws Exception {
//		// alert popup is closed
//		driver.findElement(By.xpath("(//div[@class='modal-content appointment_content_modal'])[1]/div[1]/span/i[1]"))
//				.click();
//		Thread.sleep(4000);
	}

	@Then("close the alert opened in the top of the page")
	public void close_the_alert_opened_in_the_top_of_the_page() throws Exception {
		// mouse hover on the home visit to show the address
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@class='type-text left-align'])[1]"))).build()
				.perform();
		Thread.sleep(1000);

		// mouse hover on the date to show the apt details like id,date,status
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(
				By.xpath("(//table[@class='table nh_table invoice_table'])[1]/tbody[1]/tr[2]/td[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);

		// mouse hover on the another date to show the apt details like id,date,status
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(
				By.xpath("(//table[@class='table nh_table invoice_table'])[1]/tbody[1]/tr[5]/td[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);

	}

	@When("user select the radio button from the payment methods")
	public void user_select_the_radio_button_from_the_payment_methods() throws Exception {
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
	}

	@Then("cursor will move to the transaction amount field")
	public void cursor_will_move_to_the_transaction_amount_field() {
	}

	@When("user enter the cash as per tests prices")
	public void user_enter_the_cash_as_per_tests_prices() throws InterruptedException {
		// entering the amount
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("200");
		Thread.sleep(2000);
	}

	@Then("receipt comment icon will be enabled and click on it")
	public void receipt_comment_icon_will_be_enabled_and_click_on_it() {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the receipt comment and click on ok button to submit comment")
	public void enter_the_receipt_comment_and_click_on_ok_button_to_submit_comment() throws Exception {
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test comment");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);
	}

	@When("user click on the submit button from proforma invoice page")
	public void user_click_on_the_submit_button_from_proforma_invoice_page() throws Exception {
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@Then("it redirect to the invoice page")
	public void it_redirect_to_the_invoice_page() {

	}

	@And("download the invoice by clicking on the print icon")
	public void download_the_invoice_by_clicking_on_the_print_icon() throws Exception {
		// click on the appointments
		driver.findElement(By.xpath("(//a[text()='Appointments'])[5]")).click();
		Thread.sleep(2000);
		// clicking on the first appointment id
		driver.findElement(By.xpath("(//tbody[@class='lab_row'])[1]/tr[1]/td[2]/a")).click();
		Thread.sleep(5000);
		// closing the popup
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[1]/span/i")).click();
		Thread.sleep(5000);

		// again clicking on the appointment
		driver.findElement(By.xpath("(//a[text()='Appointments'])[5]")).click();
		Thread.sleep(2000);
		// clicking on the second appointment id
		driver.findElement(By.xpath("(//tbody[@class='lab_row'])[1]/tr[1]/td[2]/a")).click();
		Thread.sleep(5000);
		// closing the popup
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[1]/span/i")).click();
		Thread.sleep(5000);
		// closing the popup with apti
		driver.findElement(By.xpath("(//div[@class='modal-content appointment_content_modal'])[1]/div[1]/span[1]/i[1]"))
				.click();
		Thread.sleep(3000);
		// mouse-hovering on the appointment date
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("(//table[@class='table nh_table invoice_table'])[1]/tbody[1]/tr[2]/td[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);

		// mouse hover on the another date to show the apt details like id,date,status
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(
				By.xpath("(//table[@class='table nh_table invoice_table'])[1]/tbody[1]/tr[5]/td[1]/div[1]"))).build()
				.perform();
		Thread.sleep(2000);

		// generating invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// clicking on the proforma invoice icon
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
	}

	@And("download the receipt by clicking on the receipt id")
	public void download_the_receipt_by_clicking_on_the_receipt_id() throws Exception {
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		Thread.sleep(3000);
	}

	@And("download the pdf by clicking on the total advance pdf icon")
	public void download_the_pdf_by_clicking_on_the_total_advance_pdf_icon() throws Exception {
		// clicking on the total receipt
		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
		Thread.sleep(2000);
	}

	@And("download the invoice by clicking on the print icon in the page bottom")
	public void download_the_invoice_by_clicking_on_the_print_icon_in_the_page_bottom() throws Exception {
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
	}

	@When("user click on the share invoice to share the invoice")
	public void user_click_on_the_share_invoice_to_share_the_invoice() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("clearing the already given mail and mobile number to enter new mail")
	public void clearing_the_already_given_mail_and_mobile_number_to_enter_new_mail() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enter the email id to whom we are sharing the invoice")
	public void enter_the_email_id_to_whom_we_are_sharing_the_invoice() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
	}

	@And("click on submit button to share invoice")
	public void click_on_submit_button_to_share_invoice() throws Exception {
		// submit
		WebElement submit1 = driver
				.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		submit1.click();
		Thread.sleep(15000);
	}

	@Then("switch the role to radiologytechnician to fillup the form")
	public void switch_the_role_to_radiologytechnician_to_fillup_the_form() throws Exception {
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Radiology_Technician'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("fill the form and submit and forward it to radiologist role")
	public void fill_the_form_and_submit_and_forward_it_to_radiologist_role() throws Exception {
		// searching with patient name
		driver.findElement(By.xpath("(//input[@id='q_patient_master_frst_nm_cont'])[1]")).sendKeys("Cucum");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Growth Scan Term'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div[2]/div/fieldset/input[9]"))
				.sendKeys("test lmp");
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div[2]/div/fieldset/input[9]"))
				.sendKeys("test lmp");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		// Press Tab key
		action.sendKeys(Keys.TAB).perform();
		// Send some text
		action.sendKeys("test edd by date").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Press Tab key
		action.sendKeys(Keys.TAB).perform();
		// Send some text
		action.sendKeys("test edd by scan").perform();
		action.sendKeys(Keys.TAB).perform();
		// Send some text
		action.sendKeys("test one indication bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("test two indication bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("test three indication bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.UP).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("test in b/w indication bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		action.sendKeys(Keys.TAB).perform();
		// Send some text
		action.sendKeys("test cervix length").perform();
		action.sendKeys(Keys.TAB).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement radio1 = driver.findElement(By.xpath("(//label[text()='Variable'])[1]"));
		radio1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[2]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='files_constr'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Prescription.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100);");
		driver.findElement(By.xpath("(//input[@multiple='multiple'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Radiologytechnician.png");
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);
		WebElement longitudinal = driver.findElement(By.xpath("(//label[text()='Longitudinal'])[1]"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", longitudinal);
		Thread.sleep(1000);
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		WebElement radio3 = driver.findElement(By.xpath("(//label[text()='Anterior'])[1]"));
		radio3.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		WebElement radio4 = driver.findElement(By.xpath("(//label[text()='Gradei'])[1]"));
		radio4.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js1111 = (JavascriptExecutor) driver;
		js1111.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		WebElement radio5 = driver.findElement(By.xpath("(//label[text()='Absent'])[1]"));
		radio5.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js11111 = (JavascriptExecutor) driver;
		js11111.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		WebElement radio6 = driver.findElement(By.xpath("(//label[text()='Present'])[2]"));
		radio6.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[normalize-space(text())='Fetal Heart Rate']/ancestor::legend/following-sibling::input"))
				.sendKeys("1234567890");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);

		action.sendKeys(Keys.TAB).perform();
		// Send some text
		action.sendKeys("test bpd table data for measurements[cms]").perform();
//				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.TAB).perform();
//				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*
		 * // action.sendKeys(Keys.TAB).perform();
		 */// Thread.sleep(1000);
		action.sendKeys("test bpd table data for pog").perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys("test hc table data for measurements").perform();
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		JavascriptExecutor j7 = (JavascriptExecutor) driver;
		j7.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);

//				action.sendKeys(Keys.TAB).perform();
//				Thread.sleep(1000);
		action.sendKeys("123455").perform();
//				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		action.sendKeys("test123").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.TAB).perform();
//				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.TAB).perform();
//				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("abctes51").perform();
//				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys("102839302").perform();
		Thread.sleep(1000);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js41 = (JavascriptExecutor) driver;
		js41.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[normalize-space(text())='Estimated Fetal Weight']/ancestor::legend/following-sibling::input"))
				.sendKeys("56789");
		Thread.sleep(1000);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);

		WebElement two = driver.findElement(By.xpath("(//label[text()='2'])[1]"));
		two.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement zero = driver.findElement(By.xpath("(//label[text()='0'])[2]"));
		zero.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement one = driver.findElement(By.xpath("(//label[text()='1'])[3]"));
		two.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement zero1 = driver.findElement(By.xpath("(//label[text()='0'])[4]"));
		zero1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space(text())='Total']/ancestor::legend/following-sibling::input"))
				.sendKeys("test total");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		js7.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);

		action.sendKeys(Keys.TAB).perform();
		// Send some text
		action.sendKeys("test one impression bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("test two impression bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("test three impression bullet point question").perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.UP).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.sendKeys("test in b/w impression bullet point question").perform();
		Thread.sleep(1000);
		JavascriptExecutor js88 = (JavascriptExecutor) driver;
		js88.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);

//		// entering the notes
//		WebElement notes = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
//		notes.sendKeys("Test notes");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//select[@class='quill-sel browser-default'])[2]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@data-value='huge'])[1]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Test notes in huge");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[2]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@data-value='serif'])[1]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Test notes in serif");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[2]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@data-value='monospace'])[1]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Test notes in monoscope");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// selecting bold button
//		driver.findElement(By.xpath("(//button[@class='ql-bold'])[1]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Test notes in bold");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////				// selecting italic button
////				driver.findElement(By.xpath("(//button[@class='ql-italic'])[1]")).click();
////				Thread.sleep(1000);
////				notes.sendKeys("Test notes in italic");
////				Thread.sleep(1000);
////				action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		// selecting underline button
//		driver.findElement(By.xpath("(//button[@class='ql-underline'])[1]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Test notes in underline");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// selecting strike button
//		driver.findElement(By.xpath("(//button[@class='ql-strike'])[1]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Test notes in strike");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// selecting a and colour and entering text
//		driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[3]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@class='ql-picker-options'])[3]/span[2]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Text colour");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// selecting a and colour and entering text
//		driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[4]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@class='ql-picker-options'])[4]/span[5]")).click();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Text colour in colouring");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
////				Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// clicking on the num button
//		driver.findElement(By.xpath("(//button[@class='ql-list'])[1]")).click();
//		Thread.sleep(1000);
//		notes.sendKeys("Number test notes1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		action.sendKeys(Keys.ENTER).perform();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		notes.sendKeys("Number test notes2");
//		Thread.sleep(1000);

		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space(text())='Disclaimer']/ancestor::fieldset[1]//textarea[1]"))
				.sendKeys("test disclaimer" + Keys.ENTER);
		driver.findElement(By.xpath("//div[normalize-space(text())='Disclaimer']/ancestor::fieldset[1]//textarea[1]"))
				.sendKeys("test disclaimer two" + Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space(text())='Disclaimer']/ancestor::fieldset[1]//textarea[1]"))
				.sendKeys("test disclaimer three");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])")).click();
		Thread.sleep(5000);

		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js71 = (JavascriptExecutor) driver;
			js71.executeScript("window.scrollBy(0, 200);");
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js71 = (JavascriptExecutor) driver;
			js71.executeScript("window.scrollBy(0, 200);");
			Thread.sleep(1000);
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space(text())='Disclaimer']/ancestor::fieldset[1]//textarea[1]"))
				.clear();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])")).click();
		Thread.sleep(5000);

		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js71 = (JavascriptExecutor) driver;
			js71.executeScript("window.scrollBy(0, 200);");
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		// forward
		driver.findElement(By.xpath("(//a[text()='Forward'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(5000);
	}

	@Then("switch the role to radiologist to approve")
	public void switch_the_role_to_radiologist_to_approve() throws Exception {
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Radiologist'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Reported'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='q_patient_master_frst_nm_cont'])[1]")).sendKeys("Cucum");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Growth Scan Term'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div[2]/div/fieldset/input[9]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div[2]/div/fieldset/input[9]"))
				.sendKeys("updated test lmp data from radiologist role");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])")).click();
		Thread.sleep(5000);
		// edit
		driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js71 = (JavascriptExecutor) driver;
			js71.executeScript("window.scrollBy(0, 200);");
			Thread.sleep(1000);
		}
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[normalize-space(text())='Disclaimer']/ancestor::fieldset[1]//textarea[1]"))
				.sendKeys("Resubmitted the form from radiologist role");
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(3000);

	}

	@And("from radiologist role click on approve button")
	public void from_radiologist_role_click_on_approve_button() throws Exception {
		// Approve
		driver.findElement(By.xpath("(//a[text()='Approve'])[1]")).click();
		Thread.sleep(5000);
		Actions pdf1 = new Actions(driver);
		pdf1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		pdf1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);

		Actions pdf11 = new Actions(driver);
		pdf11.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		pdf11.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(5000);
		driver.close();

	}
}
