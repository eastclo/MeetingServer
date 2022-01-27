package com.MeetingServer.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user); // db에

    Optional<User> findById(User user); // 계정 생성 중복 검사용

    List<User> findAll(); // select all
}
