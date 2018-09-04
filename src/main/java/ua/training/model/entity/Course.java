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
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                '}';
    }
}
