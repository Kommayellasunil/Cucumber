package TeleCaller;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Insurancelead {
	WebDriver driver = null;

	@Given("naviagating to the web_NH_Portal {string}")
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

	@When("login page was_opened")
	public void login_page_was_opened() throws Exception {
	}

	@Then("entering the email_id {string} password {string}")
	public void entering_the_email_id_password(String email_id, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(email_id);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(10000);
	}

	@And("click on_the_sign_in button")
	public void click_on_the_sign_in_button() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(5000);
	}

	@When("select the_cdp and profile popup opens")
	public void select_the_cdp_and_profile_popup_opens() throws Exception {
	}

	@Then("select the_cdp and role_as telecaller")
	public void select_the_cdp_and_role_as_telecaller() throws Exception {
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
		// selecting Role clicking on clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='TeleCaller'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("telecaller dashboard opened")
	public void telecaller_dashboard_opened() {
	}

	@Then("click on the add new lead to register a new lead")
	public void click_on_the_add_new_lead_to_register_a_new_lead() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='New Lead'])[1]/img[1]")).click();
		Thread.sleep(3000);
	}

	@And("fillup the details for the lead registration")
	public void fillup_the_details_for_the_lead_registration() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Mr.'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("Insurancelead");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("45");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='nmbr'])[1]")).sendKeys("8009001002" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'3')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'3')])[1]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Father'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Name'])[1]")).sendKeys("Test Father");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='M'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Age'])[1]")).sendKeys("70" + Keys.TAB);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a.btn-floating.green.left.add_fields")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i[1]")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("Test city");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("Test district");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("500035");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("Test line1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='autocomplete-input'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='autocomplete-input'])[1]")).sendKeys("Test line2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("Test landmark");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Add'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='icon'])[3]/following-sibling::h6[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Hyderabad'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit to register the lead")
	public void click_on_the_submit_to_register_the_lead() throws Exception {
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(), 'Cucum Insurancelead')]]//img[@title='FollowUP']"))
				.click();
		Thread.sleep(3000);
	}

	@When("new lead is registered lead will be shown on the dashboard")
	public void new_lead_is_registered_lead_will_be_shown_on_the_dashboard() throws Exception {
	}

	@Then("edit and submit the edit lead form")
	public void edit_and_submit_the_edit_lead_form() throws Exception {
		driver.findElement(By.xpath("(//a[@title='Edit Lead'])/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("55");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("Cucumleadinsur@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the i button to show the updated details
		driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.), 'Mr. Cucum Insurancelead')]]//a[@data-tooltip='Lead Engagement' or contains(@class, 'lead-engagement-icon')][1]/img[1]"))
				.click();
		Thread.sleep(3000);
	}

	@And("click on the Insurance required for edit button")
	public void click_on_the_insurance_required_for_edit_button() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Insurer'])[1]/i[1]")).click();
		Thread.sleep(3000);

	}

	@Then("fillup the form and submit the form")
	public void fillup_the_form_and_submit_the_form() throws Exception {
		driver.findElement(By.xpath(
				"//label[contains(normalize-space(),'Pre Existing illness')]/following::span[contains(@class,'select2-selection')][1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'3')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='btn-floating green left add_fields'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//label[contains(normalize-space(),'Relation')]/following::span[contains(@class,'select2-selection')][4]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[contains(text(),'Daughter')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Name'])[2]")).sendKeys("Test Daughter");
		Thread.sleep(1000);
		WebElement f = driver.findElement(By.xpath("(//label[text()='F'])[2]"));
		f.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Age'])[2]")).sendKeys("16" + Keys.TAB);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.), 'Mr. Cucum Insurancelead')]]//a[@data-tooltip='Lead Engagement' or contains(@class, 'lead-engagement-icon')][1]/img[1]"))
				.click();
		Thread.sleep(3000);
	}

	@When("form is submitted, data will be populated in the Insurance required for section in popup")
	public void form_is_submitted_data_will_be_populated_in_the_insurance_required_for_section_in_popup()
			throws Exception {

	}

	@Then("click on the Insurer Selected edit button")
	public void click_on_the_insurer_selected_edit_button() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Insurer'])[2]/i[1]")).click();
		Thread.sleep(3000);
	}

	@And("fillup the form with insurer and submit the form")
	public void fillup_the_form_with_insurer_and_submit_the_form() throws Exception {
	}

	@When("form is submitted, data will be populated in the insurer for section in popup")
	public void form_is_submitted_data_will_be_populated_in_the_insurer_for_section_in_popup() throws Exception {

	}

	@Then("click on the stage and select the stage and status also and enter the remarks")
	public void click_on_the_stage_and_select_the_stage_and_status_also_and_enter_the_remarks() throws Exception {

	}

	@And("click on the submit button present at the bottom of the page")
	public void click_on_the_submit_button_present_at_the_bottom_of_the_page() throws Exception {

	}

	@Then("click on the view remarks button to show the remarks")
	public void click_on_the_view_remarks_button_to_show_the_remarks() throws Exception {

	}

}
