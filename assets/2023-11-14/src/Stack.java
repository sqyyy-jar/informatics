import java.util.Math;

public class Stack<T> {
    private static final float GROWTH_FACTOR = 1.5;
    private T[] content;
    private int size;

    public Stack() {
        this(16);
    }

    public Stack(int capacity) {
        this.content = new T[Math.max(0, capacity)];
    }

    public void push(T element) {
        if (size() >= capacity()) {
            resize(Math.max(1, (int)((float)capacity() * GROWTH_FACTOR)));
        }
        content[size++] = element;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        --size;
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }
        return content[size - 1];
    }

    public int capacity() {
        return content.length;
    }

    public int size() {
        return size;
    }

    public int isEmpty() {
        return size() < 1;
    }

    public void resize(int capacity) {
        if (capacity <= capacity()) {
            return;
        }
        T[] newContent = new T[capacity];
        for (int i = 0; i < size(); i++) {
            newContent[i] = content[i];
        }
        content = newContent;
    }
}