package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSuccessPO extends BasePagePO{
	//private WebDriver driver;
	
	private By successBox = By.id("success");
	
	public LoginSuccessPO(WebDriver driver) {
		super(driver);
		//this.driver = driver;
	}
	public boolean successBoxIsPresent() {
		return isIn(successBox);
		//return driver.findElement(By.id("success")).isDisplayed();	
	}
}
