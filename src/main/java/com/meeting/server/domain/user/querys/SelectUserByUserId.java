package com.meeting.server.domain.user.querys;

import com.meeting.server.domain.user.User;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectUserByUserId extends MappingSqlQuery<User> {

    private static final String SQL_FIND_BY_USER_ID = "select user_id, user_pwd from users where user_id = :user_id";

    public SelectUserByUserId(DataSource dataSource) {
        super(dataSource, SQL_FIND_BY_USER_ID);
        super.declareParameter(new SqlParameter("user_id", Types.VARCHAR));
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
