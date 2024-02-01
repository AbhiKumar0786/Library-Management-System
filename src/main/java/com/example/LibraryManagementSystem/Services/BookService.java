package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.RequestDtos.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;
    public String addBook(AddBookRequest addBookRequest){

        //1. Get the author Entity from authorId.
        Author author  = authorRepository.findById(addBookRequest.getAuthorId()).get();

        author.setNoOfBooksWritten(author.getNoOfBooksWritten()+1);

        //2. Get the book Entity from addBookRequest.
        Book newBook  = new Book(addBookRequest.getBookName() , addBookRequest.getBookGenre() , addBookRequest.getNoOfPages(),
                                                                 addBookRequest.getPrice(), addBookRequest.getPublishDate());
        // 3. Set the foreign key variables/Mapping variables.

          //3.1 Adding for the book the Author Entity.
            newBook.setAuthor(author); // Unidirectional Mapping.

          //3.2 for author add the book into the BookList.
            author.getBookList().add(newBook); // Bidirectional Mapping.

        authorRepository.save(author);

        return "New Book has been saved into the DB.";

    }
}
