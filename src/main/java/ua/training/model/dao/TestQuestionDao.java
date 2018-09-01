package ua.training.model.dao;

import ua.training.model.entity.TestQuestion;

import java.util.List;

public interface TestQuestionDao extends GenericDao<TestQuestion> {
    public List<TestQuestion> findAllByCategory(String category);
}
