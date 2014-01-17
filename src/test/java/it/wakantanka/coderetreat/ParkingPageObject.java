package it.wakantanka.coderetreat;

import org.openqa.selenium.WebDriver;

public class ParkingPageObject {

	static WebDriver driver;

	static void navigateToStartPage(String baseUrl) {
		driver.get(baseUrl + "/parkcalc/");
	}
}
