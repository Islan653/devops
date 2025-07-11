package tricentis.demowebshop.Testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import tricentis.demoshop.page.HomePage;
import tricentis.demowebshop.drivers.Drivers;
import tricentis.demowebshop.utils.ScreenShotUtil;

public class LoginTest {

	private WebDriver driver;
	HomePage home;

	@BeforeEach
	public void setup() {
	driver = Drivers.criarDriver();
    home = new HomePage(driver);
	

	}

	@AfterEach
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
    
	}

	@Test
	public void loginSucesso() {
		home.login("islansantosbz@gmail.com", "123456");
		ScreenShotUtil.screenshot(driver, "login", "login sucesso");
	}

	@Test
	public void senhaInvalida() {
		home.login("testetestes@gmail.com", "", "The credentials provided are incorrect");
		ScreenShotUtil.screenshot(driver, "login", "login senha invalida");
	}

	@Test
	public void emailForaDoPadrao() {
		home.login("testetestesgmail.com", "", "Please enter a valid email address.");
	}

	@Test
	public void emailInexistente() {
		home.login("10testetestes@gmail.com", "", "Login was unsuccessful. Please correct the errors and try again.");
	}

	@Test
	public void senhaBranco() {
		home.login("testetestes@gmail.com", "", "The credentials provided are incorrect");
	}

	@Test
	public void emailBranco() {
		home.login("", "B?0P248kEf-P", "No customer account found");
	}
}