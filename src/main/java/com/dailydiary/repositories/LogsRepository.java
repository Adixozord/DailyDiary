package com.dailydiary.repositories;

import com.dailydiary.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogsRepository extends JpaRepository<Logs, Long> {

    List<Logs> findAllByOrderByCreatedDesc();

    // searching for log 8y log id
    List<Logs> findAllById(Long id);

    List<Logs> findAllByUserId(Long UserId);


}
