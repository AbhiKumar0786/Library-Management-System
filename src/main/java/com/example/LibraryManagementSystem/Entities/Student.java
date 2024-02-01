package com.example.LibraryManagementSystem.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="student") // if you will not define the table name then it will class name by default.
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id //Used to tell this is a primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String name;

    private String branch;

    private double cgpa;

    private String phoneNo;

    /*
       mappedBy contains the value of variable name : Child Table F.K. variable name.
     */
    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}
