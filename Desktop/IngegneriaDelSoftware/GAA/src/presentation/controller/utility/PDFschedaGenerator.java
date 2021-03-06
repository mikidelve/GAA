package presentation.controller.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Gestisce la creazione e la stampa del pdf
 * 
 * @author Giava
 *
 */
public class PDFschedaGenerator {
	static PDFschedaGenerator pdf = new PDFschedaGenerator();
	/**
	 * Destinazione e nome definito per la scheda che sar� salvata/stampata
	 */
	public static final String DEST = "GeneratedPDF/Scheda";

	@SuppressWarnings("static-access")
	public void createPdf(int numPDF, String data, String testointro, String contenuto, String testofinale)
			throws IOException, DocumentException {
		String anno = data.substring(8, 12);
		String mese = data.substring(6, 7);
		String giorno = data.substring(3, 5);
		String dest = DEST + giorno + mese + anno + "N." + numPDF + ".pdf";
		File file = new File(dest);
		file.getParentFile().mkdirs();
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();
		Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
		Chunk chunk = new Chunk("Scheda descrittiva", chapterFont);
		Chapter chapter = new Chapter(new Paragraph(chunk), 1);
		chapter.setNumberDepth(0);
		chapter.add(new Paragraph("Data produzione : " + data, paragraphFont));
		chapter.add(chunk.NEWLINE);
		chapter.add(chunk.NEWLINE);
		chapter.add(new Paragraph(testointro, paragraphFont));
		chapter.add(chunk.NEWLINE);
		chapter.add(chunk.NEWLINE);
		chapter.add(new Paragraph(contenuto, paragraphFont));
		chapter.add(chunk.NEWLINE);
		chapter.add(chunk.NEWLINE);
		chapter.add(new Paragraph(testofinale, paragraphFont));
		document.add(chapter);
		document.close();

	}

	public void StampaPDF(int numpdf) throws IOException {
		Desktop d = java.awt.Desktop.getDesktop();
		String des = DEST + numpdf + ".pdf";
		d.print(new File(des));

	}

	public static PDFschedaGenerator getIstance() {
		return pdf;
	}

}
