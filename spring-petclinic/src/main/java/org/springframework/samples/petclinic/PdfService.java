package org.springframework.samples.petclinic;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;

@Service
public class PdfService {

    public void gerarComprovante(Matricula matricula, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // ── LOGO ──────────────────────────────────────────────────────────────
        try {
            URL logoUrl = getClass().getResource("/static/img/panagymlogo.png");
            if (logoUrl != null) {
                Image logo = Image.getInstance(logoUrl);
                logo.scaleToFit(120, 60);
                logo.setAlignment(Image.ALIGN_CENTER);
                document.add(logo);
            }
        } catch (Exception e) {
            System.out.println("Logo não encontrada: " + e.getMessage());
        }

        // ── LINHA SEPARADORA AZUL ──────────────────────────────────────────────
        PdfContentByte cb = writer.getDirectContent();
        cb.setColorStroke(new Color(59, 130, 246)); // azul do site
        cb.setLineWidth(2f);
        cb.moveTo(36, 750);
        cb.lineTo(559, 750);
        cb.stroke();

        document.add(new Paragraph(" "));

        // ── TÍTULO ────────────────────────────────────────────────────────────
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(20);
        fontTitle.setColor(new Color(15, 23, 42)); // slate-950

        Paragraph title = new Paragraph("COMPROVANTE DE MATRÍCULA", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        Font fontSubtitle = FontFactory.getFont(FontFactory.HELVETICA);
        fontSubtitle.setSize(11);
        fontSubtitle.setColor(new Color(100, 116, 139)); // slate-500

        Paragraph subtitle = new Paragraph("PanaGYM - Brasília, Distrito Federal", fontSubtitle);
        subtitle.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(subtitle);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        // ── TABELA DE DADOS ───────────────────────────────────────────────────
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{35f, 65f});

        Font fontLabel = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontLabel.setSize(10);
        fontLabel.setColor(new Color(100, 116, 139));

        Font fontValue = FontFactory.getFont(FontFactory.HELVETICA);
        fontValue.setSize(11);
        fontValue.setColor(new Color(15, 23, 42));

        Color bgLabel = new Color(241, 245, 249); // slate-100
        Color bgValue = Color.WHITE;

        adicionarLinha(table, "Nome",      matricula.getNome(),                    fontLabel, fontValue, bgLabel, bgValue);
        adicionarLinha(table, "CPF",       mascaraCpf(matricula.getCpf()),          fontLabel, fontValue, bgLabel, bgValue);
        adicionarLinha(table, "E-mail",    matricula.getEmail(),                   fontLabel, fontValue, bgLabel, bgValue);
        adicionarLinha(table, "Telefone",  mascaraTelefone(matricula.getTelefone()),fontLabel, fontValue, bgLabel, bgValue);
        adicionarLinha(table, "Cartão",    mascaraCartao(matricula.getCartao()),    fontLabel, fontValue, bgLabel, bgValue);
        adicionarLinha(table, "Plano",     matricula.getPlano(),                   fontLabel, fontValue, bgLabel, bgValue);
        adicionarLinha(table, "Status",    "MATRICULADO ✓",                        fontLabel, fontValue, bgLabel, bgValue);

        document.add(table);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        // ── RODAPÉ ────────────────────────────────────────────────────────────
        cb.setColorStroke(new Color(59, 130, 246));
        cb.setLineWidth(1f);
        cb.moveTo(36, 120);
        cb.lineTo(559, 120);
        cb.stroke();

        Font fontFooter = FontFactory.getFont(FontFactory.HELVETICA);
        fontFooter.setSize(9);
        fontFooter.setColor(new Color(148, 163, 184));

        Paragraph footer = new Paragraph("Este documento é um comprovante oficial de matrícula na PanaGYM.\nDúvidas? Entre em contato pelo site panagym.com.br", fontFooter);
        footer.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(footer);

        document.close();
    }

    // ── HELPER: linha da tabela ────────────────────────────────────────────────
    private void adicionarLinha(PdfPTable table, String label, String value,
                                 Font fontLabel, Font fontValue,
                                 Color bgLabel, Color bgValue) {
        PdfPCell cellLabel = new PdfPCell(new Phrase(label, fontLabel));
        cellLabel.setBackgroundColor(bgLabel);
        cellLabel.setPadding(10f);
        cellLabel.setBorderColor(new Color(226, 232, 240));

        PdfPCell cellValue = new PdfPCell(new Phrase(value != null ? value : "-", fontValue));
        cellValue.setBackgroundColor(bgValue);
        cellValue.setPadding(10f);
        cellValue.setBorderColor(new Color(226, 232, 240));

        table.addCell(cellLabel);
        table.addCell(cellValue);
    }

    // ── MÁSCARAS ──────────────────────────────────────────────────────────────
    private String mascaraCpf(String cpf) {
        if (cpf == null) return "-";
        String digits = cpf.replaceAll("[^0-9]", "");
        if (digits.length() != 11) return cpf;
        return digits.substring(0, 3) + "." +
               digits.substring(3, 6) + "." +
               digits.substring(6, 9) + "-" +
               digits.substring(9);
    }

    private String mascaraTelefone(String tel) {
        if (tel == null) return "-";
        String digits = tel.replaceAll("[^0-9]", "");
        if (digits.length() == 11) // celular (11) 99999-9999
            return "(" + digits.substring(0, 2) + ") " +
                   digits.substring(2, 7) + "-" +
                   digits.substring(7);
        if (digits.length() == 10) // fixo (11) 9999-9999
            return "(" + digits.substring(0, 2) + ") " +
                   digits.substring(2, 6) + "-" +
                   digits.substring(6);
        return tel;
    }

    private String mascaraCartao(String cartao) {
        if (cartao == null) return "-";
        String digits = cartao.replaceAll("[^0-9]", "");
        if (digits.length() != 16) return cartao;
        // Mostra só os últimos 4 dígitos por segurança
        return "**** **** **** " + digits.substring(12);
    }
}