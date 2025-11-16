package com.kdpm.school_textbook_management_system.repo;

import com.kdpm.school_textbook_management_system.entity.SchoolClass;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {
    boolean existsBySchoolClassName(String schoolClassName);

    @Modifying
    @Transactional
    @Query("DELETE FROM SchoolClass sc WHERE sc.schoolClassId =:schoolClassId")
    void deleteSchoolClassBySchoolClassId(int schoolClassId);
}



