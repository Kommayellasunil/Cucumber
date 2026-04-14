package RecommendationManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BrowserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecommendationManager {
	WebDriver driver = null;

	@Given("navigate to the NH_Web_portal {string}")
//	public void navigate_to_the_nh_web_portal(String string) {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
	public void launchBrowser(String url) throws Exception {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
//		ChromeOptions co = new ChromeOptions();
//		co.addArgouments("--remote-allow-origins=*");
//		driver = new ChromeDriver(co);
//		co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://customer.nanohealthplan.com/users/sign_in");
//		driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);

	}

	@When("login page opened")
	public void login_page_opened() {
	}

	@Then("enters the email {string} password {string}")
	public void enters_the_email_password(String email, String password) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_login")))).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(10000);
	}

	@Then("click on signin button to login")
	public void click_on_signin_button_to_login() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@Then("selects the cdp name and role name")
	public void selects_the_cdp_name_and_role_name() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on RecommendationManager Role
		driver.findElement(By.xpath("(//div[normalize-space(text())='RecommendationManager'])[1]")).click();
		Thread.sleep(5000);
	}

	@When("role is selected it will opens the recommendation manager dashboard")
	public void role_is_selected_it_will_opens_the_recommendation_manager_dashboard() {

	}

	@Then("user opens the recommendation creation screen")
	public void user_opens_the_recommendation_creation_screen() {

	}

	@When("user creates a new recommendation")
	public void user_creates_a_new_recommendation() throws Exception {
		Actions create = new Actions(driver);
		create.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Create Recommendation'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Create Recommendation'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).click()
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Form'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Cucum");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[text()='Cucum formbuilder'])[1]")).click();
//		Thread.sleep(1000);
	}

	@When("user adds a source form Cucum formbuilder")
	public void user_adds_a_source_form_cucum_formbuilder() throws Exception {
		Actions create = new Actions(driver);
		WebElement formname = driver.findElement(By.xpath(
				"//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum formbuilder')]"));
		formname.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@title='Delete'])[1]/img[1]")).click();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).click()
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Form'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Cucum");
		Thread.sleep(1000);
		WebElement formname1 = driver.findElement(By.xpath(
				"//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum formbuilder')]"));
		formname1.click();
		Thread.sleep(1000);
	}

	@When("user deletes the added source node")
	public void user_deletes_the_added_source_node() throws Exception {

	}

	@When("user adds the source form again Cucum formbuilder")
	public void user_adds_the_source_form_again_cucum_formbuilder() throws Exception {

	}

	@When("user adds target node Doctor Consultation")
	public void user_adds_target_node_doctor_consultation() throws Exception {
		Actions create = new Actions(driver);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add target node'])[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add target node'])[1]/div[1]"))).click()
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Doctor Consultation'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Doctor Consultation'])[2]")).click();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//div[@data-id='engine'])[1]/div[1]"))).doubleClick().build()
				.perform();
		Thread.sleep(2000);
	}

	@When("user configures logic with height condition")
	public void user_configures_logic_with_height_condition() throws Exception {
		Actions create = new Actions(driver);
		driver.findElement(By.xpath("(//input[@name='logic_code'])[1]")).sendKeys("8790");
		Thread.sleep(1000);
		WebElement inputfield = driver
				.findElement(By.xpath("(//label[@id='question-select-label'])[1]/following-sibling::div[1]/input[1]"));
		inputfield.sendKeys("Height");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//li[text()='Height'])[1]")).click();
		Thread.sleep(10000);
		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@id='questnDropdown'])[1]")));
		dropdown.selectByVisibleText("Height");
		Thread.sleep(1000);
		Select dropdown1 = new Select(driver.findElement(By.xpath("(//select[@id='typeDropdown'])[1]")));
		dropdown1.selectByVisibleText("To Integer");
		Thread.sleep(1000);
		Select dropdown11 = new Select(driver.findElement(By.xpath("(//select[@id='operatorDropdown'])[1]")));
		dropdown11.selectByVisibleText("Greater than or equal to");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='textInput'])[1]")).sendKeys("170");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		Thread.sleep(2000);
		create.moveToElement(driver.findElement(By.xpath("(//div[@data-id='engine'])[1]/div[1]"))).doubleClick().build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='edit'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='logic_code'])[1]")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='logic_code'])[1]")).sendKeys("8791");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='checkIcon'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Back'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='head'])[1]")).sendKeys("Cucum recommendation");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("Cucum");
		Thread.sleep(3000);
		// clicking on the recommendation name
		driver.findElement(By.xpath("(//div[text()='Cucum recommendation'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@title='Add target node'])[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Doctor Consultation'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Doctor Consultation'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='True'])[2]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("Cucum");
		Thread.sleep(3000);
	}

	@When("user updates logic code")
	public void user_updates_logic_code() {

	}

	@When("user submits recommendation with name Cucum recommendation")
	public void user_submits_recommendation_with_name_cucum_recommendation() {

	}

	@When("user edits recommendation to add true condition target")
	public void user_edits_recommendation_to_add_true_condition_target() throws Exception {
		// clicking on the recommendation name
		driver.findElement(By.xpath("(//div[text()='Cucum recommendation'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@title='Add target node'])[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Diagnostic Lab'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='FBS'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='True'])[2]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='frst_nm'])[1]")).sendKeys("Cucum");
		Thread.sleep(3000);

	}

	@Then("user tests recommendation with height value")
	public void user_tests_recommendation_with_height_value() throws Exception {
		// clicking on the recommendation name
		driver.findElement(By.xpath("(//div[text()='Cucum recommendation'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Test'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("312");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='HTFT'])[1]")).sendKeys("170");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Send request'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@name='HTFT'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='HTFT'])[1]")).sendKeys("160");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Send request'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Close'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Back'])[1]")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
