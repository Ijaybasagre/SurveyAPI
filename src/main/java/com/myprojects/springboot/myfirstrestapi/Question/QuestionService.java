package com.myprojects.springboot.myfirstrestapi.Question;

import com.myprojects.springboot.myfirstrestapi.Option.Choice;
import com.myprojects.springboot.myfirstrestapi.Option.ChoiceService;
import com.myprojects.springboot.myfirstrestapi.survey.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ChoiceService choiceService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, ChoiceService choiceService) {
        this.questionRepository = questionRepository;
        this.choiceService = choiceService;

    }

    public List<Question> retrieveAll() {
        return  questionRepository.findAll();
    }

    public Question retrieveQuestionById(Long questionId){
        return questionRepository.findById(questionId)
                .orElseThrow(
                        ()-> new RuntimeException(questionId+" not found")
                );
    }

    public Question createNewQuestion(Question question){
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long questionId, Question question){
        Question q = retrieveQuestionById(questionId);
        if(question.getDescription() != null)
            q.setDescription(question.getDescription());
        if(question.getCorrectAnswer() != null)
            q.setCorrectAnswer(question.getCorrectAnswer());
        return questionRepository.save(q);
    }

    public void deleteQuestion(Long questionId){
        questionRepository.deleteById(questionId);
    }

    public Question addQuestionChoices(Long questionId, Long choicesId) {
        Question question = retrieveQuestionById(questionId);
        Choice choice = choiceService.retrieveChoiceById(choicesId);
        question.getChoices().add(choice);
        return questionRepository.save(question);
    }

    public Question updateSurveyQuestion(Long questionId, Long choicesId, @RequestBody Choice choice){
        Question question = retrieveQuestionById(questionId);
        question.getChoices().remove(choiceService.retrieveChoiceById(choicesId));

        Choice c = choiceService.updateOption(choicesId,choice);
        question.getChoices().add(c);

        return questionRepository.save(question);
    }

    public void deleteQuestionChoice(Long questionId, Long choiceId){
            choiceService.deleteChoice(choiceId);
    }
}
