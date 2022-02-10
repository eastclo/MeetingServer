package com.meeting.server.servercore.message;

import lombok.Getter;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

@Getter
public class Response{
    private Boolean requestResult;

    public Response(Boolean requestResult) {
        this.requestResult = requestResult;
    }

    public void writeResponse(Socket socket) {
        try (OutputStream outputStream = socket.getOutputStream();
             DataOutputStream dataOutputStream = new DataOutputStream(outputStream);) {

            // 답변에 맞는 json 파일 작성
            JSONObject jsonObject = new JSONObject();
            if (requestResult) {
                jsonObject.put("result", "success");
            } else {
                jsonObject.put("result", "failure");
            }
            String responseBody = jsonObject.toString();

            dataOutputStream.writeUTF(responseBody);
            dataOutputStream.flush();

            // 아웃풋 스트림 보내기
        } catch (Exception e) {
            e.printStackTrace();
            // log
        }
    }
}
