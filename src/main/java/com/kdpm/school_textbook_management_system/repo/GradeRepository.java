package com.kdpm.school_textbook_management_system.repo;

import com.kdpm.school_textbook_management_system.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    boolean existsByGradeName(String gradeName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Grade g WHERE g.gradeId =:gradeId")
    void deleteGradeByGradeId(int gradeId);
}

