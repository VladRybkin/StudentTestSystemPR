package ua.training.model.dao.impl;

import org.apache.log4j.Priority;
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

import org.apache.log4j.Logger;

public class JDBCCourseDao implements CourseDao {
    private Connection connection;
    private static Logger log = Logger.getLogger(JDBCCourseDao.class.getName());
    private CourseMapper courseMapper = new CourseMapper();
    private String createQuery = "INSERT INTO courses(`course_status`,`course_category`)VALUES(?, ?)";
    private String findByIdQuery = "SELECT * FROM courses WHERE course_id = ?";
    private String findAllQuery = "SELECT * FROM courses";
    private String updateQuery = "UPDATE courses SET course_id = ?, course_status =?, course_category=? WHERE course_id =";
    private String deleteQuery = "DELETE FROM courses WHERE course_id = ?";

    JDBCCourseDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Course course) {

        try (PreparedStatement ps = connection.prepareStatement(createQuery)) {
            courseMapper.setParameters(ps, course);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);

        }
    }

    @Override
    public Course findById(int id) {
        Course course = null;
        try (PreparedStatement ps = connection.prepareStatement
                (findByIdQuery)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                course = courseMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);
        }
        return course;


    }

    @Override
    public List<Course> findAll() {
        Map<Integer, Course> courses = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllQuery);

            while (resultSet.next()) {
                Course course = courseMapper.extractFromResultSet(resultSet);
                course = courseMapper.makeUnique(courses, course);
                courses.put(course.getId(), course);
            }
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);

        }
        return new ArrayList<>(courses.values());

    }

    @Override
    public void update(Course course, int id) {
        try (PreparedStatement ps = connection.prepareStatement(updateQuery + id)) {
            courseMapper.setParameters(ps, course);
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

    @Override
    public void insertStudentCourses(int userId, int courseId) {
        final String insertStudentCourses = "INSERT INTO student_courses(user_id, course_id)VALUES(" + userId + "," + courseId + ")";
        try (PreparedStatement ps = connection.prepareStatement(insertStudentCourses)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(org.apache.log4j.Level.INFO, e);

        }
    }
}
