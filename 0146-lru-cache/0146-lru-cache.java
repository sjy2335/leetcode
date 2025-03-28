import java.util.*;

class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing node
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }

        // Create new node
        Node node = new Node(key, value);
        map.put(key, node);
        addToTail(node);

        if (map.size() > capacity) {
            // Remove least recently used (head)
            map.remove(head.key);
            removeHead();
        }
    }

    private void moveToTail(Node node) {
        if (node == tail) return; // Already at the tail
        
        removeNode(node);
        addToTail(node);
    }

    private void addToTail(Node node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private void removeHead() {
        if (head == null) return;
        removeNode(head);
    }

    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        
        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;
    }
}