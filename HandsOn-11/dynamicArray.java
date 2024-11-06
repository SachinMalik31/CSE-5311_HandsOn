public class DynamicArray {
    private int[] data;         // Array to store elements
    private int capacity;       // Total available capacity
    private int size;           // Current number of elements

    // Constructor to initialize the dynamic array
    public DynamicArray() {
        this.capacity = 2;      // Initial capacity
        this.size = 0;          // Initial size
        this.data = new int[capacity];
    }

    // Method to double the array's capacity when needed
    private void resize() {
        capacity *= 2;
        int[] newData = new int[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Method to add an element to the dynamic array
    public void add(int value) {
        if (size == capacity) {
            resize();
        }
        data[size++] = value;
    }

    // Method to get an element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return data[index];
    }

    // Method to get the current size of the array
    public int getSize() {
        return size;
    }

    // Method to get the current capacity of the array
    public int getCapacity() {
        return capacity;
    }

    // Method to print all elements in the array
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        
        // Adding elements to the dynamic array
        for (int i = 0; i < 10; i++) {
            arr.add(i);
            System.out.println("Added " + i + ", Size: " + arr.getSize() + ", Capacity: " + arr.getCapacity());
        }

        // Printing all elements
        System.out.print("Array elements: ");
        arr.print();

        // Accessing elements by index
        try {
            System.out.println("Element at index 2: " + arr.get(2));
            System.out.println("Element at index 20: " + arr.get(20)); // Will throw exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}


/* 
Output :

Added 0, Size: 1, Capacity: 2
Added 1, Size: 2, Capacity: 2
Added 2, Size: 3, Capacity: 4
Added 3, Size: 4, Capacity: 4
...
Array elements: 0 1 2 3 4 5 6 7 8 9 
Element at index 2: 2
Index out of range

*/