package airlines.controllers;

import airlines.models.post;
import airlines.models.text_block;
import airlines.repository.text_blockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/text_block")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class text_blockController {
    @Autowired
    private text_blockRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("text_blocks", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/text_blockList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String text, @RequestParam Integer order_num, @RequestParam post post_id, Model model){
        text_block text_block = new text_block();
        text_block.setText(text);
        text_block.setOrder_num(order_num);
        text_block.setPost_id(post_id);
        repository.save(text_block);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/text_block";
    }

    @PostMapping("/{text_block}")
    public String delete(@PathVariable text_block text_block, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(text_block);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/text_block";
    }
}
