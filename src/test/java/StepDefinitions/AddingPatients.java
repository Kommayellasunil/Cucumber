package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class AddingPatients {
	public WebDriver driver;

	@Given("navigate to nanohealth url {string}")
	public void launchBrowser(String url) throws Exception {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver145.exe");
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(co);
//		co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://customer.nanohealthplan.com/users/sign_in");
//		driver.manage().window().maximize();
//	}

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		Thread.sleep(3000);
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("enter the emailormobile {string} and password {string}")
	public void enter_the_emailormobile_and_password(String emailormobile, String password) throws Exception {
		driver.findElement(By.xpath("(//input[@id='user_login'])[1]")).sendKeys(emailormobile);
		driver.findElement(By.xpath("(//input[@id='user_password'])[1]")).sendKeys(password);
		Thread.sleep(15000);
	}

	@And("click signin button")
	public void click_signin_button() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the profile for clinic manager")
	public void select_the_profile_for_clinic_manager() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("delete existing patient using search bar")
	public void delete_existing_patient_using_search_bar() throws Exception {
		Thread.sleep(8000);
//		driver.findElement(By.id("frst_nm")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("7781110013");
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement firstName = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))
		);
		firstName.sendKeys("7781110013");
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
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("existing patient_deleted")
	public void existing_patient_deleted() throws Exception {
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on add_patienticon for registration")
	public void click_on_add_patienticon_for_registration() throws Exception {
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("selecting the  title_of_patient")
	public void selecting_the_title_of_patient() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
//				driver.findElement(By.xpath("(//span[@class='selection'])[1]")).sendKeys(Keys.DOWN);
//				Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("user enters following details into registration form to register")
	public void user_enters_following_details_into_registration_form_to_register(
			io.cucumber.datatable.DataTable dataTable) throws Exception {
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
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys(regData.get(9).get(1));
//		// aadharcardnumber
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[9]/div[2]/input"))
//				.sendKeys(regData.get(11).get(1));
//		Thread.sleep(1000);
	}

	@Then("selecting_the radio_button")
	public void selecting_the_radio_button() throws Exception {
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
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(2000);

	}

	@And("click on submitbutton_to_register")
	public void click_on_submitbutton_to_register() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(10000);
	}

	@Then("it redirects to the patient_profile")
	public void it_redirects_to_the_patient_profile() {
	}

	@And("deleting the existing family member")
	public void deleting_the_existing_family_member() throws Exception {
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).click();
		Thread.sleep(2000);
		// deleting the already added family member
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frst_nm")))).sendKeys("8008117652");
//		driver.findElement(By.id("frst_nm")).sendKeys("kmkm");
		Thread.sleep(2000);
//		// clicking on the name
//		driver.findElement(By.xpath("(//a[text()='Km Km'])[1]")).click();
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
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
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
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frst_nm")))).sendKeys("Demomrfam");
		Thread.sleep(2000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("user click on add family member")
	public void user_click_on_add_family_member() throws Exception {
		// clicking on the add family member
		driver.findElement(By.xpath("//a[@data-tooltip='Add Family Member']/i[1]")).click();
		Thread.sleep(2000);
		// selecting the title
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Ms./Mrs.'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("entering the following details in the add family member")
	public void entering_the_following_details_in_the_add_family_member(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> addFammem = dataTable.asLists(String.class);
		// firstname
		driver.findElement(By.xpath("(//input[@id='first_name'])[2]")).sendKeys(addFammem.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		driver.findElement(By.xpath("(//input[@id='lst_name'])[2]")).sendKeys(addFammem.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// age
//		driver.findElement(By.xpath("/html/body/main/div/div[4]/div/div[2]/div/div[3]/form/div[2]/div[6]/input"))
//				.sendKeys(addFammem.get(2).get(1));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("selecting the relation by clicking on the dropdown")
	public void selecting_the_relation_by_clicking_on_the_dropdown() throws Exception {
		// age
		driver.findElement(By.xpath("(//input[@id='patient_master_dob'])[2]")).click();
		Thread.sleep(1000);
		// clicking on the year
		driver.findElement(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='1970'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);

		// phone
		driver.findElement(By.xpath("(//input[@id='nmbr'])[2]")).sendKeys("8008117652");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("testfamertwo@gmail.com");
		Thread.sleep(1000);

		// selecting the relation
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Mother']")).click();
		Thread.sleep(1000);
//		// selecting the program
//		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("selecting the checkbox for address")
	public void selecting_the_checkbox_for_address() throws Exception {
		// clicking on the checkbox
		WebElement cb = driver.findElement(By.xpath("(//div[@class='row address-box edit_add'])[1]/div[1]/label[1]"));
		cb.click();
		Thread.sleep(1000);

	}

	@When("clicking on the submit button in the add family member popup")
	public void clicking_on_the_submit_button_in_the_add_family_member_popup() throws Exception {
		// save
		driver.findElement(By.cssSelector("input.btn.green.right.submit_btn")).click();
		Thread.sleep(5000);
	}

	@Then("family member is added and redirected to the patient profile")
	public void family_member_is_added_and_redirected_to_the_patient_profile() {
	}

	@And("clicking on the edit relationship pencil icon")
	public void clicking_on_the_edit_relationship_pencil_icon() throws Exception {
		Thread.sleep(1000);
		// mouse-hovering to the edit relationship
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//li[@class='patient_card']/a/i"))).build().perform();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		// clicking on the edit relationship
		driver.findElement(By.xpath("//li[@class='patient_card']/a/i")).click();
		Thread.sleep(1000);

	}

	@Then("edit relatioship popup will be opened")
	public void edit_relatioship_popup_will_be_opened() {
	}

	@When("edit the relation from dropdown")
	public void edit_the_relation_from_dropdown() throws Exception {
		// clicking on the drop-down
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Mother-in-law'])[1]")).click();
		Thread.sleep(1000);

	}

	@Then("submit button will be visible click on it")
	public void submit_button_will_be_visible_click_on_it() throws Exception {
		// submit
		driver.findElement(By.xpath("(//div[@class='modal-footer'])[1]/input[1]")).click();
		Thread.sleep(5000);
	}

	@And("it will again redirect to the patient profile")
	public void it_will_again_redirect_to_the_patient_profile() {
		driver.close();
	}

	@And("deleting the existing same number family member")
	public void deleting_the_existing_same_number_family_member() throws Exception {
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("7667676769");
		Thread.sleep(2000);
//		// clicking on the name
//		driver.findElement(By.xpath("(//a[text()='Automation Existmember'])[1]")).click();
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the add patient icon to register a new patient")
	public void click_on_the_add_patient_icon_to_register_a_new_patient() throws Exception {
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select the title of the patient to register new patient")
	public void select_the_title_of_the_patient_to_register_new_patient() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
//				driver.findElement(By.xpath("(//span[@class='selection'])[1]")).sendKeys(Keys.DOWN);
//				Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("registration form is opened to register a new patient then enter the following details")
	public void registration_form_is_opened_to_register_a_new_patient_then_enter_the_following_details(
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
//				.sendKeys(regData.get(8).get(1));

	}

	@Then("select the required radio buttons to register")
	public void select_the_required_radio_buttons_to_register() throws Exception {
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
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
	}

	@And("click submit button_to_register the patient of whom entered details in registration form")
	public void click_submit_button_to_register_the_patient_of_whom_entered_details_in_registration_form()
			throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@Then("deleting the existing family member using search")
	public void deleting_the_existing_family_member_using_search() throws Exception {
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("3334445558");
		Thread.sleep(5000);
//		// clicking on the name
//		driver.findElement(By.xpath("(//a[text()='Family member'])[1]")).click();
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
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("clicking on the add patient to add family member using existing phone number")
	public void clicking_on_the_add_patient_to_add_family_member_using_existing_phone_number() throws Exception {
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("enter the already existing number in mobile number filed")
	public void enter_the_already_existing_number_in_mobile_number_filed() {
		// phone
		driver.findElement(By.id("nmbr")).sendKeys("7667676769");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		driver.findElement(By.id("email")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("existing number entered popup will be shown")
	public void existing_number_entered_popup_will_be_shown() throws Exception {
		Thread.sleep(1000);
	}

	@And("from the popup select the family member radio button")
	public void from_the_popup_select_the_family_member_radio_button() throws Exception {
		WebElement fammem = driver.findElement(By.xpath("(//label[text()='Family Member'])[1]"));
		fammem.click();
		Thread.sleep(3000);
	}

	@Then("add family member popup will be shown")
	public void add_family_member_popup_will_be_shown() {
	}

	@And("enter the family member first and last names")
	public void enter_the_family_member_first_and_last_names() {
		driver.findElement(By.xpath("(//input[@name='patient_master[frst_nm]'])[2]")).sendKeys("Family");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='patient_master[lst_nm]'])[2]")).sendKeys("member");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the sex of the family member")
	public void select_the_sex_of_the_family_member() {
		WebElement f = driver.findElement(By.xpath("(//label[text()='F'])[2]"));
		f.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the DOB and select the age")
	public void click_on_the_dob_and_select_the_age() throws Exception {
		driver.findElement(By.xpath("(//input[@id='patient_master_dob'])[2]")).click();
		Thread.sleep(1000);
		// clicking on the year
		driver.findElement(By.xpath("(//div[@class='selects-container'])[1]/div[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/span[text()='1985'])[2]")).click();
		Thread.sleep(1000);
		// clicking on the month
		driver.findElement(By.xpath("(//div[@class='selects-container'])[1]/div[1]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/span[text()='April'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='13'])[1]")).click();
		Thread.sleep(1000);
		// phone number
		driver.findElement(By.xpath("(//input[@ID='nmbr'])[2]")).sendKeys("3334445558");
		Thread.sleep(1000);
	}

	@Then("select relation from the dropdown")
	public void select_relation_from_the_dropdown() throws Exception {
		// selecting the relation
		driver.findElement(By.xpath("(//span[@class='selection'])[12]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Mother']")).click();
		Thread.sleep(1000);
//		// selecting the program
//		driver.findElement(By.xpath("(//span[@class='selection'])[13]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
	}

	@And("select the home checkbox for family member")
	public void select_the_home_checkbox_for_family_member() throws Exception {

	}

	@Then("click on the submit button to add family member")
	public void click_on_the_submit_button_to_add_family_member() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(3000);
	}

	@When("family member is added then it will shown under the family member section")
	public void family_member_is_added_then_it_will_shown_under_the_family_member_section() {
	}

	@Then("click on the added family member name")
	public void click_on_the_added_family_member_name() throws Exception {
		driver.findElement(By.xpath("(//li[@class='patient_card'])[1]/div[1]/a[1]")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@And("click on the add patient icon in the top of the page")
	public void click_on_the_add_patient_icon_in_the_top_of_the_page() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the add patient
		driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")).click();
		Thread.sleep(2000);
	}

	@Then("enter the existing phone number to select the self")
	public void enter_the_existing_phone_number_to_select_the_self() throws Exception {
		// phone
		driver.findElement(By.id("nmbr")).sendKeys("7667676769");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		driver.findElement(By.id("email")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
	}

	@When("existing phone number entered then popup opens")
	public void existing_phone_number_entered_then_popup_opens() {
	}

	@Then("select the self radio button from the popup")
	public void select_the_self_radio_button_from_the_popup() throws Exception {
		WebElement self = driver.findElement(By.xpath("(//label[text()='Self'])[2]"));
		self.click();
		Thread.sleep(3000);
	}

	@And("it will open the patient profile for that existing mobile number")
	public void it_will_open_the_patient_profile_for_that_existing_mobile_number() {
		driver.close();
	}

	@Then("search a existing patient and copy the patient id")
	public void search_a_existing_patient_and_copy_the_patient_id() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("Demomrfam");
		Thread.sleep(3000);

		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);

//		Actions action = new Actions(driver);
//		// action.doubleClick(driver.findElement(By.cssSelector("li#clinic_patient_profile:nth-of-type(1)"))).perform();
//		action.doubleClick(driver.findElement(By.xpath("(//img[@data-tooltip='Copy to Clipboard'])[1]"))).perform();
//		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement copyIcon = driver.findElement(By.xpath("(//img[@data-tooltip='Copy to Clipboard'])[1]"));
		action.click(copyIcon).perform();
		Thread.sleep(3000);

		// closing the popup
		driver.findElement(By.xpath("(//div[@id='pt_qr_modal'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(3000);

		// clicking on the add patient
		driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")).click();
		Thread.sleep(3000);
	}

	@And("open registration page from the clinic manager role")
	public void open_registration_page_from_the_clinic_manager_role() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[1]/div/div[2]/input")).click();
		Thread.sleep(1000);
		Robot v = new Robot();
		v.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		v.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		v.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		v.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[1]/div/div[2]/input"))
				.sendKeys(Keys.TAB);
		Thread.sleep(1000);
	}

	@Then("paste the reg id in the registration id field")
	public void paste_the_reg_id_in_the_registration_id_field() {

	}

	@And("check the validation for existing patient reg id")
	public void check_the_validation_for_existing_patient_reg_id() throws Exception {
		String dupregid = driver.findElement(By.xpath("(//div[@class='form_err reqErrAlertRGST'])[1]")).getText();
		System.out.println("Validation:" + dupregid);
		Thread.sleep(2000);
		// driver.close();

	}

	@Then("searching with invoice number and click on the invoice id")
	public void searching_with_invoice_number_and_click_on_the_invoice_id() throws Exception {
		driver.findElement(By.xpath("(//i[@class='material-icons right search_fun'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='search_link inv_srch'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='invoice'])[1]")).sendKeys("OP-");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[1]/a[1]"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[1]/a[1]"))).click().build()
				.perform();
		Thread.sleep(5000);
		driver.close();

	}

}
