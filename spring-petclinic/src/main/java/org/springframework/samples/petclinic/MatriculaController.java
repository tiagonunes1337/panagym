package org.springframework.samples.petclinic;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private PdfService pdfService;

    // CREATE + DOWNLOAD PDF (Tudo em um só passo)
    @PostMapping("/finalizar-matricula")
    public void salvar(@ModelAttribute Matricula matricula, HttpServletResponse response) throws IOException {
        Matricula salva = repository.save(matricula);

        System.out.println("Matrícula salva: " + salva.getNome() + " | Plano: " + salva.getPlano());

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=comprovante_" + salva.getNome() + ".pdf");

        pdfService.gerarComprovante(salva, response); 
    }

    // READ - Listar todos os alunos da PanaGYM
    @GetMapping("/lista")
    public String listar(Model model) {
        List<Matricula> lista = repository.findAll();
        model.addAttribute("alunos", lista);
        return "lista-alunos"; // Criaremos esse HTML em seguida
    }

    // DELETE - Remover matrícula
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/matriculas/lista";
    }
}