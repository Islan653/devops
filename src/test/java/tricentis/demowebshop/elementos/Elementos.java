package tricentis.demowebshop.elementos;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class Elementos {

	public By menuRegister = By.xpath("//a[@href='/register']");
	public By firstName = By.id("FirstName");
	public By lastName = By.id("LastName");
	public By email = By.id("Email");
	public By password = By.id("Password");
	public By confirmPassword = By.id("ConfirmPassword");
	public By btnRegister = By.id("register-button");
	public By login = By.xpath("//a[@href='/login']");
	public By email2 = By.id("Email");
	public By password2 = By.id("Password");
	
	
	/*
	 * Elementos para login
	 */
	
	public By menuLogin = By.xpath("//a[@href='/login']");
	public By btnLogin = By.xpath("//input[@class='button-1 login-button']");
	
	/*
	 * Elementos carrinho
	 */
    public By menuCarrinho = By.id("topcartlink");
    public By checkBoxRemoverProduto = By.name("removefromcart");
    public By atualizarCarrinho = By.name("updatecart");
    public By carrinhoVazio = By.xpath("//div[normalize-space(text())='Your Shopping Cart is empty!']");


	public By getMenuCarrinho() {
		return menuCarrinho;
	}



	public By getCheckBoxRemoverProduto() {
		return checkBoxRemoverProduto;
	}



	public By getAtualizarCarrinho() {
		return atualizarCarrinho;
	}



	public By getCarrinhoVazio() {
		return carrinhoVazio;
	}



	public By getEmail2() {
		return email2;
	}



	public By getPassword2() {
		return password2;
	}



	public By getBtnLogin() {
		return btnLogin;
	}

	//Elementos logout 
	private By menulogout = By.xpath("//a[@href='/logout']");
	


	
	

	public By getMenulogout() {
		return menulogout;
	}



	public By getMenuRegister() {
		return menuRegister;
	}

	public By getFirstName() {
		return firstName;
	}

	public By getLastName() {
		return lastName;
	}

	public By getEmail() {
		return email;
	}

	public By getPassword() {
		return password;
	}

	public By getConfirmPassword() {
		return confirmPassword;
	}

	public By getBtnRegister() {
		return btnRegister;
	}


	public By getLogin() {
		return login;
	}

	public By getMenuLogin() {
		return menuLogin;
	}

}

