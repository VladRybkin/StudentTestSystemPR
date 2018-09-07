package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String category;
    private String status;
    private List<User> users = new ArrayList<>();


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (category != null ? !category.equals(course.category) : course.category != null) return false;
        if (status != null ? !status.equals(course.status) : course.status != null) return false;
        return users != null ? users.equals(course.users) : course.users == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                '}';
    }
}
