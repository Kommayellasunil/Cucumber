package ClinicManager;

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
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("enter the emailormobile {string} and password {string}")
	public void enter_the_emailormobile_and_password(String emailormobile, String password) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_login'])[1]")))
				.sendKeys(emailormobile);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_password'])[1]")))
				.sendKeys(password);
		Thread.sleep(5000);
	}

	@And("click signin button")
	public void click_signin_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
	}

	@Then("select the profile for clinic manager")
	public void select_the_profile_for_clinic_manager() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000); // kept for Robot
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // kept for Robot
		// selecting cdp admin role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();
	}

	@And("delete existing patient using search bar")
	public void delete_existing_patient_using_search_bar() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm")));
		firstName.sendKeys("7781110013");

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
	}

	@Then("existing patient_deleted")
	public void existing_patient_deleted() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting clinic manager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
	}

	@And("click on add_patienticon for registration")
	public void click_on_add_patienticon_for_registration() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
	}

	@Then("selecting the  title_of_patient")
	public void selecting_the_title_of_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the title
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
	}

	@When("user enters following details into registration form to register")
	public void user_enters_following_details_into_registration_form_to_register(
			io.cucumber.datatable.DataTable dataTable) throws Exception {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]")))
				.sendKeys(regData.get(7).get(1));
		// district
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys(regData.get(8).get(1));
		// pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000); // kept for Robot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys(regData.get(9).get(1));
	}

	@Then("selecting_the radio_button")
	public void selecting_the_radio_button() throws Exception {
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
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000); // kept for Robot
	}

	@And("click on submitbutton_to_register")
	public void click_on_submitbutton_to_register() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000); // kept for Robot
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
	}

	@Then("it redirects to the patient_profile")
	public void it_redirects_to_the_patient_profile() {
	}

	@And("deleting the existing family member")
	public void deleting_the_existing_family_member() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdp admin role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("frst_nm"))).click();

		// deleting the already added family member
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("8008117652");

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
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")))
					.click();
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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting clinic manager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("frst_nm"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("Demomrfam");
		// clicking on the patient name
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col.s7.btn-loader.opt_search"))).click();
		// clicking on the view profile
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='View Profile'])[1]"))).click();
	}

	@When("user click on add family member")
	public void user_click_on_add_family_member() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add family member
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-tooltip='Add Family Member']/i[1]")))
				.click();
		// selecting the title
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Ms./Mrs.'])[1]"))).click();
	}

	@Then("entering the following details in the add family member")
	public void entering_the_following_details_in_the_add_family_member(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> addFammem = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// firstname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='first_name'])[2]")))
				.sendKeys(addFammem.get(0).get(1));
		// lastname
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='lst_name'])[2]")))
				.sendKeys(addFammem.get(1).get(1));
	}

	@And("selecting the relation by clicking on the dropdown")
	public void selecting_the_relation_by_clicking_on_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// age
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='patient_master_dob'])[2]"))).click();
		// clicking on the year
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='1970'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();

		// phone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='nmbr'])[2]")))
				.sendKeys("8008117652");
		// email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='email'])[2]")))
				.sendKeys("testfamertwo@gmail.com");

		// selecting the relation
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[5]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Mother']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
		Thread.sleep(2000); // kept for Robot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='email'])[2]")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000); // kept for Robot
	}

	@Then("selecting the checkbox for address")
	public void selecting_the_checkbox_for_address() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the checkbox
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='row address-box edit_add'])[1]/div[1]/label[1]")))
				.click();
	}

	@When("clicking on the submit button in the add family member popup")
	public void clicking_on_the_submit_button_in_the_add_family_member_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn.green.right.submit_btn"))).click();
	}

	@Then("family member is added and redirected to the patient profile")
	public void family_member_is_added_and_redirected_to_the_patient_profile() {
	}

	@And("clicking on the edit relationship pencil icon")
	public void clicking_on_the_edit_relationship_pencil_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// mouse-hovering to the edit relationship
		Actions action = new Actions(driver);
		WebElement editRel = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='patient_card']/a/i")));
		action.moveToElement(editRel).build().perform();

		driver.navigate().refresh();

		// clicking on the edit relationship
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='patient_card']/a/i"))).click();
	}

	@Then("edit relatioship popup will be opened")
	public void edit_relatioship_popup_will_be_opened() {
	}

	@When("edit the relation from dropdown")
	public void edit_the_relation_from_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the drop-down
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Mother-in-law'])[1]"))).click();
	}

	@Then("submit button will be visible click on it")
	public void submit_button_will_be_visible_click_on_it() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modal-footer'])[1]/input[1]")))
				.click();
		Thread.sleep(3000); // kept for Robot
	}

	@And("it will again redirect to the patient profile")
	public void it_will_again_redirect_to_the_patient_profile() {
		driver.close();
	}

	@And("deleting the existing same number family member")
	public void deleting_the_existing_same_number_family_member() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdp admin role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("frst_nm"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("7667676769");

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting clinic manager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
	}

	@And("click on the add patient icon to register a new patient")
	public void click_on_the_add_patient_icon_to_register_a_new_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
	}

	@Then("select the title of the patient to register new patient")
	public void select_the_title_of_the_patient_to_register_new_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the title
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
	}

	@When("registration form is opened to register a new patient then enter the following details")
	public void registration_form_is_opened_to_register_a_new_patient_then_enter_the_following_details(
			io.cucumber.datatable.DataTable dataTable) {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]")))
				.sendKeys(regData.get(7).get(1));
		// district
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys(regData.get(8).get(1));
		// pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys(regData.get(9).get(1));
	}

	@Then("select the required radio buttons to register")
	public void select_the_required_radio_buttons_to_register() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000); // kept for Robot physical actions

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys("767676");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000); // kept for Robot physical actions

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
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000); // kept for Robot
	}

	@And("click submit button_to_register the patient of whom entered details in registration form")
	public void click_submit_button_to_register_the_patient_of_whom_entered_details_in_registration_form()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000); // kept for Robot
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
	}

	@Then("deleting the existing family member using search")
	public void deleting_the_existing_family_member_using_search() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdp admin role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("frst_nm"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("3334445558");

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting clinic manager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
	}

	@And("clicking on the add patient to add family member using existing phone number")
	public void clicking_on_the_add_patient_to_add_family_member_using_existing_phone_number() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
	}

	@Then("enter the already existing number in mobile number filed")
	public void enter_the_already_existing_number_in_mobile_number_filed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// phone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nmbr"))).sendKeys("7667676769");
		// email
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).click();
	}

	@When("existing number entered popup will be shown")
	public void existing_number_entered_popup_will_be_shown() throws Exception {
	}

	@And("from the popup select the family member radio button")
	public void from_the_popup_select_the_family_member_radio_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Family Member'])[1]"))).click();
	}

	@Then("add family member popup will be shown")
	public void add_family_member_popup_will_be_shown() {
	}

	@And("enter the family member first and last names")
	public void enter_the_family_member_first_and_last_names() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@name='patient_master[frst_nm]'])[2]")))
				.sendKeys("Family");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='patient_master[lst_nm]'])[2]")))
				.sendKeys("member");
	}

	@Then("select the sex of the family member")
	public void select_the_sex_of_the_family_member() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='F'])[2]"))).click();
	}

	@And("click on the DOB and select the age")
	public void click_on_the_dob_and_select_the_age() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='patient_master_dob'])[2]"))).click();
		// clicking on the year
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='selects-container'])[1]/div[2]/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/span[text()='1985'])[2]"))).click();
		// clicking on the month
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='selects-container'])[1]/div[1]/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/span[text()='April'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='13'])[1]"))).click();
		// phone number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@ID='nmbr'])[2]")))
				.sendKeys("3334445558");
	}

	@Then("select relation from the dropdown")
	public void select_relation_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the relation
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[12]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Mother']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='email'])[2]")))
				.sendKeys(Keys.PAGE_DOWN);
	}

	@And("select the home checkbox for family member")
	public void select_the_home_checkbox_for_family_member() throws Exception {

	}

	@Then("click on the submit button to add family member")
	public void click_on_the_submit_button_to_add_family_member() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[3]"))).click();
	}

	@When("family member is added then it will shown under the family member section")
	public void family_member_is_added_then_it_will_shown_under_the_family_member_section() {
	}

	@Then("click on the added family member name")
	public void click_on_the_added_family_member_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='patient_card'])[1]/div[1]/a[1]")))
				.click();
		driver.close();
	}

	@And("click on the add patient icon in the top of the page")
	public void click_on_the_add_patient_icon_in_the_top_of_the_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting clinic manager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
	}

	@Then("enter the existing phone number to select the self")
	public void enter_the_existing_phone_number_to_select_the_self() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// phone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nmbr"))).sendKeys("7667676769");
		// email
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).click();
	}

	@When("existing phone number entered then popup opens")
	public void existing_phone_number_entered_then_popup_opens() {
	}

	@Then("select the self radio button from the popup")
	public void select_the_self_radio_button_from_the_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Self'])[2]"))).click();
	}

	@And("it will open the patient profile for that existing mobile number")
	public void it_will_open_the_patient_profile_for_that_existing_mobile_number() {
		driver.close();
	}

	@Then("search a existing patient and copy the patient id")
	public void search_a_existing_patient_and_copy_the_patient_id() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting clinic manager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("frst_nm"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("Demomrfam");
		Thread.sleep(2000); // kept for Robot
		// clicking on the patient name
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col.s7.btn-loader.opt_search"))).click();
		Thread.sleep(2000); // kept for Robot
		Actions action = new Actions(driver);
		WebElement copyIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='Copy to Clipboard'])[1]")));
		action.click(copyIcon).perform();
		Thread.sleep(3000); // kept for Robot
		// closing the popup
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='pt_qr_modal'])[1]/div[1]/div[1]/span/i[1]"))).click();
		Thread.sleep(2000); // kept for Robot
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
		Thread.sleep(2000); // kept for Robot
	}

	@And("open registration page from the clinic manager role")
	public void open_registration_page_from_the_clinic_manager_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[1]/div/div[2]/input")))
				.click();
		Thread.sleep(1000); // kept for Robot
		Robot v = new Robot();
		v.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // kept for Robot
		v.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000); // kept for Robot
		v.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000); // kept for Robot
		v.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // kept for Robot
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[1]/div/div[2]/input"))).sendKeys(Keys.TAB);
		Thread.sleep(2000); // kept for Robot
	}

	@Then("paste the reg id in the registration id field")
	public void paste_the_reg_id_in_the_registration_id_field() {

	}

	@And("check the validation for existing patient reg id")
	public void check_the_validation_for_existing_patient_reg_id() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement err = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='form_err reqErrAlertRGST'])[1]")));
		String dupregid = err.getText();
		Thread.sleep(2000); // kept for Robot
		System.out.println("Validation:" + dupregid);
		// driver.close();
	}

	@Then("searching with invoice number and click on the invoice id")
	public void searching_with_invoice_number_and_click_on_the_invoice_id() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='material-icons right search_fun'])[1]")))
				.click();
		Thread.sleep(2000); // waiting for search box to be visible
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='search_link inv_srch'])[1]")))
				.click();
		Thread.sleep(2000); // waiting for invoice page to be opened
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='invoice'])[1]")))
				.sendKeys("OP-");
		Thread.sleep(2000); // waiting for search results
		Actions action = new Actions(driver);
		WebElement uploadDropdown = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='upld_dropdown'])[1]/a[1]")));
		action.moveToElement(uploadDropdown).build().perform();
		Thread.sleep(2000); // waiting for dropdown to be visible
		action.moveToElement(wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='upld_dropdown'])[1]/a[1]"))))
				.click().build().perform();
		Thread.sleep(5000); // waiting for download to complete
		driver.close();
	}

}
