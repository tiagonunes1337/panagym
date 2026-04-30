package org.springframework.samples.petclinic;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class PdfService {

    public void gerarComprovante(Matricula matricula, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        
        // Estilização básica
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph("COMPROVANTE DE MATRÍCULA - PanaGYM", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" ")); 
        document.add(new Paragraph("Nome: " + matricula.getNome()));
        document.add(new Paragraph("CPF: " + matricula.getCpf()));
        document.add(new Paragraph("E-mail: " + matricula.getEmail()));
        document.add(new Paragraph("Telefone: " + matricula.getTelefone()));
        document.add(new Paragraph("Plano: " + matricula.getPlano()));
        document.add(new Paragraph("Status: MATRICULADO"));
        
        document.close();
    }
}