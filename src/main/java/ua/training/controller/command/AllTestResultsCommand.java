package ua.training.controller.command;

import ua.training.model.entity.TestResult;
import ua.training.service.TestResultService;
import ua.training.service.comparators.TestResultComparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllTestResultsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws IOException {
        TestResultService testResultService = new TestResultService();
        int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<TestResult> testResults = testResultService.findAllWithLimit((page - 1) * recordsPerPage, recordsPerPage);
        testResults.sort(new TestResultComparator());

        int noOfRecords = testResultService.findAll().size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("testResults", testResults);

        return "/WEB-INF/pages/adminPages/testResultsStatistic.jsp";
    }
}
