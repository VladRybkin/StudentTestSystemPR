package ua.training.model.dao;

import ua.training.model.entity.TestResult;

import java.util.List;

public interface TestResultDao extends GenericDao<TestResult> {
    List<TestResult> findAllByUserId(int id, int currentPage, int recordsPerPage);
    List<TestResult> findAllWithLimit(int currentPage, int recordsPerPage);
}
