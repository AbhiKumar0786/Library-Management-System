package com.example.LibraryManagementSystem.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String authorName;

    private int authorAge;

    @Column(unique = true)
    private String emailId;

    private int noOfBooksWritten;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList  = new ArrayList<>();

    public Author(String authorName, int authorAge, String emailId) {
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.emailId = emailId;
    }
}
