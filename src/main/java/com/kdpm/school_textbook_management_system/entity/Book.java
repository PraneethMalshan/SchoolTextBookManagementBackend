package com.kdpm.school_textbook_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", length = 100, nullable = false)
    private int bookId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "subject", length = 100, nullable = false)
    private String subject;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "book_image",length = 100, nullable = false)
    private String bookImage;

    @Column(name = "total_count",length = 100, nullable = false)
    private int totalCount;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "grade_id")
    private Grade grade;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookAllocation> allocations;

}
