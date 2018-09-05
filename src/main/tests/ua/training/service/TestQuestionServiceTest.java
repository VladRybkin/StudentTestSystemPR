package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestQuestionServiceTest {
    private TestQuestionService testQuestionService=new TestQuestionService();

    @Test
    public void findById() {
        assertEquals(testQuestionService.findById(6).getId(), 6);
    }

    @Test
    public void findAll() {
        assertTrue(testQuestionService.findAll().size()>0);

    }

    @Test
    public void findAllByCategory() {
        assertTrue(testQuestionService.findAllByCategory("'GEOGRAPHY'").size()>0);
    }


}