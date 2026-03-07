package com.library.management.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "Books")
public class BookEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "BOOKID")
private int bookId;

@Column(name ="TITLE")
private String title;

@Column(name = "AUTHOR")
private String autor;

@Column(name = "CATEGORY")
private String category;

@Column(name = "AVAILABLE")
private Boolean isAvailable;

@Column(name = "CREATEDAT")
private LocalDateTime createdAt;

@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<BorrowRecordEntity> borrowRecord =new HashSet<>();

@PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
