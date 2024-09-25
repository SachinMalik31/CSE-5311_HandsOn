

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    // Constructor to build the heap from an existing array
    public MinHeap(List<T> data) {
        this.heap = new ArrayList<>();
        if (data != null && !data.isEmpty()) {
            buildMinHeap(data);
        }
    }

    // Get index of the parent node using bitwise operators
    private int parent(int i) {
        return (i - 1) >> 1; // Equivalent to (i - 1) / 2
    }

    // Get index of the left child node using bitwise operators
    private int left(int i) {
        return (i << 1) + 1; // Equivalent to 2 * i + 1
    }

    // Get index of the right child node using bitwise operators
    private int right(int i) {
        return (i << 1) + 2; // Equivalent to 2 * i + 2
    }

    // Heapify the element at index i
    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        // Check if left child exists and is smaller than the current element
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        // Check if right child exists and is smaller than the smallest found so far
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        // If the smallest element is not the parent, swap and heapify the affected sub-tree
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Build the heap using the given data
    public void buildMinHeap(List<T> data) {
        this.heap = new ArrayList<>(data);
        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Insert a new element into the heap
    public void insert(T value) {
        heap.add(value);
        int i = heap.size() - 1;

        // Bubble up the new value to its proper position
        while (i > 0 && heap.get(parent(i)).compareTo(heap.get(i)) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Pop the root node (minimum value) from the heap
    public T pop() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Pop from an empty heap");
        }

        T root = heap.get(0);
        // Replace the root with the last element
        T lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapify(0); // Restore heap property
        }
        return root;
    }

    // Peek at the root node without removing it
    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Peek from an empty heap");
        }
        return heap.get(0);
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Print the heap (for debugging purposes)
    @Override
    public String toString() {
        return heap.toString();
    }

    // Main method demonstrating the functionality of MinHeap
    public static void main(String[] args) {
        // Example 1: Initial heap construction with integer values
        List<Integer> data = List.of(8, 3, 4, 1, 3, 9, 2);
        MinHeap<Integer> heap = new MinHeap<>(data);
        System.out.println("Example 1:");
        System.out.println("Initial heap: " + heap);

        // Pop the root node (smallest element)
        System.out.println("Popped element: " + heap.pop());
        System.out.println("Heap after pop: " + heap);

        // Insert new elements
        heap.insert(4);
        heap.insert(8);
        System.out.println("Heap after insertions: " + heap);

        // Peek at the root (minimum element)
        System.out.println("Peek at root: " + heap.peek());

        // Pop all elements to demonstrate functionality
        while (!heap.isEmpty()) {
            System.out.println("Popped element: " + heap.pop());
            System.out.println("Heap: " + heap);
        }

        // Example 2: Another heap demonstration
        System.out.println("\nExample 2:");
        List<Integer> data2 = List.of(13, 3, 1, 9, 37, 19, 6);
        MinHeap<Integer> heap2 = new MinHeap<>(data2);
        System.out.println("Initial heap: " + heap2);

        // Check if the heap is empty
        System.out.println("Is heap empty? " + heap2.isEmpty());

        // Peek at the root element
        System.out.println("Peek at root: " + heap2.peek());

        // Insert elements into the heap
        heap2.insert(3);
        heap2.insert(2);
        System.out.println("Heap after insertions (3, 2): " + heap2);

        // Pop the root (smallest element)
        System.out.println("Popped element: " + heap2.pop());
        System.out.println("Heap after pop: " + heap2);

        // Pop all elements and display heap after each pop
        while (!heap2.isEmpty()) {
            System.out.println("Popped element: " + heap2.pop());
            System.out.println("Heap: " + heap2);
        }

        // Final check if the heap is empty
        System.out.println("Is heap empty: " + heap2.isEmpty());
    }
}
