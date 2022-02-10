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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectAllUserTest {

    private GenericApplicationContext ctx;
    private UserDao userDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        userDao = ctx.getBean(UserDao.class);
        assertNotNull(userDao);
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        assertTrue(users.size() == 11);
        for (User user: users)
            System.out.println(user.toString());
        ctx.close();
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
