package ClinicManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Patientprofileicons {
	WebDriver driver = null;

	@Given("navigate to the nanohealth web application portal {string}")
	public void launchBrowser(String url) throws Exception {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("login with the details")
	public void login_with_the_details(io.cucumber.datatable.DataTable dataTable) throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(regData.get(0).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password")))
				.sendKeys(regData.get(1).get(1));
		Thread.sleep(5000);
	}

	@And("clicking on the signin button")
	public void clicking_on_the_signin_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(5000);
	}

	@Then("select the profile with facility type")
	public void select_the_profile_with_facility_type() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
//				.click();
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_SUBTRACT);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_SUBTRACT);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
	}

	@And("deleting the existing patient using search bar")
	public void deleting_the_existing_patient_using_search_bar() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("5656767699");
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col.s7.btn-loader.opt_search"))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='View Profile'])[1]"))).click();
//
//		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
//				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
//			wait.until(
//					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
//					.click();
//			wait.until(ExpectedConditions
//					.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i"))).click();
//		} else {
//			wait.until(
//					ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")))
//					.click();
//		}
//
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")))
//				.click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])/img[1]"))).click();
	}

	@Then("patient deleted successfully")
	public void patient_deleted_successfully() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
	}

	@And("click on the add patient icon for new registration of patient")
	public void click_on_the_add_patient_icon_for_new_registration_of_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))).click();
	}

	@Then("select title of the patient")
	public void select_title_of_the_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("user enter the following details into the registration form")
	public void user_enter_the_following_details_into_the_registration_form(io.cucumber.datatable.DataTable dataTable) {
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
	}

	@Then("selecting radio_buttons for new registration")
	public void selecting_radio_buttons_for_new_registration() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys("test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys("500035");
		Thread.sleep(1000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
	}

	@And("click on the submit to register patient")
	public void click_on_the_submit_to_register_patient() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
	}

	@Then("it will redirect to patient profile")
	public void it_will_redirect_to_patient_profile() {
	}

	@When("patient profile is opened")
	public void patient_profile_is_opened() {
	}

	@Then("click on the pencil icon to the edit details")
	public void click_on_the_pencil_icon_to_the_edit_details() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Edit Profile'])[1]"))).click();
	}

	@And("select the programme name from dropdown")
	public void select_the_programme_name_from_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Self'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button to save changes")
	public void click_on_the_submit_button_to_save_changes() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#update_submit"))).click();
	}

	@Then("click on the Home icon from the left side beside patient profile image")
	public void click_on_the_home_icon_from_the_left_side_beside_patient_profile_image() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Address'])[1]/img[1]")))
				.click();
	}

	@And("click on the add new address")
	public void click_on_the_add_new_address() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-tooltip='Add New Address']/i[1]")))
				.click();
	}

	@Then("enter the following details under new address1")
	public void enter_the_following_details_under_new_address1(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_detail_address_line1")))
				.sendKeys(regData.get(0).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_detail_address_line2")))
				.sendKeys(regData.get(1).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_detail_area")))
				.sendKeys(regData.get(2).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_detail_landmark")))
				.sendKeys(regData.get(3).get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dist_nm"))).sendKeys(regData.get(4).get(1));
	}

	@And("selecting city from the dropdown for new address")
	public void selecting_city_from_the_dropdown_for_new_address() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Hyderabad'][1]"))).click();
	}

	@Then("entering the pincode")
	public void entering_the_pincode() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement brandInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_detail_pin_code")));
		String text = "500034";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(100);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'5000')])[1]"))).click();
	}

	@When("user click on the save button for new address")
	public void user_click_on_the_save_button_for_new_address() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Address'])[1]/img[1]")))
				.click();
	}

	@Then("it will redirect to the addresses page popup")
	public void it_will_redirect_to_the_addresses_page_popup() {
	}

	@Then("updating the pincode for the new address")
	public void updating_the_pincode_for_the_new_address() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Address'])[1]/img[1]")))
				.click();
	}

	@And("clicking on the save button for new address in edit address page")
	public void clicking_on_the_save_button_for_new_address_in_edit_address_page() {
	}

	@And("deleting the already existing address")
	public void deleting_the_already_existing_address() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		if (driver.findElements(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).size() > 0
				&& driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-trash-o'])[2]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm!']"))).click();
		}
	}

	@Then("closing the addresses popup")
	public void closing_the_addresses_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//div[@id='modalAddressList'])[1]/div[1]/div[1]/span[1]/i[1]")))
					.click();
		} catch (Exception e) {
		}
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	@Then("click on the contact icon beside of home icon")
	public void click_on_the_contact_icon_beside_of_home_icon() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Contact'])[1]/img[1]"))).click();Thread.sleep(1000);
	}

	@Then("contact popup will open")
	public void contact_popup_will_open() {
	}

	@Then("click on the add new contact")
	public void click_on_the_add_new_contact() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-tooltip='Add New Contact']"))).click();Thread.sleep(1000);
	}

	@Then("enter the following details under new contact1")
	public void enter_the_following_details_under_new_contact1(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
//		List<List<String>> regData = dataTable.asLists(String.class);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#autocomplete-input"))).sendKeys(regData.get(0).get(1));Thread.sleep(1000);
	}

	@Then("select the country code for new contact from dropdown")
	public void select_the_country_code_for_new_contact_from_dropdown() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='+91']"))).click();Thread.sleep(1000);
	}

	@Then("enter the following details under new contact2")
	public void enter_the_following_details_under_new_contact2(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
//		List<List<String>> regData = dataTable.asLists(String.class);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_nmbr'])[1]"))).sendKeys(regData.get(0).get(1));Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='contact_detail_email'])[1]"))).sendKeys(regData.get(1).get(1));Thread.sleep(1000);
	}

	@Then("click on the save button for new contact")
	public void click_on_the_save_button_for_new_contact() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save'][1]"))).click();Thread.sleep(1000);
//		driver.navigate().refresh();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Contact'])[1]/img[1]"))).click();Thread.sleep(1000);
	}

	@And("updating the contact by clicking edit")
	public void updating_the_contact_by_clicking_edit() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#saved-contact>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>a>i"))).click();Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_nmbr'])[1]"))).clear();Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_nmbr'])[1]"))).sendKeys("96543345671");Thread.sleep(1000);
	}

	@Then("saving it")
	public void saving_it() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save'][1]"))).click();Thread.sleep(1000);
	}

	@Then("closing the contact popup")
	public void closing_the_contact_popup() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='modal_contact_list'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();Thread.sleep(1000);
//		driver.navigate().refresh();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Contact'])[1]/img[1]"))).click();Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='modal_contact_list'])[1]/div[1]/div[1]/a[1]/i[1]"))).click();Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='autocomplete-input'])[1]"))).sendKeys("Mobile");Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='+91']"))).click();Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_nmbr'])[1]"))).sendKeys("879009850");Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save'][1]"))).click();Thread.sleep(1000);
//		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();Thread.sleep(1000);
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'+')])[1]"))).click();Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_nmbr'])[1]"))).sendKeys("8790098500000");Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save'][1]"))).click();Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_nmbr'])[1]"))).sendKeys("8790089023");Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save'][1]"))).click();Thread.sleep(1000);
//		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='modal_contact_list'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();Thread.sleep(1000);
//		driver.navigate().refresh();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Contact'])[1]/img[1]"))).click();Thread.sleep(1000);
//		if (driver.findElements(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).size() > 0 && driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).isDisplayed()) {
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-trash-o'])[2]"))).click();Thread.sleep(1000);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm!']"))).click();Thread.sleep(1000);
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='modal_contact_list'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();Thread.sleep(1000);
//		driver.navigate().refresh();Thread.sleep(1000);
	}

	@And("click on the add identification icon")
	public void click_on_the_add_identification_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Identification Details'])[1]/img[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the qr code")
	public void clicking_on_the_qr_code() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-tooltip='Print']/img[1]"))).click();
	}

	@And("adding one identification aadhar no")
	public void adding_one_identification_aadhar_no() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[text()='Identification Type'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Aadhar card'])[1]"))).click();
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Parameter value'])[1]/following-sibling::input[1]")))
				.sendKeys("987788990022");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='patient_parameter_detail_file_location'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Aadhaar.png");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='btn right green'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("closing the identification popup")
	public void closing_the_identification_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='modal_identification_list'])[1]/div/div[1]/span/i[1]")))
				.click();
		Thread.sleep(3000);
	}

	@Then("adding another mr number identification")
	public void adding_another_mr_number_identification() throws Exception {
	}

	@And("deleting one identification of the patient")
	public void deleting_one_identification_of_the_patient() throws Exception {
	}

	@Then("click on the files icon")
	public void click_on_the_files_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Files'])[1]/img[1]"))).click();
	}

	@And("entering the label name")
	public void entering_the_label_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("label_name"))).sendKeys("Demo test label");
		Thread.sleep(1000);
	}

	@Then("clicking on the upload icon")
	public void clicking_on_the_upload_icon() throws Exception {
		driver.findElement(By.id("custom_img_url_"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Prescription.pdf");
		Thread.sleep(1000);
	}

	@And("sending the file")
	public void sending_the_file() {
	}

	@Then("click on the submit button from files popup")
	public void click_on_the_submit_button_from_files_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.modal-action.btn.green.right")))
				.click();
	}

	@When("file uploaded")
	public void file_uploaded() {
	}

	@Then("clicking on the uploaded pdf")
	public void clicking_on_the_uploaded_pdf() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='responsive-img photo'])[1]")))
				.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@And("closing the file popup")
	public void closing_the_file_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement close = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='modal_files_list'])[1]/div[1]/div[1]/span/i[1]")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", close);
		Thread.sleep(3000);
	}

	@Then("clicking on the add referral icon")
	public void clicking_on_the_add_referral_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Referral'])[1]/img[1]"))))
				.click().build().perform();
		Thread.sleep(2000);
	}

	@And("selecting the referral type as TV")
	public void selecting_the_referral_type_as_TV() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='TV'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the submit in referral popup")
	public void clicking_on_the_submit_in_referral_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn.right.green.btn-loader.on_submit")))
				.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	@When("referral is added")
	public void referral_is_added() {
	}

	@Then("mouse hovering to the add referral")
	public void mouse_hovering_to_the_add_referral() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action1 = new Actions(driver);
		action1.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[5]/a[1]/img[1]")))).build()
				.perform();
		Thread.sleep(1000);
	}

	@And("mouse hovering to the program icon")
	public void mouse_hovering_to_the_program_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[6]/a[1]/img[1]")))).build()
				.perform();
		Thread.sleep(1000);
	}

	@Then("click on the share credentials icon")
	public void click_on_the_share_credentials_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Share Credentials'])[1]/img[1]")))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Credentials'])[1]/img[1]")))
				.click();
		Thread.sleep(1000);

		WebElement createpswd = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Create Password'])[1]")));
		Thread.sleep(1000);
		createpswd.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Share'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#user_password")))
				.sendKeys("Demo@123");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Share'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the insurance button")
	public void clicking_on_the_insurance_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Insurer'])[1]/img[1]")))
				.click();
		Thread.sleep(1000);
	}

	@And("click on the plus button in insurance popup")
	public void click_on_the_plus_button_in_insurance_popup() throws Exception {
	}

	@When("new insurance popup opens")
	public void new_insurance_popup_opens() {
	}

	@And("select the insurance radio button from the new insurer popup")
	public void select_the_insurance_radio_button_from_the_new_insurer_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement insurnace = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Insurance'])[1]")));
		Thread.sleep(1000);
		insurnace.click();
		Thread.sleep(1000);
	}

	@Then("enter the following in the insurance popup")
	public void enter_the_following_in_the_insurance_popup(io.cucumber.datatable.DataTable dataTable) throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#insurance_policy_detail_id_card:nth-of-type(1)")))
				.sendKeys(regData.get(0).get(1));
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#insurance_policy_detail_policy_no:nth-of-type(1)")))
				.sendKeys(regData.get(1).get(1));
		Thread.sleep(1000);
	}

	@And("select the policy start and end dates")
	public void select_the_policy_start_and_end_dates() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("insurance_policy_detail_policy_start_date"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='is-today']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[2]"))).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[text()='Bajaj Allianz General Insurance Co Ltd'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[3]"))).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@Then("clicking on the save button from insurance popup")
	public void clicking_on_the_save_button_from_insurance_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn.right.green.ins_submit"))).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@And("clicking on the edit and updating the policy no")
	public void clicking_on_the_edit_and_updating_the_policy_no() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Insurer'])[1]/img[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-pencil'])[3]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("insurance_policy_detail_policy_no"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("insurance_policy_detail_policy_no")))
				.sendKeys("123456789");
		Thread.sleep(1000);
	}

	@Then("saving the insurance with new policy no")
	public void saving_the_insurance_with_new_policy_no() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn.right.green.ins_submit"))).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	@And("adding new insurance")
	public void adding_new_insurance() throws Exception {
	}

	@Then("deleting the newly added insurance")
	public void deleting_the_newly_added_insurance() throws Exception {
	}

	@And("closing the insurance popup")
	public void closing_the_insurance_popup() throws Exception {
	}

	@Then("click on the reviews icon")
	public void click_on_the_reviews_icon() throws Exception {
	}

	@And("clicking on the plus button in the review popup")
	public void clicking_on_the_plus_button_in_the_review_popup() throws Exception {
	}

	@Then("giving the ratings and entering the comments")
	public void giving_the_ratings_and_entering_the_comments() throws Exception {
	}

	@And("clicking on the submit from the add review popup")
	public void clicking_on_the_submit_from_the_add_review_popup() throws Exception {
	}

	@Then("adding another review and submitting")
	public void adding_another_review_and_submitting() throws Exception {
	}

	@And("editing the comments and deleting one review")
	public void editing_the_comments_and_deleting_one_review() throws Exception {
	}

	@Then("closing the review popup")
	public void closing_the_review_popup() throws Exception {
	}

	@And("clicking on the careteam icon")
	public void clicking_on_the_careteam_icon() throws Exception {
	}

	@Then("clicking on the plus button in the careteam popup")
	public void clicking_on_the_plus_button_in_the_careteam_popup() {
	}

	@And("selecting provider type and name")
	public void selecting_provider_type_and_name() throws Exception {
	}

	@Then("assigning another and deleting it")
	public void assigning_another_and_deleting_it() throws Exception {
	}

	@Then("clicking on the submit button")
	public void clicking_on_the_submit_button() throws Exception {
	}

	@And("click on the Add Allergies from the patient profile")
	public void click_on_the_add_allergies_from_the_patient_profile() throws Exception {
	}

	@Then("add allergies popup will be opened click on the add button to add")
	public void add_allergies_popup_will_be_opened_click_on_the_add_button_to_add() throws Exception {
	}

	@And("select the allergie type and enter the text for allergie")
	public void select_the_allergie_type_and_enter_the_text_for_allergie() throws Exception {
	}

	@Then("click on add button again to add new allergie")
	public void click_on_add_button_again_to_add_new_allergie() throws Exception {
	}

	@And("select the type of allergie and enter the allergie text")
	public void select_the_type_of_allergie_and_enter_the_allergie_text() throws Exception {
	}

	@Then("click on the submit button to save the allergies")
	public void click_on_the_submit_button_to_save_the_allergies() throws Exception {
	}

	@And("mouse hover on the Add Allergies to show the added allergies and click on any one allergie")
	public void mouse_hover_on_the_add_allergies_to_show_the_added_allergies_and_click_on_any_one_allergie()
			throws Exception {
	}

	@Then("allergies will be opened remove one allergie and submit again")
	public void allergies_will_be_opened_remove_one_allergie_and_submit_again() throws Exception {
	}

	@And("mouse hover on the add allergies again to show the updated")
	public void mouse_hover_on_the_add_allergies_again_to_show_the_updated() throws InterruptedException {
	}

	@Then("book doctor,dietitian,lab appointments for the patient")
	public void book_doctor_dietitian_lab_appointments_for_the_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions doc = new Actions(driver);
		doc.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]")))).build()
				.perform();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")))
				.click();
		Thread.sleep(2000);
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
		element.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]/div[1]/div[1]/div[1]")))
				.click();
		Thread.sleep(2000);
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		boolean selected = false;
		Thread.sleep(2000);
		List<WebElement> am = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));

		for (WebElement slot : am) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				js11.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
				Thread.sleep(300);
				js11.executeScript("arguments[0].click();", slot);
				selected = true;
				break;
			}
		}
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		element.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#advance_field")))
				.sendKeys("100");
		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
		element.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#payment_cmnt")))
				.sendKeys("100 rupees paid");
		element.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@class='modal-close btn green right payCmntOk'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Demo Icons'])[2]"))))
				.build().perform();
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Book New Appointment'])[1]/img[1]")))).build()
				.perform();
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Book Dietitian Appointment'])[1]/img[1]"))))
				.build().perform();
		action.moveToElement(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Book Dietitian Appointment'])[1]/img[1]")))).click()
				.build().perform();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]")))
				.click();
		Thread.sleep(3000);
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		boolean selected1 = false;
		List<WebElement> am1 = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));
		Thread.sleep(2000);
		for (WebElement slot : am1) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				js111.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
				Thread.sleep(300);
				js111.executeScript("arguments[0].click();", slot);
				selected1 = true;
				break;
			}
		}
		Thread.sleep(1000);
		if (!selected1) {
			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));
			for (WebElement slot : pm) {
				if (slot.isDisplayed() && slot.isEnabled()) {
					js111.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
					Thread.sleep(300);
					js111.executeScript("arguments[0].click();", slot);
					break;
				}
			}
		}
		Thread.sleep(2000);

		WebElement gmail1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Email'])[1]")));
		gmail1.click();
		Thread.sleep(1000);
		WebElement sms1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='SMS'])[1]")));
		sms1.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bookNowBtn"))).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		WebElement paylater = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Pay Later'])[1]")));
		paylater.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#bookLater"))).click();
		Thread.sleep(1000);
		action.moveToElement(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Demo Icons'])[2]"))))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Book New Appointment'])[1]/img[1]")))).build()
				.perform();
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]"))))
				.build().perform();
		action.moveToElement(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")))).click()
				.build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.selection"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/i[text()='add'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/i[text()='add'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/i[text()='add'])[1]"))).click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/i[text()='remove'])[5]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn-loader.btn.checkout.btn-block")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
		Thread.sleep(1000);

		JavascriptExecutor js1111 = (JavascriptExecutor) driver;
		boolean selected11 = false;
		Thread.sleep(1000);

		List<WebElement> am111 = driver.findElements(By.xpath("//span[contains(text(),'AM')]"));
		Thread.sleep(2000);
		for (WebElement slot : am111) {
			if (slot.isDisplayed() && slot.isEnabled()) {
				js1111.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
				Thread.sleep(300);
				js1111.executeScript("arguments[0].click();", slot);
				selected11 = true;
				break;
			}
		}
		Thread.sleep(1000);
		if (!selected11) {
			List<WebElement> pm = driver.findElements(By.xpath("//span[contains(text(),'PM')]"));
			for (WebElement slot : pm) {
				if (slot.isDisplayed() && slot.isEnabled()) {
					js1111.executeScript("arguments[0].scrollIntoView({block:'center'});", slot);
					Thread.sleep(300);
					js1111.executeScript("arguments[0].click();", slot);
					break;
				}
			}
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='delivery_charges'])[1]")))
				.sendKeys("50");
		WebElement cbox1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Email'])[1]")));
		cbox1.click();
		WebElement cbox2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='SMS'])[1]")));
		cbox2.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-loader"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		WebElement paylater1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Pay Later'])[1]")));
		paylater1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#bookLater"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]"))).click();
		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
		}
		Thread.sleep(1000);
	}

	@When("appointments where booked click on notes and add")
	public void appointments_where_booked_click_on_notes_and_add() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='options'])[2]/div/div/a[2]/img")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).sendKeys("Test message");
		Thread.sleep(1000);
		driver.findElement(By.id("files_constr"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Dischargesummary.pdf");
		Thread.sleep(1000);

		for (int i = 0; i <= 2; i++) {
			WebElement doctor = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Doctor']")));
			doctor.click();
		}
		for (int i = 0; i <= 2; i++) {
			WebElement dietitcian = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Dietitian']")));
			dietitcian.click();
		}
		for (int i = 0; i <= 2; i++) {
			WebElement patient = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Patient']")));
			Thread.sleep(2000);
			patient.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save']"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@id='doctor_notes_new_modal'])[1]/div/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("copy the patient id for merge")
	public void copy_the_patient_id_for_merge() throws Exception {
	}

	@And("register a new patient and click on the merge patient button and paste the copied patient id")
	public void register_a_new_patient_and_click_on_the_merge_patient_button_and_paste_the_copied_patient_id()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement patientIdElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("clinic_patient_profile")));
		String patientId = patientIdElement.getText().trim();
		System.out.println("Copied Patient ID: " + patientId);

		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Mr.')])[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("Cucum");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst_name"))).sendKeys("Mergepatient");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys("55");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nmbr"))).sendKeys("5656767699");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-line1"))).sendKeys("test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete-input"))).sendKeys("test");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("landmark"))).sendKeys("testlandmark");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='city'])[1]")))
				.sendKeys("Test city");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys("Test district");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();

		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys("676767");

		Robot test = new Robot();
		test.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add Referral'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[3]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.cls.btn.green.right.referral_submit")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Updates'])[1]/img[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Merge Account'])[1]")))
				.click();
		Thread.sleep(1000);

		WebElement input = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='register_patient_data'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
		Thread.sleep(1000);
		input.sendKeys(patientId);
		Thread.sleep(1000);
		System.out.println("Patient ID pasted successfully.");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Then("after merging old patient data records will be applied to the new patient")
	public void after_merging_old_patient_data_records_will_be_applied_to_new_patient() throws Exception {
	}

	@And("clicking on the patient engagement icon")
	public void clicking_on_the_patient_engagement_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
		} else {
			Actions action = new Actions(driver);
			action.moveToElement(wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Patient Engagement'])[1]/img[1]"))))
					.build().perform();
		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Patient Engagement'])[1]/img[1]"))).click();
	}

	@When("patient engagemnet popup opens")
	public void patient_engagemnet_popup_opens() {
	}

	@Then("select the engagement method from the dropdown")
	public void select_the_engagement_method_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Phone']"))).click();
	}

	@And("select the date for engagement as today")
	public void select_the_date_for_engagement_as_today() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("patient_engagement_detail_engagement_date"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='is-today']"))).click();
	}

	@Then("select the time for engagement")
	public void select_the_time_for_engagement() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("patient_engagement_detail_engagement_time"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Ok'])[2]"))).click();
	}

	@And("enter the sms text in the sms field")
	public void enter_the_sms_text_in_the_sms_field() {
	}

	@Then("click on the send icon beside of the sms field")
	public void click_on_the_send_icon_beside_of_the_sms_field() throws Exception {
	}

	@When("send icon is clicked it will sent sms successfully")
	public void send_icon_is_clicked_it_will_sent_sms_successfully() {
	}

	@And("select the status from the dropdown")
	public void select_the_status_from_the_dropdown() throws Exception {
	}

	@Then("enter the engagement description")
	public void enter_the_engagement_description() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient_engagement_detail_notes")))
				.sendKeys("Test is pending...");
	}

	@Then("click on the submit button in the engagement popup")
	public void click_on_the_submit_button_in_the_engagement_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input#patient_engagement_detail_prfrd_followup_date"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input#patient_engagement_detail_prfrd_followup_time"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[@class='btn-flat timepicker-close waves-effect'])[4]")))
				.click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Preferred Method'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Phone'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("engmtSubmitBtn"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);
	}

	@When("history updated")
	public void history_updated() {
	}

	@Then("close the engagement popup")
	public void close_the_engagement_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#patient-engagement-modal-closeBtn>i")))
				.click();
		driver.navigate().refresh();
		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
		}
	}

	@Then("mouse hover to upload reports and click on the upload doctor visit")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_doctor_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Upload Medical Documents'])[1]/img[1]"))))
				.build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Doctor Visit'])[1]"))).click();
	}

	@When("doctor visit popup opens from the upload reports")
	public void doctor_visit_popup_opens_from_the_upload_reports() {
	}

	@Then("enter the doctors first_last name")
	public void enter_the_doctors_first_last_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doctor_visit_dummy2"))).sendKeys("Doctor");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doctor_visit_referral_reason")))
				.sendKeys("One");
	}

	@And("select the hospital name for doctor visit upload")
	public void select_the_hospital_name_for_doctor_visit_upload() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement brandInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("doctor_visit_hospital_master_id")));
		String text = "Na";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(100);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).click();
	}

	@Then("uploading the visit report pdf for doctor visit upload")
	public void uploading_the_visit_report_pdf_for_doctor_visit_upload() throws Exception {
		driver.findElement(By.id("doctor_visit_prescription_img"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Prescription.pdf");
	}

	@And("selecting diagnosis for doctor visit")
	public void selecting_diagnosis_for_doctor_visit() throws Exception {
	}

	@And("entering the notes for doctor visit")
	public void entering_the_notes_for_doctor_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='doctor_visit_cmmts'])[1]")))
				.sendKeys("demo notes");
	}

	@Then("clicking on the submit button to save doctor visit upload")
	public void clicking_on_the_submit_button_to_save_doctor_visit_upload() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.modal-action.btn.green.right")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save Prescription'])[1]")))
				.click();
		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
		}
	}

	@And("mouse hover to upload reports and click on the upload dietician visit")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_dietician_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action2 = new Actions(driver);
		action2.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Upload Medical Documents'])[1]/img[1]"))))
				.build().perform();
		action2.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Upload Dietitian Visit'])[1]")))).click()
				.build().perform();
	}

	@When("dietician visit popup opens from the upload reports")
	public void dietician_visit_popup_opens_from_the_upload_reports() {
	}

	@Then("select the visit date for dietician upload visit")
	public void select_the_visit_date_for_dietician_upload_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("input#patient_prescription_header_visit_date")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='is-today']/button"))).click();
	}

	@And("enter the dietician first_last name")
	public void enter_the_dietician_first_last_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient_prescription_header_dummy2")))
				.sendKeys("Dietitian");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient_prescription_header_dummy1")))
				.sendKeys("One");
	}

	@Then("select the hospital name")
	public void select_the_hospital_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement brandInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("patient_prescription_header_form_hospital_name")));
		String text = "Na";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(100);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).click();
	}

	@And("uploading the visit report pdf")
	public void uploading_the_visit_report_pdf() throws Exception {
		driver.findElement(By.id("patient_prescription_header_prescription_img"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Prescription.pdf");
	}

	@Then("clicking on the submit button to save dietician visit upload")
	public void clicking_on_the_submit_button_to_save_dietician_visit_upload() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/main/div/div[2]/div[4]/div/div[2]/div/form/div[3]/span/input[1]"))).click();
	}

	@And("mouse hover to upload reports and click on the upload diagnostic visit")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_diagnostic_visit() throws Exception {
	}

	@When("diagnostic visit popup opens from the upload reports")
	public void diagnostic_visit_popup_opens_from_the_upload_reports() {
	}

	@Then("select the visit date for diagnostic upload visit")
	public void select_the_visit_date_for_diagnostic_upload_visit() throws Exception {
	}

	@And("enter the lab name for diagnostic upload visit")
	public void enter_the_lab_name_for_diagnostic_upload_visit() throws Exception {
	}

	@Then("upload the diagnostic report pdf")
	public void upload_the_diagnostic_report_pdf() throws Exception {
	}

	@And("clicking on the submit button to save diagnostic visit upload")
	public void clicking_on_the_submit_button_to_save_diagnostic_visit_upload() throws Exception {
	}

	@And("mouse hover to upload reports and click on the upload discharge summary")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_discharge_summary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action3 = new Actions(driver);
		action3.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Upload Medical Documents'])[1]/img[1]"))))
				.build().perform();
		action3.moveToElement(wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-tooltip='Upload Discharge Summary']"))))
				.click().build().perform();
	}

	@When("discharge summary  popup opens from the upload reports")
	public void discharge_summary_popup_opens_from_the_upload_reports() {
	}

	@Then("select the visit date for discharge summary")
	public void select_the_visit_date_for_discharge_summary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_visit_date"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='is-today']/button"))).click();
	}

	@And("clicking on the submit button to save discharge summary")
	public void clicking_on_the_submit_button_to_save_discharge_summary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#doctor_visit_dummy2")))
				.sendKeys("Doctor");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#doctor_visit_referral_reason")))
				.sendKeys("One");

		WebElement brandInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#doctor_visit_hospital_master_id")));
		String text = "Na";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(100);
		}

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input#doctor_visit_prescription_img"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Dischargesummary.pdf");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='modal-action btn green right'])[1]"))).click();

		if (driver.findElements(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).size() > 0
				&& driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).isDisplayed()) {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")))
					.click();
		}
	}

	@Then("click on the discharge summary")
	public void click_on_the_discharge_summary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#patientHistoryBtn"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='row']/span[text()='Discharge Summary'][1]"))).click();
	}

	@And("click on print pdf for discharge summary")
	public void click_on_print_pdf_for_discharge_summary() throws AWTException, Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='row']/span[text()='Discharge Summary']//following-sibling::span/a/img")))
				.click();
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot2.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("ds pdf will open on new tab get back to the parent window")
	public void ds_pdf_will_open_on_new_tab_get_back_to_the_parent_window() {
	}

	@And("click on another pdf for discharge summary")
	public void click_on_another_pdf_for_discharge_summary() {
	}

	@Then("clicking on the dischare summary to close row")
	public void clicking_on_the_dischare_summary_to_close_row() throws Exception {
	}

	@When("row closed for dischare summary")
	public void row_closed_for_dischare_summary() {
	}

	@Then("click on the dietician visit")
	public void click_on_the_dietician_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row']/span[text()='Dietitian Visit']")))
				.click();
	}

	@And("click on print with header and footer for dietician visit")
	public void click_on_print_with_header_and_footer_for_dietician_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[2]"))).click();
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot3.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("pdf will open on new tab get back to the parent window for dietician visit")
	public void pdf_will_open_on_new_tab_get_back_to_the_parent_window_for_dietician_visit() {
	}

	@And("click on print pdf for dietician visit")
	public void click_on_print_pdf_for_dietician_visit() {
	}

	@Then("share invoice to gmail clearing mobile number for for dietician visit")
	public void share_invoice_to_gmail_clearing_mobile_number_for_for_dietician_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Prescription'])[2]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails")))
				.sendKeys("sunil.kommayella@nanohealth.in");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/main/div/div[2]/div[26]/div/div[2]/form/div[2]/input")))
				.click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		for (int i = 0; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_UP);
		}
		Thread.sleep(1000);
	}

	@When("invoice shared again clicking on dietician visit to close")
	public void invoice_shared_again_clicking_on_dietician_visit_to_close() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row']/span[text()='Dietitian Visit']")))
				.click();
	}

	@Then("clicking on the diagnostic report")
	public void clicking_on_the_diagnostic_report() throws Exception {
	}

	@And("click on print pdf for diagnostic report")
	public void click_on_print_pdf_for_diagnostic_report() throws Exception {
	}

	@Then("diagnostic report pdf will open on new tab get back to the parent window")
	public void diagnostic_report_pdf_will_open_on_new_tab_get_back_to_the_parent_window() {
	}

	@And("click on another pdf for diagnostic report")
	public void click_on_another_pdf_for_diagnostic_report() {
	}

	@Then("clicking on the diagnostic report to close row")
	public void clicking_on_the_diagnostic_report_to_close_row() throws Exception {
	}

	@When("row closed for diagnostic report")
	public void row_closed_for_diagnostic_report() {
	}

	@Then("click on the prescription")
	public void click_on_the_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row']/span[text()='Prescription']")))
				.click();
	}

	@And("click on print with header and footer for prescription")
	public void click_on_print_with_header_and_footer_for_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]"))).click();
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot4.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("pdf will open on new tab get back to the parent window for prescription")
	public void pdf_will_open_on_new_tab_get_back_to_the_parent_window_for_prescription() {
	}

	@And("click on print pdf for prescription")
	public void click_on_print_pdf_for_prescription() {
	}

	@Then("share invoice to gmail clearing mobile number for for prescription")
	public void share_invoice_to_gmail_clearing_mobile_number_for_for_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emails")))
				.sendKeys("sunil.kommayella@nanohealth.in");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/main/div/div[2]/div[26]/div/div[2]/form/div[2]/input")))
				.click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		for (int i = 0; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_UP);
		}
		Thread.sleep(1000);
	}

	@When("invoice shared again clicking on prescription to close")
	public void invoice_shared_again_clicking_on_prescription_to_close() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Prescription']"))).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
