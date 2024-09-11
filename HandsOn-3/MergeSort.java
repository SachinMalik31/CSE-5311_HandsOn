

 /*     Q-6. Implement merge sort and show/test it on the array [5,2,4,7,1,3,2,6].     */
  
  
  
import java.util.Arrays;

public class MergeSort {

    // Function to merge two halves
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two halves into the main array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // If any elements left in the left half
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // If any elements left in the right half
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Function to implement merge sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case: array is already sorted
        }

        // Find the midpoint of the array
        int mid = arr.length / 2;

        // Split the array into two halves
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    public static void main(String[] args) {
        // Test array
        int[] arr = {5, 2, 4, 7, 1, 3, 2, 6};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Call mergeSort function
        mergeSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}






/*
    Result :
                 Original Array: [5, 2, 4, 7, 1, 3, 2, 6]
      		  Sorted Array :  [1, 2, 2, 3, 4, 5, 6, 7]



 */

