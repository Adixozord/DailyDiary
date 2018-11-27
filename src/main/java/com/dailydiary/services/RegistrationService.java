package com.dailydiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dailydiary.dto.RegistrationFormDTO;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.UserRepository;

import javax.validation.Valid;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    public boolean checkUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        User user = userRepository.findByUsername(username);
        return user == null;
    }

    public boolean checkEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        User user = userRepository.findByEmail(email);
        return user == null;
    }

    public void registerUser(@Valid RegistrationFormDTO form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setEnabled(true);
        userRepository.save(user);


    }
}
