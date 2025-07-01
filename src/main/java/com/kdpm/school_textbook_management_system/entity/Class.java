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
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name")
    private String className;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable=false)
    private Grade grade;

    @OneToMany(mappedBy="classes")
    private Set<Student> students;


}
