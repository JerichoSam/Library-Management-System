package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.management.entity.BorrowRecordEntity;

@Repository
public interface BorrowRecord extends JpaRepository<BorrowRecordEntity, Integer>{

    List<BorrowRecordEntity> findBorrowRecordByBorrowRecordId(Integer borrowRecordId);
}
