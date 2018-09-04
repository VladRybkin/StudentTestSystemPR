package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

import java.util.List;

public class UserService  {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public User findById(int id) {

        try (UserDao dao = daoFactory.createUserDao()) {
           return dao.findById(id);
        }
    }
    public User findCoursesByUserId(int id) {

        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findCoursesByUserId(id);
        }
    }


    public List<User> findAll() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }


    public void update(User user, int id) {

        try (UserDao dao = daoFactory.createUserDao()) {
            dao.update(user, id);
        }
    }


    public void delete(int id) {

        try (UserDao dao = daoFactory.createUserDao()) {
            dao.delete(id);
        }
    }

    public void create(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.create(user);
        }
    }


    public void close() {

        try (UserDao dao = daoFactory.createUserDao()) {
            dao.close();
        }
    }


}
