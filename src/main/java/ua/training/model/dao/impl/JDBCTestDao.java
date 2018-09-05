package ua.training.model.dao.impl;

import ua.training.model.dao.TestDao;
import ua.training.model.dao.mapper.TestMapper;
import ua.training.model.dao.mapper.TestQuestionMapper;
import ua.training.model.entity.Test;
import ua.training.model.entity.TestQuestion;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

public class JDBCTestDao implements TestDao {
    private Connection connection;
    private static Logger log = Logger.getLogger(JDBCTestDao.class.getName());
    private TestMapper testMapper = new TestMapper();
    private final String createQuery = "INSERT INTO tests(`test_category`)VALUES(?)";
    private final String findAllQuery = "SELECT * FROM tests LEFT JOIN test_questions USING(test_id)";
    private final String updateQuery = "UPDATE tests SET test_category = ? WHERE test_id = ";
    private final String deleteQuery = "DELETE FROM tests WHERE test_id = ?";

    JDBCTestDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Test test) {
        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            testMapper.setParameters(ps, test);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }

    @Override
    public Test findById(int id) {
        return null;
    }

    @Override
    public List<Test> findAll() {
        Map<Integer, Test> tests = new HashMap<>();
        Map<Integer, TestQuestion> testQuestions = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllQuery);
            TestQuestionMapper testQuestionMapper = new TestQuestionMapper();
            while (resultSet.next()) {
                Test test = testMapper.extractFromResultSet(resultSet);
                TestQuestion testQuestion = testQuestionMapper.extractFromResultSet(resultSet);
                test = testMapper.makeUnique(tests, test);
                testQuestion = testQuestionMapper.makeUnique(testQuestions, testQuestion);
                test.getQuestions().add(testQuestion);
                tests.put(test.getId(), test);
            }
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
        return new ArrayList<>(tests.values());

    }

    @Override
    public void update(Test test, int id) {
        try (PreparedStatement ps = connection.prepareStatement(updateQuery + id)) {
            testMapper.setParameters(ps, test);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }
}
