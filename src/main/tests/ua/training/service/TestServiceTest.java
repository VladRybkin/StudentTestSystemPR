package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestServiceTest {
    private TestService testService=new TestService();

    @Test
    public void findById() {

    }

    @Test
    public void findAll()
    {assertTrue(testService.findAll().size()>0);
    }


}