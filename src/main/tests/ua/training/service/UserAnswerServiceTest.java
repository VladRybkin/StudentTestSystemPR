package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAnswerServiceTest {
    private UserAnswerService userAnswerService=new UserAnswerService();
    @Test
    public void create() {
    }

    @Test
    public void insertUserAnswers() {
    }

    @Test
    public void findById() {
       assertEquals(userAnswerService.findById(8).getId(), 8);
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

    @Test
    public void findAll() {
        assertTrue(userAnswerService.findAll().size()>0);
    }

    @Test
    public void findAllByUserId() {
        assertTrue(userAnswerService.findAllByUserId(2).size()>0);
    }
}