package com.Library.Management.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "Books")
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "ID")
private int id;

@Column(name ="TITLE")
private String title;

@Column(name = "AUTHOR")
private String autor;

@Column(name = "CATEGORY")
private String category;

@Column(name = "AVAILABLE")
private Boolean isAvailable;

@Column(name = "CREATEDAT")
@GeneratedValue(strategy = GenerationType.AUTO)
private LocalDateTime createdAt;
}
