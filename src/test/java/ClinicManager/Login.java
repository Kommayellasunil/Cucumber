package ClinicManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BrowserUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver = null;

	@Given("User navigates to the NanoHealth web application {string}")
	public void launchBrowser(String url) throws Exception {
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

	@When("User enters the email address {string}")
	public void user_enters_the_email_address(String string) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(string);
		Thread.sleep(1000);
	}

	@And("User enters the password {string}")
	public void user_enters_the_password(String Pswd) throws Exception {
		driver.findElement(By.id("user_password")).sendKeys(Pswd);
		Thread.sleep(15000);
	}

	@And("User clicks on the sign in button")
	public void user_click_on_the_sign_in_button() throws Exception {
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("user select the role")
	public void user_select_the_role() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);

		// selecting Role clicking on clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("user successfully loggined with the role")
	public void user_successfully_loggined_with_the_role() throws Exception {
		System.out.println("user successfully logged in");
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(10000);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys("Chakra@0001");
		Thread.sleep(15000);
		driver.findElement(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]")).click();
		Thread.sleep(5000);
		// login with otp
		driver.findElement(By.xpath("(//a[@id='login-otp-link'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='login-mobile'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='login-mobile'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='getOptBtn'])[1]")).click();
		Thread.sleep(15000);
		// verify
		driver.findElement(By.xpath("(//input[@id='verifyOptBtn'])[1]")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);

		// selecting Role clicking on clinic manager
		driver.findElement(By.xpath("(//div[normalize-space(text())='Clinic_Manager - NanoHealth_OPD'])[1]")).click();
		Thread.sleep(3000);
	}

}
