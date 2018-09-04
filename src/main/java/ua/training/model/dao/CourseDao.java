package ua.training.model.dao;

import ua.training.model.entity.Course;

public interface CourseDao extends GenericDao<Course> {
     void insertStudentCourses(int userId, int courseId);
}
