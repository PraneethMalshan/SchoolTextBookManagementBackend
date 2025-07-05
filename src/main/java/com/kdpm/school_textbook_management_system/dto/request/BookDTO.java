package com.kdpm.school_textbook_management_system.dto.request;

import com.kdpm.school_textbook_management_system.entity.BookAllocation;
import com.kdpm.school_textbook_management_system.entity.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private int bookId;
    private String title;
    private String subject;
    private LocalDate receivedDate;
    private String bookImage;
    private int totalCount;
    private boolean activeStatus;
    private String grade;
    private Set<BookAllocation> allocations;

}
