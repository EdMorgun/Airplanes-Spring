package airlines.controllers;

import airlines.models.airport;
import airlines.models.spec_machinery;
import airlines.models.spec_machinery_codelist;
import airlines.repository.spec_machineryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/spec_machinery")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class spec_machineryController {
    @Autowired
    private spec_machineryRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("spec_machinerys", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/spec_machineryList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String number, @RequestParam airport airport_id, @RequestParam spec_machinery_codelist type_code, Model model){
        spec_machinery spec_machinery = new spec_machinery();
        spec_machinery.setNumber(number);
        spec_machinery.setAirport_id(airport_id);
        spec_machinery.setType_code(type_code);
        repository.save(spec_machinery);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/spec_machinery";
    }

    @PostMapping("/{spec_machinery}")
    public String delete(@PathVariable spec_machinery spec_machinery, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(spec_machinery);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/spec_machinery";
    }
}
