package ua.training.model.dao.mapper;

import ua.training.model.entity.TestQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TestQuestionMapper implements ObjectMapper<TestQuestion> {
    private String TEST_QUESTION_ID="test_question_id";
    private String TEST_CATEGORY="test_category";
    private String QUESTION="question";
    private String ANSWER="answer";

    @Override
    public TestQuestion extractFromResultSet(ResultSet rs) throws SQLException {
        TestQuestion testQuestion = new TestQuestion();
        testQuestion.setId(rs.getInt(TEST_QUESTION_ID));
        testQuestion.setCategory(rs.getString(TEST_CATEGORY));
        testQuestion.setQuestion(rs.getString(QUESTION));
        testQuestion.setAnswer(rs.getString(ANSWER));
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
