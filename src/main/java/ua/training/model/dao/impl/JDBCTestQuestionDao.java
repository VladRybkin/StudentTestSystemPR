package ua.training.model.dao.impl;

import ua.training.model.dao.TestQuestionDao;
import ua.training.model.dao.mapper.TestQuestionMapper;
import ua.training.model.entity.TestQuestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class JDBCTestQuestionDao implements TestQuestionDao {
    private Connection connection;
    private TestQuestionMapper testQuestionMapper = new TestQuestionMapper();
    private static Logger log = Logger.getLogger(JDBCTestQuestionDao.class.getName());
    private final String createQuery = "INSERT INTO test_questions(test_category,question,answer, test_id)VALUES(?, ?, ?, ?)";
    private final String findAllQuery = "SELECT * FROM test_questions";
    private final String findAllByCategoryQuery = "SELECT * FROM test_questions WHERE test_category=";
    private final String updateQuery = "UPDATE test_questions SET question = ? , answer= ?, test_category = ? WHERE test_question_id = ";
    private final String deleteQuery = "DELETE FROM test_questions  WHERE test_question_id = ?";

    JDBCTestQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(TestQuestion testQuestion) {
        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            testQuestionMapper.setParameters(ps, testQuestion);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }

    @Override
    public TestQuestion findById(int id) {
        return null;
    }

    @Override
    public List<TestQuestion> findAll() {
        Map<Integer, TestQuestion> testQuestions = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllQuery);
            while (resultSet.next()) {
                TestQuestion testQuestion = testQuestionMapper.extractFromResultSet(resultSet);
                testQuestion = testQuestionMapper.makeUnique(testQuestions, testQuestion);
                testQuestions.put(testQuestion.getId(), testQuestion);
            }
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);

        }
        return new ArrayList<>(testQuestions.values());

    }

    @Override
    public List<TestQuestion> findAllByCategory(String category) {
        Map<Integer, TestQuestion> testQuestions = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllByCategoryQuery + category);
            while (resultSet.next()) {
                TestQuestion testQuestion = testQuestionMapper.extractFromResultSet(resultSet);
                testQuestion = testQuestionMapper.makeUnique(testQuestions, testQuestion);
                testQuestions.put(testQuestion.getId(), testQuestion);
            }
            return new ArrayList<>(testQuestions.values());
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
            return null;
        }
    }


    @Override
    public void update(TestQuestion testQuestion, int id) {
        try (PreparedStatement ps = connection.prepareStatement(updateQuery+id)) {
            testQuestionMapper.setParameters(ps, testQuestion);
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
