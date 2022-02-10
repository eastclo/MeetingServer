package com.meeting.server.servercore.message;

import java.net.Socket;

public class RequestWorker implements Runnable{
    private Socket socket = null;

    public RequestWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Request request = new Request().readRequest(this.socket);
        // 그에 맞는 처리
        Boolean requestResult = true;
        switch (request.getCmd()) {
            case 1:
                // 회원 가입
                // users 테이블에 insert 넣어
                break;
            case 2:
                // 로그인
                // users 테이블에서 select
                break;
            case 3:
                // 방 생성
                break;
            case 4:
                // 방 참가
                break;
        }
        // 처리 결과 통보
        /*
            결과에 맞는 json 작성
            outputStream 보내기.
         */
        Response response = new Response(requestResult);
        response.writeResponse(this.socket);
    }
}
