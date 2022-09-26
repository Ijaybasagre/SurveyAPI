package com.myprojects.springboot.myfirstrestapi.survey;

import com.myprojects.springboot.myfirstrestapi.Question.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public ResponseEntity retrieveSurveys(){
        return new ResponseEntity(surveyService.getSurveys(), HttpStatus.OK);
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity retrieveSurvey(@PathVariable Long surveyId){
        return new ResponseEntity(surveyService.getSurvey(surveyId),HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity createNewSurvey(@RequestBody Survey survey){
        return new ResponseEntity(surveyService.createNewSurvey(survey),HttpStatus.CREATED);
    }

    @PutMapping("/{surveyId}")
    public ResponseEntity updateSurvey(@PathVariable Long surveyId,
                                       @RequestBody Survey survey){
        return new ResponseEntity(surveyService.updateSurvey(surveyId,survey),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{surveyId}")
    public ResponseEntity deleteSurvey(@PathVariable Long surveyId){
        surveyService.deleteSurvey(surveyId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{surveyId}/questions/{questionId}")
    public ResponseEntity addSurveyQuestion(@PathVariable Long surveyId,
                                            @PathVariable Long questionId){
        return new ResponseEntity(surveyService.addSurveyQuestion(surveyId,questionId)
                                    ,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{surveyId}/questions/{questionId}")
    public ResponseEntity updateSurveyQuestion(@PathVariable Long surveyId,
                                               @PathVariable Long questionId,
                                               @RequestBody Question question){
        return new ResponseEntity(surveyService.updateSurveyQuestion(surveyId,questionId,question)
                ,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{surveyId}/questions/{questionId}")
    public ResponseEntity deleteSurveyQuestion(@PathVariable Long surveyId,
                                               @PathVariable Long questionId){
        surveyService.deleteSurveyQuestion(surveyId,questionId);
        return ResponseEntity.noContent().build();
    }

}
