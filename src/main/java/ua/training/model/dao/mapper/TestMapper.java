package ua.training.model.dao.mapper;

import ua.training.model.entity.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TestMapper implements ObjectMapper<Test> {
    @Override
    public Test extractFromResultSet(ResultSet rs) throws SQLException {
        Test test=new Test();
        test.setId(rs.getInt("test_id"));
        test.setCategory(rs.getString("test_category"));

        return test;
    }

    @Override
    public Test makeUnique(Map<Integer, Test> cache, Test test) {
        cache.putIfAbsent(test.getId(), test);
        return cache.get(test.getId());
    }

    @Override
    public void setParameters(PreparedStatement ps, Test test) throws SQLException {
        ps.setString(1 , test.getCategory());

    }
}
