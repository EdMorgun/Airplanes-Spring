package airlines.Main;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static airlines.Main.MainController.getCurrentUsername;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping()
    public String admin(Model model) {
        model.addAttribute("name", getCurrentUsername());
        return "/admin";
    }

    @PostMapping()
    public String action(@RequestParam String table, Model model) {
        if(table.equals("Choose table to edit")) { return "admin"; }
        Tables t = Tables.valueOf(table);
        model.addAttribute("name", getCurrentUsername());
        switch (t) {
            case ad_service:
                return "redirect:/ad_service";
            case ad_service_code:
                return "redirect:/ad_service_code";
            case airport:
                return "redirect:/airport";
            case client:
                return "redirect:/client";
            case comment:
                return "redirect:/comment";
            case hangar:
                return "redirect:/hangar";
            case plane:
                return "redirect:/plane";
            case position:
                return "redirect:/position";
            case route:
                return "redirect:/route";
            case spec_machinery:
                return "redirect:/spec_machinery";
            case spec_machinery_codelist:
                return "redirect:/spec_machinery_codelist";
            case text_block:
                return "redirect:/text_block";
            case ticket:
                return "redirect:/ticket";
            case users:
                return "redirect:/users";
            case feedback:
                return "redirect:/feedback";
            case employee:
                return "redirect:/employee";
            case post:
                return "redirect:/post";
            default:
                return "/admin";
        }
    }
}

enum Tables {
    ad_service,
    ad_service_code,
    airport,
    client,
    comment,
    employee,
    feedback,
    hangar,
    plane,
    position,
    post,
    route,
    spec_machinery,
    spec_machinery_codelist,
    text_block,
    ticket,
    users
}
