package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Entities.LibraryCard;
import com.example.LibraryManagementSystem.Entities.Transaction;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Enums.TransactionType;
import com.example.LibraryManagementSystem.Exception.BookNotFoundException;
import com.example.LibraryManagementSystem.Exception.CardNotFoundException;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.CardRepository;
import com.example.LibraryManagementSystem.Repository.TransactionRepository;
import jakarta.transaction.Synchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    public String issueBook(Integer cardId , Integer bookId) throws Exception{
        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(TransactionStatus.ONGOING);
        transaction.setTransactionType(TransactionType.ISSUED);

        //1. Get the Book and Card Entity from the Db.
        Optional<Book> optionalBook =  bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("BookId entered is invalid!!");
        }

        Optional<LibraryCard> optionalLibraryCard  = cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw new CardNotFoundException("cardId entered is invalid!!");
        }

        Book book  = optionalBook.get();
        LibraryCard card  = optionalLibraryCard.get();
        //2. Validate Book Card Entity.

          // Check the Availability.
        if(book.getIsAvailable()==false){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("Book with the bookId is not Available. TransactionId "+transaction.getTransactionId());
        }
          //Check for max books issued.
        if(card.getNoOfBooksIssued()>=LibraryCard.MAX_NO_OF_ALLOWED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("You have reached the max number of issued books "+
                                " please return the book in order to issue the book."+
                                "TransactionId "+transaction.getTransactionId());
        }


        transaction.setTransactionStatus(TransactionStatus.SUCCESS);


        //3. Update the card and the Book Status.
         book.setIsAvailable(Boolean.FALSE);
         card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

         // Child class also have to need the attribute of parent class.
         transaction.setBook(book);
         transaction.setLibraryCard(card);

         //save the child as it will cascade to both of the parent.
         Transaction savedTransaction = transactionRepository.save(transaction);

         return "Transaction has been saved with the transactionId "+savedTransaction.getTransactionId()+" in the Db";
    }
}
