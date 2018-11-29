package com.dailydiary.controllers;

import com.dailydiary.entity.Category;
import com.dailydiary.entity.Logs;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.CategoryRepository;
import com.dailydiary.repositories.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String prepareHomePage(Model model, @SessionAttribute(value = LOGGED_USER_KEY, required = false) User loggedUser, HttpServletRequest request, HttpSession session) {
//        if (request.getParameter("logout") != null) {
//            session.setAttribute(LOGGED_USER_KEY, null);
//        }
        if (loggedUser != null) {
            model.addAttribute("newLog", new Logs());
            model.addAttribute("loggedUser", loggedUser);
            List<Logs> userLogs = logsRepository.findAllByUserId(loggedUser.getId());
            model.addAttribute("userLogs", userLogs);

        }
        List<Logs> logs = logsRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("allLogs", logs);

        return "homepage";
    }

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryRepository.findAll();

    }


}

