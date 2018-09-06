package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestResultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws IOException {

        return "/WEB-INF/pages/tests/testResult.jsp";
    }
}
