package com.dailydiary.controllers;

import com.dailydiary.dto.UserDTO;
import com.dailydiary.entity.Logs;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping(value = "/dd", produces = "text/html;charset=UTF-8")
public class HomePageController {

    @Autowired
    LogsRepository logsRepository;

    @GetMapping
        public String prepareHomePage(Model model, @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) User loggedUser){

            if(loggedUser != null){
                model.addAttribute("loggedUser",loggedUser);
                List<Logs> userLogs = logsRepository.findAllByUserId(loggedUser.getId());
                model.addAttribute("userLogs", userLogs);
            }
            List<Logs> logs = logsRepository.findAll();
            model.addAttribute("allLogs", logs);

            return "homepage";
        }

    }
