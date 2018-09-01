package ua.training.model.dao.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface ObjectMapper<T> {

    T extractFromResultSet(ResultSet rs) throws SQLException;

    T makeUnique(Map<Integer, T> cache,
                 T object);
     void setParameters(PreparedStatement ps, T entity) throws SQLException;
}
