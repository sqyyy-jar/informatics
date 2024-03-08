package y24.m03.d07;

import java.util.Objects;

public class Testing {
    public static void assertThat(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }

    public static <T>void assertEq(T left, T right) {
        if (!Objects.equals(left, right)) {
            throw new AssertionError(left + " != " + right);
        }
    }

    public static void testQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertThat(queue.dequeue() == 1);
        assertThat(queue.dequeue() == 2);
    }

    public static void testQueueAscending() {
        {
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(1);
            queue.enqueue(3);
            queue.insertSortedAscending(2);
            assertThat(queue.dequeue() == 1);
            assertThat(queue.dequeue() == 2);
            assertThat(queue.dequeue() == 3);
        }
        {
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(1);
            queue.insertSortedAscending(2);
            assertThat(queue.dequeue() == 1);
            assertThat(queue.dequeue() == 2);
        }
        {
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(2);
            queue.insertSortedAscending(1);
            assertThat(queue.dequeue() == 1);
            assertThat(queue.dequeue() == 2);
        }
    }

    public static void testQueueDescending() {
        {
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(3);
            queue.enqueue(1);
            queue.insertSortedDescending(2);
            assertThat(queue.dequeue() == 3);
            assertThat(queue.dequeue() == 2);
            assertThat(queue.dequeue() == 1);
        }
        {
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(1);
            queue.insertSortedDescending(2);
            assertThat(queue.dequeue() == 2);
            assertThat(queue.dequeue() == 1);
        }
        {
            Queue<Integer> queue = new Queue<>();
            queue.enqueue(2);
            queue.insertSortedDescending(1);
            assertThat(queue.dequeue() == 2);
            assertThat(queue.dequeue() == 1);
        }
    }

    public static void testStack() {
        Stack<Integer> stack = new Stack<>();
        assertThat(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop() == 2);
        assertThat(stack.pop() == 1);
    }

    public static void testStackAscending() {
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(3);
            stack.insertSortedAscending(2);
            assertThat(stack.pop() == 3);
            assertThat(stack.pop() == 2);
            assertThat(stack.pop() == 1);
        }
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.insertSortedAscending(2);
            assertThat(stack.pop() == 2);
            assertThat(stack.pop() == 1);
        }
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(2);
            stack.insertSortedAscending(1);
            assertThat(stack.pop() == 2);
            assertThat(stack.pop() == 1);
        }
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(3);
            stack.push(2);
            stack.push(1);
            stack.sortAscending();
            assertEq(stack.pop(), 3);
            assertEq(stack.pop(), 2);
            assertEq(stack.pop(), 1);
        }
    }

    public static void testStackDescending() {
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(3);
            stack.push(1);
            stack.insertSortedDescending(2);
            assertThat(stack.pop() == 1);
            assertThat(stack.pop() == 2);
            assertThat(stack.pop() == 3);
        }
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.insertSortedDescending(2);
            assertThat(stack.pop() == 1);
            assertThat(stack.pop() == 2);
        }
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(2);
            stack.insertSortedDescending(1);
            assertThat(stack.pop() == 1);
            assertThat(stack.pop() == 2);
        }
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.sortDescending();
            assertEq(stack.pop(), 1);
            assertEq(stack.pop(), 2);
            assertEq(stack.pop(), 3);
        }
    }

    public static void main(String[] args) {
        testQueue();
        testQueueAscending();
        testQueueDescending();
        testStack();
        testStackAscending();
        testStackDescending();
    }
}
