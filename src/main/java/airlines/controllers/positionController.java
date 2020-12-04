package airlines.controllers;

import airlines.models.hangar;
import airlines.models.position;
import airlines.repository.positionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/position")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class positionController {
    @Autowired
    private positionRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("positions", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/positionList";
    }

    @PostMapping("/{position}")
    public String delete(@PathVariable position position, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(position);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/position";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String name, @RequestParam String description, Model model){
        position position = new position();
        position.setName(name);
        position.setDescription(description);
        repository.save(position);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/position";
    }
}
