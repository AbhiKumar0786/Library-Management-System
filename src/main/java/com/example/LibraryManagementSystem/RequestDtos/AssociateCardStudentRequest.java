package com.example.LibraryManagementSystem.RequestDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociateCardStudentRequest {

    private Integer cardId;
    private Integer studentId;
}
