package org.springframework.samples.petclinic; // Verifique se o package está igual aos outros arquivos .java

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // O Spring vai procurar um arquivo chamado index.html na pasta templates
    }
}