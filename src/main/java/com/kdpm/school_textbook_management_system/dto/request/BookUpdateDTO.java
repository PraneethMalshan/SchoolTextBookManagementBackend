package com.kdpm.school_textbook_management_system.dto.request;

import java.time.LocalDate;

public class BookUpdateDTO {
    private String title;
    private String subject;
    private LocalDate receivedDate;
    private String bookImage;
    private int totalCount;
    private boolean activeStatus;
    private String grade;
}
