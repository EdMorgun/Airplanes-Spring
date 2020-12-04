package airlines.controllers;

import airlines.models.*;
import airlines.repository.feedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;
import java.sql.Date;

@RequestMapping(value = "/feedback")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class feedbackController {
    @Autowired
    private feedbackRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("feedbacks", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/feedbackList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam client client_id, @RequestParam Integer like_amount, @RequestParam Integer dislike_amount,
                         @RequestParam String text, @RequestParam post post_id, @RequestParam String theme, Model model){
        feedback feedback = new feedback();
        feedback.setClient_id(client_id);
        feedback.setLike_amount(like_amount);
        feedback.setDislike_amount(dislike_amount);
        feedback.setText(text);
        feedback.setPost_id(post_id);
        feedback.setTheme(theme);
        repository.save(feedback);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/feedback";
    }

    @PostMapping("/{feedback}")
    public String delete(@PathVariable feedback feedback, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(feedback);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/feedback";
    }
}
