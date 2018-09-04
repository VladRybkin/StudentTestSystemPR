package ua.training.model.dao.impl;

import ua.training.model.dao.UserAnswerDao;
import ua.training.model.dao.mapper.UserAnswerMapper;
import ua.training.model.entity.UserAnswer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUserAnswerDao implements UserAnswerDao {
    private Connection connection;
    private UserAnswerMapper userAnswerMapper = new UserAnswerMapper();
    private static Logger log = Logger.getLogger(JDBCUserAnswerDao.class.getName());
    private final String createQuery = "INSERT INTO user_answers (test_question,user_answer,correct_answer, user_id)\n" + "VALUES\n" + "(?, ?, ?, ?);";
    private final String findAllByUserIdQuery = "SELECT * FROM user_answers right join users using(user_id) WHERE user_id=";
    private final String findAllQuery = "SELECT * FROM user_answers RIGHT JOIN users USING(user_id);";
    private final String updateQuery = "UPDATE statistic SET user_id = ? , test_result_id= ? WHERE user_id = ?";
    private final String deleteQuery = "DELETE FROM stastistic  WHERE user_id = ?";


    JDBCUserAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(UserAnswer userAnswer) {
        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            userAnswerMapper.setParameters(ps, userAnswer);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public void insertUserAnswers(UserAnswer... userAnswers) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            connection.setAutoCommit(false);
            for (UserAnswer userAnswer : userAnswers) {
                userAnswerMapper.setParameters(ps, userAnswer);
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public UserAnswer findById(int id) {
        return null;
    }

    @Override
    public List<UserAnswer> findAll() {
        Map<Integer, UserAnswer> userAnswers = new HashMap<>();


        Extract(userAnswers, findAllQuery);

        return new ArrayList<>(userAnswers.values());

    }

    @Override
    public List<UserAnswer> findAllByUserId(int id) {
        Map<Integer, UserAnswer> userAnswers = new HashMap<>();
        Extract(userAnswers, findAllByUserIdQuery + id);

        return new ArrayList<>(userAnswers.values());

    }

    private void Extract(Map<Integer, UserAnswer> userAnswers, String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                UserAnswer userAnswer = userAnswerMapper.extractFromResultSet(resultSet);
                userAnswer = userAnswerMapper.makeUnique(userAnswers, userAnswer);
                userAnswers.put(userAnswer.getId(), userAnswer);

            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);

        }
    }

    @Override
    public void update(UserAnswer statistic) {

        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            userAnswerMapper.setParameters(ps, statistic);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public void delete(int id) {

        try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
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
