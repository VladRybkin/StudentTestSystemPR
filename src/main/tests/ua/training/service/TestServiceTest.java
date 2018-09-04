package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestServiceTest {
    TestService testService=new TestService();
    @Test
    public void create() {
    }

    @Test
    public void findById() {

    }

    @Test
    public void findAll()
    {assertTrue(testService.findAll().size()>0);
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