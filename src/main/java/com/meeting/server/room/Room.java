package com.meeting.server.room;

import com.meeting.server.room.client.ClientList;

public class Room {
    private int PORT;
    private ClientList clientList;

    public Room(int PORT) {
        this.PORT = PORT;
        this.clientList = new ClientList();
    }
}
