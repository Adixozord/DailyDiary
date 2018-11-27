package com.dailydiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dailydiary.dto.UserDTO;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.UserRepository;

@Service
@Transactional
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public boolean checkCredentials(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }

    public UserDTO login(String username, String password) {
        if (username == null || username.isEmpty()) {
            return null;
        }
        if (password == null || password.isEmpty()) {
            return null;
        }
        User user = userRepository.findByUsernameAndPassword(username, password);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
