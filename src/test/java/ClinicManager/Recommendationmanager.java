package ClinicManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Recommendationmanager {
	WebDriver driver = null;
	WebDriverWait wait;

	@Test(priority = 0)
	public void one() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions create = new Actions(driver);
		create.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Create Recommendation'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Create Recommendation'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Update'])[1]"))).click();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).click()
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Form'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Search'])[1]"))).sendKeys("Cucum");
		Thread.sleep(1000);
		WebElement formname = driver.findElement(By.xpath(
				"//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cucum')]"));
		formname.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Delete'])[1]/span[1]"))).click();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add source node'])[1]/div[1]"))).click()
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Form'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Search'])[1]"))).sendKeys("Cucum");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Cucum formbuilder'])[1]"))).click();
		Thread.sleep(2000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add target node'])[1]/div[1]"))).build()
				.perform();
		Thread.sleep(1000);
		create.moveToElement(driver.findElement(By.xpath("(//span[@title='Add target node'])[1]/div[1]"))).click()
				.build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Doctor Consultation'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Doctor Consultation'])[2]"))).click();
		Thread.sleep(2000);
		create.moveToElement(driver.findElement(By.xpath("(//div[@data-id='engine'])[1]/div[1]"))).doubleClick().build()
				.perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='logic_code'])[1]"))).sendKeys("8790");
		Thread.sleep(1000);

//		WebElement inputfield = driver
//				.findElement(By.xpath("(//label[@id='question-select-label'])[1]/following-sibling::div[1]/input[1]"));
//		inputfield.sendKeys("Height");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//li[text()='Height'])[1]")).click();
//		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Search & Select'])[1]/following-sibling::div[1]/input[1]"))
				).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Search & Select'])[1]/following-sibling::div[1]/input[1]"))
				).sendKeys("Height" + Keys.ENTER);
		Thread.sleep(3000);

		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@id='questnDropdown'])[1]")));
		dropdown.selectByVisibleText("Height");
		Thread.sleep(1000);
		Select dropdown1 = new Select(driver.findElement(By.xpath("(//select[@id='typeDropdown'])[1]")));
		dropdown1.selectByVisibleText("To Integer");
		Thread.sleep(1000);
		Select dropdown11 = new Select(driver.findElement(By.xpath("(//select[@id='operatorDropdown'])[1]")));
		dropdown11.selectByVisibleText("Greater than or equal to");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='textInput'])[1]"))).sendKeys("170");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[2]"))).click();
		Thread.sleep(2000);
		create.moveToElement(driver.findElement(By.xpath("(//div[@data-id='engine'])[1]/div[1]"))).doubleClick().build()
				.perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='edit'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='logic_code'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='logic_code'])[1]"))).sendKeys("8791");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='checkIcon'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[2]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Back'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='head'])[1]"))).sendKeys("Cucum recommendation");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='frst_nm'])[1]"))).sendKeys("Cucum");
		Thread.sleep(2000);
		// clicking on the recommendation name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Cucum recommendation'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Edit'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@title='Add target node'])[1]/div[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Diagnostic Lab'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='FBS'])[1]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='True'])[2]"))).click();
		Thread.sleep(2000);
		// submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Submit'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='frst_nm'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='frst_nm'])[1]"))).sendKeys("Cucum");
		Thread.sleep(3000);
		// clicking on the recommendation name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Cucum recommendation'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Test'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='age'])[1]"))).sendKeys("312");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='HTFT'])[1]"))).sendKeys("170");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Send request'])[1]"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='HTFT'])[1]"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='HTFT'])[1]"))).sendKeys("160");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Send request'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Close'])[1]"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Back'])[1]"))).click();
		Thread.sleep(2000);
		driver.close();

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver146.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
//		co.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_login")))).sendKeys("sunilk@nh.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys("Chakra@1");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sign-btn full-btn loginBtn btn_disable'])[1]"))).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='nanohealthplan'])[1]"))).click();
		Thread.sleep(3000);
		// selecting Role clicking on RecommendationManager Role
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[normalize-space(text())='RecommendationManager'])[1]"))).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

}
