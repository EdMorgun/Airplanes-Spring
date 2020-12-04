package airlines.controllers;

import airlines.models.ad_service;
import airlines.models.ad_service_code;
import airlines.models.ticket;
import airlines.repository.ad_serviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/ad_service")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ad_serviceController {

    @Autowired
    private ad_serviceRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("ad_services", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/ad_serviceList";
    }
/*
    @GetMapping(value="/{ad_service}")
    public String ad_serviceEditForm(@PathVariable ad_service ad_service, Model model) {
        model.addAttribute("ad_service", ad_service);
        return "edits/ad_serviceEdit";
    }

    @GetMapping(params = { "create" })
    public String ad_serviceEditForm(@RequestParam(name = "create") String create) {
        if(create.equals("1")) return "creates/createAirline";
        return "lists/ad_serviceList";
    }
*/
    @PostMapping(params = { "create" } )
    public String create(@RequestParam ad_service_code ad_code_id, @RequestParam ticket ticket_id, Model model){
        ad_service ad_service = new ad_service();
        ad_service.setAd_code_id(ad_code_id);
        ad_service.setTicket_id(ticket_id);
        repository.save(ad_service);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/ad_service";
    }
/*
    @PostMapping()
    public String update(@RequestParam ad_service_code ad_code_id, @RequestParam ticket ticket_id, @RequestParam("id") ad_service ad_service){
        ad_service.setAd_code_id(ad_code_id);
        ad_service.setTicket_id(ticket_id);
        repository.save(ad_service);
        return "redirect:/ad_service";
    }
*/
    @PostMapping("/{ad_service}")
    public String delete(@PathVariable ad_service ad_service, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(ad_service);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/ad_service";
    }
}
