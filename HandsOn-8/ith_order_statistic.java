import java.util.Random;

public class QuickSelect {

    // Helper function to swap elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Randomized partition function for quickselect
    private static int randomizedPartition(int[] array, int start, int end) {
        Random random = new Random();
        int randIndex = start + random.nextInt(end - start + 1); // Generate random index between start and end
        swap(array, randIndex, end); // Swap random element with the last element
        
        int pivot = array[end];
        int pivotIndex = start;
        
        for (int j = start; j <= end - 1; j++) {
            if (array[j] <= pivot) {
                swap(array, pivotIndex, j);
                pivotIndex++;
            }
        }
        
        swap(array, pivotIndex, end); // Put pivot in its correct place
        return pivotIndex;
    }

    // Randomized quickselect function to find the ith order statistic
    private static int randomizedQuickSelect(int[] array, int start, int end, int i) {
        if (start < end) {
            int q = randomizedPartition(array, start, end);
            int k = q - start + 1;

            if (i == k) {
                return array[q]; // Found the ith smallest element
            } else if (i < k) {
                return randomizedQuickSelect(array, start, q - 1, i);
            } else {
                return randomizedQuickSelect(array, q + 1, end, i - k);
            }
        } else {
            return array[start]; // When start == end, we have found the element
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 45, 23, 51, 19, 33, 28, 36};  // Input array
        int n = array.length;
        int i = 4; // We are looking for the 4th smallest element (ith order statistic)

        int result = randomizedQuickSelect(array, 0, n - 1, i);
        System.out.println("The 4th order statistic of the array is: " + result);
    }
}

// Output :  The 4th order statistic of the array is: 28
