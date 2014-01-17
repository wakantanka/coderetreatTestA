package it.wakantanka.coderetreat;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ParkcalcPageObject {

	@FindBy(how = How.ID, using = "ParkPlatz")
	private WebElement parkingType;

	@FindBy(how = How.ID, using = "StartDatum")
	private WebElement startDate;

	@FindBy(how = How.ID, using = "StartZeit")
	private WebElement startTime;

	@FindBy(how = How.XPATH, using = "//input[@name='StartZeitampm'][1]")
	private WebElement startTimeAm;

	@FindBy(how = How.XPATH, using = "//input[@name='StartZeitampm'][2]")
	private WebElement startTimePm;

	@FindBy(how = How.ID, using = "AbfahrDatum")
	private WebElement endDate;

	@FindBy(how = How.ID, using = "AbfahrZeit")
	private WebElement endTime;

	public void selectParkingTypeByVisibleText(String visibleText) {
		Select selectBox = new Select(this.parkingType);
		selectBox.selectByVisibleText(visibleText);
	}

	public void typeStartDate(String date) {
		this.startDate.clear();
		this.startDate.sendKeys(date);
	}

	public void typeStartTime(String time) {
		this.startTime.clear();
		this.startTime.sendKeys(time);
	}

	public void clickStartTimeAmPm(AMPM ampm) {
		if (ampm.equals(AMPM.AM)) {
			this.startTimeAm.click();
		}

		if (ampm.equals(AMPM.PM)) {
			this.startTimePm.click();
		}
	}

	public void typeEndDate(String date) {
		this.endDate.clear();
		this.endDate.sendKeys(date);
	}

	public void typeEndTime(String time) {
		this.endTime.clear();
		this.endTime.sendKeys(time);
	}
	
}
