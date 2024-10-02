import java.util.Arrays;
import java.util.Random;

public class RandomPivotSort {

    // Main quicksort function with a randomly chosen pivot
    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int randomPivotIdx = randomDivide(arr, start, end);
            sort(arr, start, randomPivotIdx - 1); // Recursively sort left subarray
            sort(arr, randomPivotIdx + 1, end);   // Recursively sort right subarray
        }
    }

    // Partition the array using a randomly selected pivot
    public static int randomDivide(int[] arr, int start, int end) {
        Random rand = new Random();
        int pivotIdx = rand.nextInt(end - start + 1) + start;

        // Swap the pivot element to the end
        swap(arr, pivotIdx, end);

        return partition(arr, start, end);
    }

    // Standard partition logic used in quicksort
    public static int partition(int[] arr, int start, int end) {
        int pivotValue = arr[end];  // Select the pivot element
        int smallerIdx = start - 1; // Position for smaller elements

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivotValue) {
                smallerIdx++;
                swap(arr, smallerIdx, j); // Swap smaller element
            }
        }

        // Move pivot element to its correct place
        swap(arr, smallerIdx + 1, end);
        return smallerIdx + 1;
    }

    // Helper function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test random pivot quicksort
    public static void main(String[] args) {
        int[] data = { 30, 50, 70, 90, 40, 20, 80 };
        System.out.println("Original array: " + Arrays.toString(data));

        sort(data, 0, data.length - 1);
        System.out.println("Sorted array (Random Pivot): " + Arrays.toString(data));
    }
}
