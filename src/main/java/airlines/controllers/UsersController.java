package airlines.controllers;

import airlines.models.Role;
import airlines.models.Users;
import airlines.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static airlines.Main.MainController.getCurrentUsername;

@Controller
@RequestMapping(value="/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("name", getCurrentUsername());
        model.addAttribute("users", repository.findAll());
        return "lists/userList";
    }

    /*@GetMapping(value="/", params = { "id", "username", "firstName", "lastName" })
    public  String getBy(@RequestParam Integer id, @RequestParam String username, @RequestParam String firstName,
                                                                  @RequestParam String lastName, Model model) {
        if(id != null) {
            model.addAttribute("users", Arrays.asList(repository.findById(id).get()));
            return "lists/userList";
        }
        else if(!username.equals("")) {
            model.addAttribute("users", Arrays.asList(repository.findByUsername(username)));
            return "lists/userList";
        }
        else if(!firstName.equals("") && !lastName.equals("")) {
            model.addAttribute("users", repository.findByFirstNameAndLastName(firstName,lastName));
            return "lists/userList";
        }
        else if(!firstName.equals("")) {
            model.addAttribute("users", repository.findByFirstName(firstName));
            return "lists/userList";
        }
        else if(!lastName.equals("")) {
            model.addAttribute("users", repository.findByLastName(lastName));
            return "lists/userList";
        }
        else {
            model.addAttribute("users", repository.findAll());
            return "lists/userList";
        }
    }*/

    @PostMapping("/{user}")
    public String delete(@PathVariable Users user, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(user);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/users";
    }

    @PostMapping()
    public String update(@RequestParam String username, @RequestParam String password, @RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam Map<String, String> form,
                         @RequestParam("id") Users user,
                         Model model) {

        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstName);
        user.setLastname(lastName);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        repository.save(user);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/users";
    }
}
