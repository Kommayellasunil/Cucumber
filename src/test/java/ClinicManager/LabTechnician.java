package ClinicManager;

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
	public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("login with clinicmanger detail emailcm {string} and passwordcm {string}")
	public void login_with_clinicmanger_detail_emailcm_and_passwordcm(String emailcm, String passwordcm)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(emailcm);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(passwordcm);
		Thread.sleep(5000);
	}

	@And("clicking on the sign_in button to login")
	public void clicking_on_the_sign_in_button_to_login() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(5000); // Wait for login
	}

	@Then("selecting_the_cdp_admin_profile")
	public void selecting_the_cdp_admin_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();
	}

	@And("deleting exists patient using search")
	public void deleting_exists_patient_using_search() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("8790298141");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col.s7.btn-loader.opt_search"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='View Profile'])[1]"))).click();

		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i"))).click();
		} else {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")))
					.click();
		}

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
	}

	@Then("existing patient deleted successfully")
	public void existing_patient_deleted_successfully() {
	}

	@And("click on the add_patient_icon for patient registration")
	public void click_on_the_add_patient_icon_for_patient_registration() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
	}

	@Then("selecting title_of_patient")
	public void selecting_title_of_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("user enter the following into the registration form")
	public void user_enter_the_following_into_the_registration_form(DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys(regData.get(0).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst_name"))).sendKeys(regData.get(1).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys(regData.get(2).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nmbr"))).sendKeys(regData.get(3).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-line1")))
				.sendKeys(regData.get(4).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete-input")))
				.sendKeys(regData.get(5).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("landmark"))).sendKeys(regData.get(6).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]")))
				.sendKeys(regData.get(7).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys(regData.get(8).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys(regData.get(9).get(1));
	}

	@Then("selecting the radio_buttons")
	public void selecting_the_radio_buttons() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add Referral'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#referral_name:nth-of-type(1)")))
				.sendKeys("test name");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#referral_clinic:nth-of-type(1)")))
				.sendKeys("NH_OP hospital");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.cls.btn.green.right.referral_submit")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
	}

	@And("click on submit_button_to_register_patient")
	public void click_on_submit_button_to_register_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
	}

	@Then("it will redirect to patient_profile")
	public void it_will_redirect_to_patient_profile() {
	}

	@When("user click on Book_Diagnostic_Appointment from Book Appointment section")
	public void user_click_on_book_diagnostic_appointment_from_book_appointment_section() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]"))))
				.build().perform();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]"))).click();
	}

	@Then("avaiable labs and tests will be displayed")
	public void avaiable_labs_and_tests_will_be_displayed() {
	}

	@And("selecting the thyrocare lab from lab name dropdown")
	public void selecting_the_thyrocare_lab_from_lab_name_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.selection"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]"))).click();
		Thread.sleep(2000);
	}

	@When("list of tests are displayed from thyrocare lab")
	public void list_of_tests_are_displayed_from_thyrocare_lab() {
	}

	@Then("selecting the test for diagnosticbooking")
	public void selecting_the_test_for_diagnosticbooking() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement brandInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='myInput'])[1]")));
		String text = "FBS";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/i[text()='add'])[1]"))).click();
	}

	@And("clicking on the checkout from cartsummary")
	public void clicking_on_the_checkout_from_cartsummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn-loader.btn.checkout.btn-block")))
				.click();
	}

	@Then("Types will be displayed select the type")
	public void types_will_be_displayed_select_the_type() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("select the location address")
	public void select_the_location_address() throws Exception {
	}

	@Then("select the datetime and slot time")
	public void select_the_datetime_and_slot_time() throws Exception {
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
	}

	@And("enabling the checkboxes from notify patient")
	public void enabling_the_checkboxes_from_notify_patient() throws Exception {
	}

	@Then("click on the submit button from invoicepage")
	public void click_on_the_submit_button_from_invoicepage() throws Exception {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-loader"))).click();
	}

	@When("proformainvoice page will be opened for diagnostic booking")
	public void proformainvoice_page_will_be_opened_for_diagnostic_booking() {
	}

	@Then("select the paymentmethod radio button")
	public void select_the_paymentmethod_radio_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		WebElement cash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Cash']")));
		cash.click();
	}

	@When("user enter the transaction amount then receipt comment will be visible")
	public void user_enter_the_transaction_amount_then_receipt_comment_will_be_visible() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("advance_field"))).sendKeys("50");
	}

	@Then("click on receipt comment and enter the comment")
	public void click_on_receipt_comment_and_enter_the_comment() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentComment"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_cmnt")))
				.sendKeys("test receipt comment 1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Ok'])[2]"))).click();
	}

	@Then("click on the submit button inthe proforma invoice for diagnosticbooking")
	public void click_on_the_submit_button_inthe_proforma_invoice_for_diagnosticbooking() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bookNowBtn"))).click();
	}

	@Then("click on the brand logo")
	public void click_on_the_brand_logo() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='brand-logo']/img"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
	}

	@And("click on the labtechnician role")
	public void click_on_the_labtechnician_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Lab_Technician'])[1]"))).click();
	}

	@Then("labtechnician role dashboard will be opened")
	public void labtechnician_role_dashboard_will_be_opened() {
	}

	@And("Click on the appointmentid under confirmed in Labtechnician dashboard")
	public void click_on_the_appointmentid_under_confirmed_in_labtechnician_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))).click();
	}

	@Then("click on the collected and status will be collected")
	public void click_on_the_collected_and_status_will_be_collected() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Collected']"))).click();
		Thread.sleep(1000);
	}

	@And("click on the dashboard for labtechnician role")
	public void click_on_the_dashboard_for_labtechnician_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-dashboard'])[2]"))).click();
		Thread.sleep(1000);
	}

	@When("dashboard is opened click on the collected status")
	public void dashboard_is_opened_click_on_the_collected_status() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.tabs.card>li:nth-of-type(2)>a"))).click();
		Thread.sleep(1000);
	}

	@Then("click on the appointmentid under collected in Labtechnician dashboard")
	public void click_on_the_appointmentid_under_collected_in_labtechnician_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))).click();
		Thread.sleep(1000);
	}

	@And("click on the delivered button and status will be delivered")
	public void click_on_the_delivered_button_and_status_will_be_delivered() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Delivered']"))).click();
		Thread.sleep(1000);
	}

	@Then("click on the dashboard for labtechnician")
	public void click_on_the_dashboard_for_labtechnician() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-dashboard'])[2]"))).click();
		Thread.sleep(1000);
	}

	@When("dashboard is opened click on the delivered status")
	public void dashboard_is_opened_click_on_the_delivered_status() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.tabs.card>li:nth-of-type(3)>a"))).click();
		Thread.sleep(1000);
	}

	@Then("click on the appointmentid under delivered in Labtechnician dashboard")
	public void click_on_the_appointmentid_under_delivered_in_labtechnician_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))).click();
		Thread.sleep(1000);
	}

	@When("click on the plus button for add diagnostic test")
	public void click_on_the_plus_button_for_add_diagnostic_test() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1000);
		Actions qr = new Actions(driver);
		qr.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Click to download'])[1]/img[1]")))).build()
				.perform();
		Thread.sleep(1000);
		qr.moveToElement(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Click to download'])[1]/img[1]")))).click().build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
	}

	@Then("Add Diagnostic Tests popup will be opened")
	public void add_diagnostic_tests_popup_will_be_opened() {
	}

	@And("select the tests from dropdown")
	public void select_the_tests_from_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='selection']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Sodium']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='selection']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Chloride']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='selection']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='PPBS'][1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Yes'])[1]"))).click();
	}

	@Then("deleting the recently added test and saving")
	public void deleting_the_recently_added_test_and_saving() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//tr[td[contains(normalize-space(.),'Sodium')]]//i[@data-tooltip='Delete'][1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Yes']"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@And("upload the reports by clicking on the Upload Reports")
	public void upload_the_reports_by_clicking_on_the_upload_reports() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Upload Reports']"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id("files_constr"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Fbs_chloride_ppbs.pdf");
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[2]/input"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
	}

	@Then("labreport will be uploaded successfully")
	public void labreport_will_be_uploaded_successfully() {
	}

	@And("click on the pdf then it will opened in new window")
	public void click_on_the_pdf_then_it_will_opened_in_new_window() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String mainWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='responsive-img photo img']")))
				.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close();
				driver.switchTo().window(mainWindow);
				break;
			}
		}
		Thread.sleep(1000);
	}

	@And("click on the Edit digitisation order page")
	public void click_on_the_edit_digitisation_order_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn green'])[1]"))).click();
		Thread.sleep(1000);
		Robot robot33 = new Robot();
		robot33.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1000);
	}

	@When("clicking on the dropdown and selecting the lab")
	public void clicking_on_the_dropdown_and_selecting_the_lab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='selection'][1]"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")))
					.click();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	@Then("entering the data into the technology_readings_units")
	public void entering_the_data_into_the_technology_readings_units() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[2]/input[2]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[2]/input[2]")))
				.sendKeys("test1");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[3]/input")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[3]/input")))
				.sendKeys("80");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[5]/input")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[5]/input")))
				.sendKeys("70-100");
		Thread.sleep(1000);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[2]/input[2]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[2]/input[2]")))
				.sendKeys("test2");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[3]/input")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[3]/input")))
				.sendKeys("90");
		Thread.sleep(1000);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[2]/input[2]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[2]/input[2]")))
				.sendKeys("test2");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[3]/input")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[3]/div/div[1]/div[3]/input")))
				.sendKeys("90");
		Thread.sleep(1000);

	}

	@And("entering the comments for each individual test")
	public void entering_the_comments_for_each_individual_test() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[6]/a/img[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[1]/div/div[2]/div[2]/input")))
				.sendKeys("test comments for F.B.S");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='nested-fields'])[1]/div/div[1]/div[6]/a/img[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[6]/a/img[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='nested-fields'])[2]/div/div[2]/div[2]/input")))
				.sendKeys("test comment for Chloride");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='nested-fields'])[2]/div/div[1]/div[6]/a/img[2]")))
				.click();
		Thread.sleep(1000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("entering the comments")
	public void entering_the_comments() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prescriptionComments")))
				.sendKeys("demo test comments from lab technician role");
		Thread.sleep(1000);
	}

	@And("click on the update button")
	public void click_on_the_update_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Update'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("selecting the test checkboxes and deselecting one of them")
	public void selecting_the_test_checkboxes_and_deselecting_one_of_them() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement cbox1 = wait.until(ExpectedConditions.elementToBeClickable(
					By.cssSelector("tbody#saved_lab_result>tr:nth-of-type(1)>td:nth-of-type(1)>label")));
			Thread.sleep(1000);
			cbox1.click();
		}
		WebElement cbox2 = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("tbody#saved_lab_result>tr:nth-of-type(3)>td:nth-of-type(1)>label")));
		cbox2.click();
		Thread.sleep(3000);
	}

	@When("checkboxes are selected then only selected tests results will be printed in the pdfs")
	public void checkboxes_are_selected_then_only_selected_tests_results_will_be_printed_in_the_pdfs() {
	}

	@Then("clicking on the preview button")
	public void clicking_on_the_preview_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Preview'])[1]"))).click();
	}

	@And("downloading the pdfs with_without header_footers")
	public void downloading_the_pdfs_with_without_header_footers() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]"))))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]"))).click();
		Thread.sleep(1000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]"))))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='No'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the forward button")
	public void clicking_on_the_forward_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Forward'][1]"))).click();
		Thread.sleep(1000);
	}

	@When("Lab Report forwarded")
	public void lab_report_forwarded() {
	}

	@Then("clicking on the brand logo1")
	public void clicking_on_the_brand_logo1() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
	}

	@And("selecting the pathologist role from the roles")
	public void selecting_the_pathologist_role_from_the_roles() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Pathologist'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@When("pathologist dashboard is opened")
	public void pathologist_dashboard_is_opened() {
	}

	@Then("clicking on the digitalized status from the dashborad")
	public void clicking_on_the_digitalized_status_from_the_dashborad() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='tab col s2'])[4]/a[1]"))).click();
		Thread.sleep(1000);
	}

	@And("clicking on the appointmentid of the patient")
	public void clicking_on_the_appointmentid_of_the_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))).click();
		Thread.sleep(1000);
		Robot robot7 = new Robot();
		robot7.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		Thread.sleep(1000);
	}

	@When("digitisation page opens")
	public void digitisation_page_opens() {
	}

	@Then("click on the edit button from the pathologist role")
	public void click_on_the_edit_button_from_the_pathologist_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn green'])[1]"))).click();
		Thread.sleep(1000);
		String mainWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='responsive-img photo img']")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close();
				driver.switchTo().window(mainWindow);
				break;
			}
		}
		Thread.sleep(1000);
	}

	@And("clear and update the comments from the pathologist role")
	public void clear_and_update_the_comments_from_the_pathologist_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prescriptionComments"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prescriptionComments")))
				.sendKeys("Updated from the pathologist role comments");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Update'][1]"))).click();
		Thread.sleep(1000);
		Robot robot35 = new Robot();
		robot35.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
	}

	@Then("downloading the pdf")
	public void downloading_the_pdf() throws Exception {
	}

	@When("click on the preview button")
	public void click_on_the_preview_button() throws Exception {
	}

	@Then("downloading pdfs with and without header footer")
	public void downloading_pdfs_with_and_without_header_footer() throws Exception {
	}

	@And("click on the approve button")
	public void click_on_the_approve_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Approve']"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		String parentWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='responsive-img photo img'])[1]")))
				.click();
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWindows = driver.getWindowHandles();
		Thread.sleep(1000);
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				driver.close();
				break;
			}
		}
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		String parentWindow2 = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='responsive-img photo img'])[2]")))
				.click();
		Thread.sleep(1000);
		wait2.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String window : allWindows1) {
			if (!window.equals(parentWindow2)) {
				driver.switchTo().window(window);
				driver.close();
				break;
			}
		}
		Thread.sleep(1000);
		driver.switchTo().window(parentWindow2);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]"))))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@data-tooltip='Print With Header & Footer'])[1]"))).click();
		Thread.sleep(1000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]"))))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@data-tooltip='Print Without Header & Footer'])[1]"))).click();
		Thread.sleep(1000);
	}

	@When("Lab Report approved")
	public void lab_report_approved() {
	}

	@Then("clicking on the Nanohealth brand logo")
	public void clicking_on_the_nanohealth_brand_logo() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='brand-logo']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
	}

	@And("select the clinic manager profile NH_IP+OP")
	public void select_the_clinic_manager_profile_nh_ip_op() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
	}

	@When("dashboard is open mouse hover to the appointments")
	public void dashboard_is_open_mouse_hover_to_the_appointments() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#admin-apmnts")))).click()
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@id='admin-diagnostics'])[2]"))))
				.click().build().perform();
		Thread.sleep(10000);
	}

	@Then("click on the diagnostic lab orders list")
	public void click_on_the_diagnostic_lab_orders_list() {
	}

	@And("click on the Approved status")
	public void click_on_the_approved_status() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='tab col s2'])[4]"))).click();
		Thread.sleep(3000);
	}

	@When("list of approved patients list will be displayed and click on the aptid")
	public void list_of_approved_patients_list_will_be_displayed_and_click_on_the_aptid() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))).click();
		Thread.sleep(3000);
	}

	@Then("from popup copyaddress_downloadinvoice_view")
	public void from_popup_copyaddress_downloadinvoice_view() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("copy_link_icon"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img"))))
				.click();
		Thread.sleep(2000);
	}

	@And("downloading the labreports with and without header footer")
	public void downloading_the_labreports_with_and_without_header_footer() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img"))))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img"))).click();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		action1.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img"))))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img"))).click();
		Thread.sleep(2000);
	}

	@Then("click on the complete status")
	public void click_on_the_complete_status() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Complete'])[1]"))))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Yes'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("status is changed to completed")
	public void status_is_changed_to_completed() {
	}

	@Then("click on the completed status from the header")
	public void click_on_the_completed_status_from_the_header() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='tab col s2'])[5]"))).click();
		Thread.sleep(3000);
	}

	@And("click on the appointment id of the completed status of the lab")
	public void click_on_the_appointment_id_of_the_completed_status_of_the_lab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("tbody>tr>td>a:nth-of-type(1)"))))
				.click();
		Thread.sleep(3000);
	}

	@When("apt id is clikced popup  will open")
	public void apt_id_is_clikced_popup_will_open() {
	}

	@Then("click on the inovice and download the pdfs with and without header_footer")
	public void click_on_the_inovice_and_download_the_pdfs_with_and_without_header_footer() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img"))).click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img"))))
				.build().perform();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img"))).click();
		Thread.sleep(1000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img"))))
				.build().perform();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img"))).click();
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Send Feedback link'])[1]/img")))).build()
				.perform();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Send Feedback link'])[1]/img")))
				.click();
		Thread.sleep(1000);
		WebElement sms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='SMS'])[1]")));
		sms.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Send'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Demo Labtechnician')])")))
				.click();
		Thread.sleep(1000);
		Actions uploads = new Actions(driver);
		uploads.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Upload Medical Documents'])[1]/img[1]"))))
				.build().perform();
		uploads.moveToElement(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Upload Lab Reports'])[1]/img[1]")))).click().build()
				.perform();
		Thread.sleep(3000);
				driver.findElement(By.xpath("(//input[@id='unified-document-input'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Fbs_chloride_ppbs.pdf");
		Thread.sleep(2000);
		WebElement checkbox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//strong[@id='expected-patient-name'])[1]")));
		checkbox.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='confirm-type-btn'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='footer-upload-btn'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='patientHistoryBtn'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[contains(text(),'Diagnostic Report')]/ancestor::li//a[contains(@href,'.pdf')]")))
				.click();
	}

	@And("Close the popup after downloading pdfs with and without header_footer")
	public void close_the_popup_after_downloading_pdfs_with_and_without_header_footer() throws Exception {
	}

	@And("clicking on the brand logo")
	public void clicking_on_the_brand_logo() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='brand-logo']/img"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the labtechnician role")
	public void clicking_on_the_labtechnician_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Lab_Technician'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("dashboard will be opened for labtechnician")
	public void dashboard_will_be_opened_for_labtechnician() {
	}

	@Then("Managereports searching")
	public void managereports_searching() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='lab_masters'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-dashboard'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='labTechOrders'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("q_patient_master_frst_nm_or_patient_master_lst_nm_cont")))
				.sendKeys("cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("q_apmnt_status_cont"))).sendKeys("confirmed");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("q_apmnt_status_cont"))).sendKeys("completed");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='OP'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='IP'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(1000);
		driver.close();
	}
}
