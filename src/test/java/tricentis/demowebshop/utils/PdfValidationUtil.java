package tricentis.demowebshop.utils;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfValidationUtil {

public static void validarPedido(String filePath, String orderId, String valorTotalEsperado, String taxEsperado) {
		
		File pdfFile = new File(filePath);
		
		if(!pdfFile.exists()) {
			throw new IllegalArgumentException("Arquivo não encontrado " + filePath);
		}
		
		try (PDDocument document = PDDocument.load(pdfFile)){
			// extraindo o texto do pdf 
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String conteudo = pdfStripper.getText(document);
			System.out.println(conteudo);
			
			if(!conteudo.contains("Order# " + orderId)) {
				throw new IllegalAccessException("Número do pedido não encontrado ou incorreto: " + orderId );
			}
			
		}catch (Exception e) {
			throw new RuntimeException("Erro ao ler pdf");
		}
		
	}
		
		
	


}