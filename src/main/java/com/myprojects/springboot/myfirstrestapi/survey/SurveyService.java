    package com.myprojects.springboot.myfirstrestapi.survey;

import com.myprojects.springboot.myfirstrestapi.Option.ChoiceService;
import com.myprojects.springboot.myfirstrestapi.Question.Question;
import com.myprojects.springboot.myfirstrestapi.Question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;
    private final QuestionService questionService;
    @Autowired
    public SurveyService(SurveyRepository surveyRepository, QuestionService questionService) {
        this.surveyRepository = surveyRepository;
        this.questionService = questionService;
    }

    public List<Survey> getSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurvey(Long surveyId){
        return surveyRepository.findById(surveyId)
                .orElseThrow(
                        () -> new RuntimeException(surveyId+" not found")
                );
    }

    public Survey createNewSurvey(Survey survey){
        return surveyRepository.save(survey);
    }

    public Survey updateSurvey(Long surveyId, Survey survey){
        Survey s = getSurvey(surveyId);
        if(survey.getDescription() != null)
            s.setDescription(survey.getDescription());
        if(survey.getTitle() != null)
            s.setTitle(survey.getTitle());

        return surveyRepository.save(s);
    }

    public void deleteSurvey(Long surveyId){
        surveyRepository.deleteById(surveyId);
    }

    public Survey addSurveyQuestion(Long surveyId,Long questionId){
        Survey survey = getSurvey(surveyId);
        Question question = questionService.retrieveQuestionById(questionId);
        survey.addQuestion(question);
        return surveyRepository.save(survey);
    }

    public Survey updateSurveyQuestion(Long surveyId, Long questionId, @RequestBody Question question){
        Survey survey = getSurvey(surveyId);
        survey.getQuestions().remove(questionService.retrieveQuestionById(questionId));
        Question q = questionService.updateQuestion(questionId,question);
        survey.addQuestion(q);
        return surveyRepository.save(survey);
    }

    public void deleteSurveyQuestion(Long surveyId, Long questionId) {
        questionService.deleteQuestion(questionId);
    }

}
