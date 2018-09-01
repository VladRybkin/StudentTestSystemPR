package ua.training.service;

import ua.training.model.dao.CourseDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entity.Course;


import java.util.List;

public class CourseService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public void create(Course course) {
        try (CourseDao dao = daoFactory.createCourseDao()) {
             dao.create(course);
        }
    }
    public void insertStudentCourses(int userId, int courseId){
        try (CourseDao dao = daoFactory.createCourseDao()) {
            dao.insertStudentCourses(userId, courseId);
        }
    }



    public Course findById(int id) {
        try (CourseDao dao = daoFactory.createCourseDao()) {
            return dao.findById(id);
        }
    }


    public List<Course> findAll() {
        try (CourseDao dao = daoFactory.createCourseDao()) {
            return dao.findAll();
        }
    }



    public void update(Course course) {
        try (CourseDao dao = daoFactory.createCourseDao()) {
            dao.update(course);
        }
    }


    public void delete(int id) {
        try (CourseDao dao = daoFactory.createCourseDao()) {
            dao.delete(id);
        }
    }


    public void close() {
        try (CourseDao dao = daoFactory.createCourseDao()) {
            dao.close();
        }
    }
}
