package ClinicManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Masterdata {
	WebDriver driver = null;

	@Given("naviagate to the NH_Web_portal {string}")
	// public void naviagate_to_the_nh_web_portal() {
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

	@When("loginpage opens")
	public void loginpage_opens() {

	}

	@Then("enter emailormobile {string} password {string}")
	public void enter_emailormobile_password(String emailormobile, String password) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(emailormobile);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password);
		Thread.sleep(10000);
	}

	@And("click on the sign in button")
	public void click_on_the_sign_in_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("select a profile popup opens")
	public void select_a_profile_popup_opens() throws Exception {

	}

	@Then("select the role as clinic manager")
	public void select_the_role_as_clinic_manager() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]")))
				.click();
		Thread.sleep(2000);
		// selecting Role clicking on Clinic manager Role
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		Thread.sleep(2000);
	}

	@When("dashboard opens mousehover on the reports")
	public void dashboard_opens_mousehover_on_the_reports() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// hover the mouse on Reports
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(10000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
	}

	@Then("click on the master data")
	public void click_on_the_master_data() {

	}

	@When("master_data_dashboard opens")
	public void master_data_dashboard_opens() throws Exception {
	}

	@Then("click on the facility digital twin from the masterdata")
	public void click_on_the_facility_digital_twin_from_the_masterdata() {

	}

	@And("mouse hover on to the clinic_hopsital")
	public void mouse_hover_on_to_the_clinic_hopsital() {

	}

	@Then("drag and drop to add a new clinic_hospital")
	public void drag_and_drop_to_add_a_new_clinic_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// try {
		// ht.until(ExpectedConditions
		// .visibilityOf(driver.findElement(By.xpath("(//a[text()='Facility Digital
		// Twin'])[1]")))).click();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		// Click "add new" button
		WebElement plusBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='plusminus'])[1]")));
		plusBtn.click();

		// Wait for hospital icon to appear
		WebElement hospitalIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='HosplIcon'])[1]")));

		// Move to hospital icon
		action.moveToElement(hospitalIcon).perform();

		// Wait for canvas (drop area)
		WebElement canvas = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='react-flow__pane'])[1]")));

		// Ensure it's interactable
		wait.until(ExpectedConditions.elementToBeClickable(canvas));

		// Perform drag and drop
		action.clickAndHold(hospitalIcon).moveToElement(canvas).pause(Duration.ofMillis(500)) // small pause helps //
																								// stability
				.release().perform();
	}

	@And("enter the details of the clinic_hospital with mouse hover actions")
	public void enter_the_details_of_the_clinic_hospital_with_mouse_hover_actions() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the hospital name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/input[1]")))
				.sendKeys("Cucum Hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/span/following-sibling::img"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// selecting the facility type
		WebElement ftype = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/following-sibling::div/select[1]"));
		Select select = new Select(ftype);
		select.selectByVisibleText("OP Only");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the registration year
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div/input[1]"))
				.sendKeys("2013");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the registration number
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/following-sibling::div/input[1]"))
				.sendKeys("123456789");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action4 = new Actions(driver);
		action4.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // entering the patient id format
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/following-sibling::div/input[1]"))
		// .sendKeys("Number");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// header image upload
		Actions action5 = new Actions(driver);
		action5.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[7]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		try {
			driver.findElement(By.cssSelector("input#fileInputH"))
					.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\varahi_header.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Actions action6 = new Actions(driver);
		action6.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// header image height
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/input[1]"))).sendKeys("70");
//		Thread.sleep(1000);

		// footer image upload
		Actions action7 = new Actions(driver);
		action7.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[9]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		try {
			driver.findElement(By.cssSelector("input#fileInputF"))
					.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\varahi_footer.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Actions action8 = new Actions(driver);
		action8.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// footer image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/input[1]"))
				.sendKeys("30");
		Thread.sleep(1000);

		// preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(3000);

		// is day clinic
		Actions action9 = new Actions(driver);
		action9.moveToElement(driver.findElement(By.xpath("(//label[text()='Is Day Clinic'])[1]"))).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement idc = driver.findElement(By.xpath("(//input[@id='is_day_clinic'])[1]"));
			idc.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// is active
		Actions action10 = new Actions(driver);
		action10.moveToElement(driver.findElement(By.xpath("(//label[text()='Is Active'])[1]"))).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement idc = driver.findElement(By.xpath("(//input[@id='is_active'])[1]"));
			idc.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);

	}

	@Then("add invoice pdf configuration header and footer from create new hospital")
	public void add_invoice_pdf_configuration_header_and_footer_from_create_new_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// by default invoice pdf configuration header and footer from cdp level
		// removing the invoice pdf header
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Remove'])[3]"))).click();
		Thread.sleep(2000);

		// removing the invoice pdf footer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Remove'])[3]"))).click();
		Thread.sleep(2000);

		// adding header & footer for invoice pdf
		// header
		driver.findElement(By.cssSelector("input#fileInputHIn"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Assurance_header.png");
		Thread.sleep(2000);
		// changing the header height
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input[1]"))).clear();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input[1]"))
				.sendKeys("55");
		Thread.sleep(1000);

		// footer
		driver.findElement(By.cssSelector("input#fileInputFIn"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Assurance_footer.png");
		Thread.sleep(1000);
		// changing the footer height
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input[1]"))).clear();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input[1]"))
				.sendKeys("55");
		Thread.sleep(1000);

		WebElement footertype = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[15]/following-sibling::div/select[1]"));
		Select footertype1 = new Select(footertype);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		footertype1.selectByVisibleText("Continuous");
		Thread.sleep(1000);

		// clicking on the preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(3000);

		Robot pagedown = new Robot();
		pagedown.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		// mouse hovering on the Font size large icon
		Actions fzl = new Actions(driver);
		fzl.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/span/following-sibling::img[1]")))
				.build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input[1]"))
				.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// mouse hovering on the Font size medium icon
		Actions fz2 = new Actions(driver);
		fz2.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/span/following-sibling::img[1]")))
				.build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/following-sibling::div/input[1]"))
				.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// mouse hovering on the Font size small icon
		Actions fz3 = new Actions(driver);
		fz3.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/span/following-sibling::img[1]")))
				.build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]"))
				.sendKeys("7");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Then("click on the submit button to create a new hospital")
	public void click_on_the_submit_button_to_create_a_new_hospital() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(10000);
	}

	@And("add the address contact and save again")
	public void add_the_address_contact_and_save_again() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(3000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// Locate the element
		WebElement doubclick = driver.findElement(By.xpath("(//div[text()='Cucum Hospital'])[1]"));
		Thread.sleep(1000);
		// Create Actions instance
		Actions actions = new Actions(driver);
		// Perform double click
		actions.doubleClick(doubclick).perform();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@class='addphone'])[1]"))).build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='addphone'])[1]"))).click();
		Thread.sleep(1000);
		// // clicking on the edit
		// driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		// Thread.sleep(3000);
		// // address line1
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[23]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[23]/following-sibling::div/input[1]"))))
				.sendKeys("Test");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line2
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[24]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[24]/following-sibling::div/input[1]"))
				.sendKeys("Test two");
		Thread.sleep(1000);
		// city
		WebElement city = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[25]/following-sibling::div/select"));
		Select hyd = new Select(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hyd.selectByVisibleText("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// area
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[27]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[27]/following-sibling::div/input[1]"))
				.sendKeys("Test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[28]/following-sibling::div/input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[28]/following-sibling::div/input"))
				.sendKeys("Test landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[29]/following-sibling::div/input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[29]/following-sibling::div/input"))
				.sendKeys("667788");
		Thread.sleep(1000);
		// add location
		WebDriverWait loc = new WebDriverWait(driver, Duration.ofSeconds(30));
		loc.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class='convert-text'])[1]/img"))))
				.click();
		Thread.sleep(3000);
		// current location
		driver.findElement(By.xpath("(//button[text()='Current Location'])[1]")).click();
		Thread.sleep(2000);
		// update
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//div[@id='fixed_footerr'])[2]/button[2]")).click();
		Thread.sleep(8000);
		// WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
		// .click();
		// Thread.sleep(5000);
		// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum
		// Hospital");
		// Thread.sleep(2000);
		//
		// JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		// WebElement element6 = driver.findElement(By.xpath("(//option[text()='Cucum
		// Hospital (Hospital)'])[1]"));
		// jse6.executeScript("arguments[0].click();", element6);
		// Thread.sleep(3000);
		// WebElement doubleclick =
		// driver.findElement(By.xpath("(//img[@alt='HosplIcon'])[2]"));
		// Actions action2 = new Actions(driver);
		// action2.doubleClick(doubleclick).build().perform();
		// Thread.sleep(3000);
		// // edit
		// driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		// Thread.sleep(2000);
		// ############################################################################//
		// clicking on the edit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[1]"))).click();
		Thread.sleep(2000);
		// adding contact
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='addphone'])[2]"))).click();
		Thread.sleep(2000);

		// add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add +'])[1]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("789321456");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number"))).clear();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("7893214569");
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-email")))
				.sendKeys("hospitalw@gmail.com");
		Thread.sleep(1000);

		try {
			// save
			driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(2000);
		// edit number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='editBtn'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number"))).clear();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("7893214560");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Close'])[3]"))).click();
		Thread.sleep(2000);
		// // close
		// driver.findElement(By.xpath("(//div[@class='popClose'])[1]")).click();
		// Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='fixed_footerr'])[1]/button[2]")))
				.click();
		Thread.sleep(5000);

	}

	@Then("alert with the updation will appear")
	public void alert_with_the_updation_will_appear() {
	}

	@And("search the hospital and mouse hover on to the hospital")
	public void search_the_hospital_and_mouse_hover_on_to_the_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Hospital");
		Thread.sleep(2000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Hospital'])[1]"))).build().perform();
		Thread.sleep(3000);
	}

	@When("team details icon is visible click on it")
	public void team_details_icon_is_visible_click_on_it() throws Exception {
		Actions img = new Actions(driver);
		img.moveToElement(driver.findElement(By.xpath("(//span[text()='Doctor Consultation'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Doctor Consultation'])[1]")).click();
		Thread.sleep(7000);
	}

	@And("team details is clicked then user details")
	public void team_details_is_clicked_then_user_details() {

	}

	@Then("add new doctor from the user details")
	public void add_new_doctor_from_the_user_details() throws Exception {
		// clicking on the add new +
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[text()='add'][1]")))).click();
		Thread.sleep(3000);
		// selecting the salutation
		driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Dr.'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Doctor");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys("30");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[10]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("8733828282");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[normalize-space(text())='Role']/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		// Thread.sleep(3000);
		WebElement nameField = driver.findElement(By.xpath(
				"//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'doctor')]"));
		nameField.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space(text())='Hospitals']/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Cucum Hospital'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// masterdata access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);

		/*
		 * // hover the mouse on Reports Actions action = new Actions(driver);
		 * Thread.sleep(1000);
		 * action.moveToElement(driver.findElement(By.id("admin-reports"))).click().
		 * build().perform(); Thread.sleep(1000);
		 * action.moveToElement(driver.findElement(By.xpath("//a[text()='Master Data']")
		 * )).click().build().perform(); Thread.sleep(1000); WebDriverWait ht = new
		 * WebDriverWait(driver, Duration.ofSeconds(30)); try {
		 * ht.until(ExpectedConditions .visibilityOf(driver.findElement(By.xpath(
		 * "/html/body/main/div/div[2]/div/div/div[1]/a")))).click(); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * Thread.sleep(18000);
		 * 
		 * driver.findElement(By.cssSelector("input#searchBoxx")).
		 * sendKeys("Cucum Hospital"); Thread.sleep(2000);
		 * 
		 * JavascriptExecutor jse5 = (JavascriptExecutor) driver; WebElement element =
		 * driver.findElement(By.
		 * xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		 * jse5.executeScript("arguments[0].click();", element); Thread.sleep(3000);
		 */
		driver.close();
	}

	@Then("digitaltwin will open and click on the demandprogram button")
	public void digitaltwin_will_open_and_click_on_the_demandprogram_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Demand Program'])[1]")))
				.click();
//		driver.findElement(By.xpath("(//div[text()='Demand Program'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("click on the plus button to create a new program")
	public void click_on_the_plus_button_to_create_a_new_program() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Program'])[1]/i[1]")))
				.click();
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])[1]/i[1]")).click();
		Thread.sleep(3000);
	}

	@Then("creation of demand program popup will open")
	public void creation_of_demand_program_popup_will_open() {

	}

	@And("enter the details select the end date")
	public void enter_the_details_select_the_end_date() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// entering program name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_program_name")))
				.sendKeys("Cucumber demandprogramme");
//		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Category'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Impact'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_program_comp")))
				.sendKeys("Testing company");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_program_owner")))
				.sendKeys("Test owner");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Hospital'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//label[text()='Location'])[1]/following-sibling::span[1]")).click();
		// Thread.sleep(2000);
		WebElement newprogram = driver.findElement(By.xpath("(//label[text()='New'])[1]"));
		newprogram.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#location_name"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#location_name")))
				.sendKeys("loc_cucumdemandprogram");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='City']/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Hyderabad'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#pincode"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Area']/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Nagar_1')])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#pincode"))).sendKeys("898989");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[2]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#program_master_desc")))
				.sendKeys("Test description");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_start_dt")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='is-today'])[1]/button[1]")))
				.click();
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
			active.click();
			Thread.sleep(1000);
		}

	}

	@Then("save the demandprogram")
	public void save_the_demandprogram() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("edit and save the demandprogram by changing the programname")
	public void edit_and_save_the_demandprogram_by_changing_the_programname() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program Name'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum')])[1]")))
				.click();
		Thread.sleep(1000);
		// searching
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		// changing the name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_program_name")))
				.clear();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_program_name")))
				.sendKeys("Cucumber program");
		Thread.sleep(1000);
		// selecting the end-date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#program_master_end_at")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='select-wrapper select-year'])[1]/input[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li/span[text()='2035'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		driver.close();
	}

	@When("the masterdata dashboard")
	public void the_masterdata_dashboard() {
	}

	@Then("click on the doctors button")
	public void click_on_the_doctors_button() throws Exception {
		// searching opd hospital
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Nanohealth");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the doctor Consultation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Doctor Consultation'])[1]")))
				.click();
		Thread.sleep(5000);

		// // clicking on the brand logo & changing role WebDriverWait logoclick = new
		// WebDriverWait logoclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		// logoclick
		// .until(ExpectedConditions.visibilityOf(driver
		// .findElement(By.xpath("(//div[@id='leftone'])[1]/following-sibling::aside[1]/div[1]/img[1]"))))
		// .click();
		// Thread.sleep(3000);
		// // selecting the NanoHealth CDP
		// driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		// Thread.sleep(3000);
		// // selecting Role clicking on IPD Clinic_manager Role
		// driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager -
		// NanoHealth_OPD'])[1]")).click();
		// Thread.sleep(3000);
		// Actions action = new Actions(driver);
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[text()='Master
		// Data'])[1]"))).click().build().perform();
		// Thread.sleep(3000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[text()='Doctors'])[2]"))).click().build().perform();
		// Thread.sleep(3000);

	}

	@When("doctor masters page open")
	public void doctor_masters_page_open() {

	}

	@Then("click on the add button to add a new doctor master")
	public void click_on_the_add_button_to_add_a_new_doctor_master() throws Exception {
		// clicking on the add new +
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(2000);
		// selecting the salutation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[9]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Dr.'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("enter the following details in the new doctor popup page1")
	public void enter_the_following_details_in_the_new_doctor_popup_page1(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<List<String>> regData = dataTable.asLists(String.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name")))
				.sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lst_name")))
				.sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the gender radiobutton for the doctor")
	public void select_the_gender_radiobutton_for_the_doctor() {
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the following details in the doctor page6")
	public void enter_the_following_details_in_the_doctor_page6(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<List<String>> regData = dataTable.asLists(String.class);
		// age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age")))
				.sendKeys(regData.get(0).get(1));
		Thread.sleep(1000);
	}

	@Then("selecting the country code from dropdown for doctormasters")
	public void selecting_the_country_code_from_dropdown_for_doctormasters() throws Exception {
		/*
		 * // driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		 * // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //
		 * driver.findElement(By.xpath("//li[text()='+91']")).click(); //
		 * Thread.sleep(1000);
		 */ }

	@Then("enter the following details in the new doctor popup page2")
	public void enter_the_following_details_in_the_new_doctor_popup_page2(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<List<String>> regData = dataTable.asLists(String.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr")))
				.sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the continue button to add doctor role in the next popup")
	public void click_on_the_continue_button_to_add_doctor_role_in_the_next_popup() throws Exception {
		// upload picture
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[@data-tooltip='Upload Picture'])[1]/span/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#upload_img"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Doctor.png");
		Thread.sleep(2000);

		WebElement slider = driver.findElement(By.xpath("(//div[@class='cr-slider-wrap'])[1]/input[1]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, -300, 0).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#submitBtn"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);

	}

	@Then("select the role and existing hospital from the dropdown")
	public void select_the_role_and_existing_hospital_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Role'])[1]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		// Thread.sleep(2000);
		WebElement nameField = driver.findElement(By.xpath(
				"//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'doctor')]"));
		nameField.click();
		Thread.sleep(3000);
		// selecting the existing hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Hospitals']/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@And("upload the doctor signature")
	public void upload_the_doctor_signature() throws Exception {
		driver.findElement(By.cssSelector("input#files_sign"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Doctorsignature.png");
		Thread.sleep(2000);
	}

	@Then("clicking on the more icon to enable access checkboxes")
	public void clicking_on_the_more_icon_to_enable_access_checkboxes() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
//		Thread.sleep(1000);
		// masterdata access
//		for (int i = 0; i <= 1; i++) {
//			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])"));
//			fa.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		// health access
		for (int i = 0; i <= 1; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Health Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(1000);
		// qualification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#qualification")))
				.sendKeys("MBBS");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// reg number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#rgstrton_no")))
				.sendKeys("12345678");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// reg year
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#rgstrton_yr"))).sendKeys("2020");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#effctv_dt"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='select-wrapper select-year'])/input[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li/span[text()='2020'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]"))).build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#time_sensivity"))).sendKeys("5");
		Thread.sleep(1000);
		Actions act2 = new Actions(driver);
		act2.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[2]"))).build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#days_in_advnce"))).sendKeys("5");
		Thread.sleep(1000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Specialisations'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Internal Medicine'])[1]")))
				.click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS and Email'])[1]"));
			sms.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		WebElement islead = driver.findElement(By.xpath("(//label[text()='Is lead'])[1]"));
		islead.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement isnetwork = driver.findElement(By.xpath("(//label[text()='In network'])[1]"));
		isnetwork.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#days_in_advnce")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		// entering the qualification of the doctor
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.click();
		// (//textarea[@id='name_template'])[1]
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.sendKeys("MBBS, test qualification" + Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.sendKeys("MBBS, test qualification" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.sendKeys("for cucumber doctor" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='name_template'])[1]")))
				.sendKeys("test qualifaction for the testing doctor");
		Thread.sleep(2000);

		// downloading the pdf
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Qualification (blank pdf)'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Qualification (blank pdf)'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
	}

	@Then("click on the save button from add doctor page")
	public void click_on_the_save_button_from_add_doctor_page() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(10000);
	}

	@And("click on the add or edit consultations plus button")
	public void click_on_the_add_or_edit_consultations_plus_button() throws Exception {
		// edit doctor
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_nmbr_cont")))
				.sendKeys("7766554422");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Edit Doctor'])[1]/img[1]")))
				.click();
		Thread.sleep(3000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Hospitals']/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("add appointment types for the created doctor")
	public void add_appointment_types_for_the_created_doctor() throws Exception {
		// adding availability
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions ava = new Actions(driver);
		ava.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Availability'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Availability'])[1]/img[1]"))).click();
		Thread.sleep(2000);
		WebElement selecthsptl = driver.findElement(By.xpath("(//select[@id='hospital_master_id'])[1]"));
		Select hsptl = new Select(selecthsptl);
		hsptl.selectByVisibleText("NanoHealth_OPD");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Fee'])[1]/following-sibling::input[1]"))).sendKeys("300");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[1]/following-sibling::input[1]")))
				.sendKeys("30");
		Thread.sleep(1000);
		// clicking on the select days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Tuesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Wednesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Thursday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Friday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		Thread.sleep(1000);
		// removing last added day
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection__choice__remove'])[7]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[1]"))).click();
		Thread.sleep(2000);

		// start time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available Start Time'])[1]"))).click();
		Thread.sleep(1000);
		// 9
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[9]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]"))).click();
		Thread.sleep(1000);
		// end time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available End Time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]"))).click();
		Thread.sleep(1000);

		// adding another appointment type as video
		// clicking on the plus button to add new appt type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[3]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[1]/following-sibling::input[1]")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		// JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		// jse1.executeScript("window.scrollBy(0,200)", "");
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Video')])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Fee'])[2]/following-sibling::input[1]"))).sendKeys("300");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[2]/following-sibling::input[1]")))
				.sendKeys("30");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[2]/following-sibling::input[1]")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the select days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monday'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Friday'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		Thread.sleep(1000);

		// start time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available Start Time'])[2]"))).click();
		Thread.sleep(1000);
		// 9
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[3]/div[9]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[3]/div[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[3]/button[2]"))).click();
		Thread.sleep(1000);
		// end time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available End Time'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[3]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[4]/div[2]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[4]/button[2]"))).click();
		Thread.sleep(1000);
		// adding onemore day using add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[3]"))).click();
		Thread.sleep(3000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,200)", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[2]/following-sibling::input[1]")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the select days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[3]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Tuesday'])[2]"))).click();
		Thread.sleep(1000);

		// start time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available Start Time'])[3]"))).click();
		Thread.sleep(1000);
		// 10
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[5]/div[10]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[5]/div[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[5]/button[2]"))).click();
		Thread.sleep(1000);
		// end time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available End Time'])[3]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[5]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[6]/div[2]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[6]/button[2]"))).click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(10000);

	}

	@And("adding charge configurations to the newly added doctors")
	public void adding_charge_configurations_to_the_newly_added_doctors() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching doctor
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_nmbr_cont"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_nmbr_cont")))
				.sendKeys("7766554422");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Add/Edit charge configurations'])[1]/span[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Add/Edit charge configurations'])[1]/span[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		WebElement label1 = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		label1.click();
		Thread.sleep(2000);
		// entering charge code
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Charge Code'])[1]/following-sibling::input[1]")))
				.sendKeys("Cucumdoc-op");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// changing doctor label name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]")))
				.sendKeys("Doc.Cucumber Doctor");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Payment Mode'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Self'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")))
				.sendKeys("30");
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("clicking on the sharecredentials button and click on confirm for doctormaster")
	public void clicking_on_the_sharecredentials_button_and_click_on_confirm_for_doctormaster() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// share-credentials
		Actions sc = new Actions(driver);
		sc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Credentials'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Share Credentials'])[1]/img[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Confirm!']"))).click();
		Thread.sleep(5000);

	}

	@And("adding doctor break time for schedule once")
	public void adding_doctor_break_time_for_schedule_once() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_nmbr_cont"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_nmbr_cont")))
				.sendKeys("7766554422");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Block Day'])[1]/img[1]"))).click();
		Thread.sleep(5000);
		// adding block days for schedule = once
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Hospital'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		Thread.sleep(1000);
		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat.click();
		Thread.sleep(1000);
		WebElement once = driver.findElement(By.xpath("(//label[text()='Once'])[1]"));
		once.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#block_start_date"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//td[@class='is-today'])[1]/following-sibling::td[1]/button[1]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		// edit & update the block date for schedule once
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='block_apmnt_tab_Clinic'])[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]/i[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_start_date'])[2]")))
				.click();
		Thread.sleep(2000);
		// select next month and first date to be blocked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='month-next'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'1')])[1]")))
				.click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[2]"))).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("adding doctor break time for schedule dialy")
	public void adding_doctor_break_time_for_schedule_dialy() throws Exception {
		// adding block days for schedule = once
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Block Day'])[1]/img[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Hospital'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		Thread.sleep(1000);
		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Daily'])[1]"))).click();
		Thread.sleep(2000);
		// start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_start_date'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='is-today'])[1]/button[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_end_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// Store all date elements in a list
		List<WebElement> allDates = driver.findElements(By.xpath("(//button[@class='datepicker-day-button'])"));
		// Click on the last date in the list
		allDates.get(allDates.size() - 1).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		// delete the block date for schedule daily
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='block_apmnt_tab_Clinic'])[1]/table[1]/tbody[1]/tr[2]/td[6]/a[2]/i[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Confirm!'])[1]"))).click();
		Thread.sleep(3000);

		// adding block days for schedule = once
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Hospital'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		Thread.sleep(1000);
		WebElement repeat1 = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat1.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Daily'])[1]"))).click();
		Thread.sleep(2000);
		// start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_start_date'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//td[@class='is-today is-selected'])[1]/button[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_end_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// Store all date elements in a list
		List<WebElement> allDates1 = driver.findElements(By.xpath("(//td[@class='is-selected'])[1]"));
		// Click on the last date in the list
		allDates1.get(allDates1.size() - 1).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(7000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("adding doctor break time for schedule weekyly")
	public void adding_doctor_break_time_for_schedule_weekyly() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Block Day'])[1]/img[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Hospital'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Video')])[1]")))
				.click();
		Thread.sleep(1000);
		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Weekly'])[1]"))).click();
		Thread.sleep(2000);
		// selecting the week days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Week Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Week Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(2000);
		/*
		 * driver.findElement(By.
		 * xpath("(//label[normalize-space(text())='Week Days'])[1]/following-sibling::span[1]"
		 * )) .click(); Thread.sleep(2000);
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Week Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		Thread.sleep(1000);
		// start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_start_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the next month
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='month-next'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'1')])[1]")))
				.click();
		Thread.sleep(2000);
		// end date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_end_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the next month
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//button[@class='month-next'])[2]")).click();
			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-day='1'])[2]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	@And("adding doctor break time for schedule monthly")
	public void adding_doctor_break_time_for_schedule_monthly() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Block Day'])[1]/img[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Hospital'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monthly'])[1]"))).click();
		Thread.sleep(2000);
		// selecting the month days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='1'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='2'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='3'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='5'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='6'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='25'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='26'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='27'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='28'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Month Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(2000);

		// start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_start_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the next month
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='month-next'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'1')])[1]")))
				.click();
		Thread.sleep(2000);
		// end date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='block_end_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the next month
		for (int i = 0; i <= 3; i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='month-next'])[2]")))
					.click();
			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-day='1'])[2]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@And("adding doctor block time for schedule monthly")
	public void adding_doctor_block_time_for_schedule_monthly() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Break Time'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Break Time'])[1]/img[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Hospital'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='All'])[1]"))).click();
		Thread.sleep(1000);
		// driver.findElement(
		// By.xpath("(//label[normalize-space(text())='Appointment
		// Type'])[1]/following-sibling::span[1]"))
		// .click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		Thread.sleep(2000);
		WebElement repeat = driver.findElement(By.xpath("(//label[text()='Repeat'])[1]"));
		repeat.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monthly'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monthly'])[1]"))).click();
		Thread.sleep(2000);
		try {
			WebElement monthdays = driver.findElement(By.xpath("(//input[@class='select2-search__field'])[4]"));
			Thread.sleep(1000);
			for (int day = 1; day <= 31; day++) {
				monthdays.click(); // open dropdown for each selection
				monthdays.sendKeys(String.valueOf(day));
				monthdays.sendKeys(Keys.ENTER);
				Thread.sleep(200); // small wait so UI updates
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i <= 2; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(1000);
		}

		// break start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='break_start_date'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(2000);
		// break enddate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='break_end_date'])[1]")))
				.click();
		Thread.sleep(2000);
		// next month
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath("(//button[@class='month-next'])[2]")).click();
			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-day='1'])[2]"))).click();
		Thread.sleep(2000);
		// break start time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='break_start_time'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[7]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='timepicker-display-column timepicker-display-am-pm'])[1]/div[1]/div[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-footer'])[1]/div[1]/button[2]")))
				.click();
		Thread.sleep(2000);

		// break end time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='break_end_time'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[7]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='timepicker-display-column timepicker-display-am-pm'])[2]/div[1]/div[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-footer'])[2]/div[1]/button[2]")))
				.click();
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Then("from ipd hospital add the price configurations for the newly created doctor")
	public void from_ipd_hospital_add_the_price_configurations_for_the_newly_created_doctor() throws Exception {

	}

	@Then("search the recent added doctor using search field")
	public void search_the_recent_added_doctor_using_search_field() throws Exception {
		// mouse hover on to the reports
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]"))).click().build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Facility Digital Twin'])[1]")))
				.click();
		Thread.sleep(12000);
		// clicking on the user details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='User Details'])[1]")))
				.click();
		Thread.sleep(5000);
		// searching with mobile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_mobile_or_email_cont")))
				.sendKeys("7766554422");
		Thread.sleep(1000);
		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the doctor
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='user_role_name'])[1]")))
				.click();
		Thread.sleep(3000);
		// availability
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Availability'])[1]"))).click();
		Thread.sleep(2000);
		// selecting nh_ipward
		WebElement hos = driver.findElement(By.xpath("(//select[@id='hospital_master_id'])[1]"));
		Select hosp = new Select(hos);
		hosp.selectByVisibleText("NanoHealth_IPD");
		Thread.sleep(1000);
		// // add
		// try {
		// driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Fee'])[1]/following-sibling::input[1]"))).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[1]/following-sibling::input[1]")))
				.sendKeys("30");
		Thread.sleep(1000);
		// clicking on the select days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Tuesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Wednesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Thursday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Friday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();

		// start time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available Start Time'])[1]"))).click();
		Thread.sleep(1000);
		// 9
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[9]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]"))).click();
		Thread.sleep(1000);
		// end time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available End Time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]"))).click();
		Thread.sleep(1000);

		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the doctor
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='user_role_name'])[1]")))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// availability
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Availability'])[1]"))).click();
		Thread.sleep(3000);
		WebElement hospita2 = driver.findElement(By.id("hospital_master_id"));
		Select hos11 = new Select(hospita2);
		hos11.selectByVisibleText("NanoHealth_IPD");
		Thread.sleep(3000);
		// close
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#doctor-apmnt-modal>div>div>span>i")))
				.click();
		Thread.sleep(2000);
		driver.close();
	}

	@When("the masterdata dashboard is opened")
	public void the_masterdata_dashboard_is_opened() throws Exception {
		Thread.sleep(2000);
	}

	@Then("click on the userdetails button")
	public void click_on_the_userdetails_button() throws Exception {
		// clicking on the user details from digitaltwin dashboard
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='User Details'])[1]")))
				.click();
		Thread.sleep(5000);

		/*
		 * // Thread.sleep(1000); //
		 * driver.findElement(By.xpath("(//a[text()='User Details'])[1]")).click(); //
		 * Thread.sleep(1000); // String md =
		 * driver.findElement(By.cssSelector("a#admin-reports")).getText(); //
		 * System.out.println(md);
		 */ }

	@When("userdetails page open")
	public void userdetails_page_open() {
	}

	@Then("click on the add button to add a new dietician master")
	public void click_on_the_add_button_to_add_a_new_dietician_master() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New User'])[1][i]")))
				.click();
		Thread.sleep(3000);
		// selecting the salutation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[7]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Mr.'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name")))
				.sendKeys("Cucumber");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lst_name")))
				.sendKeys("Dietitian");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // gender
		// WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		// male.click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age"))).sendKeys("36");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr"))).sendKeys("7788992222");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// upload picture
		driver.findElement(By.xpath("(//a[@data-tooltip='Upload Picture'])[1]/span/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#upload_img"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Dietitian.png");
		Thread.sleep(2000);

		WebElement slider = driver.findElement(By.xpath("(//div[@class='cr-slider-wrap'])[1]/input[1]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, -300, 0).perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#submitBtn")).click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Role'])[2]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(), 'Diet')])[1]")))
				.click();
		Thread.sleep(2000);
		// selecting the existing hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Hospitals']/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
//		// masterdata access
//		for (int i = 0; i <= 1; i++) {
//			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])"));
//			fa.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		// health access
		for (int i = 0; i <= 1; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Health Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(8000);
		// edit dietitian
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_mobile_or_email_cont")))
				.sendKeys("7788992222");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Hospitals']/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);

	}

	@And("enter the details of the dietitian")
	public void enter_the_details_of_the_dietitian() throws Exception {

	}

	@Then("click on the edit button for newly created dietician")
	public void click_on_the_edit_button_for_newly_created_dietician() {
	}

	@And("edit the phonenumber click on save button for dietician")
	public void edit_the_phonenumber_click_on_save_button_for_dietician() throws Exception {
	}

	@Then("click on the dietitian role name and add availability")
	public void click_on_the_dietitian_role_name_and_add_availability() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_mobile_or_email_cont")))
				.sendKeys("7788992222");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the role name
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@class='user_role_name' and contains(text(), 'Diet')])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Availability'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(2000);
		WebElement selecthsptl = driver.findElement(By.xpath("(//select[@id='hospital_master_id2'])[1]"));
		Select hsptl = new Select(selecthsptl);
		hsptl.selectByVisibleText("NanoHealth_OPD");
		Thread.sleep(1000);

		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Clinic')])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Fee'])[1]//preceding-sibling::input[1]"))).sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[1]/preceding-sibling::input[1]")))
				.sendKeys("30");
		Thread.sleep(1000);
		// clicking on the select days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Tuesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Wednesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[1]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[1]"))).click();
		Thread.sleep(2000);

		// start time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available Start Time'])[1]"))).click();
		Thread.sleep(1000);
		// 9
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[9]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]"))).click();
		Thread.sleep(1000);
		// end time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available End Time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]"))).click();
		Thread.sleep(1000);

		// driver.findElement(
		// By.xpath("(//label[normalize-space(text())='Slot
		// Duration'])[1]/preceding-sibling::input[1]"))
		// .sendKeys(Keys.PAGE_DOWN);
		// Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// adding another appointment type as video
		// clicking on the plus button to add new appt type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(3000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Video')])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Fee'])[2]/preceding-sibling::input[1]"))).sendKeys("300");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[2]/preceding-sibling::input[1]")))
				.sendKeys("30");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Slot Duration'])[2]/preceding-sibling::input[1]")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the select days
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monday'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Friday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Select Days'])[2]/following-sibling::span[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		Thread.sleep(1000);

		// start time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available Start Time'])[2]"))).click();
		Thread.sleep(1000);
		// 9
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[3]/div[9]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[3]/div[1]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[3]/button[2]"))).click();
		Thread.sleep(1000);
		// end time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Available End Time'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[3]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		// am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[4]/div[2]"))).click();
		Thread.sleep(1000);
		// ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[4]/button[2]"))).click();
		Thread.sleep(1000);

		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(12000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@And("clicking on the sharecredentials button and click on confirm for dietician")
	public void clicking_on_the_sharecredentials_button_and_click_on_confirm_for_dietician() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// share-credentials
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("a.share_crdls.tooltipped>img:nth-of-type(1)"))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		// Thread.sleep(5000);
		// clicking on the create password
		WebElement pswd = driver.findElement(By.xpath("(//label[text()='Create Password'])[1]"));
		pswd.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='user_password'])[1]")))
				.sendKeys("1234567");
		Thread.sleep(2000);
		// share
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Share'])[1]"))).click();
		Thread.sleep(3000);

		// clicking on the automatic generate password
		WebElement pswd1 = driver.findElement(By.xpath("(//label[text()='Automatically generate a password'])[1]"));
		pswd1.click();
		Thread.sleep(2000);
		// share
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Share'])[1]"))).click();
		Thread.sleep(5000);

	}

	@Then("add price configuration for the newly created dietitian")
	public void add_price_configuration_for_the_newly_created_dietitian() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@id='admin-reports'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Facility Digital Twin'])[1]")))
				.click();
		Thread.sleep(10000);
		// searching opd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(5000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the charge masters
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Dietician Consultation'])[1]")))
				.click();
		Thread.sleep(5000);
		// searching dietitian
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_frst_nm_or_lst_nm_cont")))
				.sendKeys("Cucumber");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Add/Edit charge configurations'])[1]/span[1]")))
				.build().perform();
		Thread.sleep(2000);
		action1.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Add/Edit charge configurations'])[1]/span[1]")))
				.click().build().perform();
		Thread.sleep(5000);
		WebElement label1 = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		label1.click();
		Thread.sleep(2000);
		// entering charge code
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Charge Code'])[1]/following-sibling::input[1]")))
				.sendKeys("Cucumdt-op");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// changing doctor label name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]")))
				.sendKeys("Dt.Cucumber Dietitian");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Payment Mode'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Self'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")))
				.sendKeys("100");
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		driver.close();
	}

	@When("the masterdata dashboard opened")
	public void the_masterdata_dashboard_opened() {
	}

	@Then("click on the digital twin from masterdata dashboard")
	public void click_on_the_digital_twin_from_masterdata_dashboard() throws Exception {
		/*
		 * // WebDriverWait ht = new WebDriverWait(driver, Duration.ofSeconds(30)); //
		 * try { // ht.until(ExpectedConditions // .visibilityOf(driver.findElement(By.
		 * xpath("(//a[text()='Facility Digital Twin'])[1]")))).click(); // } catch
		 * (Exception e) { // // TODO Auto-generated catch block // e.printStackTrace();
		 * // } // Thread.sleep(18000);
		 */ }

	@And("drag and drop to create a new pharmacy")
	public void drag_and_drop_to_create_a_new_pharmacy() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add new button
		driver.findElement(By.xpath("(//img[@class='plusminus'])[1]")).click();
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		try {
			action1.moveToElement(driver.findElement(By.xpath("(//img[@alt='PharmaIcon'])[1]"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Thread.sleep(1000);
		// action1.dragAndDrop(driver.findElement(By.xpath("(//img[@alt='PharmaIcon'])[1]")),
		// driver.findElement(By.xpath("(//div[@class='react-flow__pane'])[1]"))).build().perform();
		// click on the pharmacy icon to create new
		driver.findElement(By.xpath("(//img[@alt='PharmaIcon'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("add pharmacy popup opens enter the following details")
	public void add_pharmacy_popup_opens_enter_the_following_details() {

	}

	@And("enter the details in the create new pharmacy popup")
	public void enter_the_details_in_the_create_new_pharmacy_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy name
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/input"))
				.sendKeys("Cucum Pharmacy");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy license code
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/following-sibling::div/input"))
				.sendKeys("12345678910");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// GST Number
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div/input"))
				.sendKeys("22AAAAA0000A1Z5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action4 = new Actions(driver);
		action4.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy header image
		driver.findElement(By.cssSelector("input#fileInputH"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\CFA_header.png");
		Thread.sleep(1000);
		// Pharmacy footer image
		driver.findElement(By.cssSelector("input#fileInputF"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\CFA_footer.png" + "");
		Thread.sleep(2000);
		// preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(3000);
		Actions action8 = new Actions(driver);
		action8.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Retailer'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			// is retailer
			WebElement isret = driver
					.findElement(By.xpath("(//span[text()='Is Retailer'])[1]/preceding-sibling::span[1]"));
			isret.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		Actions action9 = new Actions(driver);
		action9.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Active'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			// is active
			WebElement isact = driver
					.findElement(By.xpath("(//span[text()='Is Active'])[1]/preceding-sibling::span[1]"));
			isact.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Actions action10 = new Actions(driver);
		action10.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Distributor'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			// is distributor
			WebElement isdist = driver
					.findElement(By.xpath("(//span[text()='Is Distributor'])[1]/preceding-sibling::span[1]"));
			isdist.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);
		Actions action101 = new Actions(driver);
		action101.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Eligible for GST'])[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			// is distributor
			WebElement isdist = driver
					.findElement(By.xpath("(//span[text()='Is Eligible for GST'])[1]/preceding-sibling::span[1]"));
			isdist.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);
	}

	@Then("click on the submit button from the create new pharmacy popup")
	public void click_on_the_submit_button_from_the_create_new_pharmacy_popup() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(10000);

		// String toast =
		// driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
		//
		// String expected_toast = "Cucum Pharmacy (pharmacy) created.";
		//
		// Assert.assertEquals(toast, expected_toast);
		//
		// Assert.assertTrue(toast.contains("Cucum Pharmacy (pharmacy) created."));
		//
		// System.out.println("Toast message for creation verification is done:-" +
		// toast);

	}

	@And("add the address for pharmacy and save the pharmacy")
	public void add_the_address_for_pharmacy_and_save_the_pharmacy() throws Exception {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(3000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// Locate the element
		WebElement doubclick = driver.findElement(By.xpath("(//div[text()='Cucum Pharmacy'])[1]"));
		// Create Actions instance
		Actions actions = new Actions(driver);
		// Perform double click
		actions.doubleClick(doubclick).perform();
		Thread.sleep(2000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@class='addphone'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@class='addphone'])[1]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]"))
		// .sendKeys("Test line1");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[19]/following-sibling::div/input[1]"))
		// .sendKeys("Test line2");
		// Thread.sleep(1000);
		// // city
		// WebElement city = driver
		// .findElement(By.xpath("(//label[@id='HospitalLabel'])[20]/following-sibling::div/select"));
		// Select hyd = new Select(city);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// hyd.selectByIndex(6);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // area
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[22]/following-sibling::div/input"))
		// .sendKeys("Test area");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // landmark
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[23]/following-sibling::div/input"))
		// .sendKeys("Test landmark");
		// Thread.sleep(2000);
		// // clicking on the save button
		// WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		// save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Save'])[1]"))))
		// .click();
		// Thread.sleep(3000);
		// // entering the pincode
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[24]/following-sibling::div/input"))
		// .sendKeys("556677");
		// Thread.sleep(2000);
		// // clicking on the edit button
		// driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]"))
				.sendKeys("CDPconfig address");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[19]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[19]/following-sibling::div/input[1]"))
				.sendKeys("test line2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// city
		WebElement city = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[20]/following-sibling::div/select"));
		Select hyd = new Select(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hyd.selectByValue("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[2]"))))
				.click();
		Thread.sleep(10000);

		/*
		 * // close
		 * driver.findElement(By.xpath("(//button[text()='Close'])[2]")).click();
		 * Thread.sleep(5000); // yes
		 * driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		 * Thread.sleep(3000);
		 */

	}

	@And("search and click on the pharmacy from the search box")
	public void search_and_click_on_the_pharmacy_from_the_search_box() {
	}

	@Then("double click on the pharmacy to edit")
	public void double_click_on_the_pharmacy_to_edit() throws Exception {
		/*
		 * WebElement doubleclick =
		 * driver.findElement(By.xpath("(//div[text()='Cucum Pharmacy'])[1]")); Actions
		 * action = new Actions(driver);
		 * action.doubleClick(doubleclick).build().perform(); Thread.sleep(5000); //
		 * edit driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		 * Thread.sleep(2000);
		 */
	}

	@And("edit the pharmacy and add address for the pharmacy")
	public void edit_the_pharmacy_and_add_address_for_the_pharmacy() throws Exception {
	}

	@Then("click on the submit button from the pharmacy address popup")
	public void click_on_the_submit_button_from_the_pharmacy_address_popup() throws Exception {
	}

	@And("click on the submit button from the pharmacy popup")
	public void click_on_the_submit_button_from_the_pharmacy_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// adding contact
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='addphone'])[2]"))).click();
		Thread.sleep(1000);
		// add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Add')])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("789321453");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number"))).clear();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("7893214521");
//		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-email")).sendKeys("pharmacye@gmail.com");
		Thread.sleep(1000);
		try {
			// save
			driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		// edit number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='editBtn'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number"))).clear();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("7893214561");
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Close'])[3]"))).click();
		Thread.sleep(2000);
		// // close
		// driver.findElement(By.xpath("(//div[@class='popClose'])[1]")).click();
		// Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='fixed_footerr'])[1]/button[2]")))
				.click();
		Thread.sleep(10000);

		// // submit from the pharmacy popup
		// WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		// submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
		// .click();
		// Thread.sleep(3000);
	}

	@Then("connect this created pharmacy with the cucum hospital")
	public void connect_this_created_pharmacy_with_the_cucum_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hover to the dot above of the hospital name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]"))).build().perform();
		Thread.sleep(2000);
		List<WebElement> lastpharm = driver.findElements(By.xpath(
				"(//div[@class='react-flow__handle react-flow__handle-bottom nodrag nopan target connectable connectablestart connectableend connectionindicator'])"));
		WebElement lastpharm1 = lastpharm.get(lastpharm.size() - 1);
		Actions action1 = new Actions(driver);
		action1.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]")), lastpharm1).build()
				.perform();
		Thread.sleep(2000);
		// no
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='No'])[1]"))).click();
		Thread.sleep(2000);

		List<WebElement> lastpharmm = driver.findElements(By.xpath(
				"(//div[@class='react-flow__handle react-flow__handle-bottom nodrag nopan target connectable connectablestart connectableend connectionindicator'])"));
		WebElement lastpharm2 = lastpharmm.get(lastpharm.size() - 1);

		// connecting pharmacy to the hospital
		Actions connection = new Actions(driver);
		connection.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]")), lastpharm2).build()
				.perform();
		Thread.sleep(2000);

		// yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Yes'])[1]"))).click();
		Thread.sleep(5000);

		// String toast =
		// driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
		//
		// String expected_toast = "Cucum Pharmacy is connected to Cucum Hospital.";
		//
		// Assert.assertEquals(toast, expected_toast);
		//
		// Assert.assertTrue(toast.contains("Cucum Pharmacy is connected to Cucum
		// Hospital."));
		//
		// System.out.println("Toast message for connection verification is done:-" +
		// toast);

	}

	private WebElement lastpharm1() {
		// TODO Auto-generated method stub
		return null;
	}

	@And("add pharmacist user using created pharmacy from hospital digital twin")
	public void add_pharmacist_user_using_created_pharmacy_from_hospital_digital_twin() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		Actions pharm = new Actions(driver);
		pharm.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Pharmacy'])[1]"))).build().perform();
		Thread.sleep(2000);
		pharm.moveToElement(driver.findElement(By.xpath("(//div[@title='Add Pharmacist/Technician/Manager'])[1]")))
				.build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@title='Add Pharmacist/Technician/Manager'])"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i[1]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lst_name")))
				.sendKeys("Pharmacist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age"))).sendKeys("30");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")))
				.sendKeys("cucumpharmacist@gmail.com");
		Thread.sleep(2000);
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Role']/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Pharmacist'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Pharmacies']/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum Pharmacy'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// masterdata access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		// Health access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Health Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(10000);
	}

	@And("disconnect the pharmacy with the hospital")
	public void disconnect_the_pharmacy_with_the_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// disconnect
		Actions discon = new Actions(driver);
		discon.moveToElement(driver.findElement(By.xpath("(//button[@id='bold'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id='bold'])[1]/img[1]"))).click();
		Thread.sleep(1000);
		// yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Yes'])[1]"))).click();
		Thread.sleep(10000);
		// String toast =
		// driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
		//
		// String expected_toast = "Cucum Pharmacy disconnected from Cucum Hospital.";
		//
		// Assert.assertEquals(toast, expected_toast);
		//
		// Assert.assertTrue(toast.contains("Cucum Pharmacy disconnected from Cucum
		// Hospital."));
		//
		// System.out.println("Toast message for disconnection verification is done:-" +
		// toast);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		driver.close();
		// String toast1 =
		// driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
		// System.out.println(toast1);
	}

	@Then("click on facility digital_twin from the masterdata")
	public void click_on_facility_digital_twin_from_the_masterdata() throws Exception {
		/*
		 * WebDriverWait fdt = new WebDriverWait(driver, Duration.ofSeconds(30)); try {
		 * fdt.until(ExpectedConditions .visibilityOf(driver.findElement(By.
		 * xpath("(//a[text()='Facility Digital Twin'])[1]")))).click(); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * Thread.sleep(15000);
		 */
	}

	@And("drag and drop the lab to create a new lab")
	public void drag_and_drop_the_lab_to_create_a_new_lab() throws Exception {
		// clicking on the add new button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='plusminus'])[1]"))).click();
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		try {
			action1.moveToElement(driver.findElement(By.xpath("(//img[@alt='LabIcon'])[1]"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		action1.dragAndDrop(driver.findElement(By.xpath("(//img[@alt='LabIcon'])[1]")),
				driver.findElement(By.xpath("(//div[@class='react-flow__pane'])[1]"))).build().perform();

	}

	@Then("enter the necessary details for the lab creation")
	public void enter_the_necessary_details_for_the_lab_creation() throws Exception {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// Lab name
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/input")))
				.sendKeys("Cucum lab");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab header image
		driver.findElement(By.cssSelector("input#fileInputH"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\varahi_header.png");
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab header image height
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div/input")))
				.sendKeys("70");
		Thread.sleep(1000);
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab footer image
		driver.findElement(By.cssSelector("input#fileInputF"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\varahi_footer.png");
		Thread.sleep(1000);
		Actions action4 = new Actions(driver);
		action4.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab header image height
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[5]/following-sibling::div/input")))
				.sendKeys("20");
		Thread.sleep(1000);

		// preview
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#hospitalPBtn"))).click();
		Thread.sleep(2000);

		Actions is1 = new Actions(driver);
		is1.moveToElement(driver.findElement(By.xpath("(//label[text()='Is Default'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement is_def = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			is_def.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Actions is2 = new Actions(driver);
		is2.moveToElement(driver.findElement(By.xpath("(//label[text()='Is Active'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement is_act = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			is_act.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
	}

	@And("click on the submit button to create a new lab")
	public void click_on_the_submit_button_to_create_a_new_lab() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(8000);
	}

	@Then("double click on the lab to edit")
	public void double_click_on_the_lab_to_edit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement doubleclick = driver.findElement(By.xpath("(//div[text()='Cucum Lab'])[1]"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).build().perform();
		Thread.sleep(3000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("add the lab address and save it")
	public void add_the_lab_address_and_save_it() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@title='Add/Update address'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Add/Update address'])[1]/img")))
				.click();
		Thread.sleep(1000);
		// click on the add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add +'])[1]"))).click();
		Thread.sleep(2000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[1]"))).click();
		Thread.sleep(1000);
		// address line1
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[6]/following-sibling::div/input")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[6]/following-sibling::div/input")))
				.sendKeys("test one");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line2
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[7]/following-sibling::div/input")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@id='HospitalLabel'])[7]/following-sibling::div/input")))
				.sendKeys("test two");
		Thread.sleep(1000);
		WebElement select = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/select"));
		Select city = new Select(select);
		city.selectByVisibleText("Hyderabad");
		Thread.sleep(1000);
		// area
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/input"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/input"))).sendKeys("test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[11]/following-sibling::div/input"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[11]/following-sibling::div/input"))).sendKeys("test landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input"))).sendKeys("879009");
		Thread.sleep(2000);
		// clicking on the update location button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='convert-text'])/img")))
				.click();
		Thread.sleep(2000);
		// clicking on the edit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Current Location'])[1]")))
				.click();
		Thread.sleep(2000);

		// update
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Update'])[1]"))).click();
		Thread.sleep(2000);
		// save from the address popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Add/Update address'])[1]/img")))
				.click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// ##########################################################################################
		// adding another address
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add +'])[1]"))).click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[2]"))).click();
		Thread.sleep(2000);
		// address line1
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[15]/following-sibling::div/input"))).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line2
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input"))).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement select1 = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/following-sibling::div/select"));
		Select city1 = new Select(select1);
		city1.selectByVisibleText("Ahmedabad");
		Thread.sleep(1000);
		// area
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[19]/following-sibling::div/input"))).sendKeys("test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[20]/following-sibling::div/input"))).sendKeys("test landmark");
		// pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[21]/following-sibling::div/input"))).sendKeys("879010");
		Thread.sleep(2000);

		// // close
		// driver.findElement(By.xpath("(//button[text()='X'])")).click();
		// Thread.sleep(2000);
		// #################################################################################################
		// save from the address popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Add/Update address'])[1]/img")))
				.click();
		Thread.sleep(2000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[2]"))).click();
		Thread.sleep(2000);
		// close
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='X'])[1]"))).click();
		Thread.sleep(8000);

		// adding contact
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='addphone'])[2]"))).click();
		Thread.sleep(2000);
		// add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add +'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("689321456");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("6893214569");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-email")))
				.sendKeys("cucumlabw@gmail.com");
		Thread.sleep(1000);
		try {
			// save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		// edit number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='editBtn'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#hospital-number")))
				.sendKeys("6893214560");
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Close'])[3]"))).click();
		Thread.sleep(2000);

		// close lab popup
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		WebElement click = driver.findElement(By.xpath("(//span[@title='Close'])[1]"));
		jse1.executeScript("arguments[0].click()", click);
		Thread.sleep(2000);

		// yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Yes'])[1]"))).click();
		Thread.sleep(3000);

		// // submit
		// driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		// Thread.sleep(2000);
		// // zoom in
		// driver.findElement(By.xpath("(//button[@class='react-flow__controls-button
		// react-flow__controls-zoomin'])"))
		// .click();
		// Thread.sleep(1000);
	}

	@Then("map the lab with the hospital to create tests in the lab")
	public void map_the_lab_with_the_hospital_to_create_tests_in_the_lab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
//
//		// mouse hover to the dot below of the hospital name
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//div[@data-handleid='b'])[1]"))).build().perform();
//		Thread.sleep(2000);
//
//		// Actions action1 = new Actions(driver);
//		// action1.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='b'])[1]")),
//		// driver.findElement(By.xpath(
//		// "(//div[@class='react-flow__handle react-flow__handle-top nodrag nopan target
//		// connectable connectablestart connectableend connectionindicator'])")))
//		// .build().perform();
//		// Thread.sleep(2000);
//		// // yes
//		// driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
//		// Thread.sleep(5000);
//
//		Actions action1 = new Actions(driver);
//		action1.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='b'])[1]")), driver.findElement(By.xpath(
//				"(//div[@class='react-flow__handle react-flow__handle-top nodrag nopan target connectable connectablestart connectableend connectionindicator'])[last()]")))
//				.build().perform();
//		Thread.sleep(2000);
//		// yes
//		driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
//		Thread.sleep(5000);
		Actions actions = new Actions(driver);

		// Source (hospital bottom handle)
		WebElement source = driver.findElement(By.xpath("(//div[@data-handleid='b'])[1]"));
		// Target (handle of Cucum Lab)
		WebElement target = driver.findElement(
				By.xpath("//div[.//text()[contains(.,'Cucum Lab')]]//div[contains(@class,'react-flow__handle-top')]"));
		// Perform drag manually (more reliable than dragAndDrop)
		actions.moveToElement(source).clickAndHold().moveToElement(target).pause(Duration.ofSeconds(1)).release()
				.build().perform();
		// Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Yes'])[1]"))).click();
		Thread.sleep(8000);
	}

	@And("search the created lab that is connected with the hospital")
	public void search_the_created_lab_that_is_connected_with_the_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Lab");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

	}

	@Then("mouse over on to the lab that created")
	public void mouse_over_on_to_the_lab_that_created() throws Exception {
		/*
		 * // List<WebElement> lastlab = driver // .findElements(By.
		 * xpath("(//div[@class='react-flow__node react-flow__node-Lab nopan selectable'])[1]"
		 * )); // WebElement lastlabclick = lastlab.get(lastlab.size() - 1); //
		 * lastlabclick.click(); // Thread.sleep(2000);
		 * 
		 * // List<WebElement> lastlab = driver // .findElements(By.
		 * xpath("//div[@class='react-flow__node react-flow__node-Lab nopan selectable']"
		 * )); // WebElement lastlabclick = lastlab.get(1); // Change the index to click
		 * on a different lab // lastlabclick.click(); // Thread.sleep(2000);
		 */ }

	@And("click on the lab test to create radiology pathology packages")
	public void click_on_the_lab_test_to_create_radiology_pathology_packages() throws Exception {
		Actions lab = new Actions(driver);
		lab.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Lab'])[1]/following-sibling::img[1]")))
				.build().perform();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))).build().perform();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@Then("click on the plus button to add new test1")
	public void click_on_the_plus_button_to_add_new_test1() throws Exception {
		// adding test
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add'][1]"))).click();
		Thread.sleep(3000);
	}

	@And("select the individual radio button for adding pathology test to lab")
	public void select_the_individual_radio_button_for_adding_pathology_test_to_lab() {
		// individual
		WebElement ind = driver.findElement(By.xpath("(//label[text()='Individual'])[1]"));
		ind.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the pathology radio button to add pathology test")
	public void select_the_pathology_radio_button_to_add_pathology_test() {
		// pathology
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Pathology']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("select the test name from the dropdown to add pathology test")
	public void select_the_test_name_from_the_dropdown_to_add_pathology_test() {
		// fbs
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='RBS'][1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("selecting pathology test")
	public void selecting_pathology_test() {
	}

	@Then("label name_department field automatically filled for pathology test")
	public void label_name_department_field_automatically_filled_for_pathology_test() {
	}

	@And("enter the technology for the pathology test")
	public void enter_the_technology_for_the_pathology_test() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#diagnostic_test_lab_detail_technology")))
				.sendKeys("test tech");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("enable the active checkbox for the pathology test")
	public void enable_the_active_checkbox_for_the_pathology_test() throws Exception {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
		}
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the plus button to add ideal range")
	public void click_on_the_plus_button_to_add_ideal_range() throws Exception {
		// clicking on the + ADD ideal range
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a.btn-floating.waves-effect.config_btn.green.tooltipped>i"))).click();
		Thread.sleep(2000);
	}

	@And("enter the details for diagnostic test lab configurations")
	public void enter_the_details_for_diagnostic_test_lab_configurations() throws Exception {
		// lower
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_lower_age")))
				.sendKeys("5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// upper
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_upper_age")))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// gender selection
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[@for='gender']/following-sibling::span/span[1]")))
				.click();
		Thread.sleep(1000);
		// all
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='All']"))).click();
		Thread.sleep(1000);
		// ideal range
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_ideal_range")))
				.sendKeys("70-130");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// comments
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"textarea#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_comments")))
				.sendKeys("test comments");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the plus to add new ideal range")
	public void click_on_the_plus_to_add_new_ideal_range() throws Exception {
		// clikcing on the add
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row addBtn']/a/i"))).click();
		Thread.sleep(2000);
	}

	@And("entering the details and remove last added")
	public void entering_the_details_and_remove_last_added() throws Exception {
		// lower
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='lower-age'])[2]")))
				.sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// upper
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='upper-age'])[2]")))
				.sendKeys("150");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// gender-selection
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='gender']/following-sibling::span/span[1])[2]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='All']"))).click();
		Thread.sleep(1000);
		// ideal range
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='ideal-range'])[2]")))
				.sendKeys("70-120");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// removing
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i")))
				.click();
		Thread.sleep(1000);
	}

	@Then("click on the continue button for pathology test")
	public void click_on_the_continue_button_for_pathology_test() throws Exception {
		// continue
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("button.waves-effect.waves-dark.btn.green.btnContinue.next-step.right"))).click();
		Thread.sleep(2000);
	}

	@And("entering the cost and price of that pathology test")
	public void entering_the_cost_and_price_of_that_pathology_test() {
		// cost
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_cost")))
				.sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price")))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for saving pathology test")
	public void click_on_the_save_button_for_saving_pathology_test() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("add the op price charge configurations from opd hospital")
	public void add_the_op_price_charge_configurations_from_opd_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		/*
		 * // searching lab
		 * driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum");
		 * Thread.sleep(2000); JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		 * WebElement element =
		 * driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]")); //
		 * jse5.executeScript("arguments[0].click();", element); // Thread.sleep(3000);
		 * // // mouse hovering on to the hospital // Actions action1 = new
		 * Actions(driver); // action1.moveToElement(driver.findElement(By.
		 * xpath("(//div[text()='Cucum Lab'])[1]"))).build().perform(); //
		 * Thread.sleep(3000); // Actions action2 = new Actions(driver); //
		 * action2.moveToElement(driver.findElement(By.
		 * xpath("(//div[text()='Diagnostic Test'])[1]"))).build().perform(); //
		 * Thread.sleep(2000); // WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(30)); wait.until(
		 * ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("(//div[text()='Diagnostic Test'])[1]")))) .click();
		 * Thread.sleep(5000);
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text()='Test Name')])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='RBS'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(2000);
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(2000);
		WebElement selfdefined = driver.findElement(By.xpath("(//label[text()='Self defined'])[2]"));
		selfdefined.click();
		Thread.sleep(2000);
		// selecting the hospital opd
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Hospital'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		// entering charge code
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Charge Code'])[2]/following-sibling::input[1]")))
				.sendKeys("rbs-op");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Payment Mode'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Self'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")))
				.sendKeys("100");
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("add the ip price charge configurations from ipd hospital")
	public void add_the_ip_price_charge_configurations_from_ipd_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the brand logo & changing role
		WebDriverWait logoclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		logoclick.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))))
				.click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]")))
				.click();
		Thread.sleep(2000);
		// selecting Role clicking on IPD Clinic_manager Role
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[normalize-space(text())='IPBillingManager'])[1]")))
				.click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(18000);
		// searching lab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx"))).sendKeys("Cucum");
		Thread.sleep(2000);

		JavascriptExecutor jse511 = (JavascriptExecutor) driver;
		WebElement element2 = driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]"));
		jse511.executeScript("arguments[0].click();", element2);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action11 = new Actions(driver);
		action11.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Lab'])[1]"))).build().perform();
		Thread.sleep(3000);
		Actions action31 = new Actions(driver);
		action31.moveToElement(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text()='Test Name')])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='RBS'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(2000);
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[2]"));
		yes.click();
		Thread.sleep(2000);
		// clicking on the self defined radio btn
		WebElement selfdef = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		selfdef.click();
		Thread.sleep(2000);
		// selecting the hospital
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Hospital'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the health system
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Provider'])[1]"))).click();
		Thread.sleep(1000);
		// entering the charge code
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Charge Code'])[1]/following-sibling::input[1]")))
				.sendKeys("rbs-ip");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))).sendKeys("rbs ip");
		Thread.sleep(1000);
		// selecting the program
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the room type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(), 'Test')])[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the department
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//li[contains(text(), 'General Surgery')])[1]"))).click();
		Thread.sleep(1000);
		// selecting the payment mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(), 'Insurance')])[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the insurance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(), 'Insurance')])[1]")))
				.click();
		Thread.sleep(1000);
		// clearing the price & renetering the price and saving
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")))
				.sendKeys("100");
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("add the op and ip price charge configurations from cdpadmin role")
	public void add_the_op_and_ip_price_charge_configurations_from_cdpadmin_role() throws Exception {

		// // clicking on the brand logo & changing role
		// WebDriverWait logoclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		// logoclick.until(
		// ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))))
		// .click();
		// Thread.sleep(3000);
		// // selecting the NanoHealth CDP
		// driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		// Thread.sleep(3000);
		// // selecting Role clicking on cdp admin Role
		// driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		// Thread.sleep(3000);
		//// // click on the masterdata button
		//// driver.findElement(By.xpath("(//a[text()='Master Data'])[1]")).click();
		//// Thread.sleep(5000);
		// // click on the facility digital twin button from masterdata
		// driver.findElement(By.xpath("(//a[text()='Facility Digital
		// Twin'])[1]")).click();
		// Thread.sleep(18000);
		// // searching lab
		// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum");
		// Thread.sleep(2000);
		//
		// JavascriptExecutor jse511 = (JavascriptExecutor) driver;
		// WebElement element2 = driver.findElement(By.xpath("(//option[text()='Cucum
		// Lab (Lab)'])[1]"));
		// jse511.executeScript("arguments[0].click();", element2);
		// Thread.sleep(3000);
		// // mouse hovering on to the hospital
		// Actions action11 = new Actions(driver);
		// action11.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum
		// Lab'])[1]"))).build().perform();
		// Thread.sleep(3000);
		// Actions action31 = new Actions(driver);
		// action31.moveToElement(driver.findElement(By.xpath("(//div[text()='Diagnostic
		// Test'])[1]"))).build().perform();
		// Thread.sleep(2000);
		// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait1.until(
		// ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Diagnostic
		// Test'])[1]"))))
		// .click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("(//label[normalize-space(text()='Test
		// Name')])[1]/following-sibling::span[1]"))
		// .click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='RBS'])[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		// Thread.sleep(3000);
		//// // removing already added op price charge configuration
		//// driver.findElement(By.xpath("(//i[@class='fa
		// fa-times-circle'])[3]")).click();
		//// Thread.sleep(2000);
		// // clicking on the plus button to add op price charge configuration
		// driver.findElement(By.xpath("(//i[text()='add'])[5]")).click();
		// Thread.sleep(2000);
		// // clicking on the flat increase
		// driver.findElement(By.xpath("(//label[text()='Flat increase'])[2]")).click();
		// Thread.sleep(2000);
		// // selecting the hospital opd
		// driver.findElement(By.xpath("(//label[text()='Hospital'])[3]/following-sibling::span[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		// Thread.sleep(1000);
		// // entering charge code
		// driver.findElement(By.xpath("(//label[text()='Charge
		// Code'])[3]/following-sibling::input[1]"))
		// .sendKeys("rbs-op");
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//label[text()='Program'])[3]/following-sibling::span[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//label[text()='Payment
		// Mode'])[3]/following-sibling::span[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//li[text()='Self'])[1]")).click();
		// Thread.sleep(1000);
		// // entering the flat increase amount
		// driver.findElement(By.xpath("(//label[text()='Flat
		// Increase'])[3]/following-sibling::input[1]")).clear();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//label[text()='Flat
		// Increase'])[3]/following-sibling::input[1]"))
		// .sendKeys("100" + Keys.TAB);
		// Thread.sleep(2000);
		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(5000);
		// // edit the rbs again
		// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		// Thread.sleep(2000);
		// // click on the ip charge price configurations
		// driver.findElement(By.xpath("(//a[text()='IP Charge Price
		// Configurations'])[1]")).click();
		// Thread.sleep(2000);
		// WebElement no2 = driver.findElement(By.xpath("(//label[text()='No'])[2]"));
		// no2.click();
		// Thread.sleep(1000);
		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(5000);
		//
		// // changing role to clinic manager from cdp admin role
		// // clicking on the brand logo & changing role
		// WebDriverWait logoclick1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// logoclick1.until(
		// ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))))
		// .click();
		// Thread.sleep(3000);
		// // selecting the NanoHealth CDP
		// driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		// Thread.sleep(3000);
		// // selecting Role clicking on IPD Clinic_manager Role
		// driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager -
		// NanoHealth_OPD'])[1]")).click();
		// Thread.sleep(3000);
		// Actions action = new Actions(driver);
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		// Thread.sleep(1000);
		// action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility
		// Digital Twin'])[1]"))).click().build()
		// .perform();
		// Thread.sleep(18000);
		// // searching lab
		// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum");
		// Thread.sleep(2000);
		//
		// JavascriptExecutor jse51 = (JavascriptExecutor) driver;
		// WebElement element3 = driver.findElement(By.xpath("(//option[text()='Cucum
		// Lab (Lab)'])[1]"));
		// jse51.executeScript("arguments[0].click();", element3);
		// Thread.sleep(3000);
		// // mouse hovering on to the hospital
		// Actions action111 = new Actions(driver);
		// action111.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum
		// Lab'])[1]"))).build().perform();
		// Thread.sleep(3000);
		// Actions action311 = new Actions(driver);
		// action311.moveToElement(driver.findElement(By.xpath("(//div[text()='Diagnostic
		// Test'])[1]"))).build().perform();
		// Thread.sleep(2000);
		// WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait11.until(
		// ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Diagnostic
		// Test'])[1]"))))
		// .click();
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("(//label[normalize-space(text()='Test
		// Name')])[1]/following-sibling::span[1]"))
		// .click();
		// Thread.sleep(1000);

	}

	@And("click on the plus button to add new test2")
	public void click_on_the_plus_button_to_add_new_test2() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// adding test
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(3000);
	}

	@Then("select the individual radio button for adding radiology test to lab")
	public void select_the_individual_radio_button_for_adding_radiology_test_to_lab() {
		WebElement ind1 = driver.findElement(By.xpath("(//label[text()='Individual'])[1]"));
		ind1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("select the radiology radio button to add radiology test")
	public void select_the_radiology_radio_button_to_add_radiology_test() {
		// radilogy
		WebElement rad = driver.findElement(By.xpath("(//label[text()='Radiology'])[1]"));
		rad.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the test name from the dropdown to add radiology test")
	public void select_the_test_name_from_the_dropdown_to_add_radiology_test() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// OPG
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'OPG')][1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// active
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='Active'])[2]")).click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("selecting radiology test")
	public void selecting_radiology_test() {

	}

	@Then("click on the continue button for radiology test")
	public void click_on_the_continue_button_for_radiology_test() throws Exception {
		// continue
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(1000);

	}

	@And("entering the cost and price of that radiology test")
	public void entering_the_cost_and_price_of_that_radiology_test() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// cost
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_cost")))
				.sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price")))
				.sendKeys("2500");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for saving radiology test")
	public void click_on_the_save_button_for_saving_radiology_test() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("click on the plus button to add new test3")
	public void click_on_the_plus_button_to_add_new_test3() throws Exception {
		// adding test
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(3000);
	}

	@Then("select the profile radio button for adding profile pathology test to lab")
	public void select_the_profile_radio_button_for_adding_profile_pathology_test_to_lab() throws Exception {

		WebElement profile = driver.findElement(By.xpath("(//label[text()='Profile'])[1]"));
		profile.click();
		Thread.sleep(1000);
	}

	@And("select the pathology radio button to add profile pathology test")
	public void select_the_pathology_radio_button_to_add_profile_pathology_test() {
		// pathology
		WebElement path = driver.findElement(By.xpath("(//label[text()='Pathology'])[1]"));
		path.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the test name from the dropdown to add profile pathology test")
	public void select_the_test_name_from_the_dropdown_to_add_profile_pathology_test() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Thyroid Profile'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@When("selecting profile pathology test")
	public void selecting_profile_pathology_test() {
	}

	@Then("label name_department field automatically filled for profile pathology test")
	public void label_name_department_field_automatically_filled_for_profile_pathology_test() {
	}

	@And("enter the technology for the profile pathology test")
	public void enter_the_technology_for_the_profile_pathology_test() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#diagnostic_test_lab_detail_technology")))
				.sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enable the active checkbox for the profile pathology test")
	public void enable_the_active_checkbox_for_the_profile_pathology_test() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the plus button to add ideal range for profile pathology test")
	public void click_on_the_plus_button_to_add_ideal_range_for_profile_pathology_test() throws Exception {
		// clicking on the + ADD ideal range
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a.btn-floating.waves-effect.config_btn.green.tooltipped>i"))).click();
		Thread.sleep(2000);
	}

	@And("enter the details for diagnostic test lab configurations for profile pathology test")
	public void enter_the_details_for_diagnostic_test_lab_configurations_for_profile_pathology_test() throws Exception {
		// lower
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_lower_age")))
				.sendKeys("5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// upper
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_upper_age")))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// gender selection
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[@for='gender']/following-sibling::span/span[1]")))
				.click();
		Thread.sleep(1000);
		// all
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='All']"))).click();
		Thread.sleep(1000);
		// ideal range
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_ideal_range")))
				.sendKeys("70-130");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// comments
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"textarea#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_comments")))
				.sendKeys("test comments");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the continue button for profile pathology test")
	public void click_on_the_continue_button_for_profile_pathology_test() throws Exception {
		// continue
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("button.waves-effect.waves-dark.btn.green.btnContinue.next-step.right"))).click();
		Thread.sleep(2000);
	}

	@And("entering the cost and price of that profile pathology test")
	public void entering_the_cost_and_price_of_that_profile_pathology_test() {
		// cost
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_cost")))
				.sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price")))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for saving profile pathology test")
	public void click_on_the_save_button_for_saving_profile_pathology_test() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("add the interpretation for the profile test and save it")
	public void add_the_interpretation_for_the_profile_test_and_save_it() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Test Name'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Thyroid Profile')])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the interpretation button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-comment fa-solid'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#interpretation"))).sendKeys(
				"Thyroid profile interpretation involves analyzing TSH, T3, and T4 levels to understand if the thyroid is overactive (hyperthyroidism) or underactive (hypothyroidism). A standard TSH test is often the first step, as high levels indicate an underactive thyroid and low levels suggest an overactive thyroid");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("click on the plus button to add new test5")
	public void click_on_the_plus_button_to_add_new_test5() throws Exception {
		/*
		 * // searching lab
		 * driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum");
		 * Thread.sleep(2000);
		 * 
		 * JavascriptExecutor jse511 = (JavascriptExecutor) driver; WebElement element2
		 * = driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]"));
		 * jse511.executeScript("arguments[0].click();", element2); Thread.sleep(3000);
		 * // mouse hovering on to the hospital Actions action11 = new Actions(driver);
		 * action11.moveToElement(driver.findElement(By.
		 * xpath("(//div[text()='Cucum Lab'])[1]"))).build().perform();
		 * Thread.sleep(3000); Actions action31 = new Actions(driver);
		 * action31.moveToElement(driver.findElement(By.
		 * xpath("(//div[text()='Diagnostic Test'])[1]"))).build().perform();
		 * Thread.sleep(2000); WebDriverWait wait1 = new WebDriverWait(driver,
		 * Duration.ofSeconds(30)); wait1.until(
		 * ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("(//div[text()='Diagnostic Test'])[1]")))) .click();
		 * Thread.sleep(5000);
		 */
		// adding test
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(3000);
	}

	@And("select the popular package radio button to add popular package")
	public void select_the_popular_package_radio_button_to_add_popular_package() {
		WebElement pkg = driver.findElement(By.xpath("(//label[text()=' Popular Package'])[1]"));
		pkg.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("enter the popular package test name")
	public void enter_the_popular_package_test_name() {
		// test name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_test_name")))
				.sendKeys("Cucum testpkg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("disable and enable the checkboxes of the popular package")
	public void disable_and_enable_the_checkboxes_of_the_popular_package() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i <= 1; i++) {
			WebElement individual = driver.findElement(By.xpath("(//label[text()='Individual'])[2]"));
			individual.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i <= 1; i++) {
			WebElement grouponly = driver.findElement(By.xpath("(//label[text()='Group only'])[1]"));
			grouponly.click();
		}
	}

	@Then("selecting the test name from the dropdown to add into the popular package")
	public void selecting_the_test_name_from_the_dropdown_to_add_into_the_popular_package() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[1]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[1]/following-sibling::input[1]")))
				.sendKeys("0" + Keys.TAB);
		Thread.sleep(1000);
		// clicking on the dropdown
		// driver.findElement(By.xpath("(//label[text()='Test
		// Name'])[2]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MRI Spectroscopy'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("clicking on the plus button to select one more test1")
	public void clicking_on_the_plus_button_to_select_one_more_test1() throws Exception {
		// add
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='addButton'])[1]/a[1]"))).click();
		Thread.sleep(1000);
	}

	@And("entering the order number1")
	public void entering_the_order_number1() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[2]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[2]/following-sibling::input[1]")))
				.sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
	}

	@Then("selecting the test name1 from the dropdown to add into the popular package")
	public void selecting_the_test_name1_from_the_dropdown_to_add_into_the_popular_package() throws Exception {
		// clicking on the dropdown
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//label[text()='Test
		// Name'])[4]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cross Match'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("clicking on the plus button to select one more test2")
	public void clicking_on_the_plus_button_to_select_one_more_test2() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#diagnostic_test_lab_detail_test_name"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='addButton'])[1]/a[1]"))).click();
		Thread.sleep(1000);
	}

	@And("entering the order number2")
	public void entering_the_order_number2() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[3]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[3]/following-sibling::input[1]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
	}

	@Then("selecting the test name2 from the dropdown to add into the popular package")
	public void selecting_the_test_name2_from_the_dropdown_to_add_into_the_popular_package() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[3]/following-sibling::input[1]")))
				.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		// clicking on the dropdown
		// driver.findElement(By.xpath("(//label[text()='Test
		// Name'])[5]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'ECG')])[1]")))
				.click();
		Thread.sleep(3000);
	}

	@And("clicking on the plus button to select one more test3")
	public void clicking_on_the_plus_button_to_select_one_more_test3() throws Exception {
		// add
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='addButton'])[1]/a[1]"))).click();
		Thread.sleep(1000);
	}

	@And("entering the order number3")
	public void entering_the_order_number3() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[4]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[4]/following-sibling::input[1]")))
				.sendKeys("3" + Keys.TAB);
		Thread.sleep(1000);
	}

	@Then("selecting the test name3 from the dropdown to add into the popular package")
	public void selecting_the_test_name3_from_the_dropdown_to_add_into_the_popular_package() throws Exception {
		// clicking on the dropdown
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//label[text()='Test
		// Name'])[6]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'ECG')])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@And("adding one of the profiletest in package")
	public void adding_one_of_the_profiletest_in_package() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='addButton'])[1]/a[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[4]/following-sibling::input[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[@for='order_id'])[4]/following-sibling::input[1]")))
				.sendKeys("4" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Lipid Profile')])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@And("removing the last added test name for the popular package")
	public void removing_the_last_added_test_name_for_the_popular_package() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-times-circle'])[3]")))
				.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		// 🔹 Zoom IN (Ctrl + +)
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_0); // Press '+'
			robot.keyRelease(KeyEvent.VK_0);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
	}

	@Then("clicking on the continue button from the popular package popup")
	public void clicking_on_the_continue_button_from_the_popular_package_popup() throws Exception {
		// continue
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("entering the cost and price for the popular package")
	public void entering_the_cost_and_price_for_the_popular_package() {
		// cost
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_cost")))
				.sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price")))
				.sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button to save the popular package")
	public void click_on_the_save_button_to_save_the_popular_package() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("popular package is saved")
	public void popular_package_is_saved() {

	}

	@And("deleting the one test OPG")
	public void deleting_the_one_test_OPG() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().refresh();

		Thread.sleep(2000);
		// deleting the test OPG
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Test Name'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'OPG')])[1]")))
				.click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash-o'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Confirm!']"))).click();
		Thread.sleep(5000);
	}

	@Then("mouse-hovering to the tests in the cucumber testlab")
	public void mouse_hovering_to_the_tests_in_the_cucumber_testlab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// // mouse hovering to the package
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		// Thread.sleep(2000);
		// Actions pkg = new Actions(driver);
		// pkg.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Package'])[1]/img"))).build().perform();
		// Thread.sleep(2000);
		// try {
		// // wait up to 15 seconds for visibility
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//
		// WebElement icon = wait.until(ExpectedConditions
		// .visibilityOfElementLocated(By.xpath("(//span[@class='tooltipped
		// childs_tests'])[1]/i[1]")));
		//
		// // perform mouse hover or click
		// Actions actions = new Actions(driver);
		// actions.moveToElement(icon).perform();
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		// download report
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).click();
		Thread.sleep(3000);
	}

	@And("click on the edit for popular package")
	public void click_on_the_edit_for_popular_package() throws Exception {

	}

	@Then("update the price and click on save button from edit package")
	public void update_the_price_and_click_on_save_button_from_edit_package() throws Exception {

	}

	@And("click on the edit2")
	public void click_on_the_edit2() throws Exception {
		// EDIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//I[@class='fa fa-pencil'])[2]"))).click();
		Thread.sleep(2000);
	}

	@Then("update the price and click on save button2")
	public void update_the_price_and_click_on_save_button2() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// continue
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(1000);
		// price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price")))
				.sendKeys("1500");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);

	}

	@And("click on the edit3")
	public void click_on_the_edit3() throws Exception {
		// EDIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//I[@class='fa fa-pencil'])[3]"))).click();
		Thread.sleep(2000);
	}

	@Then("update the price and click on save button3")
	public void update_the_price_and_click_on_save_button3() throws Exception {
		// continue
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(1000);
		// price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnostic_test_lab_detail_price")))
				.sendKeys("300");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("click on the edit4")
	public void click_on_the_edit4() throws Exception {
	}

	@Then("update the price and click on save button4")
	public void update_the_price_and_click_on_save_button4() throws Exception {

	}

	@And("searching test name and type using search")
	public void searching_test_name_and_type_using_search() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// test name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='RBS']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(1000);
		// active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[3]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Yes'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(1000);
		// active
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[3]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='No'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// test type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Radiology'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(2000);
	}

	@Then("click on the linked hospital button")
	public void click_on_the_linked_hospital_button() throws Exception {
		// link-hospitals
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-link'][1]"))).click();
		Thread.sleep(1000);
	}

	@And("add the hospital name and save it")
	public void add_the_hospital_name_and_save_it() throws Exception {
		// add
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='addressAdd'])[1]/a[1]")))
				.click();
		Thread.sleep(1000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		robot2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the linked hospital button again")
	public void clicking_on_the_linked_hospital_button_again() throws Exception {
		// link-hospitals
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-link']"))).click();
		Thread.sleep(1000);
	}

	@And("removing the mapped hospital from linked hospitals")
	public void removing_the_mapped_hospital_from_linked_hospitals() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// remove
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-times-circle'])[2]")))
				.click();
		Thread.sleep(3000);
		// closing
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='modal-close nh_close btn-floating'])[2]/i[1]")))
				.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// // back
		// driver.findElement(By.xpath("//a[text()='Back']")).click();
		// Thread.sleep(2000);
	}

	@When("linked hospital removed and clicking on the back button")
	public void linked_hospital_removed_and_clicking_on_the_back_button() {
	}

	@Then("add lab slots for the newly created lab")
	public void add_lab_slots_for_the_newly_created_lab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Slots'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Appointment Type'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Lab')])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Monday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Tuesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Wednesday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Thursday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Friday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Saturday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='select2-search__field'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Sunday'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='select2-selection__choice__remove'])[8]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='start_time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[10]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]"))).click();
		Thread.sleep(1000);
		// end-date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='end_time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//table[@id='example'])[2]/tbody[1]/tr[1]/td[6]/a[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='e_start_time'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[3]/div[9]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[3]/button[2]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='btn green update_save'])[1]")))
				.click();
		Thread.sleep(3000);
		// deleting one of the slot days
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//table[@id='example'])[2]/tbody[1]/tr[2]/td[6]/a[2]/i[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Confirm!'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='slot-modal'])[1]/div[1]/div[1]/span[1]/i[1]")))
				.click();
		Thread.sleep(2000);
	}

	@Then("add newly created popular package in another lab")
	public void add_newly_created_popular_package_in_another_lab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the reports and selecting digital twin
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(18000);
		// searching lab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("NanoHealth");
		Thread.sleep(2000);
		JavascriptExecutor jse511 = (JavascriptExecutor) driver;
		WebElement element2 = driver.findElement(By.xpath("(//option[text()='NanoHealth_Lab1 (Lab)'])[1]"));
		jse511.executeScript("arguments[0].click();", element2);
		Thread.sleep(3000);
		// mouse hovering on to the lab
		Actions action11 = new Actions(driver);
		action11.moveToElement(
				driver.findElement(By.xpath("(//div[text()='NanoHealth_Lab1'])[1]/following-sibling::img[1]"))).build()
				.perform();
		Thread.sleep(3000);
		Actions action31 = new Actions(driver);
		action31.moveToElement(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))))
				.click();
		Thread.sleep(5000);
		// clicking on the add new test
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[1]"))).click();
		Thread.sleep(5000);
		WebElement popularpackage = driver
				.findElement(By.xpath("(//label[normalize-space(text())='Popular Package'])[1]"));
		popularpackage.click();
		Thread.sleep(3000);
		// click on the existing radio btn
		WebElement existing = driver.findElement(By.xpath("(//label[text()='Existing'])[1]"));
		existing.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//span[@id='select2-diagnostic_test_master_select-container'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum')])[1]")))
				.click();
		Thread.sleep(3000);
		// click on the continue button
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//button[@class='waves-effect waves-dark btn green btnContinue next-step right'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='diagnostic_test_lab_detail_cost'])[1]")))
				.sendKeys("300");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='diagnostic_test_lab_detail_price'])[1]")))
				.sendKeys("200");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("add copy as popular package in the created lab")
	public void add_copy_as_popular_package_in_the_another_lab() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the reports and selecting digital twin
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-reports'])[1]"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(18000);
		// searching lab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx"))).sendKeys("Cucum");
		Thread.sleep(2000);
		JavascriptExecutor jse511 = (JavascriptExecutor) driver;
		WebElement element2 = driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]"));
		jse511.executeScript("arguments[0].click();", element2);
		Thread.sleep(3000);
		Actions lab = new Actions(driver);
		lab.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Lab'])[1]/following-sibling::img[1]")))
				.build().perform();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Diagnostic Test'])[1]"))))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[1]"))).click();
		Thread.sleep(3000);
		WebElement popularpkg = driver.findElement(By.xpath("(//label[normalize-space(text())='Popular Package'])[1]"));
		popularpkg.click();
		Thread.sleep(2000);
		WebElement copyas = driver.findElement(By.xpath("(//label[text()='Copy As'])[1]"));
		copyas.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//span[@id='select2-copy_diagnostic_test_master_select-container'])[1]"))).click();
		Thread.sleep(2000);
//		Robot pgdwn = new Robot();
//		pgdwn.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		pgdwn.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(2000);
//		pgdwn.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='copy_pkg_test_name'])[1]")))
//				.sendKeys("Copy as popular package" + Keys.TAB);
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Testing_package'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='copy_pkg_test_name'])[1]"))).sendKeys("Copy as popular package" + Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#diagnostic_test_lab_detail_cost")))
				.sendKeys("100" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='diagnostic_test_lab_detail_price'])[1]")))
				.sendKeys("100" + Keys.TAB);
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@Then("open facility digital twin and search for the hospital")
	public void open_facility_digital_twin_and_search_for_the_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Cucum Lab");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		Actions hsptl = new Actions(driver);
		hsptl.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Lab'])[1]/following-sibling::img[1]")))
				.build().perform();
		Thread.sleep(2000);
	}

	@When("mouse hover on the lab and click on the add technician_pathologist")
	public void mouse_hover_on_the_lab_and_click_on_the_add_technician_pathologist() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='Users'])[1]"))).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Users'])[1]")))).click();
		Thread.sleep(5000);
	}

	@Then("user details page will be opened")
	public void user_details_page_will_be_opened() {
	}

	@And("click on the add button to create a new user with technician_pathologist")
	public void click_on_the_add_button_to_create_a_new_user_with_technician_pathologist() throws Exception {
		WebDriverWait plus = new WebDriverWait(driver, Duration.ofSeconds(30));
		plus.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[text()='add'])[1]")))).click();
		Thread.sleep(3000);

	}

	@Then("enter the details of the user and click on continue")
	public void enter_the_details_of_the_user_and_click_on_continue() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name")))
				.sendKeys("CucumLab");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lst_name")))
				.sendKeys("Radiologist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age"))).sendKeys("40");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("//li[text()='+91']")).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr"))).sendKeys("8833828282");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@And("select the roles technician_pathologist and save")
	public void select_the_roles_technician_pathologist_and_save() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Role']/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Lab_Technician'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='DiagnosticLabMasters']/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum Lab'])[1]"))).click();
		Thread.sleep(1000);
		// more
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='show_more_fields'])[1]/img")))
				.click();
		Thread.sleep(1000);
		// full access
		WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
		fa.click();
		Thread.sleep(1000);
		// verified
		WebElement ver = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
		ver.click();
		Thread.sleep(1000);
		// less
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='Less'])[1]"))).click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("existing teamdetails is deleted")
	public void existing_teamdetails_is_deleted() throws Exception {
	}

	@And("click on the teamdetails button from the masterdata dashboard")
	public void click_on_the_teamdetails_button_from_the_masterdata_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the user details button in digital twin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='User Details'])[1]")))
				.click();
		Thread.sleep(5000);
	}

	@Then("click on the plus button to add new user")
	public void click_on_the_plus_button_to_add_new_user() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i")))
				.click();
		Thread.sleep(1000);
	}

	@And("enter the necessary details of the user")
	public void enter_the_necessary_details_of_the_user() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// first name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name")))
				.sendKeys("Cucumber");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// last name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lst_name")))
				.sendKeys("Userrole");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age"))).sendKeys("45");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr"))).sendKeys("6566566560");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		// // mail
		// driver.findElement(By.cssSelector("input#email:nth-of-type(1)")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// profile picture
		// driver.findElement(By.cssSelector("input#files_constr"))
		// .sendKeys("C:\\Users\\Lenovo\\Desktop\\userroleimage.png");
		// Thread.sleep(1000);
	}

	@When("details has been entered then continue button will enable and turn to green colour")
	public void details_has_been_entered_then_continue_button_will_enable_and_turn_to_green_colour() {
	}

	@Then("click on the continue button to add the roles to user")
	public void click_on_the_continue_button_to_add_the_roles_to_user() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(3000);
	}
	
	@And("select the role from the roles popup and select the required options from the role fields")
	public void select_the_role_from_the_roles_popup_and_select_the_required_options_from_the_role_fields()
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Role']/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[contains(text(), 'Clinic')])[1]"))))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Hospitals']/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		WebDriverWait hsplt = new WebDriverWait(driver, Duration.ofSeconds(30));
		hsplt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]"))))
				.click();
		Thread.sleep(2000);
		// clicking on the more
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
			fa.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement md = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
			md.click();
//			Thread.sleep(1000);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement md = driver.findElement(By.xpath("(//label[text()='Health Access'])[1]"));
			md.click();
//			Thread.sleep(1000);
		}

		// clicking on the less
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='Less'])[1]"))).click();
		Thread.sleep(1000);

		// clicking on the save
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])/i[1]")))).click();
		// driver.findElement(By.xpath("(//a[@data-tooltip='Add New
		// User'])/i[1]")).click();
		Thread.sleep(3000);
		// number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr")))
				.sendKeys("6566566560" + Keys.TAB);
		Thread.sleep(3000);
		// YES
		WebDriverWait yes = new WebDriverWait(driver, Duration.ofSeconds(30));
		yes.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Yes'])[1]")))).click();
		// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
		Thread.sleep(3000);
		// number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr")))
				.sendKeys("6566566561" + Keys.TAB);
		Thread.sleep(2000);
		// continue
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Continue'])[1]"))).click();
		Thread.sleep(3000);

	}

	@Then("click on the plus button to add new role to the user")
	public void click_on_the_plus_button_to_add_new_role_to_the_user() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(2000);
	}

	@And("select the another role and role required options from the dropdowns")
	public void select_the_another_role_and_role_required_options_from_the_dropdowns() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Role'])[3]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		// Thread.sleep(3000);
		WebElement nameField = driver.findElement(By.xpath(
				"//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'doctor')]"));
		nameField.click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath(
					"/html/body/main/div[5]/div/div[2]/form/ul/li[2]/div[2]/div[1]/div[2]/div/div[1]/div[3]/span"))
					.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[2]")))
				.click();
		Thread.sleep(1000);
		// // signature of the doctor
		// driver.findElement(By.cssSelector("input#files_sign"))
		// .sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\doctorsignature.png");
		// Thread.sleep(1000);
		// clicking on the more
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[2]"))).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[2]"));
			fa.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement md = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[2]"));
			md.click();
		}
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1000);
		// clicking on the less
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='Less'])[2]"))).click();
		Thread.sleep(2000);

	}

	@Then("add the ipbillingmanager role with financial access")
	public void add_the_ipbillingmanager_role_with_financial_access() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[normalize-space(text())='Role'])[4]/preceding-sibling::span[1]"))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[contains(text(), 'IPB')])[1]")).click();
		// Thread.sleep(1000);
		WebElement nameField = driver.findElement(By.xpath(
				"//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'ipbillingmanager')]"));
		nameField.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[3]"))).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 2; i++) {
			WebElement finaccess = driver.findElement(By.xpath("(//label[text()='Financial access'])[1]"));
			finaccess.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		WebElement discount = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		discount.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Report Access (Days)'])[1]/following-sibling::input[1]"))
				.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Past Access (Days)'])[1]/following-sibling::input[1]"))
				.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement yes1 = driver.findElement(By.xpath("(//label[text()='Yes'])[2]"));
		yes1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Invoice Date Change (Days)'])[1]/following-sibling::input[1]"))
				.sendKeys("10");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Invoice Date Change (Days)'])[1]/following-sibling::input[1]"))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		WebElement fullaccess = driver.findElement(By.xpath("(//label[text()='Full Access'])[3]"));
		fullaccess.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement masterdataaccess = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[3]"));
		masterdataaccess.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement verified = driver.findElement(By.xpath("(//label[text()='Verified'])[3]"));
		verified.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement hlthaccess = driver.findElement(By.xpath("(//label[text()='Health Access'])[3]"));
		hlthaccess.click();
		Thread.sleep(1000);

	}

	@And("click on the save button from the roles page")
	public void click_on_the_save_button_from_the_roles_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("save button is clicked it will redirect to the users role page")
	public void save_button_is_clicked_it_will_redirect_to_the_users_role_page() {
	}

	@And("click on the save button from the edit user role")
	public void click_on_the_save_button_from_the_edit_user_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		/*
		 * driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		 * Thread.sleep(3000);
		 */
		// share credentials
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Share Credetiatls'])[1]")))
				.click();
		Thread.sleep(2000);
		// select create a password
		WebElement createpswd = driver.findElement(By.xpath("(//label[text()='Create Password'])[1]"));
		createpswd.click();
		Thread.sleep(1000);
		// entering test dummy password
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("Demo@123");
		Thread.sleep(1000);
		// select automatically generate a password
		WebElement automatpswd = driver
				.findElement(By.xpath("(//label[text()='Automatically generate a password'])[1]"));
		createpswd.click();
		Thread.sleep(1000);
		// share
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Share'])[1]"))).click();
		Thread.sleep(5000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(3000);

		// searching through filter
		driver.findElement(By.cssSelector("input#q_frst_nm_or_lst_nm_cont")).sendKeys("userrole");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.cssSelector("a.btn.clear_btn.btn-loader")).click();
		Thread.sleep(2000);

	}

	@Then("navigate to the masterdata dashboard from teamdetails page")
	public void navigate_to_the_masterdata_dashboard_from_teamdetails_page() throws Exception {
		driver.close();
	}

	@Then("click on the team details button from the masterdata")
	public void click_on_the_team_details_button_from_the_masterdata() throws Exception {

		WebDriverWait teamdetails = new WebDriverWait(driver, Duration.ofSeconds(30));
		teamdetails.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='User Details'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@And("click on the plus button to add new healthcoach from teamdetails")
	public void click_on_the_plus_button_to_add_new_healthcoach_from_teamdetails() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i")))
				.click();
		Thread.sleep(3000);
	}

	@Then("enter the details like first and last name age email no profile picture")
	public void enter_the_details_like_first_and_last_name_age_email_no_profile_picture() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Healthcoach");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement female = driver.findElement(By.xpath("(//label[text()='F'])[1]"));
			female.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.cssSelector("input#age")).sendKeys("35");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("cucumhc@gmail.com");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input#files_constr"))
		// .sendKeys("C:\\Users\\Lenovo\\Desktop\\Uploads\\hc.png");
		// Thread.sleep(1000);
		// Robot robot1 = new Robot();
		// robot1.keyPress(KeyEvent.VK_TAB);
		// Thread.sleep(1000);
	}

	@And("click on the continue button from the team details")
	public void click_on_the_continue_button_from_the_team_details() throws Exception {
		WebDriverWait cont = new WebDriverWait(driver, Duration.ofSeconds(30));
		cont.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select the role as healthcoach from the dropdown")
	public void select_the_role_as_healthcoach_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Role']/preceding-sibling::span[1]\r\n" + ""))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='HealthCoach'])[1]")).click();
		// Thread.sleep(1000);
		WebElement nameField = driver.findElement(By.xpath(
				"//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'healthcoach')]"));
		nameField.click();
		Thread.sleep(3000);
	}

	@When("healthcoach role is selected location will be automatically update")
	public void healthcoach_role_is_selected_location_will_be_automatically_update() throws Exception {
	}

	@Then("select the city and area from the dropdown")
	public void select_the_city_and_area_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='City'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(3000);
		// selecting the zone - hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Zones']/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='City'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Hyd')])[1]")))
				.click();
		Thread.sleep(2000);
		// selecting the area
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[normalize-space(text())='Areas']/following-sibling::span[1]"))).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'IndiraNagar_1')])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Programs'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the program
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@And("click on the more button to add more details")
	public void click_on_the_more_button_to_add_more_details() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("enable the required checkboxes")
	public void enable_the_required_checkboxes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		for (int i = 0; i <= 2; i++) {
//			WebElement ma = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
//			ma.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement a = driver.findElement(By.xpath("(//label[text()='Active'])[3]"));
			a.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement v = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
			v.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	@And("upload the Aadhar PAN files")
	public void upload_the_Aadhar_PAN_files() throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
		}
		// Aadhar
		driver.findElement(By.cssSelector("a#uploadAadhar")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='upload_documents'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Aadhaar.png");
		Thread.sleep(1000);
		WebElement slider = driver.findElement(By.xpath("(//div[@class='cr-slider-wrap'])[1]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(0, 50).release().perform(); // move down
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@class='remove'])[1]/i[1]")).click();
		// Thread.sleep(2000);
		// Aadhar
		driver.findElement(By.cssSelector("a#uploadAadhar")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='upload_documents'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Aadhaar.png");
		Thread.sleep(1000);
		WebElement slider1 = driver.findElement(By.xpath("(//div[@class='cr-slider-wrap'])[1]"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(slider1).moveByOffset(0, 50).release().perform(); // move down
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		Thread.sleep(2000);

		// PAN
		driver.findElement(By.xpath("(//p[text()='Pan Document'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='upload_documents'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Pancard.jpg");
		Thread.sleep(1000);
		WebElement slider11 = driver.findElement(By.xpath("(//div[@class='cr-slider-wrap'])[1]"));
		Actions actions11 = new Actions(driver);
		actions11.clickAndHold(slider11).moveByOffset(0, 50).release().perform(); // move down
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		Thread.sleep(2000);
		// Upload multiple files at once in one sendKeys call
		driver.findElement(By.xpath("(//input[@id='files_verify'])[1]"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Aadhaar.png\n"
						+ "C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Pancard.jpg\n"
						+ "C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Pancard.jpg");

		// removing one document
		// driver.findElement(By.xpath("(//span[@class='remove'])[5]/i[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the save button from the popup to create a new healhcoach")
	public void click_on_the_save_button_from_the_popup_to_create_a_new_healhcoach() throws Exception {
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(7000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
		}
	}

	@And("edit the age and save the user of healthcoach")
	public void edit_the_age_and_save_the_user_of_healthcoach() throws Exception {
		WebDriverWait edit = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		// age
		driver.findElement(By.cssSelector("input#age")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#age")).sendKeys("45");
		Thread.sleep(2000);
		WebDriverWait cont = new WebDriverWait(driver, Duration.ofSeconds(30));
		cont.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("click on the healthcoach role")
	public void click_on_the_healthcoach_role() throws Exception {
		driver.findElement(By.xpath("(//div[@class='user_detl_dropdown'])[1]/a[1]")).click();
		Thread.sleep(3000);
	}

	@And("download the profile and assign device and assign tablet")
	public void download_the_profile_and_assign_device_and_assign_tablet() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Profile Download'])[1]/img"))).click();
		Thread.sleep(3000);
		// assign devices
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Assign Devices'])[1]/img")))
				.click();
		Thread.sleep(3000);
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(2000);
		// device type
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Device Type'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum')])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// device automatically will be selected
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(2000);
		// remove
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-times-circle'])[2]")))
				.click();
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the healthcoach role
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='user_detl_dropdown'])[1]/a[1]")))
				.click();
		Thread.sleep(3000);
		// assign tablet
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Enable provider app access'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		// app access
		for (int i = 0; i <= 1; i++) {
			WebElement appaccess = driver.findElement(By.xpath("(//label[@for='app_access'])[1]"));
			appaccess.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// mouse hover on the i
		Actions icard = new Actions(driver);
		icard.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]"))).build().perform();
		Thread.sleep(1000);
		// device id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#imei_code")))
				.sendKeys("9cucum12hcimeicd");
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			// area-wise syncup
			WebElement syncup = driver.findElement(By.xpath("(//label[@for='area_sync'])[1]"));
			syncup.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// searching with mobile/email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_mobile_or_email_cont")))
				.sendKeys("cucumhc@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Role'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Healthcoach'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		// downloading the user details report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='file_download'])[1]"))).click();
		Thread.sleep(3000);
		driver.close();
	}

	@And("changing role from clinicmanager to ipbillingmanager to create new ipprocedure")
	public void changing_role_from_clinicmanager_to_ipbillingmanager_to_create_new_ipprocedure() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the brand logo & changing role
		// WebDriverWait logoclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		// logoclick
		// .until(ExpectedConditions.visibilityOf(driver
		// .findElement(By.xpath("(//div[@id='leftone'])[1]/following-sibling::aside[1]/div[1]/img[1]"))))
		// .click();
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='brand-logo'])/img[1]")))
				.click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]")))
				.click();
		Thread.sleep(3000);
		// selecting Role clicking on IPD Clinic_manager Role
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_IPD'])[1]"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(8000);
	}

	@Then("click on the charge masters from the dashboard to create ipprocedure")
	public void click_on_the_charge_masters_from_the_dashboard_to_create_ipprocedure() throws Exception {
		// searching ipd hospital
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(5000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_IPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_IPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the charge masters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Charge Masters'])[1]")))
				.click();
		Thread.sleep(5000);
	}

	@And("create a new ip procedure using surgery masters from the charge master")
	public void create_a_new_ip_procedure_using_surgery_masters_from_the_charge_master() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Service Name'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='IP Procedure'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#surgery_master_surgery_name")))
				.sendKeys("Cucum ip pro");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='arrow_drop_down'])[5]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Role Type'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Clinic_Manager'])[1]")))
				.click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@Then("click on add new charge master from the charge masters")
	public void click_on_add_new_charge_master_from_the_charge_masters() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New Charge Code Detail'])[2]/i[1]")))
				.click();
		Thread.sleep(3000);
	}

	@And("select the hospital service type service name code master")
	public void select_the_hospital_service_type_service_name_code_master() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Hospital'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Professional Fees'])[1]")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Service Name'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='IP Procedure'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='DUMMYPC'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("select the ipprocedure using dropdown created before using surgery master")
	public void select_the_ipprocedure_using_dropdown_created_before_using_surgery_master()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Hospital Procedure Name'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum ip pro'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("enter the base price and select the variable price")
	public void enter_the_base_price_and_select_the_variable_price() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='hospital_surgery_mapping_master_price'])[1]")))
				.sendKeys("10000");
		Thread.sleep(1000);

	}

	@Then("select the price type as self defined")
	public void select_the_price_type_as_self_defined() throws InterruptedException {
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
		WebElement selfdefined = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		selfdefined.click();
		Thread.sleep(1000);
	}

	@And("add provider and demand programs and save the ipprocedure")
	public void add_provider_and_demand_programs_and_save_the_ipprocedure() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Health System'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Provider'])[1]"))).click();
		Thread.sleep(1000);
		// entering the charge code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='charge_code_input'])[1]")))
				.sendKeys("Cucum-ip1");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@Then("select the facility and service and search for the ipprocedure")
	public void select_the_facility_and_service_and_search_for_the_ipprocedure() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Facility'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[contains(text(),'IP
		// Procedure')])[1]")).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("edit and save the ipprocedure")
	public void edit_and_save_the_ipprocedure() throws Exception {
		// edit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#hospital_surgery_mapping_master_surgery_label_name")))
				.clear();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#hospital_surgery_mapping_master_surgery_label_name")))
				.sendKeys("Cucum ip procedures");
		Thread.sleep(1000);
		// changing payment mode to self
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Payment Mode'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Self'])[1]"))).click();
		Thread.sleep(2000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Facility'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'IP Procedure')])[1]")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// download
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("navigate to the masterdata dashboard from ip procedures page")
	public void navigate_to_the_masterdata_dashboard_from_ip_procedures_page() throws Exception {
		driver.close();
	}

	@Then("click on the minor procedures from the dashboard")
	public void click_on_the_minor_procedures_from_the_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching opd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the charge masters
		driver.findElement(By.xpath("(//span[text()='Charge Masters'])[1]")).click();
		Thread.sleep(5000);
		// creating new op procedure from charge masters
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Minor Procedure'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#surgery_master_surgery_name")))
				.sendKeys("Cucum op procedure");
		Thread.sleep(1000);
		WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no.click();
		Thread.sleep(1000);
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='arrow_drop_down'])[5]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Clinic_Manager'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='All'])[1]"))).click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		// creating new dialysis from charge masters
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Dialysis'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#surgery_master_surgery_name")))
				.sendKeys("Cucum dialysis");
		Thread.sleep(1000);
		WebElement yes1 = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes1.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='arrow_drop_down'])[5]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Clinic_Manager'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='All'])[1]"))).click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		// creating new homecare procedure from charge masters
		Actions action11 = new Actions(driver);
		action11.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Home Care'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#surgery_master_surgery_name")))
				.sendKeys("Cucum Hcs");
		Thread.sleep(1000);
		WebElement no1 = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no1.click();
		Thread.sleep(1000);
		WebElement yes11 = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes11.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='arrow_drop_down'])[5]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Clinic_Manager'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='All'])[1]"))).click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		// hover the mouse on Reports
		Actions m = new Actions(driver);
		Thread.sleep(1000);
		m.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		m.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(18000);
		// searching ipd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse6.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions t = new Actions(driver);
		t.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the minor procedures
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Minor Procedure'])[1]")))
				.click();
		Thread.sleep(5000);
		Actions test = new Actions(driver);
		test.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Minor Procedures'])[1]/i[1]")))
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New Minor Procedures'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Procedure'])[2]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum op procedure'])[1]")))
				.click();
		Thread.sleep(1000);
		// entering price
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#hospital_surgery_mapping_master_price"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#hospital_surgery_mapping_master_price")))
				.sendKeys("500");
		Thread.sleep(2000);
		// variable price - yes
		WebElement Yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		Yes.click();
		Thread.sleep(1000);
		// variable price - no
		WebElement No = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		No.click();
		Thread.sleep(1000);
		// variable price - yes
		WebElement Yes1 = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		Yes1.click();
		Thread.sleep(1000);
		// clicking on the continue button
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input.btn.green.right.prcdbtn.continue_btn"))).click();
		Thread.sleep(2000);
		// clicking on the self-defined
		WebElement selfdef = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		selfdef.click();
		Thread.sleep(2000);
		// entering charge code
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Charge Code'])[1]/following-sibling::input[1]")))
				.sendKeys("Cucum-Op-01");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clear & entering the charge label name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]")))
				.sendKeys("Cucum op-self");
		Thread.sleep(1000);
		// selecting the program
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
		// selecting the payment mode
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Payment Mode'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Self'])[1]"))).click();
		Thread.sleep(1000);
		// clearing & entering the price
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[3]/following-sibling::input[1]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[3]/following-sibling::input[1]")))
				.sendKeys("1000");
		Thread.sleep(1000);
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(2000);
		// entering charge code
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Charge Code'])[2]/following-sibling::input[1]")))
				.sendKeys("Cucum-op-02");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clear & entering the charge label name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[2]/following-sibling::input[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Charge Label Name'])[2]/following-sibling::input[1]")))
				.sendKeys("Cucum op-self2");
		Thread.sleep(1000);
		// selecting the program
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='All'])[1]"))).click();
		Thread.sleep(1000);
		// selecting the payment mode
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Payment Mode'])[2]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Insurance'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//li[text()='Apollo Munich Health Insurance Company Limited'])[1]"))).click();
		Thread.sleep(1000);
		// remove
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a/i[@class='fa fa-times-circle'])[2]")))
				.click();
		Thread.sleep(1000);
		// clicking on the save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[2]"))).click();
		Thread.sleep(3000);
	}

	@And("edit the minor procedure and save it")
	public void edit_the_minor_procedure_and_save_it() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")).sendKeys("600");
		Thread.sleep(1000);
		// continue
		driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
		Thread.sleep(2000);
		//// remove
		// driver.findElement(By.xpath("(//a/i[@class='fa
		//// fa-times-circle'])[2]")).click();
		// Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		Thread.sleep(3000);
	}

	@And("searching through using service dropdown for minorprocedures1")
	public void searching_through_using_service_dropdown_for_minorprocedures1() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Procedure'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum op procedure'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the search button and reseting after for minorprocedures1")
	public void clicking_on_the_search_button_and_reseting_after_for_minorprocedures1() throws Exception {
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the minor procedure name
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/table/tbody/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='newSurgeryMaster-modal'])[1]/div/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@And("navigate to the masterdata dashboard from minor procedures page")
	public void navigate_to_the_masterdata_dashboard_from_minor_procedures_page() throws Exception {

	}

	@When("facilitydigitaltwin is opened mouse hover on hospital click on chargemasters")
	public void facilitydigitaltwin_is_opened_mouse_hover_on_hospital_click_on_chargemasters() throws Exception {
		// // searching opd hospital
		// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Nanohealth");
		// Thread.sleep(2000);
		// JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		// WebElement element =
		// driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD
		// (Hospital)'])[1]"));
		// jse5.executeScript("arguments[0].click();", element);
		// Thread.sleep(3000);
		// // mouse hovering on to the hospital
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		// Thread.sleep(3000);
		// // clicking on the charge masters
		// driver.findElement(By.xpath("(//span[text()='Charge Masters'])[1]")).click();
		// Thread.sleep(5000);
	}

	@Then("click on add button to create new dialysis")
	public void click_on_add_button_to_create_new_dialysis() throws Exception {
		// // creating new op procedure from charge masters
		// Actions action1 = new Actions(driver);
		// action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add
		// New Surgery'])[1]/i[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[@data-tooltip='Add New
		// Surgery'])[1]/i[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//li[text()='Dialysis'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).sendKeys("Cucum
		// dialysis");
		// Thread.sleep(1000);
		// WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		// yes.click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//i[text()='arrow_drop_down'])[5]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Clinic_Manager'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		// Thread.sleep(1000);
		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(3000);
	}

	@And("after creating redirect to the digitaltwin and mousehover on hospital again")
	public void after_creating_redirect_to_the_digitaltwin_and_mousehover_on_hospital_again() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		// hover the mouse on Reports
//		Actions m = new Actions(driver);
//		Thread.sleep(1000);
//		m.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
//		Thread.sleep(1000);
//		m.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
//				.perform();
//		Thread.sleep(18000);
		// [commented out above code as it is already performed in the background step]
		// searching opd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse6.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions t = new Actions(driver);
		t.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the dialysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Dialysis')])[1]")))
				.click();
		Thread.sleep(8000);
	}

	@Then("click on the dialysis and map created dialysis in the hospital")
	public void click_on_the_dialysis_and_map_created_dialysis_in_the_hospital() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Procedure'])[2]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum dialysis')])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='hospital_surgery_mapping_master_price'])[1]")))
				.sendKeys("100");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
		// search dialysis and edit the price
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Procedure'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum dialysis')])[1]")))
				.click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='hospital_surgery_mapping_master_price'])[1]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='hospital_surgery_mapping_master_price'])[1]")))
				.sendKeys("150");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(8000);
		// mapping homecareservices in the hospital
		// hover the mouse on Reports
		Actions m = new Actions(driver);
		Thread.sleep(1000);
		m.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		m.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(18000);
		// searching ipd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse6.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions t = new Actions(driver);
		t.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the home care services
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Home Care'])[1]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add New HomeCare Services'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Procedure'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum Hcs'])[1]"))).click();
		Thread.sleep(1000);
		// entering price
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")))
				.sendKeys("600");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Tax'])[1]/following-sibling::span[1]"))).click();
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		// variable price - yes
		WebElement Yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		Yes.click();
		Thread.sleep(1000);
		// variable price - no
		WebElement No = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		No.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Service Name'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum Hcs'])[1]"))).click();
		Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Active'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Yes'])[1]"))).click();
		Thread.sleep(1000);

		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the home care service name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='search-results'])[1]/table/tbody[1]/tr[1]/td[2]/a[1]"))).click();
		Thread.sleep(2000);
		// closing popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='newSurgeryMaster-modal'])[1]/div/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		// download report
		Actions rep = new Actions(driver);
		rep.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait download = new WebDriverWait(driver, Duration.ofSeconds(30));
		download.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]")))).click();
		Thread.sleep(3000);
		driver.close();
	}

	@Then("click on the room masters from the dashboard")
	public void click_on_the_room_masters_from_the_dashboard() throws Exception {
		// driver.findElement(By.xpath("(//a[text()='Patient Rooms'])[1]")).click();
		// Thread.sleep(2000);
		// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		// System.out.println(md);
	}

	@And("click on the room type details from the clinic room masters page")
	public void click_on_the_room_type_details_from_the_clinic_room_masters_page() throws Exception {
		// // clicking on the room type details
		// driver.findElement(By.xpath("//a[text()='Room Type Details']")).click();
		// Thread.sleep(1000);

	}

	@Then("deleting the room type and room details from UI")
	public void deleting_the_room_type_and_room_details_from_UI() throws Exception {
		// // clicking on the room details
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Room
		// Details'])[1]"))))
		// .click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Cucumber room
		// type'])[1]")).click();
		// Thread.sleep(1000);
		// // search
		// WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		// search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
		// .click();
		// Thread.sleep(2000);
		// // mouse hover on the delete
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Delete
		// Room Detail'])[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[@data-tooltip='Delete Room
		// Detail'])[1]")).click();
		// Thread.sleep(1000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(2000);
		//
		// // clicking on the room type details
		// driver.findElement(By.xpath("//a[text()='Room Type Details']")).click();
		// Thread.sleep(1000);
		// // SEARCH
		// driver.findElement(By.cssSelector("input#q_room_type_cont")).sendKeys("Cucumber");
		// Thread.sleep(1000);
		// WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
		// .click();
		// Thread.sleep(3000);
		// // mouse hover on the delete
		// Actions del = new Actions(driver);
		// del.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Delete
		// Room Type'])[1]"))).build().perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[@data-tooltip='Delete Room
		// Type'])[1]")).click();
		// Thread.sleep(2000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching ipd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_IPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_IPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the room masters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Room'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the room type details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Room Type Details']"))).click();
		Thread.sleep(1000);
	}

	@Then("click on the plus to add room type")
	public void click_on_the_plus_to_add_room_type() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the plus - add room type
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Room Type'])[1]/i"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Room Type'])[1]/i")))
				.click();
		Thread.sleep(1000);
	}

	@And("enter the following details")
	public void enter_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<List<String>> rm = dataTable.asLists(String.class);
		// room-type
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#clinic_room_type_master_room_type")))
				.sendKeys(rm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#clinic_room_type_master_desc")))
				.sendKeys(rm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("clicking on the dropdown charge code master")
	public void clicking_on_the_dropdown_charge_code_master() {
		// // clicking on the drop-down
		// driver.findElement(By.xpath("")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("selecting the general ward  charges")
	public void selecting_the_general_ward_charges() throws Exception {

		// driver.findElement(By.xpath("(//li[text()='101001 (General Ward
		// charges)'])[1]")).click();
		// Thread.sleep(1000);
		// is-active
		// no
		WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// yes
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
	}

	@Then("click on the save button from the room type details")
	public void click_on_the_save_button_from_the_room_type_details() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(1000);
	}

	@And("click on the edit button and update the room type name")
	public void click_on_the_edit_button_and_update_the_room_type_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(1000);
		// room-type
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#clinic_room_type_master_room_type"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input#clinic_room_type_master_room_type")))
				.sendKeys("Cucumber room type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on save button from the edit room type details page")
	public void click_on_save_button_from_the_edit_room_type_details_page() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(2000);
		// SEARCH
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_room_type_cont")))
				.sendKeys("Cucumber");
		Thread.sleep(1000);
		WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Room Type'])[1]/i")))
				.click();
		Thread.sleep(1000);
		// WebElement roomTypeInput =
		// driver.findElement(By.cssSelector("input#clinic_room_type_master_room_type"));
		// roomTypeInput.sendKeys("Cucumber room type", Keys.TAB);
		WebElement brandInput = driver.findElement(By.cssSelector("input#clinic_room_type_master_room_type"));
		String text = "Cucumber room type";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Thread.sleep(2000);
		// Store XPath in a String
		String xpath = "(//div[@class='dup_room_type_err'])[1]";
		// Find the element using the stored XPath
		WebElement validationElement = driver.findElement(By.xpath(xpath));
		// Get and print the validation text
		String validationText = validationElement.getText();
		System.out.println("Validation Message: " + validationText);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='room-type-modal'])[1]/div[1]/div[1]/span[1]/i[1]")))
				.click();
		Thread.sleep(2000);
	}

	@And("click on the Room details in the header section")
	public void click_on_the_room_details_in_the_header_section() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the room details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Room Details']"))).click();
		Thread.sleep(2000);
	}

	@Then("click on the plus button to room")
	public void click_on_the_plus_button_to_room() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// click on add room + button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
	}

	@And("selecting the room type from the dropdown")
	public void selecting_the_room_type_from_the_dropdown() throws Exception {
		// selecting the site from the dropdown
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//label[text()='Site'])[2]/following-sibling::span[1]"))))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cucumber room type']")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("entering the following details into room details")
	public void entering_the_following_details_into_room_details(io.cucumber.datatable.DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<List<String>> rm = dataTable.asLists(String.class);
		// entering the room no
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clinic_room_master_room_number")))
				.sendKeys(rm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clinic_room_master_desc")))
				.sendKeys(rm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clinic_room_master_price")))
				.sendKeys(rm.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Bed no.'])[1]/following-sibling::input[1]")))
				.sendKeys(rm.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Description'])[2]/following-sibling::input[1]")))
				.sendKeys(rm.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the plus button to add another bed in the same room")
	public void click_on_the_plus_button_to_add_another_bed_in_the_same_room(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> rm = dataTable.asLists(String.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[3]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Bed no.'])[2]/following-sibling::input[1]")))
				.sendKeys(rm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Description'])[3]/following-sibling::input[1]")))
				.sendKeys(rm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#clinic_room_master_price")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#clinic_room_master_price")))
				.sendKeys(rm.get(2).get(1));
		Thread.sleep(1000);
	}

	@And("removing the last added room")
	public void removing_the_last_added_room() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-times-circle'])[2]")))
				.click();
		Thread.sleep(1000);
	}

	@Then("click on the save button from the room details popup")
	public void click_on_the_save_button_from_the_room_details_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("click on the edit button and update the price")
	public void click_on_the_edit_button_and_update_the_price() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[2]/div[1]/div/div[2]/div/div[3]/div/input")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[2]/div[1]/div/div[2]/div/div[3]/div/input")))
				.sendKeys("1000");
		Thread.sleep(1000);
	}

	@Then("click on the save button from the edit room details popup")
	public void click_on_the_save_button_from_the_edit_room_details_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[4]/input[1]")))
				.click();
		Thread.sleep(5000);
		// search with filters-site
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")))
				.click();
		Thread.sleep(1000);
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		// search with filters-room type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[2]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucumber room type'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		// search with filters-room type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucumber room type'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_room_number_cont")))
				.sendKeys("101");
		Thread.sleep(1000);
		WebDriverWait search2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		// click on add room + button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
		WebElement brandInput = driver.findElement(By.cssSelector("input#clinic_room_master_room_number"));
		String text = "101";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(500); // small pause between keystrokes
		}
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='room-modal'])[1]/div[1]/div[1]/span[1]/i[1]")))
				.click();
		Thread.sleep(5000);
		// hover the mouse on Reports
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(10000);
		// creating brandmaster in op hospital
		// searching ipd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx"))).sendKeys("Cucum");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Pharmacy'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the charge masters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Brand Masters'])[1]")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Category'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Vaccine']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//li[text()='Alcon Laboratories (India) Private Limited'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Tablet']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='brand_master_brand_name'])[1]")))
				.sendKeys("Cucumber brandmaster");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#brand_master_brand_desc")))
				.sendKeys("NA");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Route'])[1]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Oral'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']")))
				.sendKeys("8790" + Keys.TAB);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'6')])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input#brand_master_tax_service_mapping_master_attributes_hsncode"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='CGST'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'2.5')])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']")))
				.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='COVID-19'][1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='brand_master_mrp']")))
				.sendKeys("200");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='brand_master_mrp']")))
				.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkbox1 = driver.findElement(By.xpath("//label[text()='Active']"));
			checkbox1.click();
		}
//		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkbox2 = driver.findElement(By.xpath("//label[text()='Verified']"));
			checkbox2.click();
		}
//		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			WebElement checkbox3 = driver.findElement(By.xpath("//label[text()='Serial Number Required?']"));
			checkbox3.click();
		}
//		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save']"))).click();
		Thread.sleep(5000);
		// clicking on the edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#brand_master_brand_name")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement brandname = driver.findElement(By.cssSelector("input#brand_master_brand_name"));
		brandname.sendKeys("Cucum brand", Keys.chord(Keys.SHIFT, "8"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#brand_master_brand_name")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#brand_master_brand_name")))
				.sendKeys("Cucumber brandmaster' 1.5GM/8");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#brand_master_brand_desc")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#brand_master_brand_desc")))
				.sendKeys("ABC12345");
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save']"))).click();
		Thread.sleep(3000);
		// searching with the brand name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#q_brand_name_start")))
				.sendKeys("Cucumber brandmaster");
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the brand name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'CUCUMBER')])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='newBrand-modal'])[1]/div[1]/div[1]/span[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(2000);
	}

	@And("navigate to the masterdata dashboard from room masters page")
	public void navigate_to_the_masterdata_dashboard_from_room_masters_page() throws Exception {
		driver.close();
	}

	// @Then("click on the home care services from the masterdata dashboard")
	// public void click_on_the_home_care_services_from_the_masterdata_dashboard()
	// throws InterruptedException, Exception {
	// // searching opd hospital
	// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Nanohealth");
	// Thread.sleep(2000);
	//
	// JavascriptExecutor jse5 = (JavascriptExecutor) driver;
	// WebElement element =
	// driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD
	// (Hospital)'])[1]"));
	// jse5.executeScript("arguments[0].click();", element);
	// Thread.sleep(3000);
	// // mouse hovering on to the hospital
	// Actions action = new Actions(driver);
	// action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
	// Thread.sleep(3000);
	// // clicking on the charge masters
	// driver.findElement(By.xpath("(//span[text()='Charge Masters'])[1]")).click();
	// Thread.sleep(5000);
	// // creating new homecare procedure from charge masters
	// Actions action1 = new Actions(driver);
	// action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add
	// New Surgery'])[1]/i[1]"))).build()
	// .perform();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//a[@data-tooltip='Add New
	// Surgery'])[1]/i[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='Home Care'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).sendKeys("Cucum
	// Hcs");
	// Thread.sleep(1000);
	// WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
	// no.click();
	// Thread.sleep(2000);
	// WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
	// yes.click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//i[text()='arrow_drop_down'])[5]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='Clinic_Manager'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
	// Thread.sleep(1000);
	// // save
	// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
	// Thread.sleep(3000);
	// // hover the mouse on Reports
	// Actions m = new Actions(driver);
	// Thread.sleep(1000);
	// m.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
	// Thread.sleep(1000);
	// m.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital
	// Twin'])[1]"))).click().build()
	// .perform();
	// Thread.sleep(18000);
	// // searching ipd hospital
	// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Nanohealth");
	// Thread.sleep(2000);
	//
	// JavascriptExecutor jse6 = (JavascriptExecutor) driver;
	// WebElement element1 =
	// driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD
	// (Hospital)'])[1]"));
	// jse6.executeScript("arguments[0].click();", element1);
	// Thread.sleep(3000);
	// // mouse hovering on to the hospital
	// Actions t = new Actions(driver);
	// t.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
	// Thread.sleep(3000);
	// // clicking on the home care services
	// driver.findElement(By.xpath("(//span[text()='Home Care'])[1]")).click();
	// Thread.sleep(5000);
	// driver.findElement(By.xpath("(//a[@data-tooltip='Add New HomeCare
	// Services'])[1]/i[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//label[text()='Procedure'])[1]/following-sibling::span[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='Cucum Hcs'])[1]")).click();
	// Thread.sleep(2000);
	// // entering price
	// driver.findElement(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")).sendKeys("600");
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//label[text()='Tax'])[1]/following-sibling::span[1]")).click();
	// Robot robot1 = new Robot();
	// robot1.keyPress(KeyEvent.VK_DOWN);
	// Thread.sleep(1000);
	// robot1.keyPress(KeyEvent.VK_ENTER);
	// Thread.sleep(1000);
	// Robot robot = new Robot();
	// for (int i = 0; i <= 1; i++) {
	// WebElement active =
	// driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
	// active.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	// // variable price - yes
	// WebElement Yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
	// Yes.click();
	// Thread.sleep(2000);
	// // variable price - no
	// WebElement No = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
	// No.click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
	// Thread.sleep(3000);
	// driver.navigate().refresh();
	// Thread.sleep(2000);
	// }
	//
	// @And("edit and save the homecareservices")
	// public void edit_and_save_the_homecareservices() throws Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
	// Thread.sleep(3000);
	// driver.findElement(By.xpath("(//label[text()='Service
	// Name'])[1]/following-sibling::span[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='Cucum Hcs'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//label[text()='Active'])[1]/following-sibling::span[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='Yes'])[1]")).click();
	// Thread.sleep(2000);
	//
	// // search
	// WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
	// search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
	// .click();
	// Thread.sleep(2000);
	// // clicking on the home care service name
	// driver.findElement(By.xpath("(//div[@id='search-results'])[1]/table/tbody[1]/tr[1]/td[2]/a[1]")).click();
	// Thread.sleep(3000);
	// // closing popup
	// driver.findElement(By.xpath("(//div[@id='newSurgeryMaster-modal'])[1]/div/div[1]/span[1]/i[1]")).click();
	// Thread.sleep(3000);
	// // reset
	// driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
	// Thread.sleep(2000);
	// // download report
	// Actions rep = new Actions(driver);
	// rep.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download
	// Reports'])[1]/i[1]"))).build()
	// .perform();
	// Thread.sleep(1000);
	// WebDriverWait download = new WebDriverWait(driver, Duration.ofSeconds(30));
	// download.until(ExpectedConditions
	// .visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Download
	// Reports'])[1]/i[1]")))).click();
	// Thread.sleep(3000);
	// driver.close();
	// }
	//
	// @And("searching through the service name for hcs")
	// public void searching_through_the_service_name_for_hcs() {
	// // clicking on the service name
	// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Home service1']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("click on the search and reset buttons after getting the results1")
	// public void
	// click_on_the_search_and_reset_buttons_after_getting_the_results1() throws
	// Exception {
	// // search
	// driver.findElement(By.xpath("//input[@name='commit']")).click();
	// Thread.sleep(1000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("searching through the active for hcs")
	// public void searching_through_the_active_for_hcs() {
	// // searching through the active
	// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Yes']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("clicking on the search and reset buttons after getting the results2")
	// public void
	// clicking_on_the_search_and_reset_buttons_after_getting_the_results2() throws
	// Exception {
	// // search
	// driver.findElement(By.xpath("//input[@name='commit']")).click();
	// Thread.sleep(1000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("navigate to the masterdata dashboard from home care services page")
	// public void
	// navigate_to_the_masterdata_dashboard_from_home_care_services_page() throws
	// Exception {
	// //
	// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// driver.close();
	// }

	// @Then("click on the brandmaster from the masterdata dashboard")
	// public void click_on_the_brandmaster_from_the_masterdata_dashboard() throws
	// Exception {
	// // searching ipd hospital
	// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum");
	// Thread.sleep(2000);
	//
	// JavascriptExecutor jse5 = (JavascriptExecutor) driver;
	// WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum
	// Hospital (Hospital)'])[1]"));
	// jse5.executeScript("arguments[0].click();", element);
	// Thread.sleep(3000);
	// // mouse hovering on to the hospital
	// Actions action = new Actions(driver);
	// action.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum
	// Pharmacy'])[1]"))).build().perform();
	// Thread.sleep(3000);
	// // clicking on the charge masters
	// driver.findElement(By.xpath("(//div[text()='Brand Masters'])[1]")).click();
	// Thread.sleep(5000);
	//
	// }
	//
	// @And("click on plus button to add new brand")
	// public void click_on_plus_button_to_add_new_brand() throws Exception {
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("select the category of the brand using dropdown")
	// public void select_the_category_of_the_brand_using_dropdown() throws
	// Exception {
	// driver.findElement(By.xpath("(//label[text()='Category'])[2]/following-sibling::span[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='Vaccine']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @And("select the manufacturer of the brand using dropdown")
	// public void select_the_manufacturer_of_the_brand_using_dropdown() throws
	// Exception {
	// driver.findElement(By.xpath("(//li[text()='Alcon Laboratories (India) Private
	// Limited'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//
	// }
	//
	// @Then("select the form of the brand using dropdown")
	// public void select_the_form_of_the_brand_using_dropdown() throws Exception {
	// driver.findElement(By.xpath("//li[text()='Tablet']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @And("enter the brand and salt names")
	// public void enter_the_brand_and_salt_names() throws Exception {
	// driver.findElement(By.xpath("(//input[@id='brand_master_brand_name'])[1]")).sendKeys("Cucumber
	// brandmaster");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.cssSelector("input#brand_master_brand_desc")).sendKeys("NA");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//
	// }
	//
	// @Then("select the route of the brand using dropdown")
	// public void select_the_route_of_the_brand_using_dropdown() {
	// driver.findElement(By.xpath("(//label[text()='Route'])[1]/following-sibling::span[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("(//li[text()='Oral'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @When("entering the HSN code for add new brand")
	// public void entering_the_hsn_code_for_add_new_brand() throws Exception {
	// driver.findElement(By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']"))
	// .sendKeys("8790" + Keys.TAB);
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//li[contains(text(),'6')])[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.cssSelector("input#brand_master_tax_service_mapping_master_attributes_hsncode")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//label[text()='CGST'])[1]/following-sibling::span[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[contains(text(),'2.5')])[1]")).click();
	// Thread.sleep(1000);
	//// Robot robot = new Robot();
	//// robot.keyPress(KeyEvent.VK_TAB);
	//// Thread.sleep(2000);
	//// Robot robot1 = new Robot();
	//// robot1.keyPress(KeyEvent.VK_TAB);
	//// Thread.sleep(1000);
	//// robot1.keyPress(KeyEvent.VK_TAB);
	//// Thread.sleep(1000);
	//// robot1.keyPress(KeyEvent.VK_TAB);
	//// Thread.sleep(1000);
	//// driver.findElement(By.xpath("(//label[text()='IGST'])[1]/following-sibling::span[1]")).click();
	//// Thread.sleep(1000);
	//// driver.findElement(By.xpath("(//li[text()='12.0'])[1]")).click();
	//// Thread.sleep(1000);
	// }
	//
	// @Then("selecting the GST rate from the dropdown")
	// public void selecting_the_GST_rate_from_the_dropdown() throws Exception {
	// // driver.findElement(
	// //
	// By.cssSelector("span#select2-brand_master_tax_service_mapping_master_attributes_igst-container"))
	// // .click();
	// // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//// driver.findElement(By.xpath("(//li[text()='12.0'])[1]")).click();
	//// Thread.sleep(2000);
	// driver.findElement(By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']"))
	// .sendKeys(Keys.PAGE_DOWN);
	// }
	//
	// @And("select the vaccine for from dropdown")
	// public void select_the_vaccine_for_from_dropdown() throws Exception {
	// // driver.findElement(By.xpath("(//span[@class='selection'])[10]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='COVID-19'][1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the price for the vaccine brand")
	// public void enter_the_price_for_the_vaccine_brand() throws Exception {
	// driver.findElement(By.xpath("//input[@id='brand_master_mrp']")).sendKeys("200");
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//input[@id='brand_master_mrp']")).sendKeys(Keys.PAGE_DOWN);
	// Thread.sleep(1000);
	// }
	//
	// @And("select the checkboxes active and verified")
	// public void select_the_checkboxes_active_and_verified() throws Exception {
	// for (int i = 0; i <= 2; i++) {
	// WebElement checkbox1 =
	// driver.findElement(By.xpath("//label[text()='Active']"));
	// checkbox1.click();
	// }
	// Thread.sleep(1000);
	// for (int i = 0; i <= 2; i++) {
	// WebElement checkbox2 =
	// driver.findElement(By.xpath("//label[text()='Verified']"));
	// checkbox2.click();
	// }
	// Thread.sleep(1000);
	// for (int i = 0; i <= 3; i++) {
	// WebElement checkbox3 = driver.findElement(By.xpath("//label[text()='Serial
	// Number Required?']"));
	// checkbox3.click();
	// }
	// Thread.sleep(1000);
	// }
	//
	// @Then("click on the save button from new brand popup")
	// public void click_on_the_save_button_from_new_brand_popup() throws Exception
	// {
	// // save
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(5000);
	// }
	//
	// @And("click on the edit button update the salt name")
	// public void click_on_the_edit_button_update_the_salt_name() throws Exception
	// {
	// // clicking on the edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.cssSelector("input#brand_master_brand_name")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// WebElement brandname =
	// driver.findElement(By.cssSelector("input#brand_master_brand_name"));
	// brandname.sendKeys("Cucum brand", Keys.chord(Keys.SHIFT, "8"));
	// Thread.sleep(2000);
	//
	// driver.findElement(By.cssSelector("input#brand_master_brand_name")).clear();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#brand_master_brand_name")).sendKeys("Cucumber
	// brandmaster' 1.5GM/8");
	// Thread.sleep(2000);
	// driver.findElement(By.cssSelector("input#brand_master_brand_desc")).clear();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#brand_master_brand_desc")).sendKeys("ABC12345");
	// Thread.sleep(1000);
	// }
	//
	// @Then("click on the save button from the edit new brand popup")
	// public void click_on_the_save_button_from_the_edit_new_brand_popup() throws
	// Exception {
	// // save
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @And("search the added brand by using brand name field")
	// public void search_the_added_brand_by_using_brand_name_field() throws
	// Exception {
	// // searching with the brand name
	// driver.findElement(By.cssSelector("input#q_brand_name_start")).sendKeys("Cucumber
	// brandmaster");
	// Thread.sleep(1000);
	// // search
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(2000);
	// // clicking on the brand name
	// driver.findElement(By.xpath("(//a[contains(text(),
	// 'CUCUMBER')])[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//div[@id='newBrand-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
	// Thread.sleep(2000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
	// Thread.sleep(2000);
	// }
	//
	// @Then("navigate to the masterdata dashboard from brandmasters page")
	// public void navigate_to_the_masterdata_dashboard_from_brandmasters_page()
	// throws Exception {
	//// driver.close();
	// Actions action = new Actions(driver);
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility
	// Digital Twin'])[1]"))).click().build()
	// .perform();
	// Thread.sleep(15000);
	// }

	@Then("click on the diease program from the masterdata dashboard")
	public void click_on_the_diease_program_from_the_masterdata_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching opd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the charge masters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Package'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("click on the plus button to add new program")
	public void click_on_the_plus_button_to_add_new_program() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add'][1]"))).click();
		Thread.sleep(1000);
	}

	@Then("enter the program name from add new program popup")
	public void enter_the_program_name_from_add_new_program_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// entering the program name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#package_master_pckg_nm")))
				.sendKeys("Cucumberdiseaseprogram");
//		Thread.sleep(1000);
		// entering the program group name
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='package_master_package_group_name'])[1]")))
				.sendKeys("Cucum groupname");
		Thread.sleep(1000);
	}

	@And("select the effective start date")
	public void select_the_effective_start_date() throws Exception {
		// selecting the effective date
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.pick-date.stdt "))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='is-today'])[1]/button[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*
		 * // selecting the end date
		 * driver.findElement(By.cssSelector("input.pick-date.endt ")).click();
		 * Thread.sleep(1000);
		 */
	}

	@Then("enter the package duration and select the days from dropdown")
	public void enter_the_package_duration_and_select_the_days_from_dropdown() throws Exception {
		// entering the duration
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#duration"))).sendKeys("365");
//		Thread.sleep(1000);
	}

	@And("enter the description from add new program popup")
	public void enter_the_description_from_add_new_program_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#package_master_pckg_desc")))
				.sendKeys("Cucumberdiseaseprogram descriptionn");
//		Thread.sleep(1000);
	}

	@Then("uploading the image of the program")
	public void uploading_the_image_of_the_program() throws Exception {
		// sending the demo pro.image
		driver.findElement(By.cssSelector("input#package_image_url"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\Dieaseprogram.jpg");
		Thread.sleep(1000);
	}

	@And("enabling the checkboxes for the new program")
	public void enabling_the_checkboxes_for_the_new_program() {
		for (int i = 0; i <= 2; i++) {
			WebElement print = driver.findElement(By.xpath("//label[text()='Print description']"));
			print.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement radio = driver.findElement(By.xpath("//label[text()='Is Visible Web']"));
			radio.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	@Then("selecting the charge code and for ip from dropdown")
	public void selecting_the_charge_code_and_for_ip_from_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(1000);
		// selecting the charge code from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CardiologyPackage s']")))
				.click();
		Thread.sleep(1000);
		// selecting the ip+op from dropdown
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='OP Only'])[1]"))).click();
		Thread.sleep(1000);
		// selecting the what from dropdown
		// driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Doctor Consultation'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("selecting services from add new program popup")
	public void selecting_services_from_add_new_program_popup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Internal Medicine'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Clinic']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the whose resp
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Doctor']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the cost
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("package_master_patient_package_details_attributes_0_service_cost")))
				.sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the gst
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("package_master_patient_package_details_attributes_0_gst_amt")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("package_master_patient_package_details_attributes_0_gst_amt")))
				.sendKeys("6");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// // entering the pay %
		// driver.findElement(By.id("package_master_patient_package_details_attributes_0_min_pay")).sendKeys("4");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the time cycle
		// driver.findElement(By.id("package_master_patient_package_details_attributes_0_time_cycle")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the time cycle type i.e dys,weeks,months etc.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[7]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Weeks']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("package_master_patient_package_details_attributes_0_service_time")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Ok'])[1]"))).click();
		Thread.sleep(1000);
		// clicking on the description
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Add Description'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='Add Description'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='line_desc'])[1]")))
				.sendKeys("test1");
		Thread.sleep(2000);
	}

	@Then("clicking on the add plus button to add new service")
	public void clicking_on_the_add_plus_button_to_add_new_service() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// clicking on the add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[1]"))).click();
		Thread.sleep(1000);
		Robot pddw = new Robot();
		pddw.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

	}

	@And("selecting services again")
	public void selecting_services_again() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the what dropdown
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='What'])[2]/following-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Dietician Consultation'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selectinging the service name
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Dietician Consultation'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the where
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Clinic'][1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the whose responsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dietitian'][1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// cost
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Cost'])[2]/following-sibling::input[1]")))
				.sendKeys("500");
		Thread.sleep(1000);
		// gst
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='GST'])[2]/following-sibling::input[1]")))
				.sendKeys("6");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// // pay
		// driver.findElement(By.xpath("/html/body/header/div[18]/div/div[2]/form/div[3]/div[2]/div/div[5]/div[2]/input"))
		// .sendKeys("1");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the time cycle type i.e dys,weeks,months etc.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[12]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Weeks'][1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// time
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@class='service_time timepicker'])[2]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Ok'])[6]"))).click();
		Thread.sleep(1000);

		// clicking on the description
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@data-tooltip='Add Description'])[2]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='line_desc'])[2]")))
				.sendKeys("test2");
		Thread.sleep(1000);
		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(2000);
	}

	@Then("remove last added services")
	public void remove_last_added_services() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-times-circle'])[2]")))
				.click();
		Thread.sleep(1000);
	}

	@And("selecting the checkbox active")
	public void selecting_the_checkbox_active() {
		for (int i = 0; i <= 1; i++) {
			WebElement active2 = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
			active2.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button from the add new program popup")
	public void click_on_the_save_button_from_the_add_new_program_popup() throws Exception {
		// clicking on the save btn
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the edit button and updating the description")
	public void click_on_the_edit_button_and_updating_the_description() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package_master_pckg_desc"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package_master_pckg_desc")))
				.sendKeys("Cucumdiseaseprogram description");
		Thread.sleep(1000);
	}

	@Then("click on the save button from the edit program")
	public void click_on_the_save_button_from_the_edit_program() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the submit btn
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(3000);

	}

	@And("selecting the program name from dropdown and searching")
	public void selecting_the_program_name_from_dropdown_and_searching() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching with the name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cucumberdiseaseprogram']")))
				.click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(1000);
		// clicking on the program name
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[text()='Cucumberdiseaseprogram'])[1]")))).click();
		Thread.sleep(3000);
		// edit
		WebDriverWait edit = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@class='btn green right btn-loader'])[1]")))).click();
		Thread.sleep(3000);
		WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
		active.click();
		Thread.sleep(2000);
		// save
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(3000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		WebElement active1 = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
		active1.click();
		Thread.sleep(2000);
		// save
		WebDriverWait save1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		save1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(1000);
	}

	@Then("navigae to the masterdata dashboard from diease program page")
	public void navigae_to_the_masterdata_dashboard_from_diease_program_page() throws Exception {
//		Actions action = new Actions(driver);
//		Thread.sleep(1000);
//		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
//		Thread.sleep(1000);
//		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
//				.perform();
//		Thread.sleep(10000);
		// creating new promocode
		// hover the mouse on Reports
		Actions action1 = new Actions(driver);
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(10000);
		// [commented above code because it was already executed in the previous step
		// and it is navigating to the masterdata dashboard]
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Promo Code'])[1]"))).click();
		Thread.sleep(5000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
		// clicking on the add new icon +
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
		// entering the promo code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#promo_code_master_promo_code")))
				.sendKeys("Cucumber codee");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the start date -
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#promo_code_master_start_date")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='1'][1]"))).click();
		Thread.sleep(1000);
		// selecting the end date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#promo_code_master_end_date")))
				.click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//button[text()='28'])[2]")).click();
		// Thread.sleep(1000);
		List<WebElement> date = driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
		WebElement lastdate = date.get(date.size() - 1);
		lastdate.click();
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the program
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the status master
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Status Master'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Registered Users']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the service master
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Service Master'])[1]/following-sibling::span[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Doctor Consultation']")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Service Master'])[1]/following-sibling::span[1]"))).click();
		driver.findElement(By.xpath("//li[text()='Dietician Consultation']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the discount
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("promo_code_master_promo_code_service_details_attributes_0_discount"))).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("discount"))).sendKeys("5");
		Thread.sleep(1000);

		for (int i = 0; i <= 2; i++) {
			// clicking on the checkbox-family
			WebElement fam = driver.findElement(By.xpath("//label[text()='Family?']"));
			fam.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save']"))).click();
		Thread.sleep(3000);
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(1000);
		// entering the promo code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#promo_code_master_promo_code")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#promo_code_master_promo_code")))
				.sendKeys("Cucumber code");
		// clicking on the save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save']"))).click();
		Thread.sleep(3000);
		// searching with the promo code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='selection']"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cucumber code']"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the promo code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Cucumber code'])[1]"))).click();
		Thread.sleep(2000);
		// closing popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='promoCodeMaster-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(1000);
		driver.close();
	}

	// @Then("click on the promocode from the masterdata")
	// public void click_on_the_promocode_from_the_masterdata() throws Exception {
	// driver.findElement(By.xpath("(//div[text()='Promo Code'])[1]")).click();
	// Thread.sleep(5000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @And("click on the plus button to add new promo code")
	// public void click_on_the_plus_button_to_add_new_promo_code() throws Exception
	// {
	// // clicking on the add new icon +
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter promo code in the new promo code popup")
	// public void enter_promo_code_in_the_new_promo_code_popup() {
	// // entering the promo code
	// driver.findElement(By.cssSelector("input#promo_code_master_promo_code")).sendKeys("Cucumber
	// codee");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("select the start date from the calendar for new promo code")
	// public void select_the_start_date_from_the_calendar_for_new_promo_code()
	// throws Exception {
	// // selecting the start date -
	// driver.findElement(By.cssSelector("input#promo_code_master_start_date")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//button[text()='1'][1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("select the end date from the calendar for new promo code")
	// public void select_the_end_date_from_the_calendar_for_new_promo_code() throws
	// Exception {
	// // selecting the end date
	// driver.findElement(By.cssSelector("input#promo_code_master_end_date")).click();
	// Thread.sleep(1000);
	//// driver.findElement(By.xpath("(//button[text()='28'])[2]")).click();
	//// Thread.sleep(1000);
	//
	// List<WebElement> date =
	// driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
	// WebElement lastdate = date.get(date.size() - 1);
	// lastdate.click();
	//
	// }
	//
	// @And("selecting the active checkbox for new promo code")
	// public void selecting_the_active_checkbox_for_new_promo_code() {
	// for (int i = 0; i <= 1; i++) {
	// WebElement active =
	// driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
	// active.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("select the program status_master service_master from the dropdown for
	// new promo code")
	// public void
	// select_the_program_status_master_service_master_from_the_dropdown_for_new_promo_code()
	// throws Exception {
	// // selecting the program
	// driver.findElement(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // selecting the status master
	// driver.findElement(By.xpath("(//label[text()='Status
	// Master'])[1]/following-sibling::span[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Registered Users']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // selecting the service master
	// driver.findElement(By.xpath("(//label[text()='Service
	// Master'])[1]/following-sibling::span[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Doctor Consultation']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("(//label[text()='Service
	// Master'])[1]/following-sibling::span[1]")).click();
	// driver.findElement(By.xpath("//li[text()='Dietician
	// Consultation']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("entering the discount and enabling the checkbox for new promo code")
	// public void
	// entering_the_discount_and_enabling_the_checkbox_for_new_promo_code() throws
	// Exception {
	// // entering the discount
	// driver.findElement(By.id("promo_code_master_promo_code_service_details_attributes_0_discount")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.className("discount")).sendKeys("5");
	// Thread.sleep(1000);
	//
	// for (int i = 0; i <= 2; i++) {
	// // clicking on the checkbox-family
	// WebElement fam = driver.findElement(By.xpath("//label[text()='Family?']"));
	// fam.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("click on the save button for new promo code")
	// public void click_on_the_save_button_for_new_promo_code() throws Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("click on edit and update the promo code")
	// public void click_on_edit_and_update_the_promo_code() throws Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// // entering the promo code
	// driver.findElement(By.cssSelector("input#promo_code_master_promo_code")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.cssSelector("input#promo_code_master_promo_code")).sendKeys("Cucumber
	// code");
	// }
	//
	// @And("click on the save button from the edit promo code page")
	// public void click_on_the_save_button_from_the_edit_promo_code_page() throws
	// Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("selecting the promo code from the dropdown and searching")
	// public void selecting_the_promo_code_from_the_dropdown_and_searching() throws
	// Exception {
	// // searching with the promo code
	// driver.findElement(By.xpath("//span[@class='selection']")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//li[text()='Cucumber code']")).click();
	// Thread.sleep(1000);
	// // search
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(2000);
	// // clicking on the promo code
	// driver.findElement(By.xpath("(//a[text()='Cucumber code'])[1]")).click();
	// Thread.sleep(2000);
	// // closing popup
	// driver.findElement(By.xpath("(//div[@id='promoCodeMaster-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
	// Thread.sleep(2000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("navigate to the masterdata dashboard from the promocode page")
	// public void navigate_to_the_masterdata_dashboard_from_the_promocode_page()
	// throws Exception {
	// Thread.sleep(1000);
	// driver.close();
	// }

	@Then("click on the screening camps from the masterdata dashboard")
	public void click_on_the_screening_camps_from_the_masterdata_dashboard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching opd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the screening camp
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Screening Camps'])[1]")))
				.click();
		Thread.sleep(5000);
	}

	@Then("click on the add new camp from the screening camps")
	public void click_on_the_add_new_camp_from_the_screening_camps() throws Exception {
		// clicking on the add
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
	}

	@Then("entering the camp name to create new camp")
	public void entering_the_camp_name_to_create_new_camp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Camp Type'])[1]/preceding-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Camp')])[1]")))
				.click();
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// entering the camp name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#camp_name")))
				.sendKeys("Cucumber testcamp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the location from the dropdown")
	public void select_the_location_from_the_dropdown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the drop-down for selecting location
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Location '])[1]/preceding-sibling::span[1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Shivapuri Colony'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@Then("select the program from the dropdown")
	public void select_the_program_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// // clicking on the drop-down for selecting program
		// driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")))
				.click();
		Thread.sleep(1000);
		// for (int i = 0; i <= 1; i++) {
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_TAB);
		// Thread.sleep(1000);
		// }
	}

	@Then("select the service from the dropdown")
	public void select_the_service_from_the_dropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Service'])[1]/preceding-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Diagnostic Lab'])[1]")))
				.click();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
		}
	}

	@Then("entering the capacity for new camp")
	public void entering_the_capacity_for_new_camp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// entering the capacity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#capacity"))).sendKeys("300");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the start date and time for new camp")
	public void select_the_start_date_and_time_for_new_camp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#starting-date"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click on Year dropdown
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='select-wrapper select-year'])[1]/input[1]")))
				.click();
		Thread.sleep(1000);
		LocalDate today = LocalDate.now();
		String currentYear = String.valueOf(today.getYear());
		Thread.sleep(1000);
		// Select current year dynamically
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/span[text()='" + currentYear + "']")))
				.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='select-wrapper select-month'])[1]/input[1]")))
				.click();
		Thread.sleep(1000);
		LocalDate today1 = LocalDate.now();
		String currentMonth = today1.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		Thread.sleep(1000);
		// Select current month dynamically
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/span[text()='" + currentMonth + "']")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='is-today'])[1]/button[1]")))
				.click();
		// driver.findElement(By.xpath("//button[text()='21']")).click();
		Thread.sleep(3000);

		// // present date
		// driver.findElement(By.xpath("//td[@class='is-today']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the camp start time
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#screening_camp_master_start_time")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// 8
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='timepicker-canvas'])[1]//following-sibling::div[1]/div[8]"))).click();
		Thread.sleep(1000);
		// clicking on the am
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]"))).click();
		Thread.sleep(1000);
		// 00 minutes
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='timepicker-dial timepicker-minutes']/div[1]")))
				.click();
		Thread.sleep(1000);
		// clicking on the ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]"))).click();
		Thread.sleep(1000);
	}

	@Then("select the end date and time for new camp")
	public void select_the_end_date_and_time_for_new_camp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the end date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#end-date"))).click();
		Thread.sleep(1000);
		// end date
		// driver.findElement(By.xpath("(//button[text()='28'])[2]")).click();
		// Thread.sleep(1000);
		List<WebElement> date = driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
		WebElement lastdate = date.get(date.size() - 1);
		lastdate.click();
		Thread.sleep(2000);
		// clicking on the end time
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#screening_camp_master_end_time")))
				.click();
		Thread.sleep(1000);
		// 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='timepicker-canvas'])[2]//following-sibling::div[1]/div[6]"))).click();
		Thread.sleep(1000);
		// pm
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]"))).click();
		Thread.sleep(1000);
		// 30 minutes
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[7]")))
				.click();
		Thread.sleep(1000);
		// clicking on the ok
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]"))).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
		}
		Thread.sleep(1000);
	}

	@Then("entering the age from and to for new camp")
	public void entering_the_age_from_and_to_for_new_camp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// entering the age from
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age_lwr_lmt"))).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age to
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age_upr_lmt"))).sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enabling the checkbox for ispublic")
	public void enabling_the_checkbox_for_ispublic() {
		// selecting the check box
		for (int i = 0; i <= 2; i++) {
			WebElement ispub = driver.findElement(By.xpath("//label[text()='Is Public']"));
			ispub.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for new camp")
	public void click_on_the_save_button_for_new_camp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clicking on the submit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#submit"))).click();
		Thread.sleep(3000);
	}

	@When("save button is clicked it will open popup for add address for the created camp")
	public void save_button_is_clicked_it_will_open_popup_for_add_address_for_the_created_camp() throws Exception {
	}

	@Then("enter the address details and save")
	public void enter_the_address_details_and_save() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='address_detail_address_line1'])[1]")))
				.sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='address_detail_address_line2'])[1]")))
				.sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address_detail_landmark'])[1]")))
				.sendKeys("landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='City'])[1]/preceding-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Hyderabad'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='dist_nm'])[1]")))
				.sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address_detail_pin_code'])[1]")))
				.sendKeys("090909");
		Thread.sleep(1000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@When("save button is clicked then address will be added for that camp")
	public void save_button_is_clicked_then_address_will_be_added_for_that_camp() throws Exception {

	}

	@Then("adding slots for the screeningcamp")
	public void adding_slots_for_the_screeningcamp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// add slots
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Add Slots'])[1]/i")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#slot_duration"))).sendKeys("30");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#slot_capacity"))).sendKeys("10");
		Thread.sleep(1000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#submit")))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	// @And("adding address for the screeningcamp")
	// public void adding_address_for_the_screeningcamp() throws Exception {
	// // add address
	// driver.findElement(By.xpath("(//a[@data-tooltip='Add
	// Address'])[1]/i")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//input[@id='address_detail_address_line1'])[1]")).sendKeys("test");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//input[@id='address_detail_address_line2'])[1]")).sendKeys("test");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//input[@id='address_detail_landmark'])[1]")).sendKeys("landmark");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//*[@id=\"new_address_detail\"]/div[2]/div[1]/div/input")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li/span[text()='Hyderabad'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//input[@id='dist_nm'])[1]")).sendKeys("test");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//input[@id='address_detail_pin_code'])[1]")).sendKeys("090909");
	// Thread.sleep(1000);
	// WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
	// save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
	// .click();
	// Thread.sleep(3000);
	// }

	@Then("adding recommendations for the screeningcamp")
	public void adding_recommendations_for_the_screeningcamp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// recommendations
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Recommendations'])[1]/i")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[4]"))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Doctor
		// Consultation'])[1]")).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Diagnostic Lab'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='HbA1c'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[2]"))).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		// Thread.sleep(3000);
		// add
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Add'])[1]")))).click();
		// driver.findElement(By.xpath("(//input[@value='Add'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("clicking on the camp name")
	public void clicking_on_the_camp_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Cucumber')])[1]")))
				.click();
		Thread.sleep(1000);

	}

	@And("clicking on the filter icon")
	public void clicking_on_the_filter_icon() throws Exception {
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.cssSelector("span#filter_ico")).click();
		}
		Thread.sleep(1000);
	}

	@Then("searching the patient name using filters")
	public void searching_the_patient_name_using_filters() throws Exception {

	}

	@And("clicking on the reset button in the camp page")
	public void clicking_on_the_reset_button_in_the_camp_page() {
	}

	@And("deleting already exisiting patient in the camp")
	public void deleting_already_exisiting_patient_in_the_camp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='brand-logo'])/img[1]")))
				.click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frst_nm"))).sendKeys("5656565657");
		Thread.sleep(2000);
		// clicking on the patient name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col.s7.btn-loader.opt_search")))
				.click();
		Thread.sleep(3000);
		// clicking on the view profile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View Profile'])[1]"))).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i")).click();
			Thread.sleep(2000);
		} else {
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a/i")).click();
			Thread.sleep(2000);
		}
		// deleteing
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")))
				.click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='brand-logo'])/img[1]")))
				.click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]"))).click();
		Thread.sleep(3000);
		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Cucumber testcamp'])[1]")))
				.click();
		Thread.sleep(1000);

	}

	@Then("click on the plus button to assign patients")
	public void click_on_the_plus_button_to_assign_patients() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// assign patients-
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Assign Patients'])[1]/i")))
				.click();
		Thread.sleep(3000);
		// clicking on the registered user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Registered User'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='register_patient_data'])[1]")))
				.sendKeys("7781110013");
		Thread.sleep(2000);
		// clicking search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[2]"))).click();
		Thread.sleep(2000);
		// clicking on the submit to add existing patient to the camp
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(3000);
		// qr code download
		/*
		 * driver.findElement(By.xpath("(//a[@data-tooltip='Demo Mrfam'])[1]/img[1]")).
		 * click(); Thread.sleep(3000);
		 */
		// Searching & clicking on the patient name from eligible status to check
		// recommendations are added or not
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
				.sendKeys("Demo");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Demo Mrfam'])[1]"))).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);

		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}
		String recommendations1 = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println("Eligible patient recommendation is added & it is in pending status:" + recommendations1);
		Thread.sleep(2000);

		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Cucumber')])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
				.sendKeys("mrfam");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the eligible button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Eligible')])[1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the verify button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Verify'])[1]"))).click();
		Thread.sleep(2000);
		// verifying
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Yes'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the verified status
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn-loader verify_btn'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Demo Mrfam'])[1]"))).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}
		// clicking on the appointments to check wheither recomm. are added or not
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")))
				.click();
		Thread.sleep(3000);

		String appointment = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println(
				"Appointment is created for patient recommendation & it is in confirmed status:" + appointment);
		Thread.sleep(2000);
		// clicking on the apt id
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")))
				.click();
		Thread.sleep(3000);

		String Appointmentdetails = driver.findElement(By.xpath("(//div[@class='blue_patch'])[2]")).getText();
		System.err.println("Appointment details:" + Appointmentdetails);
		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span/i[1]")))
				.click();
		Thread.sleep(3000);
		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Cucumber')])[1]")))
				.click();
		Thread.sleep(2000);
		// assign patients-
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Assign Patients'])[1]/i")))
				.click();
		Thread.sleep(3000);
	}

	@And("add patient in that new camp")
	public void add_patient_in_that_new_camp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// first name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#first_name"))).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// last name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lst_name")))
				.sendKeys("scamppat");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age"))).sendKeys("40");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// phone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr"))).sendKeys("5656565657");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email:nth-of-type(1)")))
				.sendKeys("scamppat@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#nmbr"))).click();
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Submit'])[2]"))).click();
		Thread.sleep(7000);

		// searching with mobile nmbr
		try {
			driver.findElement(By.cssSelector("input#q_nmbr_cont")).sendKeys("5656565657");
			Thread.sleep(3000);
			WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
			search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
					.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// clicking on the verified status
		// driver.findElement(By.xpath("(//a[@class='btn-loader
		// verify_btn'])[1]")).click();
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Cucum scamppat'])[1]")))
				.click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}

		String recommendations1 = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println("Eligible patient recommendation is added & it is in pending status:" + recommendations1);
		Thread.sleep(2000);

		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Cucumber testcamp'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")))
				.sendKeys("mrfam");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the eligible button
		driver.findElement(By.xpath("(//a[contains(text(), 'Eligible')])[1]")).click();
		Thread.sleep(3000);
		// clicking on the verify button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Verify'])[1]"))).click();
		Thread.sleep(2000);
		// verifying
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Yes'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the verified status
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn-loader verify_btn'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Cucum scamppat'])[1]")))
				.click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(2000);
			}
		}
		// clicking on the appointments to check wheither recomm. are added or not
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")))
				.click();
		Thread.sleep(3000);

		String appointment = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println(
				"Appointment is created for patient recommendation & it is in confirmed status:" + appointment);
		Thread.sleep(2000);
		// clicking on the apt id
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")))
				.click();
		Thread.sleep(3000);

		String Appointmentdetails = driver.findElement(By.xpath("(//div[@class='blue_patch'])[2]")).getText();
		System.err.println("Appointment details:" + Appointmentdetails);
		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span/i[1]")))
				.click();
		Thread.sleep(3000);
		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Cucumber testcamp'])[1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the verify button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Verified')])[1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the compledted button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Complete'])[1]"))).click();
		Thread.sleep(2000);
		// clicking yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Yes'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the completed button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Completed')])[1]")))
				.click();
		Thread.sleep(2000);
	}

	@Then("navigate to the masterdata dashboard from the screening camps")
	public void navigate_to_the_masterdata_dashboard_from_the_screening_camps() throws Exception {
		driver.close();
	}

	@Then("click on the device management from the masterdata")
	public void click_on_the_device_management_from_the_masterdata() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// searching opd hospital
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchBoxx")))
				.sendKeys("Nanohealth");
		Thread.sleep(2000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='NanoHealth_OPD (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='NanoHealth_OPD'])[1]"))).build().perform();
		Thread.sleep(3000);
		// clicking on the charge masters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Device'])[1]"))).click();
		Thread.sleep(5000);
	}

	@And("click on the device details to select device type")
	public void click_on_the_device_details_to_select_device_type() throws Exception {
		// clicking on the device type details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Device Details'])[1]")))
				.click();
		Thread.sleep(3000);
	}

	@Then("selecting the device type from the dropdown and searching")
	public void selecting_the_device_type_from_the_dropdown_and_searching() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum device type'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div/div[3]/div/div/div[1]/div/div/table/tbody/tr/td[7]/a[2]/img"))).click();
		Thread.sleep(2000);
		// de-link the healthcoach
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@class='unlink_btn btn-loader'])[1]/img[1]"))).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum device type'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("clicking on the delete button beside edit button")
	public void clicking_on_the_delete_button_beside_edit_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash-o'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the confirm button to delete")
	public void clicking_on_the_confirm_button_to_delete() throws Exception {
		// clicking on the confirm button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Confirm!'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("click on the device type details to select device type")
	public void click_on_the_device_type_details_to_select_device_type() throws Exception {
		// clicking on the device type details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Device Type Details']")))
				.click();
		Thread.sleep(3000);
	}

	@Then("selecting the device type from the dropdown to delete")
	public void selecting_the_device_type_from_the_dropdown_to_delete() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum device type'])[1]")))
				.click();
		Thread.sleep(1000);
	}

	@And("clicking on the search button to get the device type details data")
	public void clicking_on_the_search_button_to_get_the_device_type_details_data() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the delete button and confirm deleting")
	public void clicking_on_the_delete_button_and_confirm_deleting() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash-o'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Confirm!'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("click on the device type details from the device masters page")
	public void click_on_the_device_type_details_from_the_device_masters_page() throws Exception {
		// clicking on the device type details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Device Type Details']")))
				.click();
		Thread.sleep(3000);
	}

	@Then("click on the plus button to add new device1")
	public void click_on_the_plus_button_to_add_new_device1() throws Exception {
		// clicking on the plus icon

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement add = driver.findElement(By.xpath("//i[text()='add']"));
		js.executeScript("arguments[0].click();", add);
		Thread.sleep(2000);
	}

	@And("enter the device type and description")
	public void enter_the_device_type_and_description() {
		// input#device_type_master_device_type
		// device type
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_type_master_device_type")))
				.sendKeys("Cucumber device typeee");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_type_master_desc")))
				.sendKeys("Cucumber device type description");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enable the active checkbox for new device")
	public void enable_the_active_checkbox_for_new_device() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("//label[text()='Active']"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the save button to add new device master")
	public void click_on_the_save_button_to_add_new_device_master() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("Edit and update the device name")
	public void edit_and_update_the_device_name() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(1000);
		// device type
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_type_master_device_type")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// device type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_type_master_device_type")))
				.sendKeys("Cucum device type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the save button from the edit device popup")
	public void click_on_the_save_button_from_the_edit_device_popup() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Save'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("searching added device using dropdown")
	public void searching_added_device_using_dropdown() throws Exception {
		// searching with the device type name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cucum device type'][1]")))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(2000);

	}

	@Then("click on the device details from the device masters page")
	public void click_on_the_device_details_from_the_device_masters_page() throws InterruptedException {
		// clicking on the device details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Device Details']"))).click();
		Thread.sleep(1000);
	}

	@And("click on the plus button to add new device2")
	public void click_on_the_plus_button_to_add_new_device2() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='add']"))).click();
		Thread.sleep(1000);
	}

	@Then("select the device type from the dropdown to add new device")
	public void select_the_device_type_from_the_dropdown_to_add_new_device() throws Exception {
		// selecting the device type
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/main/div/div[3]/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div/span/span[1]/span")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cucum device type']"))).click();
		Thread.sleep(1000);
	}

	@And("enter the following details in the add new device popup")
	public void enter_the_following_details_in_the_add_new_device_popup(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> dm = dataTable.asLists(String.class);
		// entering the device id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_device_id")))
				.sendKeys(dm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the device name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_device_name")))
				.sendKeys(dm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the UUID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_uuid")))
				.sendKeys(dm.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the major
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_major")))
				.sendKeys(dm.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the minor
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_minor")))
				.sendKeys(dm.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the rent p.day
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_rent_per_day")))
				.sendKeys(dm.get(5).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the sale price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_sale_price")))
				.sendKeys(dm.get(6).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enable the avaible checkbox to add new device popup")
	public void enable_the_avaible_checkbox_to_add_new_device_popup() {
		for (int i = 0; i <= 1; i++) {
			WebElement avaiable = driver.findElement(By.xpath("(//label[text()='Available'])[2]"));
			avaiable.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the save button to add new device")
	public void click_on_the_save_button_to_add_new_device() throws Exception {
		// clicking on the save button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save'][1]"))).click();
		Thread.sleep(3000);
	}

	@Then("edit and update the rent per day")
	public void edit_and_update_the_rent_per_day() throws Exception {
		// edit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(1000);
		// entering the rent p.day
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_rent_per_day")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the rent p.day
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#device_master_rent_per_day")))
				.sendKeys("2000");
		Thread.sleep(1000);
	}

	@And("click on the save button from the edit new device popup")
	public void click_on_the_save_button_from_the_edit_new_device_popup() throws Exception {
		// clicking on the save button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save'][1]"))).click();
		Thread.sleep(3000);
	}

	@Then("searching with the device type using dropdown")
	public void searching_with_the_device_type_using_dropdown() throws Exception {
		// searching with the device type
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cucum device type']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Search'][1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset'][1]"))).click();
		Thread.sleep(2000);
	}

	@And("searching with the device id using dropdown")
	public void searching_with_the_device_id_using_dropdown() throws Exception {
		// searching with the device ID
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='cucumberid1234']"))).click();
		Thread.sleep(1000);
		// clicking on the search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Search'][1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(1000);
	}

	@Then("searching with the avaible dropdown")
	public void searching_with_the_avaible_dropdown() throws Exception {
		// searching with the device avaible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//label[text()='Available'])[1]/following-sibling::span[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Available Only']"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Search'][1]"))).click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(1000);
		// download devices
		Actions down = new Actions(driver);
		down.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum')])[1]")))
				.click();
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//a[@class='device_name'])[1]")).click();
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div/div[3]/div/div/div[1]/div/div/table/tbody/tr/td[7]/a[2]/img"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='selection'])[7]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Cucum Healthcoach'])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Submit'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("navigate to the masterdata dashboard from the device masters page")
	public void navigate_to_the_masterdata_dashboard_from_the_device_masters_page() throws Exception {
		driver.close();
	}

	@And("click on the formbuilder button from the digitaltwin")
	public void click_on_the_formbuilder_button_from_the_digitaltwin() throws Exception {
		// clicking on the form builder from the facilitydigitaltwin
		driver.findElement(By.xpath("(//div[text()='Form Builder'])[1]")).click();
		Thread.sleep(8000);
	}

	@Then("deleting the already created form from the UI")
	public void deleting_the_already_created_form_from_the_UI() throws Exception {
		driver.findElement(By.xpath("(//input[@id='form_name'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='formName'])[1]")).sendKeys("Cucum");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@title='Delete Form'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='Yes'])[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//button[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the formbuilder to create a new form")
	public void click_on_the_formbuilder_to_create_a_new_form() throws Exception {
	}

	@And("mouse hover and click on the plus button to create a new form")
	public void mouse_hover_and_click_on_the_plus_button_to_create_a_new_form() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Create Form'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@data-tooltip='Create Form'])[1]/img[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the form type from form type and form name popup")
	public void select_the_form_type_from_form_type_and_form_name_popup() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// clicking on the reset button
		driver.findElement(By.xpath("(//div[text()='Reset'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Form Type'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// clicking on the add button for error validation
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Add'])[1]")))).click();
		Thread.sleep(2000);
	}

	@When("form type is selected then form name and label configuration question will display")
	public void form_type_is_selected_then_form_name_and_label_configuration_question_will_display() {
	}

	@Then("enter the form name and select the label configuration for that form")
	public void enter_the_form_name_and_select_the_label_configuration_for_that_form() throws Exception {
		driver.findElement(By.xpath("(//label/span[text()='Form Name'])[1]/following-sibling::input[1]"))
				.sendKeys("Cucum formbuilder" + Keys.TAB);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("click on the add button from form type and form name popup")
	public void click_on_the_add_button_from_form_type_and_form_name_popup() throws Exception {
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Add'])[1]")))).click();
		Thread.sleep(2000);
	}

	@Then("add responsible role and add header footer for the form")
	public void add_responsible_role_and_add_header_footer_for_the_form() throws Exception {
		// clicking on the X remove all resp role name
		driver.findElement(By.xpath("(//div[@aria-label='Remove All'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the dropdown button to add resp role name
		// driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div")).click();
		driver.findElement(By.xpath("(//span[text()='Responsible Role'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		// selecting the resp role name from dropdown
		driver.findElement(By.xpath("(//div[text()='Clinic_Manager'])[1]")).click();
		Thread.sleep(1000);
		// is_active
		for (int i = 0; i <= 1; i++) {
			WebElement is_active = driver.findElement(By.xpath("(//label[@class='is-active-container'])[1]/input[1]"));
			is_active.click();
		}

		// clicking on the three dot s
		driver.findElement(By.xpath("(//img[@title='More Details'])[1]")).click();
		Thread.sleep(3000);

		WebElement male = driver.findElement(By.xpath("(//span[text()='Male'])[1]"));
		male.click();
		Thread.sleep(1000);
		WebElement all = driver.findElement(By.xpath("(//span[text()='All'])[1]"));
		all.click();
		Thread.sleep(1000);

		// uploading header
		try {
			driver.findElement(By.cssSelector("input#fileInputF-header_img_url"))
					.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\varahi_header.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.findElement(By.xpath("(//input[@name='header_img_height'])[1]")).sendKeys("40");
		Thread.sleep(1000);
		// uploading footer
		try {
			driver.findElement(By.cssSelector("input#fileInputF-footer_img_url"))
					.sendKeys("C:\\Users\\Admin\\Desktop\\Automationuploadfile\\varahi_footer.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.findElement(By.xpath("(//input[@name='footer_img_height'])[1]")).sendKeys("20");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the add parameter button
		driver.findElement(By.xpath("(//button[@title='Add New Parameter'])[1]")).click();
		Thread.sleep(2000);
		WebElement select = driver.findElement(By.xpath("(//select[@class='parameter-select react_css'])[1]"));
		Select parameter = new Select(select);
		parameter.selectByVisibleText("Save as draft");
		Thread.sleep(1000);
		WebElement no = driver.findElement(By.xpath("(//label/input[@value='No'])[1]"));
		no.click();
		Thread.sleep(1000);
		WebElement yes = driver.findElement(By.xpath("(//label/input[@value='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Delete'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the add parameter button
		driver.findElement(By.xpath("(//button[@title='Add New Parameter'])[1]")).click();
		Thread.sleep(2000);
		WebElement select1 = driver.findElement(By.xpath("(//select[@class='parameter-select react_css'])[1]"));
		Select parameter1 = new Select(select1);
		parameter1.selectByVisibleText("Save as draft");
		Thread.sleep(1000);
		WebElement no1 = driver.findElement(By.xpath("(//label/input[@value='No'])[1]"));
		no1.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@title='Update'])[1]/img[1]")).click();
		Thread.sleep(2000);
		WebElement yes1 = driver.findElement(By.xpath("(//label/input[@value='Yes'])[1]"));
		yes1.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the save button from form details popup
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the string question type from left side question types")
	public void click_on_the_string_question_type_from_left_side_question_types() throws Exception {
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='String'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='String'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("string question is clicked then Add String Type Question")
	public void string_question_is_clicked_then_add_string_type_question() {
	}

	@Then("select the question and give label configuration for that question")
	public void select_the_question_and_give_label_configuration_for_that_question() throws InterruptedException {

		driver.findElement(By.xpath("(//div[text()='Notes'])[1]")).click();
		Thread.sleep(1000);
		// removing filter
		driver.findElement(By.xpath("(//span[@title='Clear filter'])[1]")).click();
		Thread.sleep(1000);
		// adding another question
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='Integer'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Integer'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='react_css'])[1]")).sendKeys("Height");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@title='Height'])[1]")).click();
		Thread.sleep(1000);

	}

	@And("click on add button to add first question in the form")
	public void click_on_add_button_to_add_first_question_in_the_form() throws Exception {

	}

	@And("add another ques and made it dependent parent and child question")
	public void add_another_ques_and_made_it_dependent_parent_and_child_question() throws Exception {
		// driver.findElement(By.xpath("(//img[@alt='String'])[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath(
		// "(//label/span[text()='Existing
		// Question'])[1]/following-sibling::div[1]/div[1]/div[1]/div[2]/input[1]"))
		// .sendKeys("Other" + Keys.ENTER);
		// Thread.sleep(2000);
		// removing filter
		driver.findElement(By.xpath("(//span[@title='Clear filter'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the questions
		driver.findElement(By.xpath("(//div[text()='Questions'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='react_css'])[1]")).sendKeys("Other");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Other'])[1]")).click();
		Thread.sleep(1000);
		// rename question name
		driver.findElement(By.xpath("(//div[@id='bfocus'])[3]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@id='bfocus'])s[3]")).sendKeys("Cucum dependentquestion");
		Thread.sleep(1000);
		// //making this question as dependentque through drag n drop
		// Actions drag0= new Actions(driver);
		// drag0.moveToElement(driver.findElement(By.xpath("(//img[@alt='drag'])[2]"))).build().perform();
		// Thread.sleep(2000);
		// WebElement drag1 = driver.findElement(By.xpath("(//img[@alt='drag'])[2]"));
		// Actions actions11 = new Actions(driver);
		// actions11.clickAndHold(drag1).moveByOffset(0, -100).release().perform();
		// Thread.sleep(1000);

		WebElement source = driver.findElement(By.xpath(
				"(//span[@title='Drag to reorder within row / drag to another row / drag to empty space to create new row'])[3]"));
		WebElement target = driver.findElement(By.xpath(
				"(//span[@title='Drag to reorder within row / drag to another row / drag to empty space to create new row'])[1]"));
		Actions clickandhold = new Actions(driver);
		clickandhold.clickAndHold(source).build().perform();
		Thread.sleep(2000);
		clickandhold.dragAndDropBy(target, 0, -10).release().build().perform();
		Thread.sleep(2000);
	}

	@Then("click on the integer question type from left side question types")
	public void click_on_the_integer_question_type_from_left_side_question_types() throws Exception {
		// click on the question type
		driver.findElement(By.xpath("(//div[text()='Question Types'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the question for integer and give label configuration for that question")
	public void select_the_question_for_integer_and_give_label_configuration_for_that_question() throws Exception {

	}

	@And("click on add button to add second question in the form")
	public void click_on_add_button_to_add_second_question_in_the_form() throws Exception {

	}

	@Then("search the question type as radio and click on it")
	public void search_the_question_type_as_radio_and_click_on_it() throws Exception {
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).sendKeys("Radio");
		Thread.sleep(1000);
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='Radio'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Radio'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("select the question for radio and give label configuration for that question")
	public void select_the_question_for_radio_and_give_label_configuration_for_that_question() throws Exception {
		// driver.findElement(By.xpath("(//label/span[text()='Existing
		// Question'])[1]/following-sibling::div[1]")).click();
		// Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Diabetes'])[1]")).click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='que-input-area'])[5]"))).build().perform();
		Thread.sleep(1000);
		// clicking on the three dots and changing the options
		driver.findElement(By.xpath("(//img[@title='More Details'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@name='options'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//textarea[@name='options'])[1]")).sendKeys("Y,N");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		// clear the filters
		driver.findElement(By.xpath("(//span[@title='Clear filter'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on add button to add third question in the form")
	public void click_on_add_button_to_add_third_question_in_the_form() throws Exception {

	}

	@Then("search the question type as checkbox and click on it")
	public void search_the_question_type_as_checkbox_and_click_on_it() throws Exception {
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).sendKeys("Checkbox");
		Thread.sleep(2000);
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='Checkbox'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Checkbox'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("select the question for checkbox and give options and label configuration for that question")
	public void select_the_question_for_checkbox_and_give_options_and_label_configuration_for_that_question()
			throws Exception {
		driver.findElement(By.xpath("(//div[contains(text(),'Checkbox1')])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("click on add button to add fourth question in the form")
	public void click_on_add_button_to_add_fourth_question_in_the_form() throws Exception {

	}

	@And("remove the last question from the creating form")
	public void remove_the_last_question_from_the_creating_form() throws Exception {
		Actions lastque = new Actions(driver);
		lastque.moveToElement(driver.findElement(By.xpath("(//div[@class='que-input-area'])[6]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Delete'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[text()='Yes'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("drag and down the questions")
	public void drag_and_down_the_questions() throws Exception {
		WebElement source1 = driver.findElement(By.xpath("(//span[@title='Drag to reorder question rows'])[3]"));
		WebElement target = driver.findElement(By.xpath("(//span[@title='Drag to reorder question rows'])[1]"));
		Actions clickandhold = new Actions(driver);
		clickandhold.clickAndHold(source1).build().perform();
		Thread.sleep(2000);
		clickandhold.dragAndDropBy(target, 0, -10).release().build().perform();
		Thread.sleep(2000);
	}

	@And("click on save button to create the new form")
	public void click_on_save_button_to_create_the_new_form() throws Exception {
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the viewbutton
		driver.findElement(By.xpath("(//span[@title='View'])[1]/img[1]")).click();
		Thread.sleep(2000);
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
		Thread.sleep(3000);
	}

	@Then("edit the form add the newly created question and save changes")
	public void edit_the_form_add_the_newly_created_question_and_save_changes() throws Exception {
		// driver.findElement(By.xpath("(//img[@title='Filter'])[1]")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("(//input[@id='formName'])[1]")).sendKeys("Cucum");
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//button[text()='Search'])[1]")).click();
		// Thread.sleep(3000);
		// edit the form
		driver.findElement(By.xpath("(//span[@title='Edit'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@title='Form Preview'])[1]")).click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).sendKeys("Date");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Date'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(text(),'Date')])[1]")).click();
		Thread.sleep(1000);

		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//div[@class='que-input-area'])[6]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@title='More Details'])[2]")).click();
		Thread.sleep(1000);
		// time only
		driver.findElement(By.xpath("(//label[text()='Time Only'])[1]")).click();
		Thread.sleep(1000);
		WebElement req = driver.findElement(By.xpath("(//label/span[text()='Required'])[1]"));
		req.click();
		Thread.sleep(1000);
		// changing the question label
		driver.findElement(By.xpath("(//input[@name='questn_desc'])[1]")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("1").perform();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// clicking on the save btn from more details popup
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		// clear filters
		driver.findElement(By.xpath("(//span[@title='Clear filter'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).clear();
		Thread.sleep(1000);
		// adding another question
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).sendKeys("Paragraph");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Paragraph'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Daily 4CW Text'])[1]")).click();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='que-input-area'])[6]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@title='More Details'])[2]")).click();
		Thread.sleep(1000);
		WebElement req1 = driver.findElement(By.xpath("(//label/span[text()='Required'])[1]"));
		req1.click();
		Thread.sleep(1000);
		// changing the question label
		driver.findElement(By.xpath("(//input[@name='questn_desc'])[1]")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		// Actions action = new Actions(driver);
		action.sendKeys("2").perform();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Save'])[1]")))).click();
		Thread.sleep(2000);
		WebElement source1 = driver.findElement(By.xpath(
				"(//span[@title='Drag to reorder within row / drag to another row / drag to empty space to create new row'])[6]"));
		WebElement target = driver.findElement(By.xpath(
				"(//span[@title='Drag to reorder within row / drag to another row / drag to empty space to create new row'])[3]"));
		Actions clickandhold = new Actions(driver);
		clickandhold.clickAndHold(source1).build().perform();
		Thread.sleep(2000);
		clickandhold.dragAndDropBy(target, 0, -10).release().build().perform();
		Thread.sleep(2000);

		// WebElement source11 = driver.findElement(By.xpath("(//span[@title='Drag to
		// reorder within row / drag to another row / drag to empty space to create new
		// row'])[6]"));
		// WebElement target1 =
		// driver.findElement(By.xpath("(//div[@class='questions-container'])[1]"));
		// Actions clickandhold1 =new Actions(driver);
		// clickandhold1.clickAndHold(source1).build().perform();
		// Thread.sleep(2000);
		// clickandhold1.dragAndDropBy(target1, 0,5).release().build().perform();
		// Thread.sleep(2000);

		// renaming the form
		driver.findElement(By.xpath("(//input[@id='bfocus1'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='bfocus1'])[1]")).sendKeys("Cucum formbuilder");
		Thread.sleep(1000);
		// clicking on the save btn from form
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(8000);
		driver.close();
	}

	@Then("click on the storemaster from the masterdata")
	public void click_on_the_storemaster_from_the_masterdata() throws Exception {
		// driver.findElement(By.xpath("(//a[text()='Store Masters'])[1]")).click();
		// Thread.sleep(1000);
	}

	@And("search and delete the already existing storemaster")
	public void search_and_delete_the_already_existing_storemaster() throws Exception {
		// driver.findElement(By.cssSelector("input#q_store_name_start")).sendKeys("Cucum");
		// Thread.sleep(1000);
		// // search
		// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		// Thread.sleep(3000);
		// // clicking on the delete button
		// driver.findElement(By.xpath("(//i[@class='fa fa-trash-o fa-1x
		// red-text'])[1]")).click();
		// Thread.sleep(2000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(4000);
	}

	@When("existing storemaster is deleted")
	public void existing_storemaster_is_deleted() {

	}

	@Then("click on the plus button to add new storemaster")
	public void click_on_the_plus_button_to_add_new_storemaster() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='plusminus'])[1]"))).click();
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		try {
			action1.moveToElement(driver.findElement(By.xpath("(//img[@alt='StoreIcon'])[1]"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		action1.dragAndDrop(driver.findElement(By.xpath("(//img[@alt='StoreIcon'])[1]")),
				driver.findElement(By.xpath("(//div[@class='react-flow__pane'])[1]"))).build().perform();
	}

	@When("plus button is clicked it will open a popup to add new storemaster")
	public void plus_button_is_clicked_it_will_open_a_popup_to_add_new_storemaster() {

	}

	@Then("select the hospital name from dropdown")
	public void select_the_hospital_name_from_dropdown() {
		WebElement city = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/select[1]"));
		Select hsplt = new Select(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hsplt.selectByVisibleText("Cucum Hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the required store type and store name")
	public void enter_the_required_store_type_and_store_name() {
		// store type
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[2]/following-sibling::div[1]/input[1]")))
				.sendKeys("Test store type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// store name
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div[1]/input[1]")))
				.sendKeys("Cucum store");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the save button to save the new store master")
	public void click_on_the_save_button_to_save_the_new_store_master() throws Exception {
		// save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[1]"))).click();
		Thread.sleep(3000);
	}

	@And("search the store and click on the edit button")
	public void search_the_store_and_click_on_the_edit_button() throws Exception {
		// // searching ipd hospital
		// driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum");
		// Thread.sleep(2000);
		//
		// JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		// WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum
		// Hospital (Hospital)'])[1]"));
		// jse5.executeScript("arguments[0].click();", element);
		// Thread.sleep(3000);
		//
		// List<WebElement> laststore = driver.findElements(By.xpath(
		// "(//div[@class='react-flow__handle react-flow__handle-bottom nodrag nopan
		// target connectable connectablestart connectableend connectionindicator'])"));
		// WebElement laststore1 = laststore.get(laststore.size() - 1);
		//
		// // connecting store to the hospital
		// Actions connection = new Actions(driver);
		// connection.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]")),
		// laststore1).build()
		// .perform();
		// Thread.sleep(2000);
		//
		// // yes
		// driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		// Thread.sleep(3000);

	}

	@Then("edit the changes and save again of store master")
	public void edit_the_changes_and_save_again_of_store_master() throws Exception {

	}

	@And("search the recently added store using search functionality")
	public void search_the_recently_added_store_using_search_functionality() throws Exception {

	}

	@Then("navigate to the masterdata dashboard from storemaster")
	public void navigate_to_the_masterdata_dashboard_from_storemaster() throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//img[@title='Click to close.'])[1]")).click();
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='URL Shortner'])[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='url'])[1]")))
				.sendKeys("Https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
		// generate url
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#url_submit_btn"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='content_copy'])[1]"))).click();
		Thread.sleep(1000);
		// opening new tab
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_N);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// pasting the url link
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// clicking on the enter button
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		Robot robot31 = new Robot();
		robot31.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot31.keyPress(KeyEvent.VK_W);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='clear'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='brand-logo'])/img[1]")))
				.click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]")))
				.click();
		Thread.sleep(3000);
		// selecting Role clicking on IPD Clinic_manager Role
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_IPD'])[1]"))).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]"))).click().build()
				.perform();
		Thread.sleep(18000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Department Masters'])[1]")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[text()='add'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@id='department_master_department_name'])[1]")))
				.sendKeys("Cucum department");
		Thread.sleep(2000);
		WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no.click();
		Thread.sleep(1000);
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//label[text()='Department Name'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[contains(text(),'Cucum')])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		driver.close();

	}

	// @And("click on the url shortener button from the masterdata")
	// public void click_on_the_url_shortener_button_from_the_masterdata() throws
	// Exception {
	//
	// driver.findElement(By.xpath("(//div[text()='URL Shortner'])[1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the url and click on the generate url button")
	// public void enter_the_url_and_click_on_the_generate_url_button() throws
	// Exception {
	// driver.findElement(By.xpath("(//input[@name='url'])[1]"))
	// .sendKeys("Https://customer.nanohealthplan.com/users/sign_in");
	// Thread.sleep(2000);
	// // generate url
	// driver.findElement(By.cssSelector("input#url_submit_btn")).click();
	// Thread.sleep(2000);
	// }
	//
	// @When("shortener link is generated then it will show the shortener url in the
	// below")
	// public void
	// shortener_link_is_generated_then_it_will_show_the_shortener_url_in_the_below()
	// {
	//
	// }
	//
	// @Then("copy the url using copy button")
	// public void copy_the_url_using_copy_button() throws Exception {
	// driver.findElement(By.xpath("(//i[text()='content_copy'])[1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("paste it in the new tab and click enter")
	// public void paste_it_in_the_new_tab_and_click_enter() throws Exception {
	// // opening new tab
	// Robot robot = new Robot();
	// robot.keyPress(KeyEvent.VK_CONTROL);
	// Thread.sleep(1000);
	// robot.keyPress(KeyEvent.VK_N);
	// Thread.sleep(1000);
	// robot.keyRelease(KeyEvent.VK_N);
	// Thread.sleep(1000);
	// robot.keyRelease(KeyEvent.VK_CONTROL);
	// Thread.sleep(1000);
	//
	// // pasting the url link
	// Robot robot1 = new Robot();
	// robot1.keyPress(KeyEvent.VK_CONTROL);
	// Thread.sleep(1000);
	// robot1.keyPress(KeyEvent.VK_V);
	// Thread.sleep(1000);
	// robot1.keyRelease(KeyEvent.VK_V);
	// Thread.sleep(1000);
	// robot1.keyRelease(KeyEvent.VK_CONTROL);
	// Thread.sleep(1000);
	//
	// // clicking on the enter button
	// Robot robot3 = new Robot();
	// robot3.keyPress(KeyEvent.VK_ENTER);
	// Thread.sleep(1000);
	// }
	//
	// @When("it will open the link of the url shortener and closing this tab")
	// public void it_will_open_the_link_of_the_url_shortener_and_closing_this_tab()
	// throws Exception {
	// Robot robot3 = new Robot();
	// robot3.keyPress(KeyEvent.VK_CONTROL);
	// Thread.sleep(1000);
	// robot3.keyPress(KeyEvent.VK_W);
	// Thread.sleep(2000);
	// }
	//
	// @Then("navigated back to the previous page and just click on the close
	// button")
	// public void
	// navigated_back_to_the_previous_page_and_just_click_on_the_close_button()
	// throws Exception {
	// driver.findElement(By.xpath("(//i[text()='clear'])[1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("clicking on the reset button from the url shortener page")
	// public void clicking_on_the_reset_button_from_the_url_shortener_page() throws
	// Exception {
	// driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
	// Thread.sleep(2000);
	// }
	//
	// @Then("navigate to the masterdata dashboard from url shortener")
	// public void navigate_to_the_masterdata_dashboard_from_url_shortener() throws
	// Exception {
	// Thread.sleep(1000);
	// // driver.close();
	// }
	//
	// @And("click on department master from digitaltwin dashboard")
	// public void click_on_department_master_from_digitaltwin_dashboard() throws
	// Exception {
	// // // clicking on the brand logo & changing role
	// // WebDriverWait logoclick = new WebDriverWait(driver,
	// Duration.ofSeconds(30));
	// // logoclick
	// // .until(ExpectedConditions.visibilityOf(driver
	// //
	// .findElement(By.xpath("(//div[@id='leftone'])[1]/following-sibling::aside[1]/div[1]/img[1]"))))
	// // .click();
	// // Thread.sleep(3000);
	// driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
	// Thread.sleep(2000);
	// // selecting the NanoHealth CDP
	// driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
	// Thread.sleep(3000);
	// // selecting Role clicking on IPD Clinic_manager Role
	// driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager -
	// NanoHealth_IPD'])[1]")).click();
	// Thread.sleep(3000);
	// Actions action = new Actions(driver);
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.xpath("(//a[text()='Facility
	// Digital Twin'])[1]"))).click().build()
	// .perform();
	// Thread.sleep(18000);
	// driver.findElement(By.xpath("(//div[text()='Department
	// Masters'])[1]")).click();
	// Thread.sleep(5000);
	// driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("add new department and save the department")
	// public void add_new_department_and_save_the_department() throws Exception {
	// driver.findElement(By.xpath("(//input[@id='department_master_department_name'])[1]"))
	// .sendKeys("Cucum department");
	// Thread.sleep(2000);
	// WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
	// no.click();
	// Thread.sleep(1000);
	// WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
	// yes.click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]")).click();
	// Thread.sleep(3000);
	// driver.findElement(By.xpath("(//label[text()='Department
	// Name'])[1]/following-sibling::span[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//li[contains(text(),'Cucum')])[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
	// Thread.sleep(2000);
	// driver.close();
	// }
}
