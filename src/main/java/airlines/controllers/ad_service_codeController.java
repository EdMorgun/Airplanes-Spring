package airlines.controllers;

import airlines.models.ad_service_code;
import airlines.repository.ad_service_codeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value="/ad_service_code")
public class ad_service_codeController {

    private ad_service_codeRepository repository;

    @Autowired
    public ad_service_codeController(ad_service_codeRepository ad_service_codeRepository) {
        repository = ad_service_codeRepository;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("ad_service_codes", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/ad_service_codeList";
    }/*

    @GetMapping(value = "/{ad_service_code}")
    public String airlineEditForm(@PathVariable ad_service_code code, Model model) {
        model.addAttribute("ad_service_code", code);
        return "edits/ad_service_codeEdit";
    }*/

    @PostMapping(params = { "create" } )
    public String create(@RequestParam Integer cost, @RequestParam String descr, Model model){
        ad_service_code code = new ad_service_code();
        code.setCost(cost);
        code.setDescr(descr);
        repository.save(code);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/ad_service_code";
    }
/*
    @PostMapping()
    public String update(@RequestParam Integer cost, @RequestParam String descr,
                         @RequestParam("ad_code_id") ad_service_code code) {
        code.setCost(cost);
        code.setDescr(descr);
        repository.save(code);
        return "redirect:/ad_service_code";
    }
*/
    @PostMapping("/{ad_code_id}")
    public String delete(@PathVariable ad_service_code ad_code_id, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(ad_code_id);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/ad_service_code";
    }
}
