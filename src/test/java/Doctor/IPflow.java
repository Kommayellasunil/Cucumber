package Doctor;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Alert;
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

public class IPflow {
	WebDriver driver = null;

	@Given("naviagating to URL of NH_application {string}")
	// public void navigating_to_url_of_nh_application(String url) throws
	// InterruptedException {
	//
	// }
	public void launchBrowser(String url) {
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "\\driver\\chromedriver139.exe");
		// ChromeOptions co = new ChromeOptions();
		// co.addArguments("--remote-allow-origins=*");
		// driver = new ChromeDriver(co);
		// co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.get("https://customer.nanohealthplan.com/users/sign_in");
		// driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@When("NH url login page opens")
	public void nh_url_login_page_opens() throws InterruptedException {
	}

	@Then("enter the email9 {string} password9 {string}")
	public void enter_email9_and_password9(String email9, String password9) throws InterruptedException {
		driver.findElement(By.id("user_login")).sendKeys(email9);
		driver.findElement(By.id("user_password")).sendKeys(password9);
		Thread.sleep(15000);
	}

	@And("click on the sign in button to login")
	public void click_on_the_sign_in_button_to_login() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the role as cdpadmin to delete exist patient")
	public void select_the_role_as_cdpadmin_to_delete_exist_patient() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(10000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.id("frst_nm")).sendKeys("5788110053");
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
			// driver.findElement(By.id("admin-billing-tab")).click();
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i")).click();
			Thread.sleep(2000);
		} else {
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
			Thread.sleep(2000);
		}
		// deleteing
		driver.findElement(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")).click();
		Thread.sleep(7000);

		driver.findElement(By.id("frst_nm")).sendKeys("7788110027");
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
			// driver.findElement(By.id("admin-billing-tab")).click();
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i")).click();
			Thread.sleep(2000);
		} else {
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
			Thread.sleep(2000);
		}
		// deleteing
		driver.findElement(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")).click();
		Thread.sleep(7000);

		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on brand logo to change profile role to ipdclinicmanager")
	public void click_on_brand_logo_to_change_profile_role_to_ipdclinicmanager() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);

		/*
		 * driver.findElement(By.id("frst_nm")).sendKeys("7788110021");
		 * Thread.sleep(3000); // clicking on the patient name
		 * driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click(
		 * ); Thread.sleep(3000); // clicking on the view profile
		 * driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		 * Thread.sleep(3000); // close for pending amount if
		 * (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i"))
		 * .isDisplayed()) {
		 * driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).
		 * click(); Thread.sleep(1000); } else { Thread.sleep(1000); }
		 */
	}

	@Then("click on the add patient icon from the ipdclinicmanager role")
	public void click_on_the_add_patient_icon_from_the_ipdclinicmanager_role() throws Exception {
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(30));
		// element.until(ExpectedConditions.elementToBeClickable(
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select title_of_the_ip_patient")
	public void select_title_of_the_ip_patient() throws Exception {
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(60));
		// selecting the title
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		// Thread.sleep(1000);
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Mr.')])[1]"))).click();
		Thread.sleep(1000);
	}

	@When("user enters the following details into registration form from the ipdhospital")
	public void user_enters_details_into_registration_form_from_ipdhospital() throws Exception {
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(60));
		// firstname
		element.until(ExpectedConditions.elementToBeClickable(By.id("first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		element.until(ExpectedConditions.elementToBeClickable(By.id("lst_name"))).sendKeys("Ipflowpatient");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		element.until(ExpectedConditions.elementToBeClickable(By.id("age"))).sendKeys("85");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		element.until(ExpectedConditions.elementToBeClickable(By.id("nmbr"))).sendKeys("5788110053");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		// element.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("cucusdhmdss@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// addressline
		element.until(ExpectedConditions.elementToBeClickable(By.id("address-line1"))).sendKeys("test");
		element.until(ExpectedConditions.elementToBeClickable(By.id("autocomplete-input"))).sendKeys("test");
		element.until(ExpectedConditions.elementToBeClickable(By.id("landmark"))).sendKeys("testlandmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// city
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='city'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='city'])[1]")))
				.sendKeys("Test city");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// district
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='district'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys("Test district");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys("676767");
		Robot test = new Robot();
		test.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// referred by
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")))
				.click();
		Thread.sleep(1000);
		// self
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[3]"))).click();
		Thread.sleep(1000);
		// submit
		element.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("span.cls.btn.green.right.referral_submit")))
				.click();
		Thread.sleep(2000);
		// demand program
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		element.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
		Thread.sleep(8000);
	}

	@And("click on the submit_button_to_register from the ipdhospital")
	public void click_on_the_submit_button_to_register_from_the_ipdhospital() throws Exception {

	}

	@Then("it will open the patient profile with admit now button")
	public void it_will_open_the_patient_profile_with_admit_now_button() throws Exception {
		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role as IPBillingManager
		driver.findElement(By.xpath("(//div[normalize-space(text())='IPBillingManager'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumipflowpatient");
		Thread.sleep(3000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the advance button present in the right side")
	public void click_on_advance_button_present_in_right_side() throws Exception {
		// clicking on the advance
		driver.findElement(
				By.xpath("//div[@class='invoice_container patientLoadBalance']/a[contains(text(),'Advance: ')]"))
				.click();
		Thread.sleep(2000);
	}

	@Then("enter the amount for advance payment")
	public void enter_the_amount_for_advance_payment() throws InterruptedException {
		// entering amount
		driver.findElement(By.cssSelector("input#load_amount")).sendKeys("50000");
		Thread.sleep(1000);
	}

	@And("select the payment method radio button after entering advance amount")
	public void select_payment_method_radio_button_after_entering_amount() throws InterruptedException {
		WebElement other = driver.findElement(By.xpath("//label[text()='Other']"));
		other.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting phonepe
		driver.findElement(By.xpath("//li[text()='PhonePe']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering other transaction id
		driver.findElement(By.cssSelector("input#other_txn_id")).sendKeys("123456");
		Thread.sleep(1000);

	}

	@Then("click on the save button to save the advance amount")
	public void click_on_the_save_button_to_save_the_advance_amount() throws InterruptedException {
		// clicking on the save
		// driver.findElement(By.cssSelector("input#save")).click();
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#save")))).click();
		Thread.sleep(8000);
	}

	@When("save is clicked it will show the loaded amount in the advance field button")
	public void save_is_clicked_show_loaded_amount_in_advance_field_button() throws InterruptedException {

	}

	@Then("return some amount using return advance")
	public void return_some_amount_using_return_advance() throws Exception {
		// clicking on the advance
		driver.findElement(
				By.xpath("//div[@class='invoice_container patientLoadBalance']/a[contains(text(),'Advance: ')]"))
				.click();
		Thread.sleep(2000);
		// clicking on the return advance
		driver.findElement(By.xpath("(//a[@class='return_amnt'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='load_amount'])[1]")).sendKeys("10000");
		Thread.sleep(1000);
		WebElement card = driver.findElement(By.xpath("(//label[text()='Card'])[1]"));
		card.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='txn_id'])[1]")).sendKeys("123456");
		Thread.sleep(1000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#save")))).click();
		Thread.sleep(8000);
	}

	@And("deleting the already existing family member from cdpadmin role")
	public void deleting_the_already_existing_family_member_from_cdpadmin_role() throws Exception {

	}

	@And("click on the brandlogo and select the ipdclinicmanager role")
	public void click_on_the_brandlogo_and_select_the_ipdclinicmanager_role() throws Exception {

	}

	@Then("search and open the patient that want to admit from ipdhospital")
	public void search_and_open_the_patient_that_want_to_admit_from_ipdhospital() throws Exception {
	}

	@Then("click on the admitnow button under the bookappointments section")
	public void click_on_admitnow_button_under_bookappointments_section() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Admit Now')])[1]")).click();
		Thread.sleep(3000);
	}

	@And("select the insurance radio button and add insurance")
	public void select_insurance_radio_button_and_add_insurance() throws Exception {
		WebElement insurance = driver.findElement(By.xpath("(//label[contains(text(),'Insurance')])[1]"));
		insurance.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Insurance'])[1]/img[1]")).click();
		Thread.sleep(2000);
		WebElement insur = driver.findElement(By.xpath("(//label[text()='Insurance'])[2]"));
		insur.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card")).sendKeys("12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_no")).sendKeys("123456789");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_start_date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Insurance Company'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='btn right green ins_submit btn-loader'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement insurance1 = driver.findElement(By.xpath("(//label[contains(text(),'Insurance')])[1]"));
		insurance1.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Family Member'])[2]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Family Member'])[2]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='col m1 form_brd name_title'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Mr.')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Cucumipflow");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("fammember");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#age")).sendKeys("56");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("7788110027");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[13]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Brother'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='btn green right submit_btn'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on add family member icon from primary attendant field")
	public void click_on_add_family_member_icon_from_primary_attendant_field() throws Exception {
	}

	@Then("add family member popup opens enter the details")
	public void add_family_member_popup_opens_enter_details() throws InterruptedException {

	}

	@Then("select the relation from the dropdown from the add family member")
	public void select_relation_from_dropdown_in_add_family_member() throws InterruptedException {
	}

	@Then("click on the submit button add the family member")
	public void click_on_submit_button_add_family_member() throws InterruptedException {
	}

	@And("select the department from dropdown")
	public void select_department_from_dropdown() throws Exception {
		WebElement insurance1 = driver.findElement(By.xpath("(//label[contains(text(),'Insurance')])[1]"));
		insurance1.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// selecting the department
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'General Surgery')])[1]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@Then("select the single from roomtype dropdown")
	public void select_single_from_roomtype_dropdown() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[contains(text(),'Single Room')])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@And("select the lead doctor from dropdown")
	public void select_lead_doctor_from_dropdown() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@Then("select the familymember from dropdown")
	public void select_the_familymember_from_dropdown() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@And("select admission type radio button")
	public void select_admission_type_radio_button() throws Exception {
		WebElement surgery = driver.findElement(By.xpath("(//label[text()='Surgery'])[1]"));
		surgery.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@Then("select the ipdhospital from the dropdown on clicking admission site")
	public void select_the_ipdhospital_from_the_dropdown_on_clicking_admission_site() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering comments
		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[10]/div/div[2]/input"))
				.sendKeys("Test comments");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@And("click on the submit button from admitform")
	public void click_on_submit_button_from_admitform() throws InterruptedException {
		WebElement submit = driver.findElement(By.xpath("(//input[@id='update_submit'])[1]"));
		submit.click();
		Thread.sleep(5000);
	}

	@When("admit now form is submitted the status of patient will be changed to ip")
	public void admit_now_form_is_submitted_the_status_of_patient_will_be_changed_to_ip() {
	}

	@Then("ip number will be generated then click on it to download the pdfs like consent form")
	public void ip_number_will_be_generated_then_click_on_it_to_download_the_pdfs_like_consent_form() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'IP-')])[1]")).click();
		Thread.sleep(5000);
		// clicking on the qr code
		driver.findElement(By.xpath("(//div[@id='ip_forms_modal'])[1]/div[1]/div[1]/a[1]/img[1]")).click();
		Thread.sleep(2000);
		Thread.sleep(1000);

		// Store parent window
		String parentWindow = driver.getWindowHandle();
		/* -------- Admit Now PDF -------- */
		driver.findElement(By.xpath("//td[normalize-space(.)='Admit_Now']//following-sibling::td[1]/a[1]/img[1]"))
				.click();
		// Switch to child window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(2000); // wait for PDF to load
				driver.close(); // close child tab
			}
		}
		Thread.sleep(1000);
		// Switch back to parent
		driver.switchTo().window(parentWindow);
		/* -------- Invoice PDF -------- */
		driver.findElement(By.xpath("//td[normalize-space(.)='Invoice']//following-sibling::td[2]/a[1]/img[1]"))
				.click();
		// Switch to child window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(2000); // wait for PDF to load
				driver.close(); // close child tab
			}
		}
		// Switch back to parent
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

//		// Step 1: Click the image link (opens new tab)
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[2]/img[1]")).click();
//		// Step 2: Store parent window handle
//		String parentWindow1 = driver.getWindowHandle();
//		// Step 3: Get all window handles
//		Set<String> allWindows = driver.getWindowHandles();
//		for (String window : allWindows) {
//			if (!window.equals(parentWindow1)) {
//				// Step 4: Switch to child tab
//				driver.switchTo().window(window);
//				// (Optional) Perform any action on child tab
////				System.out.println("Child tab title: " + driver.getTitle());
//				// Step 5: Close the child tab
//				driver.close();
//				// Step 6: Switch back to parent tab
////				driver.switchTo().window(parentWindow1);
//			}
//		}
//		// Step 1: Click the image link (opens new tab)
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[4]/img[1]")).click();
//		// Step 2: Store parent window handle
//		String parentWindow11 = driver.getWindowHandle();
//		// Step 3: Get all window handles
//		Set<String> allWindows1 = driver.getWindowHandles();
//		for (String window : allWindows1) {
//			if (!window.equals(parentWindow11)) {
//				// Step 4: Switch to child tab
//				driver.switchTo().window(window);
//				// (Optional) Perform any action on child tab
////				System.out.println("Child tab title: " + driver.getTitle());
//				// Step 5: Close the child tab
//				driver.close();
//				// Step 6: Switch back to parent tab
//				driver.switchTo().window(parentWindow11);
//			}
//		}
		// uploading pdf
		driver.findElement(By.xpath("(//input[@class='dynamic-upload-input'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Dischargesummary.pdf");
		Thread.sleep(3000);
		// deleting it
		driver.findElement(By.xpath("(//i[@class='fa fa-trash'])[1]")).click();
		Thread.sleep(2000);
		// uploading pdf
		driver.findElement(By.xpath("(//input[@class='dynamic-upload-input'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Dischargesummary.pdf");
		Thread.sleep(3000);
		// clicking on the download button
		driver.findElement(By.xpath("(//button[@id='download-selected'])[1]")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkall = driver
					.findElement(By.xpath("(//input[@id='check_all'])[1]/following-sibling::label[1]"));
			checkall.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// clicking on the download button
		driver.findElement(By.xpath("(//button[@id='download-selected'])[1]")).click();
		Thread.sleep(5000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='ip_forms_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("edit the admit form and submit again")
	public void edit_the_admit_form_and_submit_again() throws Exception {
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='patientHistoryBtn'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the ip number to open the filledup forms
		driver.findElement(By.xpath("(//span[text()='ACTIVE'])[1]")).click();
		Thread.sleep(3000);
		// edit admit form and submit again
		// clicking on the edit button
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Form'])[1]/img[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[10]/div/div[2]/input"))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[10]/div/div[2]/input"))
				.sendKeys("Updated comments for admit form");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
		Thread.sleep(3000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='patientHistoryBtn'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the ip number to open the filledup forms
		driver.findElement(By.xpath("(//span[text()='ACTIVE'])[1]")).click();
		Thread.sleep(3000);
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// click on the admit form
		driver.findElement(By.xpath("(//span[normalize-space(.)='Admit Now'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"((//span[normalize-space()='Admit Now'])[1]/ancestor::div[contains(@class,'collapsible-body')]//a[@data-tooltip='Print PDF'])[2]"))
				.click();
		Thread.sleep(3000);
		// clicking on the share button
		driver.findElement(By.xpath(
				"(//span[normalize-space()='Admit Now'])[1]/ancestor::div[contains(@class,'collapsible-body')]//a[contains(@href,'op_form')]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub.click();
		Thread.sleep(10000);
		// click on the admit form
		driver.findElement(By.xpath("(//span[normalize-space(.)='Admit Now'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the zero invoice amount id button")
	public void click_on_zero_invoice_amount_id_button() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='invoice_container'])[3]")).click();
		Thread.sleep(3000);
		//
	}

	@And("click on the add service and add one of the service and submit")
	public void click_on_add_service_and_submit() throws InterruptedException, Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Service'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Service'])[1]/i[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		/*
		 * // driver.findElement(By.cssSelector("input#created_at")).click(); //
		 * Thread.sleep(2000);
		 */
		/*
		 * LocalDate today = LocalDate.now(); int previousWeekDay =
		 * today.minusDays(1).getDayOfMonth(); // one day ago
		 * System.out.println("Date to select (one day ago): " + previousWeekDay); //
		 * Step 4: Locate all the day elements in the calendar List<WebElement>
		 * dateElements =
		 * driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
		 * 
		 * // Step 5: Iterate through the list and find the required date for
		 * (WebElement dateElement : dateElements) { if
		 * (dateElement.getText().equals(String.valueOf(previousWeekDay))) {
		 * System.out.println("Clicking on date: " + dateElement.getText());
		 * dateElement.click(); break; } }
		 * System.out.println("Previous date selected successfully!");
		 */
//		// 1️⃣ Get yesterday's date
//		LocalDate yesterday = LocalDate.now().minusDays(1);
//		int yesterdayDay = yesterday.getDayOfMonth();
//
//		// 2️⃣ Open the calendar widget (change locator as per your input field/button)
//		driver.findElement(By.cssSelector("input#created_at")).click();
//
//		// 3️⃣ Try selecting yesterday in current month
//		try {
//			WebElement yesterdayDate = driver.findElement(By.xpath("//td[normalize-space()='" + yesterdayDay + "']"));
//			yesterdayDate.click();
//			System.out.println("✅ Yesterday selected in current month: " + yesterday);
//		} catch (Exception e) {
//			System.out.println("⚠️ Yesterday not in current month. Switching to previous month...");
//
//			// 4️⃣ Click previous month arrow
//			driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
//			Thread.sleep(1000);
//
//			// 5️⃣ Select yesterday in previous month
//			WebElement yesterdayDatePrev = driver
//					.findElement(By.xpath("//td[normalize-space()='" + yesterdayDay + "']"));
//			yesterdayDatePrev.click();s
//			System.out.println("✅ Yesterday selected from previous month: " + yesterday);
//		}
//
		driver.findElement(By.xpath("(//input[@id='created_at'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(2000);
		// sync data
		driver.findElement(By.xpath("(//a[@data-tooltip='Sync Data'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// Switch to alert
		Alert alert = driver.switchTo().alert();
		// Accept the alert (click OK)
		alert.accept();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("minor");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[normalize-space(text())='Minor Procedure'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Professional Fees'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Doctor Consultation'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Add'])[1]")).click();
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader sbmtBtn'])[1]")).click();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement paynow = driver.findElement(By.xpath("(//label[text()='Pay Now'])[1]"));
		paynow.click();
		Thread.sleep(1000);
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[@class='btn green right book_now mbl_full_width btn-loader'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {
			Thread.sleep(1000);
		}

	}

	@Then("click on the bookipprocedures and book the appointment")
	public void click_on_the_bookipprocedures_and_book_the_appointment() throws Exception {
		// clicking on the book ip procedures
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book IP Procedures'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book IP Procedures'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// removing one of the procedure
		driver.findElement(By.xpath("(//i[text()='remove'])[4]")).click();
		Thread.sleep(2000);
		// checkout
		driver.findElement(By.xpath("(//a[text()='Checkout'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='in_patient_detail_operation_dt'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='select-wrapper select-month'])[1]/input[1]")).click();
		Thread.sleep(1000);
		LocalDate today = LocalDate.now();
		String currentMonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		Thread.sleep(1000);
		// Select current month dynamically
		driver.findElement(By.xpath("//li/span[text()='" + currentMonth + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='timepicker act-disab actual-operation-time'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(1000);
		// clicking on the discharge date
		driver.findElement(By.xpath("(//input[@id='in_patient_detail_discharge_dt'])[1]")).click();
		Thread.sleep(1000);
		// open month dropdown
		driver.findElement(By.xpath("(//div[@class='select-wrapper select-month'])[2]/input")).click();
		Thread.sleep(500);

		// get current month dynamically
		LocalDate today1 = LocalDate.now();
		String currentMonth1 = today1.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		// wait and select the month
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement monthOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li/span[normalize-space()='" + currentMonth1 + "'])[last()]")));
		monthOption.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='month-next'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='in_patient_detail[discharge_time]'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(1000);
		// continue
		driver.findElement(By.xpath("(//button[@id='continue-btn'])[1]")).click();
		Thread.sleep(3000);
		// selecting the supporting doctor
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);
//		// selecting the Anaesthetist
//		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[2]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("")).click();
//		Thread.sleep(2000);
		// clicking on the continue
		driver.findElement(By.xpath("(//button[@id='continue-team'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the procedure room no and selecting it
		driver.findElement(By.xpath("(//label[text()='Procedure Room no.'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		// clicking on the continue button
		driver.findElement(By.xpath("(//button[@id='continue-ot'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the submit
		driver.findElement(By.xpath("(//input[@id='btn-loader'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement paynow = driver.findElement(By.xpath("(//label[text()='Pay Now'])[1]"));
		paynow.click();
		Thread.sleep(1000);
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[@class='btn green right book_now mbl_full_width btn-loader'])[1]")).click();
		Thread.sleep(5000);
		// generate the invoice
		Actions id = new Actions(driver);
		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(2000);
		// download invoice
		Actions inv = new Actions(driver);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(5000);

		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement submit = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		submit.click();
		Thread.sleep(10000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {
			Thread.sleep(1000);
		}

	}

	@And("assign the room and bed for the ippatient")
	public void assign_room_and_bed_for_ippatient() throws Exception {
		Actions id = new Actions(driver);
		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Assign room'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Assign room'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Room Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Single')])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='in_patient_detail_admission_dt'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='in_patient_detail_admitted_days'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='in_patient_detail_admitted_days'])[1]")).sendKeys("5" + Keys.TAB);
		Thread.sleep(2000);
		// clicking on the assign button
		driver.findElement(By.xpath("(//input[@class='btn green right sbmtBtn assign_btn'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {
			Actions ipcard = new Actions(driver);
			ipcard.moveToElement(driver.findElement(By.xpath("(//span[@class='ip_card ip_ico'])[1]"))).build()
					.perform();
			Thread.sleep(1000);
		}
		Actions ipcard = new Actions(driver);
		ipcard.moveToElement(driver.findElement(By.xpath("(//span[@class='ip_card ip_ico'])[1]"))).build().perform();
		Thread.sleep(2000);

		ipcard.moveToElement(
				driver.findElement(By.xpath("(//div[@class='bkng_services_prfl'])[1]/div[1]/a[13]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);

	}

	@Then("extend the bed date for the ippatients")
	public void extend_bed_date_for_ippatients() throws Exception {
		driver.findElement(By.xpath("(//div[@class='bkng_services_prfl'])[1]/div[1]/a[13]/img[1]")).click();
		Thread.sleep(2000);
		// clicking on the extend date
		driver.findElement(By.xpath("(//a[text()='Extend Date'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='addtnl_days'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='addtnl_days'])[1]")).sendKeys("10" + Keys.TAB + Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='btn green right sbmtBtn'])[1]")).click();
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='allottedBed'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the appointments and selecting the hosptial beds
		driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='admin-rooms'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Select hospital'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Select room type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Single')])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the bed view
		driver.findElement(By.xpath("(//a[text()='Bed View'])[1]")).click();
		Thread.sleep(3000);
//		// signout
//		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
//		Thread.sleep(5000);
//		driver.close();
	}

	@And("book the doctor diagnostic appointments for the ippatient")
	public void book_the_doctor_diagnostic_appointments_for_the_ippatient() throws Exception {
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("5788110053");
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(3000);
			// driver.findElement(By.id("admin-billing-tab")).click();
		} else {
		}
		// clicking on the book doctor appointment button
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h6[text()='Clinic'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='TOMORROW'])[1]")).click();
		Thread.sleep(3000);
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
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@id='bookNowBtn'])[1]")).click();
		Thread.sleep(3000);
		WebElement paynow = driver.findElement(By.xpath("(//label[text()='Pay Now'])[1]"));
		paynow.click();
		Thread.sleep(1000);
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[@id='bookLater'])[1]")).click();
		Thread.sleep(3000);
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
//		Robot robot4 = new Robot();
//		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(2000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(2000);
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// clicking on the submit
//		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
//		sub.click();
//		Thread.sleep(10000);
//		for (int i = 0; i <= 2; i++) {
//			robot4.keyPress(KeyEvent.VK_PAGE_UP);
//			Thread.sleep(2000);
//		}

		// booking lab appointment
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Cucum')])[2]"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book New Appointment'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// clicking on the drop down
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		Thread.sleep(2000);
		// selecting the lab
		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
		Thread.sleep(10000);
		// clicking on the plus
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// removing last added
		driver.findElement(By.xpath("(//a/i[text()='remove'])[5]")).click();
		Thread.sleep(2000);
		// clicking on the checkout button
		driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
		// selecting the type - Lab Visit
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
		// Try AM first
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		List<WebElement> am1 = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));
		boolean selected1 = false;

		for (WebElement slot : am1) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				js11.executeScript("arguments[0].click();", slot);
				selected1 = true;
				break;
			}
		}

		if (!selected1) {
			// Try PM next
			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));
			for (WebElement slot : pm) {
				if (slot.isDisplayed() && slot.isEnabled()) {
					js12.executeScript("arguments[0].click();", slot);
					break;
				}
			}
		}
		// clicking on the submit
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
		}
		WebElement paynow2 = driver.findElement(By.xpath("(//label[text()='Pay Now'])[1]"));
		paynow2.click();
		Thread.sleep(1000);
		WebElement paylater2 = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater2.click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[@id='bookLater'])[1]")).click();
		Thread.sleep(3000);
		// booking lab appointment
//				Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Cucum')])[2]"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book New Appointment'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Minor Procedures'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
//		Thread.sleep(2000);
		// clicking on the checkout button
		driver.findElement(By.xpath("(//a[text()='Checkout'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='continue-ot'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='continue-team'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the submit button
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
		}
		WebElement paynow1 = driver.findElement(By.xpath("(//label[text()='Pay Now'])[1]"));
		paynow1.click();
		Thread.sleep(1000);
		WebElement paylater1 = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater1.click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[@id='bookLater'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='tooltipped service_wise_pdf'])[1]/img[1]")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
		}
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clicking on the submit
		WebElement sub1 = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub1.click();
		Thread.sleep(10000);
		for (int i = 0; i <= 2; i++) {
			Robot robot4 = new Robot();
			robot4.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(2000);
		}
		// clicking on the appointments
		driver.findElement(By.xpath("(//a[@class='btn-loader btn green right'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='moreApmntList'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.close();
	}

	@Given("navigates to this urls {string}")
	// public void navigating_to_url_of_nh_application(String url) throws
	// InterruptedException {
	//
	// }
	public void launchBrowser1(String url) {
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "\\driver\\chromedriver139.exe");
		// ChromeOptions co = new ChromeOptions();
		// co.addArguments("--remote-allow-origins=*");
		// driver = new ChromeDriver(co);
		// co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.get("https://customer.nanohealthplan.com/users/sign_in");
		// driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@And("login into doctor role with credentails")
	public void login_into_doctor_role_with_credentails() throws Exception {
		driver.findElement(By.id("user_login")).sendKeys("doctor1@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on CDPAdmin
		driver.findElement(By.xpath("(//div[normalize-space(text())='Doctor'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("doctor dashboard opens then select the ipd hospital")
	public void doctor_dashboard_opens_then_select_the_ipd_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='doctor-iplist'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='NanoHealth_IPD'])[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
				.sendKeys("Cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("search the ippatient and click on dischargesummary button")
	public void search_the_ippatient_and_click_on_dischargesummary_button() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Cucum Ipflowpatient')])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Discharge Summary'])[1]")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1200)");
		Thread.sleep(1000);
	}

	@Then("enter the provisional diagnosis at time of admission")
	public void enter_the_provisional_diagnosis_at_time_of_admission() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]"))
				.sendKeys("Test provisional diagnosis at time of admission1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]"))
				.sendKeys("Test provisional diagnosis at time of admission2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]"))
				.sendKeys("Test provisional diagnosis at time of admission3" + Keys.UP + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")).sendKeys("Test in the middle");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]"))
				.sendKeys("Test provisional diagnosis at time of admission1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]"))
				.sendKeys("Test provisional diagnosis at time of admission2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]"))
				.sendKeys("Test provisional diagnosis at time of admission3" + Keys.UP + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")).sendKeys("Test in the middle");
		Thread.sleep(2000);
	}

	@And("select the diagnosis and add")
	public void select_diagnosis_and_add() throws Exception {
		driver.findElement(By.xpath("(//input[@id='doctor_visit_comorbidity'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")).sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Week'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][note]'])[1]"))
				.sendKeys("Test diagnosis notes");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='doctor_visit_comorbidity'])[1]")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")).sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Months'])[1]")).click();
		Thread.sleep(2000);

	}

	@Then("search the diagnosis in ds and add")
	public void search_diagnosis_in_ds_and_add() throws Exception {
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='doctor_visit_comorbidity'])[1]"));
		String text = "Cancer";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//div[@class='input_close_cmrb'])[3]/i[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);

	}

	@And("enter the patient history in dischargesummary")
	public void enter_patient_history() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]"))
				.sendKeys("Test patient history1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]"))
				.sendKeys("patient history" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]"))
				.sendKeys("patienthistory" + Keys.UP + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]")).sendKeys("pat hstry");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
	}

	@Then("select the symptoms for ippatient in dischargesummary")
	public void select_the_symptoms_for_ippatient_in_dischargesummary() throws Exception {
		driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Month'])[1]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")).click();
		// Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")).sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Days'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")).click();
		Thread.sleep(2000);
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]"));
		String text = "Symptom";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[3]")).sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Years'])[1]")).click();
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//div[@id='input_close_cmpl'])[3]/i[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		// Robot escape = new Robot();
		// escape.keyPress(KeyEvent.VK_ESCAPE);
		// Thread.sleep(2000);

	}

	@And("enter hospitalcourse medication during hospital and condition on discharge")
	public void enter_hospitalcourse_details() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[3]"))
				.sendKeys("Test hospital course" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[3]"))
				.sendKeys("Test hospital course2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[3]")).sendKeys("Test hospital course3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[4]")).sendKeys("Dolo 650" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[4]"))
				.sendKeys("Test medicine Syrup" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[4]")).sendKeys("Test Cap Cipla");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[5]"))
				.sendKeys("Test condition1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[5]"))
				.sendKeys("Test condition2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[5]")).sendKeys("Test condition3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);

	}

	@Then("enter the vitals for ippatient in dischargesummary")
	public void enter_vitals() throws Exception {
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pulse(bpm)'])[1]/following-sibling::input[1]"))
				.sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[normalize-space(text())='Height(Cms)'])[1]/following-sibling::input[1]"))
				.sendKeys("170");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[normalize-space(text())='Weight(Kgs)'])[1]/following-sibling::input[1]"))
				.sendKeys("69" + Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[normalize-space(text())='Waist(cms)'])[1]/following-sibling::input[1]"))
				.sendKeys("32");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[normalize-space(text())='Hip(cms)'])[1]/following-sibling::input[1]"))
				.sendKeys("31");
		Thread.sleep(1000);
		// temp
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[9]/div[1]/input[12]"))
				.sendKeys("101");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='SpO2(%)'])[1]/following-sibling::input[1]"))
				.sendKeys("76");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='section_header rounded-top'])[13]/following-sibling::input[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='section_header rounded-top'])[14]/following-sibling::input[1]"))
				.click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='bp-s'])[1]")).sendKeys("120");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@id='bp-d'])[1]")).sendKeys("90");
//		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(2000);

		// advice on discharge
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[6]"))
				.sendKeys("test advice on ds1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[6]"))
				.sendKeys("test advice on ds2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='bulletPointTextNew'])[6]")).sendKeys("test advice on ds3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
		Thread.sleep(1000);
	}

	@And("select the medicine1 for ippatient in dischargesummary")
	public void select_the_medicine1_for_ippatient_in_dischargesummary() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Medicine'])[1]/preceding-sibling::input[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[1]"))
				.clear();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[1]"))
				.sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='medication_notes'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='medication_notes'])[1]")).sendKeys("Test medicine notes");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Medicine'])[2]/preceding-sibling::input[1]")).click();
		Thread.sleep(3000);
		// Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		try {
			if (driver.findElement(By.xpath("(//div[text()='1-0-1-1'])[1]")).isDisplayed()) {
				driver.findElement(By.xpath("(//div[text()='1-0-1-1'])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//label[text()='Route'])[2]/following-sibling::span[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//li[text()='Oral'])[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//li[text()='After Food'])[1]")).click();
				Thread.sleep(1000);
				/*
				 * WebElement brandInput =
				 * driver.findElement(By.xpath("(//input[@class='frequency'])[2]"));
				 * 
				 * String text = "Dai"; for (char c : text.toCharArray()) {
				 * brandInput.sendKeys(Character.toString(c)); Thread.sleep(300); // small pause
				 * between keystrokes } Thread.sleep(2000);
				 */
				driver.findElement(By.xpath("(//input[@class='frequency'])[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[text()='Daily'])[1]")).click();
				// Thread.sleep(1000);
				driver.findElement(By.xpath(
						"(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]"))
						.clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath(
						"(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]"))
						.sendKeys("2" + Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
				Thread.sleep(1000);
			} else {
				driver.findElement(By.xpath(
						"(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]"))
						.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(
						"(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]"))
						.clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath(
						"(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]"))
						.sendKeys("2" + Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
	}

	@Then("add the lab and request")
	public void add_the_lab_and_request() throws Exception {
		driver.findElement(By.xpath("(//input[@id='recommended_lab_input_helper'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='recommended_lab_input_helper'])[1]"));
		String text = "Profile";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='recommended_lab_input_helper'])[1]")).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]")).click();
		Thread.sleep(2000);
		// request
		driver.findElement(By.xpath("(//a[text()='Request'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='requestLabs'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("add the procedures in ds")
	public void add_the_procedures_in_ds() throws Exception {
		driver.findElement(By.xpath("(//input[@id='packages_input'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='packages_input'])[1]"));
		String text = "Testing";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='packages_input'])[1]")).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[@class='material-icons close package_chip_close'])[3]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
	}

	@Then("enter the nextvisitdate in the ds and enter the comments")
	public void enter_the_nextvisitdate_in_the_ds_and_enter_the_comments() throws Exception {
		driver.findElement(By.xpath("(//input[@id='doctor_visit_nxt_vst_dur'])[1]")).sendKeys("5" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='In-person'])[1]")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@id='textareaField'])[1]")).sendKeys("Test comments1" + Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@id='textareaField'])[1]")).sendKeys("Test comments2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='textareaField'])[1]")).sendKeys("Test comments3" + Keys.ENTER);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
	}

	@When("editable picture is clicked it will open picture to add text")
	public void editable_picture_is_clicked_it_will_open_picture_to_add_text() throws Exception {
		// clicking on the abdomen image
		driver.findElement(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]"))
				.click();
		Thread.sleep(2000);

	}

	@Then("add the text in the editable image and save")
	public void add_the_text_in_the_editable_image_and_save() throws Exception {
		///////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the "Frame Maker" tool
		WebElement frameMaker = driver.findElement(By.xpath("(//div[@title='Frame marker'])[1]"));
		frameMaker.click();
		// Step 2: Identify the image area (canvas or drawing area)
		WebElement imageCanvas = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 3: Use Actions class to click, hold, move, and release
		Actions action = new Actions(driver);
		// Example: Drag from (100, 100) to (300, 200) relative to the image
		action.moveToElement(imageCanvas, 0, 0).clickAndHold().moveByOffset(100, 100).release().perform();
		Thread.sleep(2000);
		///////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the 2nd drawing tool (rectangle option)
		WebElement drawRectangleTool = driver.findElement(By.xpath("(//div[@title='Freehand marker'])[1]"));
		drawRectangleTool.click();
		// Step 2: Wait for tool activation (optional)
		Thread.sleep(1000);
		// Step 3: Identify the drawing area (canvas or image element)
		WebElement canvas = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Example: drag starting at 150,150 and draw box of width 100, height 100
		action.moveToElement(canvas, 0, 0).clickAndHold().moveByOffset(100, 100).release().perform();
		Thread.sleep(2000);
		// clicking on the undo
		driver.findElement(By.xpath("(//div[@title='Undo'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the delete
		driver.findElement(By.xpath("(//div[@title='Delete marker'])[1]")).click();
		Thread.sleep(2000);
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the "Frame Maker" tool
		WebElement frameMaker1 = driver.findElement(By.xpath("(//div[@title='Frame marker'])[1]"));
		frameMaker1.click();
		// Step 2: Identify the image area (canvas or drawing area)
		WebElement imageCanvas1 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 3: Use Actions class to click, hold, move, and release
		Actions action1 = new Actions(driver);
		// Example: Drag from (100, 100) to (300, 200) relative to the image
		action1.moveToElement(imageCanvas1, -50, -180).clickAndHold().moveByOffset(100, 100).release().perform();
		Thread.sleep(2000);
		// Step 1: Click on the 2nd drawing tool (rectangle option)
		WebElement drawRectangleTool1 = driver.findElement(By.xpath("(//div[@title='Freehand marker'])[1]"));
		drawRectangleTool1.click();
		// Step 2: Wait for tool activation (optional)
		Thread.sleep(1000);
		// Step 3: Identify the drawing area (canvas or image element)
		WebElement canvas1 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Example: drag starting at 150,150 and draw box of width 100, height 100
		action1.moveToElement(canvas1, 0, -100).clickAndHold().moveByOffset(100, 100).release().perform();
		Thread.sleep(2000);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the 3rd button (Arrow Maker)
		WebElement arrowTool = driver.findElement(By.xpath("(//div[@title='Arrow marker'])[1]"));
		arrowTool.click();
		// Step 2: Wait for the tool to activate
		Thread.sleep(1000);
		// Step 3: Identify the image/canvas area
		WebElement canvas11 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 4: Perform drag-and-drop (draw arrow)
		// Actions action1 = new Actions(driver);
		// Example: draw arrow from point (200,150) to (350,150)
		action1.moveToElement(canvas11, 0, 0).clickAndHold().moveByOffset(150, 0).release().perform();
		Thread.sleep(3000);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the 4th button (Text Tool)
		WebElement textTool = driver.findElement(By.xpath("(//div[@title='Text marker'])[1]"));
		textTool.click();
		// Step 2: Wait for tool activation
		Thread.sleep(2000);
		// clicking on the color
//		driver.findElement(By.xpath("(//div[@title='Color'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[52]/div/div[3]/div[1]/div/div[3]/div[1]")).click();
//		Thread.sleep(2000);

		// Step 3: Identify the canvas or drawing area
		WebElement canvas111 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 4: Drag on the canvas to create text area
		Actions action11 = new Actions(driver);
		action11.moveToElement(canvas111, -150, 20) // Starting point
				.clickAndHold().moveByOffset(200, 200) // Define the text box size
				.release().perform();
		// Step 5: Wait for textbox to appear
		Thread.sleep(1000);
		// Step 6: Locate the text box (assuming “Your text here” placeholder appears)
		WebElement textBox = driver.findElement(By.xpath("//div[contains(text(),'Your text here')][1]"));
		textBox.click();
		// Step 8: Clear default text and enter your desired text
		textBox.sendKeys(Keys.CONTROL + "a"); // Select all (optional)
		textBox.sendKeys("Test text in abdoemn in DS"); // Replace with your text
		Thread.sleep(1000);
//		// selecting the font
//		driver.findElement(By.xpath("(//div[@title='Font'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[contains(text(), 'The quick brown')])[3]")).click();
//		Thread.sleep(2000);
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Click on the 4th button - Highlighter
		WebElement highlighterTool = driver.findElement(By.xpath("(//div[@title='Highlight marker'])[1]"));
		highlighterTool.click();
		Thread.sleep(1000);
		// Locate the canvas element where you draw
		WebElement canvas45 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Create Actions instance for drag and drop (highlighting)
		Actions act = new Actions(driver);
		// Move to start point and drag for highlighting
		act.moveToElement(canvas45, -50, 0) // starting point (x=150, y=150)
				.clickAndHold().moveByOffset(150, 100) // drag horizontally (change offset if needed)
				.release().perform();
		Thread.sleep(2000); // Wait to view highlight effect
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Click on the last button - Callout Marker
		WebElement calloutTool = driver.findElement(By.xpath("(//div[@title='Callout marker'])[1]"));
		calloutTool.click();
		Thread.sleep(1000);
		// Locate the canvas where you draw the callout
		WebElement canvas43 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Perform drag and drop to create the callout shape
		Actions actions = new Actions(driver);
		actions.moveToElement(canvas43, 0, -150) // starting point
				.clickAndHold().moveByOffset(150, 100) // shape size
				.release().perform();
		Thread.sleep(2000);
		// wait for the callout box to appear
		// Click on the callout box to focus for typing
		WebElement calloutBox = driver.findElement(By.xpath("(//div[contains(text(),'Your text here')])[1]"));
		calloutBox.click();
		Thread.sleep(1000);
		WebElement editableDiv = driver.findElement(By.xpath("(//div[@contenteditable='true'])[1]"));
		editableDiv.click();
		Thread.sleep(500);
		// Get existing text
		String text = editableDiv.getText();
		// Delete character by character
		for (int i = 0; i < text.length(); i++) {
			editableDiv.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200); // slows deletion to match UI
		}
		Thread.sleep(2000);
		editableDiv.sendKeys("My updated text goes here" + Keys.SPACE);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_A);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_B);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_B);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(1000);

//		// Enter the text inside the callout
//		calloutBox.sendKeys("This is the text for testing purpose");
		// Optional pause
		Thread.sleep(2000);
		// clicking on the save and close button
		driver.findElement(By.xpath("(//div[@title='Save and close'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the abdomen image
		driver.findElement(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]"))
				.click();
		Thread.sleep(2000);
		// close it
		driver.findElement(By.xpath("(//div[@title='Close'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the medicalsummary and closing from ds")
	public void clicking_on_the_medicalsummary_and_closing_from_ds() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='patientMedicalSummaryModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);

	}

	@And("clicking on the notes and adding notes and closing from ds")
	public void clicking_on_the_notes_and_adding_notes_and_closing_from_ds() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor notes'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor notes'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea#message")).sendKeys("Test doctor message");
		Thread.sleep(1000);
		WebElement others = driver.findElement(By.xpath("(//label[text()='Others'])[1]"));
		others.click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='doctor_notes_new_modal'])[1]/div[1]/div[1]/div[1]/span[1]/i[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("clicking on the favourite dischargesummary and closing from ds")
	public void clicking_on_the_favourite_dischargesummary_and_closing_from_ds() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Base Discharge Summary 1'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Base Discharge Summary 1'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='patientHistoryInfoModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);

	}

	@And("clicking on the last prescription and sharing admitform to a mailid and perfomring click action on all buttons")
	public void clicking_on_the_last_prescription_and_sharing_admitform_to_a_mailid_and_clicking_all_buttons()
			throws Exception {
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last
		// prescription'])[1]/img[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last
		// prescription'])[1]/img[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);
		// // clicking on the all button
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img[1]"))).build().perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img[1]"))).click().build()
		// .perform();
		// Thread.sleep(2000);
		// // download & sharing registration form
		// action.moveToElement(driver.findElement(By.xpath(
		// "//span[contains(normalize-space(.),
		// 'Registration')]/ancestor::div[contains(@class,'collapsible-header')]//a[@data-tooltip='Print
		// With Header & Footer']")))
		// .build().perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath(
		// "//span[contains(normalize-space(.), 'Admit
		// Now')]/ancestor::div[contains(@class,'collapsible-header')]//a[@data-tooltip='Print
		// With Header & Footer']"))
		// .click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath(
		// "//span[contains(normalize-space(.), 'Admit
		// Now')]/ancestor::div[contains(@class,'collapsible-header')]//a[@data-tooltip='Share
		// PDF']"))
		// .click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		// Thread.sleep(1000);
		// // submit
		// driver.findElement(By.xpath("(//input[@class='btn green right btn-loader
		// submitBtn'])[1]")).click();
		// Thread.sleep(8000);
		// // clicking on the doc.consult button
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor
		// Visits'])[1]/img[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor
		// Visits'])[1]/img[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);
		// // clicking on the chemotherapy order
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Chemotherapy
		// Order'])[1]/img[1]")))
		// .build().perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Chemotherapy
		// Order'])[1]/img[1]")))
		// .click().build().perform();
		// Thread.sleep(2000);
		// // clicking on the diet visits
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Dietician
		// Vists'])[1]/img[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Dietician
		// Vists'])[1]/img[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);
		// // clicking on the diagnostic reports
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Diagnostic
		// Reports'])[1]/img[1]")))
		// .build().perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Diagnostic
		// Reports'])[1]/img[1]")))
		// .click().build().perform();
		// Thread.sleep(2000);
		// // clicking on the procedures
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Procedures'])[1]/img[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Procedures'])[1]/img[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);
		// // clicking on the forms
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Forms'])[1]/img[1]"))).build().perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Forms'])[1]/img[1]"))).click().build()
		// .perform();
		// Thread.sleep(2000);
		// // clicking on the ds
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Discharge
		// Summary'])[1]/img[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Discharge
		// Summary'])[1]/img[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		// Thread.sleep(2000);
		//
	}

	@And("clicking on the labreports and closing from ds")
	public void clicking_on_the_labreports_and_closing_from_ds() throws Exception {
		// // clicking on the ds
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab
		// Reports'])[1]/img[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab
		// Reports'])[1]/img[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		// Thread.sleep(2000);
	}

	@When("save as draft is clicked it will redirects to patientprofile")
	public void save_as_draft_is_clicked_it_will_redirects_to_patientprofile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@Then("click on discharge summmary button again to save it")
	public void click_on_discharge_summary_button_again_to_save_it() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Discharge Summary'])[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@When("save button is clicked it will open preview ds from that page download pdfs and share ds to a mailid")
	public void save_button_is_clicked_it_will_open_preview_ds_from_that_page_download_pdfs_and_share_ds_to_a_mailid()
			throws Exception {

		driver.findElement(By.xpath("(//input[@id='doctor_visit_nxt_vst_dur'])[1]")).sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Days'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='In-person'])[1]")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		for (int i = 0; i <= 2; i++) {
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		// clicking on the abdomen image
		driver.findElement(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]"))
				.click();
		Thread.sleep(2000);
		///////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the "Frame Maker" tool
		WebElement frameMaker = driver.findElement(By.xpath("(//div[@title='Frame marker'])[1]"));
		frameMaker.click();
		// Step 2: Identify the image area (canvas or drawing area)
		WebElement imageCanvas = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 3: Use Actions class to click, hold, move, and release
		Actions action = new Actions(driver);
		// Example: Drag from (100, 100) to (300, 200) relative to the image
		action.moveToElement(imageCanvas, 0, 0).clickAndHold().moveByOffset(100, 100).release().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@title='Save and close'])[1]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.cssSelector("input#saveBtn")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
//				.click();
//		Thread.sleep(5000);
		for (int i = 0; i <= 15; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// Click on "Print With Header & Footer" icon
		WebElement printWithHeaderFooter = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]")));
		printWithHeaderFooter.click();
		// Store the current (parent) window handle
		String parentWindow = driver.getWindowHandle();
		// Wait for the new window to open
		Thread.sleep(2000);
		// Get all open window handles
		Set<String> allWindows = driver.getWindowHandles();
		// Loop through each window
		for (String handle : allWindows) {
			if (!handle.equals(parentWindow)) {
				// Switch to the new window
				driver.switchTo().window(handle);
				Thread.sleep(2000); // wait for page to load
				// Close the child window
				driver.close();
				break;
			}
		}

		// Switch back to the parent window
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);

		// sharing
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emails")).clear();
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(8000);

	}

	@Then("edit and save the dischargesummary")
	public void edit_and_save_the_dischargesummary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Edit'])[1]")))).click();
		Thread.sleep(5000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@id='doctor_visit_nxt_vst_dur'])[1]")).sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Days'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='In-person'])[1]")).click();
			Thread.sleep(1000);
		}

		// clicking on the abdomen image
		driver.findElement(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]"))
				.click();
		Thread.sleep(2000);
		///////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the 4th button (Text Tool)
		WebElement textTool = driver.findElement(By.xpath("(//div[@title='Text marker'])[1]"));
		textTool.click();
		// Step 2: Wait for tool activation
		Thread.sleep(2000);
		// Step 3: Identify the canvas or drawing area
		WebElement canvas111 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 4: Drag on the canvas to create text area
		Actions action11 = new Actions(driver);
		action11.moveToElement(canvas111, -150, 20) // Starting point
				.clickAndHold().moveByOffset(200, 200) // Define the text box size
				.release().perform();
		// Step 5: Wait for textbox to appear
		Thread.sleep(1000);
		// Step 6: Locate the text box (assuming “Your text here” placeholder appears)
		WebElement textBox = driver.findElement(By.xpath("//div[contains(text(),'Your text here')][1]"));
		textBox.click();
		// Step 8: Clear default text and enter your desired text
		textBox.sendKeys(Keys.CONTROL + "a"); // Select all (optional)
		textBox.sendKeys("Test text in abdoemn in Edit DS"); // Replace with your text
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@title='Save and close'])[1]")).click();
		Thread.sleep(2000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(5000);
		for (int i = 0; i <= 15; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);

	}

	@And("then download and share the pdfs from dischargesummary preview page")
	public void then_download_and_share_the_pdfs_from_dischargesummary_preview_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// Click on "Print With Header & Footer" icon
		driver.findElement(By.xpath("(//a[@class='tooltipped right print_icon'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// Store the current (parent) window handle
		String parentWindow = driver.getWindowHandle();

		// Wait for the new window to open
		Thread.sleep(2000);

		// Get all open window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Loop through each window
		for (String handle : allWindows) {
			if (!handle.equals(parentWindow)) {
				// Switch to the new window
				driver.switchTo().window(handle);
				Thread.sleep(2000); // wait for page to load
				// Close the child window
				driver.close();
				break;
			}
		}

		// Switch back to the parent window
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);

		// sharing
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emails")).clear();
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(8000);

	}

	@Then("click on close button and it will redirects to patientprofile page")
	public void click_on_close_button_and_it_will_redirects_to_patientprofile_page() throws Exception {
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Close'])[1]")))).click();
		Thread.sleep(5000);
	}

	@And("load dischargesummary from history and add favourite dischargesummary")
	public void load_dischargesummary_from_history_and_add_favourite_dischargesummary() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// clicking on the history
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@id='patientHistoryBtn'])[1]"))))
				.click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);

		// with header and footer
		String parentwind1 = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindows1 = driver.getWindowHandles();

		// Iterate through all handles to find the new child window
		for (String handle : allWindows1) {
			if (!handle.equals(parentwind1)) {
				// Switch to the new child window
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				// Perform actions on the new window (e.g., close it)
				driver.close();

				// Break out of the loop since we've found and closed the child window
				break;
			}
		}
		Thread.sleep(1000);
		// Switch back to the original parent window
		driver.switchTo().window(parentwind1);
		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Discharge Summary'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Discharge Summary'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(8000);

		// Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Load Discharge Summary'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Load Discharge Summary'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		// Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Base Discharge Summary 1'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Base Discharge Summary 1'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'Cucum Fav Ds')])[1]")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).sendKeys("5" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(2000);
		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]")).click();
		Thread.sleep(5000);
//		// vitals
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pulse(bpm)'])[1]/following-sibling::input[1]"))
//				.clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pulse(bpm)'])[1]/following-sibling::input[1]"))
//				.sendKeys("98");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Height(Cms)'])[1]/following-sibling::input[1]"))
//				.clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Height(Cms)'])[1]/following-sibling::input[1]"))
//				.sendKeys("170");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Weight(Kgs)'])[1]/following-sibling::input[1]"))
//				.clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Weight(Kgs)'])[1]/following-sibling::input[1]"))
//				.sendKeys("69");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Waist(cms)'])[1]/following-sibling::input[1]"))
//				.clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Waist(cms)'])[1]/following-sibling::input[1]"))
//				.sendKeys("32");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Hip(cms)'])[1]/following-sibling::input[1]"))
//				.clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Hip(cms)'])[1]/following-sibling::input[1]"))
//				.sendKeys("31");
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[9]/div[1]/input[12]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(
//				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[9]/div[1]/input[12]"))
//				.sendKeys("101");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[normalize-space(text())='SpO2(%)'])[1]/following-sibling::input[1]"))
//				.clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[normalize-space(text())='SpO2(%)'])[1]/following-sibling::input[1]"))
//				.sendKeys("76");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='section_header rounded-top'])[13]/following-sibling::input[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='section_header rounded-top'])[14]/following-sibling::input[1]"))
//				.click();
//		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//input[@id='bp-s'])[1]")).clear();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//input[@id='bp-d'])[1]")).clear();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//input[@id='bp-s'])[1]")).sendKeys("120");
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//input[@id='bp-d'])[1]")).sendKeys("90");
////		Thread.sleep(2000);
//		// JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 500)");
//		Thread.sleep(2000);

	}

	@Then("save and download the pdfs and share it to mail")
	public void save_and_download_the_pdfs_and_share_it_to_mail() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		// save
//		driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]")).click();
//		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// Click on "Print With Header & Footer" icon
		driver.findElement(By.xpath("(//a[@class='tooltipped right print_icon'])[1]/img[1]")).click();
		Thread.sleep(3000);

		// Store the current (parent) window handle
		String parentWindow = driver.getWindowHandle();

		// Wait for the new window to open
		Thread.sleep(2000);

		// Get all open window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Loop through each window
		for (String handle : allWindows) {
			if (!handle.equals(parentWindow)) {
				// Switch to the new window
				driver.switchTo().window(handle);
				Thread.sleep(2000); // wait for page to load
				// Close the child window
				driver.close();
				break;
			}
		}

		// Switch back to the parent window
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// sharing
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(8000);
	}

	@Then("signout and login to nanohealthipd to discharge patient")
	public void signout_and_login_to_nanohealthipd_to_discharge_patient() throws Exception {
		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_IPD'])[1]")).click();
		Thread.sleep(5000);
	}

	@When("ipdhospital is opened search for patient and release bed")
	public void ipdhospital_is_opened_search_for_patient_and_release_bed() throws Exception {
		driver.findElement(By.id("frst_nm")).sendKeys("5788110053");
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
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
				Thread.sleep(1000);
			}
		}
		driver.findElement(By.xpath("(//div[@class='bkng_services_prfl'])[1]/div/a[13]/img[1]")).click();
		Thread.sleep(2000);
		// release bed
		driver.findElement(By.xpath("(//a[text()='Release Bed'])[1]")).click();
		Thread.sleep(3000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//		} else {
//			for (int i = 0; i <= 1; i++) {
//				driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
//				Thread.sleep(1000);
//			}
//		}

		// paying the invoice amount using redeem option
		// clicking on the pending amount in the popup
		driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 3; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
		}
		WebElement redeem = driver.findElement(By.xpath("(//label[text()='Redeem'])[1]"));
		redeem.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@id='bookNowBtn'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {
			System.out.println("Amount paid through redeem option");
		}
	}

	@Then("discharge the patient from the hospital")
	public void discharge_the_patient_from_the_hospital() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Discharge'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='closeInvoiceAlert'])[1]/div[1]/div[3]/a[1]")).click();
		Thread.sleep(2000);
		WebElement five = driver.findElement(By.xpath("(//label[text()='5'])[1]"));
		five.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
		// close for pending amount
		if (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
				Thread.sleep(1000);
			}
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='patientHistoryBtn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Discharge'])/following-sibling::span[1]/a[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Discharge'])/following-sibling::span[1]/a[2]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(8000);
	}

}
