package com.meeting.server.servercore;

import com.meeting.server.servercore.message.RequestWorker;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerCore {
    private static final int PORT = 8080;
    private static final int THREAD_CNT = 8;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

    public ServerCore() {}

    public void run() {
        System.out.println("I'm running now");

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket socket = serverSocket.accept();

                threadPool.execute(new RequestWorker(socket));
            }
        } catch (Exception e) {
            // log
        }

    }
}
