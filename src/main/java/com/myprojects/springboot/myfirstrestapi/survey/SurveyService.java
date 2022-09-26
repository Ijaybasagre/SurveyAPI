package com.myprojects.springboot.myfirstrestapi.survey;

import com.myprojects.springboot.myfirstrestapi.Question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> retrieveList(){
        return surveyRepository.findAll();
    }

    public Survey retrieveSurveyById(Long surveyId){
        Optional<Survey> optionalSurvey = surveyRepository.findById(surveyId);
        if(optionalSurvey.isEmpty()) return null;
        return  optionalSurvey.get();
    }



}
