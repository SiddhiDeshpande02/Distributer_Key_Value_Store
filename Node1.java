import network.ServerNode;

public class Node1 {
    public static void main(String[] args) throws Exception {
        new ServerNode(5001).start();
    }
}