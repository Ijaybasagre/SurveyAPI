package com.myprojects.springboot.myfirstrestapi.Option;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myprojects.springboot.myfirstrestapi.Question.Question;
import jakarta.persistence.*;

@Entity
public class Choice{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Long option_id;
    private String phrase;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Choice(){}
    public Choice(String phrase) {
        this.phrase = phrase;
    }
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return option_id;
    }

    public String getPhrase() {
        return phrase;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + option_id +
                ", phrase='" + phrase + '\'' +
                '}';
    }
}
