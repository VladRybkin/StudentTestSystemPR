package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String login;
    private String password;
    private Role role;
    private String email;
    private List<Course> courses = new ArrayList<>();
    private List<TestResult> testResults = new ArrayList<>();
    private List<UserAnswer> userAnswers = new ArrayList<>();

    public enum Role {
        ADMIN, STUDENT, UNKNOWN
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }

    public List<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != user.role) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (courses != null ? !courses.equals(user.courses) : user.courses != null) return false;
        if (testResults != null ? !testResults.equals(user.testResults) : user.testResults != null) return false;
        return userAnswers != null ? userAnswers.equals(user.userAnswers) : user.userAnswers == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        result = 31 * result + (testResults != null ? testResults.hashCode() : 0);
        result = 31 * result + (userAnswers != null ? userAnswers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                ", testResults=" + testResults +
                ", userAnswers=" + userAnswers +
                '}';
    }

}
