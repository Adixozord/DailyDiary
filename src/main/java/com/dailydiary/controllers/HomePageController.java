package com.dailydiary.controllers;

import com.dailydiary.entity.Category;
import com.dailydiary.entity.Logs;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.CategoryRepository;
import com.dailydiary.repositories.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.dailydiary.controllers.LoginController.LOGGED_USER_KEY;

@Controller
@RequestMapping(value = "/dd", produces = "text/html;charset=UTF-8")
public class HomePageController {

    @Autowired
    LogsRepository logsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping
    public String prepareHomePage(Model model,
                                  @SessionAttribute(value = LOGGED_USER_KEY, required = false) User loggedUser, HttpServletRequest request) {
        // if user is logged in
        if (loggedUser != null) {
            model.addAttribute("newLog", new Logs());
            model.addAttribute("loggedUser", loggedUser);
            // find user logs
            List<Logs> userLogs = logsRepository.findAllByUserId(loggedUser.getId());
            model.addAttribute("userLogs", userLogs);

        }
        // find all logs by creation date, sort by newest
        String search = request.getParameter("search");
        List<Logs> logs;
        if(search != null){
            logs = logsRepository.findSimilar("%"+search+"%");
        }else{
            logs = logsRepository.findAllByOrderByCreatedDesc();
        }
        model.addAttribute("allLogs", logs);
        return "homepage";
    }

    // get categories from database
    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryRepository.findAll();

    }

    @GetMapping("search")
    public String searchForLogs(Model model, @PathVariable String search) {
        model.addAttribute("foundLogs", new Logs());
        logsRepository.findSimilar("%"+search+"%");
        return "redirect:/";
    }


}

