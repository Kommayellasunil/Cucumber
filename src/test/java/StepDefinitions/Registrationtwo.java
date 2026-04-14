package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registrationtwo {
	WebDriver driver = null;

	@Given("navigate to nanohealth web portal")
	public void navigate_to_nanohealth_web_portal() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver120.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		// WebDriver driver = new ChromeDriver(co);
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
	}

	@Then("^login with the (.*) and (.*)$")
	public void login_with_the_email_and_password(String email, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(email);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(1000);
	}

	@And("clicking on sign_in_button")
	public void clicking_on_sign_in_button() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);
	}

	@Then("selecting the profile")
	public void selecting_the_profile() throws Exception {
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[1]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
	}

	@And("clicking on the add_patient_icon for new registration")
	public void clicking_on_the_add_patienti_icon_for_new_registration() throws Exception {
		// clicking on the add patient
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img")).click();
		Thread.sleep(2000);
	}

	@Then("selecting the title_of_patient")
	public void selecting_the_title_of_patient() throws Exception {
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

	@When("user enters the following details")
	public void user_enters_the_following_details(DataTable dataTable) {

		List<List<String>> regData = dataTable.asLists(String.class);
//		System.out.println(regData.get(0).get(1));
//		System.out.println(regData.get(1).get(1));
//		System.out.println(regData.get(2).get(1));
//		System.out.println(regData.get(3));
//		System.out.println(regData.get(4));
//		System.out.println(regData.get(5));
//		System.out.println(regData.get(6));
//		System.out.println(regData.get(7));
//		System.out.println(regData.get(8));
//		System.out.println(regData.get(9));
//		System.out.println(regData.get(10));
//		System.out.println(regData.get(11));

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
		driver.findElement(By.id("email")).sendKeys(regData.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// addressline
		driver.findElement(By.id("address-line1")).sendKeys(regData.get(5).get(1));
		driver.findElement(By.id("autocomplete-input")).sendKeys(regData.get(6).get(1));
		driver.findElement(By.id("landmark")).sendKeys(regData.get(7).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_0_result_value"))
				.sendKeys(regData.get(8).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// distict
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_1_result_value"))
				.sendKeys(regData.get(9).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// pincode
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_2_result_value"))
				.sendKeys(regData.get(10).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// aadharcardnumber
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_4_result_value"))
				.sendKeys(regData.get(11).get(1));
	}

	@Then("selecting radio_buttons")
	public void selecting_radio_buttons() {
		// abhacard
		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// ayushmanbharatcard
		WebElement abc = driver.findElement(By.xpath("(//label[text()='No'])[2]"));
		abc.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// height
		driver.findElement(By.cssSelector("input#Cms_")).sendKeys("180");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// weight
		driver.findElement(By.xpath("//input[@placeholder='kgs']")).sendKeys("70");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("clicking on the submit_to_register")
	public void clicking_on_the_submit_to_register() throws Exception {
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(2000);
	}

	@Then("it will redirect to the patient_profile")
	public void it_will_redirect_to_the_patient_profile() {
		System.out.println("Patient successfully registered. You are in the patient profile");
	}

}
