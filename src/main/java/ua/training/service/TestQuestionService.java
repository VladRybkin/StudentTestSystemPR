package ua.training.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.TestQuestionDao;
import ua.training.model.entity.TestQuestion;

import java.util.List;


public class TestQuestionService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public void create(TestQuestion testQuestion) {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            dao.create(testQuestion);
        }
    }

    public TestQuestion findById(int id) {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            return dao.findById(id);
        }
    }

    public List<TestQuestion> findAll() {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            return dao.findAll();
        }
    }

    public List<TestQuestion> findAllByCategory(String category) {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            return dao.findAllByCategory(category);
        }
    }

    public void update(TestQuestion testQuestion, int id) {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            dao.update(testQuestion, id);
        }
    }

    public void delete(int id) {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            dao.delete(id);
        }
    }

    public void close() {
        try (TestQuestionDao dao = daoFactory.createTestQuestionDao()) {
            dao.close();
        }
    }
}
