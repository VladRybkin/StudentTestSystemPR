package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService=new UserService();
    @Test
    public void findById() {
        assertEquals(userService.findById(2).getId(), 2);
    }

    @Test
    public void findCoursesByUserId() {

    }

    @Test
    public void findAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void create() {
    }

    @Test
    public void close() {
    }
}