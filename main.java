public class Main {

    public static void main(String[] args) {

        ConsistentHashRing ring =
                new ConsistentHashRing();

        Node n1 = new Node("localhost",5001);
        Node n2 = new Node("localhost",5002);
        Node n3 = new Node("localhost",5003);

        ring.addNode(n1);
        ring.addNode(n2);
        ring.addNode(n3);

        String key = "name";

        Node target = ring.getNode(key);

        System.out.println(
                key + " belongs to "
                        + target.getId());
    }
}