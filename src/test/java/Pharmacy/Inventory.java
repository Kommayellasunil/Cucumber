package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Inventory {
	WebDriver driver = null;

	@Given("naviagate to nh portal {string}")
//	public void naviagate_to_nh_portal() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
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

	@Then("enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(10000);
	}

	@Then("click on sign in")
	public void click_on_sign_in() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the role as pharmacist role")
	public void select_the_role_as_pharmacist_role() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on pharmacy
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("pharmacist dashboard opens")
	public void pharmacist_dashboard_opens() {
	}

	@Then("click on the inventory and click on stockentry")
	public void click_on_the_inventory_and_click_on_stockentry() throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Stock Entry')])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("click on inventory received with invoice")
	public void click_on_inventory_received_with_invoice() throws Exception {
		Actions add = new Actions(driver);
		add.moveToElement(driver.findElement(By.xpath("(//i[text()='add'])[1]"))).build().perform();
		Thread.sleep(1000);
		add.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Received without Invoice')])[1]"))).click()
				.build().perform();
		Thread.sleep(3000);

	}

	@Then("enter the details for the inventory and save as draft")
	public void enter_the_details_for_the_inventory_and_save_as_draft() throws Exception {
		driver.findElement(By.xpath("(//input[@id='pharmacy_purchase_header_purchase_dt'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Distributor Name'])[1]/following-sibling::span[1]/span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Central Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(2000);
//		// reset
//		driver.findElement(By.xpath("(//input[@id='btnClear'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='pharmacy_purchase_header_purchase_dt'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today is-selected'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Distributor Name'])[1]/following-sibling::span[1]/span[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[contains(text(),'Central Pharmacy')])[1]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Brand Name'])[1]/preceding-sibling::input[1]")).sendKeys("Sunil");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Batch'])[1]/following-sibling::input[1]")).sendKeys("12345");
		Thread.sleep(1000);
		// expiry date
		driver.findElement(By.xpath("(//label[text()='ExpDate'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
		Select sc = new Select(
				driver.findElement(By.cssSelector("select.mtz-monthpicker.mtz-monthpicker-year:nth-of-type(1)")));
		sc.selectByValue("2030");
		Thread.sleep(1000);
		// jan
		driver.findElement(By.xpath("//td[text()='Jan']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Pck/Strip Qty'])[1]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckCost'])[1]/following-sibling::input[1]")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Tablet/Pack'])[1]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[1]/following-sibling::input[1]")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Line Discount(%)'])[1]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Line Discount(%)'])[1]/following-sibling::input[1]"))
				.sendKeys("0");
		Thread.sleep(1000);
		Actions mh = new Actions(driver);
		mh.moveToElement(driver.findElement(
				By.xpath("(//input[@id='pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_hsncode'])[1]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='q_received_dt_gteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='q_received_dt_lteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("edit the inventory again add new brand and save")
	public void edit_the_inventory_again_add_new_brand_and_save() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]")).sendKeys("A");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'A2B')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Batch'])[2]/following-sibling::input[1]")).sendKeys("123");
		Thread.sleep(1000);
		// expiry date
		driver.findElement(By.xpath("(//label[text()='ExpDate'])[2]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
//				Select sc1 = new Select(
//						driver.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year'])[2]")));
//				sc1.selectByValue("2028");
//				Thread.sleep(1000);
		// jan
		driver.findElement(By.xpath("(//td[text()='Dec'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Pck/Strip Qty'])[2]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckCost'])[2]/following-sibling::input[1]")).sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Tablet/Pack'])[1]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[2]/following-sibling::input[1]")).sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Line Discount(%)'])[2]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Line Discount(%)'])[2]/following-sibling::input[1]"))
				.sendKeys("0");
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("download the pdf and download the reports")
	public void download_the_pdf_and_download_the_reports() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Then("Mouse hover on plus button to click on received without invoice")
	public void mouse_hover_on_plus_button_to_click_on_received_without_invoice() throws Exception {
		Actions add = new Actions(driver);
		add.moveToElement(driver.findElement(By.xpath("(//i[text()='add'])[1]"))).build().perform();
		Thread.sleep(1000);
		add.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Received with Invoice')])[1]"))).click()
				.build().perform();
		Thread.sleep(3000);
	}

	@Then("fill up the details and click on save button")
	public void fill_up_the_details_and_click_on_save_button() throws Exception {
		driver.findElement(By.xpath("(//input[@id='pharmacy_purchase_header_purchase_dt'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Distributor Name'])[1]/following-sibling::span[1]/span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Central Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Brand Name'])[1]/preceding-sibling::input[1]")).sendKeys("Sunil");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Batch'])[1]/following-sibling::input[1]")).sendKeys("12345");
		Thread.sleep(1000);
		// expiry date
		driver.findElement(By.xpath("(//label[text()='ExpDate'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
		Select sc = new Select(
				driver.findElement(By.cssSelector("select.mtz-monthpicker.mtz-monthpicker-year:nth-of-type(1)")));
		sc.selectByValue("2030");
		Thread.sleep(1000);
		// jan
		driver.findElement(By.xpath("//td[text()='Jan']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Pck/Strip Qty'])[1]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckCost'])[1]/following-sibling::input[1]")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Tablet/Pack'])[1]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[1]/following-sibling::input[1]")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Line Discount(%)'])[1]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Line Discount(%)'])[1]/following-sibling::input[1]"))
				.sendKeys("0");
		Thread.sleep(1000);
		Actions mh = new Actions(driver);
		mh.moveToElement(driver.findElement(
				By.xpath("(//input[@id='pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_hsncode'])[1]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='pharmacy_purchase_header_invoice_id'])[1]")).sendKeys("8790098");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("download the pdf and click on the purchase order button")
	public void download_the_pdf_and_click_on_the_purchase_order_button() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Inventory Received'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the GR No
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-header-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))
				.click();
		Thread.sleep(2000);
		// clicking on the Received date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-header-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))
				.click();
		Thread.sleep(2000);
		// clicking on the purchase order
		driver.findElement(By.xpath("(//a[contains(text(),'Purchase orders')])[1]")).click();
		Thread.sleep(2000);
		// clicking on the invoice id
		driver.findElement(By.xpath("(//a[contains(text(),'8790098')])[1]")).click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-header-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))
				.click();
		Thread.sleep(3000);
		// download the pdf
		driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'8790098')]]//a[@data-tooltip='Download'][1]/img[1]"))
				.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// clicking on the purchase order
		driver.findElement(By.xpath("(//a[contains(text(),'Purchase orders')])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("create purchase order for an brand")
	public void create_purchase_order_for_an_brand() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='pharmacy_purchase_header_purchase_dt'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Distributor Name'])[2]/following-sibling::span[1]/span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Central Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]")).sendKeys("A");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'A2B')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//input[@id='pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_purchase_pck_qty'])[1]"))
				.sendKeys("100");
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[1]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[1]/following-sibling::input[1]")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Disc(%)'])[1]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Disc(%)'])[1]/following-sibling::input[1]")).sendKeys("0");
		Thread.sleep(1000);
		// save as draft
		driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		// download pdf
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]")).click();
		Thread.sleep(3000);
		// download all reports
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);

	}

	@Then("click on the inventory return tab")
	public void click_on_the_inventory_return_tab() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Inventory Return')])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the created GR no and add brand to return")
	public void select_the_created_gr_no_and_add_brand_to_return() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='pharmacy_purchase_header_purchase_dt'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Distributor Name'])[2]/following-sibling::span[1]/span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Central Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		// Collect all the options
		List<WebElement> options = driver.findElements(By.xpath("(//ul[@class='select2-results__options'])[1]/li"));
		// Get the last option
		WebElement lastOption = options.get(options.size() - 1);
		// Click the last option
		lastOption.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]")).sendKeys("Sunil");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Pck/Strip Qty'])[1]/following-sibling::input[1]")).sendKeys("1");
		Thread.sleep(2000);

	}

	@Then("click on save button to return the brand")
	public void click_on_save_button_to_return_the_brand() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("download the return reports")
	public void download_the_return_reports() throws Exception {
		// download pdf
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]")).click();
		Thread.sleep(3000);
		// download pdf report
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on inventory and inventory details")
	public void click_on_inventory_and_inventory_details() throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Inventory Details')])[1]")).click();
		Thread.sleep(3000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Test Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// clicking on the QR code
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[9]/a[2]/img[1]")).click();
		Thread.sleep(2000);
		// closing qr
		driver.findElement(By.xpath("(//div[@id='admitConfirmModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// edit
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[9]/a[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='pharmacy_inventory_detail_remaining_qty'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='pharmacy_inventory_detail_remaining_qty'])[1]")).sendKeys("100");
		Thread.sleep(2000);
		// update
		driver.findElement(By.xpath("(//input[@value='Update'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the transfer details from inventory")
	public void click_on_the_transfer_details_from_inventory() throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer Details')])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("request the brand inventory from other pharmacy by filling details and save")
	public void request_the_brand_inventory_from_other_pharmacy_by_filling_details_and_save() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Request to'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Central Pharmacy')])[1]")).click();
		Thread.sleep(1000);
		// entering the brand and selecting the brand
//		driver.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]")).sendKeys("Sunil");
//		Thread.sleep(3000);
		WebElement brandInput = driver
				.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]"));

		String text = "Sunil brand";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//input[@id='pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_quantity'])[1]"))
				.sendKeys("500");
		Thread.sleep(1000);
		// add one more
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// from-date
		driver.findElement(By.xpath("(//input[@id='q_transfer_dt_gteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.xpath("(//input[@id='q_transfer_dt_lteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the request id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the requested date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// switching to Test pharmacy from central pharmacy
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Central Pharmacy'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer Details')])[1]")).click();
		Thread.sleep(3000);
		// from-date
		driver.findElement(By.xpath("(//input[@id='q_transfer_dt_gteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.xpath("(//input[@id='q_transfer_dt_lteq'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// transfer
		driver.findElement(By.xpath("(//a[text()='Transfer'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Initiate Transfer'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
//		Thread.sleep(2000);
		// switching to Central pharmacy from test pharmacy
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer Details')])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the transfer tab")
	public void click_on_the_transfer_tab() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer')])[4]")).click();
		Thread.sleep(3000);
	}

	@And("transfer the brand to another pharmacy by filling the brand details")
	public void transfer_the_brand_to_another_pharmacy_by_filling_the_brand_details() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Transfer to'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[normalize-space(text())='Central Pharmacy'])[1]")).click();
		Thread.sleep(3000);

//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]"))
//				.sendKeys("Sunil brand");
//		Thread.sleep(3000);
		WebElement brandInput = driver
				.findElement(By.xpath("(//label[text()='Brand Name'])[2]/preceding-sibling::input[1]"));

		String text = "Sunil brand";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// selecting the batch
		driver.findElement(By.xpath("(//a[contains(text(),'1304')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Quantity'])[1]/following-sibling::input[1]"))
				.sendKeys("50000" + Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Quantity'])[1]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Quantity'])[1]/following-sibling::input[1]"))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer')])[4]")).click();
		Thread.sleep(3000);
		// clicking on the request id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the requested date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// switching to Central pharmacy from test pharmacy
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Central Pharmacy'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer Details')])[1]")).click();
		Thread.sleep(3000);
		// clicking on the transfer button
		driver.findElement(By.xpath("(//a[text()='Transfer'])[1]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@id='q_transfer_dt_gteq'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='q_transfer_dt_lteq'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
//		Thread.sleep(5000);
		// clicking on the receive button
		driver.findElement(By.xpath("(//a[text()='Receive'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Received'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Inventory Details')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).sendKeys("Sunil brand");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		String avaialbleqty = driver.findElement(By.xpath("//table[@id='example']/tbody[1]")).getText();
		System.out.println("Avaiable quantity:" + avaialbleqty);
		Thread.sleep(5000);
		// clicking on the manage orders button
		driver.findElement(By.xpath("(//a[@id='pharmacist_orders_list'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Transfer Details')])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the received tab")
	public void click_on_the_received_tab() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Received')])[2]")).click();
		Thread.sleep(3000);
		// clicking on the request id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the requested date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the cancelled tab to see the cancelled details")
	public void click_on_the_cancelled_tab_to_see_the_cancelled_details() throws Exception {
		driver.findElement(By.xpath("(//a[contains(text(),'Cancelled')])[1]")).click();
		Thread.sleep(3000);
		// clicking on the request id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// clicking on the requested date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[contains(text(),'Transfer Details')])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("click on the inventory and click on damageinventoty")
	public void click_on_the_inventory_and_click_on_damageinventoty() throws Exception {
		driver.findElement(By.xpath("(//a[@id='pharmacy-inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Damaged Inventory')])[1]")).click();
		Thread.sleep(3000);
	}

	@And("add the brand name and submit")
	public void add_the_brand_name_and_submit() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		WebElement brandInput = driver
				.findElement(By.xpath("(//label[text()='Brand Name'])[1]/preceding-sibling::textarea[1]"));
		String text = "Sunil brand";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// batch selection path
		driver.findElement(By.xpath("(//a[contains(text(),'1304')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input[1]")).sendKeys("50000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input[1]")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
		// removing
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'TEST PHARMACY')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'SUNIL BRAND')])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
