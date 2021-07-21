package max.springbootapp.port.adapter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainRestfulController {
    @GetMapping("/")
    public String getAllTasks() {
        return "index";
    }
}
