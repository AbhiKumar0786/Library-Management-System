package com.example.LibraryManagementSystem.Entities;


import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    private TransactionStatus transactionStatus;

    @CreatedDate
    private Date createdOn;

    private int fineAmount;

    private TransactionType transactionType;

    @JoinColumn
    @ManyToOne
    private LibraryCard libraryCard;

    @JoinColumn
    @ManyToOne
    private Book book;
}
