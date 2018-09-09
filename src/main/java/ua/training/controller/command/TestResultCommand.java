package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;


public class TestResultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return "/WEB-INF/pages/tests/testResult.jsp";
    }
}
