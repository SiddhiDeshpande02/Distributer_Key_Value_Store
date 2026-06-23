package storage;

import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore {

    private final ConcurrentHashMap<String, String> store;

    public KeyValueStore() {
        store = new ConcurrentHashMap<>();
    }

    public void put(String key, String value) {
        store.put(key, value);
    }

    public String get(String key) {
        return store.get(key);
    }

    public void delete(String key) {
        store.remove(key);
    }

    public void display() {
        System.out.println(store);
    }
}
