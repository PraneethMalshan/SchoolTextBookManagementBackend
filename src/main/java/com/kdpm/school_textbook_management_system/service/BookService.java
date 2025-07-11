package com.kdpm.school_textbook_management_system.service;

import com.kdpm.school_textbook_management_system.dto.request.BookDTO;
import com.kdpm.school_textbook_management_system.dto.response.BookGetResponseDTO;

import java.util.List;

public interface BookService {
    String saveBook(BookDTO bookDTO);

    List<BookGetResponseDTO> getBookById(int bookId);

    List<BookGetResponseDTO> getBookByName(String title);
}

