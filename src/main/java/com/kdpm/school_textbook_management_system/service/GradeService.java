package com.kdpm.school_textbook_management_system.service;

import com.kdpm.school_textbook_management_system.dto.request.GradeDTO;

public interface GradeService {
    String saveGrade(GradeDTO gradeDTO);

    String deleteGrade(int gradeId);
}
