package ua.training.service.comparators;

import ua.training.model.entity.UserAnswer;

import java.util.Comparator;

public class UserAnswerComparator implements Comparator<UserAnswer> {
    @Override
    public int compare(UserAnswer o1, UserAnswer o2) {
        return o1.getId()-o2.getId();
    }
}
