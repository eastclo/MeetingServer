package com.meeting.server.servercore.message;

import lombok.Getter;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.Socket;

@Getter
public class Request{
    private int cmd;
    private String id;
    private String password;
    private String roomName;
    private String roomPassword;

    public Request readRequest(Socket socket) {
        try (InputStream inputStream = socket.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");) {

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(inputStreamReader);

            this.cmd = jsonObject.getInt("cmd");
            this.id = jsonObject.getString("id");
            if (cmd == 1 || cmd == 2) {
                this.password = jsonObject.getString("password");
            } else {
                this.id = jsonObject.getString("id");
                this.roomName = jsonObject.getString("roomName");
                this.roomPassword = jsonObject.getString("roomPassword");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // log
        }

        return this;
    }
}
