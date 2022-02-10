package com.meeting.server;

import com.meeting.server.config.ProjectConfiguration;
import com.meeting.server.servercore.ServerCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        ServerCore serverCore = ctx.getBean("serverCore", ServerCore.class);

        serverCore.run();
    }
}