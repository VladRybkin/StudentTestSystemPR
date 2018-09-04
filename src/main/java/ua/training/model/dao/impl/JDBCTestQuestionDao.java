package ua.training.model.dao.impl;

import ua.training.model.dao.TestQuestionDao;
import ua.training.model.dao.mapper.TestQuestionMapper;
import ua.training.model.entity.TestQuestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTestQuestionDao implements TestQuestionDao {
    private Connection connection;
    private TestQuestionMapper testQuestionMapper = new TestQuestionMapper();
    private static Logger log = Logger.getLogger(JDBCTestQuestionDao.class.getName());
    public JDBCTestQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(TestQuestion testQuestion) {
        final String query = "INSERT INTO test_questions(test_category,question,answer, test_id)VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            testQuestionMapper.setParameters(ps, testQuestion);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public TestQuestion findById(int id) {
        return null;
    }

    @Override
    public List<TestQuestion> findAll() {
        Map<Integer, TestQuestion> testQuestions = new HashMap<>();
        final String query = "SELECT * FROM test_questions";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                TestQuestion testQuestion = testQuestionMapper.extractFromResultSet(resultSet);
                testQuestion = testQuestionMapper.makeUnique(testQuestions, testQuestion);
                testQuestions.put(testQuestion.getId(), testQuestion);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);

        }

        return new ArrayList<>(testQuestions.values());

    }

    @Override
    public List<TestQuestion> findAllByCategory(String category) {
        Map<Integer, TestQuestion> testQuestions = new HashMap<>();
        final String query = "SELECT * FROM test_questions WHERE test_category=" + category;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                TestQuestion testQuestion = testQuestionMapper.extractFromResultSet(resultSet);
                testQuestion = testQuestionMapper.makeUnique(testQuestions, testQuestion);
                testQuestions.put(testQuestion.getId(), testQuestion);
            }

            return new ArrayList<>(testQuestions.values());
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            return null;
        }
    }


    @Override
    public void update(TestQuestion testQuestion) {
        final String query = "UPDATE test_questions SET question = ? , answer= ?, test_category = ? WHERE test_question_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            testQuestionMapper.setParameters(ps, testQuestion);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM test_questions  WHERE test_question_id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }
}
