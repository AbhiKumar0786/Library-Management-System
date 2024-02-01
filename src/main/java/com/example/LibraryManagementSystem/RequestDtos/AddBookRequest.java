package com.example.LibraryManagementSystem.RequestDtos;

import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddBookRequest {

    private String bookName;

    private Genre bookGenre;

    private int noOfPages;

    private int price;

    private Date publishDate;

    private Integer authorId;
}
