package com.hz.ideaweb.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@SuppressWarnings("serial")
public class Scores implements Serializable {
    int studentId;
    int subjectId;
    String score;
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }


}
