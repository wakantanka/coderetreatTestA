package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelIDEexport {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://klosebrothers.de/parkcalc/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelIDEexport() throws Exception {
    driver.get(baseUrl + "/parkcalc/");
    new Select(driver.findElement(By.id("ParkPlatz"))).selectByVisibleText("Short-Term Parking");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.id("StartDatum")).clear();
    driver.findElement(By.id("StartDatum")).sendKeys("12/12/2012");
    driver.findElement(By.id("AbfahrDatum")).clear();
    driver.findElement(By.id("AbfahrDatum")).sendKeys("12/12/2012");
    driver.findElement(By.id("AbfahrZeit")).clear();
    driver.findElement(By.id("AbfahrZeit")).sendKeys("13:00");
    driver.findElement(By.name("Submit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
