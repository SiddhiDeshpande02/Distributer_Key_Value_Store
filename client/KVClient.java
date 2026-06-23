package client;

import model.Node;

import java.io.*;
import java.net.Socket;

public class KVClient {

    public String send(Node node,
                       String request)
            throws Exception {

        Socket socket =
                new Socket(node.getHost(),
                        node.getPort());

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

        PrintWriter out =
                new PrintWriter(
                        socket.getOutputStream(), true);

        out.println(request);

        String response = in.readLine();

        socket.close();

        return response;
    }
}
