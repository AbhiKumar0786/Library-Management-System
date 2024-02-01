package com.example.LibraryManagementSystem.Services;


import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.RequestDtos.ModifyPhnNoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student){

         Student SavedStudent = studentRepository.save(student);
        return "The Student saved into the DB studentId "+SavedStudent.getStudentId();
    }

    public Student findStudentById(Integer studentId) throws Exception{

        Optional<Student> optionalStudent  = studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()){

            throw new Exception("Student Id entered is incorrect !!");

        }

        return optionalStudent.get();
    }

    public String modifyPhnNo(ModifyPhnNoRequest modifyPhnNoRequest){
        Integer studentId  = modifyPhnNoRequest.getStudentId();
        Student student  = studentRepository.findById(studentId).get();

        String newPhnNo  = modifyPhnNoRequest.getNewPhnNo();
        student.setPhoneNo(newPhnNo);
        studentRepository.save(student);

        return "Phone No has been modified.";
    }
}
