package ua.training.model.dao.mapper;

import ua.training.model.entity.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CourseMapper implements ObjectMapper<Course> {
    private String COURSE_ID="course_id";
    private String COURSE_STATUS="course_status";
    private String COURSE_CATEGORY="course_category";

    @Override
    public Course extractFromResultSet(ResultSet rs) throws SQLException {
        Course course=new Course();
        course.setId(rs.getInt(COURSE_ID));
        course.setStatus(rs.getString(COURSE_STATUS));
        course.setCategory(rs.getString(COURSE_CATEGORY));

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
