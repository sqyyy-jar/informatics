package y24.m05.d06;

import org.junit.jupiter.api.Test;

import static y24.m03.d07.Testing.assertEq;
import static y24.m03.d07.Testing.assertThat;

class ListTests {
    private final List<Integer> list = new List<>();

    @Test
    void appendEmptyList() {
        list.append(1);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 1);
    }

    @Test
    void removeWithOneElement() {
        list.append(1);
        assertThat(!list.isEmpty());
        list.toFirst();
        list.remove();
        assertThat(list.isEmpty());
    }

    @Test
    void removeFirst() {
        list.append(1);
        list.append(2);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 1);
        list.remove();
        list.toFirst();
        assertEq(list.getContent(), 2);
    }

    @Test
    void removeLast() {
        list.append(1);
        list.append(2);
        assertThat(!list.isEmpty());
        list.toLast();
        assertEq(list.getContent(), 2);
        list.remove();
        list.toLast();
        assertEq(list.getContent(), 1);
    }

    @Test
    void removeMiddle() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertThat(!list.isEmpty());
        list.toFirst();
        list.next();
        assertEq(list.getContent(), 2);
        list.remove();
        list.toFirst();
        list.next();
        assertEq(list.getContent(), 3);
    }

    @Test
    void insertEmptyList() {
        list.insert(1);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 1);
    }

    @Test
    void insertFirst() {
        list.append(1);
        list.toFirst();
        list.insert(2);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 2);
    }

    @Test
    void insertMiddle() {
        list.append(1);
        list.append(2);
        list.toLast();
        list.insert(3);
        assertThat(!list.isEmpty());
        list.toFirst();
        list.next();
        assertEq(list.getContent(), 3);
    }

    @Test
    void movingAround() {
        list.append(1);
        list.append(2);
        list.append(3);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 1);
        list.next();
        assertEq(list.getContent(), 2);
        list.toLast();
        assertEq(list.getContent(), 3);
        list.previous();
        assertEq(list.getContent(), 2);
    }

    @Test
    void insertSortedFront() {
        list.insertSortedFront(4, Integer::compare);
        list.insertSortedFront(5, Integer::compare);
        list.insertSortedFront(2, Integer::compare);
        list.insertSortedFront(3, Integer::compare);
        list.insertSortedFront(1, Integer::compare);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 1);
        list.next();
        assertEq(list.getContent(), 2);
        list.next();
        assertEq(list.getContent(), 3);
        list.next();
        assertEq(list.getContent(), 4);
        list.next();
        assertEq(list.getContent(), 5);
    }

    @Test
    void insertSortedFrontEmptyList() {
        list.insertSortedFront(1, Integer::compare);
        assertThat(!list.isEmpty());
        list.toLast();
        assertEq(list.getContent(), 1);
        list.remove();
        assertThat(list.isEmpty());
    }

    @Test
    void insertSortedBack() {
        list.insertSortedBack(4, Integer::compare);
        list.insertSortedBack(5, Integer::compare);
        list.insertSortedBack(2, Integer::compare);
        list.insertSortedBack(3, Integer::compare);
        list.insertSortedBack(1, Integer::compare);
        assertThat(!list.isEmpty());
        list.toFirst();
        assertEq(list.getContent(), 1);
        list.next();
        assertEq(list.getContent(), 2);
        list.next();
        assertEq(list.getContent(), 3);
        list.next();
        assertEq(list.getContent(), 4);
        list.next();
        assertEq(list.getContent(), 5);
    }

    @Test
    void insertSortedBackEmptyList() {
        list.insertSortedBack(1, Integer::compare);
        assertThat(!list.isEmpty());
        list.toLast();
        assertEq(list.getContent(), 1);
        list.remove();
        assertThat(list.isEmpty());
    }

    @Test
    void insertionSortRandom() {
        for (int x : new int[]{4, 5, 2, 3, 1}) {
            list.append(x);
        }
        assertThat(!list.isEmpty());
        list.insertionSort(Integer::compare);
        list.toFirst();
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            assertEq(list.getContent(), x);
            list.next();
        }
    }

    @Test
    void insertionSortInverse() {
        for (int x : new int[]{5, 4, 3, 2, 1}) {
            list.append(x);
        }
        assertThat(!list.isEmpty());
        list.insertionSort(Integer::compare);
        list.toFirst();
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            assertEq(list.getContent(), x);
            list.next();
        }
    }

    @Test
    void insertionSortSorted() {
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            list.append(x);
        }
        assertThat(!list.isEmpty());
        list.insertionSort(Integer::compare);
        list.toFirst();
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            assertEq(list.getContent(), x);
            list.next();
        }
    }

    @Test
    void quickSortRandom() {
        for (int x : new int[]{4, 5, 2, 3, 1}) {
            list.append(x);
        }
        assertThat(!list.isEmpty());
        list.quickSort(Integer::compare);
        list.toFirst();
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            assertEq(list.getContent(), x);
            list.next();
        }
    }

    @Test
    void quickSortInverse() {
        for (int x : new int[]{5, 4, 3, 2, 1}) {
            list.append(x);
        }
        assertThat(!list.isEmpty());
        list.quickSort(Integer::compare);
        list.toFirst();
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            assertEq(list.getContent(), x);
            list.next();
        }
    }

    @Test
    void quickSortSorted() {
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            list.append(x);
        }
        assertThat(!list.isEmpty());
        list.quickSort(Integer::compare);
        list.toFirst();
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            assertEq(list.getContent(), x);
            list.next();
        }
    }
}