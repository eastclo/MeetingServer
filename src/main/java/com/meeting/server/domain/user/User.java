package com.meeting.server.domain.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private Long id;
    private String userId;
    private String userPwd;

    public String toString() {
        return "ID: " +id +", USER_ID: " +userId +", USER_PWD: " +userPwd;
    }
}
