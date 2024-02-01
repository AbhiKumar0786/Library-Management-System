package com.example.LibraryManagementSystem.RequestDtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyPhnNoRequest {

    private Integer studentId;
    private String newPhnNo;
}
