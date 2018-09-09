package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.TestResultDao;
import ua.training.model.entity.TestResult;

import java.util.List;

public class TestResultService {
    private DaoFactory daoFactory = DaoFactory.getInstance();


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
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            return dao.findAll();
        }
    }
    public List<TestResult> findAllWithLimit(int from, int to) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            return dao.findAllWithLimit(from, to);
        }
    }

    public List<TestResult> findAllByUserId(int id, int from, int to) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            return dao.findAllByUserId(id, from, to);
        }
    }

    public void update(TestResult testResult, int id) {
        try (TestResultDao dao = daoFactory.createTestResultDao()) {
            dao.update(testResult, id);
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
