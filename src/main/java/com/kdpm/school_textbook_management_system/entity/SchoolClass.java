package com.kdpm.school_textbook_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_class_id")
    private int schoolClassId;

    @Column(name = "school_class_name", unique = true)
    private String schoolClassName;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable=false)
    private Grade grade;

    @OneToMany(mappedBy="schoolClass")
    private Set<Student> students;

}
