import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@TestInstance (Lifecycle.PER_CLASS)
public class TestGrid4JUnit {
private WebDriver driver;

 String baseURL, nodeURL;

 
 @BeforeAll
 public void setUp() throws MalformedURLException {
	 baseURL="https://www.calculator.net/triangle-calculator.html";
	 nodeURL="http://localhost:4444";
 }
 
@AfterEach
 public void tearDown() {
 driver.close(); }

 @Test
 public void test1() throws Throwable {
 System.out.println("Executing on FireFox");
 DesiredCapabilities capability=new DesiredCapabilities();
 capability.setBrowserName("firefox");
 capability.setPlatform(Platform.WIN10);
 driver=new RemoteWebDriver(new URL(nodeURL),capability);
 driver.get(baseURL);
 driver.manage().window().setSize(new Dimension(888, 835));
 driver.findElement(By.cssSelector(".clearbtn")).click();
 driver.findElement(By.name("vx")).click();
 driver.findElement(By.name("vx")).sendKeys("6");
 driver.findElement(By.name("vy")).click();
 driver.findElement(By.name("vy")).sendKeys("7");
 driver.findElement(By.name("vz")).click();
 driver.findElement(By.name("vz")).sendKeys("4");
 driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
 Assert.assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(),"Acute Scalene Triangle");
driver.close();
}

 @Test
 public void test2() throws Throwable {
 System.out.println("Executing on CHROME");
 DesiredCapabilities capability = new DesiredCapabilities();
 capability.setBrowserName("chrome");
 capability.setPlatform(Platform.WIN10);
 driver = new RemoteWebDriver(new URL(nodeURL), capability);
 driver.get(baseURL);
 driver.manage().window().setSize(new Dimension(888, 835));
 driver.findElement(By.cssSelector(".clearbtn")).click();
 driver.findElement(By.name("vx")).click();
 driver.findElement(By.name("vx")).sendKeys("6");
 driver.findElement(By.name("vy")).click();
 driver.findElement(By.name("vy")).sendKeys("7");
 driver.findElement(By.name("vz")).click();
 driver.findElement(By.name("vz")).sendKeys("4");
 driver.findElement(By.cssSelector("tr:nth-child(5) input")).click();
 Assert.assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(),"Acute Scalene Triangle");
 driver.close();
}
}

