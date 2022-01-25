package com.MeetingServer;

import com.MeetingServer.ServerCore.ServerCore;

public class main {
    public static void main(String... args) {
        ServerCore serverCore = new ServerCore();

        serverCore.run();
    }
}
