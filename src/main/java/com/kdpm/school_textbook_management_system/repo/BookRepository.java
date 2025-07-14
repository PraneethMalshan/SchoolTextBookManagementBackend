package com.kdpm.school_textbook_management_system.repo;

import com.kdpm.school_textbook_management_system.dto.request.BookDTO;
import com.kdpm.school_textbook_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByBookId(int bookId);

    List<Book> findBookByTitle(String title);

}
