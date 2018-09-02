package ua.training.model.dao;

import ua.training.model.entity.User;

public interface UserDao extends GenericDao<User>{
    boolean userIsExists(String login, String password);
    User.Role getRoleByLoginAndPass(String login, String password);
    User getUserByLoginAndPassword(String userLogin, String userPassword);
    User findCoursesByUserId(int id);


}
