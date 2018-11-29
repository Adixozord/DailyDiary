package com.dailydiary.controllers;

import com.dailydiary.dto.LoginFormDTO;
import com.dailydiary.dto.UserDTO;
import com.dailydiary.entity.User;
import com.dailydiary.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class LoginController {

    public static final String LOGGED_USER_KEY = "logged-user";

    @Autowired
    LoginService loginService;

    @GetMapping("signup")
    public String prepareLoginForm(Model model) {
        model.addAttribute("loginFormData", new LoginFormDTO());
        return "user/signup";
    }

    @PostMapping("signup")
    public String login(@ModelAttribute("loginFormData") @Valid LoginFormDTO form, BindingResult bindingResult, HttpSession session) {
        // if there are errors while filling the form
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }
        User validCredentials = loginService.login(form.getUsername(), form.getPassword());
        if (validCredentials == null) {
            bindingResult.rejectValue("username", "", "login or password incorrect");
            return "user/signup";
        }

        // correct login
        session.setAttribute(LOGGED_USER_KEY, validCredentials);
        return "redirect:/dd";
    }

    // logout logic
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.setAttribute(LOGGED_USER_KEY, null);
        return "redirect:/dd";
    }

}
