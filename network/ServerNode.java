package network;

import storage.KeyValueStore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNode {

    private int port;
    private KeyValueStore store;

    public ServerNode(int port) {
        this.port = port;
        store = new KeyValueStore();
    }

    public void start() throws Exception {

        ServerSocket serverSocket =
                new ServerSocket(port);

        System.out.println("Node running at "
                + port);

        while (true) {

            Socket socket = serverSocket.accept();

            new Thread(
                    new ClientHandler(socket, store)
            ).start();
        }
    }
}