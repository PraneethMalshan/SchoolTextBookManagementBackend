package com.kdpm.school_textbook_management_system.repo;

import com.kdpm.school_textbook_management_system.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    boolean existsByGradeName(String gradeName);
}

