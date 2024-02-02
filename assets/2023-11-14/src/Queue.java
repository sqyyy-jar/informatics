/**
 * Eine Warteschlange, welcher Elemente am Ende hinzugefügt werden und am Anfang entfernt werden können.
 */
public class Queue<T> {
    private Node head;
    private Node tail;

    /**
     * Überprüft, ob die Queue leer ist.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Fügt der Queue am Ende eine Element hinzu.
     */
    public void enqueue(T content) {
        if (content == null) {
            return;
        }
        Node node = new Node(content);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    /**
     * Entfernt ein Element von dem Anfang der Queue.
     */
    public void deque() {
        if (isEmpty()) {
            return;
        }
        head = head.getNext();
        if (isEmpty()) {
            head = tail = null;
        }
    }

    /**
     * Gibt das Element am Anfang der Queue zurück.
     */
    public T front() {
        if (isEmpty()) {
            return null;
        }
        return head.getContent();
    }

    /**
     * Ein Element der Queue.
     */
    private class Node {
        private T content;
        private Node next;

        public Node(T content) {
            this.content = content;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getContent() {
            return content;
        }
    }
}