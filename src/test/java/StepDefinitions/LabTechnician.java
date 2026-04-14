package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabTechnician {

	WebDriver driver = null;

	@Given("navigate_to_nanohealth_on_google_chrome {string}")
//	public void navigate_to_nanohealth_on_google_chrome() throws Exception {
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

	@Then("login with clinicmanger detail emailcm {string} and passwordcm {string}")
	public void login_with_clinicmanger_detail_emailcm_and_passwordcm(String emailcm, String passwordcm)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys(emailcm);
		driver.findElement(By.id("user_password")).sendKeys(passwordcm);
		Thread.sleep(15000);
	}

	@And("clicking on the sign_in button to login")
	public void clicking_on_the_sign_in_button_to_login() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("selecting_the_cdp_admin_profile")
	public void selecting_the_cdp_admin_profile() throws Exception {
//		 selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on cdpadmin manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("deleting exists patient using search")
	public void deleting_exists_patient_using_search() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("frst_nm")).sendKeys("8790298141");
		Thread.sleep(2000);
//		// clicking on the name
//		driver.findElement(By.xpath("//a[text()='Demo Labtechnician']")).click();
//		Thread.sleep(2000);
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
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("existing patient deleted successfully")
	public void existing_patient_deleted_successfully() {

	}

	@And("click on the add_patient_icon for patient registration")
	public void click_on_the_add_patient_icon_for_patient_registration() throws Exception {
		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		 selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the add patient
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img")).click();
		Thread.sleep(12000);
	}

	@Then("selecting title_of_patient")
	public void selecting_title_of_patient() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
//		// selecting the title
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
//		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("user enter the following into the registration form")
	public void user_enter_the_following_into_the_registration_form(DataTable dataTable) {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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

	@Then("selecting the radio_buttons")
	public void selecting_the_radio_buttons() throws Exception {
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
//		// abhacard
//		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
//		ac.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
//		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("767676");
//		// profession
//		driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test profession");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// referred by
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
		Thread.sleep(1000);
		// clinic
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#referral_name:nth-of-type(1)")).sendKeys("test name");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#referral_clinic:nth-of-type(1)")).sendKeys("NH_OP hospital");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
		Thread.sleep(2000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(1000);
//				Robot robot = new Robot();
//				robot.keyPress(KeyEvent.VK_TAB);
//				Thread.sleep(1000);
	}

	@And("click on submit_button_to_register_patient")
	public void click_on_submit_button_to_register_patient() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update_submit")))).click();
//		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(12000);
	}

	@Then("it will redirect to patient_profile")
	public void it_will_redirect_to_patient_profile() {
//		System.out.println("Patient successfully registered. You are in the patient profile");

	}

	@When("user click on Book_Diagnostic_Appointment from Book Appointment section")
	public void user_click_on_book_diagnostic_appointment_from_book_appointment_section() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")).click();
		Thread.sleep(3000);
	}

	@Then("avaiable labs and tests will be displayed")
	public void avaiable_labs_and_tests_will_be_displayed() {

	}

	@And("selecting the thyrocare lab from lab name dropdown")
	public void selecting_the_thyrocare_lab_from_lab_name_dropdown() throws Exception {
		// clicking on the drop down
		driver.findElement(By.cssSelector("span.selection")).click();
		Thread.sleep(2000);
		// thyrocare
		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
		Thread.sleep(5000);

	}

	@When("list of tests are displayed from thyrocare lab")
	public void list_of_tests_are_displayed_from_thyrocare_lab() {
	}

	@Then("selecting the test for diagnosticbooking")
	public void selecting_the_test_for_diagnosticbooking() throws Exception {
		// searching the FBS test
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='myInput'])[1]"));

		String text = "FBS";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Thread.sleep(2000);
		// clicking on the plus
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		// Thread.sleep(2000); // removing last added
		// driver.findElement(By.xpath("(//a/i[text()='remove'])[3]")).click();
		// Thread.sleep(2000);
	}

	@And("clicking on the checkout from cartsummary")
	public void clicking_on_the_checkout_from_cartsummary() throws Exception {
		// clicking on the checkout button
		driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
	}

	@Then("Types will be displayed select the type")
	public void types_will_be_displayed_select_the_type() throws Exception {
		// selecting the type - Lab-visit
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);

	}

	@And("select the location address")
	public void select_the_location_address() throws Exception {
//		// selecting the location - address
//		driver.findElement(
//				By.xpath("(//div[@id='lab_saved-addresses'])[1]//following-sibling::div/div/div/div/div/span[1]"))
//				.click();
//		Thread.sleep(2000);
	}

	@Then("select the datetime and slot time")
	public void select_the_datetime_and_slot_time() throws Exception {
		/*
		 * // try { // if (driver.findElement(By.
		 * xpath("//div[@class='slots-container']//span[contains(text(), 'AM')]")) //
		 * .isDisplayed()) { // WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(10)); // JavascriptExecutor js = (JavascriptExecutor)
		 * driver; // // // Find all available slots // List<WebElement> slots = driver
		 * // .findElements(By.
		 * xpath("//div[@class='slots-container']//span[contains(text(), 'AM')]")); //
		 * // if (!slots.isEmpty()) { // for (WebElement slot : slots) { // if
		 * (slot.isDisplayed() && slot.isEnabled()) { // try { //
		 * wait.until(ExpectedConditions.elementToBeClickable(slot)); //
		 * js.executeScript("arguments[0].scrollIntoView(true);", slot); //
		 * Thread.sleep(500); // Small pause to ensure visibility //
		 * js.executeScript("arguments[0].click();", slot); //
		 * System.out.println("Selected time slot: " + slot.getText()); // break; // }
		 * catch (Exception e) { // System.out.println("Failed to click slot: " +
		 * slot.getText()); // } // } // } // } else { //
		 * System.out.println("No available time slots found."); // } //
		 * Thread.sleep(2000); // // } else { // WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10)); // JavascriptExecutor js =
		 * (JavascriptExecutor) driver; // // // Find all available slots //
		 * List<WebElement> slots = driver // .findElements(By.
		 * xpath("//div[@class='slots-container']//span[contains(text(), 'PM')]")); //
		 * // if (!slots.isEmpty()) { // for (WebElement slot : slots) { // if
		 * (slot.isDisplayed() && slot.isEnabled()) { // try { //
		 * wait.until(ExpectedConditions.elementToBeClickable(slot)); //
		 * js.executeScript("arguments[0].scrollIntoView(true);", slot); //
		 * Thread.sleep(500); // Small pause to ensure visibility //
		 * js.executeScript("arguments[0].click();", slot); //
		 * System.out.println("Selected time slot: " + slot.getText()); // break; // }
		 * catch (Exception e) { // System.out.println("Failed to click slot: " +
		 * slot.getText()); // } // } // } // } else { //
		 * System.out.println("No available time slots found."); // } //
		 * Thread.sleep(2000); // // } // } catch (Exception e) { // // TODO: handle
		 * exception // }
		 */
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		// Find all available slots
//		List<WebElement> slots = driver
//				.findElements(By.xpath("//div[@class='slots-container']//span[contains(text(), 'PM')]"));
//
//		if (!slots.isEmpty()) {
//			for (WebElement slot : slots) {
//				if (slot.isDisplayed() && slot.isEnabled()) {
//					try {
//						wait.until(ExpectedConditions.elementToBeClickable(slot));
//						js.executeScript("arguments[0].scrollIntoView(true);", slot);
//						Thread.sleep(500); // Small pause to ensure visibility
//						js.executeScript("arguments[0].click();", slot);
//						System.out.println("Selected time slot: " + slot.getText());
//						break;
//					} catch (Exception e) {
//						System.out.println("Failed to click slot: " + slot.getText());
//					}
//				}
//			}
//		} else {
//			System.out.println("No available time slots found.");
//		}
		// Try AM first
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		List<WebElement> am = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));
		boolean selected = false;

		for (WebElement slot : am) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				js11.executeScript("arguments[0].click();", slot);
				selected = true;
				break;
			}
		}

		if (!selected) {
			// Try PM next
			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));
			for (WebElement slot : pm) {
				if (slot.isDisplayed() && slot.isEnabled()) {
					js11.executeScript("arguments[0].click();", slot);
					break;
				}
			}
		}

	}

	@Then("selecting referredby by searching and entering delivery charges")
	public void selecting_referredby_by_searching_and_entering_delivery_charges() throws Exception {
//		// entering referred by
//		driver.findElement(By.xpath("(//input[@id='referred_by'])[1]")).sendKeys("d");
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(3000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//
//		try {
//			// entering the delivery charges
//			driver.findElement(By.xpath("(//input[@id='delivery_charges'])[1]")).sendKeys("50");
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}

	@And("enabling the checkboxes from notify patient")
	public void enabling_the_checkboxes_from_notify_patient() throws Exception {
//		// clicking on the check boxes
//		WebElement cbox1 = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
//		cbox1.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebElement cbox2 = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
//		cbox2.click();
//		Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the submit button from invoicepage")
	public void click_on_the_submit_button_from_invoicepage() throws Exception {
		// clicking on the submit
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(5000);
	}

	@When("proformainvoice page will be opened for diagnostic booking")
	public void proformainvoice_page_will_be_opened_for_diagnostic_booking() {

	}

	@Then("select the paymentmethod radio button")
	public void select_the_paymentmethod_radio_button() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the cash btn
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(2000);
	}

	@When("user enter the transaction amount then receipt comment will be visible")
	public void user_enter_the_transaction_amount_then_receipt_comment_will_be_visible() throws Exception {
		// entering the amount
		driver.findElement(By.id("advance_field")).sendKeys("50");
		Thread.sleep(2000);
	}

	@Then("click on receipt comment and enter the comment")
	public void click_on_receipt_comment_and_enter_the_comment() throws Exception {
		// clicking on the comment
		driver.findElement(By.id("paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.id("payment_cmnt")).sendKeys("test receipt comment 1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);

	}

	@Then("click on the submit button inthe proforma invoice for diagnosticbooking")
	public void click_on_the_submit_button_inthe_proforma_invoice_for_diagnosticbooking() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("bookNowBtn")))).click();
//		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(2000);
	}

//	@And("clicking on the datewise and servicewise buttons in the diagnosticbooking proformainvoicepage")
//	public void clicking_on_the_datewise_and_servicewise_buttons_in_the_diagnosticbooking_proformainvoicepage()
//			throws Exception {
////		// clicking on the datewise
////		driver.findElement(By.xpath("//input[@id='date_wise_btn']")).click();
////		Thread.sleep(2000);
////		// clicking on the service wise
////		driver.findElement(By.xpath("//input[@id='service_wise_btn']")).click();
////		Thread.sleep(2000);
//	}
//
//	@And("click on share_invoice_button")
//	public void click_on_share_invoice_button() throws Exception {
////		Robot robot1 = new Robot();
////		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
////		Thread.sleep(1000);
////		// clicking on the share invoice
////		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[9]/a[3]")).click();
////		Thread.sleep(2000);
//	}
//
//	@When("clears existing mailandphone for diagnosticbooking")
//	public void clears_existing_mailandphone_for_diagnosticbooking() throws Exception {
////		driver.findElement(By.id("emails")).clear();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////		driver.findElement(By.id("phone")).clear();
////		Thread.sleep(2000);
//
//	}
//
//	@Then("enter mail and click on submit button to share diagnosticproformainvoice")
//	public void enter_mail_and_click_on_submit_button_to_share_diagnosticproformainvoice() throws Exception {
////		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
////		Thread.sleep(1000);
////		// clicking on the submit button
////		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
////		Thread.sleep(20000);
//	}
//
//	@When("diagnosticproformainvoice is shared successfully")
//	public void diagnosticproformainvoice_is_shared_successfully() {
//	}

	@Then("click on the brand logo")
	public void click_on_the_brand_logo() throws Exception {
		// clicking on the brand logo
		driver.findElement(By.xpath("//a[@class='brand-logo']/img")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the labtechnician role")
	public void click_on_the_labtechnician_role() throws Exception {
		// clickin on the labtechnician role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Lab_Technician'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("labtechnician role dashboard will be opened")
	public void labtechnician_role_dashboard_will_be_opened() {
	}

	@And("Click on the appointmentid under confirmed in Labtechnician dashboard")
	public void click_on_the_appointmentid_under_confirmed_in_labtechnician_dashboard() throws Exception {
		// clicking on the first apt id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)")).click();
		Thread.sleep(1000);

	}

	@Then("click on the collected and status will be collected")
	public void click_on_the_collected_and_status_will_be_collected() throws Exception {
		// collected
		driver.findElement(By.xpath("//a[text()='Collected']")).click();
		Thread.sleep(1000);

	}

	@And("click on the dashboard for labtechnician role")
	public void click_on_the_dashboard_for_labtechnician_role() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-dashboard'])[2]")).click();
		Thread.sleep(2000);
	}

	@When("dashboard is opened click on the collected status")
	public void dashboard_is_opened_click_on_the_collected_status() throws Exception {
		// clicking on the collected
		driver.findElement(By.cssSelector("ul.tabs.card>li:nth-of-type(2)>a")).click();
		Thread.sleep(2000);
	}

	@Then("click on the appointmentid under collected in Labtechnician dashboard")
	public void click_on_the_appointmentid_under_collected_in_labtechnician_dashboard() throws Exception {
		// clicking on the first appt id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)")).click();
		Thread.sleep(2000);

	}

	@And("click on the delivered button and status will be delivered")
	public void click_on_the_delivered_button_and_status_will_be_delivered() throws Exception {
		// delivered
		driver.findElement(By.xpath("//a[text()='Delivered']")).click();
		Thread.sleep(2000);
	}

	@Then("click on the dashboard for labtechnician")
	public void click_on_the_dashboard_for_labtechnician() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-dashboard'])[2]")).click();
		Thread.sleep(2000);
	}

	@When("dashboard is opened click on the delivered status")
	public void dashboard_is_opened_click_on_the_delivered_status() throws Exception {
		// clicking on the delivered
		WebDriverWait delivered = new WebDriverWait(driver, Duration.ofSeconds(30));
		delivered.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("ul.tabs.card>li:nth-of-type(3)>a"))))
				.click();
		Thread.sleep(4000);

	}

	@Then("click on the appointmentid under delivered in Labtechnician dashboard")
	public void click_on_the_appointmentid_under_delivered_in_labtechnician_dashboard() throws Exception {
		// clicking on the first appt id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@When("click on the plus button for add diagnostic test")
	public void click_on_the_plus_button_for_add_diagnostic_test() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1000);
		// clicking on the qr to download
		Actions qr = new Actions(driver);
		qr.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Click to download'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		qr.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Click to download'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// adding new diagnostic test
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(2000);
	}

	@Then("Add Diagnostic Tests popup will be opened")
	public void add_diagnostic_tests_popup_will_be_opened() {

	}

	@And("select the tests from dropdown")
	public void select_the_tests_from_dropdown() throws Exception {
		// drop down clicking
		driver.findElement(By.xpath("//span[@class='selection']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Sodium']")).click();
		Thread.sleep(1000);
		// drop down clicking
		driver.findElement(By.xpath("//span[@class='selection']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Chloride']")).click();
		Thread.sleep(1000);
		// drop down clicking
		driver.findElement(By.xpath("//span[@class='selection']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='PPBS'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("deleting the recently added test and saving")
	public void deleting_the_recently_added_test_and_saving() throws Exception {
		// deleting the test = sodium
		driver.findElement(By.xpath("//tr[td[contains(normalize-space(.),'Sodium')]]//i[@data-tooltip='Delete'][1]"))
				.click();
		Thread.sleep(1000);
		// clicking on the yes
		driver.findElement(By.xpath("//a[text()='Yes']")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@And("upload the reports by clicking on the Upload Reports")
	public void upload_the_reports_by_clicking_on_the_upload_reports() throws Exception {
		// uploading the reports
		driver.findElement(By.xpath("//a[text()='Upload Reports']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("files_constr")).sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Fbs_chloride_ppbs.pdf");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[2]/input")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("labreport will be uploaded successfully")
	public void labreport_will_be_uploaded_successfully() {

	}

	@And("click on the pdf then it will opened in new window")
	public void click_on_the_pdf_then_it_will_opened_in_new_window() throws Exception {
//		driver.findElement(By.cssSelector("img.responsive-img.photo.img")).click();
//		Thread.sleep(1000);

		// Store the main window handle
		String mainWindow = driver.getWindowHandle();

		// Click on the image that opens PDF in a new tab
		driver.findElement(By.xpath("//img[@class='responsive-img photo img']")).click();

		// Wait for the new tab to open
		Thread.sleep(2000);

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Loop through handles to find the new tab
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				// Switch to the new tab
				driver.switchTo().window(windowHandle);

				// Wait 2 seconds in the new tab
				Thread.sleep(2000);

				// Close the new tab
				driver.close();

				// Switch back to main window
				driver.switchTo().window(mainWindow);
				break;
			}
		}
	}

	@And("click on the Edit digitisation order page")
	public void click_on_the_edit_digitisation_order_page() throws Exception {
		// clicking on the EDIT
		driver.findElement(By.xpath("(//a[@class='btn green'])[1]")).click();
		Thread.sleep(3000);
		Robot robot33 = new Robot();
		robot33.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
	}

	@When("clicking on the dropdown and selecting the lab")
	public void clicking_on_the_dropdown_and_selecting_the_lab() throws Exception {
		// clicking on the dropdown
		try {
			driver.findElement(By.xpath("//span[@class='selection'][1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("entering the data into the technology_readings_units")
	public void entering_the_data_into_the_technology_readings_units() {
		// technology
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[2]/input[2]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[2]/input[2]")).sendKeys("test1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// result
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[3]/input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[3]/input")).sendKeys("80");
//		// units
//		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[4]/input")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[4]/input")).sendKeys("mg/dL");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// idealrange
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[5]/input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[5]/input")).sendKeys("70-100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// technology
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[2]/input[2]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[2]/input[2]")).sendKeys("test2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// result
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[3]/input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[3]/input")).sendKeys("90");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// units
//		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[4]/input")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[4]/input")).sendKeys("mmol/L");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[5]/input")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// idealrange
//		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[5]/input"))
//				.sendKeys("136 - 145");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		 technology
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[2]/input[2]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[2]/input[2]")).sendKeys("test2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// result
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[3]/input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[3]/input")).sendKeys("90");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@And("entering the comments for each individual test")
	public void entering_the_comments_for_each_individual_test() throws Exception {
		// entering the comments for the tests
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[6]/a/img[1]")).click();
		Thread.sleep(1000);
		// entering the comment
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[2]/div[2]/input"))
				.sendKeys("test comments for F.B.S");
		Thread.sleep(1000);
		// clicking again on the icon to close
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[6]/a/img[2]")).click();
		Thread.sleep(1000);
		// entering the comments for the tests
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[6]/a/img[1]")).click();
		Thread.sleep(1000);
		// entering the comment
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[2]/div[2]/input"))
				.sendKeys("test comment for Chloride");
		Thread.sleep(1000);
		// clicking again on the icon to close
		driver.findElement(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[6]/a/img[2]")).click();
		Thread.sleep(1000);

		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
	}

	@Then("entering the comments")
	public void entering_the_comments() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("prescriptionComments")).sendKeys("demo test comments from lab technician role");
		Thread.sleep(1000);
	}

	@And("click on the update button")
	public void click_on_the_update_button() throws Exception {
		// update
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Update'])[1]"))))
				.click();
//		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the test checkboxes and deselecting one of them")
	public void selecting_the_test_checkboxes_and_deselecting_one_of_them() throws Exception {
		for (int i = 0; i <= 1; i++) {
			WebElement cbox1 = driver
					.findElement(By.cssSelector("tbody#saved_lab_result>tr:nth-of-type(1)>td:nth-of-type(1)>label"));
			cbox1.click();
		}
		Thread.sleep(1000);
		WebElement cbox2 = driver
				.findElement(By.cssSelector("tbody#saved_lab_result>tr:nth-of-type(3)>td:nth-of-type(1)>label"));
		cbox2.click();
		Thread.sleep(1000);
	}

	@When("checkboxes are selected then only selected tests results will be printed in the pdfs")
	public void checkboxes_are_selected_then_only_selected_tests_results_will_be_printed_in_the_pdfs() {

	}

	@Then("clicking on the preview button")
	public void clicking_on_the_preview_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Preview'])[1]")))).click();
//		driver.findElement(By.xpath("(//a[text()='Preview'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("downloading the pdfs with_without header_footers")
	public void downloading_the_pdfs_with_without_header_footers() throws Exception {
		// mouse hovering on the print with header and footer
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]")))
				.build().perform();
		Thread.sleep(1000);

		// print with header & footer
		driver.findElement(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]")).click();
		Thread.sleep(5000);
//		// clicking on the preview
//		driver.findElement(By.xpath("(//a[text()='Preview'])[1]")).click();
//		Thread.sleep(2000);
		// mouse hovering on the print without header and footer
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// print without header & footer
		driver.findElement(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]")).click();
		Thread.sleep(5000);
		// closing the popup
		driver.findElement(By.xpath("(//a[text()='No'])[1]")).click();
		Thread.sleep(2000);

	}

	@Then("clicking on the forward button")
	public void clicking_on_the_forward_button() throws Exception {
		// forward
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Forward'][1]")))).click();
//		driver.findElement(By.xpath("//a[text()='Forward']")).click();
		Thread.sleep(3000);
//		Actions id = new Actions(driver);
//		id.moveToElement(driver.findElement(By.xpath("(//div[@class='card'])[1]/div[2]/div[1]/div[2]/div[1]/div[2]")))
//				.doubleClick().build().perform();
//		Thread.sleep(2000);
//		WebElement element = driver
//				.findElement(By.xpath("(//div[@class='card'])[1]/div[2]/div[1]/div[2]/div[1]/div[2]"));
//
//		Actions actions = new Actions(driver);
//
//		// Double click to select text
//		actions.doubleClick(element).perform();
//
//		// Copy
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_C);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_C);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);

	}

	@When("Lab Report forwarded")
	public void lab_report_forwarded() {
	}

	@Then("clicking on the brand logo1")
	public void clicking_on_the_brand_logo1() throws Exception {
		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("selecting the pathologist role from the roles")
	public void selecting_the_pathologist_role_from_the_roles() throws Exception {
		Thread.sleep(1000);
		// clicking on the pathologist
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pathologist'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("pathologist dashboard is opened")
	public void pathologist_dashboard_is_opened() {
	}

	@Then("clicking on the digitalized status from the dashborad")
	public void clicking_on_the_digitalized_status_from_the_dashborad() throws Exception {
		driver.findElement(By.xpath("(//li[@class='tab col s2'])[4]/a[1]")).click();
		Thread.sleep(3000);
//		Actions actions = new Actions(driver);
//		// Target element where you want to paste
//		WebElement target = driver.findElement(By.cssSelector("input#frst_nm"));
//		// Paste
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
	}

	@And("clicking on the appointmentid of the patient")
	public void clicking_on_the_appointmentid_of_the_patient() throws Exception {

		// clicking on the first apt id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)")).click();
		Thread.sleep(2000);
		Robot robot7 = new Robot();
		robot7.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@When("digitisation page opens")
	public void digitisation_page_opens() {
	}

	@Then("click on the edit button from the pathologist role")
	public void click_on_the_edit_button_from_the_pathologist_role() throws Exception {
		// clicking on the EDIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='btn green'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//a[@class='btn green'])[1]")).click();
		Thread.sleep(5000);
//		// clicking on the pdf img
//		driver.findElement(By.xpath("//img[@class='responsive-img photo img']")).click();
//		Thread.sleep(5000);

		// Store the main window handle
		String mainWindow = driver.getWindowHandle();

		// Click on the image that opens PDF in a new tab
		driver.findElement(By.xpath("//img[@class='responsive-img photo img']")).click();

		// Wait for the new tab to open
		Thread.sleep(2000);

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Loop through handles to find the new tab
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				// Switch to the new tab
				driver.switchTo().window(windowHandle);

				// Wait 2 seconds in the new tab
				Thread.sleep(2000);

				// Close the new tab
				driver.close();

				// Switch back to main window
				driver.switchTo().window(mainWindow);
				break;
			}
		}
	}

	@And("clear and update the comments from the pathologist role")
	public void clear_and_update_the_comments_from_the_pathologist_role() throws Exception {
		driver.findElement(By.id("prescriptionComments")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("prescriptionComments")).sendKeys("Updated from the pathologist role comments");
		Thread.sleep(2000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='Update'][1]"))))
				.click();
//		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(3000);
		Robot robot35 = new Robot();
		robot35.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("downloading the pdf")
	public void downloading_the_pdf() throws Exception {
		/*
		 * // // clicking on the pdf img //
		 * driver.findElement(By.cssSelector("img.responsive-img.photo.img")).click();
		 * // Thread.sleep(3000);
		 */

	}

	@When("click on the preview button")
	public void click_on_the_preview_button() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Preview'])[1]")))).click();
//		// driver.findElement(By.xpath("(//a[text()='Preview'])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("downloading pdfs with and without header footer")
	public void downloading_pdfs_with_and_without_header_footer() throws Exception {

	}

	@And("click on the approve button")
	public void click_on_the_approve_button() throws Exception {
		// clicking on the approve
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Approve']")))).click();
//		driver.findElement(By.xpath("//a[text()='Approve']")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// Store the parent window handle
		String parentWindow = driver.getWindowHandle();
		// Click on the image to open the child window
		driver.findElement(By.xpath("(//img[@class='responsive-img photo img'])[1]")).click();
		Thread.sleep(3000);
		// Wait for the new window to open
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.numberOfWindowsToBe(2));
		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window); // Switch to the child window
				System.out.println("Switched to child window: " + driver.getTitle());
				driver.close(); // Close the child window
				break;
			}
		}
		Thread.sleep(2000);
		// Switch back to the parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Switched back to parent window: " + driver.getTitle());

		// Store the parent window handle
		String parentWindow2 = driver.getWindowHandle();
		// Click on the second image to open the child window
		driver.findElement(By.xpath("(//img[@class='responsive-img photo img'])[2]")).click();
		Thread.sleep(2000);
		// Wait for the child window to open
		WebDriverWait wait21 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait21.until(ExpectedConditions.numberOfWindowsToBe(2));
		// Get all window handles
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String window : allWindows1) {
			if (!window.equals(parentWindow2)) {
				driver.switchTo().window(window); // Switch to child window
				System.out.println("Switched to child window: " + driver.getTitle());
				driver.close(); // Close the child window
				break;
			}
		}
		Thread.sleep(3000);
		// Switch back to the parent window
		driver.switchTo().window(parentWindow2);
		System.out.println("Switched back to parent window: " + driver.getTitle());
		Thread.sleep(3000);

		// mouse hovering on the print with header and footer
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]")))
				.build().perform();
		Thread.sleep(1000);
		// print with header & footer
		driver.findElement(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]")).click();
		Thread.sleep(5000);
		// mouse hovering on the print with header and footer
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// print without header & footer
		driver.findElement(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]")).click();
		Thread.sleep(5000);
	}

	@When("Lab Report approved")
	public void lab_report_approved() {

	}

	@Then("clicking on the Nanohealth brand logo")
	public void clicking_on_the_nanohealth_brand_logo() throws Exception {
		// clicking on the logo
		driver.findElement(By.xpath("//a[@class='brand-logo']")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("select the clinic manager profile NH_IP+OP")
	public void select_the_clinic_manager_profile_nh_ip_op() throws Exception {
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("dashboard is open mouse hover to the appointments")
	public void dashboard_is_open_mouse_hover_to_the_appointments() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.cssSelector("a#admin-apmnts"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-diagnostics'])[2]"))).click().build()
				.perform();
		Thread.sleep(3000);
	}

	@Then("click on the diagnostic lab orders list")
	public void click_on_the_diagnostic_lab_orders_list() {

	}

	@And("click on the Approved status")
	public void click_on_the_approved_status() throws Exception {
		// approved status
		driver.findElement(By.xpath("(//li[@class='tab col s2'])[4]")).click();
		Thread.sleep(2000);
	}

	@When("list of approved patients list will be displayed and click on the aptid")
	public void list_of_approved_patients_list_will_be_displayed_and_click_on_the_aptid() throws Exception {
		driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@Then("from popup copyaddress_downloadinvoice_view")
	public void from_popup_copyaddress_downloadinvoice_view() throws Exception {
		driver.findElement(By.id("copy_link_icon")).click();
		Thread.sleep(1000);
		// clicking on the proforma invoice
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img"))))
				.click();
//		driver.findElement(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img")).click();
		Thread.sleep(2000);
	}

	@And("downloading the labreports with and without header footer")
	public void downloading_the_labreports_with_and_without_header_footer() throws Exception {
		// mouse hovering on the print with header and footer
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);

		// print with header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(5000);

		// mouse hovering on the print with header and footer
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);

		// print without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(5000);

	}

	@Then("click on the complete status")
	public void click_on_the_complete_status() throws Exception {
		// clicking on the complete
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Complete'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//a[text()='Complete'])[1]")).click();
		Thread.sleep(5000);
		// yes
		driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
		Thread.sleep(10000);
	}

	@When("status is changed to completed")
	public void status_is_changed_to_completed() {
	}

	@Then("click on the completed status from the header")
	public void click_on_the_completed_status_from_the_header() throws Exception {
		// clicking on the complete status
		driver.findElement(By.xpath("(//li[@class='tab col s2'])[5]")).click();
		Thread.sleep(8000);
	}

	@And("click on the appointment id of the completed status of the lab")
	public void click_on_the_appointment_id_of_the_completed_status_of_the_lab() throws Exception {
		// clicking on the appointment id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)")).click();
		Thread.sleep(2000);

	}

	@When("apt id is clikced popup  will open")
	public void apt_id_is_clikced_popup_will_open() {

	}

	@Then("click on the inovice and download the pdfs with and without header_footer")
	public void click_on_the_inovice_and_download_the_pdfs_with_and_without_header_footer() throws Exception {
		// clicking on the proforma invoice
		driver.findElement(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img")).click();
		Thread.sleep(2000);

		// mouse hovering on the print with header and footer
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);

		// print with header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(2000);

		// mouse hovering on the print with header and footer
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);

		// print without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(2000);

		// feedback form
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Send Feedback link'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[@data-tooltip='Send Feedback link'])[1]/img")).click();
		Thread.sleep(1000);

		// selecting the sms radio button
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);
		// send
		driver.findElement(By.xpath("(//input[@value='Send'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[contains(text(),'Demo Labtechnician')])")).click();
		Thread.sleep(3000);
		Actions uploads = new Actions(driver);
		uploads.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Upload Medical Documents'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		uploads.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Upload Lab Reports'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='unified-document-input'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Fbs_chloride_ppbs.pdf");
		Thread.sleep(10000);
		WebElement checkbox = driver.findElement(By.xpath("(//strong[@id='expected-patient-name'])[1]"));
		checkbox.click();
		Thread.sleep(2000);
		//clicking on the confirm button
		driver.findElement(By.xpath("(//button[@id='confirm-type-btn'])[1]/i[1]")).click();
		Thread.sleep(3000);
		//clicking on the upload document button
		driver.findElement(By.xpath("(//button[@id='footer-upload-btn'])[1]/i[1]")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		//clicking on the history btn
		driver.findElement(By.xpath("(//a[@id='patientHistoryBtn'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Diagnostic Report')]/ancestor::li//a[contains(@href,'.pdf')]")).click();
		Thread.sleep(5000);
			
//		driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting the lab name
//		driver.findElement(By.xpath("(//input[@id='patient_labresult_header_lab_name'])[1]")).sendKeys("Nano");
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[text()='AI Digitize'])[1]")).click();
//		Thread.sleep(8000);

	}

	@And("Close the popup after downloading pdfs with and without header_footer")
	public void close_the_popup_after_downloading_pdfs_with_and_without_header_footer() throws Exception {
//		// clicking on the close popup
//		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div/div[1]/span/i")).click();
//		Thread.sleep(3000);
	}

	@And("clicking on the brand logo")
	public void clicking_on_the_brand_logo() throws Exception {
		// clicking on the brand logo
		driver.findElement(By.xpath("//a[@class='brand-logo']/img")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the labtechnician role")
	public void clicking_on_the_labtechnician_role() throws Exception {
		// clickin on the labtechnician role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Lab_Technician'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("dashboard will be opened for labtechnician")
	public void dashboard_will_be_opened_for_labtechnician() {
	}

	@Then("Managereports searching")
	public void managereports_searching() throws Exception {
		// clicking on the lab test masters
		driver.findElement(By.xpath("(//a[@id='lab_masters'])[1]")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//a[text()='Tests'])[1]")).click();
//		Thread.sleep(5000);
//		System.out.println("Disabled the test button when labtechnician and pathologist roles has masterdata access");
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Diagostic Test'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		WebElement indiv = driver.findElement(By.xpath("(//label[text()='Individual'])[1]"));
//		indiv.click();
//		Thread.sleep(2000);
//		WebElement indiv1 = driver.findElement(By.xpath("(//label[text()='Pathology'])[1]"));
//		indiv1.click();
//		Thread.sleep(7000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
//		// continue
//		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[6]/div/div[2]/form/ul/li[2]/div[2]/div[2]/div/div/div/table/tbody/tr/td[2]/input"))
//				.sendKeys("100");
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.TAB).perform();
//		Thread.sleep(2000);
//		action.sendKeys("200").perform();
//		Thread.sleep(2000);
//		// save
//		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
//		Thread.sleep(3000);

		// clicking on the dashboard
		driver.findElement(By.xpath("(//a[@id='admin-dashboard'])[2]")).click();
		Thread.sleep(3000);
		// clicking on the manage reports
		driver.findElement(By.xpath("(//a[@id='labTechOrders'])[1]")).click();
		Thread.sleep(1000);
		// searching through name
		driver.findElement(By.id("q_patient_master_frst_nm_or_patient_master_lst_nm_cont")).sendKeys("cucum");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(3000);
		// searching through appointment status
		driver.findElement(By.id("q_apmnt_status_cont")).sendKeys("confirmed");
		Thread.sleep(2000);
		WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(3000);
		// status
		driver.findElement(By.id("q_apmnt_status_cont")).sendKeys("completed");
		Thread.sleep(3000);
		WebDriverWait search2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(3000);
		// searching with site-OP
		driver.findElement(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='OP'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait search3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(3000);
		// searching with site-IP
		driver.findElement(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait search4 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
