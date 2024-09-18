
import java.util.PriorityQueue;
import java.util.Arrays;

public class MergeSortedArrays {

    // Helper class to hold information about the elements in the priority queue
    static class Element implements Comparable<Element> {
        int value, arrayIndex, elementIndex;

        public Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        // Compare elements by their value for priority queue sorting
        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }

    // Merging function to combine K sorted arrays into a single sorted array
    public static int[] mergeKArrays(int[][] arrays) {
        PriorityQueue<Element> queue = new PriorityQueue<>();
        int totalLength = 0;

        // Add the first element of each array to the priority queue
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                queue.offer(new Element(arrays[i][0], i, 0));
                totalLength += arrays[i].length;
            }
        }

        int[] result = new int[totalLength];
        int index = 0;

        // Extract elements in sorted order from the queue
        while (!queue.isEmpty()) {
            Element current = queue.poll();
            result[index++] = current.value;

            // Add the next element from the same array to the queue
            if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
                queue.offer(new Element(
                    arrays[current.arrayIndex][current.elementIndex + 1],
                    current.arrayIndex, current.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays1 = {
            {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}
        };

        int[][] arrays2 = {
            {1, 3, 7},
            {2, 4, 8},
            {9, 10, 11}
        };

        int[] result1 = mergeKArrays(arrays1);
        System.out.println("Merged array (case 1): " + Arrays.toString(result1));

        int[] result2 = mergeKArrays(arrays2);
        System.out.println("Merged array (case 2): " + Arrays.toString(result2));
    }
}
