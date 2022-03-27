package ar.com.educacionit.practica13;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import ar.com.educacionit.practicas.dao.Articulos;

public class PDFcreator  {
	
	private Collection<Articulos> PDFcrear;
	private Integer CantAr;
	
	

	public PDFcreator(Integer cantAr) {
		this.CantAr = cantAr;
	}

	public String CrearPDF() throws Throwable {
		Iterator<Articulos> it = PDFcrear.iterator();
		 PDDocument doc = new PDDocument();
		 PDPage hoja = new PDPage(PDRectangle.A3);
	    
	    doc.addPage(hoja);
	    PDPageContentStream cont = new PDPageContentStream(doc, hoja);
	 for(int i = 1 ; i<=CantAr ; i++){  
	    cont.beginText();
	    cont.setFont(PDType1Font.TIMES_BOLD, 12);
	    cont.newLineAtOffset(18,hoja.getMediaBox().getHeight()-(40*i));
	    cont.showText(i+": "+it.next().toString());
	    cont.endText();
	  }  
	    cont.close();
	    doc.save("C:\\prueba\\docm.pdf");
	 
	 return null;
	}
		

	public void setPDFcrear(Collection<Articulos> string) {
		PDFcrear = string;
	}
	
}
