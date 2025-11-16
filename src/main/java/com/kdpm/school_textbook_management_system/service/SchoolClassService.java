package com.kdpm.school_textbook_management_system.service;

import com.kdpm.school_textbook_management_system.dto.request.SchoolClassDTO;

public interface SchoolClassService {
    String saveSchoolClass(SchoolClassDTO schoolClassDTO, int gradeId);

}
