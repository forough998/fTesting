package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO{
	//private WebDriver driver;
	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password");
	private By submitButton = By.cssSelector("button");
	private By invalidBox = By.id("invalid");
	
	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
		/*this.driver = driver;
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");*/
	}
	
	public BasePagePO with(String username, String pwd) {
		type(usernameInput, username);
		type(passwordInput, pwd);
		click(submitButton);
		if(getUrl().equals("https://bonigarcia.dev/selenium-webdriver-java/login-form.html"))
			return this;
		return new LoginSuccessPO(driver);
		/*driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("mt-2")).click();*/
	}
	
	public boolean invalidBoxIsPresent() {
		return isIn(invalidBox);
		//return driver.findElement(By.id("invalid")).isDisplayed();	
	}
}
