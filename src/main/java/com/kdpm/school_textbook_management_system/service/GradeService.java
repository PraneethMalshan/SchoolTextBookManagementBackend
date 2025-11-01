package com.kdpm.school_textbook_management_system.service;

import com.kdpm.school_textbook_management_system.dto.request.GradeDTO;

import java.util.List;

public interface GradeService {
    String saveGrade(GradeDTO gradeDTO);

    String deleteGrade(int gradeId);

    List<GradeDTO> getAllGrades();
}
