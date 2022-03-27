package ar.com.educacionit.practica13;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import ar.com.educacionit.practicas.dao.Articulos;


public class FileParserMain2 {

	public static void main(String[] args) throws Exception {

		String path = "./src/main/java/ar/com/educacionit/practica13/articulosxls.xlsx";
		
		papaparse<Collection<Articulos>> parser = new XLSXFileParser(path);
		
		Collection<Articulos> articulos = new ArrayList<>();
		try {
			articulos = parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!articulos.isEmpty()) {
			PDFcreator crear = new PDFcreator(articulos.size());
			crear.setPDFcrear(articulos);
			System.out.println("estoy grabando en la db");
			for(Articulos unarticulo : articulos) {
				System.out.println(unarticulo);

			}
			try {
				crear.CrearPDF();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}	
	}
}
