package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestResultServiceTest {
    private TestResultService testResultService=new TestResultService();
    @Test
    public void create() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
        assertTrue(testResultService.findAll().size()>0);
    }

    @Test
    public void findAllByUserId() {
        assertTrue(testResultService.findAllByUserId(2).size()>0);
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