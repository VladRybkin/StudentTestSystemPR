package ua.training.model.dao;

import ua.training.model.entity.User;

public interface UserDao extends GenericDao<User>{
    User getUserByLoginAndPassword(String userLogin, String userPassword);
    User findCoursesByUserId(int id);


}
