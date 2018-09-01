package ua.training.model.dao;


import ua.training.service.LoginService;
import ua.training.service.UserAnswerService;
import ua.training.model.entity.*;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        DaoFactory daoFactory=DaoFactory.getInstance();
        TestQuestionDao testQuestionDao=daoFactory.createTestQuestionDao();
        UserDao userDao=daoFactory.createUserDao();
        CourseDao courseDao=daoFactory.createCourseDao();
        TestDao testDao=daoFactory.createTestDao();
        TestResultDao testResultDao=daoFactory.createTestResultDao();
        UserAnswerDao statisticDao=daoFactory.createUserAnswerDao();
        LoginService loginService=new LoginService();
        UserAnswerService service=new UserAnswerService();
        UserAnswer userAnswer=new UserAnswer();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        System.out.println(resourceBundle.getString("db.driver"));
        System.out.println(userDao.getUserByLogin("Vlad"));
        Double res=100/(5/2d);
        System.out.println(userDao.getUserByLogin("TT4"));



    }
}
