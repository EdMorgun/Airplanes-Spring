package airlines.controllers;

import airlines.models.airport;
import airlines.models.hangar;
import airlines.models.plane;
import airlines.repository.planeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;
import java.sql.Date;

@RequestMapping(value = "/plane")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class planeController {
    @Autowired
    private planeRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("planes", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/planeList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String number, @RequestParam hangar hangar_id, @RequestParam String model, @RequestParam Date last_maintenance,
                         @RequestParam Integer capacity, @RequestParam Integer resource, Model modelp){
        plane plane = new plane();
        plane.setCapacity(capacity);
        plane.setNumber(number);
        plane.setHangar_id(hangar_id);
        plane.setModel(model);
        plane.setLast_maintenance(last_maintenance);
        plane.setResource(resource);
        repository.save(plane);
        modelp.addAttribute("name", getCurrentUsername());
        return "redirect:/plane";
    }

    @PostMapping("/{plane}")
    public String delete(@PathVariable plane plane, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(plane);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/plane";
    }
}
