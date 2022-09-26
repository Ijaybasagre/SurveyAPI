package com.myprojects.springboot.myfirstrestapi.survey;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public ResponseEntity retrieveSurveys(){
        return new ResponseEntity( surveyService.retrieveList(),HttpStatus.ACCEPTED);
    }
}
