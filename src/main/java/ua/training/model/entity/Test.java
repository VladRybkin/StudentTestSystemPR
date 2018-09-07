package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int id;
    private String category;
    private List<TestQuestion> questions = new ArrayList<>();

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        if (category != null ? !category.equals(test.category) : test.category != null) return false;
        return questions != null ? questions.equals(test.questions) : test.questions == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (questions != null ? questions.hashCode() : 0);
        return result;
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
