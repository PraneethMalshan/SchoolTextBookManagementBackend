package com.kdpm.school_textbook_management_system.service.impl;

import com.kdpm.school_textbook_management_system.dto.request.SchoolClassDTO;
import com.kdpm.school_textbook_management_system.entity.Grade;
import com.kdpm.school_textbook_management_system.entity.SchoolClass;
import com.kdpm.school_textbook_management_system.repo.GradeRepository;
import com.kdpm.school_textbook_management_system.repo.SchoolClassRepository;
import com.kdpm.school_textbook_management_system.service.SchoolClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveSchoolClass(SchoolClassDTO schoolClassDTO, int gradeId) {
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade Not Found for that ID!!"));

        SchoolClass schoolClass = modelMapper.map(schoolClassDTO, SchoolClass.class);

        schoolClass.setGrade(grade);

        if (!schoolClassRepository.existsBySchoolClassName(schoolClass.getSchoolClassName())) {
            schoolClassRepository.save(schoolClass);
            return schoolClass.getSchoolClassName() + " Saved Successfully";
        } else {
            throw new DuplicateKeyException(schoolClass.getSchoolClassName()+" Already Added!!!");
        }
    }



}
