package com.meeting.server.room.client;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClientList {
    private List<Client> synchronizedClientList;

    public ClientList() {
        this.synchronizedClientList = Collections.synchronizedList(new LinkedList<>());
    }

    // 사용할 메소드만 오버로드.
    public synchronized void add(Client client) {
            synchronizedClientList.add(client);
    }

    public synchronized void remove(Client client) {
            synchronizedClientList.remove(client);
    }
}
