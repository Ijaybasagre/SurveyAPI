package com.myprojects.springboot.myfirstrestapi.Question;

import com.myprojects.springboot.myfirstrestapi.Option.Option;
import com.myprojects.springboot.myfirstrestapi.survey.Survey;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String correctAnswer;

    @OneToMany(mappedBy = "question")
    private Set<Option> options;

    @ManyToOne
    private Survey survey;

    public Question() {
    }

    public Question(String description, String correctAnswer) {
        this.description = description;
        this.correctAnswer = correctAnswer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
