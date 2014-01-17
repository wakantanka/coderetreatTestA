package it.wakantanka.coderetreat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShortParkingLotTest {
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	@FindBy(how = How.ID, using = "StartDatum")
	private WebElement startTime;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new HtmlUnitDriver();
		baseUrl = "http://klosebrothers.de/parkcalc/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ParkingPageObject.driver = driver;
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShortpackingCal() {
		ParkingPageObject.navigateToStartPage(baseUrl);
		String typex = "Short-Term Parking";
		
		selectParkingLotType(typex);
		setParkingDatesTodayOneHour();
		driver.findElement(By.name("Submit")).click();
	}

	private void setParkingDatesTodayOneHour() {
		//driver.findElement(By.id("StartDatum"))
		PageFactory.initElements(driver, this);
		startTime.clear();
		startTime.sendKeys("12/12/2012");
		driver.findElement(By.id("StartZeit")).clear();
		driver.findElement(By.id("StartZeit")).sendKeys("12:00");
		driver.findElement(By.id("AbfahrDatum")).clear();
		driver.findElement(By.id("AbfahrDatum")).sendKeys("12/12/2012");
		driver.findElement(By.id("AbfahrZeit")).clear();
		driver.findElement(By.id("AbfahrZeit")).sendKeys("13:00");

	}

	private void selectParkingLotType(String type) {
		new Select(driver.findElement(By.id("ParkPlatz")))
				.selectByVisibleText(type);
	}

}
