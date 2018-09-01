package ua.training.model.dao;

import ua.training.model.entity.User;

public interface UserDao extends GenericDao<User>{
    boolean userIsExists(String login, String password);
    User.Role getRoleByLoginAndPass(String login, String password);
    User getUserByLogin(String userLogin);
    User findCoursesByUserId(int id);


}
