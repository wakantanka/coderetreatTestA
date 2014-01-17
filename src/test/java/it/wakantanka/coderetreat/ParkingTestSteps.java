package it.wakantanka.coderetreat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class ParkingTestSteps  extends Steps{
	
	private  WebDriver driver= new HtmlUnitDriver();
	ParkcalcPageObject pageObject ;
	
	public ParkingTestSteps() {
		driver.get("http://www.klosebrothers.de/parkcalc");
		 pageObject = PageFactory.initElements(this.driver, ParkcalcPageObject.class);
	}
	
	@Given("Car is Parking in $type")
	public void selectParkingType(String type) {
		pageObject.selectParkingTypeByVisibleText(type);
	}
	
	@When("Arrived $date at $hours Daytime $daytime")
	public void setArrival(String date, String hours, String daytime) {
		pageObject.typeStartDate(date);
		pageObject.typeStartTime(hours);
		
	}
	@Then("Calculatet Fee is $amount €")
	public void calculate(String amount) {
//		pageObject.submit;
		
	}
	

}
