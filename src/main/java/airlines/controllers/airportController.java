package airlines.controllers;

import airlines.models.airport;
import airlines.repository.airportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/airport")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class airportController {
    @Autowired
    private airportRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("airports", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/airportList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String name, @RequestParam String location, Model model){
        airport airport = new airport();
        airport.setName(name);
        airport.setLocation(location);
        repository.save(airport);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/airport";
    }
    
    @PostMapping("/{airport}")
    public String delete(@PathVariable airport airport, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(airport);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/airport";
    }
}
