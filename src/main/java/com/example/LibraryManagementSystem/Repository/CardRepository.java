package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entities.LibraryCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard , Integer> {



}
