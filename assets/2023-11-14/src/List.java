public class List<T> {
    private Node head;
    private Node tail;
    private Node current;

    /**
     * Überprüft, ob die List leer ist.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Überprüft, ob die Liste ein aktuelles Element besitzt.
     */
    public boolean hasAccess() {
        return this.current != null;
    }

    /**
     * Iteriert um eine Stelle nach vorne.
     */
    public void next() {
        if (hasAccess()) {
            this.current = this.current.getNext();
        }
    }

    /**
     * Setzt das aktuelle Element auf den Anfang der Liste.
     */
    public void toFirst() {
        if (!isEmpty()) {
            this.current = this.first;
        }
    }

    /**
     * Setzt das aktuelle Element auf das Ende der Liste.
     */
    public void toLast() {
        if (!isEmpty()) {
            this.current = this.tail;
        }
    }

    /**
     * Gibt das aktuelle Objekt zurück oder null, wenn kein aktuelles Objekt vorliegt.
     */
    public T getContent() {
        if (hasAccess()) {
            return this.current.getContent();
        }
        return null;
    }

    /**
     * Setzt das Objekt des aktuellen Elements.
     */
    public void setContent(T content) {
        if (content != null && hasAccess()) {
            this.current.setContent(content);
        }
    }

    /**
     * Fügt ein Element an der aktuellen Stelle ein.
     */
    public void insert(T content) {
        if (content == null) {
            return;
        }
        if (!hasAccess()) {
            if (!isEmpty()) {
                return;
            }
            Node next = new Node(content);
            this.head = this.tail = next;
            return;
        }
        Node next = new Node(content);
        if (this.current != this.head) {
            Node previous = getPrevious(current);
            next.setNext(previous.getNext());
            previous.setNext(next);
        } else {
            next.setNext(this.head);
            this.head = next;
        }
    }

    private class Node {
        private T content;
        private Node next;

        public List(T content) {
            this.content = content;
        }

        public T getContent() {
            return this.content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}