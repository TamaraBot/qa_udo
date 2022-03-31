import static org.junit.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;


public class TestGrid4TestNG {
private WebDriver driver;
String baseURL, nodeURL;
protected ThreadLocal<RemoteWebDriver> threadDriver = null;


@BeforeClass
public void setUp() throws MalformedURLException {
baseURL="https://www.calculator.net/triangle-calculator.html";
nodeURL="http://localhost:4444";
}


//@AfterClass
//public void tearDown() {
//driver.close();
//}
@Test
public void test1() throws Throwable {
 System.out.println("Executing on FireFox");
 System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
 FirefoxOptions options = new FirefoxOptions();
   DesiredCapabilities capabilities=new DesiredCapabilities();
 capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
 //options.merge(capabilities);
 capabilities.setBrowserName("firefox");
  capabilities.setPlatform(Platform.WINDOWS);
  FirefoxDriver driver = new FirefoxDriver(options);
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
assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Acute Scalene Triangle");
driver.quit();
}

@Test
public void test2() throws Throwable {
 System.out.println("Executing on CHROME");
 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
 ChromeOptions options = new ChromeOptions();
   DesiredCapabilities capabilities=new DesiredCapabilities();
 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
// options.merge(capabilities);
 capabilities.setBrowserName("chrome");
  capabilities.setPlatform(Platform.WINDOWS);
  ChromeDriver driver = new ChromeDriver(options);
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
 assertEquals(driver.findElement(By.cssSelector("td > h3")).getText(), "Acute Scalene Triangle");
 driver.quit();
}
		}