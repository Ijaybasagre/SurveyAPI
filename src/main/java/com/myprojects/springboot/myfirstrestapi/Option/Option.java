package com.myprojects.springboot.myfirstrestapi.Option;

import com.myprojects.springboot.myfirstrestapi.Question.Question;
import jakarta.persistence.*;

@Entity
public class Option {

    @Id
    @GeneratedValue
    private Long id;
    private String phrase;

    @ManyToOne
    private Question question;

    public Option() {
    }

    public Option(String phrase) {
        this.phrase = phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Long getId() {
        return id;
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", phrase='" + phrase + '\'' +
                '}';
    }
}
