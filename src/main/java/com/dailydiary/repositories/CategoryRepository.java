package com.dailydiary.repositories;

import com.dailydiary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category , Long> {
    List<Category> findAll();
}
