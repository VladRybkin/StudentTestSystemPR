package ua.training.controller.command;

import ua.training.model.entity.*;
import ua.training.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeographyTestCommand implements Command {

    private UserAnswerService userAnswerService = new UserAnswerService();
    private TestResultService testResultService = new TestResultService();


    @Override
    public String execute(HttpServletRequest request) {
        TestQuestionService testQuestionService = new TestQuestionService();
        User user = (User) request.getSession().getAttribute("userFromLogin");
        Test geographyTest = new Test("GEOGRAPHY");
        TestResult result = new TestResult();
        geographyTest.setQuestions(testQuestionService.findAllByCategory("'GEOGRAPHY'"));
        List<TestQuestion> questions = geographyTest.getQuestions();
        HttpSession session = request.getSession();
        List<UserAnswer> statistic = new ArrayList<>();
        String userAnswer1 = request.getParameter("userAnswer1");
        String userAnswer2 = request.getParameter("userAnswer2");
        String userAnswer3 = request.getParameter("userAnswer3");
        String userAnswer4 = request.getParameter("userAnswer4");
        String userAnswer5 = request.getParameter("userAnswer5");

        if (userAnswer1 != null && userAnswer2 != null && userAnswer3 != null && userAnswer4 != null && userAnswer5 != null) {
            addToStatistic(questions.get(0).getQuestion(), userAnswer1, questions.get(0).getAnswer(), statistic);
            addToStatistic(questions.get(1).getQuestion(), userAnswer2, questions.get(1).getAnswer(), statistic);
            addToStatistic(questions.get(2).getQuestion(), userAnswer3, questions.get(2).getAnswer(), statistic);
            addToStatistic(questions.get(3).getQuestion(), userAnswer4, questions.get(3).getAnswer(), statistic);
            addToStatistic(questions.get(4).getQuestion(), userAnswer5, questions.get(4).getAnswer(), statistic);
        }

        int count = getCorrectQuestions(checkAnswer(userAnswer1, questions.get(0).getAnswer()),
                checkAnswer(userAnswer2, questions.get(1).getAnswer()),
                checkAnswer(userAnswer3, questions.get(2).getAnswer()),
                checkAnswer(userAnswer4, questions.get(3).getAnswer()),
                checkAnswer(userAnswer5, questions.get(4).getAnswer()));

        if (user != null) {
            setUserToAnswers(statistic, user);
        }

        if (userAnswer1 != null && user != null) {
            setTestResult(result, count, user);
        }

        if (statistic.size() == 5) {
            try {
                addStatsToDatabase(statistic);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (userAnswer1 != null && userAnswer2 != null && userAnswer3 != null && userAnswer4 != null && userAnswer5 != null) {
            addTestResultToDatabase(result);
        }

        if (result.getCategory() != null) {
            session.setAttribute("result", result.getResult());
        }

        request.setAttribute("geographytest", questions);
        session.setAttribute("statistic", statistic);
        request.setAttribute("Gfirst", questions.get(0).getQuestion());
        request.setAttribute("Gsecond", questions.get(1).getQuestion());
        request.setAttribute("Gthird", questions.get(2).getQuestion());
        request.setAttribute("Gfourth", questions.get(3).getQuestion());
        request.setAttribute("Gfifth", questions.get(4).getQuestion());

        if (userAnswer1 != null && userAnswer2 != null && userAnswer3 != null && userAnswer4 != null && userAnswer5 != null) {
            return "redirect:/api/testResult";
        }

        return "/WEB-INF/pages/tests/geographyTest.jsp";
    }


    private boolean checkAnswer(String userAnswer, String correctAnswer) {

        return userAnswer != null && userAnswer.equals(correctAnswer);
    }

    private void addToStatistic(String testQuestion, String userAnswer, String correctAnswer, List<UserAnswer> userAnswers) {
        UserAnswer answer = new UserAnswer(testQuestion, userAnswer, correctAnswer);
        userAnswers.add(answer);
    }

    private void setTestResult(TestResult result, int count, User user) {
        result.setCategory("GEOGRAPHY");
        result.setUser(user);
        result.setResult(count == 0 ? 0 : 100d / (5d / count));

    }

    private void setUserToAnswers(List<UserAnswer> statistic, User user) {
        for (UserAnswer answer : statistic) {
            answer.setUser(user);
        }
    }

    private void addStatsToDatabase(List<UserAnswer> statistic) throws SQLException {
        userAnswerService.insertUserAnswers(statistic.get(0), statistic.get(1), statistic.get(2), statistic.get(3), statistic.get(4));
    }

    private int getCorrectQuestions(boolean... answers) {
        int count = 0;
        for (boolean answer : answers) {
            if (answer) {
                count++;
            }
        }
        return count;
    }


    private void addTestResultToDatabase(TestResult result) {
        testResultService.create(result);
    }


}