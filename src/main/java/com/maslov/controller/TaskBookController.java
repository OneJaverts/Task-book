package com.maslov.controller;

import com.maslov.entity.TaskItem;
import com.maslov.entity.User;
import com.maslov.repository.TaskItemRepository;
import com.maslov.service.SecurityService;
import com.maslov.service.UserServiceImpl;
import com.maslov.validator.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskBookController {

    @Autowired
    private UserServiceImpl UserServiceImpl;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;
    private final TaskItemRepository repository;

    @Autowired
    public TaskBookController(TaskItemRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model){
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new TaskItem());
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userFrom", new User());
        System.out.println("модель добавлена");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userform")User user,
                               BindingResult bindingResult, Model model){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "registration";
        }
        UserServiceImpl.save(user);
        //securityService.autoLogin(user);
        return "redirect:/";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String errors, String logout){
        if(errors!=null){
            model.addAttribute("error", "Username of password is incorrect.");
        }
        if(logout!=null){
            model.addAttribute("message", "Logged out successfully");
        }
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String newItem(TaskItem item){
        if(item.getName().length() > 3){
            repository.save(item);
            return "redirect:/";
        }else System.out.println("Поле не заполнено");
        return "redirect:/";
    }
}
