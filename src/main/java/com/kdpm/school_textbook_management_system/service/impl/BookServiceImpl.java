package com.kdpm.school_textbook_management_system.service.impl;

import com.kdpm.school_textbook_management_system.dto.request.BookDTO;
import com.kdpm.school_textbook_management_system.dto.request.BookUpdateDTO;
import com.kdpm.school_textbook_management_system.dto.response.BookGetResponseDTO;
import com.kdpm.school_textbook_management_system.entity.Book;
import com.kdpm.school_textbook_management_system.exception.NotFoundException;
import com.kdpm.school_textbook_management_system.repo.BookRepository;
import com.kdpm.school_textbook_management_system.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public List<BookGetResponseDTO> getAllBooks() {
        List<Book> getAllBooks = bookRepository.findAll();
        if (getAllBooks.size() > 0) {
            return getAllBooks.stream()
                    .map(book -> modelMapper.map(book, BookGetResponseDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new NotFoundException("Book is Not Found!!");
        }


    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if (bookRepository.existsById(bookUpdateDTO.getBookId())){
            Book book = bookRepository.getReferenceById(bookUpdateDTO.getBookId());

            book.setTitle(bookUpdateDTO.getTitle());
            book.setSubject(bookUpdateDTO.getSubject());
            book.setReceivedDate(bookUpdateDTO.getReceivedDate());
            book.setBookImage(bookUpdateDTO.getBookImage());
            book.setTotalCount(bookUpdateDTO.getTotalCount());
            book.setActiveState(bookUpdateDTO.isActiveState());

            bookRepository.save(book);
            return bookUpdateDTO.getTitle() + " Updated Successfully ";
        } else {
            throw new RuntimeException("No Data Found from that ID");
        }
    }

    @Override
    public List<BookDTO> getAllBooksByActiveState(boolean activeState) {
        List<Book> getAllBooks = bookRepository.findAllByActiveStateEquals(activeState);
        if (getAllBooks.size() > 0) {
            return getAllBooks.stream()
                    .map(book -> modelMapper.map(book, BookDTO.class))
                    .collect(Collectors.toList());
        } else {
            throw new NotFoundException("Book is Not Found!!");
        }
    }

    @Override
    public List<BookGetResponseDTO> getBookByNameAndState(String title) {
        boolean b = true;
        List<Book> books = bookRepository.findAllByTitleEqualsAndActiveStateEquals(title,b);
        if (books.size() > 0) {
            List<BookGetResponseDTO> bookGetResponseDTOS = modelMapper
                    .map(books, new TypeToken<List<BookGetResponseDTO>>() {}
                    .getType());
            return bookGetResponseDTOS;
        } else {
            throw new RuntimeException("Book is Not Active!!");
        }
    }

    @Override
    public String deleteBook(int bookId) {
        if (bookRepository.existsById(bookId)){
            bookRepository.deleteBookByBookId(bookId);
            return " Deleted Successfully " + bookId;
        } else {
            throw new NotFoundException("No Book Found for that ID!!!");
        }
    }


}
