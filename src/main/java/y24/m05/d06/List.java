package y24.m05.d06;

import java.util.Comparator;

public class List<T> {
    private Node<T> first;
    private Node<T> last;
    private Node<T> current;

    public boolean isEmpty() {
        return this.first == null;
    }

    public boolean hasAccess() {
        return this.current != null;
    }

    public void next() {
        if (hasAccess()) {
            this.current = this.current.getNext();
        }
    }

    public void previous() {
        if (hasAccess()) {
            this.current = this.current.getPrevious();
        }
    }

    public void toFirst() {
        if (!isEmpty()) {
            this.current = this.first;
        }
    }

    public void toLast() {
        if (!isEmpty()) {
            this.current = this.last;
        }
    }

    public T getContent() {
        if (!hasAccess()) {
            return null;
        }
        return this.current.getContent();
    }

    public void setContent(T content) {
        if (hasAccess()) {
            this.current.setContent(content);
        }
    }

    public void insert(T content) {
        if (content == null) {
            return;
        }
        if (!hasAccess()) {
            if (isEmpty()) {
                Node<T> newNode = new Node<>(content);
                this.first = this.last = newNode;
            }
            return;
        }
        Node<T> newNode = new Node<>(content);
        if (this.current == this.first) {
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
            return;
        }
        Node<T> previous = this.current.getPrevious();
        previous.setNext(newNode);
        newNode.setPrevious(previous);
        newNode.setNext(this.current);
        this.current.setPrevious(newNode);
    }

    public void insertSorted(T content, Comparator<T> comparator) {
        if (content == null || comparator == null) {
            return;
        }
        if (isEmpty()) {
            this.insert(content);
            return;
        }
        Node<T> current = this.last;
        while (current != null && comparator.compare(current.getContent(), content) > 0) {
            current = current.getPrevious();
        }
        Node<T> newNode = new Node<>(content);
        if (current == null) {
            this.first.setPrevious(newNode);
            newNode.setNext(this.first);
            this.first = newNode;
            return;
        }
        if (current == this.last) {
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
            this.last = newNode;
            return;
        }
        Node<T> next = current.getNext();
        current.setNext(newNode);
        newNode.setPrevious(current);
        newNode.setNext(next);
        next.setPrevious(newNode);
    }

    public void append(T content) {
        if (content == null) {
            return;
        }
        if (isEmpty()) {
            insert(content);
            return;
        }
        Node<T> newNode = new Node<>(content);
        this.last.setNext(newNode);
        newNode.setPrevious(this.last);
        this.last = newNode;
    }

    public void concat(List<T> list) {
        if (list == null || list == this || list.isEmpty()) {
            return;
        }
        if (isEmpty()) {
            this.first = list.first;
            this.last = list.last;
            this.current = list.current;
        } else {
            this.last.setNext(list.first);
            list.first.setPrevious(this.last);
            this.last = list.last;
        }
        list.first = list.last = list.current = null;
    }

    public void remove() {
        if (!hasAccess()) {
            return;
        }
        Node<T> previous = this.current.getPrevious();
        Node<T> next = this.current.getNext();
        if (previous != null) {
            previous.setNext(next);
        }
        if (next != null) {
            next.setPrevious(previous);
        }
        if (this.current == this.first) {
            this.first = next;
        }
        if (this.current == this.last) {
            this.last = previous;
        }
        this.current = next;
    }

    private static class Node<T> {
        private T content;
        private Node<T> next;
        private Node<T> previous;

        public Node(T content) {
            this.content = content;
        }

        public T getContent() {
            return this.content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return this.previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
