package com.MeetingServer;

import com.MeetingServer.ServerCore.ServerCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        ServerCore serverCore = ctx.getBean("ServerCore", ServerCore.class);

        serverCore.run();
    }
}
