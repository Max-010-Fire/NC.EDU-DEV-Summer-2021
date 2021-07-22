package max.springbootapp.port.adapter.controllers;

import max.springbootapp.port.adapter.entities.UserRolesEntity;
import max.springbootapp.port.adapter.dao.RolesRepository;
import max.springbootapp.port.adapter.dao.UserRolesRepository;
import max.springbootapp.port.adapter.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class UsersRestfulController {
    @Autowired
    private UsersRepository usersJpaRepository;
    @Autowired
    private UserRolesRepository userRolesJpaRepository;
    @Autowired
    private RolesRepository rolesJpaRepository;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", usersJpaRepository.findAll());
        HashMap<Long, ArrayList<Long>> userRoles = new HashMap<>();
        List<UserRolesEntity> userRolesAll = userRolesJpaRepository.findAll();
        for (UserRolesEntity ur: userRolesAll) {
            if (userRoles.containsKey(ur.getUserId())) {
                userRoles.get(ur.getUserId()).add(ur.getRoleId());
            } else {
                userRoles.put(ur.getUserId(), new ArrayList<>());
                userRoles.get(ur.getUserId()).add(ur.getRoleId());
            }
        }

        model.addAttribute("userRoles", userRoles);
        model.addAttribute("roles", rolesJpaRepository.findAll());
        return "users";
    }
}
