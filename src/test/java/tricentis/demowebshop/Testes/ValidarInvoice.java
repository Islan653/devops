package tricentis.demowebshop.Testes;

import org.junit.jupiter.api.Test;

import tricentis.demowebshop.utils.PdfValidationUtil;

public class ValidarInvoice {

	@Test
	public void testInvoicePdf() {

		String caminhoPdf= System.getProperty("user.home") + "/Downloads/order_2013329.pdf";
		String caminhoAbsoluto = "C:\\Users\\dell\\Downloads\\order_2013329.pdf";
		String orderId = "2013329";
		String valorTotal = "1637.00";
		String tax = "0.00";

		PdfValidationUtil.validarPedido(caminhoAbsoluto, orderId, valorTotal, tax);

	}

}
