package com.kdpm.school_textbook_management_system.controller;

import com.kdpm.school_textbook_management_system.dto.request.SchoolClassDTO;
import com.kdpm.school_textbook_management_system.service.GradeService;
import com.kdpm.school_textbook_management_system.service.SchoolClassService;
import com.kdpm.school_textbook_management_system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/class")
@CrossOrigin(origins = "http://localhost:3000")
public class SchoolClassController {

    @Autowired
    private SchoolClassService schoolClassService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveSchoolClass(@RequestBody SchoolClassDTO schoolClassDTO){
        int gradeId = schoolClassDTO.getGradeId();
        String message = schoolClassService.saveSchoolClass(schoolClassDTO, gradeId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-all-classes")
    public ResponseEntity<StandardResponse> getAllSchoolClasses(){
        List<SchoolClassDTO> schoolClassDTOS = schoolClassService.getAllSchoolClasses();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", schoolClassDTOS),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-school-class/{id}")
    public ResponseEntity<StandardResponse> deleteClass (@PathVariable(value = "id") int schoolClassId){
        String message = schoolClassService.deleteClass(schoolClassId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Success", message),
                HttpStatus.OK
        );
    }

}
