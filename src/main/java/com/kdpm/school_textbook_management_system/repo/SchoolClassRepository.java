package com.kdpm.school_textbook_management_system.repo;

import com.kdpm.school_textbook_management_system.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {
    boolean existsBySchoolClassName(String schoolClassName);
}
