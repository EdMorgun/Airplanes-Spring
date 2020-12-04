package airlines.controllers;

import airlines.models.comment;
import airlines.models.feedback;
import airlines.repository.commentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;
import java.sql.Date;

@RequestMapping(value = "/comment")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class commentController {
    @Autowired
    private commentRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("comments", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/commentList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam feedback feedback_id, @RequestParam Integer like_amount, @RequestParam Integer dislike_amount,
                         @RequestParam String text, Model model){
        comment comment = new comment();
        comment.setFeedback_id(feedback_id);
        comment.setLike_amount(like_amount);
        comment.setDislike_amount(dislike_amount);
        comment.setText(text);
        repository.save(comment);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/comment";
    }

    @PostMapping("/{comment}")
    public String delete(@PathVariable comment comment, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(comment);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/comment";
    }
}
