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
    private String TEST_RESULT_ID="test_result_id";
    private String TEST_RESULT_CATEGORY="test_result_category";
    private String TEST_RESULT="test_result";
    private String USER_ID="user_id";

    @Override
    public TestResult extractFromResultSet(ResultSet rs) throws SQLException {
        TestResult testResult = new TestResult();
        testResult.setId(rs.getInt(TEST_RESULT_ID));
        testResult.setCategory(rs.getString(TEST_RESULT_CATEGORY));
        testResult.setResult(rs.getDouble(TEST_RESULT));
        User user = userService.findById(rs.getInt(USER_ID));
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
