package tricentis.demoshop.page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import tricentis.demowebshop.elementos.Elementos;
import tricentis.demowebshop.metodos.Metodos;
import tricentis.demowebshop.utils.MassaTeste;

public class RegistrarPage {

	private WebDriver driver;
	Metodos metodo;
	Elementos el = new Elementos();

	public RegistrarPage(WebDriver driver) {

		this.driver = driver;
		this.metodo = new Metodos(driver);

	}

	@Test
	public void registroSucesso(String nome, String sobrenome, String email, String senha, String confirmarSenha)
			throws InterruptedException {
        metodo.clicar(el.getMenuRegister());
		metodo.escrever(el.getFirstName(), nome);
		metodo.escrever(el.getLastName(), sobrenome);
		metodo.escrever(el.getEmail(), email);
		metodo.escrever(el.getPassword(), senha);
		metodo.escrever(el.getConfirmPassword(), confirmarSenha);
		metodo.clicar(el.getBtnRegister());

		metodo.validarTexto(email);
	}

	public void validarRegistroSucesso(String email) {
		metodo.validarTexto(email);
	}

	public void validarMensagemRegistroSemSucesso(String msg) {
      metodo.validarTexto(msg);
	

	}

}
