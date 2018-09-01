package ua.training.model.dao.impl;

import ua.training.model.dao.TestResultDao;
import ua.training.model.dao.mapper.TestResultMapper;
import ua.training.model.entity.TestResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTestResultDao implements TestResultDao {
    private Connection connection;
    private TestResultMapper testResultMapper = new TestResultMapper();

    public JDBCTestResultDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(TestResult testResult) {
        final String query = "INSERT INTO test_results(test_result_category,test_result, user_id)VALUES(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            testResultMapper.setParameters(ps, testResult);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TestResult findById(int id) {
        return null;
    }

    @Override
    public List<TestResult> findAll() {
        Map<Integer, TestResult> testResults = new HashMap<>();
        final String query = "SELECT * FROM test_results RIGHT JOIN users USING (user_id)";

        Extract(testResults, query);

        return new ArrayList<>(testResults.values());

    }

    @Override
    public List<TestResult> findAllByUserId(int id) {
        Map<Integer, TestResult> testResults = new HashMap<>();
        final String query = "SELECT * FROM test_results RIGHT JOIN users USING (user_id) WHERE user_id=" + id;

        Extract(testResults, query);

        return new ArrayList<>(testResults.values());

    }

    private void Extract(Map<Integer, TestResult> testResults, String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                TestResult testResult = testResultMapper.extractFromResultSet(resultSet);
                testResult = testResultMapper.makeUnique(testResults, testResult);
                testResults.put(testResult.getId(), testResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    @Override
    public void update(TestResult testResult) {
        final String query = "UPDATE test_results SET test_result_category = ? , test_result = ? WHERE test_result_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            testResultMapper.setParameters(ps, testResult);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM test_results  WHERE test_result_id = ?")) {
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
