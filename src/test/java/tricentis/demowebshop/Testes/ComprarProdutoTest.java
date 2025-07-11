package tricentis.demowebshop.Testes;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import tricentis.demoshop.page.HomePage;
import tricentis.demowebshop.drivers.Drivers;


public class ComprarProdutoTest {

	private WebDriver driver;
	HomePage home;
	

	@BeforeEach
	public void setup() {
		driver = Drivers.criarDriver();
		home = new HomePage(driver);

		
		
	}

	@Test
	public void ComprarProduto() {
		home.login("islansantosbz@gmail.com", "123456");
		home.headerMenu("Computer");
		home.addCarrinho("Desk", "1");
		home.validarCarrinho();
	}
    
	@Test
   public void comprarProdutoDeslogado() {
		home.limparCarrinho();
	   home.headerMenu("Computer");
	   home.addCarrinho("Desk", "1");
	   
   }
	

}
