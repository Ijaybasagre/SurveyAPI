package com.myprojects.springboot.myfirstrestapi.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private final QuestionService optionService;

    public QuestionController(QuestionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping
    public ResponseEntity retrieveAllQuestions(){
        return new ResponseEntity(optionService.getAllQuestions(), HttpStatus.ACCEPTED);
    }
}
