package com.dailydiary.controllers;


import com.dailydiary.entity.Category;
import com.dailydiary.entity.Logs;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.CategoryRepository;
import com.dailydiary.repositories.LogsRepository;
import com.dailydiary.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dd/logs")
public class LogsController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    LogService logService;

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @Autowired
    LogsRepository logsRepository;


    @GetMapping("/new")
    public String getNewLogForm(Model model) {
        model.addAttribute("newLog", new Logs());
        return "redirect:/";
    }

    @PostMapping("/new")
    public String saveLog(@ModelAttribute("newLog") Logs log, HttpSession session) {
        User user = (User) session.getAttribute("logged-user");
        if (user != null) {
            logService.createLog(log, user);
            return "redirect:/dd";

        } else {
            //odsluga niezalogoanego
            return "logs/new-log";

        }
    }


}
