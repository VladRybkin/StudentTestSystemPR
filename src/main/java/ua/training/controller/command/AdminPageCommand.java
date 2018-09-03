package ua.training.controller.command;

import ua.training.model.entity.TestResult;
import ua.training.model.entity.User;
import ua.training.service.TestResultService;
import ua.training.service.UserService;
import ua.training.service.comparators.TestResultComparator;
import ua.training.service.comparators.UserComparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AdminPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserService();
        TestResultService testResultService =new TestResultService();
        List<User> users=userService.findAll();
        List<TestResult>testResults= testResultService.findAll();
        Collections.sort(testResults, new TestResultComparator());
        Collections.sort(users, new UserComparator());

        request.setAttribute("testResults", testResults);
        request.setAttribute("studentStats", users);
        return "/WEB-INF/pages/adminPages/admin_page.jsp";
    }
}
