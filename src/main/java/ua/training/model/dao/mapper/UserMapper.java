package ua.training.model.dao.mapper;


import ua.training.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    private String USER_ID="user_id";
    private String USER_LOGIN="user_login";
    private String USER_PASSWORD="user_password";
    private String USER_ROLE="user_role";
    private String USER_MAIL="user_mail";

    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user=new User();
        user.setId(rs.getInt(USER_ID));
        user.setLogin(rs.getString(USER_LOGIN));
        user.setPassword(rs.getString(USER_PASSWORD));
        user.setRole(User.Role.valueOf(rs.getString(USER_ROLE)));
        user.setEmail(rs.getString(USER_MAIL));
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
