package com.maslov.controller;

import com.maslov.entity.TaskItem;
import com.maslov.entity.TaskItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskBookController {

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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String newItem(TaskItem item){
        if(!item.getName().equalsIgnoreCase("")){
            repository.save(item);
            return "redirect:/";
        }
        return "redirect:/";
    }
}
