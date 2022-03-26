import static org.junit.jupiter.api.Assertions.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@TestInstance (Lifecycle.PER_CLASS)
public class TestGrid4JUnit {
private WebDriver driver;

 String baseURL, nodeURL;
 protected ThreadLocal<RemoteWebDriver> threadDriver = null;

 @BeforeAll
 public void setUp_1() throws MalformedURLException {
 baseURL="https://www.calculator.net/triangle-calculator.html";

 nodeURL="http://localhost:4444";

 }
 @AfterEach
 public void tearDown_1() {
 driver.close();
 }

 @Test
 public void test1() throws Throwable {
 System.out.println("Executing on FireFox");

 DesiredCapabilities capability=new DesiredCapabilities();

 capability.setBrowserName("firefox");
 capability.setPlatform(Platform.WIN10);

 driver=new RemoteWebDriver(new URL(nodeURL),capability);
//Ёкземпл€р RemoteWebDriver создаетс€ и выполн€етс€ в Grid 4 (адрес
//концентратора Ч http://localhost:4444 ) .
 driver.get(baseURL);
 String appTitle = driver.getTitle();
assertEquals("Triangle Calculator",appTitle);
 }

 @Test
 public void test2() throws Throwable {
 System.out.println("Executing on CHROME");
 DesiredCapabilities cap = new DesiredCapabilities();
 cap.setBrowserName("chrome");
 cap.setPlatform(Platform.WIN10);

 driver = new RemoteWebDriver(new URL(nodeURL), cap);
 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get(baseURL);
 String appTitle = driver.getTitle();
 assertEquals("Triangle Calculator",appTitle);
 }
}
