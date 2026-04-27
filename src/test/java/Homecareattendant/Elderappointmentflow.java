package Homecareattendant;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

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

public class Elderappointmentflow {
	WebDriver driver = null;

	@Given("navigates to the NH url {string}")
	public void launchBrowser(String url) {
//		public void navigating_to_the_n_hurl(String string) {
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

	@Then("enter email4 {string} password4 {string}")
	public void enter_email4_password4(String email4, String password4) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(email4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password4);
		Thread.sleep(5000);
	}

	@And("signinbutton was clicked")
	public void signin_button_was_clicked() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();

	}

	@And("delete the existing elder from the cdpadmin role and click on the brand logo to change role")
	public void delete_the_existing_elder_from_the_cdpadmin_role_and_click_on_the_brand_logo_to_change_role()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("9988771132");
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

	@Then("selecting the profile for manager role")
	public void selecting_the_profile_for_manager_role() throws Exception {
		// selecting the role as clinic manager
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[normalize-space(text())='ClinicManager - Delhi'])[1]"))).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@And("click on register elder icon for register new elder")
	public void click_on_register_elder_icon_for_register_new_elder() throws Exception {
		Thread.sleep(2000);
		WebDriverWait addpatient = new WebDriverWait(driver, Duration.ofSeconds(30));
		addpatient
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Elder'])[2]/img[1]"))))
				.click();
		Thread.sleep(3000);

	}

	@Then("enter the details for the elder registration")
	public void enter_the_details_for_the_elder_registration() throws Exception {
		// selecting the title
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='first_name'])[1]")))
				.sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='lst_name'])[1]")))
				.sendKeys("elderflow");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='age'])[1]"))).sendKeys("60");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// country code
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[5]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='+91']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nmbr"))).sendKeys("9988771132");
		Thread.sleep(2000);
//		// clicking on the add new address
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Address'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input#address_detail_address_line1")).sendKeys("Hyderabad");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.cssSelector("input#address_detail_address_line2")).sendKeys("Hyderabad");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.cssSelector("input#address_detail_area")).sendKeys("Telecom nagar");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.cssSelector("input#address_detail_landmark")).sendKeys("Gachibowli");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// city
//		driver.findElement(By.xpath("(//span[@class='selection'])[11]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Hyderabad'])[1]")).click();
//		Thread.sleep(1000);
//		// district
//		driver.findElement(By.xpath("(//input[@id='dist_nm'])[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//input[@id='dist_nm'])[1]")).sendKeys("testdist");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// pincode
//		driver.findElement(By.xpath("(//input[@id='address_detail_pin_code'])[1]")).sendKeys("500034");
//		Thread.sleep(2000);
//		// clicking on the location icon
//		try {
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			WebElement element = driver.findElement(By.xpath("(//div[@class='input-field col s12 m4'])[1]/a/img[1]"));
//			jse.executeScript("arguments[0].click();", element);
//			Thread.sleep(10000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		driver.findElement(By.xpath("(//input[@id='pac-input'])[1]")).sendKeys("nanohealth");
//		Thread.sleep(3000);
//		Robot pgdwn = new Robot();
//		pgdwn.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		pgdwn.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='saveLoc'])[1]")).click();
//		Thread.sleep(2000);
//		// clicking on the submit button from add new address popup
//		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='address-line1'])[1]")))
				.sendKeys("Test1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='adrs_line2'])[1]")))
				.sendKeys("Test2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='landmark'])[1]")))
				.sendKeys("Landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='city'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='city'])[1]"))).sendKeys("Test city");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='district'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='district'])[1]")))
				.sendKeys("Test district");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pn_cd'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pn_cd'])[1]"))).sendKeys("989898");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// selecting demand program
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='selection'])[6]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Emoha'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("click on the submit button to register elder")
	public void click_on_the_submit_button_to_register_elder() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='update_submit'])[1]"))).click();
		Thread.sleep(5000);
	}

	@When("elder is registered then patient profile will be opened")
	public void elder_is_registered_then_patient_profile_will_be_opened() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//a[@data-tooltip='Transfer'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@value='Transfer'])[1]")).click();
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//		Thread.sleep(3000);
		// adding address
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Address'])[1]/img[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]/div[2]/div[1]/a[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='address_detail_area'])[1]")))
				.sendKeys("test area");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[7]/div/div[2]/form/div[3]/div[3]/a/img")))
				.click();
		Thread.sleep(3000);
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='pac-input'])[1]"));
		String text = "NanoHealth";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
//		driver.findElement(By.xpath("(//input[@id='pac-input'])[1]")).sendKeys("NanoHealth");
//		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveLoc'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(3000);
		// closing the address popup
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='modalAddressList'])[1]/div[1]/div[1]/span[1]/i[1]")))
				.click();
		Thread.sleep(3000);
	}

	@Then("assing care team from the patient profile through care team icon")
	public void assing_care_team_from_the_patient_profile_through_care_team_icon() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Care team'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Care team'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Provider Type'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'HomeCare')])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[contains(text(),'Sunil K (sunilkhc@nh.com)')])[1]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("book the home care attendant appointment to the registered elder")
	public void book_the_home_care_attendant_appointment_to_the_registered_elder() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		/*
		 * // selecting the role as clinic manager driver.findElement(By.
		 * xpath("(//div[normalize-space(text())='ClinicManager - Delhi'])[1]")).click()
		 * ; Thread.sleep(5000);
		 * driver.findElement(By.id("frst_nm")).sendKeys("9988771131");
		 * Thread.sleep(5000); // clicking on the patient name
		 * driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click(
		 * ); Thread.sleep(3000); // clicking on the view profile
		 * 
		 * driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		 * Thread.sleep(3000);
		 */

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Attendant'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[@data-tooltip='Book Home Attendant'])[1]/img[1]"))).click();
		Thread.sleep(3000);
		// clicking on the homecare attendant
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h6[text()='Home Attendant'])[1]"))).click();
		Thread.sleep(3000);
		// selecting the address
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='saved-addresses'])[2]"))).click();
		Thread.sleep(2000);
		// repeat
		WebElement repeat1 = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat1.click();
		Thread.sleep(1000);
		// once
		WebElement once = driver.findElement(By.xpath("(//label[text()='Once'])[1]"));
		once.click();
		Thread.sleep(1000);
		// repeat
		WebElement repeat11 = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat11.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Frequency'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Daily'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='repeat_count'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='repeat_count'])[1]")))
				.sendKeys("10");
		Thread.sleep(1000);
		// start date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='repeat_from'])[1]"))).click();
		Thread.sleep(1000);
		// today date is selected
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]/button[1]"))).click();
		Thread.sleep(1000);
		// selecting start time and end time
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='repeat_start_time'])[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]")))
				.click();
		Thread.sleep(1000);
		//
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='repeat_end_time'])[1]"))).click();
		Thread.sleep(2000);
		// 11
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[1]/div[2]/div[11]")))
				.click();
		Thread.sleep(1000);
		// 55
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[1]/div[3]/div[12]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Continue')])[1]")))
				.click();
		Thread.sleep(3000);
		// enable the checkboxes
		WebElement checkbox1 = driver.findElement(By.xpath("(//ul[@id='myUL'])[1]/li[1]/div[1]/div[1]/label[1]"));
		checkbox1.click();
		Thread.sleep(1000);
		WebElement checkbox2 = driver.findElement(By.xpath("(//ul[@id='myUL'])[1]/li[2]/div[1]/div[1]/label[1]"));
		checkbox2.click();
		Thread.sleep(1000);
		WebElement checkbox3 = driver.findElement(By.xpath("(//ul[@id='myUL'])[1]/li[3]/div[1]/div[1]/label[1]"));
		checkbox3.click();
		Thread.sleep(1000);
		WebElement removechckbox = driver.findElement(By.xpath("(//ul[@id='myUL'])[1]/li[3]/div[1]/div[1]/label[1]"));
		removechckbox.click();
		Thread.sleep(2000);
		// clicking on the time for first task
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='service_time timepicker'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]")))
				.click();
		Thread.sleep(2000);
		// clicking on the continue
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Continue')])[2]")))
				.click();
		Thread.sleep(2000);
	}

	@Then("change the daily rate amount in the popup and select paylatet")
	public void change_the_daily_rate_amount_in_the_popup_and_select_paylatet() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// changing daily rate amount
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='sales_price'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='sales_price'])[1]")))
				.sendKeys("500" + Keys.TAB + Keys.TAB);
		Thread.sleep(1000);
		// clicking on the submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='bookNowBtn'])[1]"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// pay - later
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='bookLater'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the dashboard
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-dashboard'])[2]"))).click();
		Thread.sleep(3000);
		// clicking on the due amount
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='due'])[1]"))).click();
		Thread.sleep(3000);

	}

	@Then("pay the amount generate the invoice and share donwload the inovice")
	public void pay_the_amount_generate_the_invoice_and_share_donwload_the_inovice() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement owner1 = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Elderflow')]]/td[8]/span[1]/following-sibling::a[1]"));
		owner1.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// pay now
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='advance_field'])[1]")))
				.sendKeys("5000");
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='bookNowBtn'])[1]"))).click();
		Thread.sleep(5000);
		// GENERATE INV....
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]")))
				.click();
		Thread.sleep(3000);
		// printing
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.tooltipped.service_wise_pdf>img")))
				.click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]"))).click();
		Thread.sleep(3000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the print
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf"))).click();
		Thread.sleep(3000);
		// clicking on the print without details
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i")))
				.click();
		Thread.sleep(3000);
		// clicking on the share invoice
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emails"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phone"))).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clicking on the submit button
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"))).click();
		Thread.sleep(10000);
	}

	@And("open patient profile and assign the carer to the elder tasks")
	public void open_patient_profile_and_assign_the_carer_to_the_elder_tasks() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the patient name to open patient profile
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]"))).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);

		for (int i = 0; i <= 2; i++) {
			WebElement taskcbox1 = driver
					.findElement(By.xpath("(//tbody[@class='programs_row'])[1]/tr[1]/td[1]/label[1]"));
			taskcbox1.click();
			Thread.sleep(2000);
		}
		// clicking on the assign button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Assign'])[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Carer'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//li[contains(text(),'Sunil K (sunilkhc@nh.com)')])[1]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost'])[1]")))
				.sendKeys("0");
		Thread.sleep(1000);
		String dupregid = driver.findElement(By.xpath("(//span[@id='cost_error'])[1]")).getText();
		System.out.println("Validation for price entered 0:" + dupregid);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='submit'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost'])[1]")))
				.sendKeys("10000");
		Thread.sleep(1000);
		String dupregid1 = driver.findElement(By.xpath("(//span[@id='cost_error'])[1]")).getText();
		System.out.println("Validation for price entered more than actual or max cost:" + dupregid1);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='submit'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost'])[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost'])[1]")))
				.sendKeys("500");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='submit'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Add/Update Tasks'])[1]/img[1]")))
				.click();
		Thread.sleep(3000);
		WebElement taskcbox1 = driver.findElement(By.xpath("(//ul[@id='myUL'])[1]/li[3]/div[1]/div[1]/label[1]"));
		taskcbox1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='submit'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the more schedules
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='More Schedules'])[1]")))
				.click();
		Thread.sleep(3000);
		WebElement targetRow = driver
				.findElement(By.xpath("(//div[@id='active_prgrms_sec'])[1]/table[1]/tbody[1]/tr[5]/td[3]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", targetRow);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Then("click on the checkin button and update the checkin reason")
	public void click_on_the_checkin_button_and_update_the_checkin_reason() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='CheckIn'])[1]"))).click();
		Thread.sleep(2000);
		WebElement others = driver.findElement(By.xpath("//label[normalize-space(text())='Others'][1]"));
		others.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='cmmts'])[1]")))
				.sendKeys("Checked in using others option for testing purpose");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Yes'])[1]"))).click();
		Thread.sleep(3000);
		// mouse hover on checkin button
		Actions checkin = new Actions(driver);
		checkin.moveToElement(driver.findElement(By.xpath("(//a[normalize-space(text())='CheckIn'])[1]"))).build()
				.perform();
		Thread.sleep(3000);
	}

	@And("click on the carerpay from billing and search and approve the status")
	public void click_on_the_carerpay_from_billing_and_search_and_approve_the_status() throws Exception {
		// clicking on the billing and selecting the carer pay
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-billing-tab'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='carer_report'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Manager'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Sunil K')])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pt_nm'])[1]"))).sendKeys("Cucum");
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the cost amount
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//table[@class='table nh_table striped responsive-table']//tr[td//a[contains(normalize-space(.),'Cucum Elderflow')]]//a[@class='btn-loader'])[3]")))
				.click();
		Thread.sleep(3000);
		// clicking on the edit cost
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Edit Cost'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost_field'])[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost_field'])[1]")))
				.sendKeys("0");
		Thread.sleep(1000);
		String dupcost = driver.findElement(By.xpath("(//span[@id='cost_error'])[1]")).getText();
		System.out.println("Validation for price entered 0:" + dupcost);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost_field'])[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='activity_cost_field'])[1]")))
				.sendKeys("400");
		Thread.sleep(1000);
		String dupcost2 = driver.findElement(By.xpath("(//span[@id='cost_error'])[1]")).getText();
		System.out.println("Validation for price entered more than actual or max cost:" + dupcost2);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(3000);

		// clicking on the approve button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//table[@class='table nh_table striped responsive-table']//tr[td//a[contains(normalize-space(.),'Cucum Elderflow')]]//span[text()='Approve'])[1]")))
				.click();
		Thread.sleep(5000);
		// yes
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Yes'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the i icon
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='user_detl_dropdown'])[1]/a[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='ConfirmIP'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(3000);

		// clicking on the billing and selecting the bypass carers
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-billing-tab'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='bypass_carers'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Zone'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Delhi'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Manager'])[1]/preceding-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Sunil K')])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pt_nm'])[1]"))).sendKeys("Cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// file download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("switching role to nursing officer and search and download the sheet")
	public void switching_role_to_nursing_officer_and_search_and_download_the_sheet() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on brand logo and switching to executive role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Nursing Officer'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the carer pay
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='carer_report'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pt_nm'])[1]"))).sendKeys("Cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Payment status'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Approved'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the i icon
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='user_detl_dropdown'])[1]/a[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='ConfirmIP'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(3000);

		// clicking on the carer activity
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='carer_activity'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Carer name'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Sunil K')])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='pt_nm'])[1]"))).sendKeys("Cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the appointment id
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//table[@class='table nh_table striped responsive-table'])[1]/tbody[1]/tr[1]/td[5]/a[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@data-tooltip='Schedules'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@id='package-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(2000);
		// clicking on the invoiceid
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//table[@class='table nh_table striped responsive-table'])[1]/tbody[1]/tr[1]/td[6]/a[1]")))
				.click();
		Thread.sleep(3000);

	}

	@And("switch role to finance and change status to pay from approve")
	public void switch_role_to_finance_and_change_status_to_pay_from_approve() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// changing the role to finance
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Finance - nanohealthplan'])"))).click();
		Thread.sleep(3000);
		// clicking on the billing
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='admin-billing-tab'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the carer pay
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='carer_report'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Zone'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Delhi'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Payment status'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Approved'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// pay
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Pay'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Yes'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Zone'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Delhi'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Payment status'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Paid'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
		driver.close();

	}

}
