class MyHashMap {

    private static final int SIZE = 1009;

    private Node[] buckets;

    private static class Node {

        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {

        int index = hash(key);

        Node current = buckets[index];

        // Bucket is empty
        if (current == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        // Search existing keys
        while (true) {

            // Key already exists
            if (current.key == key) {
                current.value = value;
                return;
            }

            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        // Key does not exist
        current.next = new Node(key, value);
    }

    public int get(int key) {

        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {

            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = hash(key);

        Node current = buckets[index];

        if (current == null) {
            return;
        }

        // Key is at the head
        if (current.key == key) {
            buckets[index] = current.next;
            return;
        }

        // Search remaining nodes
        while (current.next != null) {

            if (current.next.key == key) {

                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */