package com.kdpm.school_textbook_management_system.service.impl;

import com.kdpm.school_textbook_management_system.dto.request.BookDTO;
import com.kdpm.school_textbook_management_system.dto.response.BookGetResponseDTO;
import com.kdpm.school_textbook_management_system.entity.Book;
import com.kdpm.school_textbook_management_system.repo.BookRepository;
import com.kdpm.school_textbook_management_system.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        if (!bookRepository.existsById(book.getBookId())){
            bookRepository.save(book);
            return book.getBookId() + " Saved Successfully ";
        } else {
            throw  new DuplicateKeyException("Already Added!!!");
        }
    }

    @Override
    public List<BookGetResponseDTO> getBookById(int bookId) {
        List<Book> books = bookRepository.findBookByBookId(bookId);
        if (!books.isEmpty()){
            List<BookGetResponseDTO> bookGetResponseDTOS = books.stream()
                    .map(book -> modelMapper.map(book, BookGetResponseDTO.class))
                    .collect(Collectors.toList());

            return bookGetResponseDTOS;

        } else {
            throw new RuntimeException("Book is Not Found!");
        }
    }

    @Override
    public List<BookGetResponseDTO> getBookByName(String title) {
        List<Book> books = bookRepository.findBookByTitle(title);
        if (!books.isEmpty()){
            List<BookGetResponseDTO> bookGetResponseDTOS = books.stream()
                    .map(book -> modelMapper.map(book, BookGetResponseDTO.class))
                    .collect(Collectors.toList());

            return bookGetResponseDTOS;
        } else {
            throw new RuntimeException("Book is Not Found!");
        }
    }


}
