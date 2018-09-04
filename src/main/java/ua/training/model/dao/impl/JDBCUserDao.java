package ua.training.model.dao.impl;

import ua.training.model.dao.UserDao;
import ua.training.model.dao.mapper.CourseMapper;
import ua.training.model.dao.mapper.TestResultMapper;
import ua.training.model.dao.mapper.UserAnswerMapper;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.Course;
import ua.training.model.entity.TestResult;
import ua.training.model.entity.User;
import ua.training.model.entity.UserAnswer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private UserMapper userMapper = new UserMapper();
    private static Logger log = Logger.getLogger(JDBCUserDao.class.getName());
    private final String CREATE_QUERY = "INSERT INTO users(`user_login`, `user_password`,`user_role`,`user_mail`)VALUES(?, ?, ?, ?)";
    private final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE user_id=";
    private final String FIND_COURSES_BY_USER_ID_QUERY = "SELECT * FROM users " + "LEFT JOIN student_courses USING(user_id) " + "LEFT JOIN courses USING (course_id) WHERE user_id=";
    private final String FIND_BY_LOGIN_QUERY = "SELECT * FROM users WHERE user_login = ?";
    private final String FIND_ALL_QUERY = "SELECT * FROM users " + "LEFT JOIN student_courses USING(user_id) " + "LEFT JOIN courses USING (course_id) " + "LEFT JOIN user_answers USING(user_id) LEFT JOIN test_results USING(user_id)";
    private final String UPDATE_QUERY = "UPDATE users SET user_login = ? , user_password = ?, user_role=?, user_mail=? WHERE user_id = ?";
    private final String DELETE_QUERY = "DELETE FROM users  WHERE user_id = ?";
    private final String GET_USER_BY_LOGIN_QUERY = "SELECT * FROM users WHERE user_login = ? AND user_password = ?";

    JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_QUERY)) {
            userMapper.setParameters(ps, user);

            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_BY_ID_QUERY + id);
            if (rs.next()) {
                user = userMapper.extractFromResultSet(rs);
            }
        }   catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
            return user;


    }

    @Override
    public User findCoursesByUserId(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_COURSES_BY_USER_ID_QUERY + id);
            CourseMapper courseMapper = new CourseMapper();
            User user = null;
            if (rs.next()) {
                user = userMapper.extractFromResultSet(rs);

            }
            while (rs.next()) {
                Course course = courseMapper.extractFromResultSet(rs);
                user.getCourses().add(course);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public User findByLogin(String login) {
        try (PreparedStatement ps = connection.prepareStatement
                (FIND_BY_LOGIN_QUERY)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = userMapper.extractFromResultSet(rs);
                return user;
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
        return null;
    }


    @Override
    public List<User> findAll() {
        Map<Integer, User> users = new HashMap<>();
        Map<Integer, Course> courses = new HashMap<>();
        Map<Integer, UserAnswer> userAnswers = new HashMap<>();
        Map<Integer, TestResult> testResults = new HashMap<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_QUERY);
            CourseMapper courseMapper = new CourseMapper();
            UserAnswerMapper userAnswerMapper = new UserAnswerMapper();
            TestResultMapper testResultMapper = new TestResultMapper();

            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                Course course = courseMapper.extractFromResultSet(resultSet);
                UserAnswer userAnswer = userAnswerMapper.extractFromResultSet(resultSet);
                TestResult testResult = testResultMapper.extractFromResultSet(resultSet);

                user = userMapper.makeUnique(users, user);
                course = courseMapper.makeUnique(courses, course);
                userAnswer = userAnswerMapper.makeUnique(userAnswers, userAnswer);
                testResult = testResultMapper.makeUnique(testResults, testResult);

                user.getCourses().add(course);
                user.getUserAnswers().add(userAnswer);
                user.getTestResults().add(testResult);

                users.put(user.getId(), user);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
        return new ArrayList<>(users.values());
    }


    @Override
    public void update(User user) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            userMapper.setParameters(ps, user);

            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }


    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }


    @Override
    public User getUserByLoginAndPassword(String userLogin, String userPassword) {

        User user = new User();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN_QUERY);
            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = userMapper.extractFromResultSet(resultSet);
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }

        return user;
    }


    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

}
