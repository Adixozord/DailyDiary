package com.dailydiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dailydiary.dto.LoginFormDTO;
import com.dailydiary.dto.UserDTO;
import com.dailydiary.services.LoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class LoginController {

    public static final String LOGGED_USER_KEY = "logged-user";

    @Autowired
    LoginService loginService;

    @GetMapping("/signup")
    public String prepareLoginForm(Model model) {
        model.addAttribute("loginFormData", new LoginFormDTO());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String login(@ModelAttribute("loginFormData") @Valid LoginFormDTO form, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "user/signup";
        }
        boolean validCredentials = loginService.checkCredentials(form.getUsername(), form.getPassword());
        if(!validCredentials){
            bindingResult.rejectValue("username","","login or password incorrect");
            return "user/signup";
        }

        UserDTO user = loginService.login(form.getUsername(), form.getPassword());
        session.setAttribute(LOGGED_USER_KEY, user);
        return "redirect:/dd";


    }

}
