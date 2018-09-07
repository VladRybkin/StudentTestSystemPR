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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestion that = (TestQuestion) o;

        if (id != that.id) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        return test != null ? test.equals(that.test) : that.test == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (test != null ? test.hashCode() : 0);
        return result;
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
