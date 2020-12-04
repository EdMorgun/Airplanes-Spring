package airlines.controllers;

import airlines.models.airport;
import airlines.models.plane;
import airlines.models.route;
import airlines.repository.routeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

import java.sql.Date;
import java.sql.Timestamp;

@RequestMapping(value = "/route")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class routeController {
    @Autowired
    private routeRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("routes", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/routeList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam airport source_airport_id, @RequestParam airport dest_airport_id, @RequestParam Timestamp time_start,
                         @RequestParam Timestamp time_end, @RequestParam plane plane_id, Model model){
        route route = new route();
        route.setSource_airport_id(source_airport_id);
        route.setDest_airport_id(dest_airport_id);
        route.setTime_start(time_start);
        route.setTime_end(time_end);
        route.setPlane_id(plane_id);
        repository.save(route);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/route";
    }

    @PostMapping("/{route}")
    public String delete(@PathVariable route route, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(route);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/route";
    }
}

