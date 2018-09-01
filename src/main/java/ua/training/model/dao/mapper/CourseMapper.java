package ua.training.model.dao.mapper;

import ua.training.model.entity.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CourseMapper implements ObjectMapper<Course> {
    @Override
    public Course extractFromResultSet(ResultSet rs) throws SQLException {
        Course course=new Course();
        course.setId(rs.getInt("course_id"));
        course.setStatus(rs.getString("course_status"));
        course.setCategory(rs.getString("course_category"));

        return course;
    }

    @Override
    public Course makeUnique(Map<Integer, Course> cache, Course course) {
        cache.putIfAbsent(course.getId(), course);
        return cache.get(course.getId());
    }

    @Override
    public void setParameters(PreparedStatement ps, Course course) throws SQLException {
        ps.setString(1 , course.getStatus());
        ps.setString(2 , course.getCategory());

    }
}
