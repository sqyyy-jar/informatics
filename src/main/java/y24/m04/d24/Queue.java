package y24.m04.d24;

public class Queue {
    protected Node front;
    private Node tail;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Object pObject) {
        Node newNode = new Node(pObject);
        if (isEmpty()) {
            this.front = this.tail = newNode;
            return;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    public void dequeue() {
        if (isEmpty()) {
            return;
        }
        this.front = this.front.getNext();
    }

    public Object front() {
        if (isEmpty()) {
            return null;
        }
        return this.front.getContent();
    }

    public static class Node {
        private Object content;
        private Node next;

        public Node(Object content) {
            this.content = content;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getContent() {
            return content;
        }
    }
}
