import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Platform;

public class TestGrid4TestNG {
private WebDriver driver;
String baseURL, nodeURL;
protected ThreadLocal<RemoteWebDriver> threadDriver = null;

@BeforeClass
public void setUp() throws MalformedURLException {
baseURL="https://tusur.ru/";
nodeURL="http://localhost:4444";
}
@AfterClass
public void tearDown() {
driver.close();
}

@Test
public void test1() throws Throwable {
 System.out.println("Executing on FireFox");


 DesiredCapabilities capability=new
DesiredCapabilities();
 capability.setBrowserName("firefox");
 capability.setPlatform(Platform.WINDOWS);
 driver=new RemoteWebDriver(new URL(nodeURL),capability);
 driver.get(baseURL);
 String appTitle = driver.getTitle();
 Assert.assertEquals("Томский государственный университет систем управления и радиоэлектроники",appTitle);
 }
 @Test
 public void test2() throws Throwable {
  System.out.println("Executing on CHROME");
  DesiredCapabilities cap = new DesiredCapabilities();
  cap.setBrowserName("chrome");
  /* The execution happens on the Selenium Grid with the
 address mentioned earlier */


  cap.setPlatform(Platform.WINDOWS);
  driver = new RemoteWebDriver(new URL(nodeURL), cap);

  driver.get(baseURL);
  String appTitle = driver.getTitle();
  Assert.assertEquals("Томский государственный университет  систем управления и радиоэлектроники",appTitle);
  }
  }