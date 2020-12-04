package airlines.controllers;

import airlines.models.post;
import airlines.repository.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/post")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class postController {
    @Autowired
    private postRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("posts", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/postList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String theme, Model model){
        post post = new post();
        post.setTheme(theme);
        repository.save(post);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/post";
    }

    @PostMapping("/{post}")
    public String delete(@PathVariable post post, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(post);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/post";
    }
}
