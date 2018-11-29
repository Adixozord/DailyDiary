package com.dailydiary.repositories;

import com.dailydiary.entity.Logs;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogsRepository extends JpaRepository<Logs, Long> {

    List<Logs> findAllByOrderByCreatedDesc();

    // searching for log 8y log id
    List<Logs> findAllById(Long id);

    List<Logs> findAllByContent(String search);

    List<Logs> findAllByUserId(Long UserId);

    @Query("SELECT l FROM Logs l WHERE l.category like :search OR l.content like :search OR l.user.username like :search")
    List<Logs> findSimilar(@Param("search") String search);


}
