package ua.training.model.entity;

public class TestQuestion {
    private int id;
    private String category;
    private String question;
    private String answer;
    private Test test;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", test=" + test +
                '}';
    }
}
