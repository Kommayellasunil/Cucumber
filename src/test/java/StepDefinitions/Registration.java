package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration {
	WebDriver driver = null;

	@Given("User navigates to the NanoHealth web")
	public void user_navigates_to_the_nano_health_web_application() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver121.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@When("User enters the email id {string}")
	public void user_enters_the_email_address(String Emailaddress) {
		driver.findElement(By.cssSelector("input.string.optional")).sendKeys(Emailaddress);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("User enters the pswd {string}")
	public void user_enters_the_password(String Pswd) {
		driver.findElement(By.cssSelector("input.password.optional")).sendKeys(Pswd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("User click on the sign in")
	public void user_click_on_the_sign_in() throws Exception {
		driver.findElement(By.cssSelector("input.sign-btn.full-btn")).click();
		Thread.sleep(3000);
	}

	@Then("user will selects_the role")
	public void user_will_select_the_role() throws Exception {
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[1]/div/div/div/div[2]")).click();
		Thread.sleep(2000);
	}

	@Then("user successfully logged in with the role")
	public void user_successfully_logged_in_with_the_role() {
		System.out.println("user successfully logged in");
	}

	@When("user click on the add patient icon")
	public void user_click_on_the_add_patient_icon() throws Exception {
		// clicking on the add patient icon
		driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")).click();
		Thread.sleep(2000);
	}

	@Then("registration form will opens")
	public void registration_form_will_opens() {
		System.out.println("user is in the registration form");
	}

	@When("user select the title automatically it will select the gender radio button")
	public void user_select_the_title_automatically_it_will_select_the_gender_radio_button() throws Exception {
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
	}

	@And("user enters the first name {string}")
	public void user_enters_the_first_name(String firstname) {
		driver.findElement(By.id("first_name")).sendKeys(firstname);
	}

	@And("user enters the last name {string}")
	public void user_enters_the_last_name(String lastname) {
		driver.findElement(By.id("lst_name")).sendKeys(lastname);
	}

	@And("user enters the age year {string}")
	public void user_enters_the_age_year(String age) {
		driver.findElement(By.id("age")).sendKeys(age);
	}

	@Then("user enters the phone number {string} and gmail {string}")
	public void user_enters_the_phone_number_and_gmail(String phonenumber, String gmail) {
		// driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("nmbr")).sendKeys(phonenumber);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("email")).sendKeys(gmail);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("user enters the address line one {string} , address line two {string} , Landmark {string}")
	public void user_enters_the_address_line_address_line_landmark(String addressline, String addressline2,
			String landmark) {
		driver.findElement(By.id("address-line1")).sendKeys(addressline);
		driver.findElement(By.name("adrs_line2")).sendKeys(addressline2);
		driver.findElement(By.id("landmark")).sendKeys(landmark);
	}

	@And("user selects the state and country")
	public void user_selects_the_state_and_country() throws Exception {
//		// state
//		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("//li[text()=' Andhra Pradesh']")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// country
//		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath(" //li[text()='India']")).click();
//		Thread.sleep(1000);
		// landmark
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_0_result_value"))
				.sendKeys("test landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// district
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_1_result_value"))
				.sendKeys("test disctrict");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// pincode
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_2_result_value"))
				.sendKeys("500012");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("user clicks on the add button for referred by")
	public void user_clicks_on_the_add_button_for_referred_by() throws Exception {
//		// referred by
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div/ul/li/div/div[10]/div[2]/a")).click();
//		Thread.sleep(1000);
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_4_result_value"))
				.sendKeys("123456789012");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("user selects the self option")
	public void user_selects_the_self_option() throws Exception {
//		driver.findElement(By.xpath("/html/body/main/div/form/div[3]/div/div[2]/div/div[1]/div/div[3]/div/div"))
//				.click();
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//div[@class='modal-footer'])[1]/span")).click();
//		Thread.sleep(1000);
		WebElement abac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		abac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("user clicks on the Choose files for profile picture and uploads picture")
	public void user_clicks_on_the_choose_files_for_profile_picture() throws Exception {
//		// profile picture
//		driver.findElement(By.id("patient_master_patient_questnr_value_details_attributes_4_result_value"))
//				.sendKeys("C:\\Users\\Lenovo\\Pictures\\Screenshots\\Screenshot (1).png");
//		Thread.sleep(1000);
		WebElement abc = driver.findElement(By.xpath("(//label[text()='No'])[2]"));
		abc.click();
		Thread.sleep(2000);

	}

	@And("user clicks on the Choose files for Id card and uploads picture")
	public void user_select_any_photo_and_upload() throws Exception {
//		// id
//		driver.findElement(By.id("patient_master_patient_questnr_value_details_attributes_5_result_value"))
//				.sendKeys("C:\\Users\\Lenovo\\Pictures\\Screenshots\\Screenshot (2).png");
//		Thread.sleep(1000);

		// height
		driver.findElement(By.cssSelector("input#Cms_")).sendKeys("180");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// weight
		driver.findElement(By.xpath("//input[@placeholder='kgs']")).sendKeys("70");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() throws Exception {
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(3000);
	}

	@Then("it will take the user to the patientprofile page")
	public void it_will_take_the_user_to_the_patientprofile_page() {
		System.out.println("User is in the patient profile page");
	}
}
