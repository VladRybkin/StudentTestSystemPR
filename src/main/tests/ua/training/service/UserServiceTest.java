package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService=new UserService();
    @Test
    public void findById() {
        assertEquals(userService.findById(2).getId(), 2);
    }

    @Test
    public void findCoursesByUserId() {
        assertTrue(userService.findById(1)!=null);
    }

    @Test
    public void findAll() {
        assertTrue(userService.findAll().size()>0);
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