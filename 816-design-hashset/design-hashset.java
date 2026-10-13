class MyHashSet {

    private static final int SIZE = 1000;

    private Node[] buckets;

    private static class Node {

        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {

        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key);
            return;
        }

        Node current = buckets[index];

        while (true) {

            if (current.key == key) {
                return;
            }

            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        current.next = new Node(key);
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

        while (current.next != null) {

            if (current.next.key == key) {

                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    public boolean contains(int key) {

        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {

            if (current.key == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */