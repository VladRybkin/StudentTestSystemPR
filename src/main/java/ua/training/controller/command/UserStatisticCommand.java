package ua.training.controller.command;

import ua.training.model.entity.TestResult;
import ua.training.model.entity.User;
import ua.training.model.entity.UserAnswer;
import ua.training.service.TestResultService;
import ua.training.service.UserAnswerService;
import ua.training.service.comparators.TestResultComparator;
import ua.training.service.comparators.UserAnswerComparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserStatisticCommand implements Command {
    private TestResultService testResultService=new TestResultService();
    private UserAnswerService userAnswerService=new UserAnswerService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int page = 1;
        int recordsPerPage = 10;
        if(request.getParameter("page") != null)
        {page = Integer.parseInt(request.getParameter("page"));}

        User user=(User) request.getSession().getAttribute("userFromLogin");
        List<TestResult>testResults=testResultService.findAllByUserId(user.getId());
        List<UserAnswer>userAnswers=userAnswerService.findAllByUserId(user.getId());
        Collections.sort(userAnswers, new UserAnswerComparator());
        Collections.sort(testResults, new TestResultComparator());

        int noOfRecords=userAnswers.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);


        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);

        request.setAttribute("userStatistic", testResults);
        request.setAttribute("userAnswerStatistic", userAnswers);


        return "/WEB-INF/pages/statistic/user_statistic.jsp";
    }
}
