package ua.training.model.entity;

public class UserAnswer {
    private int id;
    private String testQuestion;
    private String userAnswer;
    private String correctAnswer;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestQuestion() {
        return testQuestion;
    }

    public void setTestQuestion(String testQuestion) {
        this.testQuestion = testQuestion;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "id=" + id +
                ", testQuestion='" + testQuestion + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", user=" + user +
                '}';
    }
}
