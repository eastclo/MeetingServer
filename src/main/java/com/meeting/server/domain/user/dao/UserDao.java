package com.meeting.server.domain.user.dao;

import com.meeting.server.domain.user.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
    boolean findUserByUserId(String userId);
    boolean findUserByUserIdAndPwd(String userId, String userPwd);
    void insert(User user);
    void update(User user);
    void delete(User user);
}