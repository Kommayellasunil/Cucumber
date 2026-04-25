package Doctor;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

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

public class Prescription {

	WebDriver driver = null;

	@Given("navigating to the nh_url {string}")
//	public void navigating_to_the_nh_url(String string) {
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

	@Then("enter email8 {string} password8 {string}")
	public void enter_email8_password8(String email8, String password8) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(email8);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password8);
		// clicking on the eye button to view the password
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@toggle='#password-field'])[1]"))).click();
		Thread.sleep(5000);

	}

	@And("sign_in_button was clicked")
	public void sign_in_button_was_clicked() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("select the cdp and role cdpadmin to delete the existing patient")
	public void select_the_cdp_and_role_cdpadmin_to_delete_the_existing_patient() throws Exception {
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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("6656767688");
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

	@And("click on brand logo and select the clinic manager role to register patient")
	public void click_on_brand_logo_and_select_the_clinic_manager_role_to_register_patient() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting Role as IPBillingManager
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("register the new patient and book the doctor appointment")
	public void register_the_new_patient_and_book_the_doctor_appointment() throws Exception {
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(30));
//		element.until(ExpectedConditions.elementToBeClickable(
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
		// selecting the title
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
//		Thread.sleep(1000);
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Mr.')])[1]"))).click();
		Thread.sleep(1000);
		// firstname
		element.until(ExpectedConditions.elementToBeClickable(By.id("first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		element.until(ExpectedConditions.elementToBeClickable(By.id("lst_name"))).sendKeys("Prescription");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		element.until(ExpectedConditions.elementToBeClickable(By.id("age"))).sendKeys("55");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		element.until(ExpectedConditions.elementToBeClickable(By.id("nmbr"))).sendKeys("6656767688");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
//		element.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("cucumps@gmail.com");
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
		Thread.sleep(1000);
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
		Thread.sleep(2000);
		// submit
		element.until(ExpectedConditions.elementToBeClickable(By.id("update_submit"))).click();
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
//				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
		Thread.sleep(2000);
		// selecting the type - clinic type
		element.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[1]"))).click();
		Thread.sleep(1000);
		// selecting the clinic
		element.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]/div[1]/div[1]/div[1]")))
				.click();
		Thread.sleep(1000);
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

//		fee.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// clicking on the notify
//		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
//		gmail.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
//		sms.click();
//		Thread.sleep(1000);
		// clicking on the submit
		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
		Thread.sleep(5000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// entering the cash
		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#advance_field"))).sendKeys("100");
		Thread.sleep(1000);
//		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
//		Thread.sleep(1000);
//		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#payment_cmnt")))
//				.sendKeys("100 rupees paid");
//		Thread.sleep(1000);
//		element.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//a[@class='modal-close btn green right payCmntOk'])[1]"))).click();
//		Thread.sleep(2000);
		// clicking on the submit
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait11.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		Thread.sleep(2000);
		//generate the invoice
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Generate')])[1]"))).click();
		Thread.sleep(3000);
		wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]"))).click();
		Thread.sleep(3000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// receipt download
		WebElement receipt1 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]"));
		JavascriptExecutor rpt1 = (JavascriptExecutor) driver;
		rpt1.executeScript("arguments[0].scrollIntoView(true)", receipt1);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
		Thread.sleep(1000);
		Robot robot31 = new Robot();
		robot31.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		// print
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf"))).click();
		Thread.sleep(2000);
		// print without details
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf"))).click();
		Thread.sleep(2000);
		// share invoice
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phone"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub.click();
		Thread.sleep(10000);
	}

	@Then("signout from the clinic manager role")
	public void signout_from_the_clinic_manager_role() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='profile-img'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-sign-out'])[1]"))).click();
		Thread.sleep(5000);
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
	}

	@And("login to the doctor role")
	public void login_to_the_doctor_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login"))).sendKeys("doctor1@nh.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user_password"))).sendKeys("Chakra@1");
		Thread.sleep(8000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		Thread.sleep(3000);
		// selecting Role clicking on Doctor
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Doctor'])[1]")))
				.click();
		Thread.sleep(3000);
	}

	@And("click on the add prescription button to write the prescription")
	public void click_on_the_add_prescription_button_to_write_the_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//tr[td[contains(normalize-space(.),'Cucum Prescription')]]//a[normalize-space()='Consult']")))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Prescription'])[1]/img[1]")).click();
		Thread.sleep(2000);

//		WebElement addBtn = driver.findElement(By.xpath("(//a[@data-tooltip='Add Prescription'])[1]/img[1]"));
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click();", addBtn);
//		Thread.sleep(3000);

//		driver.findElement(By.xpath("(//button[text()='Add Prescription'])[1]")).click();
//		Thread.sleep(3000);
//		// clicking on the yes button in popup
//		driver.findElement(By.xpath("(//a[@id='modalApmntNewPresc'])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("entering the consultation type data")
	public void entering_the_consultation_type_data() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Consultation Type'])[1]/following-sibling::input[1]")))
				.sendKeys("Clinic type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("entering the accompainedby data in prescription")
	public void entering_the_accompainedby_data_in_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Accompained by family" + Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Testing" + Keys.ENTER);
		Thread.sleep(2000);
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
	}

	@Then("entering the patient history in prescription")
	public void entering_the_patient_history_in_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

	}

	@And("select the comorbidity and click enter to select and enter duration and notes")
	public void select_the_comorbidity_and_click_enter_to_select_and_enter_duration_and_notes()
			throws InterruptedException, Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	}

	@Then("search and add the comorbidity and select and enter the duration")
	public void search_and_add_the_comorbidity_and_select_and_enter_the_duration() throws Exception {
		WebElement brandInput = driver.findElement(By.cssSelector("input#doctor_visit_comorbidity"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("remove one of the comorbidity")
	public void remove_one_of_the_comorbidity() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_close_cmrb'])[3]"))).click();
		Thread.sleep(2000);
		// Cast the driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
	}

	@Then("click on symptoms and select by clicking enter button and enter duration")
	public void click_on_symptoms_and_select_with_enter_and_enter_duration() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[1]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("search and select the symptom and enter and select the duration")
	public void search_and_select_symptom_and_enter_duration() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// remove one
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='input_close'])[3]"))).click();
		Thread.sleep(1000);
	}

	@Then("click on the diagnosis and select one and choose type")
	public void click_on_diagnosis_and_select_one_and_choose_type() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_diagnosis"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
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
	}

	@And("select another and remove one of them")
	public void select_another_and_remove_one_of_them() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_diagnosis"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// remove one
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_close_diag'])[2]/i[1]")))
				.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
	}

	@And("adding vitals in the prescription form")
	public void adding_vitals_in_the_prescription_form() throws Exception {
		// temp
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		jse11111.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);
	}

	@Then("click on the medicine field and select one medicine using enter button and add notes")
	public void click_on_the_medicine_field_and_select_one_medicine_using_enter_button_and_add_notes()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='add'])[1]"))).click();
//		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Medicine'])[1]/preceding-sibling::input[1]"))).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
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
	}

	@And("click on the questionmark icon to create new brand in the prescription")
	public void click_on_questionmark_icon_to_create_new_brand_in_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='new_brand_entry_icon'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Brand Name'])[1]/following-sibling::textarea[1]")))
				.sendKeys("Prescription brand");

		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/span[text()='Tablet'])"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@class='new_brand_desc'])[1]")))
				.sendKeys("Automation testing brand");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='0-1-1-1'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Oral'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='After Food'])[1]"))).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("select the dosage route time frequency duration and type of newly added brand")
	public void select_dosage_route_time_frequency_duration_and_type_of_newly_added_brand() throws Exception {
//		Thread.sleep(1000);
	}

	@And("select the existing brand using arrow keys and remove one of the brand")
	public void select_existing_brand_using_arrow_keys_and_remove_one_of_the_brand() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Medicine'])[3]/preceding-sibling::input[1]"))).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 1; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-times-circle'])[4]"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
	}

	@Then("enter the nextvisitdate and select the nextvisittype")
	public void enter_nextvisitdate_and_select_nextvisittype() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt.click();
		Thread.sleep(1000);
//		WebElement video = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
//		video.click();
//		Thread.sleep(1000);
	}

	@And("select the labs through keys and search remove one of them after adding")
	public void select_labs_through_keys_and_remove_after_adding() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#recommended_lab_input_helper")))
				.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys("Ecg");
//		Thread.sleep(2000);
		WebElement brandInput = driver.findElement(By.cssSelector("input#recommended_lab_input_helper"));

		String text = "Ecg";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		Thread.sleep(2000);

//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close lab_chip_close'])[2]"))).click();
		Thread.sleep(2000);
	}

	@Then("click on the request button")
	public void click_on_request_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Request'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='requestLabs'])[1]"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		WebElement video = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
		video.click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@And("select the procedures and enter the comments")
	public void select_procedures_and_enter_comments() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]"))).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
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
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]"))).click();
		Thread.sleep(1000);

	}

	@Then("select the painscale")
	public void select_painscale() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Noticeable']"))).click();
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
	}

	@Then("click on the abdomen picture and draw write the text on the picture")
	public void click_on_the_abdomen_picture_and_draw_write_the_text_on_the_picture() throws Exception {
		// clicking on the abdomen image
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]")))
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
//		Actions action1 = new Actions(driver);
		// Example: draw arrow from point (200,150) to (350,150)
		action1.moveToElement(canvas11, 0, 0).clickAndHold().moveByOffset(150, 0).release().perform();
		Thread.sleep(2000);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		textBox.sendKeys("Test text in abdoemn before edit"); // Replace with your text
		Thread.sleep(1000);
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
		Thread.sleep(2000); // wait for the callout box to appear
		// Click on the callout box to focus for typing
		WebElement calloutBox = driver.findElement(By.xpath("(//div[contains(text(),'Your text here')])[1]"));
		calloutBox.click();
		Thread.sleep(1000);
		// Enter the text inside the callout
		calloutBox.sendKeys("This is the text for testing purpose");
		// Optional pause
		Thread.sleep(2000);
		// clicking on the save and close button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@title='Save and close'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the abdomen image
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		// close it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@title='Close'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("click on attachment and upload any file pdf")
	public void click_on_attachment_and_upload_file_pdf() throws Exception {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Attachment'])[1]"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Attachment'])[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#attachmentsUploader"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Prescription.pdf");
		Thread.sleep(2000);
		// clear
		driver.findElement(By.xpath("(//a[text()='Clear'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#attachmentsUploader"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Prescription.pdf");
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='OK'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("click on the medicalsummary and close the popup")
	public void click_on_medicalsummary_and_close_popup() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(
				By.xpath("(//span[@class='modal-close nh_close index_close summary_close btn-floating'])[1]/i[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("click on the notes and add some notes and close the popup")
	public void click_on_notes_and_add_notes_and_close_popup() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor notes'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor notes'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#message")))
				.sendKeys("Test doctor message");
		Thread.sleep(1000);
		WebElement others = driver.findElement(By.xpath("(//label[text()='Others'])[1]"));
		others.click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[2]"))).click();
		Thread.sleep(2000);
		// closing the popup
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@id='doctor_notes_new_modal'])[1]/div[1]/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("click on the fav prescription and close the popup")
	public void click_on_fav_prescription_and_close_popup() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Prescription'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Prescription'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='patientHistoryInfoModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the last prescription and close the popup")
	public void click_on_last_prescription_and_close_popup() throws Exception {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// clicking on the all button
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		// download & sharing registration form
		action.moveToElement(driver.findElement(By.xpath(
				"//span[contains(normalize-space(.), 'Registration')]/ancestor::div[contains(@class,'collapsible-header')]//a[@data-tooltip='Print With Header & Footer']")))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//span[contains(normalize-space(.), 'Registration')]/ancestor::div[contains(@class,'collapsible-header')]//a[@data-tooltip='Print With Header & Footer']")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//span[contains(normalize-space(.), 'Registration')]/ancestor::div[contains(@class,'collapsible-header')]//a[@data-tooltip='Share PDF']")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='phone'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]")))
				.sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(8000);
		// clicking on the doc.consult button
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Visits'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Visits'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// clicking on the chemotherapy order
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Chemotherapy Order'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Chemotherapy Order'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
		// clicking on the diet visits
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Dietician Vists'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Dietician Vists'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// clicking on the diagnostic reports
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Diagnostic Reports'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Diagnostic Reports'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
		// clicking on the procedures
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Procedures'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Procedures'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// clicking on the forms
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Forms'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Forms'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		// clicking on the ds
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Discharge Summary'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Discharge Summary'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the labreports and close the popup")
	public void click_on_labreports_and_close_popup() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='patientHistoryModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);

	}

	@And("click on the save as draft button to save draft prescription")
	public void click_on_save_as_draft_button_to_save_draft_prescription() throws InterruptedException {
		// save as draft
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save as Draft'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("click on the add prescription button again and click on save button")
	public void click_on_add_prescription_button_again_and_click_save() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Add Prescription'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Yes'])[2]"))).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("(//label[text()='Video'])[1]")).isSelected()) {
//			System.out.println("Radio button is selected");
		} else {
			WebElement video = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
			video.click();
			Thread.sleep(2000);
//			System.out.println("Radio button is clicked");
		}

		// WebElement video =
		// driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
		// video.click();
		Thread.sleep(2000);
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@title='Save and close'])[1]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("in preview prescription download pdf with and without header and footers")
	public void preview_prescription_download_pdf_with_and_without_headers_and_footers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// without header & footer
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		// with header and footer
		String parentwind = driver.getWindowHandle();
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
		Thread.sleep(1000);
	}

	@Then("share the prescription pdf with the patient email or mobile")
	public void share_prescription_pdf_with_patient_email_or_mobile() throws InterruptedException {
		// sharing
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phone"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(8000);
	}

	@And("click on the edit button to add one more medicine and save the prescription")
	public void click_on_edit_button_add_one_more_medicine_and_save() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]"))).click()
//				.build().perform();
//		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 800)");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Medicine'])[3]//preceding-sibling::input[1]")).click();
//		Thread.sleep(5000);
////		WebElement brandInput = driver
////				.findElement(By.xpath("(//label[text()='Medicine'])[3]//preceding-sibling::input[1]"));
////		String text = "A";
////		for (char c : text.toCharArray()) {
////			brandInput.sendKeys(Character.toString(c));
////			Thread.sleep(300); // small pause between keystrokes
////		}
////		Thread.sleep(2000);
////		for (int i = 0; i <= 2; i++) {
////			Robot robot = new Robot();
////			robot.keyPress(KeyEvent.VK_RIGHT);
////			Thread.sleep(1000);
////		}
////		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
//		driver.findElement(
//				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[3]"))
//				.clear();
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[3]"))
//				.sendKeys("2");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Type'])[7]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='To be continued'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).sendKeys("10" + Keys.TAB);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
//		Thread.sleep(2000);
//		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
//		teleconslt.click();
//		Thread.sleep(1000);
//		WebElement video = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
//		video.click();
//		Thread.sleep(1000);
//		// save
//		driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]")).click();
//		Thread.sleep(2000);
	}

	@Then("download and share the prescription after edit and save")
	public void download_and_share_the_prescription_after_edit_and_save() throws Exception {
//		for (int i = 0; i <= 10; i++) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0, 100)");
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//		// without header & footer
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		// with header and footer
//		String parentwind = driver.getWindowHandle();
//		// Get all window handles
//		Set<String> allWindows = driver.getWindowHandles();
//
//		// Iterate through all handles to find the new child window
//		for (String handle : allWindows) {
//			if (!handle.equals(parentwind)) {
//				// Switch to the new child window
//				driver.switchTo().window(handle);
//				Thread.sleep(1000);
//				// Perform actions on the new window (e.g., close it)
//				driver.close();
//
//				// Break out of the loop since we've found and closed the child window
//				break;
//			}
//		}
//		Thread.sleep(1000);
//		// Switch back to the original parent window
//		driver.switchTo().window(parentwind);
//		Thread.sleep(2000);
//
//		// sharing
//		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("emails")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("phone")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
//		Thread.sleep(8000);
		// close
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Close'])[1]"))).click();
		Thread.sleep(5000);
		Robot pdwn = new Robot();
		pdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("from patient profile history sharing prescription and downloading the pdfs")
	public void from_patient_profile_history_share_prescription_and_download_pdfs() throws InterruptedException {
		// clicking on the history
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='patientHistoryBtn'])[1]"))).click();
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
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='phone'])[1]"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='emails'])[1]")))
				.sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000);

	}

	@Then("click on the load prescription then select the favourite prescription and click on it")
	public void click_on_load_prescription_and_select_favourite_prescription() throws Exception {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Load Prescription'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Load Prescription'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
//		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Prescription'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Prescription'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[contains(text(),'Cucum Fav Ps')])[1]")).click();
		WebElement favps = driver.findElement(By.xpath(
				"//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cucum fav ps')]"));
		favps.click();
		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("5" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		WebElement video = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
		video.click();
		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		// clicking on the abdomen image
		driver.findElement(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]"))
				.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000); // wait for the callout box to appear
		// Click on the callout box to focus for typing
		WebElement calloutBox = driver.findElement(By.xpath("(//div[contains(text(),'Your text here')])[1]"));
		calloutBox.click();
		Thread.sleep(1000);
		// Enter the text inside the callout
		calloutBox.sendKeys("This is loaded prescription");
		// Optional pause
		Thread.sleep(2000);
		// clicking on the save and close button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@title='Save and close'])[1]"))).click();
		Thread.sleep(2000);
	}

	@When("favourite prescription is selected all the prescription data will be automatically filled up")
	public void favourite_prescription_selected_autofill_prescription_data() {
	}

	@Then("click on save button to save the prescription")
	public void click_on_save_button_to_save_prescription() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("download the pdfs and share the prescription through share prescription")
	public void download_the_pdfs_and_share_the_prescription_through_share_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
//		WebElement element = driver
//				.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// with header and footer
		String parentwind = driver.getWindowHandle();
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
//		driver.close();
	}

}
