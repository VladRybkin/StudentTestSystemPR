package ua.training.model.dao.mapper;

import ua.training.model.entity.UserAnswer;
import ua.training.service.UserAnswerService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserAnswerMapper implements ObjectMapper<UserAnswer> {
    UserAnswerService userAnswerService = new UserAnswerService();

    @Override
    public UserAnswer extractFromResultSet(ResultSet rs) throws SQLException {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setId(rs.getInt("user_answer_id"));
        userAnswer.setTestQuestion(rs.getString("test_question"));
        userAnswer.setUserAnswer(rs.getString("user_answer"));
        userAnswer.setCorrectAnswer(rs.getString("correct_answer"));
        return userAnswer;
    }

    @Override
    public UserAnswer makeUnique(Map<Integer, UserAnswer> cache, UserAnswer userAnswer) {
        cache.put(userAnswer.getId(), userAnswer);
        return cache.get(userAnswer.getId());
    }

    @Override
    public void setParameters(PreparedStatement ps, UserAnswer userAnswer) throws SQLException {
        ps.setString(1, userAnswer.getTestQuestion());
        ps.setString(2, userAnswer.getUserAnswer());
        ps.setString(3, userAnswer.getCorrectAnswer());
        ps.setInt(4, userAnswer.getUser().getId());


    }
}
