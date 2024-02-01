package com.example.LibraryManagementSystem.RequestDtos;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddAuthorRequest {

    private String authorName;

    private int authorAge;

    private String emailId;
}
