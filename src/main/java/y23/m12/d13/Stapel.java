package y23.m12.d13;

public class Stapel {
    private Teller top;

    public boolean isEmpty() {
        return this.top == null;
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        return this.top.getContent();
    }

    public void push(Object content) {
        if (content == null) {
            return;
        }
        Teller teller = new Teller(content);
        teller.setNext(this.top);
        this.top = teller;
    }

    public void pop() {
        if (!isEmpty()) {
            this.top = this.top.getNext();
        }
    }

    private class Teller {
        private Object content;
        private Teller next;

        public Teller(Object content) {
            this.content = content;
        }

        public Object getContent() {
            return content;
        }

        public Teller getNext() {
            return next;
        }

        public void setNext(Teller next) {
            this.next = next;
        }
    }
}
