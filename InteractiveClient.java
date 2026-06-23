import java.util.Scanner;
import client.KVClient;
import hash.ConsistentHashRing;
import model.Node;

public class InteractiveClient {

    public static void main(String[] args) throws Exception {

        ConsistentHashRing ring = new ConsistentHashRing();

        ring.addNode(new Node("localhost",5001));
        ring.addNode(new Node("localhost",5002));
        ring.addNode(new Node("localhost",5003));

        KVClient client = new KVClient();

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.print("> ");

            String request = sc.nextLine();

            String key = request.split(" ")[1];

            Node target = ring.getNode(key);

            String response =
                    client.send(target, request);

            System.out.println(response);
        }
    }
}