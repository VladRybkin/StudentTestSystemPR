package ua.training.model.dao;

import ua.training.model.entity.UserAnswer;

import java.sql.SQLException;
import java.util.List;

public interface UserAnswerDao extends GenericDao<UserAnswer> {
     List<UserAnswer> findAllByUserId(int id, int currentPage, int recordsPerPage);
     void insertUserAnswers(UserAnswer ... userAnswers) throws SQLException;
}
