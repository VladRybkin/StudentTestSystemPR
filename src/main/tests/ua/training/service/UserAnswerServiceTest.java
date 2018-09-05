package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAnswerServiceTest {
    private UserAnswerService userAnswerService = new UserAnswerService();

    @Test
    public void findById() {
        assertEquals(userAnswerService.findById(8).getId(), 8);
    }

    @Test
    public void findAll() {
        assertTrue(userAnswerService.findAll().size() > 0);
    }

    @Test
    public void findAllByUserId() {
        assertTrue(userAnswerService.findAllByUserId(2, 1, Integer.MAX_VALUE).size() > 0);
    }
}