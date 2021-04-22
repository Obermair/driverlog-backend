package com.example.services;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat/{username}")
@ApplicationScoped
public class WebsocketService {

    Map<String, Session> sessions = new ConcurrentHashMap<>();
    private void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message , result -> {
                if (result.getException() != null) {
                    System.out.println("Unable to send");
                }
            });
        });
    }

    @OnOpen
    public void onOpen(Session session,
                       @PathParam("username") String username) {
        sessions.put(username, session);
        System.out.println("User " + username + " joined");
        broadcast("User " + username + " joined");
    }

    @OnClose
    public void onClose(Session session,
                        @PathParam("username") String username) {
        sessions.remove(username);
        broadcast("User " + username + " left");
    }

    @OnMessage
    public void onMessage(String message,
                          @PathParam("username") String username) {
        broadcast(">> " + username + ": " + message);
    }

    @OnError
    public void onError(Session session,
                        @PathParam("username") String username,
                        Throwable throwable) {
        sessions.remove(username);
        broadcast("User " + username
                + " left on error: " + throwable);
    }
}
