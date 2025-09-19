package com.kdpm.school_textbook_management_system.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradeDTO {
    private int gradeId;
    private String gradeName;
}
