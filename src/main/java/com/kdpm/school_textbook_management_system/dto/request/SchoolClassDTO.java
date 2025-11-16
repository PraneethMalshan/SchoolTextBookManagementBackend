package com.kdpm.school_textbook_management_system.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class SchoolClassDTO {
    private int schoolClassId;
    private String schoolClassName;
    private int gradeId;
}
