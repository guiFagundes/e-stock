package projeto.estock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Model model) {
        //model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
}
