import java.util.Arrays;

public class NonRandomPivotSort {

    // Method to execute quicksort using a fixed pivot (last element)
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotPos = divide(arr, left, right);
            sort(arr, left, pivotPos - 1);  // Sort the left partition
            sort(arr, pivotPos + 1, right); // Sort the right partition
        }
    }

    // Function to divide the array based on pivot
    public static int divide(int[] arr, int left, int right) {
        int pivot = arr[right];  // The last element is the pivot
        int index = left - 1;    // Position for smaller elements

        for (int current = left; current < right; current++) {
            if (arr[current] <= pivot) {
                index++;
                swap(arr, index, current); // Swap elements smaller than pivot
            }
        }

        swap(arr, index + 1, right);  // Move the pivot to its correct place
        return index + 1;  // Return pivot's new index
    }

    // Helper function to swap two elements in the array
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        int[] data = { 30, 50, 70, 90, 40, 20, 80 };
        System.out.println("Initial array: " + Arrays.toString(data));

        sort(data, 0, data.length - 1);
        System.out.println("Sorted array (Non-Random pivot): " + Arrays.toString(data));
    }
}
