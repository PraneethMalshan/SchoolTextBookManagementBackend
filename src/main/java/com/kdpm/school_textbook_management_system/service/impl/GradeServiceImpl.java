package com.kdpm.school_textbook_management_system.service.impl;

import com.kdpm.school_textbook_management_system.dto.request.GradeDTO;
import com.kdpm.school_textbook_management_system.entity.Grade;
import com.kdpm.school_textbook_management_system.exception.NotFoundException;
import com.kdpm.school_textbook_management_system.repo.GradeRepository;
import com.kdpm.school_textbook_management_system.service.GradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {


    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveGrade(GradeDTO gradeDTO) {
        Grade grade = modelMapper.map(gradeDTO, Grade.class);
        if (!gradeRepository.existsByGradeName(grade.getGradeName())) {
            gradeRepository.save(grade);
            return grade.getGradeId() + " Saved Successfully";
        } else {
            throw new DuplicateKeyException("Grade with name " + grade.getGradeName() + " already exists!");

        }
    }

    @Override
    public String deleteGrade(int gradeId) {
        if (gradeRepository.existsById(gradeId)) {
            gradeRepository.deleteGradeByGradeId(gradeId);
            return "Deleted Successfully " + gradeId;
        } else {
            throw new NotFoundException("No Grade Found for that ID!!!");
        }
    }
}
