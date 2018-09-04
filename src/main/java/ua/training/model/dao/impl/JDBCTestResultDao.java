package ua.training.model.dao.impl;

import ua.training.model.dao.TestResultDao;
import ua.training.model.dao.mapper.TestResultMapper;
import ua.training.model.entity.TestResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class JDBCTestResultDao implements TestResultDao {
    private Connection connection;
    private TestResultMapper testResultMapper = new TestResultMapper();
    private static Logger log = Logger.getLogger(JDBCTestResultDao.class.getName());
    private final String createQuery = "INSERT INTO test_results(test_result_category,test_result, user_id)VALUES(?, ?, ?)";
    private final String findAllQuery = "SELECT * FROM test_results RIGHT JOIN users USING (user_id)";
    private final String findAllByUserId = "SELECT * FROM test_results RIGHT JOIN users USING (user_id) WHERE user_id=";
    private final String updateQuery = "UPDATE test_results SET test_result_category = ? , test_result = ? WHERE test_result_id =";
    private final String deleteQuery = "DELETE FROM test_results  WHERE test_result_id = ?";


    JDBCTestResultDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(TestResult testResult) {
        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            testResultMapper.setParameters(ps, testResult);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }

    @Override
    public TestResult findById(int id) {
        return null;
    }

    @Override
    public List<TestResult> findAll() {
        Map<Integer, TestResult> testResults = new HashMap<>();
        Extract(testResults, findAllQuery);
        return new ArrayList<>(testResults.values());
    }
    @Override
    public List<TestResult> findAllWithLimit(int from, int to) {
        Map<Integer, TestResult> testResults = new HashMap<>();
        Extract(testResults, findAllQuery+" limit "+ from+", "+to);
        return new ArrayList<>(testResults.values());
    }

    @Override
    public List<TestResult> findAllByUserId(int id, int from, int to) {
        Map<Integer, TestResult> testResults = new HashMap<>();
        Extract(testResults, findAllByUserId + id+" limit "+ from+", "+to);
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
            log.log(org.apache.log4j.Level.INFO, e);
        }
    }

    @Override
    public void update(TestResult testResult, int id) {
        try (PreparedStatement ps = connection.prepareStatement(updateQuery + id)) {
            testResultMapper.setParameters(ps, testResult);
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
