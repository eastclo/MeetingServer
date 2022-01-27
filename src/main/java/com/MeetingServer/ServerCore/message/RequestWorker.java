package com.MeetingServer.ServerCore.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class RequestWorker implements Runnable{
    private Socket socket = null;

    public RequestWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("running now~");
        try(OutputStream outputStream = socket.getOutputStream()) {
            // json 분석

            // 그에 맞는 처리

            // 처리 결과 통보
            //outputStream.write();
        } catch (IOException e) {
            // log
        }
    }
}
