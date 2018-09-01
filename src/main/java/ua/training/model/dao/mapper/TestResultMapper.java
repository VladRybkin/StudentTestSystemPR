package ua.training.model.dao.mapper;

import ua.training.model.entity.TestResult;
import ua.training.model.entity.User;
import ua.training.service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TestResultMapper implements ObjectMapper<TestResult> {
    private UserService userService = new UserService();

    @Override
    public TestResult extractFromResultSet(ResultSet rs) throws SQLException {
        TestResult testResult = new TestResult();
        testResult.setId(rs.getInt("test_result_id"));
        testResult.setCategory(rs.getString("test_result_category"));
        testResult.setResult(rs.getDouble("test_result"));
        User user = userService.findById(rs.getInt("user_id"));
        testResult.setUser(user);
        return testResult;
    }

    @Override
    public TestResult makeUnique(Map<Integer, TestResult> cache, TestResult testResult) {
        cache.putIfAbsent(testResult.getId(), testResult);
        return cache.get(testResult.getId());
    }

    @Override
    public void setParameters(PreparedStatement ps, TestResult testResult) throws SQLException {
        ps.setString(1, testResult.getCategory());
        ps.setDouble(2, testResult.getResult());
        ps.setInt(3, testResult.getUser().getId());


    }
}
