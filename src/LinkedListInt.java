public class LinkedListInt {
    private static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }

    private Node head;
    private int size = 0;

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.value;
    }

    public int size() {
        return size;
    }

    public int getLast() {
        return get(size - 1);
    }
}
