package TeleCaller;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leadregistration {
	WebDriver driver = null;

	@Given("navigating to the NH url {string}")
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

	@Then("enter email {string} password {string}")
	public void enter_email_password(String email, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(8000);
	}

	@And("signin button clicked")
	public void signin_button_clicked() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the profile for telecaller")
	public void selecting_the_profile_for_telecaller() throws Exception {
		driver.findElement(By.xpath("(//div[normalize-space(text())='TeleCaller'])[1]")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
	}

	@And("click on register lead icon for registration")
	public void click_on_register_lead_icon_for_registration() throws Exception {
		// clicking on the add new lead
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("enter the details for the lead registration")
	public void enter_the_details_for_the_lead_registration() throws Exception {
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
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("Telecallerlead");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("45");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='+91'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).sendKeys("9876556777");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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

	@And("click on the submit button to register lead")
	public void click_on_the_submit_button_to_register_lead() throws Exception {
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("edit the lead and save the changes")
	public void edit_the_lead_and_save_the_changes() throws Exception {

//		// Pass the lead name dynamically
//		String leadName = "Cucum Telecallerlead";
//
//		// XPath to find the engagement icon corresponding to the lead name
//		WebElement editlead = driver.findElement(By.xpath(
//				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Telecallerlead')]]//a[@data-tooltip='Edit Lead']"));
//
//		// Click on the icon
//		editlead.click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).sendKeys("9876556778");
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		try {
//			// submit
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[11]/input")).click();
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		try {
//			// submit
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[11]/input")).click();
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}

	@When("lead is registered it will be shown in the dashboard")
	public void lead_is_registered_it_will_be_shown_in_the_dashboard() {

	}

	@Then("click on the engagement button")
	public void click_on_the_engagement_button() throws Exception {
		// clicking on the today button
		driver.findElement(By.xpath("(//a[@id='lead-today-btn'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("add the engagement for the leadeng stage1 and save")
	public void add_the_engagement_for_the_leadeng_stage1_and_save() throws Exception {
		//editing the lead
		driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr[td[contains(normalize-space(.),'Cucum Telecallerlead')]]//img[@title='Follow Up']")).click();
		Thread.sleep(3000);
		// Pass the lead name dynamically
		String leadName = "Cucum Telecallerlead";

		// XPath to find the engagement icon corresponding to the lead name
		WebElement editlead = driver.findElement(By.xpath(
				"(//a[@title='Edit Lead'])[1]/i[1]"));
		// Click on the icon
		editlead.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("60");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("cucumleadone@gmail.com");
		Thread.sleep(1000);
		try {
			// submit
			driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//clicking on the i button
		driver.findElement(By.xpath("(//div[@class='upld_dropdown lead_card'])[1]/span/i[1]")).click();
		Thread.sleep(3000);
		
		
		//adding another mobile number
		driver.findElement(By.xpath("(//a[@title='Add New Contact'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='contact_detail[phn_nmbr_typ]'])[1]")).sendKeys("Telephone");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[11]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='+91'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='user_nmbr'])[1]")).sendKeys("9876556770");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		//clicking on the radio button to activate mobile number
		WebElement mobileNumberRadioButton = driver.findElement(By.xpath("(//input[@class='active-contact-radio'])[1]"));
		mobileNumberRadioButton.click();
		Thread.sleep(2000);
		WebElement mobileNumberRadioButton1 = driver.findElement(By.xpath("(//input[@class='active-contact-radio'])[2]"));
		mobileNumberRadioButton1.click();
		Thread.sleep(2000);
		WebElement mobileNumberRadioButton11 = driver.findElement(By.xpath("(//input[@class='active-contact-radio'])[1]"));
		mobileNumberRadioButton11.click();
		Thread.sleep(2000);
		//save remarks
		driver.findElement(By.xpath("(//span[@id='saveRemarksBtn'])[1]")).click();
		Thread.sleep(2000);
//		clickingon the dropdown
		driver.findElement(By.xpath("(//span[@title='Select Stage'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[normalize-space(text())='Right Party Contact'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@title='Select Status'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[normalize-space(text())='Ringing'])[1]")).click();
		Thread.sleep(1000);
		

		
		
		
	
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

	@And("add the engagement for the leadeng stage2 and save")
	public void add_the_engagement_for_the_leadeng_stage2_and_save() throws Exception {
		// clicking on the today button
		driver.findElement(By.xpath("(//a[@id='lead-today-btn'])[1]")).click();
		Thread.sleep(3000);
		WebElement engagementLink = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Telecallerlead')]]//a[@data-tooltip='Lead Engagement']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", engagementLink);
		Thread.sleep(2000);
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
		driver.findElement(By.xpath("(//label[contains(text(),'Stage2')])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Qualified')])[1]")).click();
		// description
		driver.findElement(By.xpath("(//textarea[@id='patient_engagement_detail_notes'])[1]"))
				.sendKeys("qualified stage");
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

	@And("add the engagement for the leadeng stage3 and save")
	public void add_the_engagement_for_the_leadeng_stage3_and_save() throws Exception {
		// clicking on the today button
		driver.findElement(By.xpath("(//a[@id='lead-today-btn'])[1]")).click();
		Thread.sleep(3000);
		WebElement engagementLink = driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Telecallerlead')]]//a[@data-tooltip='Lead Engagement']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", engagementLink);
		Thread.sleep(2000);
		// selecting the phone
		driver.findElement(By.xpath("//li[text()='Other'][1]")).click();
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
		// selecting the stage3
		driver.findElement(By.xpath("(//label[contains(text(),'Stage3')])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'Follow')])[1]")).click();
		// description
		driver.findElement(By.xpath("(//textarea[@id='patient_engagement_detail_notes'])[1]"))
				.sendKeys("follow up stage");
		Thread.sleep(1000);
		// following up date
		driver.findElement(By.xpath("(//label[text()='Followup Date'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(2000);
		// clicking on the next month
		driver.findElement(By.xpath("(//button[@class='month-next'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@data-day='1'])[2]")).click();
		Thread.sleep(2000);
		// following up time
		driver.findElement(By.xpath("(//label[text()='Followup Time'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(2000);
		// ok
		driver.findElement(By.xpath("(//button[@class='btn-flat timepicker-close waves-effect'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Preferred Method'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SMS'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.id("engmtSubmitBtn")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	@Then("search the lead using dashboard date filter and buttons")
	public void search_the_lead_using_dashboard_date_filter_and_buttons() throws Exception {
		// clicking on the date
		driver.findElement(By.xpath("(//span[@id='selected-date'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='month-next'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@data-day='1'])[1]/button[1]")).click();
		Thread.sleep(2000);
		// clicking on the today button
		driver.findElement(By.xpath("(//a[@id='lead-today-btn'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the W button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Week'])[1]")).click();
		Thread.sleep(2000);

		// clicking on the M button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Month'])[1]")).click();
		Thread.sleep(2000);

		// clicking on the < button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Previous'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the > button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Next'])[1]")).click();
		Thread.sleep(2000);

		// clicking on the today button
		driver.findElement(By.xpath("(//a[@id='apmt-today-btn'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the W button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Week'])[3]")).click();
		Thread.sleep(2000);

		// clicking on the M button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Month'])[3]")).click();
		Thread.sleep(2000);

		// clicking on the < button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Previous'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the > button in myleads
		driver.findElement(By.xpath("(//a[@data-tooltip='Next'])[2]")).click();
		Thread.sleep(2000);

	}
}
