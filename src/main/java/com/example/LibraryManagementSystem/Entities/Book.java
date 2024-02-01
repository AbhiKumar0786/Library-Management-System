package com.example.LibraryManagementSystem.Entities;


import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int bookId;

   @Column(unique = true)
   private String bookName;

   @Enumerated(value = EnumType.STRING)
   private Genre bookGenre;

   private int noOfPages;

   private int price;

   private Date publishDate;

   private Boolean isAvailable;

   @JoinColumn  // This is the method to write F.K. in this child class.
   @ManyToOne   // The relationship between book and author is many To One.
   private Author author;

   @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
   private List<Transaction> transactionList  = new ArrayList<>();
   public Book(String bookName, Genre bookGenre, int noOfPages, int price, Date publishDate) {
      this.bookName = bookName;
      this.bookGenre = bookGenre;
      this.noOfPages = noOfPages;
      this.price = price;
      this.publishDate = publishDate;
   }
}
