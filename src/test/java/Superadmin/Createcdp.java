package Superadmin;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

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

public class Createcdp {
	WebDriver driver = null;

	@Given("naviagating to NHWebportal {string}")
//	public void naviagating_to_nh_webportal(String string) {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
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

	@When("login page was opened")
	public void login_page_was_opened() {
	}

	@Then("enter email15 {string} password15 {string}")
	public void enter_email15_password15(String email15, String password15) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(email15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password15);
		Thread.sleep(3000);
	}

	@And("click on the sign in button tologin")
	public void click_on_the_sign_in_button_tologin() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
	}

	@When("select cdp popup opens")
	public void select_cdp_popup_opens() {

	}

	@Then("select the cdp and role as superadmin")
	public void select_the_cdp_and_role_as_superadmin() throws Exception {
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
		WebElement cdp = driver.findElement(By.xpath(
				"//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'nanohealthplan')]"));
		cdp.click();
		Thread.sleep(3000);
//		// selecting Role clicking on Superadmin Role
//		driver.findElement(By.xpath("(//div[normalize-space(text())='SuperAdmin'])[1]")).click();
//		Thread.sleep(5000);
		WebElement role = driver.findElement(By.xpath(
				"//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'superadmin')]"));
		role.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@When("superadmin dashboard opens")
	public void superadmin_dashboard_opens() {
	}

	@Then("click on the plus button to create new cdp")
	public void click_on_the_plus_button_to_create_new_cdp() throws Exception {
		Actions add = new Actions(driver);
		add.moveToElement(driver.findElement(By.xpath("(//i[text()='add'])[1]"))).build().perform();
		Thread.sleep(2000);
		add.moveToElement(driver.findElement(By.xpath("(//i[text()='add'])[1]"))).click().build().perform();
		Thread.sleep(5000);
	}

	@Then("enter the cdp details and save to create new cdp")
	public void enter_the_cdp_details_and_save_to_create_new_cdp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the cdp type
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='CDP Type'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Hospitals'])[1]"))).click();
		Thread.sleep(1000);
		// entering cdpname
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#care_delivery_program_master_name"))).sendKeys("Cucum cdp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#autocomplete-input"))).sendKeys("Testing CDP");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#gst_no"))).sendKeys("GSTIN12345");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#btnClear"))).click();
		Thread.sleep(1000);
		// selecting the cdp type
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='CDP Type'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Hospitals'])[1]"))).click();
		Thread.sleep(1000);
		// entering cdpname
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#care_delivery_program_master_name"))).sendKeys("Cucum cdp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#autocomplete-input"))).sendKeys("Testing CDP");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
			active.click();
		}
		// entering the organization name
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#org_name"))).sendKeys("Cucumcdp");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#gst_no"))).sendKeys("GSTIN12345" + Keys.PAGE_DOWN);
		Thread.sleep(1000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 100)");
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_address_line1"))).sendKeys("Test addressline1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_address_line2"))).sendKeys("Test addressline2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_area"))).sendKeys("Test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_landmark"))).sendKeys("Test landamrk");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='City'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Hyderabad'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_pin_code"))).sendKeys("500035");
		Thread.sleep(1000);
//		js.executeScript("window.scrollBy(0, 100)");
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#contact_details_frst_nm"))).sendKeys("Cucumcdp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#contact_details_lst_nm"))).sendKeys("user");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#contact_details_nmbr"))).sendKeys("3456789012");
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);

	}

	@When("cdp is created it will be in the created status")
	public void cdp_is_created_it_will_be_in_the_created_status() throws Exception {
	}

	@Then("click on the home button and it will open dashboard")
	public void click_on_the_home_button_and_it_will_open_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#super_admin_dashboard"))))
				.click();
		Thread.sleep(3000);
	}

	@When("dashboard opens search created cdp using filters and click on the edit button")
	public void dashboard_opens_search_created_cdp_using_filters_and_click_on_the_edit_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Created'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("in edit cdp popup add details of enabled roles and services and upload headerfooterlogo")
	public void in_edit_cdp_popup_add_details_of_enabled_roles_and_services_and_upload_headerfooterlogo()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit CDP'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit CDP'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[normalize-space(text())='Enabled Roles'])[1]//preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='CDPAdmin'])[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[normalize-space(text())='Enabled Roles'])[1]//preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Clinic_Manager'])[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[normalize-space(text())='Enabled Roles'])[1]//preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Doctor'])[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[normalize-space(text())='Enabled Services'])[1]//preceding-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Doctor Consultation')])[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[normalize-space(text())='Enabled Services'])[1]//preceding-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Diet')])[1]"))).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//label[normalize-space(text())='Enabled Services'])[1]//preceding-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Diagnostic Lab')])[1]"))).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 100)");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#care_delivery_program_master_name"))).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		// uploading web logo
		driver.findElement(By.cssSelector("input#care_delivery_program_master_web_logo_url"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\nh_web_logo.png");
//		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// uploading app logo
		driver.findElement(By.cssSelector("input#care_delivery_program_master_app_logo_url"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\NH_app_logo.png");
//		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// uploading web bg
//		driver.findElement(By.cssSelector("input#care_delivery_program_master_hme_bgrnd_img")).sendKeys("");
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#gst_no"))).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);

	}

	@Then("click on the save button to save the changes of new cdp")
	public void click_on_the_save_button_to_save_the_changes_of_new_cdp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='CDP Name'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Cucum')])[1]"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Created'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit CDP'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit CDP'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		// removing the doctor role and dietitian service
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@title='Doctor'])[1]/span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Diet')])[1]/span[1]"))).click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("update the status of cdp created to active")
	public void update_the_status_of_cdp_created_to_active() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='CDP Name'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Cucum')])[1]"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Created'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Update CDP Status'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Update CDP Status'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Status'])[2]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Active'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Update'])[1]"))).click();
		Thread.sleep(3000);

	}

	@When("cdp is created take the subscription using subscription plan button")
	public void cdp_is_created_take_the_subscription_using_subscription_plan_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='CDP Name'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Cucum')])[1]"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Active'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Subscription Plan'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Subscription Plan'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);

	}

	@Then("enter and select the details for the subscription plan")
	public void enter_and_select_the_details_for_the_subscription_plan() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#submit-btn"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Item'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Chakra Subscription(Monthly)'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#chakra_subscription_plan_label_description")))
				.sendKeys("testing desc");
		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#btnClear"))).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Item'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Chakra Subscription(Monthly)'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#chakra_subscription_plan_label_description")))
				.sendKeys("testing desc");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Price type'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='One Time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Billing day'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='5th'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Monthly'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Due on receipt'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("click on save button for the subscription plan")
	public void click_on_save_button_for_the_subscription_plan() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#submit-btn"))).click();
		Thread.sleep(5000);
	}

	@And("click on the invoice button beside of edit button")
	public void click_on_the_invoice_button_beside_of_edit_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Invoice'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the submit button in popup
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='submit-btn'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("invoice will be created in draft status")
	public void invoice_will_be_created_in_draft_status() throws Exception {
		// code here
	}

	@Then("click on the print invoice button and click on the save button to save")
	public void click_on_the_print_invoice_button_and_click_on_the_save_button_to_save() throws Exception {
		Actions printinvoice = new Actions(driver);
		printinvoice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		printinvoice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);

	}

	@And("share the subscription invoice through email")
	public void share_the_subscription_invoice_through_email() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='phone'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000);
		// clicking on the home button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-home'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("edit the subscription invoice and save changes")
	public void edit_the_subscription_invoice_and_save_changes() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions edit = new Actions(driver);
		edit.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Subscription Plan'][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		edit.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Subscription Plan'][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		// clicking on the edit button in subscription popup
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#chakra_subscription_plan_price"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#chakra_subscription_plan_price"))).sendKeys("2000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Billing day'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='10th'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='subscription-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(3000);

//		driver.findElement(By.xpath("")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//input[@id='submit-btn'])[1]")).click();
//		Thread.sleep(3000);
//		// download invoice
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		// clicking on the home button
//		driver.findElement(By.xpath("(//i[@class='fa fa-home'])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("click on the cdpinvoices button")
	public void click_on_the_cdpinvoices_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='CDP Name'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Cucum')])[1]"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Active'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='CDP Invoices'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='CDP Invoices'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
	}

	@Then("click on the plus button to setup the cdp")
	public void click_on_the_plus_button_to_setup_the_cdp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add New Invoice'])[1]/i[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Item'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
	}

	@And("select the setup and fillthe details and submit the details")
	public void select_the_setup_and_fillthe_details_and_submit_the_details() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Setup'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#corp_sale_order_header_amount"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#corp_sale_order_header_amount"))).sendKeys("5000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#corp_sale_order_header_amount"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#corp_sale_order_header_amount"))).sendKeys("10000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='corp_sale_order_header_due_date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Payment Terms'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Due on receipt'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='comments'])[1]"))).sendKeys("testing description");
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='submit-btn'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the print invoice
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the save button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Save'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the print invoice
//				Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
//				Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the share invoice
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='phone'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000);
		// clicking on the back button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Back'])[1]"))).click();
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
		// clicking on the share invoice
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]"))).click();
		Thread.sleep(5000);
//		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='phone'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000);

		// filter-search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Draft'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_due_date_time_gteq'])[1]"))).click();
		Thread.sleep(1000);
		// Click on Year dropdown
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-wrapper select-year'])[1]/input[1]"))).click();
		Thread.sleep(1000);
		// Get current year
		LocalDate today = LocalDate.now();
		String currentYear = String.valueOf(today.getYear());
		// Select current year dynamically
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/span[text()='" + currentYear + "']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-wrapper select-month'])[1]/input[1]"))).click();
		Thread.sleep(1000);
		LocalDate today1 = LocalDate.now();
		String currentMonth = today1.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		Thread.sleep(1000);
		// Select current month dynamically
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/span[text()='" + currentMonth + "']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]/button[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_due_date_time_lteq'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]/button[1]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Pending'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);

	}

	@Then("click on the home button and click on cdp name to create hospital")
	public void click_on_the_home_button_and_click_on_cdp_name_to_create_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the home button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-home'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("click on the hospital button")
	public void click_on_the_hospital_button() throws Exception {
//		// clicking on the cdp name
//		driver.findElement(By.xpath("(//a[contains(text(),'Cucum')])[1]")).click();
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement nameField = driver.findElement(By.xpath(
				"//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cucum')]"));
		nameField.click();
		Thread.sleep(3000);
		// clicking on the hospital button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Hospitals'])[1]"))).click();
		Thread.sleep(3000);

		/*
		 * driver.findElement(By.xpath("(//a[contains(text(),'Hospitals')])[1]")).click(
		 * ); Thread.sleep(3000);
		 */
	}

	@Then("enter all the necessary details for creation of hospital")
	public void enter_all_the_necessary_details_for_creation_of_hospital() throws Exception {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Hospital'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Hospital'])[1]/i[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_hsptl_nm"))).sendKeys("Cucumcdp hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Facility Type Master'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='OP Only'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_rgstrton_no"))).sendKeys("1345677");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_rgstrton_yr"))).sendKeys("2025");
		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='btnClear'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_hsptl_nm"))).sendKeys("Cucumcdp hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Facility Type Master'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='OP Only'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_rgstrton_no"))).sendKeys("1234567890");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_rgstrton_yr"))).sendKeys("2022");
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement isdayclinic = driver.findElement(By.xpath("(//label[text()='is_day_clinic'])[1]"));
			isdayclinic.click();
//			Thread.sleep(1000);
		}
		for (int i = 0; i <= 1; i++) {
			WebElement isactive = driver.findElement(By.xpath("(//label[text()='is_active'])[1]"));
			isactive.click();
//			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			WebElement verify = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
			verify.click();
//			Thread.sleep(1000);
		}

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_address_line1"))).sendKeys("test line1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_address_line2"))).sendKeys("test line2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_landmark"))).sendKeys("test lndmrk");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='City'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Hyderabad'])[1]"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#address_details_pin_code"))).sendKeys("500035");
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#hospital_master_nmbr"))).sendKeys("8080818180");
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@When("hospital is created it will ask for doctor creation")
	public void hospital_is_created_it_will_ask_for_doctor_creation() {

	}

	@Then("enter the necessary details for doctor creation")
	public void enter_the_necessary_details_for_doctor_creation() throws Exception {
		// doctor details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_frst_nm"))).sendKeys("Cucumcdp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_lst_nm"))).sendKeys("doctor");
		Thread.sleep(1000);
		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#age"))).sendKeys("65");
		Thread.sleep(1000);
		WebElement smsngmail = driver.findElement(By.xpath("(//label[text()='SMS and Email'])[1]"));
		smsngmail.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='nmbr'])[1]"))).sendKeys("4848484848");
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Hospital/clinic'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Cucum')])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_qualification"))).sendKeys("1234567890");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_rgstrton_no"))).sendKeys("1234567890");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_rgstrton_no"))).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_rgstrton_yr"))).sendKeys("2022");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_hospital_doctors_time_sensivity"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_hospital_doctors_time_sensivity"))).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_hospital_doctors_days_in_advnce"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_hospital_doctors_days_in_advnce"))).sendKeys("30");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[text()='Specialisations'])/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='General Surgery'])[1]"))).click();
		Thread.sleep(1000);

		jse.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_master_hospital_doctors_effctv_dt"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);

	}

	@And("click on home button and click on admins button to create cdpadmin")
	public void click_on_home_button_and_click_on_admins_button_to_create_cdpadmin() throws Exception {
		// clicking on the home button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-home'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("create cdpadmin user from admins button")
	public void create_cdpadmin_user_from_admins_button() throws Exception {
		
		Actions admins = new Actions(driver);
		admins.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Admins'][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		admins.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Admins'][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);

		Actions admin = new Actions(driver);
		admin.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New CDP Admin'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(2000);
		admin.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New CDP Admin'])[1]/i[1]"))).click()
				.build().perform();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#lst_name"))).sendKeys("Cdpadmin");
		Thread.sleep(1000);
		WebElement male1 = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male1.click();
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).sendKeys(
		 * "4545454545"); Thread.sleep(1000);
		 */
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#age"))).sendKeys("55");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='nmbr'])[1]"))).sendKeys("4848484849" + Keys.TAB);
		Thread.sleep(2000);
		// continue
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[normalize-space(text())='Role'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'CDPAdmin')])[1]")).click();
//		Thread.sleep(2000);
		WebElement nameField = driver.findElement(By.xpath(
				"//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cdpadmin')]"));
		nameField.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
			fa.click();
//			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			WebElement md = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
			md.click();
//			Thread.sleep(1000);
		}

		for (int i = 0; i <= 2; i++) {
			WebElement ver = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
			ver.click();
//			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			WebElement ver = driver.findElement(By.xpath("(//label[text()='Health Access'])[1]"));
			ver.click();
//			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		// searching through filter
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#q_frst_nm_or_lst_nm_cont"))).sendKeys("Cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// edit cdpadmin
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='user_role_details_label_name'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='user_role_details_label_name'])[1]"))).sendKeys("CDPadmin");
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		// share credentials
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Credetiatls'])[1]"))).click();
		Thread.sleep(2000);
		// select create a password
		WebElement createpswd = driver.findElement(By.xpath("(//label[text()='Create Password'])[1]"));
		createpswd.click();
		Thread.sleep(1000);
		// entering test dummy password
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#user_password"))).sendKeys("Chakra@1");
		Thread.sleep(1000);
		// share
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Share'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the home button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-home'])[1]"))).click();
		Thread.sleep(3000);
//		// clicking on the cdp name
//		driver.findElement(By.xpath("(//a[contains(text(),'Cucum')])[1]")).click();
//		Thread.sleep(3000);
//		WebElement nameField = driver.findElement(By.xpath(
//				"//a[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cucum')]"));
//		nameField.click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[text()='Labs'])[1]")).click();
//		Thread.sleep(2000);
//		WebElement labs = driver.findElement(By.xpath(
//				"//a[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'add new lab')]"));
////				(//a[@data-tooltip='Add New Lab'])[1]/i[1]
//		labs.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@name='diagnostic_lab_master[lab_name]'])[1]")).sendKeys("Cucumcdp lab");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Hospital/Clinic'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Cucum')])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='diagnostic_lab_master_mobile'])[1]")).sendKeys("6303030030");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Address Line1'])[1]/following-sibling::input[1]"))
//				.sendKeys("add line1");
	}

	@And("change the status of cdp active to  cdpflagged and verify by user login")
	public void change_the_status_of_cdp_active_to_cdpflagged_and_verify_by_user_login() throws Exception {
		Actions xpath = new Actions(driver);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		// Actions status = new Actions(driver);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.click().build().perform();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='CDP Flagged'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Update'])[1]")).click();
		Thread.sleep(3000);

		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("4848484849");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
		// yes
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(5000);
		String cdpflagged = driver.findElement(By.xpath("(//div[@id='time_zone_modal'])[1]/div[1]/div[2]")).getText();
		System.out.println("Message we are showing when status is CDPFlagged:" + cdpflagged);
		Thread.sleep(5000);
		// ok
		driver.findElement(By.xpath("(//input[@value='Ok'])[1]")).click();
		Thread.sleep(5000);
		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("change the status of cdp cdpflagged to paused and verify by user login")
	public void change_the_status_of_cdp_cdpflagged_to_paused_and_verify_by_user_login() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Superadmin Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='SuperAdmin'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='CDP Flagged'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		Actions status = new Actions(driver);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.click().build().perform();
//		Thread.sleep(5000);
		Actions xpath = new Actions(driver);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Paused'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Update'])[1]")).click();
		Thread.sleep(3000);
		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("change the status of cdp paused to cancelled and verify by user login")
	public void change_the_status_of_cdp_paused_to_cancelled_and_verify_by_user_login() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("4848484849");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
		String paused = driver.findElement(By.xpath("(//div[@id='time_zone_modal'])[1]/div[1]/div[2]")).getText();
		System.out.println("Message we are showing when status is paused:" + paused);
		Thread.sleep(5000);
		// clicking on the logout button
		driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).click();
		Thread.sleep(3000);

		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Superadmin Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='SuperAdmin'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Paused'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		Actions status = new Actions(driver);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.click().build().perform();
//		Thread.sleep(5000);
		Actions xpath = new Actions(driver);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cancelled'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Update'])[1]")).click();
		Thread.sleep(3000);
		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("change the status of cancelled to adminpaused and verify by user login")
	public void change_the_status_of_cancelled_to_adminpaused_and_verify_by_user_login() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Superadmin Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='SuperAdmin'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cancelled'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		Actions status = new Actions(driver);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.click().build().perform();
//		Thread.sleep(5000);
		Actions xpath = new Actions(driver);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Admin Paused'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Update'])[1]")).click();
		Thread.sleep(3000);
		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("change the status of adminpaused to active and verify by user login")
	public void change_the_status_of_adminpaused_to_active_and_verify_by_user_login() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Superadmin Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='SuperAdmin'])[1]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Admin Paused'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		Actions status = new Actions(driver);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//		status.moveToElement(driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum')]]//a[@data-tooltip='Update CDP Status'][1]/img[1]")))
//				.click().build().perform();
//		Thread.sleep(5000);
		Actions xpath = new Actions(driver);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		xpath.moveToElement(driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]]//a[contains(translate(@data-tooltip, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'update cdp status')][1]/img[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Status'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Active'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Update'])[1]")).click();
		Thread.sleep(3000);
		// signout
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);
		driver.findElement(By.id("user_login")).sendKeys("4848484849");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

}
