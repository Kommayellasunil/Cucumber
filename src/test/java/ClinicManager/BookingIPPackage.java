package ClinicManager;

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

public class BookingIPPackage {
	WebDriver driver = null;

	@Given("navigate to the nanohealth website url {string}")
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

	@Then("enter the emailormobile1 {string} and password1 {string}")
	public void enter_the_emailormobile1_and_password1(String emailormobile1, String password1) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(emailormobile1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password1);
		Thread.sleep(5000); // kept for waiting the credentials to be entered
	}

	@And("click on the signin button to login ipbillingmanager")
	public void click_on_the_signin_button_to_login_ipbillingmanager() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
	}

	@Then("select the ipbillingmanager profile")
	public void select_the_ipbillingmanager_profile() throws Exception {

	}

	@And("delete existing patient using search bar in cdpadmin role")
	public void delete_existing_patient_using_search_bar_in_cdpadmin_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdpadmin Role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000); // kept for Robot physical actions
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // kept for Robot physical actions

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("7712511112");
		// clicking on the patient name
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col.s7.btn-loader.opt_search"))).click();
		// clicking on the view profile
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='View Profile'])[1]"))).click();

		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
			// clicking on the delete
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i"))).click();
		} else {
			// clicking on the delete
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")))
					.click();
		}

		// deleteing
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")))
				.click();
		// clicking on the brand logo
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))).click();
	}

	@Then("existing patient_deleted from the cdpadmin role")
	public void existing_patient_deleted_from_the_cdpadmin_role() {
	}

	@And("click on the add_patient_icon for registration")
	public void click_on_the_add_patient_icon_for_registration() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting Role as IPBillingManager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
	}

	@Then("selecting the  title_of_the_patient")
	public void selecting_the_title_of_the_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the title
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
	}

	@When("user enters details into registration form")
	public void user_enters_details_into_registration_form(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// firstname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys(regData.get(0).get(1));
		// lastname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst_name"))).sendKeys(regData.get(1).get(1));
		// age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys(regData.get(2).get(1));
		// phone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nmbr"))).sendKeys(regData.get(3).get(1));
		// addressline
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-line1")))
				.sendKeys(regData.get(4).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete-input")))
				.sendKeys(regData.get(5).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("landmark"))).sendKeys(regData.get(6).get(1));
		// city
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#city:nth-of-type(1)")))
				.sendKeys(regData.get(7).get(1));
		// district
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#district:nth-of-type(1)")))
				.sendKeys(regData.get(8).get(1));
		// pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#pn_cd:nth-of-type(1)")))
				.sendKeys(regData.get(9).get(1));
	}

	@Then("selecting_the radio_button to register patient")
	public void selecting_the_radio_button_to_register_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000); // kept for Robot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys("767676");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000); // kept for Robot

		// referred by
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add Referral'])[1]"))).click();
		// self
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[3]"))).click();
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.cls.btn.green.right.referral_submit")))
				.click();
		// demand program
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000); // kept for Robot
	}

	@And("click on submitbutton_to_register_patient")
	public void click_on_submitbutton_to_register_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
		Thread.sleep(2000); // kept for waiting the registration to be completed and redirected to patient profile
	}

	@Then("click on the admission detail from the patient profile")
	public void click_on_the_admission_detail_from_the_patient_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// changing role to ipbillingmanager to admit the patient
		// clicking on the brand logo
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting Role as IPBillingManager
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[normalize-space(text())='IPBillingManager'])[1]"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("Cucumippackage");
		// clicking on the patient name
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col.s7.btn-loader.opt_search"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Admit Now'])[1]"))).click();
	}

	@And("fillup the form of admission detail in the ipbillingmanager role")
	public void fillup_the_form_of_admission_detail_in_the_ipbillingmanager_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Self'])[1]"))).click();

		// selecting the department
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='General Surgery'])[1]"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", 200);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Test room'])[1]"))).click();

		js.executeScript("window.scrollBy(0, arguments[0]);", 200);
		// selecting the Lead doctor
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[5]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")))
				.click();

		Robot pgwn = new Robot();
		pgwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000); // kept for Robot

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Surgery'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[8]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_IPD'])[1]"))).click();

		// entering the comments
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[10]/div/div[2]/input")))
				.sendKeys("Test admit comments");
	}

	@Then("click on the submit button from the admission detail form")
	public void click_on_the_submit_button_from_the_admission_detail_form() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#update_submit"))).click();
		// clicking on the patient name
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]"))).click();
	}

	@When("after submitting the form it will redirect to the patient profile page")
	public void after_submitting_the_form_it_will_redirect_to_the_patient_profile_page() {
	}

	@Then("search and open the patient profile from the ipbillingmanager")
	public void search_and_open_the_patient_profile_from_the_ipbillingmanager() throws Exception {
	}

	@And("click on the add ip package icon from the book appointment section")
	public void click_on_the_add_ip_package_icon_from_the_book_appointment_section() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add IP Package'])[1]/img")))
				.click();
	}

	@Then("select the packages using plus button")
	public void select_the_packages_using_plus_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='myInput'])[1]")))
				.sendKeys("Cucum");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='add'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='add'])[2]"))).click();
	}

	@And("remove one of the package using remove button")
	public void remove_one_of_the_package_using_remove_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='remove'])[2]"))).click();
	}

	@Then("click on the checkout button from the cart of ip packages")
	public void click_on_the_checkout_button_from_the_cart_of_ip_packages() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Checkout'])[1]"))).click();
	}

	@And("search and select the doctor name for referred by")
	public void search_and_select_the_doctor_name_for_referred_by() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='typeahead tt-input'])[1]")))
				.sendKeys("d");
		Thread.sleep(2000); // kept for waiting the search result to be displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='typeahead tt-input'])[1]")))
				.sendKeys(Keys.DOWN);
		Thread.sleep(2000); // kept for waiting the search result to be displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='typeahead tt-input'])[1]")))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("select the program start date for booking ip package")
	public void select_the_program_start_date_for_booking_ip_package() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='pick-date stdt'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
	}

	@When("start date is selected it will select automatically end date")
	public void start_date_is_selected_it_will_select_automatically_end_date() {

	}

	@Then("click on the submit button from the popup")
	public void click_on_the_submit_button_from_the_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#btn-loader"))).click();
	}

	@And("select the paymentmethods11 as cash")
	public void select_the_paymentmethods11_as_cash() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Cash']"))).click();
	}

	@When("user enters_the transaction_amount for ippackage then receipt_comment will visible")
	public void user_enters_the_transaction_amount_for_ippackage_then_receipt_comment_will_visible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#advance_field"))).sendKeys("10");
	}

	@Then("click on receipt_comment and enter_comment for ippackage appointment")
	public void click_on_receipt_comment_and_enter_comment_for_ippackage_appointment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
		// comment
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#payment_cmnt")))
				.sendKeys("test receipt comment");
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Ok'])[2]"))).click();
	}

	@And("click on the submit button inthe proformainvoice11")
	public void click_on_the_submit_button_inthe_proformainvoice11() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
	}

	@Then("download the Invoice_receipt_totaladvance_printpdf11")
	public void download_the_invoice_receipt_totaladvance_printpdf11() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// generate invoice
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")))
				.click();

		// printing
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='tooltipped summary_pdf'])[1]/img[1]")))
				.click();
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000); // kept for Robot
		// clicking on the receipt id
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'R-')])[1]"))).click();
		// clicking on the total receipt
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")))
				.click();
		// clicking on the print
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.green.right.tooltipped.summary_pdf")))
				.click();
		Thread.sleep(2000); // kept for waiting the pdf to be downloaded
	}

	@And("click on shareinvoice11 button")
	public void click_on_shareinvoice11_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.green.right.btn-loader2.summary_pdf")))
				.click();
		Thread.sleep(5000); // kept for waiting the share invoice popup to be displayed
	}

	@Then("clears existing mail and phone for ippackage")
	public void clears_existing_mail_and_phone_for_ippackage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).clear();
	}

	@And("enter mail and click on submit button for shareinvoice11")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice11() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails")))
				.sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000); // kept for waiting the email to be entered
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000); // kept for waiting the success message to be displayed
	}

	@Then("click on the patient name and open patient profile")
	public void click_on_the_patient_name_and_open_patient_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the patient name to open patient profile
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]"))).click();

		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
		} else {
			System.out.println("No pending amount pop up");
		}
		Thread.sleep(2000); // kept for waiting the patient profile to be loaded
	}

	@And("create a new ip package for the ip patient")
	public void create_a_new_ip_package_for_the_ip_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add IP Package'])[1]/img")))
				.click();

		// click on the plus button to create a new ip package
		Actions action = new Actions(driver);
		WebElement addNewIPPackageBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New IP-Package'])[1]/i[1]")));
		action.moveToElement(addNewIPPackageBtn).build().perform();
		action.moveToElement(wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add New IP-Package'])[1]/i[1]"))))
				.click().build().perform();
		Thread.sleep(2000); // kept for waiting the add new ip package form to be displayed
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_IPD'])[1]"))).click();
		Thread.sleep(1000);
		// enter the ip package name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pckg_nm'])[1]")))
				.sendKeys("Cucumippackage");
		Thread.sleep(1000);
		// entering the duration
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='duration'])[1]")))
				.sendKeys("30");
		Thread.sleep(1000);
		// entering the service name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='invoice_search'])[1]")))
				.sendKeys("Ip pro");
		// clicking on the service name from the search result
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='IP Procedure'])[1]")))
				.click();
		Thread.sleep(1000); // kept for waiting the service to be added to the package
		// entering the service name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='invoice_search'])[1]")))
				.sendKeys("Diagnostic");
		// clicking on the service name from the search result
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Diagnostic Lab'])[1]")))
				.click();
		Thread.sleep(1000); // kept for waiting the service to be added to the package
		// removing the added service from the package
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='remove_fields dynamic'])[1]/i[1]")))
				.click();
		Thread.sleep(1000); // kept for waiting the service to be removed from the package
		// adding the service again
		// entering the service name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='invoice_search'])[1]")))
				.sendKeys("Ip pro");
		Thread.sleep(1000);
		// clicking on the service name from the search result
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='IP Procedure'])[1]")))
				.click();
		Thread.sleep(1000);
		// adding one more service to the package using service type
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Professional Fees'])[1]"))).click();
		Thread.sleep(1000);
		// selecting the service name
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Doctor Consultation'])[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the doctor name
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")))
				.click();
		Thread.sleep(1000);
		// clearing the unit cost and entering the new unit cost for the service
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='unit_cost'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='unit_cost'])[1]")))
				.sendKeys("500");
		Thread.sleep(1000);
		// clicking on the add button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Add'])[1]"))).click();
		Thread.sleep(1000); // kept for waiting the service to be added to the package
		// clearing the total cost of the ippackage and entering the cost
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pkg_price'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pkg_price'])[1]")))
				.sendKeys("500");
		Thread.sleep(1000);
		// clicking on the submit button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='btn-loader'])[1]"))).click();
		Thread.sleep(1000); // kept for waiting the ip package to be created
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000); // kept for Robot
		Thread.sleep(1000); // kept for waiting the page to be scrolled down
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Cash']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#advance_field")))
				.sendKeys("500");

		// clicking on the comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
		// comment
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#payment_cmnt")))
				.sendKeys("paying full amount for ippackage");
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Ok'])[2]"))).click();
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
		Thread.sleep(2000); // kept for waiting the proforma invoice to be generated
		// generate invoice
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")))
				.click();
		Thread.sleep(2000); // kept for waiting the invoice to be generated
		// converting the invoice to tax invoice
		Actions inv = new Actions(driver);
		WebElement convertBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")));
		inv.moveToElement(convertBtn).build().perform();
		inv.moveToElement(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")))).click()
				.build().perform();
		Thread.sleep(2000); // kept for waiting the invoice to be converted to tax invoice
		// printing
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='tooltipped summary_pdf'])[1]/img[1]")))
				.click();

		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000); // kept for Robot

		// clicking on the receipt id
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'R-')])[1]"))).click();
		// clicking on the total receipt
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")))
				.click();
		// clicking on the print
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.green.right.tooltipped.summary_pdf")))
				.click();
		Thread.sleep(5000); // kept for waiting the pdf to be downloaded
		// clicking on the share invoice
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.green.right.btn-loader2.summary_pdf")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails")))
				.sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000); // kept for waiting the email to be entered
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000); // kept for waiting the success message to be displayed
		driver.close();
	}
}
