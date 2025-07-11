package tricentis.demowebshop.metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.opentest4j.AssertionFailedError;

public class Metodos {

	private WebDriver driver;
	
	public Metodos(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clicar(By locator) {

		try {
			esperarElementoClicavel(locator, 10);
			driver.findElement(locator).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}

	}
	
	

	public void clicar(String elemento, String texto) {
		try {
			driver.findElement(By.xpath("//*[" + elemento + "]//*[contains(text(),'" + texto + "')]")).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado com o texto " + texto);
		}

	}

	public void escrever(By locator, String texto) {

		try {
			driver.findElement(locator).sendKeys(texto);
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}
	}

	public void validarTexto(By locator, String textoDesejado) {
		try {
			String textoCapturado = driver.findElement(locator).getText();
			assertEquals(textoDesejado, textoCapturado);
		} catch (Exception e) {
			throw new AssertionFailedError("Texto em branco ou errado! " + locator);
		}
	}

	public void validarTexto(String textoDesejado) {
		try {
			String textoCapturado = driver.findElement(By.xpath("//*[text()='" + textoDesejado + "']")).getText();
			assertEquals(textoDesejado, textoCapturado);
		} catch (Exception e) {
			throw new AssertionFailedError("Texto em branco ou errado! " + textoDesejado);
		}
	}

	public void esperarElementoClicavel(By locator, int segundos) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}
	}

	public void esperarElementoVisivel(By locator, int segundos) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado " + locator);
		}

	}

	public void validarUrl(String urlEsperada) {
		try {
			assertEquals(urlEsperada, driver.getCurrentUrl());
		} catch (Exception e) {
			throw new NotFoundException(urlEsperada + " não encontrada.");
		}

	}

	public void alert() {

		driver.switchTo().alert();

	}

	public boolean existText(By elemento, String textoEsperado) {

		List<WebElement> elementos = driver.findElements(elemento);

		if (elementos.isEmpty()) {
			return false;
		}

		String textoNaTela = elementos.get(0).getText().trim();
		return textoNaTela.equalsIgnoreCase(textoEsperado);

	}
}
