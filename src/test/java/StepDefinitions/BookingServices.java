package StepDefinitions;

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
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingServices {
	WebDriver driver = null;

	@Given("navigate_to_nanohealth_on_the_web {string}")
	public void launchBrowser(String url) throws Exception {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://customer.nanohealthplan.com/users/sign_in");
//		driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("logging with the  emailid {string} and  password {string}")
	public void login_with_sunilcm_gmail_com_and_demo(String emailid, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailid);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(15000);
	}

	@And("click on sign_in_button")
	public void click_on_sign_in_button() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select_the_profile")
	public void select_the_profile() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("deleting existing patient using search")
	public void deleting_existing_patient_using_search() throws Exception {
		// selecting Role clicking on CDPAdmin
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.id("frst_nm")).sendKeys("7789110017");
		Thread.sleep(10000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[22]/div/div[1]/span")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[22]/div/div[1]/span")).click();
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
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(5000);

		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("existing patient deleted")
	public void existing_patient_deleted() {
	}

	@And("click on add_patient_icon for registration")
	public void click_on_add_patient_icon_for_registration() throws Exception {
		/*
		 * // signout
		 * driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click
		 * (); Thread.sleep(3000);
		 * driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		 * Thread.sleep(5000);
		 * driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		 * Thread.sleep(3000);
		 * driver.findElement(By.id("user_login")).sendKeys("sunilk@nh13.com");
		 * driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		 * Thread.sleep(1000); driver.findElement(By.name("commit")).click();
		 * Thread.sleep(5000);
		 */
//		/*
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select title_of_patient")
	public void select_title_of_patient() throws Exception {
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
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

	@When("user enters the following details into the registration form")
	public void user_enters_the_following_details_into_the_registration_form(
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
		// city/html/body/main/div/form/div[2]/div/ul/li/div/div[9]/div[2]/input
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
	}

	@Then("select the radio_buttons")
	public void select_the_radio_buttons() throws Exception {
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("767676");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		// referred by
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add Referral'])[1]"))).click();
//		Thread.sleep(1000);
		// digital
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='icon'])[2]"))).click();
//		Thread.sleep(1000);
		// instagram
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.fa.fa-instagram.circle.pink.tooltipped")))
				.click();
//		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.cls.btn.green.right.referral_submit")))
				.click();
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

	@And("click on  submit_button_to_register")
	public void click_on_submit_button_to_register() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update_submit")))).click();
//		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(10000);
	}

	@Then("it will redirects to the patient_profile")
	public void it_will_redirects_to_the_patient_profile() {
	}

	@When("user click on ambulance from book appointment")
	public void user_click_on_ambulance_from_book_appointment() throws Exception {

		/*
		 * driver.findElement(By.id("frst_nm")).sendKeys("Cucumoppatient");
		 * Thread.sleep(5000); // clicking on the patient name
		 * driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click(
		 * ); Thread.sleep(3000); // clicking on the view profile
		 * driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		 * Thread.sleep(3000);
		 */

		// mouse hovering on the ambulance
		Actions ambul = new Actions(driver);
		ambul.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Ambulance'])/img[1]"))).build().perform();
		Thread.sleep(1000);
		// clicking on the ambulance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Ambulance'])/img[1]")))).click();
		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(9)")).click();
		Thread.sleep(3000);
	}

	@Then("from popup select the pickup location")
	public void from_popup_select_the_pickup_location() {

		// selecting the clinic
		driver.findElement(By.xpath("(//h6[text()='Clinic'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("select the location and choose address")
	public void select_the_location_and_choose_address() {
		// selecting the address
		driver.findElement(By.xpath("(//div[@class='provider-addresses'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("from popup select the drop location")
	public void from_popup_select_the_drop_location() {
		// clicking on the home
		driver.findElement(By.xpath("(//h6[text()='Home'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("select the location and choose address for drop location")
	public void select_the_location_and_choose_address_for_drop_location() throws InterruptedException {
		// selecting the home
		driver.findElement(By.xpath("(//div[@class='provider-addresses'])[2]")).click();
		Thread.sleep(1000);
	}

	@Then("select the date and time for appointment")
	public void select_the_date_and_time_for_appointment() throws Exception {
		// date-time-selection
		driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_date")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("td.is-today")).click();
		Thread.sleep(1000);
		// slot-time
		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[text()='Ok']")).click();
		Thread.sleep(3000);
	}

	@And("click on continue button")
	public void click_on_continue_button() throws Exception {
		// continue
		try {
			driver.findElement(By.cssSelector("button.waves-effect.waves-dark.btn.green.date-continue.next-step.right"))
					.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Then("enter the price and click on submit button")
	public void enter_the_price_and_click_on_submit_button() throws Exception {
		// entering the price
		driver.findElement(By.cssSelector("input#appointment_tracking_order_value")).sendKeys("1000");
		Thread.sleep(3000);
		try {
			// submit
			driver.findElement(By.xpath("(//input[@class='btn-loader btn green right btn-loader'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
	}

	@And("select the paymentmethods1")
	public void select_the_paymentmethods1() throws Exception {
		WebDriverWait disc = new WebDriverWait(driver, Duration.ofSeconds(30));
		// entering the discount amount
		disc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#promo_amnt"))).sendKeys("100");
		// Thread.sleep(1000);
		// clicking on the apply
		disc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#applyCouponModal"))).click();
//		Thread.sleep(2000);
		// entering the comments
		disc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#comments")))
				.sendKeys("Discount 100");
		Thread.sleep(1000);
		// clicking on the submit button
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#applyCouponBtn"))))
				.click();
		Thread.sleep(2000);

		// clicking on the close button for applied discount
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.custom_chip>i")))).click();
		Thread.sleep(3000);

		// entering the discount amount
		disc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#promo_amnt"))).sendKeys("100");
		Thread.sleep(2000); // clicking on the apply
		disc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#applyCouponModal"))).click();
		Thread.sleep(2000); // entering the comments
		disc.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#comments")))
				.sendKeys("Discount 100");
		Thread.sleep(1000);
		// clicking on the submit button
		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#applyCouponBtn"))))
				.click();
		Thread.sleep(3000);

	}

	@When("user enter transactionamount as partial for paymentmethodone")
	public void user_enter_transactionamount_as_partial_for_paymentmethodone() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#advance_field"))).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("Receiptcomment1 will be visible click on it")
	public void receiptcomment1_will_be_visible_click_on_it() {
	}

	@And("enter the receiptcomments1 and click on ok")
	public void enter_the_receiptcomments1_and_click_on_ok() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#payment_cmnt")))
				.sendKeys("receipt comment for 100 rupees for payment method cash");
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")))
				.click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button  inthe proformainvoice1")
	public void click_on_the_submit_button_inthe_proformainvoice1() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("click on the paybalance button")
	public void click_on_the_paybalance_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Pay Balance'])[1]"))).click();
//		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("billing invoice page will open select the payment methodtwo and enter partial amount")
	public void billing_invoice_page_will_open_select_the_payment_methodtwo_and_enter_partial_amount()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// select the paymentmethod as card
		WebElement card = driver.findElement(By.xpath("(//label[text()='Card'])[1]"));
		card.click();
		Thread.sleep(1000);
		// enter transaction amount
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#txn_id"))).sendKeys("12345");
//		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// entering amount partially
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#advance_field"))).sendKeys("100");
//		Thread.sleep(2000);
		// entering receipt comment

		// clicking on the comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#payment_cmnt")))
				.sendKeys("receipt comment for 100 rupees for payment method card");
		Thread.sleep(1000);

		// ok
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")))
				.click();
		Thread.sleep(1000);
	}

	@And("click on the submit button from the invoice_page")
	public void click_on_the_submit_button_from_the_invoice_page() throws Exception {
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
	}

	@Then("click on the paybalance button again")
	public void click_on_the_paybalance_button_again() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("select the paymentmethodthree and enter partial amount")
	public void select_the_paymentmethodthree_and_enter_partial_amount() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// select the paymentmethod as other
		WebElement card = driver.findElement(By.xpath("(//label[text()='Other'])[1]"));
		card.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// selecting the phonpe/googlepay
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Googlepay'])[1]"))).click();
//		Thread.sleep(1000);
		// enter transaction amount
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#other_txn_id"))).sendKeys("12345");
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// entering amount partially
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#advance_field"))).sendKeys("700");
//		Thread.sleep(1000);
		// clicking on the comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i#paymentComment"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea#payment_cmnt")))
				.sendKeys("receipt comment for 100 rupees for payment method other");
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")))
				.click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button again from the invoice page")
	public void click_on_the_submit_button_again_from_the_invoice_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
//		Thread.sleep(5000);
	}

	@And("Click on the generate button in the top to generate invoice id")
	public void Click_on_the_generate_button_in_the_top_to_generate_invoice_id() throws Exception {
//		// download the op invoice
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
//		Thread.sleep(2000);
	}

	@And("click on the paybalance button again to pay partial amount")
	public void click_on_the_paybalance_button_again_to_pay_partial_amount() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Pay Balance'])[1]"))).click();
////		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
	}

	@Then("select paymentmethod as send link and enter details")
	public void select_paymentmethod_as_send_link_and_enter_details() throws Exception {
//		// select the paymentmethod as send link
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement card = driver.findElement(By.xpath("(//label[text()='Send link'])[1]"));
//		card.click();
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// adding partial amount in the send link option
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#request_amt"))).clear();
////		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#request_amt"))).sendKeys("12");
////		Thread.sleep(2000);
//		// clearing the percentage
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#extra_charge"))).clear();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#extra_charge")))
//				.sendKeys("1" + Keys.TAB);
////		Thread.sleep(2000);
//		// clearing the percentage
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#extra_charge"))).clear();
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#extra_charge")))
//				.sendKeys("0" + Keys.TAB);
////		Thread.sleep(2000);
//		// clearing mail and writing another email
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]"))).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]")))
//				.sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// clearing mobile number
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='mobile'])[1]"))).clear();
//		Thread.sleep(2000);
//
//		// clicking on the send icon
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.small.material-icons.sendPaymentLink")))
//				.click();
//		Thread.sleep(5000);
//		// enter transaction amount
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#link_txn_id"))).sendKeys("12345");
//		Thread.sleep(1000);
	}

	@And("click on the submit from the proforma invoice page")
	public void click_on_the_submit_from_the_proforma_invoice_page() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
////		Thread.sleep(5000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Pay Balance'])[1]"))).click();
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// select the paymentmethod as send link
//		WebElement card = driver.findElement(By.xpath("(//label[text()='Send link'])[1]"));
//		card.click();
//		Thread.sleep(1000);
//		Robot robot3 = new Robot();
//		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// adding partial amount in the send link option
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#request_amt"))).clear();
////		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#request_amt"))).sendKeys("588");
////		Thread.sleep(2000);
//		// clearing the percentage
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#extra_charge"))).clear();
////		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#extra_charge")))
//				.sendKeys("0" + Keys.TAB);
////		Thread.sleep(2000);
//		// clearing mail and writing another email
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]"))).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]")))
//				.sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// clearing mobile number
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='mobile'])[1]"))).clear();
//		Thread.sleep(2000);
//
//		// clicking on the send icon
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.small.material-icons.sendPaymentLink")))
//				.click();
//		Thread.sleep(5000);
//		// enter transaction amount
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#link_txn_id"))).sendKeys("1234");
//		Thread.sleep(1000);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
//		Thread.sleep(3000);

	}

	@And("clicking on the appointmentid at righttop")
	public void clicking_on_the_appointmentid_at_righttop() throws Exception {
		// clicking on the appointment id
		WebDriverWait aptidclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		aptidclick
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//div[@class='row summary'])[1]/div[2]/a[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("reducingscreensize click on the proformainvoice")
	public void reducingscreensize_click_on_the_proformainvoice() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot3 = new Robot();
		for (int i = 0; i < 2; i++) {
			robot3.keyPress(KeyEvent.VK_CONTROL);
			robot3.keyPress(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
			robot3.keyRelease(KeyEvent.VK_SUBTRACT);
			robot3.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(1000);
		// proforma invoice
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='price-block'])[1]/div[1]/div[2]/a[2]"))).click();
//		Thread.sleep(2000);

	}

	@And("clicking on the viewbutton and closingpopup for ambulancebooking")
	public void clicking_on_the_viewbutton_and_closingpopup_for_ambulancebooking() throws Exception {
		// clicking on the view
		driver.findElement(By.xpath("(//a[text()='View'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		// Release CTRL + 0
		robot.keyRelease(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// closing the popup
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("div#modalApmntShow>div>div>span:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("div#modalApmntShow>div>div>span:nth-of-type(1)")).click();
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_SUBTRACT);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@And("selecting Servicewise Datewise Itemwise Summary and downloading the invoice")
	public void selecting_Servicewise_Datewise_Itemwise_Summary_and_downloading_the_invoice() throws Exception {
		// generate the invoice
		Actions id = new Actions(driver);
		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(2000);
		// converting to tax invoice
		Actions taxinv = new Actions(driver);
		taxinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")).click();
		Thread.sleep(4000);
		// download invoice
		Actions inv = new Actions(driver);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(5000);

		// selecting datewsie and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		WebDriverWait datewise = new WebDriverWait(driver, Duration.ofSeconds(30));
		datewise.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Datewise'])[1]"))))
				.click();
		Thread.sleep(3000);
		// OP -Invoice datewise wise pdf
		driver.findElement(By.cssSelector("a.tooltipped.date_wise_pdf>img")).click();
		Thread.sleep(2000);

		// selecting summary and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait summary = new WebDriverWait(driver, Duration.ofSeconds(30));
		summary.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Summary'])[1]"))))
				.click();
		Thread.sleep(3000);
		// OP -Invoice summary wise pdf
		driver.findElement(By.cssSelector("a.tooltipped.datewise_summary_pdf>img")).click();
		Thread.sleep(2000);

		// selecting itemwise and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait itemwise = new WebDriverWait(driver, Duration.ofSeconds(30));
		itemwise.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Itemwise'])[1]"))))
				.click();
		Thread.sleep(3000);
		// OP -Invoice itemwise wise pdf
		driver.findElement(By.cssSelector("a.tooltipped.date_wise_pdf>img")).click();
		Thread.sleep(2000);

		// selecting itemwise and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		WebDriverWait servicewise = new WebDriverWait(driver, Duration.ofSeconds(30));
		servicewise
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Servicewise'])[1]"))))
				.click();
		Thread.sleep(3000);

	}

	@And("download the Invoice_receipt_totaladvance_printpdf1")
	public void download_the_invoice_receipt_totaladvance_printpdf1() throws Exception {
//		// OP -Invoice pdf
//		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
//		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// mouse hovering on the discount i icon
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.cssSelector("i.fa.fa-info-circle.tooltipped:nth-of-type(1)")))
//				.build().perform();
//		Thread.sleep(2000);
		// receipt download
		WebElement receipt1 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]"));
		JavascriptExecutor rpt1 = (JavascriptExecutor) driver;
		rpt1.executeScript("arguments[0].scrollIntoView(true)", receipt1);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
		Thread.sleep(1000);

		WebElement receipt2 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[2]/a[1]"));
		JavascriptExecutor rpt2 = (JavascriptExecutor) driver;
		rpt2.executeScript("arguments[0].scrollIntoView(true)", receipt2);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[3]/div[2]/a")).click();
		Thread.sleep(1000);

		WebElement receipt3 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[4]/div[2]/a[1]"));
		JavascriptExecutor rpt3 = (JavascriptExecutor) driver;
		rpt3.executeScript("arguments[0].scrollIntoView(true)", receipt3);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[4]/div[2]/a")).click();
		Thread.sleep(1000);

//		WebElement receipt4 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[5]/div[2]/a[1]"));
//		JavascriptExecutor rpt4 = (JavascriptExecutor) driver;
//		rpt4.executeScript("arguments[0].scrollIntoView(true)", receipt4);
//		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[4]/div[2]/a")).click();
//		Thread.sleep(1000);

		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[5]/div[2]/a")).click();
		Thread.sleep(1000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
//		// pdf downloading
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(1000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);

	}

	@Then("click on shareinvoice1 button")
	public void click_on_shareinvoice1_button() throws Exception {
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(3000);
	}

	@And("clears existing mail and phone for ambulance appointment")
	public void clears_existing_mail_and_phone_for_ambulance_appointment() {
	}

	@Then("enter phone and click on submit button  for shareinvoice1")
	public void enter_phone_and_click_on_submit_button_for_shareinvoice1() throws Exception {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).sendKeys("8790098500");
		Thread.sleep(1000);
		// submit
		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub.click();
		Thread.sleep(10000);
	}

	@When("user click on patientsname from ambulance proformainvoicepage")
	public void user_click_on_patientsname_from_ambulance_proformainvoicepage() throws Exception {
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//		} else {
//			// mouse hover on the hcs
//			Actions hcs = new Actions(driver);
//			hcs.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Care Service'])/img[1]")))
//					.build().perform();
//			Thread.sleep(1000);
//		}
//		Thread.sleep(2000);

	}

	@Then("patientprofile page will be opened")
	public void patientprofile_page_will_be_opened() {
	}

	@When("user click on bookhomecareservice from book appointment")
	public void user_click_on_bookhomecareservice_from_book_appointment() throws Exception {
		Actions hcs = new Actions(driver);
		hcs.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Care Service'])/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// clicking on the homecareservices img icon
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Care Service'])/img[1]"))))
				.click();
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(10)>img")).click();
		Thread.sleep(3000);
	}

	@Then("services page will open")
	public void services_page_will_open() {

	}

	@And("select the homecare services and remove one of the selected services")
	public void select_the_homecare_services_and_remove_one_of_the_selected_services() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// adding the services
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='add'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='add'])[3]"))).click();
		Thread.sleep(2000);
		// removing last added
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[text()='remove'])[3]"))).click();
		Thread.sleep(2000);
	}

	@Then("click on checkout button from homecare service page")
	public void click_on_checkout_button_from_homecare_service_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the checkout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Checkout']"))).click();
//		Thread.sleep(2000);
	}

	@And("select the location and address")
	public void select_the_location_and_address() throws Exception {
//		// clicking on the addresss
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[3]/div/div/div[2]/form/ul/li[1]/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div/div[2]"))
//				.click();
//		Thread.sleep(1000);
	}

	@Then("select the start date and end date with timings")
	public void select_the_start_date_and_end_date_with_timings() throws Exception {
//		// start date
//		driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_date")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		// driver.findElement(By.xpath("//button[text()='21']")).click();
//		Thread.sleep(1000);
//		// start time
//		driver.findElement(By.id("start_time")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[text()='11']")).click();
//		Thread.sleep(2000);
//		// am
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[text()='00']")).click(); // 00
//		Thread.sleep(2000);
//		// clicking on the ok
//		driver.findElement(By.xpath("(//button[text()='Ok'])[1]")).click();
//		Thread.sleep(1000);
//		// end date
//		driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_end_date")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click(); // 10
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.name("hc_end_time")).click();
//		Thread.sleep(1000);
//		// selecting time
//		driver.findElement(By.xpath("(//div[text()='3'])[2]")).click(); // 4
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click(); // pm
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[text()='00'])[2]")).click(); // 00
//		Thread.sleep(1000);
//		// clicking on the ok
//		driver.findElement(By.xpath("(//button[text()='Ok'])[2]")).click();
//		Thread.sleep(1000);
//		// clicking on the continue
//		driver.findElement(By.cssSelector("div.step-actions>button:nth-of-type(1)")).click();
//		Thread.sleep(1000);
	}

	@And("enter the age and click on continue")
	public void enter_the_age_and_click_on_continue() throws Exception {
//		// selecting sex radio button
//		WebElement fm = driver.findElement(By.xpath("(//label[text()='F'])[1]"));
//		fm.click();
//		Thread.sleep(1000);
//		// entering the age
//		driver.findElement(By.cssSelector("input#age")).sendKeys("35");
//		Thread.sleep(1000);
//		// clicking on the continue
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div/div[2]/form/ul/li[3]/div[2]/div[3]/button"))
//				.click();
//		Thread.sleep(3000);
	}

	@Then("changing time in the invoice page")
	public void changing_time_in_the_invoice_page() throws Exception {
//		// selecting the time-slot
//		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
//		Thread.sleep(1000);
//		// 6pm
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[3]/following-sibling::div[1]/div[6]")).click();
//		Thread.sleep(1000);
//		// 30mins
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[3]/following-sibling::div[2]/div[7]")).click();
//		Thread.sleep(1000);
//		// PM
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[3]/div[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[3]/button[2]")).click();
//		Thread.sleep(2000);
	}

	@And("clicking on submit button")
	public void clicking_on_submit_button() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='bookNowBtn'])[1]"))).click();
//		Thread.sleep(2000);
	}

	@Then("it will open the proformainvoice page for homecareservice")
	public void it_will_open_the_proformainvoice_page_for_homecareservice() throws Exception {
		// deleting the one invoice
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Delete Item'])[1]/i[1]")))
				.click();
//		Thread.sleep(3000); 
		// yes
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Yes'])[2]"))).click();
//		Thread.sleep(3000);
	}

	@And("changing the comments by clearing existing comment beside services name")
	public void changing_the_comments_by_clearing_existing_comment_beside_services_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-comment pointer'])[1]")))
				.click();
//		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='btnCmntClear'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering comment
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@class='materialize-textarea'])[1]")))
				.sendKeys("Home care services comment 1");
//		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal nh_modal invoiceCommentModal open'])[1]/div[1]/div[3]/div[1]/input[1]")))
				.click();
//		Thread.sleep(3000);
		// editing the amount for service
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-pencil'])[3]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#invoice_detail_unit_cost"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#invoice_detail_unit_cost")))
				.sendKeys("250" + Keys.TAB);
		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='modal-action btn green right btn-loader'])[1]")))
				.click();
//		Thread.sleep(2000);
	}

	@And("edit the invoice date for home care services")
	public void edit_the_invoice_date_for_home_care_services() throws Exception {
		// clicking on the edit invoice date
//		driver.findElement(By.xpath("(//a[@class='edit-invoice-date'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		LocalDate today = LocalDate.now();
//		int previousWeekDay = today.minusDays(1).getDayOfMonth(); // one day ago
//		System.out.println("Date to select (one day ago): " + previousWeekDay);
//		// Step 4: Locate all the day elements in the calendar
//		List<WebElement> dateElements = driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
//
//		// Step 5: Iterate through the list and find the required date
//		for (WebElement dateElement : dateElements) {
//			if (dateElement.getText().equals(String.valueOf(previousWeekDay))) {
//				System.out.println("Clicking on date: " + dateElement.getText());
//				dateElement.click();
//				break;
//			}
//		}
//		System.out.println("Previous date selected successfully!");
//		Thread.sleep(2000);
		// 1️⃣ Get yesterday's date
		LocalDate yesterday = LocalDate.now().minusDays(1);
		int yesterdayDay = yesterday.getDayOfMonth();

		// 2️⃣ Open the calendar widget (change locator as per your input field/button)
		driver.findElement(By.xpath("(//a[@class='edit-invoice-date'])[1]/i[1]")).click();

		// 3️⃣ Try selecting yesterday in current month
		try {
			WebElement yesterdayDate = driver.findElement(By.xpath("//td[normalize-space()='" + yesterdayDay + "']"));
			yesterdayDate.click();
			System.out.println("✅ Yesterday selected in current month: " + yesterday);
		} catch (Exception e) {
			System.out.println("⚠️ Yesterday not in current month. Switching to previous month...");

			// 4️⃣ Click previous month arrow
			driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
			Thread.sleep(1000);

			// 5️⃣ Select yesterday in previous month
			WebElement yesterdayDatePrev = driver
					.findElement(By.xpath("//td[normalize-space()='" + yesterdayDay + "']"));
			yesterdayDatePrev.click();
			System.out.println("✅ Yesterday selected from previous month: " + yesterday);
		}
		Thread.sleep(2000);
		// clicking on the tracking button
		Actions tracking = new Actions(driver);
		tracking.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Tracking'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(2000);
		tracking.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Tracking'])[1]/i[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		// Locate the table body
		WebElement tableBody = driver
				.findElement(By.xpath("(//table[@class='table nh_table invoice_table'])[1]/tbody[1]"));
		// Get all rows
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		// Loop through all rows
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			// Get all columns (cells) in the row
			List<WebElement> cols = row.findElements(By.tagName("td"));
			// Print row number
			System.out.print("Row " + (i + 1) + ": ");
			// Print all column values
			for (WebElement col : cols) {
				System.out.print(col.getText() + " | ");
			}
			// Move to the next line after each row
			System.out.println();
		}
		// closing the tracking popup
		driver.findElement(By.xpath("(//div[@id='invoiceUpdatesList'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("select pay later option from the payments")
	public void select_pay_later_option_from_the_payments() throws Exception {
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button inthe proformainvoice2")
	public void click_on_the_submit_button_inthe_proformainvoice2() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf2")
	public void download_the_invoice_receipt_totaladvance_printpdf2() throws Exception {
		// OP invoice pdf
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);
//		// clicking on the total receipt
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
	}

	@Then("click on the invoice id to generate the invoice id")
	public void click_on_the_invoice_id_to_generate_the_invoice_id() throws Exception {
		// clicking on the invoice id button
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[2]")).click();
		Thread.sleep(5000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("click on shareinvoice2 button")
	public void click_on_shareinvoice2_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for homecareservices appointment")
	public void clears_existing_mail_and_phone_for_homecareservices_appointment() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enter mail and click on submit button for shareinvoice2")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice2() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement submit1 = driver
				.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		submit1.click();
		Thread.sleep(10000);
	}

	@When("user click on patientsname from homecareservices proformainvoicepage")
	public void user_click_on_patientsname_from_homecareservices_proformainvoicepage() throws Exception {

		// searching patient and booking diagnostic from search bar.
		driver.findElement(By.cssSelector("input#frst_nm")).sendKeys("Cucumoppatient");
		Thread.sleep(2000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);

	}

	@Then("patientprofile page will open")
	public void patientprofile_page_will_open() {
	}

	@When("user click on bookdiagnostic from book appointment")
	public void user_click_on_bookdiagnostic_from_book_appointment() throws Exception {
		// mouse hover on the diagnostic booking
		Actions diag = new Actions(driver);
		diag.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img")))
				.build().perform();
		Thread.sleep(1000);
//		// clicking on the book diagonstic appointment
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(3)>img")).click();
//		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")).click();
		Thread.sleep(3000);
	}

	@Then("it will show the avaible labs and tests")
	public void it_will_show_the_avaible_labs_and_tests() {
	}

	@When("select lab from the dropdown")
	public void select_lab_from_the_dropdown() throws Exception {
		// clicking on the drop down
		driver.findElement(By.cssSelector("span.selection")).click();
		Thread.sleep(2000);
		// selecting the lab
		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
		Thread.sleep(10000);
	}

	@Then("avaible tests from that lab will be reflected")
	public void avaible_tests_from_that_lab_will_be_reflected() {

	}

	@And("select the diagnostic services and remove one of the selected services")
	public void select_the_diagnostic_services_and_remove_one_of_the_selected_services() throws Exception {
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
	}

	@Then("click on checkout button from diagnostic service page")
	public void click_on_checkout_button_from_diagnostic_service_page() throws Exception {
		// clicking on the checkout button
		driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
	}

	@And("select the type")
	public void select_the_type() throws Exception {
		// selecting the type - Lab Visit
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the address for the selected lab")
	public void select_the_address_for_the_selected_lab() throws Exception {
//		// selecting the location - address
//		driver.findElement(
//				By.xpath("(//div[@id='lab_saved-addresses'])[1]//following-sibling::div/div/div/div/div/span[1]"))
//				.click();
//		Thread.sleep(2000);
	}

	@And("select the slot for diagnostic appointment")
	public void select_the_slot_for_diagnostic_appointment() throws Exception {

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

	}

	@Then("enter referredby delivery charges")
	public void enter_referredby_delivery_charges() throws Exception {
		Thread.sleep(2000);
		// entering referred by
		driver.findElement(By.xpath("(//label[text()='Referred By'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(1000);
		// entering the delivery charges
		driver.findElement(By.xpath("(//input[@id='delivery_charges'])[1]")).sendKeys("50");
		Thread.sleep(2000);
	}

	@And("select the notify patient checkboxes for diagnostic booking")
	public void select_the_notify_patient_checkboxes_for_diagnostic_booking() throws Exception {
		// clicking on the check boxes
		WebElement cbox1 = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		cbox1.click();
		WebElement cbox2 = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		cbox2.click();
		Thread.sleep(1000);
	}

	@Then("click on submit from paymentpage for diagnostic booking")
	public void click_on_submit_from_invoicepage_for_diagnostic_booking() throws Exception {
		// clicking on the submit
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(2000);

	}

	@Then("it will open the proformainvoice page for diagnostic booking")
	public void it_will_open_the_proformainvoice_page_for_diagnostic_booking() {

	}

	@And("give the hundered percent discount and apply")
	public void give_the_hundered_percent_discount_and_apply() throws Exception {
		driver.findElement(By.cssSelector("input#promo_disc")).sendKeys("100");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000); // entering comments
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("applied 100% discount");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#applyCouponBtn")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);
	}

	@Then("click on the submit button inthe proformainvoice3")
	public void click_on_the_submit_button_inthe_proformainvoice3() throws Exception {
//		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
//		paylater.click();
//		Thread.sleep(1000);
//		// clicking on the submit
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
////		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf3")
	public void download_the_invoice_receipt_totaladvance_printpdf3() throws Exception {
		// OP invoice
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		// clicking on the apt id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//div[@class='row summary'])[1]/div[2]/a")))).click();
		Thread.sleep(3000);
		// downloading op invoice
		driver.findElement(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(5000);

		/*
		 * driver.findElement(By.xpath("(//a[text()='Proforma Invoice'])[1]")).click();
		 * Thread.sleep(5000);
		 */
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);

//		Actions receipt = new Actions(driver);
//		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		// clicking on the total advance
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(2000);
		// mouse hover on the i button to show discount
//		Actions discount = new Actions(driver);
//		discount.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle tooltipped'])[1]"))).build()
//				.perform();
//		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);
		// clicking on the print without details
		driver.findElement(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i")).click();
		Thread.sleep(3000);
	}

	@Then("click on shareinvoice3 button")
	public void click_on_shareinvoice3_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for diagnostic appointment")
	public void clears_existing_mail_and_phone_for_diagnostic_appointment() throws Exception {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
	}

	@Then("enter mail and click on submit button for shareinvoice3")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice3() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clicking on the submit button
		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
		Thread.sleep(10000);
	}

	@When("user click on patientsname from diagnostic proformainvoicepage")
	public void user_click_on_patientsname_from_diagnostic_proformainvoicepage() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			// driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(1000);
		}
	}

	@Then("patientprofile  will be open")
	public void patientprofile_will_be_open() {
	}

	@When("user click on bookdietitianappointment from book appointment")
	public void user_click_on_bookdietitianappointment_from_book_appointment() throws Exception {
		// clicking on the book dietician
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//a[@data-tooltip='Book Dietitian Appointment'])[1]/img[1]")))).click();
		Thread.sleep(3000);
	}

	@Then("list of avaible dietitians will be displayed")
	public void list_of_avaible_dietitians_will_be_displayed() {

	}

	@And("select the dietitan and click on book appointment")
	public void select_the_dietitan_and_click_on_book_appointment() throws Exception {
		// clicking on the book appointment
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select the type and slot for dietitan appointment")
	public void select_the_type_and_slot_for_dietitan_appointment() throws Exception {
		// clicking on the clinic
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
		// selecting the hospital
		driver.findElement(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]")).click();
		Thread.sleep(2000);
		// clicking on the slot
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

	}

	@And("here we can change timings")
	public void here_we_can_change_timings() throws Exception {
//		// clicking on the slot time
//		driver.findElement(By.id("appointment_tracking_slot_time")).click();
//		Thread.sleep(1000);
//		// 6
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[1]/div[6]")).click();
//		Thread.sleep(1000);
//		// 30 mins
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[2]/div[7]")).click();
//		Thread.sleep(1000);
//		// pm
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[2]")).click();
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		Thread.sleep(1000);
	}

	@Then("select the checkboxes for notifypatient for dietitanappointment")
	public void select_the_checkboxes_for_notifypatient_for_dietitanappointment() throws Exception {
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		Thread.sleep(1000);
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);
	}

	@And("click on the submit from paymentpage for dietitanappointment")
	public void click_on_the_submit_from_paymentpage_for_dietitanappointment() throws Exception {
		// clicking on the submit
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("it will open proformainvoice page for dietitanappointment")
	public void it_will_open_proformainvoice_page_for_dietitanappointment() {

	}

	@And("select the paymentmethods4")
	public void select_the_paymentmethods4() throws Exception {
		// adding insurance to the patient & paying through insurance
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Insurer'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Insurer'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(5000);

		WebElement insurance = driver.findElement(By.xpath("(//label[text()='Insurance'])[2]"));
		insurance.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='insurance_policy_detail_id_card'])[1]")).sendKeys("1234567");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='insurance_policy_detail_policy_no'])[1]")).sendKeys("17892922");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='insurance_policy_detail_policy_start_date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Insurance Company'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Insurance Company Limited')])")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@class='btn right green ins_submit btn-loader'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Select'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the pre-authorization response button
		driver.findElement(By.xpath("(//a[text()='Pre-authorization Response'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_0_result_value'])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//input[@name='patient_master[patient_questnr_value_details_attributes][1][result_value]'])[1]"))
				.sendKeys("87900");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.TAB).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action1.sendKeys("500").perform();
		Thread.sleep(1000);
		action1.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//input[@name='patient_master[patient_questnr_value_details_attributes][4][result_value]'])[1]"))
				.sendKeys("87900");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action1.sendKeys(Keys.TAB).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action1.sendKeys("500").perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the claim approval response button
		driver.findElement(By.xpath("(//a[text()='Claim Approval Response'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_0_result_value'])[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//input[@name='patient_master[patient_questnr_value_details_attributes][1][result_value]'])[1]"))
				.sendKeys("87900");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action11 = new Actions(driver);
		action11.sendKeys(Keys.TAB).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action11.sendKeys("500").perform();
		Thread.sleep(1000);
		action11.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action11.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//input[@name='patient_master[patient_questnr_value_details_attributes][4][result_value]'])[1]"))
				.sendKeys("87900");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action11.sendKeys(Keys.TAB).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action11.sendKeys("500").perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);

	}

	@When("user enters the transactionamount then receiptcomment will visible")
	public void user_enters_the_transactionamount_then_receiptcomment_will_visible() throws Exception {

	}

	@Then("click on receiptcomment and enter the comment")
	public void click_on_receiptcomment_and_enter_the_comment() throws Exception {
	}

	@Then("click on the submit button inthe proformainvoice4")
	public void click_on_the_submit_button_inthe_proformainvoice4() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf4")
	public void download_the_invoice_receipt_totaladvance_printpdf4() throws Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);
//		// clicking on the receipt id 2
//		// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[2]/a")).click();
//		// Thread.sleep(2000);
//		// clicking on the total receipt
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[1]/strong/span/a/img"))
//				.click();
//		Thread.sleep(2000);

		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
	}

	@Then("click on shareinvoice4 button")
	public void click_on_shareinvoice4_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for dietitianappointment")
	public void clears_existing_mail_and_phone_for_dietitianappointment() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enter mail and click on submit button for shareinvoice4")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice4() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clicking on the submit
		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub.click();
		Thread.sleep(15000);
	}

	@When("user click on patientsname from dietitian proformainvoicepage")
	public void user_click_on_patientsname_from_dietitian_proformainvoicepage() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(2000);
		}

		/*
		 * driver.findElement(By.id("frst_nm")).sendKeys("Cucumoppatient");
		 * Thread.sleep(10000); // clicking on the patient name
		 * driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click(
		 * ); Thread.sleep(3000); // clicking on the view profile
		 * driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		 * Thread.sleep(3000); // close for pending amount if
		 * (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i"))
		 * .isDisplayed()) {
		 * driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).
		 * click(); Thread.sleep(1000); } else { }
		 */
	}

	@When("user click on bookopprocedures from book appointment")
	public void user_click_on_bookopprocedures_from_book_appointment() throws Exception {
		// mouse hover on the oppro booking
		Actions op = new Actions(driver);
		op.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Minor Procedures'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		// clicking on the book op procedures
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Book Minor Procedures'])[1]/img[1]"))))
				.click();
		Thread.sleep(2000);
	}

	@Then("list of procedures will be displayed for opprocedures")
	public void list_of_procedures_will_be_displayed_for_opprocedures() {
	}

	@And("select the procedures and remove of them")
	public void select_the_procedures_and_remove_of_them() throws Exception {
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the add again
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// removing
		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		Thread.sleep(3000);

	}

	@Then("click on the checkout for op procedure booking")
	public void click_on_the_checkout_for_op_procedure_booking() throws Exception {
		// checkout
		WebDriverWait checkout = new WebDriverWait(driver, Duration.ofSeconds(30));
		checkout.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")))).click();
		Thread.sleep(3000);

	}

	@And("select the procedure start time and end time")
	public void select_the_procedure_start_time_and_end_time() throws Exception {
//		// start time
//		driver.findElement(By.cssSelector("input#start_time")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]//following-sibling::div[1]/div[6]"))
//				.click(); //
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]//following-sibling::div[2]/div[7]"))
//				.click(); // 30mins
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.cssSelector("input#end_time")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// start time
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[2]//following-sibling::div[1]/div[7]"))
//				.click();
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[2]//following-sibling::div[2]/div[1]"))
//				.click();
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
//		Thread.sleep(1000);
	}

	@Then("select the procedure room for op procedure appointment")
	public void select_the_procedure_room_for_op_procedure_appointment() throws Exception {
//		// clicking on the procedure rooms
//		driver.findElement(By.xpath("//span[@class='selection'][1]")).click();
//		Thread.sleep(1000);
//		// selecting the room
//		driver.findElement(By.xpath("//li[text()='454']")).click();
//		Thread.sleep(2000);

	}

	@When("user click on submit button")
	public void user_click_on_submit_button() throws Exception {
		// continue
		driver.findElement(By.cssSelector("input#continue-ot")).click();
		Thread.sleep(2000);
	}

	@Then("from team popup select the therapist_leaddoctor_supportingdoctor_counsellor")
	public void from_team_popup_select_the_therapist_leaddoctor_supportingdoctor_counsellor() throws Exception {
		// clicking on the nurse
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Sunil')])[1]")).click();
		Thread.sleep(2000);
		// clicking on the doctor
		driver.findElement(By.cssSelector("input#op_patient_detail_referred_by")).click();
		Thread.sleep(1000);
		// nh doctor
		driver.findElement(By.xpath("(//a[contains(text(),'Dr. Doctor One')])[1]")).click();
		Thread.sleep(1000);
//		// supporting doctor
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[1]/div[2]/form/ul/li[2]/div[2]/div[4]/div/div[3]/span/span[1]/span/ul/li/input")).click();
//		Thread.sleep(1000);
//		// dr harshita
//		driver.findElement(By.xpath("//li[text()='Dr. Manager T']")).click();
//		Thread.sleep(1000);
////		// clicking on the counsellor
////		driver.findElement(By.xpath(
////				"/html/body/main/div/div[4]/div[1]/div[2]/form/ul/li[2]/div[2]/div[5]/div/div[3]/span/span[1]/span"))
////				.click();
////		Thread.sleep(1000);
////		// selecting the counsellor
////		driver.findElement(By.xpath("//li[text()='Anita Sharma']")).click();
////		Thread.sleep(1000);

	}

	@And("click on continue button from team")
	public void click_on_continue_button_from_team() throws InterruptedException {
		// continue
		driver.findElement(By.xpath("(//input[@id='continue-team'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("enter the nursing and additional charges")
	public void enter_the_nursing_and_additional_charges() throws Exception {
		// nursing charges
		driver.findElement(By.xpath("(//input[@id='op_patient_detail_nursing_chrge'])[1]")).sendKeys("1");
		Thread.sleep(1000);
		// additional charges
		driver.findElement(By.xpath("(//input[@id='additional_charges'])[1]")).sendKeys("1");
		Thread.sleep(1000);

	}

	@And("click on the submit button from opprocedure invoice page")
	public void click_on_the_submit_button_from_opprocedure_invoice_page() throws Exception {
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(2000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
	}

	@Then("proformainvoice page will be opened for opprocedure")
	public void proformainvoice_page_will_be_opened_for_opprocedure() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)");
		Thread.sleep(2000);
		// clicking on the proceed button to add amount discount
		driver.findElement(By.xpath("(//input[@id='promo_amnt'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Proceed'])[1]")).click();
		Thread.sleep(3000);
		// paying remaining due amount using amount discount
		driver.findElement(By.xpath("(//input[@id='promo_amnt'])[1]")).sendKeys("60");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@id='applyCouponModal'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//textarea[@id='comments'])[1]"))
				.sendKeys("Paid partial amount using amount discount");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='applyCouponBtn'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='bookLater'])[1]")).click();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Pay Balance'])[1]"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 400)");
		Thread.sleep(2000);
		// clicking on the proceed button to add amount discount
		driver.findElement(By.xpath("(//input[@name='promo_amnt'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Proceed'])[1]")).click();
		Thread.sleep(3000);
		// paying remaining due amount using amount discount
		driver.findElement(By.xpath("(//input[@id='promo_amnt'])[1]")).sendKeys("60");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@id='applyCouponModal'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//textarea[@id='comments'])[1]"))
				.sendKeys("Paid partial amount using amount discount");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='applyCouponBtn'])[1]")).click();
		Thread.sleep(2000);
//				Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the submit button
		driver.findElement(By.xpath("(//button[@id='bookNowBtn'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("select the paymentmethods7")
	public void select_the_paymentmethods7() throws InterruptedException {
//		// cash
//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(1000);
	}

	@When("user enters_the transaction_amount for opprocedure then receipt_comment will visible")
	public void user_enters_the_transaction_amount_for_opprocedure_then_receipt_comment_will_visible()
			throws InterruptedException {
//		// entering amount
//		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("120");
//		Thread.sleep(2000);
	}

	@Then("click on receipt_comment and enter_comment for opprocedure appointment")
	public void click_on_receipt_comment_and_enter_comment_for_opprocedure_appointment() {
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("receipt comment for minor procedure");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the submit button inthe proformainvoice7")
	public void click_on_the_submit_button_inthe_proformainvoice7() throws Exception {
//		// submit
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
////		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf7")
	public void download_the_invoice_receipt_totaladvance_printpdf7() throws InterruptedException, Exception {
//		// generate the invoice
//		Actions id = new Actions(driver);
//		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]"))).build()
//				.perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
//		Thread.sleep(2000);
//		// converting to tax invoice
//		Actions taxinv = new Actions(driver);
//		taxinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")))
//				.build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")).click();
//		Thread.sleep(4000);
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
//		// receipt id
//		driver.findElement(By.xpath("(//a[@format='pdf'])[1]")).click();
//		Thread.sleep(2000);
//		Actions receipt = new Actions(driver);
//		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
//		Thread.sleep(2000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
	}

	@Then("click on shareinvoice7 button")
	public void click_on_shareinvoice7_button() throws InterruptedException {
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);

	}

	@And("clears existing mail and phone for opprocedure")
	public void clears_existing_mail_and_phone_for_opprocedure() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enter mail and click on submit button for shareinvoice7")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice7() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement submit = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		submit.click();
		Thread.sleep(10000);
//		// clicking on the appointments
//		driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@id='admin-opsurgeries'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[contains(text(),'Confirmed')])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Oppatient')]]//a[@data-tooltip='Pharmacy Consumptions']/img[1][1]"))
//				.click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Central Pharmacy'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Brand Name'])[1]/preceding-sibling::textarea[1]"))
//				.sendKeys("Sunil");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[@class='btn green tooltipped medicineAvail'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input[1]")).sendKeys("5");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::textarea[1]")).sendKeys("A");
//		Thread.sleep(3000);
//		// remove
//		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
//		Thread.sleep(1000);
//		// save
//		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
//		Thread.sleep(2000);

	}

	@When("user click on patientsname from opprocedure proformainvoicepage")
	public void user_click_on_patientsname_from_opprocedure_proformainvoicepage() throws Exception {

		/*
		 * driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		 * Thread.sleep(2000); // close for pending amount if
		 * (driver.findElement(By.xpath(
		 * "(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed())
		 * { driver.findElement(By.xpath(
		 * "(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		 * Thread.sleep(2000); //
		 * driver.findElement(By.id("admin-billing-tab")).click(); Thread.sleep(2000); }
		 */

		driver.findElement(By.id("frst_nm")).sendKeys("Cucumoppatient");
		Thread.sleep(10000);
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
		}

	}

	@Then("patientprofile  will opened after opprocedure appointment")
	public void patientprofile_will_opened_after_opprocedure_appointment() throws InterruptedException {
	}

	@When("user click on bookdoctorappointment from book appointment")
	public void user_click_on_bookdoctorappointment_from_book_appointment() throws Exception {
		// mouse hover on the doc booking
		Actions doc = new Actions(driver);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// clicking on the doctor appointment
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]")).click();
		Thread.sleep(2000);

	}

	@Then("list of avaible doctors list will be displayed")
	public void list_of_avaible_doctors_list_will_be_displayed() {
//		System.out.println("list of available doctors list is displayed");
	}

	@And("select the doctor and click on book appointment")
	public void select_the_doctor_and_click_on_book_appointment() throws Exception {
		// clicking on the book appointment
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
		Thread.sleep(2000);

	}

	@Then("select the type for doctorappointment")
	public void select_the_type_for_doctorappointment() throws Exception {
		// selecting the type - video type
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(2000);

	}

	@And("select the dateandtime and slot for doctor appointment")
	public void select_the_dateandtime_and_slot_for_doctor_appointment() throws Exception {
//		// selecting the date and time - tomorrow
//		driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")).click();
//		Thread.sleep(2000);

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

	}

	@Then("we can change the slottime here for doctorappointment")
	public void we_can_change_the_slottime_here_for_doctorappointment() throws Exception {
		// clicking on the slot time
		driver.findElement(By.xpath("(//input[@id='appointment_tracking_slot_time'])[1]")).click();
		Thread.sleep(1000);
		// 6
		driver.findElement(By.xpath("//div[@class='timepicker-canvas']/following-sibling::div[1]/div[11]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(2000);
	}

	@And("select the registrationfees_notifypatients checkboxes")
	public void select_the_registrationfees_notifypatients_checkboxes() throws Exception {
//		WebElement fee = driver.findElement(By.xpath("//label[text()='50']"));
//		fee.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);

	}

	@Then("click on the submit button from payment popup")
	public void click_on_the_submit_button_from_payment_popup() throws Exception {
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
//		Robot robot12 = new Robot();
//		for (int i = 0; i < 4; i++) {
//			robot12.keyPress(KeyEvent.VK_CONTROL);
//			robot12.keyPress(KeyEvent.VK_ADD);
//			Thread.sleep(1000);
//			robot12.keyRelease(KeyEvent.VK_ADD);
//			robot12.keyRelease(KeyEvent.VK_CONTROL);
//		}
//		Thread.sleep(2000);
//		Robot robot3 = new Robot();
//		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);

	}

	@And("applying discount for five percentage and entering the comments")
	public void applying_discount_for_five_percentage_and_entering_the_comments() throws Exception {
		// adding 10% discount
		driver.findElement(By.cssSelector("input#promo_disc")).sendKeys("10");
		Thread.sleep(2000);
		// adding comment for the discount
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("10% discount for the doctor appointment");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#applyCouponBtn")).click();
		Thread.sleep(2000);
	}

	@Then("paying the remaining balance and entering the comments")
	public void paying_the_remaining_balance_and_entering_the_comments() throws Exception {
		// entering the cash
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1440");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		Thread.sleep(2000);
		/*
		 * // clicking yes on the payment update popup
		 * driver.findElement(By.cssSelector("input#negotiableYes")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.cssSelector("i#paymentComment")).click();
		 * Thread.sleep(2000);
		 */ driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("Remaining balance amt paid.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='modal-close btn green right payCmntOk'])[1]")).click();
		Thread.sleep(2000);

//		// selecting the cash rad.btn
//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(1000);
//		// entering the amount
//		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("250");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment 1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		WebElement cash = driver.findElement(By.xpath("(//label[text()='Redeem'])[1]"));
//		cash.click();
//		Thread.sleep(2000);
	}

	@Then("click on receipt_comment and enter_comment for doctor appointment")
	public void click_on_receipt_comment_and_enter_comment_for_doctor_appointment() {
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("click on the submit button inthe proformainvoice8")
	public void click_on_the_submit_button_inthe_proformainvoice8() throws Exception {
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf8")
	public void download_the_invoice_receipt_totaladvance_printpdf8() throws Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the receipt id 2
		// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[2]/a")).click();
		// Thread.sleep(3000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);

	}

	@When("user click on the back button from the doctor appointment profoma invoice")
	public void user_click_on_the_back_button_from_the_doctor_appointment_profoma_invoice() throws Exception {
//		driver.findElement(By.xpath("//a[text()='Back']")).click();
//		Thread.sleep(2000);
	}

	@Then("it will redirect to the doctor appointment page")
	public void it_will_redirect_to_the_doctor_appointment_page() {
	}

	@And("click on the confirmed status for doctor in the appointments")
	public void click_on_the_confirmed_status_for_doctor_in_the_appointments() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-doc-consultations'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the confirmed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped"))))
				.click();
//		driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped")).click();
		Thread.sleep(2000);
	}

	@Then("click on the first patients appointment id")
	public void click_on_the_first_patients_appointment_id() throws Exception {
		// clicking on the first patient id
		WebElement pat = driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a"));
		pat.click();
		Thread.sleep(2000);
	}

	@And("click on the cancel button from the popup")
	public void click_on_the_cancel_button_from_the_popup() throws Exception {
		// clicking on the cancel
		driver.findElement(By.xpath("(//a[text()='Cancel'])[3]")).click();
		Thread.sleep(1000);
	}

	@Then("from cancel appointment popup enter the cancellation reason")
	public void from_cancel_appointment_popup_enter_the_cancellation_reason() throws Exception {
		// cancel reason
		driver.findElement(By.id("comments")).sendKeys("test reason");
		Thread.sleep(1000);
	}

	@And("click on the refund button from cancel appointment popup")
	public void click_on_the_refund_button_from_cancel_appointment_popup() throws Exception {
		// clicking on the refund
		driver.findElement(By.xpath("(//a[text()='Refund'])[1]")).click();
		Thread.sleep(1000);
		Robot robot111 = new Robot();
		robot111.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("it will redirect to the proformainvoice for refund")
	public void it_will_redirect_to_the_proformainvoice_for_refund() {
	}

	@And("select the paymentmethod for refund")
	public void select_the_paymentmethod_for_refund() throws Exception {
		WebElement cash1 = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash1.click();
		Thread.sleep(1000);

	}

	@Then("enter the  amount for refund")
	public void enter_the_amount_for_refund() throws Exception {
		// entering the cash
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1440");
		Thread.sleep(1000);
	}

	@When("receipt comment is visible")
	public void receipt_comment_is_visible() {

	}

	@Then("click on it and enter the receipt comment and click on ok")
	public void click_on_it_and_enter_the_receipt_comment_and_click_on_ok() throws Exception {
		// clicking on the receipt comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		Thread.sleep(2000);
		// entering the reason
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test reason");
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@And("enter the refund reason and click on ok")
	public void enter_the_refund_reason_and_click_on_ok() throws Exception {
		// entering the refund reason
		driver.findElement(By.cssSelector("textarea#refund_rsn")).sendKeys("refund reason");
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.refundOk")).click();
		Thread.sleep(2000);
	}

	@Then("click on the submit button from the refund proformainvoice page")
	public void click_on_the_submit_button_from_the_refund_proformainvoice_page() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		// driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);

	}

	@And("download the invoice_receiptIDs_totaladvance_printpdf from the refund proformainvoice page")
	public void download_the_invoice_receiptIDs_totaladvance_printpdf_from_the_refund_proformainvoice_page()
			throws Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		/*
		 * Robot robot2 = new Robot(); robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		 * Thread.sleep(1000);
		 */
		/*
		 * // Store main window ONLY ONCE String mainWindow = driver.getWindowHandle();
		 * // ===== FIRST TAB =====
		 * driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		 * Thread.sleep(3000); // Switch to new tab for (String window :
		 * driver.getWindowHandles()) { if (!window.equals(mainWindow)) {
		 * driver.switchTo().window(window); break; } } Thread.sleep(2000); // Close new
		 * tab driver.close(); Thread.sleep(2000); // Switch back to main window
		 * driver.switchTo().window(mainWindow); Thread.sleep(2000); // ===== SECOND TAB
		 * =====
		 * driver.findElement(By.xpath("(//a[contains(text(),'R-')])[2]")).click();
		 * Thread.sleep(3000); // Switch again to new tab for (String window :
		 * driver.getWindowHandles()) { if (!window.equals(mainWindow)) {
		 * driver.switchTo().window(window); break; } } Thread.sleep(2000); // Close new
		 * tab driver.close(); Thread.sleep(2000); // Switch back AGAIN safely
		 * driver.switchTo().window(mainWindow); Thread.sleep(3000);
		 */
		
		
		
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 400)");
//		Thread.sleep(2000);		
//		// ===== CONTINUE YOUR FLOW =====
//		Actions receipt = new Actions(driver);
//		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")))
//		       .build()
//		       .perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(5000);

	}

	@When("user click on patientsname from refund proformainvoicepage")
	public void user_click_on_patientsname_from_refund_proformainvoicepage() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(2000);
			try {
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		Thread.sleep(2000);
	}

	@Then("patientprofile  will opened after refund proformainvoicepage")
	public void patientprofile_will_opened_after_refund_proformainvoicepage() throws Exception {
		Actions dialysis = new Actions(driver);
		dialysis.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Dialysis'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		dialysis.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Dialysis'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
	}

	@When("patient profile is opened click on the book dialysis")
	public void patient_profile_is_opened_click_on_the_book_dialysis() throws Exception {
		// selecting the procedure date
		driver.findElement(By.xpath("(//input[@id='op_patient_detail_admission_dt'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]")).click();
		Thread.sleep(1000);
		LocalDate today = LocalDate.now();
		String currentMonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		Thread.sleep(1000);
		// Select current month dynamically
		driver.findElement(By.xpath("//li/span[text()='" + currentMonth + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(2000);

	}

	@Then("select the procedure date and start end time")
	public void select_the_procedure_date_and_start_end_time() throws Exception {
		// selecting the procedure start time
		driver.findElement(By.xpath("(//input[@id='start_time'])[1]")).click();
		Thread.sleep(1000);
		// 11pm
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")).click();
		Thread.sleep(1000);
		// 00
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// pm
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[2]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='timepicker-footer'])[1]/div[1]/button[2]")).click();
		Thread.sleep(1000);
		// selecting the procedure end time
		driver.findElement(By.xpath("(//input[@id='end_time'])[1]")).click();
		Thread.sleep(1000);
		// 11pm
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[12]")).click();
		Thread.sleep(1000);
		// pm
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='timepicker-footer'])[2]/div[1]/button[2]")).click();
		Thread.sleep(1000);

	}

	@And("click on the continue button from the dates popup")
	public void click_on_the_continue_button_from_the_dates_popup() throws Exception {
		driver.findElement(By.xpath("(//input[@id='continue-ot'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the lead doctor and click on the continue button")
	public void select_the_lead_doctor_and_click_on_the_continue_button() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='continue-team'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the submit button from invoice popup")
	public void click_on_the_submit_button_from_invoice_popup() throws Exception {
		driver.findElement(By.xpath("(//input[@id='btn-loader'])[1]")).click();
		Thread.sleep(3000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("enter the amount and generate the invoice id for the invoice")
	public void enter_the_amount_and_generate_the_invoice_id_for_the_invoice() throws Exception {
		driver.findElement(By.xpath("(//input[@id='advance_field'])[1]")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt"))
				.sendKeys("receipt comment for 100 rupees for payment method cash");
		Thread.sleep(1000);
		// ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")).click();
		Thread.sleep(1000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		Thread.sleep(3000);
	}

	@And("download the invoice receipt and share invoice to the mail")
	public void download_the_invoice_receipt_and_share_invoice_to_the_mail() throws Exception {
		// generate the invoice
		Actions id = new Actions(driver);
		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(2000);
		// converting to tax invoice
		Actions taxinv = new Actions(driver);
		taxinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")).click();
		Thread.sleep(4000);
		// download invoice
		Actions inv = new Actions(driver);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(5000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// receipt download
		WebElement receipt1 = driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]"));
		JavascriptExecutor rpt1 = (JavascriptExecutor) driver;
		rpt1.executeScript("arguments[0].scrollIntoView(true)", receipt1);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
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
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			// driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(1000);
		}
	}

	@When("user click on addprogram from book appointment")
	public void user_click_on_addprogram_from_book_appointment() throws Exception {

		/*
		 * // // selecting Role clicking on clinic manager driver.findElement(By.
		 * xpath("(//div[normalize-space(text())='Clinic Manager - NanoHealth_OPD'])[1]"
		 * )).click(); // Thread.sleep(3000); // //
		 * driver.findElement(By.id("frst_nm")).sendKeys("Cucumoppatient"); //
		 * Thread.sleep(10000); // // clicking on the patient name //
		 * driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click(
		 * ); // Thread.sleep(3000); // // // clicking on the view profile // //
		 * driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click(); //
		 * Thread.sleep(3000); // // close for pending amount // if
		 * (driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i"))
		 * .isDisplayed()) { //
		 * driver.findElement(By.xpath("//*[@id=\"invoice_modal\"]/div/div[1]/span/i")).
		 * click(); Thread.sleep(1000); }
		 */

		// mouse hover on the program booking
		Actions pro = new Actions(driver);
		pro.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])/img[1]"))).build().perform();
		Thread.sleep(1000);
		// clicking on the add program
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])/img[1]")))).click();
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(15)>img")).click();
		Thread.sleep(3000);
	}

	@Then("it will display the programs")
	public void it_will_display_the_programs() {
	}

	@And("select the programs and remove one of the program")
	public void select_the_programa_and_remove_one_of_the_program() throws Exception {
		// clicking on the plus
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the plus
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(2000);
		// removing the last added program
		driver.findElement(By.xpath("(//i[text()='remove'])[4]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the checkout for the program booking")
	public void click_on_the_checkout_for_the_program_booking() throws Exception {
		// checkout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.waves-effect.btn.checkout.btn-block")))).click();
//		driver.findElement(By.cssSelector("a.waves-effect.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
	}

	@And("select addreferredby and select the program start date")
	public void select_addreferredby_and_select_the_program_start_date() throws Exception {
		// referred by
		driver.findElement(By.xpath("(//label[text()='Referred By'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);

		// start date
		driver.findElement(By.xpath("(//input[@class='pick-date stdt'])[1]")).click();
		Thread.sleep(1000);
		// Click on Year dropdown
		driver.findElement(By.xpath("(//div[@class='select-wrapper select-year'])[1]/input[1]")).click();
		Thread.sleep(1000);
		LocalDate today = LocalDate.now();
		String currentYear = String.valueOf(today.getYear());
		Thread.sleep(1000);
		// Select current year dynamically
		driver.findElement(By.xpath("//li/span[text()='" + currentYear + "']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[@class='select-wrapper select-month'])[1]/input[1]")).click();
		Thread.sleep(1000);
		LocalDate today1 = LocalDate.now();
		String currentMonth = today1.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		Thread.sleep(1000);
		// Select current month dynamically
		driver.findElement(By.xpath("//li/span[text()='" + currentMonth + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		// driver.findElement(By.xpath("//button[text()='21']")).click();
		Thread.sleep(3000);
		// click on the activity list
		driver.findElement(By.xpath("(//img[@data-tooltip='View activity list'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the back button
		driver.findElement(By.xpath("(//span[text()='Back'])[2]")).click();
		Thread.sleep(3000);
		WebElement existinginv = driver.findElement(By.xpath("(//label[text()='Existing Invoice'])[1]"));
		existinginv.click();
		Thread.sleep(2000);
		// Store the main window handle
		String mainWindow = driver.getWindowHandle();

		// Click on the OP number link (which opens PDF in a new tab)
		WebElement opLink = driver.findElement(By.xpath("(//a[contains(text(),'OP-')])[1]"));
		opLink.click();

		// Wait until a new tab is opened
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver1 -> driver1.getWindowHandles().size() > 1);

		// Get all window handles after new tab opens
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				// Switch to the new tab
				driver.switchTo().window(windowHandle);

				// Optional: wait for the PDF or page to load
				Thread.sleep(2000);

				// ✅ Close the new tab
				driver.close();

				// ✅ Switch back to main window
				driver.switchTo().window(mainWindow);
				break;
			}
		}
		Thread.sleep(5000);
//		WebElement exstinvclick = driver
//				.findElement(By.xpath("//a[contains(text(),'OP-')]/parent::label/preceding-sibling::input[1]"));
//		exstinvclick.click();
//		Thread.sleep(2000);
		WebElement radio = driver
				.findElement(By.xpath("//a[contains(text(),'OP-')]/parent::label/preceding-sibling::input[1]"));

		// Scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
		Thread.sleep(500);

		// Force click using JS (cannot be intercepted)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);

	}

	@Then("click on the submit button from select invoice of addprogram booking")
	public void click_on_the_submit_button_from_select_invoice_of_addprogram_booking() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input#btn-loader")).click();
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("select the paymentmethods10")
	public void select_the_paymentmethods10() throws Exception {
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
	}

	@When("user enters_the transaction_amount for program then receipt_comment will visible")
	public void user_enters_the_transaction_amount_for_program_then_receipt_comment_will_visible() throws Exception {
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("10");
		Thread.sleep(1000);
	}

	@Then("click on receipt_comment and enter_comment for program appointment")
	public void click_on_receipt_comment_and_enter_comment_for_program_appointment() throws Exception {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);

	}

	@Then("click on the submit button inthe proformainvoice10")
	public void click_on_the_submit_button_inthe_proformainvoice10() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf10")
	public void download_the_invoice_receipt_totaladvance_printpdf10() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
//		Thread.sleep(2000);

		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		Thread.sleep(3000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
	}

	@Then("click on shareinvoice10 button")
	public void click_on_shareinvoice10_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for program")
	public void clears_existing_mail_and_phone_for_program() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enter mail and click on submit button for shareinvoice10")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice10() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub.click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]")).click();
		Thread.sleep(5000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			try {
				// driver.findElement(By.id("admin-billing-tab")).click();
				// Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// click on the pharmacy order
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Pharmacy Order'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Pharmacy Order'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Doctor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
		WebElement brandInput = driver.findElement(By.xpath(
				"(//textarea[@id='prescription_sale_order_header_prescription_order_lines_attributes_0_brand_name'])[1]"));

		String text = "Sunil";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(2000);
		// selecting the batch
		driver.findElement(By.xpath("(//a[contains(text(),'1304(Dec-36')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input[1]")).sendKeys("5");
		Thread.sleep(2000);
		// deliver
		WebElement deliverButton = driver.findElement(By.xpath("(//input[@value='Delivery'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deliverButton);
		Robot pgdwn13 = new Robot();
		pgdwn13.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("50");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//				driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
//		// generate invoice
//		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
//		Thread.sleep(3000);

		// printing
		driver.findElement(By.xpath("(//a[@class='tooltipped service_wise_pdf'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		Thread.sleep(3000);
		// clicking on the total receipt
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// clicking on the print
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// clicking on the print without details
		driver.findElement(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i[1]")).click();
		Thread.sleep(5000);
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement sub1 = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub1.click();
		Thread.sleep(10000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]")).click();
		Thread.sleep(5000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			try {
				// driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@And("create a dynamic op package")
	public void create_a_dynamic_op_package() throws Exception {
		// clicking on the add program
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Program'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#pckg_nm")).sendKeys("Cucum testpackage");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='duration'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='duration'])[1]")).sendKeys("31");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Sync Data'])[1]/i[1]")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Diagnostic");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Diagnostics'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Diagnostic");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Diagnostics'])[2]")).click();
		Thread.sleep(2000);
		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//label[text()='Frequency'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weekly'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='repeat_count'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='repeat_count'])[1]")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Monday')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Wednesday')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Friday')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Sunday')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//label[text()='WeekDay'])[1]/following-sibling::select[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='repeat_count'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='repeat_from'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='repeat_start_time'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		// mouse-hovering on the i icon
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Doctor");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Doctor')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='invoice_search'])[1]")).sendKeys("Minor");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Minor')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='pkg_price'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='pkg_price'])[1]")).sendKeys("1000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='advance_field'])[1]")).sendKeys("1000");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
		// generate the invoice
		Actions id = new Actions(driver);
		id.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(2000);
		// converting to tax invoice
		Actions taxinv = new Actions(driver);
		taxinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]")).click();
		Thread.sleep(4000);
		// OP invoice
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
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
		Thread.sleep(10000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[@class='btn-loader profile_nav'])[1]")).click();
		Thread.sleep(5000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			try {
				// driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// clicking on the programs
		driver.findElement(By.xpath("(//a[contains(text(),'Programs')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Cucum testpackage'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the book button
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//table[@id='example']//tr[td[normalize-space()='Dr. Doctor One']][1]/td[7]/a[1]"))
				.click();
		Thread.sleep(3000);
		// Switch to child tab
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		// clicking on the book appointment
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait11.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)"))))
				.click();
//												driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
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
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//				// clicking on the notify
//				WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
//				gmail.click();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//				WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
//				sms.click();
		Thread.sleep(1000);
		// clicking on the submit
		element.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#bookNowBtn"))).click();
		Thread.sleep(5000);
		// Close child tab & return
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			try {
				// driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// clicking on the programs
		driver.findElement(By.xpath("(//a[contains(text(),'Programs')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Cucum testpackage'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		Thread.sleep(3000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		// closing the package popup
		driver.findElement(By.xpath("(//div[@id='package-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
	}

	@And("merge the invoices from the history")
	public void merge_the_invoices_from_the_history() throws Exception {
		driver.findElement(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='More Appointments'])[1]/i[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@id='ptnt_history'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the invoice
		driver.findElement(By.xpath("(//a[@id='clinic_patient_inv_hstry'])[2]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			try {
				// driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		driver.findElement(By.xpath("(//a[@data-tooltip='Merge Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//form[@id='merge_invoices'])[1]/div[1]/div[1]/div[1]/div[1]/label[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='saveDateInvoice'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the invoice op number
		driver.findElement(By.xpath("(//div[@class='invoice_container op_nmbr'])[1]/a[1]")).click();
		Thread.sleep(5000);
//		// downloading print invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(3000);
//		// clicking on the appointment id
		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		Thread.sleep(3000);
		// closing popup
//		driver.findElement(By.xpath("(//div[@id='schdlApmntsModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//		Thread.sleep(3000);
//		// clicking on the invoice op number
//		driver.findElement(By.xpath("(//a[contains(text(),'OP-')])[2]")).click();
//		Thread.sleep(5000);
		driver.close();
	}

}
