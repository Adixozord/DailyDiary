package com.dailydiary.controllers;

import com.dailydiary.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping(value = "/dd", produces = "text/html;charset=UTF-8")
public class HomePageController {

        @RequestMapping
        public String homePage(){
            return "homepage";
        }

        @GetMapping
        public String prepareHomePage(Model model, @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser){

            if(loggedUser != null){
                model.addAttribute("loggedUser",loggedUser);
            }
            return "homepage";
        }

    }
