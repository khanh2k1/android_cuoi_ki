package com.example.thi_cuoi_ki.models;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import java.util.List;

public class Question {

    @BsonId
    private ObjectId id;
    private String content;
    private List<String> answers;
    private int correctAnswer;

    public Question() {
    }

    public Question(ObjectId id, String content, List<String> answers, int correctAnswer) {
        this.id = id;
        this.content = content;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
