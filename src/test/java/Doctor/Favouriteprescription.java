package Doctor;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Favouriteprescription {
	WebDriver driver = null;

	@Given("navigate to nanohealth login url {string}")
	// public void navigating_to_url_of_nh_application(String url) throws
	// InterruptedException {
	//
	// }
	public void launchBrowser(String url) {
//		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
//		 + "\\driver\\chromedriver139.exe");
//		 ChromeOptions co = new ChromeOptions();
//		 co.addArguments("--remote-allow-origins=*");
//		 driver = new ChromeDriver(co);
//		 co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		 driver.get("https://customer.nanohealthplan.com/users/sign_in");
//		 driver.manage().window().maximize();

		// @Given("I launch the browser with URL {string}")
		// public void launchBrowser(String url) {
		driver = BrowserUtility.getInstance().launchBrowser(url);
	}

	@Then("enter email11 {string} password11 {string}")
	public void enter_email11_password11(String email11, String password11) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(email11);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password11);
		Thread.sleep(5000);
	}

	@And("click on the signin button to login into doctor role")
	public void click_on_the_signin_button_to_login_into_doctor_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
	}

	@When("signin button is clicked then doctor dashboard opens")
	public void signin_button_is_clicked_then_doctor_dashboard_opens() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdpadmin Role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='Doctor'])[1]")))
				.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000); // kept for Robot physical actions
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // kept for Robot physical actions
	}

	@Then("click on the myaccount and click on configurations button")
	public void click_on_the_myaccount_and_click_on_configurations_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='profile-img'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-cog'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("from configurations click on the prescription")
	public void from_configurations_click_on_the_prescription() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Configurations'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='doctorFavPrescBtn'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("delete the existing favourite prescription and click on the plus button to add new one")
	public void delete_the_existing_favourite_prescription_and_click_on_the_plus_button_to_add_new_one()
			throws Exception {
		// delete the specific favourite prescription "Cucum Fav Ps"
		if (driver.findElement(By
				.xpath("//div[normalize-space(text())='Cucum Fav Ps']/ancestor::tr//a[contains(@class,'delete')]/i[1]"))
				.isDisplayed()) {
			driver.findElement(By.xpath(
					"//div[normalize-space(text())='Cucum Fav Ps']/ancestor::tr//a[contains(@class,'delete')]/i[1]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
			Thread.sleep(8000);
			System.out.println("Cucum Fav Ps is deleted");
		} else {
			System.out.println("No favourite prescription found with name: Cucum Fav Ps");
			// // clicking on the plus button to addnew
			// Actions action = new Actions(driver);
			// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add
			// New'])[1]/i[1]"))).build()
			// .perform();
			// Thread.sleep(2000);
		}
	}

	@And("create the favourite prescription and save it")
	public void create_the_favourite_prescription_and_save_it() throws Exception {
		// clicking on the plus button to addnew
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='fav_precription_creation'])[1]")))
				.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='Favourite_Prescription_Name'])[1]")))
				.sendKeys("Cucum Fav Ps");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Consultation Type'])[1]/following-sibling::input[1]")))
				.sendKeys("Testing type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Accompained by family" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Testing" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the reset button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='Favourite_Prescription_Name'])[1]")))
				.sendKeys("Cucum Fav Ps");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Consultation Type'])[1]/following-sibling::input[1]")))
				.sendKeys("Testing type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Accompained by family" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Accompanied By'])[1]/following-sibling::div/textarea[1]")))
				.sendKeys("Fav prescription");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space(text())='Patient History'])[1]/following-sibling::div[1]/textarea[1]")))
				.sendKeys("Test patient history" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space(text())='Patient History'])[1]/following-sibling::div[1]/textarea[1]")))
				.sendKeys("testing history" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("(//div[normalize-space(text())='Patient History'])[1]/following-sibling::div[1]/textarea[1]")))
				.sendKeys("test history");
		Thread.sleep(1000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_comorbidity"))).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")).sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Week'])[1]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='comorbidity_notes'])[1]")))
				.sendKeys("Testing comorbidity notes");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_comorbidity")))
				.sendKeys("Hypertension");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'HYPERTENSION')])[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")))
				.sendKeys("2");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_comorbidity"))).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_close_cmrb'])[3]"))).click();
		Thread.sleep(2000);
		// Cast the driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms"))).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[1]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms")))
				.sendKeys("Symptom");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'SYMPTOM')])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[2]"))).sendKeys("1");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_symptoms"))).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// remove one
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='input_close'])[3]"))).click();
		Thread.sleep(1000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_diagnosis"))).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[1]"))).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Since Birth'])[1]"))).click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_diag'])[1]/img[1]")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='diagnosis_notes'])[1]")))
				.sendKeys("Testing diagnostics notes selected since birth");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_diag'])[1]/img[1]")))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// remove one
		driver.findElement(By.xpath("(//div[@class='input_close_diag'])[2]/i[1]")).click();
		Thread.sleep(2000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)");
		Thread.sleep(1000);
		// temp
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space(text())='Temp (F)']/following-sibling::input")))
				.sendKeys("101");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Pulse (bpm)']/following-sibling::input"))).sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Respiratory Rate (/min)']/following-sibling::input")))
				.sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space(text())='SpO2(%)']/following-sibling::input")))
				.sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#bp-s"))).sendKeys("120");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#bp-d"))).sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// height
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Height (Cms)']/following-sibling::input[1]"))).sendKeys("165");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// weight
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[normalize-space(text())='Weight (Kgs)']/following-sibling::input[1]")))
				.sendKeys("68" + Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		JavascriptExecutor jse11111 = (JavascriptExecutor) driver;
		jse11111.executeScript("window.scrollBy(0, 300)");
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Medicine'])[1]/preceding-sibling::input[1]"))).click();
		Thread.sleep(3000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='medication_notes'])[1]")))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='medication_notes'])[1]")))
				.sendKeys("Test brand notes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='Less'])[1]"))).click();
		Thread.sleep(2000);
		// JavascriptExecutor jse11111 = (JavascriptExecutor) driver;
		jse11111.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Medicine'])[2]/preceding-sibling::input[1]")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 1; i++) {
			// Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt.click();
		Thread.sleep(1000);
		WebElement video = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
		video.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#recommended_lab_input_helper")))
				.click();
		Thread.sleep(3000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys("Ecg");
		// Thread.sleep(2000);
		WebElement brandInput = driver.findElement(By.cssSelector("input#recommended_lab_input_helper"));

		String text = "Ecg";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}

		Thread.sleep(2000);

		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Request'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='requestLabs'])[1]"))).click();
		Thread.sleep(2000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]"))).click();
		Thread.sleep(3000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]")))
				.sendKeys("Program");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'program')])[2]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]")))
				.sendKeys("Automation testprocedure");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// removing second one
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close package_chip_close'])[2]"))).click();
		Thread.sleep(2000);
		// comments
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("Testing comments" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("test comments" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("tdy test ps comments");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h6[text()='Noticeable']")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		// clicking on the abdomen image
		driver.findElement(
				By.xpath("(//div[normalize-space(text())='Abdomen'])[1]/following-sibling::div[1]/div[1]/img[1]"))
				.click();
		Thread.sleep(2000);
		// Step 1: Click on the 3rd button (Arrow Maker)
		WebElement arrowTool = driver.findElement(By.xpath("(//div[@title='Arrow marker'])[1]"));
		arrowTool.click();
		// Step 2: Wait for the tool to activate
		Thread.sleep(1000);
		// Step 3: Identify the image/canvas area
		WebElement canvas11 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 4: Perform drag-and-drop (draw arrow)
		// Actions action1 = new Actions(driver);
		// Example: draw arrow from point (200,150) to (350,150)
		Actions action1 = new Actions(driver);
		action1.moveToElement(canvas11, 0, 0).clickAndHold().moveByOffset(150, 0).release().perform();
		Thread.sleep(3000);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1: Click on the 4th button (Text Tool)
		WebElement textTool = driver.findElement(By.xpath("(//div[@title='Text marker'])[1]"));
		textTool.click();
		// Step 2: Wait for tool activation
		Thread.sleep(2000);
		// Step 3: Identify the canvas or drawing area
		WebElement canvas111 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Step 4: Drag on the canvas to create text area
		Actions action11 = new Actions(driver);
		action11.moveToElement(canvas111, -150, 20) // Starting point
				.clickAndHold().moveByOffset(200, 200) // Define the text box size
				.release().perform();
		// Step 5: Wait for textbox to appear
		Thread.sleep(1000);
		// Step 6: Locate the text box (assuming “Your text here” placeholder appears)
		WebElement textBox = driver.findElement(By.xpath("//div[contains(text(),'Your text here')][1]"));
		textBox.click();
		// Step 8: Clear default text and enter your desired text
		textBox.sendKeys(Keys.CONTROL + "a"); // Select all (optional)
		textBox.sendKeys("Test notes in Fav Ps"); // Replace with your text
		Thread.sleep(1000);
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Click on the 4th button - Highlighter
		WebElement highlighterTool = driver.findElement(By.xpath("(//div[@title='Highlight marker'])[1]"));
		highlighterTool.click();
		Thread.sleep(1000);
		// Locate the canvas element where you draw
		WebElement canvas45 = driver
				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
		// Create Actions instance for drag and drop (highlighting)
		Actions act = new Actions(driver);
		// Move to start point and drag for highlighting
		act.moveToElement(canvas45, -50, 0) // starting point (x=150, y=150)
				.clickAndHold().moveByOffset(150, 100) // drag horizontally (change offset if needed)
				.release().perform();
		Thread.sleep(2000); // Wait to view highlight effect
		////////////////////////////////////////////////////////////////////////////////////////////////////////
//		// Click on the last button - Callout Marker
//		WebElement calloutTool = driver.findElement(By.xpath("(//div[@title='Callout marker'])[1]"));
//		calloutTool.click();
//		Thread.sleep(1000);
//		// Locate the canvas where you draw the callout
//		WebElement canvas43 = driver
//				.findElement(By.xpath("(//div[@class='__markerjs2_ __markerjs2__0_'])[1]/div[1]/div[2]/div[1]/img[1]"));
//		// Perform drag and drop to create the callout shape
//		Actions actions = new Actions(driver);
//		actions.moveToElement(canvas43, 0, -150) // starting point
//				.clickAndHold().moveByOffset(150, 100) // shape size
//				.release().perform();
//		Thread.sleep(2000);
//		// wait for the callout box to appear
//		// Click on the callout box to focus for typing
//		WebElement calloutBox = driver.findElement(By.xpath("(//div[contains(text(),'Your text here')])[1]"));
//		calloutBox.click();
//		Thread.sleep(1000);
//		WebElement editableDiv = driver.findElement(By.xpath("(//div[@contenteditable='true'])[1]"));
//		editableDiv.click();
//		Thread.sleep(500);
//		// Get existing text
//		String text1 = editableDiv.getText();
//		// Delete character by character
//		for (int i = 0; i < text1.length(); i++) {
//			editableDiv.sendKeys(Keys.BACK_SPACE);
//			Thread.sleep(200); // slows deletion to match UI
//		}
//		Thread.sleep(2000);
//		editableDiv.sendKeys("My updated text goes here in Fav PS" + Keys.SPACE);
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_A);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_A);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_B);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_B);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_C);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_C);
//		Thread.sleep(1000);
		// Optional pause
		Thread.sleep(2000);
		// clicking on the save and close button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@title='Save and close'])[1]"))).click();
		Thread.sleep(2000);
		// save
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]"))))
				.click();
		Thread.sleep(10000);
	}

	@Then("edit the favourite prescription and save it again")
	public void edit_the_favourite_prescription_and_save_it_again() throws Exception {
		// edit fav ps
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-pencil'])[1]"))).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt1 = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt1.click();
		Thread.sleep(1000);
		WebElement video1 = driver.findElement(By.xpath("(//label[text()='Video'])[1]"));
		video1.click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(5000);
		driver.close();
	}

	@Given("nav to nanohealth login url {string}")
	// public void navigating_to_url_of_nh_application(String url) throws
	// InterruptedException {
	//
	// }
	public void launchBrowser1(String url) {
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

	@Then("enter the email12 {string} password12 {string}")
	public void enter_the_email12_password12(String email12, String password12) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login"))).sendKeys(email12);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys(password12);
		Thread.sleep(5000);
	}

	@And("click on the signin button to login into the doctor role")
	public void click_on_the_signin_button_to_login_into_the_doctor_role() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		// selecting cdpadmin Role
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")))
				.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000); // kept for Robot physical actions
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
	}

	@When("sign in button was clicked and then doctor dashboard opens")
	public void sign_in_button_was_clicked_and_then_doctor_dashboard_opens() throws Exception {
		// System.out.println("Doctor Dashboard is opened successfully.");
	}

	@Then("click on the myaccount button and click on configurations button")
	public void click_on_the_myaccount_button_and_click_on_configurations_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='profile-img'])[1]/img[1]")))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-cog'])[1]"))).click();
		Thread.sleep(2000);
	}

	@And("from configurations section click on the dischargesummary button")
	public void from_configurations_section_click_on_the_dischargesummary_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Configurations'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='doctorDesSum'])[1]"))).click();
		Thread.sleep(2000);
	}

	@Then("delete the existing favourite dischargesummary and click on the plus button to add new one")
	public void delete_the_existing_favourite_dischargesummary_and_click_on_the_plus_button_to_add_new_one()
			throws Exception {
		// delete the specific favourite prescription "Cucum Fav Ds"
		if (driver.findElement(By
				.xpath("//div[normalize-space(text())='Cucum Fav Ds']/ancestor::tr//a[contains(@class,'delete')]/i[1]"))
				.isDisplayed()) {
			driver.findElement(By.xpath(
					"//div[normalize-space(text())='Cucum Fav Ds']/ancestor::tr//a[contains(@class,'delete')]/i[1]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
			Thread.sleep(8000);
			System.out.println("Cucum Fav Ds is deleted");
		} else {
			System.out.println("No favourite prescription found with name: Cucum Fav Ds");
		}

	}

	@And("create the favourite dischargesummary and save it")
	public void create_the_favourite_dischargesummary_and_save_it() throws Exception {
		// clicking on the plus button to addnew
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='fav_precription_creation'])[1]")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='Favourite_Prescription_Name'])[1]")))
				.sendKeys("Cucum Fav Ds");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")))
				.sendKeys("Testing type" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")))
				.sendKeys("Accompained by family" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")))
				.sendKeys("Testing");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the reset button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Reset'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='Favourite_Prescription_Name'])[1]")))
				.sendKeys("Cucum Fav Ds");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")))
				.sendKeys("Test diagnosis at time of admission1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")))
				.sendKeys("Test diagnosis at time of admission2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[1]")))
				.sendKeys("Test diagnosis at time of admission3");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='doctor_visit_comorbidity'])[1]")))
				.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")))
				.sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Week'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[comorbidity][][note]'])[1]")))
				.sendKeys("Test diagnosis notes");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")))
				.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='doctor_visit_comorbidity'])[1]")))
				.click();
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Months'])[1]"))).click();
		Thread.sleep(2000);
		WebElement brandInput = driver.findElement(By.xpath("(//input[@id='doctor_visit_comorbidity'])[1]"));
		String text = "Cancer";
		for (char c : text.toCharArray()) {
			brandInput.sendKeys(Character.toString(c));
			Thread.sleep(300);
			// small pause between keystrokes
		}
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// remove
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='input_close_cmrb'])[3]/i[1]")))
				.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]")))
				.sendKeys("Test patient history1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]")))
				.sendKeys("patient history" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]")))
				.sendKeys("patienthistory" + Keys.UP + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[2]")))
				.sendKeys("pat hstry");
		Thread.sleep(1000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")))
				.click();
		Thread.sleep(2000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")))
				.sendKeys("1" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Month'])[1]"))).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")).click();
		// Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Days'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")))
				.click();
		Thread.sleep(2000);
		WebElement brandInput1 = driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]"));
		String text1 = "Symptom";
		for (char c : text1.toCharArray()) {
			brandInput1.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[3]")))
				.sendKeys("2" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Years'])[1]"))).click();
		Thread.sleep(2000);
		// remove
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='input_close_cmpl'])[3]/i[1]")))
				.click();
		Thread.sleep(2000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		// Robot escape = new Robot();
		// escape.keyPress(KeyEvent.VK_ESCAPE);
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[3]")))
				.sendKeys("Test hospital course" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[3]")))
				.sendKeys("Test hospital course2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[3]")))
				.sendKeys("Test hospital course3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[4]")))
				.sendKeys("Dolo 650" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[4]")))
				.sendKeys("Test medicine Syrup" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[4]")))
				.sendKeys("Test Cap Cipla");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[5]")))
				.sendKeys("Test condition1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[5]")))
				.sendKeys("Test condition2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[5]")))
				.sendKeys("Test condition3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Height(Cms)'])[1]/following-sibling::input[1]")))
				.sendKeys("170");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Weight(Kgs)'])[1]/following-sibling::input[1]")))
				.sendKeys("69" + Keys.TAB);
		Thread.sleep(1000);
		// bmi
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(text(),'BMI')])[1]/following-sibling::input[1]")))
				.click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Pulse(bpm)'])[1]/following-sibling::input[1]")))
				.sendKeys("98");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='SpO2(%)'])[1]/following-sibling::input[1]"))).sendKeys("76");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Waist(cms)'])[1]/following-sibling::input[1]")))
				.sendKeys("32");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[normalize-space(text())='Hip(cms)'])[1]/following-sibling::input[1]")))
				.sendKeys("31" + Keys.TAB);
		Thread.sleep(1000);

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		Thread.sleep(2000);

		// advice on discharge
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[6]")))
				.sendKeys("test advice on ds1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[6]")))
				.sendKeys("test advice on ds2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='bulletPointTextNew'])[6]")))
				.sendKeys("test advice on ds3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Medicine'])[1]/preceding-sibling::input[1]"))).click();
		Thread.sleep(3000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[1]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[1]")))
				.sendKeys("2");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[text()='Type'])[1]/following-sibling::span[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='More'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='medication_notes'])[1]")))
				.clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='medication_notes'])[1]")))
				.sendKeys("Test medicine notes");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@data-tooltip='Less'])[1]"))).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='recommended_lab_input_helper'])[1]")))
				.click();
		Thread.sleep(2000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement brandInput11 = driver.findElement(By.xpath("(//input[@id='recommended_lab_input_helper'])[1]"));
		String text11 = "Profile";
		for (char c : text11.toCharArray()) {
			brandInput11.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='recommended_lab_input_helper'])[1]")))
				.click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// remove
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]"))).click();
		Thread.sleep(2000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement brandInput3 = driver.findElement(By.xpath("(//input[@id='packages_input'])[1]"));
		String text3 = "Testing";
		for (char c : text3.toCharArray()) {
			brandInput3.sendKeys(Character.toString(c));
			Thread.sleep(300); // small pause between keystrokes
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='packages_input'])[1]"))).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// remove
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//i[@class='material-icons close package_chip_close'])[3]"))).click();
		Thread.sleep(2000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='doctor_visit_nxt_vst_dur'])[1]")))
				.sendKeys("5" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(1000);
		// Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='In-person'])[1]")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("Test comments1" + Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("Test comments2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='textareaField'])[1]")))
				.sendKeys("Test comments3" + Keys.ENTER);
		Thread.sleep(3000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(3000);
	}

	@Then("edit the favourite dischargesummary and save it again")
	public void edit_the_favourite_dischargesummary_and_save_it_again() throws Exception {
		// edit fav ps
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//table[@id='example']//tr[td[contains(normalize-space(.),'Cucum Fav Ps')]]//a[@data-tooltip='Edit '][1]/i[1]")))
				.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#doctor_visit_nxt_vst_dur")))
				.sendKeys("10" + Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[text()='Weeks'])[1]"))).click();
		Thread.sleep(2000);
		WebElement teleconslt1 = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconslt1.click();
		Thread.sleep(1000);
		// save
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='saveBtn'])[1]"))).click();
		Thread.sleep(3000);
		driver.close();
	}

}
