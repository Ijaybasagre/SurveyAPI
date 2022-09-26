package com.myprojects.springboot.myfirstrestapi.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choices")
public class ChoiceController {

    private final ChoiceService choiceService;

    @Autowired
    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping
    public ResponseEntity getAllOptions(){
        return new ResponseEntity(  choiceService.retrieveAllChoices(), HttpStatus.OK);
    }

    @GetMapping("/{choiceId}")
    public ResponseEntity getOption(@PathVariable Long choiceId){
        return new ResponseEntity(choiceService.retrieveChoiceById(choiceId)
                ,HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity addNewOption(@RequestBody Choice choice){
        return new ResponseEntity(choiceService.createNewChoice(choice),
                HttpStatus.CREATED);
    }

    @PutMapping("/{choiceId}")
    public ResponseEntity updateOption(@PathVariable Long choiceId,
                                         @RequestBody Choice choice){
        return new ResponseEntity(choiceService.updateOption(choiceId,choice)
                ,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{choiceId}")
    public ResponseEntity deleteOption(@PathVariable Long choiceId){
        choiceService.deleteChoice(choiceId);
        return ResponseEntity.noContent().build();
    }
}
