package ua.training.model.entity;

public class TestResult {
    private int id;
    private String category;
    private double result;
    private User user;

    public TestResult() {
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

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", result=" + result +
                ", user=" + user +
                '}';
    }
}
