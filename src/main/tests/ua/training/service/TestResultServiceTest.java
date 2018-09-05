package ua.training.service;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class TestResultServiceTest {
    private TestResultService testResultService=new TestResultService();

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
        assertTrue(testResultService.findAll().size()>0);
    }

    @Test
    public void findAllByUserId() {
        assertTrue(testResultService.findAllByUserId(2, 1, Integer.MAX_VALUE).size()>0);
    }

}