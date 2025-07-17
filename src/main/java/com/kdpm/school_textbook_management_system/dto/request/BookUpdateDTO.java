package com.kdpm.school_textbook_management_system.dto.request;

import com.kdpm.school_textbook_management_system.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookUpdateDTO {
    private int bookId;
    private String title;
    private String subject;
    private LocalDate receivedDate;
    private String bookImage;
    private int totalCount;
    private boolean activeState;
}
