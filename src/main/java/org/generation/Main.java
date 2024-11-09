package org.generation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {
//crea un pdf con maven
	public static void main(String[] args) {
		
		//https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.5.13.3 
		// TODO Auto-generated method stub
		Document doc = new Document();// crea documento pdf
		//para mandarlo llamar 
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("recibo_nomina.pdf"));// entre comillas leva el nombre de arcivo//maneja el patron de diseño singleton solo permite una istancia no mas de una.
			doc.open();//abrr el documento
			//doc.add(new Paragraph("ch37 Meme masters feliz"));//agrega un parrafo 
			
			Image image = Image.getInstance("y.png");//agrega una imagen
			image.scaleAbsolute(100,100);//define el tamaño de la imagen 
			PdfPTable tabla = new PdfPTable(3);//tres columnas
			PdfPCell cell;// celda celda
			
			cell = new PdfPCell(new Phrase("Recibo de Nómina"));//agrega la celda 
			cell.setColspan(3);//oocupa 3 columnas de mi tabla es el titulo
			tabla.addCell(cell);
			
			cell = new PdfPCell(new Phrase("Nombre"));
			cell.setRowspan(2);//ocupe dos rows de la columna
			tabla.addCell(cell);
			tabla.addCell("RFC");
			tabla.addCell("Fecha");
			tabla.addCell("Departamento");
			tabla.addCell("Salario");
			
			
			//AGREGA LOS ELEMENTOS AL DOCUMENTO. 
			doc.add(image);
			doc.add(new Phrase("CH37 SA DE CV DE RL"));
			doc.add(new Phrase(" "));
			doc.add(tabla);
			
			
			
			
		} catch (FileNotFoundException | DocumentException e) {
			
			e.printStackTrace();
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doc.close();//cierra el documento 
		
		
		 
	}//main

}//class
