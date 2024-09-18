
import java.util.Arrays;

public class RemoveDuplicates {

    // Function to remove duplicates and return a new array with unique elements
    public static int[] eliminateDuplicates(int[] array) {
        if (array.length == 0) return new int[0];

        int uniquePosition = 1; // Start from the second element
        for (int i = 1; i < array.length; i++) {
            // If the current element is different from the previous, store it in the unique part
            if (array[i] != array[i - 1]) {
                array[uniquePosition] = array[i];
                uniquePosition++;
            }
        }

        // Return only the unique portion of the array
        return Arrays.copyOf(array, uniquePosition);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 2, 2, 2};
        int[] uniqueArr1 = eliminateDuplicates(arr1);
        System.out.println("Array after removing duplicates (case 1): " + Arrays.toString(uniqueArr1));

        int[] arr2 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] uniqueArr2 = eliminateDuplicates(arr2);
        System.out.println("Array after removing duplicates (case 2): " + Arrays.toString(uniqueArr2));
    }
}
