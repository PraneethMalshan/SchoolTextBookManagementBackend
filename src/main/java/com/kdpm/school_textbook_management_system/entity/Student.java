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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "admission_number")
    private int admissionNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "student_image")
    private String studentImage;

    @ManyToOne
    @JoinColumn(name="school_class_id", nullable=false)
    private SchoolClass schoolClass;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<BookAllocation> allocations;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "grade_id", referencedColumnName = "grade_id")
//    private Grade grade ;

}





