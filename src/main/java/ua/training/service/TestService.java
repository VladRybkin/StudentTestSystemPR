package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.TestDao;
import ua.training.model.entity.Test;


import java.util.List;

public class TestService{
    DaoFactory daoFactory = DaoFactory.getInstance();


    public void create(Test test) {
        try (TestDao dao = daoFactory.createTestDao()) {
            dao.create(test);
        }
    }


    public Test findById(int id) {
        try (TestDao dao = daoFactory.createTestDao()) {
            return dao.findById(id);
        }
    }


    public List<Test> findAll() {
        try (TestDao dao = daoFactory.createTestDao())
        {
            return dao.findAll();
        }
    }


    public void update(Test test, int id) {
        try (TestDao dao = daoFactory.createTestDao()) {
           dao.update(test, id);
        }
    }


    public void delete(int id) {
        try (TestDao dao = daoFactory.createTestDao()) {
            dao.delete(id);
        }
    }


    public void close() {
        try (TestDao dao = daoFactory.createTestDao()) {
            dao.close();
        }
    }
}
