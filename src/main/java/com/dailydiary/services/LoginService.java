package com.dailydiary.services;

import com.dailydiary.dto.UserDTO;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public User login(String username, String password) {
        if (username == null || username.isEmpty()) {
            return null;
        }
        if (password == null || password.isEmpty()) {
            return null;
        }
        User user = userRepository.findByUsername(username);
        if(!BCrypt.checkpw(password, user.getPassword())){
            return null;
        }
        return user;
    }

//    public User login(String username, String password) {
//        if (username == null || username.isEmpty()) {
//            return null;
//        }
//        if (password == null || password.isEmpty()) {
//            return null;
//        }
//        User user = userRepository.findByUsername(username);
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setUsername(user.getUsername());
//        userDTO.setEmail(user.getEmail());
//        return userDTO;
//    }
}
