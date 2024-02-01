package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction , String> {
}
