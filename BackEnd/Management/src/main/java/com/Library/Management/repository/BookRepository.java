package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.management.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findBookByBookId(Integer bookId);
}
