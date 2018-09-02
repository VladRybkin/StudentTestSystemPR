package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

public class LoginService {
    DaoFactory daoFactory = DaoFactory.getInstance();



    public boolean userIsExists(String login, String password) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.userIsExists(login, password);
        }
    }

    public User.Role getRoleByLoginPassword(String login, String password) {

        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getRoleByLoginAndPass(login, password);
        }
    }
    public User getUserByLoginAndPass(String login, String password) {

        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUserByLoginAndPassword(login, password);
        }
    }
}
