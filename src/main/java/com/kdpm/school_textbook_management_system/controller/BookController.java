package com.kdpm.school_textbook_management_system.controller;


import com.kdpm.school_textbook_management_system.dto.request.BookDTO;
import com.kdpm.school_textbook_management_system.dto.response.BookGetResponseDTO;
import com.kdpm.school_textbook_management_system.service.BookService;
import com.kdpm.school_textbook_management_system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = {"/save"})  //me method eka post/save method ekak nisaa mee annotation eka daanawa.
    public ResponseEntity<StandardResponse> saveBook(@RequestBody BookDTO bookDTO){  //frontend ekee idala  ena request eka JSON Object ekak widiyata. eeka apee project eka aethule use karanna nam class type eka bawata bind kara ganna oona.(saralawa kiyanawa nm JSON object ekaka idala DTO ekata bind/convert kara ganna oona.) (Json walin aapu object eka DTO ekee class type ekata bine kara gannawa.->BookDTO)
        String message = bookService.saveBook(bookDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getBookById(@RequestParam(value = "id") int bookId){
        List<BookGetResponseDTO> bookDTOS = bookService.getBookById(bookId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookDTOS),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-by-name", params = "name")
    public ResponseEntity<StandardResponse> getBookByName(@RequestParam(value = "name") String title){
        List<BookGetResponseDTO> bookDTOS = bookService.getBookByName(title);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookDTOS),
                HttpStatus.OK
        );
    }



}
