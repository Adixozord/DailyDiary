package com.dailydiary.controllers;

import com.dailydiary.entity.Logs;
import com.dailydiary.repositories.LogsRepository;
import com.dailydiary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dd/user")
public class DesktopController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LogsRepository logsRepository;

    @GetMapping("/{id}/desktop")
    public String logsOptions(@PathVariable Long id, Model model) {
        List<Logs> log = logsRepository.findAllByUserId(id);
        model.addAttribute("userLogs", log);
        return "user/desktop";
    }


}
