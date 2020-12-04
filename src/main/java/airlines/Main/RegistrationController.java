package airlines.Main;

import airlines.models.Role;
import airlines.models.Users;
import airlines.models.client;
import airlines.repository.UsersRepository;
import airlines.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    clientRepository clientRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Users user, Map<String, Object> model){
        Users userFromDb = usersRepository.findByUsername(user.getUsername());
        if(userFromDb != null) {
            model.put("message", "This username is already taken. Please choose another one.");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usersRepository.save(user);
        client client = new client();
        client.setUsr(user);
        clientRepository.save(client);
        return "redirect:/login";
    }

}
