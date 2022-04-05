package Calculator;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

class CalculatorSteps {

WebDriver driver; 
	
	@Given("^I use the calculater$")
	public void i_use_the_calculater () {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.calculator.net/math-calculator.html");
	}
	
	@When("^I enter \"1\" into the calculator$")
	public void i_enter_1_into_the_calculator () {
		driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(1)")).click(); //1
		 }
	
	
	@And ("^I add \"200\"$")
	public void i_add_200() {
		driver.findElement(By.cssSelector("div:nth-child(1) > .sciop:nth-child(4)")).click();//+
		 driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(2)")).click();//2
		 driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();//0
		 driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();//0
		 driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
		 	}
	
	@And ("^I subtract \"200\"$")
	public void i_subtract_200() {
		driver.findElement(By.cssSelector("div:nth-child(2) > .sciop:nth-child(4)")).click();//-
		 driver.findElement(By.cssSelector("div:nth-child(3) > .scinm:nth-child(2)")).click();//2
		 driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();//0
		 driver.findElement(By.cssSelector("div:nth-child(4) > .scinm:nth-child(1)")).click();//0
		 driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
		 }
	
	@And ("^I divide by \"555\"$")
	public void i_divide_by_555() {
		driver.findElement(By.cssSelector("div:nth-child(4) > .sciop:nth-child(4)")).click();///
		 driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();//5
		 driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();//5
		 driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();//5
		 driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
		 	}
	
	@And ("^I multiply by \"555\"$")
	public void i_multiply_by_555() {
		driver.findElement(By.cssSelector("div:nth-child(3) > .sciop:nth-child(4)")).click();//*
		 driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();//5
		 driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();//5
		 driver.findElement(By.cssSelector("div:nth-child(2) > .scinm:nth-child(2)")).click();//5
		 driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
		 }
	

	@Then("^the calculated result is \"1\"$")
		public void i_assert() {
		 driver.findElement(By.cssSelector(".scieq:nth-child(4)")).click();
		 assertEquals(driver.findElement(By.cssSelector(".scieq:nth-child(4)")).getText(), "1");
	driver.close();
		}
	}

