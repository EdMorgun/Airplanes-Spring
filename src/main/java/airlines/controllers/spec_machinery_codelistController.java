package airlines.controllers;

import airlines.models.airport;
import airlines.models.plane;
import airlines.models.spec_machinery_codelist;
import airlines.repository.spec_machinery_codelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

import java.sql.Date;

@RequestMapping(value = "/spec_machinery_codelist")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class spec_machinery_codelistController {
    @Autowired
    private spec_machinery_codelistRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("spec_machinery_codelists", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/spec_machinery_codelistList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String type_description, Model model){
        spec_machinery_codelist spec_machinery_codelist = new spec_machinery_codelist();
        spec_machinery_codelist.setType_description(type_description);
        repository.save(spec_machinery_codelist);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/spec_machinery_codelist";
    }

    @PostMapping("/{spec_machinery_codelist}")
    public String delete(@PathVariable spec_machinery_codelist spec_machinery_codelist, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(spec_machinery_codelist);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/spec_machinery_codelist";
    }
}
