package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {

}
