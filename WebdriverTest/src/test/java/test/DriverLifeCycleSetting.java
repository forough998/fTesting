package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {
	protected WebDriver driver;
	
	//private String baseUrl;
	
	/*@ParameterizedTest
	@EnumSource(Browser.class)
	public void TestA(Browser browser)throws InterruptedException {
		driver = DriverFactory.getNewDriverInstance(browser);
		long waitTimeSeconds = Duration.ofSeconds(5).getSeconds();
        driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
	}*/
	
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	public void beforeEach() {
		driver = new ChromeDriver();
		long waitTimeSeconds = Duration.ofSeconds(5).getSeconds();
        driver.manage().timeouts().implicitlyWait(waitTimeSeconds, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterEach
	public void afterEach() {
		if(driver != null) {
			driver.quit();
		}
	}
}
