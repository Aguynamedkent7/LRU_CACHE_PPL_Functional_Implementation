import java.util.HashMap;
import java.util.Map;

public class LRUFunctions {



    public static class Node {
        public int key;
        public String value;
        public Node prev;
        public Node next;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class CacheState {
        public int capacity;
        public int size;
        public Map<Integer, Node> map;
        public Node head;
        public Node tail;

        public CacheState(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap<>();
            this.head = null;
            this.tail = null;
        }
    }



    private static void removeNode(CacheState state, Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            state.head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            state.tail = node.prev;
        }
    }

    private static void addToHead(CacheState state, Node node) {
        node.prev = null;
        node.next = state.head;

        if (state.head != null) {
            state.head.prev = node;
        }
        state.head = node;

        if (state.tail == null) {
            state.tail = node;
        }
    }

    public static String get(CacheState state, int key) {
        if (!state.map.containsKey(key)) {
            return null;
        }

        Node node = state.map.get(key);

        removeNode(state, node);
        addToHead(state, node);

        return node.value;
    }

    public static void put(CacheState state, int key, String value) {
        if (state.map.containsKey(key)) {
            Node node = state.map.get(key);
            node.value = value;
            removeNode(state, node);
            addToHead(state, node);
        } else {
            Node newNode = new Node(key, value);
            
            state.map.put(key, newNode);
            addToHead(state, newNode);
            state.size++;

            if (state.size > state.capacity) {
                Node lruNode = state.tail;
                removeNode(state, lruNode);
                
                state.map.remove(lruNode.key);
                state.size--;
            }
        }
    }
}