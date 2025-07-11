package tricentis.demowebshop.Testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import tricentis.demoshop.page.HomePage;

import tricentis.demowebshop.drivers.Drivers;
import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;

public class LogoutTest {

	private WebDriver driver;
	HomePage home;
	Metodos metodo;
	Elementos el = new Elementos();

	@BeforeEach
	public void setup() {
		driver = Drivers.criarDriver();
		home = new HomePage(driver);
		metodo.clicar(el.getMenuLogin());
		String email = "islansantosbz@gmail.com";
		metodo.escrever(el.getEmail(), email);
		metodo.escrever(el.getPassword(), "123456");
		metodo.clicar(el.getBtnLogin());
		metodo.validarTexto(email);
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

	@Test
	public void logoutSucesso() {
		metodo.esperarElementoClicavel(el.getMenulogout(), 10);
		metodo.clicar(el.getMenulogout());
		metodo.validarUrl("https://demowebshop.tricentis.com/");

	}

}
