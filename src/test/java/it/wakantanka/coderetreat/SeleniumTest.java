package it.wakantanka.coderetreat;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTest {

	WebDriver driver =    new HtmlUnitDriver();;

	@Before
	public void before() {
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
//		this.driver = new ChromeDriver();
//		this.driver = new ChromeDriver();
	}

	@Test
	public void testParkingCalculation() throws InterruptedException {
 		this.driver.get("http://www.klosebrothers.de/parkcalc");

		ParkcalcPageObject pageObject = PageFactory.initElements(this.driver, ParkcalcPageObject.class);

  	pageObject.selectParkingTypeByVisibleText("Short-Term Parking");

		pageObject.typeStartDate("01/01/2014");
		pageObject.typeStartTime("00:00");
		pageObject.clickStartTimeAmPm(AMPM.PM);
		pageObject.typeEndDate("01/01/2014");
		pageObject.typeEndTime("12:00");

		Thread.sleep(5000);
	}

	@After
	public void after() {
		driver.close();
	}
}
