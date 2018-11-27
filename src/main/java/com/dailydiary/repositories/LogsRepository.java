package com.dailydiary.repositories;

import com.dailydiary.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogsRepository extends JpaRepository<Logs, Long> {

    List<Logs> findAll();



}
