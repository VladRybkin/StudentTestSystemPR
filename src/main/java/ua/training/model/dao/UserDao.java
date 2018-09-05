package ua.training.model.dao;

import ua.training.model.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{
    User getUserByLoginAndPassword(String userLogin, String userPassword);
    User findCoursesByUserId(int id);
    List<User> findAllWithLimit(int from, int to);


}
