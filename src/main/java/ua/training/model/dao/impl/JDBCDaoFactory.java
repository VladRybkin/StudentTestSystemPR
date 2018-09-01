package ua.training.model.dao.impl;

import ua.training.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public CourseDao createCourseDao() {
        return new JDBCCourseDao(getConnection());
    }


    @Override
    public TestDao createTestDao() {
        return new JDBCTestDao(getConnection());
    }

    @Override
    public TestQuestionDao createTestQuestionDao() {
        return new JDBCTestQuestionDao(getConnection());
    }

    @Override
    public TestResultDao createTestResultDao() {
        return new JDBCTestResultDao(getConnection());
    }

    @Override
    public UserAnswerDao createUserAnswerDao() {
        return new JDBCUserAnswerDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
