package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.LibraryCard;
import com.example.LibraryManagementSystem.RequestDtos.AssociateCardStudentRequest;
import com.example.LibraryManagementSystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {


    @Autowired
    private CardService cardService;
    @PostMapping("/generatedCard")
    public String addCard(){
       return cardService.getFreshCard();
    }

    @PutMapping("/associateCardAndStudent")
    public ResponseEntity associateCardAndStudent(@RequestBody AssociateCardStudentRequest associateCardStudentRequest){

        try{
            String result  = cardService.associateCardAndStudent(associateCardStudentRequest);
            return new ResponseEntity(result , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
