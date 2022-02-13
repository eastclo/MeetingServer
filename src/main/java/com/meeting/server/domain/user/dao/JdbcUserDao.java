package com.meeting.server.domain.user.dao;

import com.meeting.server.domain.user.User;
import com.meeting.server.domain.user.querys.SelectAllUsers;
import com.meeting.server.domain.user.querys.SelectUserByUserId;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDao")
public class JdbcUserDao  implements UserDao {

    private DataSource dataSource;

    // 필요 SQL 쿼리당 해당 쿼리에 대한 객체.

    private SelectAllUsers selectAllUsers;
    private SelectUserByUserId selectUserByUserId;

//    private UpdateSinger updateSinger;
//    private InsertSinger insertSinger;
//    private InsertSingerAlbum insertSingerAlbum;
//    private DeleteSinger deleteSinger;
//    private StoredFunctionFirstNameById storedFunctionFirstNameById;

    @Override
    public List<User> findAll() {
        return selectAllUsers.execute();
    }

    @Override
    public boolean findUserByUserId(String userId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", userId);

        List<User> toFind = selectUserByUserId.execute(paramMap);

        if(toFind.isEmpty()) return false;
        return true;
    }

    @Override
    public boolean findUserByUserIdAndPwd(String userId, String userPwd) {
        return false;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllUsers = new SelectAllUsers(dataSource);
        this.selectUserByUserId = new SelectUserByUserId(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
