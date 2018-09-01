package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserAnswerDao;
import ua.training.model.entity.UserAnswer;

import java.util.List;

public class UserAnswerService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(UserAnswer userAnswer) {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            dao.create(userAnswer);
        }
    }


    public UserAnswer findById(int id) {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            return dao.findById(id);
        }
    }


    public void update(UserAnswer statistic) {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            dao.update(statistic);
        }
    }


    public void delete(int id) {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            dao.delete(id);
        }
    }


    public void close() {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            {
                dao.close();
            }
        }
    }


    public List<UserAnswer> findAll() {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            {
                return dao.findAll();
            }

        }
    }
    public List<UserAnswer> findAllByUserId(int id) {
        try (UserAnswerDao dao = daoFactory.createUserAnswerDao()) {
            {
                return dao.findAllByUserId(id);
            }

        }
    }
}
