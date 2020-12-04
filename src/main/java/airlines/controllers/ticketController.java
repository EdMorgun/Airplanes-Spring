package airlines.controllers;

import airlines.models.client;
import airlines.models.post;
import airlines.models.route;
import airlines.models.ticket;
import airlines.repository.ticketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/ticket")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ticketController {
    @Autowired
    private ticketRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("name", getCurrentUsername());
        model.addAttribute("tickets", repository.findAll());
        return "lists/ticketList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam client client_id, @RequestParam route route_id, Model model){
        ticket ticket = new ticket();
        ticket.setClient(client_id);
        ticket.setRoute(route_id);
        repository.save(ticket);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/ticket";
    }

    @PostMapping("/{ticket}")
    public String delete(@PathVariable ticket ticket, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(ticket);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/ticket";
    }
}
