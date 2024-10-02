
/* Benchmark for Sorting Algoritms  */

 /*
    RAM : 8GB
    CPU : Intel Core i7   2.10 GHz
    OS  : Windows 11 
 */

import java.util.Arrays;
import java.util.Random;

public class SortBenchmark {

    public static void main(String[] args) {
        int[] sizes = {5, 10, 20, 100, 500, 1000, 5000, 10000, 20000,100000,6000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] array = rand.ints(size, 0, 10000).toArray();
            
            // Insertion Sort
            int[] arrCopy = Arrays.copyOf(array, array.length);
            long startTime = System.currentTimeMillis();
            insertionSort(arrCopy);
            long endTime = System.currentTimeMillis();
            System.out.println("Insertion Sort Time for size " + size + ": " + (endTime - startTime) + " ms");

            // Selection Sort
            arrCopy = Arrays.copyOf(array, array.length);
            startTime = System.currentTimeMillis();
            selectionSort(arrCopy);
            endTime = System.currentTimeMillis();
            System.out.println("Selection Sort Time for size " + size + ": " + (endTime - startTime) + " ms");

            // Bubble Sort
            arrCopy = Arrays.copyOf(array, array.length);
            startTime = System.currentTimeMillis();
            bubbleSort(arrCopy);
            endTime = System.currentTimeMillis();
            System.out.println("Bubble Sort Time for size " + size + ": " + (endTime - startTime) + " ms");
        }
    }

    // Implementing insertion sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Implementing selection sort
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Implementing bubble sort
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

