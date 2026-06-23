package network;

import storage.KeyValueStore;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private KeyValueStore store;

    public ClientHandler(Socket socket,
                         KeyValueStore store) {

        this.socket = socket;
        this.store = store;
    }

    @Override
    public void run() {

        try {

            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            String request = in.readLine();

            String[] parts = request.split(" ");

            switch (parts[0]) {

                case "PUT":
                    store.put(parts[1], parts[2]);
                    out.println("OK");
                    break;

                case "GET":
                    out.println(store.get(parts[1]));
                    break;

                case "DELETE":
                    store.delete(parts[1]);
                    out.println("Deleted");
                    break;
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
