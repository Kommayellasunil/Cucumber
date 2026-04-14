package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

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

public class Createorder {
	WebDriver driver = null;

	@Given("open nh portal {string}")
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

	@Then("entering the username {string} and password {string}")
	public void entering_the_username_and_password(String username, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(10000);
	}

	@Then("clicking sign in button")
	public void clicking_sign_in_button() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the profile for cdpadmin to delete the old patient")
	public void selecting_the_profile_for_cdpadmin_to_delete_the_old_patient() throws InterruptedException {
	}

	@Then("delete the patient and switch to the pharmacist role from cdpadmin role")
	public void delete_the_patient_and_switch_to_the_pharmacist_role_from_cdpadmin_role() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.id("frst_nm")).sendKeys("9988771121");
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile

		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
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
		Thread.sleep(8000);
		// brand logo click
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("selecting the profile for pharmacist")
	public void selecting_the_profile_for_pharmacist() throws Exception {
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on register new patient from above page")
	public void click_on_register_new_patient_from_above_page() throws Exception {
		Thread.sleep(2000);
		WebDriverWait addpatient = new WebDriverWait(driver, Duration.ofSeconds(30));
		addpatient
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img[1]"))))
				.click();
		Thread.sleep(3000);
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("createorder");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("40");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// country code
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("nmbr")).sendKeys("9988771121");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("testphamord@gmail.com");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@name='adrs_line2'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("Ameerpet");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("testcity");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("testdist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		// pincode
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("500034");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// selecting demand program
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("enter the details for the patient registration")
	public void enter_the_details_for_the_patient_registration() {

	}

	@Then("click on the submit button to register the patient")
	public void click_on_the_submit_button_to_register_the_patient() throws Exception {
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(8000);
	}

	@When("patient is registered then create order page will be opened")
	public void patient_is_registered_then_create_order_page_will_be_opened() throws Exception {
		// changing role to pharmacist role
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on pharmacy
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(5000);
		// searching with name
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("Democreateorder");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
	}

	@Then("enter the brandname and enter the qty for the brandmaster")
	public void enter_the_brandname_and_enter_the_qty_for_the_brandmaster() throws Exception {
//		driver.findElement(By.id("prescription_sale_order_header_doctor_name")).sendKeys("d");
		driver.findElement(By.xpath("(//label[text()='Doctor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_DOWN);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		robot2.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Brand Name'])/preceding-sibling::textarea[1]")).sendKeys("Sunil");
//		Thread.sleep(1000);
		WebElement brandInput = driver
				.findElement(By.xpath("(//label[text()='Brand Name'])/preceding-sibling::textarea[1]"));

		String text = "Sunil";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		// mouse hover on inventory
		Actions inv = new Actions(driver);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Inventory'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Inventory'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		// closing inventory
		driver.findElement(By.xpath("(//span[@class='btn-close nh_close btn-floating mr-15'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// selecting the batch
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[contains(text(),'1304(Dec-36)')])[1]")))).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[contains(text(),'1304(Dec-30)')][1]")).click();
//		Thread.sleep(3000);
		// entering the qty.
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input")).sendKeys("1");
		Thread.sleep(2000);
		// adding & deleting another
		driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[4]/div/a/i")).click();
		Thread.sleep(1000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);

	}

	@Then("click on the estimatebill button at the bottom of the page")
	public void click_on_the_estimatebill_button_at_the_bottom_of_the_page() throws Exception {
		// clicking on the estimate bill
		driver.findElement(By.xpath("(//input[@value='Estimate'])[1]")).click();
		Thread.sleep(8000);
	}

	@When("estimatebill is clicked then order status will be new")
	public void estimatebill_is_clicked_then_order_status_will_be_new() {
	}

	@Then("click on the manage orders new status tab and click on the orderid for the order created")
	public void click_on_the_manage_orders_new_status_tab_and_click_on_the_orderid_for_the_order_created()
			throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacist_orders_list'])[1]")).click();
		Thread.sleep(3000);
		// from-date
		driver.findElement(By.cssSelector("input#q_order_date_gteq")).click();
		Thread.sleep(1000);
		// today date
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.cssSelector("input#q_order_date_lteq")).click();
		Thread.sleep(1000);
		// today date
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the order id
		driver.findElement(By
				.xpath("//table[@id='example']//tr[td[contains(normalize-space(.),'Demo Createorder')]][1]/td[2]/a[1]"))
				.click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("download the estimate bill pdf and click on the delivered button")
	public void download_the_estimate_bill_pdf_and_click_on_the_delivered_button() throws Exception {
		/*
		 * // adding another brand
		 * driver.findElement(By.xpath("(//i[text()='add'])[4]")).click();
		 * Thread.sleep(2000); driver.findElement(By.
		 * xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::textarea[1]")).
		 * sendKeys("W"); Thread.sleep(3000);
		 */

//		// pdf download
//		driver.findElement(By.xpath("(//img[@data-tooltip='Download'])[1]")).click();
//		Thread.sleep(2000);
		// clicking on the verify button
		driver.findElement(By.xpath("(//a[text()='Verify'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the verified status
		driver.findElement(By.xpath("(//a[text()='Verified'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the order id
		driver.findElement(By
				.xpath("//table[@id='example']//tr[td[contains(normalize-space(.),'Demo Createorder')]][1]/td[2]/a[1]"))
				.click();
		Thread.sleep(3000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// adding notes
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("Confirmed by sunil for testing purpose");
		Thread.sleep(1000);
		// yes
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Okay'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the manage orders
		driver.findElement(By.xpath("(//a[@id='pharmacist_orders_list'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the confirmed button
		driver.findElement(By.xpath("(//a[text()='Confirmed'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the order id
		driver.findElement(By
				.xpath("//table[@id='example']//tr[td[contains(normalize-space(.),'Demo Createorder')]][1]/td[2]/a[1]"))
				.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// clicking on the confirmed status
//		driver.findElement(By.xpath("")).click();
//		Thread.sleep(3000);
//		// clicking on the order id
//		driver.findElement(By
//				.xpath("//table[@id='example']//tr[td[contains(normalize-space(.),'Demo Createorder')]][1]/td[2]/a[1]"))
//				.click();
//		Thread.sleep(3000);	
		// clicking on the plus button
		driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[4]/div/a/i")).click();
		Thread.sleep(3000);
		WebElement brandInput = driver
				.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::textarea[1]"));

		String text = "Sunil";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(3000);
		// selecting the batch
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[contains(text(),'1303(Dec-30)')])[1]")))).click();
		Thread.sleep(2000);
//				driver.findElement(By.xpath("//a[contains(text(),'1304(Dec-30)')][1]")).click();
//				Thread.sleep(3000);
		// entering the qty.
		driver.findElement(By.xpath("(//label[text()='QTY'])[2]/following-sibling::input")).sendKeys("1");
		Thread.sleep(2000);
		// mouse hover on inventory
		// deliver
		WebElement deliverButton = driver.findElement(By.xpath("(//input[@value='Delivery'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deliverButton);
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(3000);
	}

	@When("delivered button is clicked it will open the proformainvoice page")
	public void delivered_button_is_clicked_it_will_open_the_proformainvoice_page() {
	}

	@When("enter the amount and generate the invoice id and download the invoices pdfs")
	public void enter_the_amount_and_generate_the_invoice_id_and_download_the_invoices_pdfs() throws Exception {
		// applying the discount percentage
		driver.findElement(By.cssSelector("input#promo_amnt")).click();
		Thread.sleep(2000);
		// proceed clicking
		driver.findElement(By.xpath("(//input[@value='Proceed'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#promo_amnt")).sendKeys("5");
		Thread.sleep(1000);
		// apply btn click
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		// adding comment
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("applied 5 rupees discount");
		Thread.sleep(2000);
		// submit btn click
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#applyCouponBtn"))))
				.click();
		Thread.sleep(3000);
		// close chip
		driver.findElement(By.cssSelector("i.material-icons.close.sale_discount_det_close")).click();
		Thread.sleep(2000);
		// applying the discount percentage
		driver.findElement(By.cssSelector("input#promo_amnt")).sendKeys("5");
		Thread.sleep(1000);
		// apply btn click
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		// adding comment
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("applied 5 rupees discount");
		Thread.sleep(2000);
		// submit btn click
		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#applyCouponBtn"))))
				.click();
		Thread.sleep(5000);
		Robot pgdwn13 = new Robot();
		pgdwn13.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// pay later
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(3000);
		// submit
		driver.findElement(By.cssSelector("a#bookLater")).click();
		Thread.sleep(3000);
//		// clicking on the pay balance
//		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
//		Thread.sleep(5000);
//		Robot pgdwn14 = new Robot();
//		pgdwn14.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		// clicking on the cash btn
//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(2000);
//		// entering the amount
//		driver.findElement(By.id("advance_field")).sendKeys("5");
//		Thread.sleep(2000);
//		// clicking on the comment
//		driver.findElement(By.id("paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.id("payment_cmnt"))
//				.sendKeys("5 rupees discount amount applied & 5 rupees amount paid through cash");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(5000);
		// Generating the invoice
		WebDriverWait generate = new WebDriverWait(driver, Duration.ofSeconds(30));
		generate.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Generate'])[1]"))))
				.click();
		Thread.sleep(2000);
//		// converting to tax invoice
//		WebDriverWait confirm = new WebDriverWait(driver, Duration.ofSeconds(30));
//		confirm.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]"))))
//				.click();
//		Thread.sleep(3000);
		// mouse-hover on invoice - print invoice
		Actions invoice1 = new Actions(driver);
		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
		// clicking on the print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
	}

	@When("share the invoice to the patients emailid through share invoice")
	public void share_the_invoice_to_the_patients_emailid_through_share_invoice() throws Exception {
		// share invoice

		driver.findElement(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(3000);
		WebElement sub = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		sub.click();
		Thread.sleep(10000);
		// clicking on the manage orders
		WebElement mo = driver.findElement(By.xpath("(//a[text()='Manage Orders'])[2]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", mo);
		Thread.sleep(5000);
		// clikcing on the delivered status
		WebElement d = driver.findElement(By.xpath("(//a[text()='Delivered'])[1]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("arguments[0].click();", d);
		Thread.sleep(8000);
	}

	@Then("create a new order with new invoice and merge both invoices from the all orders")
	public void create_a_new_order_with_new_invoice_and_merge_both_invoices_from_the_all_orders() throws Exception {
		// searching with name
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("Democreateorder");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Doctor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.id("prescription_sale_order_header_doctor_name")).sendKeys("d");
//		Thread.sleep(1000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_DOWN);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		robot2.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Brand Name'])/preceding-sibling::textarea[1]")).sendKeys("Wal");
//		Thread.sleep(1000);
		WebElement brandInput = driver
				.findElement(By.xpath("(//label[text()='Brand Name'])/preceding-sibling::textarea[1]"));

		String text = "Walker";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'WALKER')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'123')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input[1]")).sendKeys("1");
		Thread.sleep(1000);
		// delivery button click
		driver.findElement(By.xpath("(//input[@value='Delivery'])[1]")).click();
		Thread.sleep(2000);
		Robot pgdwn13 = new Robot();
		pgdwn13.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// pay later
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(3000);
		// submit
		driver.findElement(By.cssSelector("a#bookLater")).click();
		Thread.sleep(3000);
		// mouse-hover on invoice - print invoice
		Actions invoice = new Actions(driver);
		invoice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		invoice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		// clicking on the all orders
		driver.findElement(By.xpath("(//a[text()='All Orders'])[1]")).click();
		Thread.sleep(3000);
		// download the pdf
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// mouse hover on to the merge invoice
		Actions mergeinv = new Actions(driver);
		mergeinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Merge Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		mergeinv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Merge Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		WebElement mergeradio = driver.findElement(By.xpath(
				"(//form[@id='merge_invoices'])[1]/input[1]/following-sibling::div[1]/div[1]/div[1]/div[1]/label[1]"));
		mergeradio.click();
		Thread.sleep(3000);
		// submit
		driver.findElement(By.xpath("(//input[@id='saveDateInvoice'])[1]")).click();
		Thread.sleep(5000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the pay balance
		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(3000);
		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the cash btn
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(2000);
		// entering the amount
		driver.findElement(By.id("advance_field")).sendKeys("35");
		Thread.sleep(2000);
		// clicking on the comment
		driver.findElement(By.id("paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.id("payment_cmnt"))
				.sendKeys("5 rupees discount amount applied & 35 rupees amount paid through cash");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
//		// converting to tax invoice
//		WebDriverWait confirm = new WebDriverWait(driver, Duration.ofSeconds(30));
//		confirm.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]"))))
//				.click();
//		Thread.sleep(3000);
		// clicking on the manage orders
		WebElement mo = driver.findElement(By.xpath("(//a[text()='Manage Orders'])[2]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", mo);
		Thread.sleep(3000);
		// clikcing on the delivered status
		WebElement d = driver.findElement(By.xpath("(//a[text()='Delivered'])[1]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("arguments[0].click();", d);
		Thread.sleep(8000);
		// selecting the type
		driver.findElement(By.xpath("(//label[contains(text(),'Type')])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'OP')])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
		// selecting the type
		driver.findElement(By.xpath("(//label[contains(text(),'Type')])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'IP')])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("existing patient got deleted from the cdpadmin role then")
	public void existing_patient_got_deleted_from_the_cdpadmin_role_then() throws Exception {

	}

	@And("register an new patient and order medicine and pay the bill amount")
	public void register_an_new_patient_and_order_medicine_and_pay_the_bill_amount() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(5000);
		// selecting cdp admin role
		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.id("frst_nm")).sendKeys("9988771132");
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
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
		Thread.sleep(8000);
		// switching role from pharmacist to clinic manager
		// brand logo click
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img[1]")).click();
		Thread.sleep(3000);
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot11 = new Robot();
		robot11.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("pharmacyreturn");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("40");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// country code
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("nmbr")).sendKeys("9988771132");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//				driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("testphamord@gmail.com");
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@name='adrs_line2'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("Ameerpet");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("testcity");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("testdist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		// pincode
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("500034");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// selecting demand program
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(3000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(8000);
		// brand logo click
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Pharmacist Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(5000);

		// checking the availble qty.
		// mouse - hovering to the inventory
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Inventory Details'])[1]"))).click().build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// selecting the batch code
		driver.findElement(By.xpath("(//label[text()='Batchnumber'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='1304'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		String avaqty = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[5]")).getText();
		System.out.println("Avaiable quantity before ordered:" + avaqty);
		Thread.sleep(5000);
		// searching with name
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("Demopharmacyreturn");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@id='prescription_sale_order_header_doctor_name'])[1]")).sendKeys("d");
//		Thread.sleep(2000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		robot2.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Doctor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Brand Name'])/preceding-sibling::textarea[1]")).sendKeys("Sunil");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(3000);
		// selecting the batch
		driver.findElement(By.xpath("(//a[contains(text(),'1304(Dec-36)')])[1]")).click();
		Thread.sleep(3000);
		// entering the qty.
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input")).sendKeys("1");
		Thread.sleep(2000);
		// deliver
		driver.findElement(By.xpath("(//input[@value='Delivery'])[1]")).click();
		Thread.sleep(3000);
		WebElement radio = driver.findElement(By.xpath("//label[text()='Cash']"));
		radio.click();
		driver.findElement(By.id("advance_field")).sendKeys("10");
		Thread.sleep(1000);
		// clicking on the comment
		driver.findElement(By.id("paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.id("payment_cmnt")).sendKeys("test receipt comment 1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(5000);
		// Generating the invoice
		WebDriverWait generate = new WebDriverWait(driver, Duration.ofSeconds(30));
		generate.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Generate'])[1]"))))
				.click();
		Thread.sleep(2000);
		// confirm
		WebDriverWait confirm = new WebDriverWait(driver, Duration.ofSeconds(30));
		confirm.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Convert to tax invoice'])[1]/img[1]"))))
				.click();
		Thread.sleep(3000);
		// print invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot21 = new Robot();
		robot11.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// receipt download
		driver.findElement(By.xpath("//a[contains(text(), 'R-')]")).click();
		Thread.sleep(2000);
		// total advance
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// downloading pdf
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// clicking on the print without details
		driver.findElement(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// clicking on the share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		submit.click();
		Thread.sleep(10000);
		// checking the availble qty.
		// mouse - hovering to the inventory
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Inventory Details')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// selecting the batch code
		driver.findElement(By.xpath("(//label[text()='Batchnumber'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='1304'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		String orderedqty = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[5]")).getText();
		System.out.println("Avaiable quantity after ordered:" + orderedqty);
		Thread.sleep(8000);

		// clicking on the manage orders
		driver.findElement(By.id("pharmacist_orders_list")).click();
		Thread.sleep(2000);
		// clikcing on the delivered status
		driver.findElement(By.xpath("(//a[text()='Delivered'])[1]")).click();
		Thread.sleep(10000);
		// clicking on the patient name
		WebElement id = driver.findElement(By.xpath("//a[text()='Demo Pharmacyreturn']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", id);
		Thread.sleep(2000);
		// clicking on the edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(1000);
		// return qty.
		driver.findElement(By.xpath("(//input[@class='returnQty'])[1]")).sendKeys("1");
		Thread.sleep(1000);
		// update inovice
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(8000);
		// clicking on the continue
		driver.findElement(By.id("prescriptionContinue")).click();
		Thread.sleep(3000);
		try {
			Robot robot3 = new Robot();
			robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);

		} catch (Exception e) {
			// TODO: handle exception
		}
		WebElement paynow = driver.findElement(By.xpath("(//label[text()='Pay Now'])[1]"));
		paynow.click();
		Thread.sleep(1000);
		// clicking on the return
		WebElement ret = driver.findElement(By.xpath("(//label[text()='Return'])[1]"));
		ret.click();
		Thread.sleep(1000);
		// clicking on the cash
		WebElement cash = driver.findElement(By.xpath("(//label[text()='Cash'])[1]"));
		cash.click();
		// advance paid
		driver.findElement(By.id("advance_field")).sendKeys("10");
		Thread.sleep(3000);
		// receipt comment
		driver.findElement(By.id("paymentComment")).click();
		Thread.sleep(1000);
		// receipt comment
		driver.findElement(By.id("payment_cmnt")).sendKeys("receipt comment");
		Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("(//a[text()='Ok'])[2]"));
		ok.click();
		Thread.sleep(1000);
		// comments
		// driver.findElement(By.id("paymentComment")).click();
		// Thread.sleep(1000);
		// refund reason
		driver.findElement(By.id("refund_rsn")).sendKeys("returning sunil brand qty.");
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//a[text()='Ok'])[1]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(2000);
		// clicking on the print invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// Receipt id 1
		String parentwind = driver.getWindowHandle();
		// Click the link with JS to avoid click interception
		WebElement link = driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
		// Wait a moment for new tab to open
		Thread.sleep(2000);
		// Get all windows
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
			if (!handle.equals(parentwind)) {
				// Switch to child window
				driver.switchTo().window(handle);
				Thread.sleep(2000); // allow page to load
				driver.close(); // close child window
			}
		}
		// Switch back to parent window
		driver.switchTo().window(parentwind);
		// Receipt id 1
		String parentwind1 = driver.getWindowHandle();
		// Click the link with JS to avoid click interception
		WebElement link1 = driver.findElement(By.xpath("(//a[contains(text(),'R-')])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", link1);
		// Wait a moment for new tab to open
		Thread.sleep(2000);
		// Get all windows
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String handle : allWindows1) {
			if (!handle.equals(parentwind1)) {
				// Switch to child window
				driver.switchTo().window(handle);
				Thread.sleep(2000); // allow page to load
				driver.close(); // close child window
			}
		}
		// Switch back to parent window
		driver.switchTo().window(parentwind1);

		// total advance
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// clicking on the print
		String parentwind3 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Invoice'])[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement submit1 = driver
				.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]"));
		submit1.click();
		Thread.sleep(10000);
		// checking the availble qty.
		// mouse - hovering to the inventory
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Inventory Details')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// selecting the batch code
		driver.findElement(By.xpath("(//label[text()='Batchnumber'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='1304'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		String returnedqty = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[5]")).getText();
		System.out.println("Avaiable quantity after return:" + returnedqty);
		Thread.sleep(5000);
	}

	@Then("return the medicine using return quantity from edit")
	public void return_the_medicine_using_return_quantity_from_edit() {

	}
}
