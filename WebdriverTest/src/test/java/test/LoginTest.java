package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.LoginFormPO;
import POs.LoginSuccessPO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends DriverLifeCycleSetting{
	//private WebDriver driver;
	private LoginFormPO login;
	private LoginSuccessPO loginSuccess;
	
	@Test
	public void testLoginOK() {
		login = new LoginFormPO(driver);
		//login.with("user", "user");
		//loginSuccess = new LoginSuccessPO(driver);
		loginSuccess = (LoginSuccessPO)login.with("user", "user");
		assertTrue(loginSuccess.successBoxIsPresent());
	}
	
	@Test
	public void testLoginNoOK() {
		login = new LoginFormPO(driver);
		login.with("user", "error");
		assertTrue(login.invalidBoxIsPresent());
	}
}
