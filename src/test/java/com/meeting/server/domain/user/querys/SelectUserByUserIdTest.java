package com.meeting.server.domain.user.querys;

import com.meeting.server.config.ProjectConfiguration;
import com.meeting.server.domain.user.User;
import com.meeting.server.domain.user.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SelectUserByUserIdTest {
    private GenericApplicationContext ctx;
    private UserDao userDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        userDao = ctx.getBean(UserDao.class);
        assertNotNull(userDao);
    }

    @Test
    public void testFindByUserId() {
        String expectTrueString = "001";
        String expectFalseString = "001";

        // 0 parameters were supplied, but 1 in parameters were declared in class 에러 발생..... 시발 왜...?
        boolean expectTrue = userDao.findUserByUserId(expectTrueString);
        boolean expectFalse = userDao.findUserByUserId(expectFalseString);

        assertTrue(expectTrue);

        assertFalse(expectFalse);

        ctx.close();
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
