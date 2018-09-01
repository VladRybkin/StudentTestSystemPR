package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.TestResultDao;
import ua.training.model.entity.TestResult;

import java.util.List;

public class TestResultService  {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public void create(TestResult testResult) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            dao.create(testResult);
        }
    }


    public TestResult findById(int id) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            return dao.findById(id);
        }
    }


    public List<TestResult> findAll() {
        try (TestResultDao dao = daoFactory.createTestResultDao())
        {
            return dao.findAll();
        }
    }
   public List<TestResult> findAllByUserId(int id) {
        try (TestResultDao dao = daoFactory.createTestResultDao())
        {
            return dao.findAllByUserId(id);
        }
    }

    public void update(TestResult testResult) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            dao.update(testResult);
        }
    }


    public void delete(int id) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            dao.delete(id);
        }
    }



    public void close() {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            dao.close();
        }
    }

}
