package TeleCaller;

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

public class Leadappointment {
	WebDriver driver = null;

	@Given("navigating to the NHurl {string}")
	public void launchBrowser(String url) {
//	public void navigating_to_the_n_hurl(String string) {
//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
//	ChromeOptions co = new ChromeOptions();
//	co.addArguments("--remote-allow-origins=*");
//	driver = new ChromeDriver(co);
//	co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	driver.get("https://customer.nanohealthplan.com/users/sign_in");
//	driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);

	}

	@Then("enter email3 {string} password3 {string}")
	public void enter_email3_password3(String email3, String password3) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(email3);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password3);
		Thread.sleep(2000);
	}

	@Then("signin button was clicked")
	public void signin_button_was_clicked() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@And("select cdpadmin role to delete existing patient and select crmleader to register new lead")
	public void select_cdpadmin_role_to_delete_existing_patient_and_select_crmleader_to_register_new_lead()
			throws InterruptedException {
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("9876556778");
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
		Thread.sleep(8000);

		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the profile for crmleader")
	public void select_the_profile_for_crmleader() throws Exception {
		driver.findElement(By.xpath("(//div[normalize-space(text())='CRMLeader'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on register lead icon for registration from crmleader")
	public void click_on_register_lead_icon_for_registration_from_crmleader() throws Exception {
		// clicking on the add new lead
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("enter the details for the lead registration from crmleader")
	public void enter_the_details_for_the_lead_registration_from_crmleader() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("Leadpatient");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("45");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='+91'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).sendKeys("9876556778");
		Thread.sleep(1000);
		// selecting the appointment date
		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[5]/div/div[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);

		WebElement stage = driver.findElement(By.xpath("(//label[text()='New'])[1]"));
		stage.click();
		Thread.sleep(1000);
		// adding referred by details
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//h6[text()='Self'])[1]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//span[@class='cls btn green right referral_submit'])[1]")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("click on the submit button to register lead from crmleader")
	public void click_on_the_submit_button_to_register_lead_from_crmleader() throws Exception {
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
	}

	@When("lead is registered it will be shown in the dashboard under my appointments")
	public void lead_is_registered_it_will_be_shown_in_the_dashboard_under_my_appointments() throws Exception {
		// mouse hover on the lead name
		Actions leadname = new Actions(driver);
		leadname.moveToElement(driver.findElement(By.xpath("(//tr[@id='patient-list'])[1]/td[2]/div[1]/span[1]")))
				.build().perform();
		Thread.sleep(2000);
	}

	@Then("click on the engagement button from myappointments")
	public void click_on_the_engagement_button_from_myappointments() {

	}

	@Then("add the engagement for the leadeng stage1 and save from crmleader")
	public void add_the_engagement_for_the_leadeng_stage1_and_save_from_crmleader() throws Exception {

		WebElement engagementBtn = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Leadpatient')]]//a[@data-tooltip='Lead Engagement'][1]"));

		engagementBtn.click();

		// selecting the phone
		driver.findElement(By.xpath("//li[text()='Phone'][1]")).click();
		Thread.sleep(2000);
		// date
		driver.findElement(By.xpath("(//label[text()='Date'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		Thread.sleep(1000);// time
		driver.findElement(By.xpath("(//label[text()='Time'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='timepicker-analog-display'])[1]/div[2]/div[1]/button[2]")).click();
		Thread.sleep(1000);
		// selecting the stage1
		driver.findElement(By.xpath("(//label[contains(text(),'Stage1')])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Contactable')])[1]")).click();
		// description
		driver.findElement(By.xpath("(//textarea[@id='patient_engagement_detail_notes'])[1]"))
				.sendKeys("Contactable stage");
		Thread.sleep(1000);
		// following up date
		driver.findElement(By.xpath("(//label[text()='Followup Date'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(2000);
		// following up time
		driver.findElement(By.xpath("(//label[text()='Followup Time'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(2000);
		// ok
		driver.findElement(By.xpath("(//button[@class='btn-flat timepicker-close waves-effect'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Preferred Method'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Phone'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.id("engmtSubmitBtn")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Then("switch role to clinic manager role from crmleader")
	public void switch_role_to_clinic_manager_role_from_crmleader() throws Exception {

		// clicking on the brand name
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// selecting Role clicking on OPD Clinic_manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='ClinicManager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the today button
		driver.findElement(By.xpath("(//a[@id='lead-today-btn'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("convert the lead into patient by registering and book apt")
	public void convert_the_lead_into_patient_by_registering_and_book_apt() throws Exception {
		// mouse hover on to the register button
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to Patient'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		WebElement registerBtn = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Leadpatient')]]//a[@data-tooltip='Convert to Patient'][1]"));
		registerBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("testline1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='adrs_line2'])[1]")).sendKeys("testline2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("landmarktest");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(8000);
		// mouse hover on the doc booking
		Actions doc = new Actions(driver);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// clicking on the doctor appointment
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]")).click();
		Thread.sleep(2000);
		// clicking on the book appointment
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)"))))
				.click();
		Thread.sleep(2000);
		// selecting the type - video type
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Find all available slots
		List<WebElement> slots = driver
				.findElements(By.xpath("//div[@class='slots-container']//span[contains(text(), 'PM')]"));

		if (!slots.isEmpty()) {
			for (WebElement slot : slots) {
				if (slot.isDisplayed() && slot.isEnabled()) {
					try {
						wait1.until(ExpectedConditions.elementToBeClickable(slot));
						js.executeScript("arguments[0].scrollIntoView(true);", slot);
						Thread.sleep(500); // Small pause to ensure visibility
						js.executeScript("arguments[0].click();", slot);
						System.out.println("Selected time slot: " + slot.getText());
						break;
					} catch (Exception e) {
						System.out.println("Failed to click slot: " + slot.getText());
					}
				}
			}
		} else {
			// System.out.println("No available time slots found.");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);// entering the cash
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1600");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("Remaining balance amt paid.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='modal-close btn green right payCmntOk'])[1]")).click();
		Thread.sleep(2000);// clicking on the submit
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		Thread.sleep(2000);
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);
		// clicking on the print without details
		driver.findElement(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i")).click();
		Thread.sleep(3000);
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clicking on the submit button
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(15000);
		// clicking on the dashboard
		driver.findElement(By.xpath("(//a[@id='admin-dashboard'])[2]")).click();
		Thread.sleep(3000);

		// mouse hover on to the print button
		Actions print = new Actions(driver);
		print.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img[1]"))).build().perform();
		Thread.sleep(2000);
		WebElement print1 = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Leadpatient')]]//a[@data-tooltip='Print'][1]"));
		print1.click();
		Thread.sleep(3000);

		// mouse hover on to the pdf button
		Actions pdf1 = new Actions(driver);
		pdf1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		WebElement pdf2 = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Leadpatient')]]//a[@data-tooltip='Print With Header & Footer'][1]/img[1]"));
		pdf2.click();
		Thread.sleep(3000);
		// mouse hover on to the pdf button
		Actions pdf21 = new Actions(driver);
		pdf21.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		WebElement pdf22 = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Leadpatient')]]//a[@data-tooltip='Print Without Header & Footer'][1]/img[1]"));
		pdf22.click();
		Thread.sleep(3000);

	}

	@Then("switch back to crmleader role")
	public void switch_back_to_crmleader_role() throws Exception {
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='CRMLeader'])[1]")).click();
		Thread.sleep(5000);
		// selecting the telecaller name and search
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Sunil Telecaller')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@id='submitBtn'])[1]")).click();
		Thread.sleep(3000);
		// un-claimed leads
		driver.findElement(By.xpath("(//div[@id='unclaimed_leads'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// created leads
		driver.findElement(By.xpath("(//div[@id='prescription-orders'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// junk leads
		driver.findElement(By.xpath("(//div[@id='junk_leads'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// Appointments
		driver.findElement(By.xpath("(//div[@id='appointments'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// Consultations
		driver.findElement(By.xpath("(//div[@id='consultations'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// Not Consulted (//div[@id='non_consulted'])[1]
		driver.findElement(By.xpath("(//div[@id='non_consulted'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// Registrations
		driver.findElement(By.xpath("(//div[@id='registrations'])[1]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// calls
		driver.findElement(By.xpath("(//div[@id='prescription-orders'])[2]")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@class='modal nh_modal open'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(3000);

		// date-filter search
		// from date
		driver.findElement(By.xpath("(//input[@id='from-date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.xpath("(//input[@id='to-date'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the next month
		driver.findElement(By.xpath("(//button[@class='month-next'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@data-day='1'])[2]/button[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//button[@id='submitBtn'])[1]")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("(//button[@id='resetBtn'])[1]")).click();
		Thread.sleep(3000);
		// today
		driver.findElement(By.xpath("(//button[@id='dayBtn'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the leads
		driver.findElement(By.xpath("(//a[@id='admin-leads'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='q_prfrd_followup_date_time_gteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@id='q_prfrd_followup_date_time_lteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-next'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@data-day='1'])[2]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);

		// mouse hover on to the owner button
		Actions owner = new Actions(driver);
		owner.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Owner'])[1]/img[1]"))).build().perform();
		Thread.sleep(2000);
		WebElement owner1 = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Telecallerlead')]]//a[@data-tooltip='Owner'][1]/img[1]"));
		owner1.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Owner'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Sunil')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
