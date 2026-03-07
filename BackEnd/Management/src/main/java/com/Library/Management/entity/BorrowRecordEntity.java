package com.library.management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BorrowRecord")
public class BorrowRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BORROWRECORDID")
    private int borrowRecordId;

    @Column(name ="BORROWDATE")
    private LocalDate borrowDate;
    
    @Column(name ="RETURNDATE")
    private LocalDate returnDate;

    @Column(name ="STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    private UsersEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKID")
    private BookEntity book;
    
}
