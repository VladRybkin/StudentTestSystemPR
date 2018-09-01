package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int id;
    private String category;
    private List<TestQuestion> questions= new ArrayList<>();

    public Test() {
    }

    public Test(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TestQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", category=" + category +
                ", questions=" + questions +
                '}';
    }
}
