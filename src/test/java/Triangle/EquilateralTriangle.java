package Triangle;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;


public class EquilateralTriangle {
	WebDriver driver; 
	
	@Given("^I open Triangle Calculate$")
	public void i_lanch () {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.calculator.net/triangle-calculator.html");
	}
	
	@When("^I clear all param$")
	public void i_clear () {
		driver.findElement(By.name("va")).clear();
		driver.findElement(By.name("vb")).clear();
		driver.findElement(By.name("vc")).clear();
		driver.findElement(By.name("vx")).clear();
		driver.findElement(By.name("vy")).clear();
		driver.findElement(By.name("vz")).clear();
	}
	
	
	@And ("^I set value \"5\" for \"A\"$")
	public void i_set_a() {
		driver.findElement(By.name("vx")).sendKeys("5");
	}
	@And ("^I set value \"5\" for \"B\"$")
	public void i_set_b() {
		driver.findElement(By.name("vy")).sendKeys("5");
	}
	@And ("^I set value \"5\" for \"C\"$")
	public void i_set_c() {
		driver.findElement(By.name("vz")).sendKeys("5");
	}
	@And ("^I click button \"Calculate\"$")
	public void i_click_button() {
		driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
	}
	@Then("^The calculated result is \"Equilateral Triangle\"$")
		public void i_assert() {
	assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Equilateral Triangle");
	driver.close();
		}
	}

