package airlines.controllers;

import airlines.models.airport;
import airlines.models.client;
import airlines.models.hangar;
import airlines.models.post;
import airlines.repository.hangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/hangar")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class hangarController {
    @Autowired
    private hangarRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("hangars", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/hangarList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam Integer capacity, @RequestParam String number, @RequestParam airport airport_id, Model model){
        hangar hangar = new hangar();
        hangar.setCapacity(capacity);
        hangar.setNumber(number);
        hangar.setAirport_id(airport_id);
        repository.save(hangar);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/hangar";
    }

    @PostMapping("/{hangar}")
    public String delete(@PathVariable hangar hangar, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(hangar);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/hangar";
    }
}
