package com.kdpm.school_textbook_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int gradeId;

    @Column(name = "grade_name")
    private String gradeName;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private Set<Class> classes;

    @OneToOne(mappedBy = "grade")
    private Student student;

}
