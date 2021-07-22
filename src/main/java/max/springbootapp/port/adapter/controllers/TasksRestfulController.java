package max.springbootapp.port.adapter.controllers;

import max.springbootapp.domain.model.responses.TaskResponse;
import max.springbootapp.port.adapter.entities.UserEntity;
import max.springbootapp.domain.model.requests.TaskRequest;
import max.springbootapp.port.adapter.entities.TaskEntity;
import max.springbootapp.port.adapter.dao.StatusesRepository;
import max.springbootapp.port.adapter.dao.TasksRepository;
import max.springbootapp.port.adapter.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TasksRestfulController {
    @Autowired
    private TasksRepository tasksJpaRepository;
    @Autowired
    private StatusesRepository statusesJpaRepository;
    @Autowired
    private UsersRepository usersJpaRepository;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getAuthorities());
        if(auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toSet()).contains("ROLE_ADMIN")) {
            model.addAttribute("tasks", tasksJpaRepository.findAll());
        } else {
            List<UserEntity> usersList = usersJpaRepository.findAll();
            String username = auth.getName();
            Long userId = null;
            for (UserEntity user: usersList) {
                if (user.getName().equals(username)) {
                    userId = user.getId();
                }
            }
            List<TaskEntity> taskList = new ArrayList<>();
            for (TaskEntity task : tasksJpaRepository.findAll()) {
                if (task.getUserId()==userId) {
                    taskList.add(task);
                }
            }
            model.addAttribute("tasks", taskList);
        }
        model.addAttribute("statuses", statusesJpaRepository.findAll());
        model.addAttribute("users", usersJpaRepository.findAll());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable String id, Model model) {
        model.addAttribute("statuses", statusesJpaRepository.findAll());
        model.addAttribute("task", tasksJpaRepository.findById(Long.parseLong(id)).get());
        model.addAttribute("users", usersJpaRepository.findAll());
        return "task";
    }

    @GetMapping("/tasks/add")
    public String getTaskAddForm(Model model) {
        model.addAttribute("taskRequest", new TaskRequest());
        model.addAttribute("users", usersJpaRepository.findAll());
        return "add_task";
    }

    @PostMapping("/tasks/add")
    public String addTask(@ModelAttribute TaskRequest taskRequest, Model model) {
        model.addAttribute("taskRequest", taskRequest);
        model.addAttribute("users", usersJpaRepository.findAll());
        model.addAttribute("statuses", statusesJpaRepository.findAll());
        TaskEntity newTask = taskRequest.requestToTask();
        tasksJpaRepository.saveAndFlush(newTask);
        return("result");
    }

    @GetMapping("/tasks/delete/{id}")
    public String getDeleteTaskForm(@PathVariable String id, Model model) {
        model.addAttribute("task", tasksJpaRepository.findById(Long.parseLong(id)).get());
        return("delete_task");
    }

    @PostMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable String id, Model model) {
        tasksJpaRepository.deleteById(Long.parseLong(id));
        model.addAttribute("users", usersJpaRepository.findAll());
        return("delete_complete");
    }

    @GetMapping("/tasks/modify/{id}")
    public String getModifyTaskForm(@PathVariable String id, Model model) {
        TaskEntity task = tasksJpaRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("taskResponse", TaskResponse.taskToTaskResponse(task));
        model.addAttribute("task", task);
        model.addAttribute("users", usersJpaRepository.findAll());
        return("modify_task");
    }

    @PostMapping("/tasks/modify/{id}")
    public String modifyTask(@PathVariable String id, @ModelAttribute TaskRequest taskRequest, Model model) {
        model.addAttribute("taskRequest", taskRequest);
        model.addAttribute("statuses", statusesJpaRepository.findAll());
        TaskEntity newTask = taskRequest.requestToTask();
        newTask.setId(Long.parseLong(id));
        tasksJpaRepository.saveAndFlush(newTask);
        return("modify_complete");
    }
}
