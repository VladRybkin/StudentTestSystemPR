package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseServiceTest {
    CourseService courseService=new CourseService();
    @Test
    public void create() {
    }

    @Test
    public void insertStudentCourses() {
    }

    @Test
    public void findById() {
        assertEquals(courseService.findById(3).getId(), 3);
    }

    @Test
    public void findAll() {
        assertTrue(courseService.findAll().size()>0);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void close() {

    }
}