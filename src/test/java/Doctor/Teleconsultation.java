package Doctor;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
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

public class Teleconsultation {
	WebDriver driver = null;

	@Given("navigates to nh_url1 {string}")
	public void launchBrowser(String url) {
//		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
//		 + "\\driver\\chromedriver139.exe");
//		 ChromeOptions co = new ChromeOptions();
//		 co.addArguments("--remote-allow-origins=*");
//		 driver = new ChromeDriver(co);
//		 co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		 driver.get("https://customer.nanohealthplan.com/users/sign_in");
//		 driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("enter email13 {string} password13 {string}")
	public void enter_email13_password13(String email13, String password13) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(email13);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password13);
		Thread.sleep(5000);
	}

	@And("clicking signin button from loginpage")
	public void clicking_signin_button_from_loginpage() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("select the cdp nanohealthplan and role cdpadmin to delete the existing patient")
	public void select_the_cdp_nanohealthplan_and_role_cdpadmin_to_delete_the_existing_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdpadmin Role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000); // kept for Robot physical actions
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // kept for Robot physical actions

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("5788110054");
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
		Thread.sleep(2000);

	}

	@And("click on brand logo and select the clinic manager role to register patient in nanohealthplan cdp")
	public void click_on_brand_logo_and_select_the_clinic_manager_role_to_register_patient_in_nanohealthplan_cdp()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting Role as IPBillingManager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
	}

	@Then("register a new patient and book the doctor appointment for video appointment")
	public void register_a_new_patient_and_book_the_doctor_appointment_for_video_appointment() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add patient
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")))
				.click();
		Thread.sleep(2000);
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(60));
		// selecting the title
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		// Thread.sleep(1000);
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Mr.')])[1]"))).click();
		Thread.sleep(1000);
		// firstname
		element.until(ExpectedConditions.elementToBeClickable(By.id("first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		element.until(ExpectedConditions.elementToBeClickable(By.id("lst_name"))).sendKeys("Teleconsultation");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		element.until(ExpectedConditions.elementToBeClickable(By.id("age"))).sendKeys("85");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		element.until(ExpectedConditions.elementToBeClickable(By.id("nmbr"))).sendKeys("5788110054");
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
		Thread.sleep(1000);
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pn_cd'])[1]")))
				.sendKeys("676767");
		Robot test = new Robot();
		test.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
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
		Thread.sleep(2000);
		// clicking on the book doctor consultation
		// mouse hover on the book doctor appointment
		Actions doc = new Actions(driver);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
		// clicking on the book appointment
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)"))))
				.click();
//				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
		Thread.sleep(2000);
		// selecting the type - video type
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[2]"))).click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		// clicking on the slot time
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='appointment_tracking_slot_time'])[1]")))
				.click();
		Thread.sleep(1000);
		// 6
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='timepicker-canvas']/following-sibling::div[1]/div[11]")))
				.click();
		Thread.sleep(1000);
		// ok
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")))
				.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);
		// clicking on the submit
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
		Thread.sleep(4000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// selecting the paylater option
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(2000);
		// clicking on the submit
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait11.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
		Thread.sleep(5000);
		// clicking on the appointment id
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='invoice-container container'])[1]/div[1]/div[1]/div[1]/div[2]/a[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Confirm')])[1]"))).click();
		Thread.sleep(3000);
		// yes
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Yes')])[1]"))).click();
		Thread.sleep(3000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(3000);
//		// print without details
//		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(4000);
//		// share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
//		sub.click();
//		Thread.sleep(8000);
	}

	@Then("signout from the clinic manager role in nanohealth cdp")
	public void signout_from_the_clinic_manager_role_in_nanohealth_cdp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='profile-img'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-sign-out'])[1]"))).click();
		Thread.sleep(2000);
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
	}

	@And("logins to the doctor role")
	public void logins_to_the_doctor_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login"))).sendKeys("doctor1@nh.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_password"))).sendKeys("Chakra@1");
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		Thread.sleep(3000);
		// selecting Role clicking on CDPAdmin
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Doctor'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@Then("search patient and click on the consult button")
	public void search_patient_and_click_on_the_consult_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Teleconsultation')]]//a[text()='Consult'][1]")))
				.click();
		Thread.sleep(5000);
	}

	@And("click on the send link option from popup and enter mailid and click submit")
	public void click_on_the_send_link_option_from_popup_and_enter_mailid_and_click_submit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//a[@class='responsive-img call_btn consult_start tooltipped'])[2]/img[1]"))).click();
		Thread.sleep(5000);
	}

	@When("submit is clicked link will sent to entered mailid or mobile")
	public void submit_is_clicked_link_will_sent_to_entered_mailid_or_mobile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='mobile'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]")))
				.sendKeys("kommayellasunil@gmail.com");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(25000);
	}

	@And("patient will join teleconsultation by clicking on the link")
	public void patient_will_join_teleconsultation_by_clicking_on_the_link() throws Exception {

	}

	@When("patient will join then both doctor and patient screens will display and doctor writes the prescription through teleconsultation")
	public void patient_will_join_then_both_doctor_and_patient_screens_will_display_and_doctor_writes_the_prescription_through_teleconsultation()
			throws Exception {
		// clicking on the prescription view
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions pv = new Actions(driver);
		pv.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription View'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@id='prescriptionView'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the grid view
		pv.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Grid View'])[1]"))).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@id='bothView'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the full screen view
		pv.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='FullScreen View'])[1]"))).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@id='fullScreenView'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@id='bothView'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@id='prescriptionView'])[1]"))).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Consultation Type'])[1]/following-sibling::input[1]")))
				.sendKeys("Clinic type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Accompained by family" + Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Testing" + Keys.ENTER);
		Thread.sleep(3000);
		// clicking on the reset button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Consultation Type'])[1]/following-sibling::input[1]")))
				.sendKeys("Clinic type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Accompained by family" + Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Testing");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space(text())='Patient History'])[1]/following-sibling::div[1]/textarea[1]")))
				.sendKeys("Test patient history" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space(text())='Patient History'])[1]/following-sibling::div[1]/textarea[1]")))
				.sendKeys("testing history" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space(text())='Patient History'])[1]/following-sibling::div[1]/textarea[1]")))
				.sendKeys("test history");
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_comorbidity"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")))
				.sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Week'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='comorbidity_notes'])[1]")))
				.sendKeys("Testing comorbidity notes");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
		WebElement brandInput = driver.findElement(By.cssSelector("input#doctor_visit_comorbidity"));

		String text = "Hypertension";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).sendKeys("Hypertension");
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'HYPERTENSION')])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")))
				.sendKeys("2");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_comorbidity"))).click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_close_cmrb'])[3]"))).click();
		Thread.sleep(2000);
		// Cast the driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms"))).click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[1]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms")))
				.sendKeys("Symptom");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'SYMPTOM')])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[2]"))).sendKeys("1");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms"))).click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// remove one
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='input_close'])[3]"))).click();
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_diagnosis"))).click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[1]"))).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Since Birth'])[1]"))).click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_diag'])[1]/img[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='diagnosis_notes'])[1]")))
				.sendKeys("Testing diagnostics notes selected since birth");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_diag'])[1]/img[1]")))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// remove one
		driver.findElement(By.xpath("(//div[@class='input_close_diag'])[2]/i[1]")).click();
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		// temp
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space(text())='Temp (F)']/following-sibling::input")))
				.sendKeys("101");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Pulse (bpm)']/following-sibling::input"))).sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#bp-s"))).sendKeys("120");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#bp-d"))).sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// height
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Height (Cms)']/following-sibling::input[1]"))).sendKeys("165");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// weight
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Weight (Kgs)']/following-sibling::input[1]")))
				.sendKeys("68" + Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		JavascriptExecutor jse11111 = (JavascriptExecutor) driver;
		jse11111.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Medicine'])[1]/preceding-sibling::input[1]"))).click();
		Thread.sleep(3000);
//				Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='medication_notes'])[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='medication_notes'])[1]")))
				.sendKeys("Test brand notes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='Less'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Medicine'])[2]/preceding-sibling::input[1]")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 1; i++) {
//			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[4]")).click();
//		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 300)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt.click();
		Thread.sleep(1000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#recommended_lab_input_helper")))
				.click();
		Thread.sleep(3000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys("Ecg");
//		Thread.sleep(2000);
		WebElement brandInput1 = driver.findElement(By.cssSelector("input#recommended_lab_input_helper"));

		String text1 = "Ecg";
		for (char c : text1.toCharArray()) {
			brandInput1.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		Thread.sleep(2000);

//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Request'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='requestLabs'])[1]"))).click();
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]"))).click();
		Thread.sleep(3000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]")))
				.sendKeys("Program");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'program')])[2]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]")))
				.sendKeys("Automation testprocedure");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// removing second one
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close package_chip_close'])[2]"))).click();
		Thread.sleep(2000);
		// comments
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("Testing comments" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("test comments" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("tdy test ps comments");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Noticeable']"))).click();
		Thread.sleep(2000);

		// save as draft
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save as Draft'])[1]"))).click();
		Thread.sleep(30000);
		js1.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(1000);
		// edit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Edit'])[1]"))).click();
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("15" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Days'])[1]"))).click();
		Thread.sleep(2000);
		WebElement inperson = driver.findElement(By.xpath("(//label[text()='In-person'])[1]"));
		inperson.click();
		Thread.sleep(3000);
		// SAVE
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			js1.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		// without header & footer
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		// with header and footer
		String parentwind = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print'])[1]/img[1]"))).click();
		Thread.sleep(2000);
		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Iterate through all handles to find the new child window
		for (String handle : allWindows) {
			if (!handle.equals(parentwind)) {
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
		driver.switchTo().window(parentwind);
		Thread.sleep(2000);
		// sharing
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phone"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000);
		// clicking on the close button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Close'])[1]"))).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		driver.close();
	}

}
