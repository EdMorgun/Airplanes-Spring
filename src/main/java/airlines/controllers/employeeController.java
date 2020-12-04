package airlines.controllers;

import airlines.models.airport;
import airlines.models.employee;
import airlines.models.feedback;
import airlines.models.position;
import airlines.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static airlines.Main.MainController.getCurrentUsername;

@RequestMapping(value = "/employee")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class employeeController {
    @Autowired
    private employeeRepository repository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", repository.findAll());
        model.addAttribute("name", getCurrentUsername());
        return "lists/employeeList";
    }

    @PostMapping(params = { "create" } )
    public String create(@RequestParam String full_name, @RequestParam Date birth_date, @RequestParam String passport_data,
                         @RequestParam String email, @RequestParam airport airport_id, @RequestParam position position_id, Model model){
        employee employee = new employee();
        employee.setFull_name(full_name);
        employee.setBirth_date(birth_date);
        employee.setPassport_data(passport_data);
        employee.setEmail(email);
        employee.setAirport_id(airport_id);
        employee.setPosition_id(position_id);
        repository.save(employee);
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/employee";
    }

    @PostMapping("/{employee}")
    public String delete(@PathVariable employee employee, @RequestParam(name = "kill") String kill, Model model) {
        if(kill.equals("1")) {
            repository.delete(employee);
        }
        model.addAttribute("name", getCurrentUsername());
        return "redirect:/employee";
    }
}
