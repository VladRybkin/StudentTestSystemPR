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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestResult that = (TestResult) o;

        if (id != that.id) return false;
        if (Double.compare(that.result, result) != 0) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        result1 = id;
        result1 = 31 * result1 + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(result);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        result1 = 31 * result1 + (user != null ? user.hashCode() : 0);
        return result1;
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
