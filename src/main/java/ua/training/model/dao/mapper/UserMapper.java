package ua.training.model.dao.mapper;


import ua.training.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user=new User();
        user.setId(rs.getInt("user_id"));
        user.setLogin(rs.getString("user_login"));
        user.setPassword(rs.getString("user_password"));
        user.setRole(User.Role.valueOf(rs.getString("user_role")));
        user.setEmail(rs.getString("user_mail"));
        return user;
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }
    @Override
    public void setParameters(PreparedStatement ps, User user) throws SQLException{
        ps.setString(1 , user.getLogin());
        ps.setString(2 ,user.getPassword());
        ps.setString(3 ,String.valueOf(user.getRole()));
        ps.setString(4 ,user.getEmail());
    }
}
