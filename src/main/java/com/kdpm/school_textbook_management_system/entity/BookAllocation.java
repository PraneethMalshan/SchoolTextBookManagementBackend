package com.kdpm.school_textbook_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book_allocation")
public class BookAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_allocation_id")
    private int bookAllocationId;

    @Column(name = "allocated_date", columnDefinition = "DATETIME")
    private Date allocatedDate;

    @Column(name = "return_date", columnDefinition = "DATETIME")
    private Date returnDate;

    @Column(name = "allocation_status", length = 100, nullable = false)
    private String status;

}
