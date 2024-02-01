package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.RequestDtos.ModifyPhnNoRequest;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ResourceBundle;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String result  = studentService.addStudent(student);
        return new ResponseEntity<>(result , HttpStatus.CREATED);
    }

    @GetMapping("/findBYId")
    public ResponseEntity findStudentById(@RequestParam("studentId") Integer studentId){

        try {
            Student student = studentService.findStudentById(studentId);
            return new ResponseEntity(student , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modifyPhnNo")
    public String modifyPhnNo(@RequestBody ModifyPhnNoRequest modifyPhnNoRequest){
      return studentService.modifyPhnNo(modifyPhnNoRequest);
    }
}

