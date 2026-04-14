package StepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Clinicmanagerbilling {
	WebDriver driver = null;

	@Given("open nh url {string}")
//	public void open_nh_url(String string) {
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

	@Then("enter emailid {string} and password {string}")
	public void enter_emailid_and_password(String emailid, String password) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys(emailid);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(10000);
	}

	@Then("sign in button clicked")
	public void sign_in_button_clicked() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the cdp and clinic manager role")
	public void select_the_cdp_and_clinic_manager_role() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("clicking on the billing and select the patientwisereport1")
	public void clicking_on_the_billing_and_select_the_patientwisereport1() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='revenue_report'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for patientwisereport1")
	public void search_and_download_the_reports_for_patientwisereport1() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Clinic Name'])[1]/preceding-sibling::span[1]")))
				.click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_OPD'])[1]"))).click();
//		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		// Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
//		// clicking on the appointment id
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]"))).click();
//		// Thread.sleep(2000);
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]/i[1]"))).click();
//		Thread.sleep(2000);
		// clicking on the reset button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);

		// service
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Doctor')])[1]"))).click();
//		Thread.sleep(1000);
		// from date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click(); // 01
//		Thread.sleep(1000);
		// to date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]/button"))).click();
//		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
//		// reset
//		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
//		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_patient_master_frst_nm_cont'])[1]")))
				.sendKeys("Cucum");
//		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// download
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
//				.click();
		try {
			// Attempt to click the element
			WebElement downloadIcon = driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]"));
			downloadIcon.click();
		} catch (StaleElementReferenceException e) {
			// If the element is stale, re-find it and try again
			System.out.println("StaleElementReferenceException caught, re-finding the element.");
			WebElement newDownloadIcon = driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]"));
			newDownloadIcon.click();
		}
		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("clicking on the billing and select the doctorwisereport1")
	public void clicking_on_the_billing_and_select_the_doctorwisereport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='doctorWise_report'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for doctorwisereport1")
	public void search_and_download_the_reports_for_doctorwisereport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// clinic name
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Clinic Name'])[1]/preceding-sibling::span[1]")))
				.click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_OPD'])[1]"))).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//label[text()='Doctor Name'])[1]/preceding-sibling::span[1]")))
//				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Dr. Doctor')])[1]")))
				.click();
//		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='month'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'Jan')])[1]"))).click();
		// selecting last month
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='1']"))).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']"))).click();
//		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(10000);
		try {
			// clicking on the download
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
					.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
//		Thread.sleep(1000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
//		Thread.sleep(1000);

	}

	@And("clicking on the billing and select the dueamountreport1")
	public void clicking_on_the_billing_and_select_the_dueamountreport1() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='dueAmount_report'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for dueamountreport1")
	public void clicking_on_the_billing_and_select_the_due_amount_report1() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// name
		wait.until(ExpectedConditions.elementToBeClickable(By.id("q_patient_master_frst_nm_cont"))).sendKeys("cucum");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]/button[1]"))).click();
		Thread.sleep(1000);
		// clicking on the search button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(2000);

		// name & service
		wait.until(ExpectedConditions.elementToBeClickable(By.id("q_patient_master_frst_nm_cont"))).sendKeys("test");
//		Thread.sleep(1000);
		// service
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(text(),'Doctor Consultation')])[1]")))
				.click();
//		Thread.sleep(1000);
		// from date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from-date"))).click();
//		Thread.sleep(1000);
		// previous month click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000); // to date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]/button[1]"))).click();
		Thread.sleep(1000);
		// clicking on the search button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(2000);
		// clicking on the download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(2000);
	}

	@Then("clicking on the billing and select the ipreport")
	public void clicking_on_the_billing_and_select_the_ipreport() throws Exception {
		driver.findElement(By.xpath("(//a[@id='admin-billing-tab'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@id='ip_report'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for ipreport")
	public void search_and_download_the_reports_for_ipreport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#q_patient_master_frst_nm_cont")).sendKeys("Cucum");
		Thread.sleep(1000);
		// searching for the patient name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the ip number
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Ippackage')]][1]//a[contains(text(),'IP-')][1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the qr code
		try {
			// Define an explicit wait with a timeout of 10 seconds.
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Use a more robust locator if possible
			By locator = By.xpath("(//div[@id='ip_forms_modal']//img)[1]");

			// Wait for the element to be visible before finding it
			WebElement myElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));

			// Now you can perform actions on the element
			myElement.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		// downloading the admit now form pdf
//		driver.findElement(By.xpath("//td[normalize-space(.)='Admit Now']//following-sibling::td[1]/a[1]/img[1]"))
//				.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//td[normalize-space(.)='Invoice']//following-sibling::td[1]/a[1]/img[1]"))
//				.click();
		Thread.sleep(1000);

		// Store parent window
		String parentWindow = driver.getWindowHandle();
		/* -------- Admit Now PDF -------- */
		driver.findElement(By.xpath("//td[normalize-space(.)='Admit Now']//following-sibling::td[1]/a[1]/img[1]"))
				.click();
		// Switch to child window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(2000); // wait for PDF to load
				driver.close(); // close child tab
			}
		}
		Thread.sleep(1000);
		// Switch back to parent
		driver.switchTo().window(parentWindow);
		/* -------- Invoice PDF -------- */
		driver.findElement(By.xpath("//td[normalize-space(.)='Invoice']//following-sibling::td[2]/a[1]/img[1]"))
				.click();
		// Switch to child window
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(2000); // wait for PDF to load
				driver.close(); // close child tab
			}
		}
		// Switch back to parent
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

		// Step 1: Click the image link (opens new tab)
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[2]/img[1]")).click();
		// Step 2: Store parent window handle
		String parentWindow1 = driver.getWindowHandle();
		// Step 3: Get all window handles
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow1)) {
				// Step 4: Switch to child tab
				driver.switchTo().window(window);
				// (Optional) Perform any action on child tab
				System.out.println("Child tab title: " + driver.getTitle());
				// Step 5: Close the child tab
				driver.close();
				// Step 6: Switch back to parent tab
				driver.switchTo().window(parentWindow1);
			}
		}
		// Step 1: Click the image link (opens new tab)
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[4]/img[1]")).click();
		// Step 2: Store parent window handle
		String parentWindow11 = driver.getWindowHandle();
		// Step 3: Get all window handles
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String window : allWindows1) {
			if (!window.equals(parentWindow11)) {
				// Step 4: Switch to child tab
				driver.switchTo().window(window);
				// (Optional) Perform any action on child tab
				System.out.println("Child tab title: " + driver.getTitle());
				// Step 5: Close the child tab
				driver.close();
				// Step 6: Switch back to parent tab
				driver.switchTo().window(parentWindow11);
			}
		}
		// uploading pdf
		driver.findElement(By.xpath("(//input[@class='dynamic-upload-input'])[1]"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\MR. CUCUM IPFLOWPATIENT.pdf");
		Thread.sleep(3000);
		// deleting it
		driver.findElement(By.xpath("(//i[@class='fa fa-trash'])[1]")).click();
		Thread.sleep(2000);
		// uploading pdf
		driver.findElement(By.xpath("(//input[@class='dynamic-upload-input'])[1]"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\MR. CUCUM IPFLOWPATIENT.pdf");
		Thread.sleep(3000);
		// clicking on the download button
		driver.findElement(By.xpath("(//button[@id='download-selected'])[1]")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkall = driver
					.findElement(By.xpath("(//input[@id='check_all'])[1]/following-sibling::label[1]"));
			checkall.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// clicking on the download button
		driver.findElement(By.xpath("(//button[@id='download-selected'])[1]")).click();
		Thread.sleep(5000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='ip_forms_modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(5000);
	}

	@Then("clicking on the billing and select the opreport")
	public void clicking_on_the_billing_and_select_the_opreport() throws Exception {
//		// hover the mouse on Reports
//		Actions action4 = new Actions(driver);
//		Thread.sleep(1000);
//		action4.moveToElement(driver.findElement(By.id("admin-billing-tab"))).click().build().perform();
//		Thread.sleep(1000);
//		action4.moveToElement(driver.findElement(By.cssSelector("a#op_report"))).click().build().perform();
//		Thread.sleep(3000);
	}

	@Then("search and download the reports for opreport")
	public void search_and_download_the_reports_for_opreport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_frst_nm_cont'])[1]")))
				.sendKeys("Cucum");
//		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// clicking on the op number
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"))).click();
//		Thread.sleep(5000);
		// download the invoice
		WebElement invoiceIcon = driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"));
		// Cast the driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute a JavaScript command to click the element
		js.executeScript("arguments[0].click();", invoiceIcon);
		System.out.println("Clicked the element using JavaScript.");
		Thread.sleep(2000);
		// clicking on the appointment id number
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//table[@id='example'])[2]/tbody[1]/tr[1]/td[2]/a[1]"))).click();
//		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[4]/div/div[1]/span/i")))
				.click();
//		Thread.sleep(3000);
		// clicking on the op number
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"))).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//table[@id='example'])[2]/tbody[1]/tr[1]/td[1]/a[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//table[@id='example'])[2]/tbody[1]/tr[1]/td[1]/a[1]")).click();
			Thread.sleep(2000);
		} else {
			driver.findElement(By.xpath("(//div[@id='schdlApmntsModal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
			Thread.sleep(3000);
		}
//		// Hold CTRL and click
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();
//		Thread.sleep(3000);

	}

	@And("clicking on the billing and select the deleteinvoicereport")
	public void clicking_on_the_billing_and_select_the_deleteinvoicereport() throws Exception {
		// hover the mouse on Reports
		Actions action4 = new Actions(driver);
		Thread.sleep(1000);
		action4.moveToElement(driver.findElement(By.id("admin-billing-tab"))).click().build().perform();
		Thread.sleep(1000);
		action4.moveToElement(driver.findElement(By.xpath("(//a[@id='archivedInvoice_report'])[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for deleteinvoicereport")
	public void search_and_download_the_reports_for_deleteinvoicereport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
		Thread.sleep(1000);
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]"))).click();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/span[contains(text(),'January')])[1]")))
//				.click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("clicking on the billing and select the gstreport1")
	public void clicking_on_the_billing_and_select_the_gstreport1() throws Exception {
		// hover the mouse on Reports
		Actions action4 = new Actions(driver);
		Thread.sleep(1000);
		action4.moveToElement(driver.findElement(By.id("admin-billing-tab"))).click().build().perform();
		Thread.sleep(1000);
		action4.moveToElement(driver.findElement(By.xpath("(//a[@id='gstInvoice_report'])[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for gstreport1")
	public void search_and_download_the_reports_for_gstreport1() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the site
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_OPD'])[1]"))).click();
//		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
		// removing the opd hospital
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]"))).click();
//		Thread.sleep(1000);
		// selecting ipd hospital
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_IPD'])[1]"))).click();
//		Thread.sleep(1000);
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='to-date'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(2000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the billing and select the discountreport")
	public void clicking_on_the_billing_and_select_the_discountreport() throws Exception {
		driver.findElement(By.id("admin-billing-tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#discount_report")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for discountreport")
	public void search_and_download_the_reports_for_discountreport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// fromdate
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#from-date"))).click();
//		Thread.sleep(1000);
		// selecting previous month
		for (int i = 0; i <= 1; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
//			Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// todate
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#to-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		// searching with name
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#q_patient_master_frst_nm_cont")))
				.sendKeys("Test");
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
//		Thread.sleep(3000);
		// mosue hover on patients name
		Actions name = new Actions(driver);
		name.moveToElement(driver.findElement(By.xpath("(//td[@class='patient_card'])[1]/div/a[1]"))).build().perform();
		Thread.sleep(2000);

		// clicking on the apt id
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//table[@id='example'])[1]/tbody/tr[1]/td[4]/a[1]")))
				.click();
		Thread.sleep(2000);
		// closing
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]//span/i[1]")))
				.click();
		Thread.sleep(2000);

		// mouse hover on amount
		Actions amt = new Actions(driver);
		amt.moveToElement(driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody/tr[1]/td[8]/div"))).build()
				.perform();
		Thread.sleep(2000);

	}

	@And("clicking on the billing and select the labpayout")
	public void clicking_on_the_billing_and_select_the_labpayout() throws Exception {
		driver.findElement(By.id("admin-billing-tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("lab_payout_report")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for labpayout")
	public void search_and_download_the_reports_for_labpayout() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// from-date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from_date'])[1]"))).click();
//		Thread.sleep(1000);
		// selecting previous month
		for (int i = 0; i <= 1; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
//					Thread.sleep(1000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//				Thread.sleep(1000);
		// todate
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#to_date"))).click();
//				Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);

		// selecting the lab and searching agian
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Lab Name'])[1]/following-sibling::span[1]"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='from_date'])[1]"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
		// Thread.sleep(1000);
		// todate
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#to_date"))).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[2]"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(3000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(3000);
		// reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(3000);
		// clicking on the apt id
		driver.findElement(
				By.xpath("(//table[@class='table nh_table striped responsive-table'])[1]/tbody[1]/tr[1]/td[3]/a[1]"))
				.click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(2000);

	}

	@Then("clicking on the billing and select the insurancereport")
	public void clicking_on_the_billing_and_select_the_insurancereport() {

	}

	@Then("search and download the reports for insurancereport")
	public void search_and_download_the_reports_for_insurancereport() {

	}

	@Then("clicking on the billing and select the refundreport")
	public void clicking_on_the_billing_and_select_the_refundreport() throws Exception {
		driver.findElement(By.id("admin-billing-tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("refund_report")).click();
		Thread.sleep(3000);
	}

	@Then("search and download the reports for refundreport")
	public void search_and_download_the_reports_for_refundreport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("q_patient_master_frst_nm_cont"))).sendKeys("Cucum");
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='1'])[1]"))).click();
//		Thread.sleep(1000);
		// to date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to-date"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]/button[1]"))).click();
		Thread.sleep(2000);
		// clicking on the search btn
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(5000);
		// clicking on the download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// Store parent window
		String parentWindow = driver.getWindowHandle();

		// Click on receipt link (opens in new tab)
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		// Wait for new tab to appear
		Thread.sleep(2000);
		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				// Switch to new tab
				driver.switchTo().window(window);
				// You can add actions inside new tab if needed
				Thread.sleep(1000);
				// Close new tab
				driver.close();
				// Switch back to parent
				driver.switchTo().window(parentWindow);
			}
		}
		Thread.sleep(1000);
		// clicking on the appointment id
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[4]/a[1]"))).click();
//		Thread.sleep(3000);
		// closing the popup
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[3]/div/div[1]/span/i")))
				.click();
//		Thread.sleep(3000);
//		// clicking on the op number
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]"))).click();
//		Thread.sleep(3000);
////				driver.findElement(By.xpath("//a[text()='Reset']")).click();
////				Thread.sleep(2000);

	}

	@Then("clicking on the billing and select the promocodetracking")
	public void clicking_on_the_billing_and_select_the_promocodetracking() throws Exception {
		driver.findElement(By.id("admin-billing-tab")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("promo_code_tracking-headers")).click();
		Thread.sleep(1000);
	}

	@Then("search and download the reports for promocodetracking")
	public void search_and_download_the_reports_for_promocodetracking() throws Exception {
		// clicking on the program
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]"))).click();
//		Thread.sleep(1000);
		// searching with the patient name
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='q_patient_master_frst_nm_cont'])[1]")))
				.sendKeys("Cucum");
		Thread.sleep(1000);
		// selecting the date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("q_applied_date_gteq"))).click();
		Thread.sleep(1000);
		// prev-month click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='month-prev'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='1'][1]"))).click();
		Thread.sleep(1000);
		// to date
		wait.until(ExpectedConditions.elementToBeClickable(By.id("q_applied_date_lteq"))).click();
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='is-today'])[1]/button"))).click();
		Thread.sleep(1000);
		// search
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Search'])[1]"))).click();
		Thread.sleep(1000);
		// download
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")))
				.click();
		Thread.sleep(2000);
		// clicking on the reset
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reset']"))).click();
		Thread.sleep(2000);
	}
}
