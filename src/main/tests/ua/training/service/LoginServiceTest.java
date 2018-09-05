package ua.training.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private LoginService loginService=new LoginService();
    @Test
    public void getUserByLoginAndPass() {
        assertEquals(loginService.getUserByLoginAndPass("Vlad", "admin").getId(), 1);
    }
}