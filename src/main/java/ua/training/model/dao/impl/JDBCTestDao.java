package ua.training.model.dao.impl;

import ua.training.model.dao.TestDao;
import ua.training.model.dao.mapper.TestMapper;
import ua.training.model.dao.mapper.TestQuestionMapper;
import ua.training.model.entity.Test;
import ua.training.model.entity.TestQuestion;

import java.sql.*;
import java.util.*;

public class JDBCTestDao implements TestDao {
    private Connection connection;
    private TestMapper testMapper = new TestMapper();

    public JDBCTestDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Test test) {
        final String query = "INSERT INTO tests(`test_category`)VALUES(?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            testMapper.setParameters(ps, test);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        final String query = "SELECT * FROM tests LEFT JOIN test_questions USING(test_id)";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

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
            e.printStackTrace();

        }

        return new ArrayList<>(tests.values());

    }

    @Override
    public void update(Test test) {
        final String query = "UPDATE tests SET test_category = ? WHERE test_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            testMapper.setParameters(ps, test);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM tests WHERE test_id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
