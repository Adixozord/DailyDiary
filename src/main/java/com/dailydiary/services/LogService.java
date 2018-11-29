package com.dailydiary.services;

import com.dailydiary.dto.LogFormDTO;
import com.dailydiary.entity.Logs;
import com.dailydiary.entity.User;
import com.dailydiary.repositories.LogsRepository;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
public class LogService {

    @Autowired
    LogsRepository logsRepository;

    public void createLog(@Valid Logs log, User user){

        log.setCreated(LocalDateTime.now());
        log.setUser(user);

        logsRepository.save(log);

    }

}
