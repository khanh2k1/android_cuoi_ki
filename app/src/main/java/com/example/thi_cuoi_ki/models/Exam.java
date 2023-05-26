package com.example.thi_cuoi_ki.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

public class Exam implements Serializable {
    @BsonId
    private ObjectId id;
    private String name, decription;
    private List<Question> questions;
    private boolean isPublic;
    private ObjectId createdBy;

    public Exam() {
    }

    public Exam(ObjectId id, String name, String decription, List<Question> questions, boolean isPublic, ObjectId createdBy) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.questions = questions;
        this.isPublic = isPublic;
        this.createdBy = createdBy;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public ObjectId getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ObjectId createdBy) {
        this.createdBy = createdBy;
    }
}
