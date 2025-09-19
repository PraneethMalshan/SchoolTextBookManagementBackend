package com.kdpm.school_textbook_management_system.controller;

import com.kdpm.school_textbook_management_system.dto.request.GradeDTO;
import com.kdpm.school_textbook_management_system.entity.Grade;
import com.kdpm.school_textbook_management_system.service.GradeService;
import com.kdpm.school_textbook_management_system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/grade")
@CrossOrigin(origins = "http://localhost:3000")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveGrade(@RequestBody GradeDTO gradeDTO ) {

        String message = gradeService.saveGrade(gradeDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

}
