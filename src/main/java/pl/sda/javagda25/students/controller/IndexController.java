package pl.sda.javagda25.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/")
public class IndexController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String wyswietlMojaStroneHelloWorldTySpringu() {
        return "strona-hallo";
    }

    @GetMapping("/hallo")
    public String wyswietlHallo() {
        return "strona-hallo";
    }

    @GetMapping("/halloTo") // /halloTo?imie=Pawel
    public String wyswietlHalloTo(Model model,
                                  @RequestParam(name = "imie") String parametrImie) { // required = false // można dodać po "imie" - wtedy nie będzie się wywalał jak załadujemy stronę bez podania imienia
        model.addAttribute("atrybutImie", parametrImie);
        return "strona-hallo-to";
    }

    @GetMapping("/halloMyBaby/{babyName}")
    public String wyswietlHalloToBaby(Model model,
                                      @PathVariable(name = "babyName") String variable) {
        model.addAttribute("atrybutImie", variable);
        return "strona-hallo-to";
    }
}
