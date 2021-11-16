package com.example.demo.InterviewTest;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class InterviewTest {
    private @Id @GeneratedValue Long id;
    private String name;
    private String domain;
    private String difficulty;
    private String questionSet;

    InterviewTest(){}

    InterviewTest(String name, String domain, String difficulty, String questionSet){
        this.name        = name;
        this.domain      = domain;
        this.difficulty  = difficulty;
        this.questionSet = questionSet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(String questionSet) {
        this.questionSet = questionSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof InterviewTest))
            return false;
        InterviewTest test = (InterviewTest) o;
        return Objects.equals(this.id, test.id) && Objects.equals(this.name, test.name)
                && Objects.equals(this.domain, test.domain) && Objects.equals(this.difficulty, test.difficulty)
                && Objects.equals(this.questionSet, test.questionSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.domain, this.difficulty, this.questionSet);
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + this.id + ", name='" + this.name + '\''
                + ", domain='" + this.domain + '\''
                + ", difficulty='" + this.difficulty + '\'' + '}';
    }
}
