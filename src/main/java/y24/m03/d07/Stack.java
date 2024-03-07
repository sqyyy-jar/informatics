package y24.m03.d07;

public class Stack<T extends Comparable<T>> {
    private Node<T> top;

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(T content) {
        if (content == null) {
            return;
        }
        Node<T> node = new Node<>(content);
        node.setNext(this.top);
        this.top = node;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T content = this.top.getContent();
        this.top = this.top.getNext();
        return content;
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }
        return this.top.getContent();
    }

    /**
     * Inserts an element sorted into the stack.
     * The stack is expected to be sorted in ascending order from bottom to top.
     * The insertion is stable in the direction from top to bottom.
     */
    public void insertSortedAscending(T content) {
        if (content == null) {
            return;
        }
        Node<T> node = new Node<>(content);
        Node<T> above = null;
        Node<T> below = this.top;
        while (below != null && below.getContent().compareTo(content) > 0) {
            above = below;
            below = below.getNext();
        }
        if (above == null) {
            node.setNext(this.top);
            this.top = node;
            return;
        }
        above.setNext(node);
        node.setNext(below);
    }

    /**
     * Inserts an element sorted into the stack.
     * The stack is expected to be sorted in descending order from bottom to top.
     * The insertion is stable in the direction from top to bottom.
     */
    public void insertSortedDescending(T content) {
        if (content == null) {
            return;
        }
        Node<T> node = new Node<>(content);
        Node<T> above = null;
        Node<T> below = this.top;
        while (below != null && below.getContent().compareTo(content) < 0) {
            above = below;
            below = below.getNext();
        }
        if (above == null) {
            node.setNext(this.top);
            this.top = node;
            return;
        }
        above.setNext(node);
        node.setNext(below);
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
