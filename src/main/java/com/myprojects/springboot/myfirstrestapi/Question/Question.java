package com.myprojects.springboot.myfirstrestapi.Question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myprojects.springboot.myfirstrestapi.Option.Choice;
import com.myprojects.springboot.myfirstrestapi.survey.Survey;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Long question_id;
    private String description;
    private String correctAnswer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="survey_id")
    private Survey survey;

    @OneToMany
    @JoinColumn(name="question_id")
    private Set<Choice> choices;

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

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Long getId() {
        return question_id;
    }

    public String getDescription() {
        return description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", description='" + description + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", survey=" + survey +
                '}';
    }
}
