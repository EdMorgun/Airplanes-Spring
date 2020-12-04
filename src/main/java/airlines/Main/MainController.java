package airlines.Main;

import airlines.models.Users;
import airlines.models.route;
import airlines.models.ticket;
import airlines.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private routeRepository routeRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private clientRepository clientRepository;
    @Autowired
    private ticketRepository ticketRepository;
    @Autowired
    private text_blockRepository text_blockRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", getCurrentUsername());
        return "greeting";
    }

    static public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ans = auth.getName();
        return ans.equals("anonymousUser") ? null : ans;
    }

    private Optional<Users> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(usersRepository.findByUsername(auth.getName()));
    }

    @GetMapping("/main")
    public String getRoutes(Model model){
        model.addAttribute("name", getCurrentUsername());
        model.addAttribute("routes", routeRepository.findAll());
        return "main";
    }

    @GetMapping("/news")
    public String getNews(Model model){
        model.addAttribute("name", getCurrentUsername());
        model.addAttribute("text_blocks", text_blockRepository.findAll());
        return "news";
    }

    @GetMapping("/buy/{id}")
    public String buyTicket(@PathVariable(name = "id") int route_id, Model model) {
        route route = routeRepository.findById(route_id).get();
        if(route.getPlane_id().getCapacity() - route.getSold() > 0) {
            route.setSold(route.getSold() + 1);
            routeRepository.save(route);
            ticket ticket = new ticket();
            ticket.setRoute(route);
            ticket.setClient(clientRepository.findByUsr(getCurrentUser().get()));
            ticketRepository.save(ticket);
        }
        else {
            model.addAttribute("message", "There are no more seats in this plane!");
        }
        return "redirect:/main";
    }

    @GetMapping("/orders")
    public String getOrders(Model model){
        model.addAttribute("name", getCurrentUsername());
        if(!getCurrentUser().isPresent()) {
            return "redirect:/";
        }
        List<ticket> tickets = ticketRepository.findAllByClient(clientRepository.findByUsr(getCurrentUser().get()));
        List<route> routes = new ArrayList<>();
        for(ticket ticket : tickets) {
            routes.add(ticket.getRoute());
        }
        model.addAttribute("routes", routes);
        model.addAttribute("nothing", routes.isEmpty());
        return "orders";
    }
}
