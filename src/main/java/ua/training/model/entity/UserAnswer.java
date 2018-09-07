package ua.training.model.entity;

public class UserAnswer {
    private int id;
    private String testQuestion;
    private String userAnswer;
    private String correctAnswer;
    private User user;

    public UserAnswer() {
    }

    public UserAnswer(String testQuestion, String userAnswer, String correctAnswer) {
        this.testQuestion = testQuestion;
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAnswer that = (UserAnswer) o;

        if (id != that.id) return false;
        if (testQuestion != null ? !testQuestion.equals(that.testQuestion) : that.testQuestion != null) return false;
        if (userAnswer != null ? !userAnswer.equals(that.userAnswer) : that.userAnswer != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(that.correctAnswer) : that.correctAnswer != null)
            return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (testQuestion != null ? testQuestion.hashCode() : 0);
        result = 31 * result + (userAnswer != null ? userAnswer.hashCode() : 0);
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
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
