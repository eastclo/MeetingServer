package com.meeting.server.domain.user.querys;

import com.meeting.server.domain.user.User;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllUsers extends MappingSqlQuery<User> {

    private static final String SQL_SELECT_ALL_USER = "select id, user_id, user_pwd from users";

    public SelectAllUsers(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_USER);
    }

    @Override
    protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getLong("id"));
        user.setUserId(rs.getString("user_id"));
        user.setUserPwd(rs.getString("user_pwd"));

        return user;
    }
}
