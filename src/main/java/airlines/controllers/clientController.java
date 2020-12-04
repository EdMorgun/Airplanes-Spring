package airlines.controllers;

import airlines.models.client;
import airlines.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/client")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class clientController {
    @Autowired
    private clientRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("clients", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/clientList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String full_name, @RequestParam String birth_date, @RequestParam String passport_data,
                         @RequestParam String email, Model model){
        client client = new client();
        client.setFull_name(full_name);
        client.setBirth_date(java.sql.Date.valueOf(birth_date));
        client.setPassport_data(passport_data);
        client.setEmail(email);
        repository.save(client);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/client";
    }

    @PostMapping("/{client}")
    public String delete(@PathVariable client client, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(client);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/client";
    }
}
