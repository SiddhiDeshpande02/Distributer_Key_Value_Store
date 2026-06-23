package hash;

import model.Node;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRing {

    private final SortedMap<Long, Node> ring;

    public ConsistentHashRing() {
        ring = new TreeMap<>();
    }

    public void addNode(Node node) {

        long hash = HashUtil.hash(node.getId());

        ring.put(hash, node);

        System.out.println(node.getId() +
                " added at " + hash);
    }

    public void removeNode(Node node) {
        ring.remove(HashUtil.hash(node.getId()));
    }

    public Node getNode(String key) {

        long hash = HashUtil.hash(key);

        if (!ring.containsKey(hash)) {

            SortedMap<Long, Node> tail =
                    ring.tailMap(hash);

            hash = tail.isEmpty() ?
                    ring.firstKey() :
                    tail.firstKey();
        }

        return ring.get(hash);
    }
}
