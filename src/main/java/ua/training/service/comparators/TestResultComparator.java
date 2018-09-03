package ua.training.service.comparators;

import ua.training.model.entity.TestResult;

import java.util.Comparator;

public class TestResultComparator implements Comparator<TestResult> {
    @Override
    public int compare(TestResult o1, TestResult o2) {
        return o1.getId()-o2.getId();
    }
}
