package com.myprojects.springboot.myfirstrestapi.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myprojects.springboot.myfirstrestapi.Question.Question;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Survey {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Long survey_id;
    private String title;
    private String description;


    @OneToMany
    @JoinColumn(name = "survey_id")
    private Set<Question> questions;

    public Survey() {
    }

    public Survey(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Long getId() {
        return survey_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Survey{" +
                "id=" + survey_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
