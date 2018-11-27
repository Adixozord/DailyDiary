package com.dailydiary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dailydiary.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameAndPassword(String username, String password);
}
