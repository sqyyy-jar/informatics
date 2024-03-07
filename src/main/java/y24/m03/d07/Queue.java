package y24.m03.d07;

public class Queue<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(T content) {
        if (content == null) {
            return;
        }
        Node<T> node = new Node<>(content);
        if (isEmpty()) {
            this.head = this.tail = node;
            return;
        }
        this.tail.setNext(node);
        this.tail = node;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T content = this.head.getContent();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        return content;
    }

    public T head() {
        if (isEmpty()) {
            return null;
        }
        return this.head.getContent();
    }

    /**
     * Inserts an element sorted into the queue.
     * The queue is expected to be sorted in ascending order from head to tail.
     * The insertion is stable in the direction from head to tail.
     */
    public void insertSortedAscending(T content) {
        if (content == null) {
            return;
        }
        if (isEmpty()) {
            this.enqueue(content);
            return;
        }
        Node<T> node = new Node<>(content);
        Node<T> previous = null;
        Node<T> next = this.head;
        while (next != null && next.getContent().compareTo(content) < 0) {
            previous = next;
            next = next.getNext();
        }
        if (previous == null) { // Add element at the head
            node.setNext(this.head);
            this.head = node;
            return;
        }
        previous.setNext(node);
        node.setNext(next);
        if (next == null) {
            this.tail = node;
        }
    }

    /**
     * Inserts an element sorted into the queue.
     * The queue is expected to be sorted in descending order from head to tail.
     * The insertion is stable in the direction from head to tail.
     */
    public void insertSortedDescending(T content) {
        if (content == null) {
            return;
        }
        if (isEmpty()) {
            this.enqueue(content);
            return;
        }
        Node<T> node = new Node<>(content);
        Node<T> previous = null;
        Node<T> next = this.head;
        while (next != null && next.getContent().compareTo(content) > 0) {
            previous = next;
            next = next.getNext();
        }
        if (previous == null) { // Add element at the head
            node.setNext(this.head);
            this.head = node;
            return;
        }
        previous.setNext(node);
        node.setNext(next);
        if (next == null) {
            this.tail = node;
        }
    }

    private static class Node<T> {
        private final T content;
        private Node<T> next;

        public Node(T content) {
            this.content = content;
        }

        public T getContent() {
            return this.content;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
