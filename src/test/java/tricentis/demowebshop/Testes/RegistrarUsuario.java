package tricentis.demowebshop.Testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import tricentis.demoshop.page.RegistrarPage;
import tricentis.demowebshop.drivers.Drivers;
import tricentis.demowebshop.utils.MassaTeste;

public class RegistrarUsuario {

	private WebDriver driver;
	RegistrarPage registrar;
	MassaTeste massa = new MassaTeste();

	@BeforeEach
	public void setup() {
		driver = Drivers.criarDriver();
		registrar = new RegistrarPage(driver);

	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit(); 
		}
	}

	@Test
	public void registroUsuario() throws InterruptedException {
		String email = massa.retornarDados("emailGmail");
		registrar.registroSucesso("Islan", "Santos", email, "123456", "123456");
		registrar.validarRegistroSucesso(email);
	}

	 @Test
	public void registrarEmailRegistrado() throws InterruptedException {
		registrar.registroSucesso("Islan", "Santos", "teste@teste.com.br", "123456", "123456");
		registrar.validarMensagemRegistroSemSucesso("The specified email already exists");

	}

	@Test
	public void registrarConfirmacaoDeSenhaDiferente()throws InterruptedException {
		registrar.registroSucesso("Islan", "Santos", "teste@teste.com.br", "123456", "1234567");
		registrar.validarMensagemRegistroSemSucesso("The password and confirmation password do not match.");
	}
}
