package ua.training.model.dao.mapper;

import ua.training.model.entity.TestQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TestQuestionMapper implements ObjectMapper<TestQuestion> {
    @Override
    public TestQuestion extractFromResultSet(ResultSet rs) throws SQLException {
        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setId(rs.getInt("test_question_id"));
        testQuestion.setCategory(rs.getString("test_category"));
        testQuestion.setQuestion(rs.getString("question"));
        testQuestion.setAnswer(rs.getString("answer"));
        return testQuestion;
    }

    @Override
    public TestQuestion makeUnique(Map<Integer, TestQuestion> cache, TestQuestion testQuestion) {
        cache.putIfAbsent(testQuestion.getId(), testQuestion);
        return cache.get(testQuestion.getId());
    }

    @Override
    public void setParameters(PreparedStatement ps, TestQuestion testQuestion) throws SQLException {
        ps.setString(1, testQuestion.getCategory());
        ps.setString(2, testQuestion.getQuestion());
        ps.setString(3, testQuestion.getAnswer());
        ps.setInt(4, testQuestion.getTest().getId());

    }
}
