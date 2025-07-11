package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import tricentis.demoshop.page.HomePage;

public class LoginTest {

	
	private WebDriver driver;
	private HomePage home;
	
	@Quando("preencher o email {string} e a senha {string} corretamente")
	public void preencher_o_email_e_a_senha_corretamente(String string, String string2) {
	    
	    
	}
	@Entao("valida o {string} logado")
	public void valida_o_logado(String string) {
	    
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
