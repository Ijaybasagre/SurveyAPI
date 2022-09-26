package com.myprojects.springboot.myfirstrestapi.Question;

import com.myprojects.springboot.myfirstrestapi.Option.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity getAllQuestions(){
        return new ResponseEntity(questionService.retrieveAll()
                , HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity getQuestion(@PathVariable Long questionId){
        return new ResponseEntity(questionService.retrieveQuestionById(questionId)
                ,HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity addNewQuestion(@RequestBody Question question){
        return new ResponseEntity(questionService.createNewQuestion(question),
                                HttpStatus.CREATED);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable Long questionId,
                                         @RequestBody Question question){
        return new ResponseEntity(questionService.updateQuestion(questionId,question)
                                ,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable Long questionId){
        questionService.deleteQuestion(questionId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{questionId}/choices/{choicesId}")
    public ResponseEntity addSurveyQuestion(@PathVariable Long questionId,
                                            @PathVariable Long choicesId){
        return new ResponseEntity(questionService.addQuestionChoices(questionId,choicesId)
                ,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{questionId}/choices/{choicesId}")
    public ResponseEntity updateQuestionChoice(@PathVariable Long questionId,
                                               @PathVariable Long choicesId,
                                               @RequestBody Choice choice){
        return new ResponseEntity(questionService.updateSurveyQuestion(questionId,choicesId,choice)
                ,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{questionId}/choices/{choicesId}")
    public ResponseEntity deleteSurveyQuestion(@PathVariable Long questionId,
                                               @PathVariable Long choicesId){
        questionService.deleteQuestionChoice(questionId,choicesId);
        return ResponseEntity.noContent().build();
    }

}
