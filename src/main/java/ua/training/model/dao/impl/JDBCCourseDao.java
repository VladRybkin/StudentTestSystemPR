package ua.training.model.dao.impl;

import ua.training.model.dao.CourseDao;
import ua.training.model.dao.mapper.CourseMapper;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.Course;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCourseDao implements CourseDao {
    private Connection connection;
    private CourseMapper courseMapper = new CourseMapper();

    public JDBCCourseDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Course course) {
        final String query = "INSERT INTO courses(`course_status`,`course_category`)VALUES(?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            courseMapper.setParameters(ps, course);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course findById(int id) {

        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM courses WHERE course_id = ?")) {
            Course course=null;
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 course = courseMapper.extractFromResultSet(rs);

            }
            return course;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Course> findAll() {
        Map<Integer, Course> courses = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();
        final String query = "SELECT * FROM courses";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            UserMapper userMapper = new UserMapper();

            while (resultSet.next()) {
                Course course = courseMapper.extractFromResultSet(resultSet);
                course = courseMapper.makeUnique(courses, course);
                courses.put(course.getId(), course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(courses.values());

    }

    @Override
    public void update(Course course) {
        final String query = "UPDATE courses SET course_id = ?, course_status =?, course_category=? WHERE course_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            courseMapper.setParameters(ps, course);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM courses WHERE course_id = ?")) {
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

    @Override
    public void insertStudentCourses(int userId, int courseId) {
        final String query = "INSERT INTO student_courses(user_id, course_id)VALUES(" + userId + "," + courseId + ")";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
