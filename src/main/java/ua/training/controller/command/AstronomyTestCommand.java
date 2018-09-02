package ua.training.controller.command;

import ua.training.model.entity.*;
import ua.training.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AstronomyTestCommand implements Command {
    private TestQuestionService testQuestionService = new TestQuestionService();
    private UserAnswerService userAnswerService = new UserAnswerService();
    private TestResultService testResultService = new TestResultService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("userFromLogin");
        Test astronomyTest = new Test("ASTRONOMY");
        TestResult result = new TestResult();
        astronomyTest.setQuestions(testQuestionService.findAllByCategory("'ASTRONOMY'"));
        List<TestQuestion> questions = astronomyTest.getQuestions();
        HttpSession session = request.getSession();
        List<UserAnswer> statistic = new ArrayList<>();
        int count = 0;


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


        if (checkAnswer(userAnswer1, questions.get(0).getAnswer(), questions, 0)) {
            count++;
        }
        if (checkAnswer(userAnswer2, questions.get(1).getAnswer(), questions, 1)) {
            count++;
        }
        if (checkAnswer(userAnswer3, questions.get(2).getAnswer(), questions, 2)) {
            count++;
        }
        if (checkAnswer(userAnswer4, questions.get(3).getAnswer(), questions, 3)) {
            count++;
        }
        if (checkAnswer(userAnswer5, questions.get(4).getAnswer(), questions, 4)) {
            count++;
        }


        if (user != null) {
            setUserToAnswers(statistic, user);
        }
        if (user != null) {
            setUserToResult(result, user);
        }
        if (userAnswer1 != null) {
            setTestResult(result, count);
        }


        if (statistic.size() == 5) {
            addStatsToDatabase(statistic);
        }

        if (userAnswer1 != null) {
            addTestResultToDatabase(result);
        }


        request.setAttribute("testt", "testt");
        request.setAttribute("count", count);
        request.setAttribute("astronomyTest", questions);
        session.setAttribute("statistic", statistic);
        request.setAttribute("Gfirst", questions.get(0).getQuestion());
        request.setAttribute("Gsecond", questions.get(1).getQuestion());
        request.setAttribute("Gthird", questions.get(2).getQuestion());
        request.setAttribute("Gfourth", questions.get(3).getQuestion());
        request.setAttribute("Gfifth", questions.get(4).getQuestion());

        return "/WEB-INF/pages/tests/astronomyTest.jsp";
    }


    private boolean checkAnswer(String userAnswer, String correctAnswer, List<TestQuestion> questions, int questionId) {

        return userAnswer != null && userAnswer.equals(questions.get(questionId).getAnswer());
    }

    private void addToStatistic(String testQuestion, String userAnswer, String correctAnswer, List<UserAnswer> userAnswers) {
        UserAnswer answer = new UserAnswer();
        answer.setTestQuestion(testQuestion);
        answer.setUserAnswer(userAnswer);
        answer.setCorrectAnswer(correctAnswer);
        userAnswers.add(answer);
    }

    private void setTestResult(TestResult result, int count) {
        result.setCategory("Astronomy");
        result.setResult(count == 0 ? 0 : 100d / (5d / count));

    }

    private void setUserToAnswers(List<UserAnswer> statistic, User user) {
        for (UserAnswer answer : statistic) {
            answer.setUser(user);
        }
    }

    private void addStatsToDatabase(List<UserAnswer> statistic) {
        for (UserAnswer answer : statistic) {
            userAnswerService.create(answer);
        }
    }

    private void setUserToResult(TestResult result, User user) {
        result.setCategory("GEOGRAPHY");
        result.setUser(user);
    }

    private void addTestResultToDatabase(TestResult result) {
        testResultService.create(result);
    }
}