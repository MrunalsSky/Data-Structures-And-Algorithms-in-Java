package sorting;

import java.util.Arrays;

public class SortingMain {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // execute n-1 passes
            // outer loop is for counting the passes
            for (int j = 0; j < arr.length - 1; j++) {
                //compare consecutive elements
                //if left element is greater than right element, then swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }
public static void improvedBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapFlag = false;
            // execute n-1 passes
            // outer loop is for counting the passes
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //compare consecutive elements
                //if left element is greater than right element, then swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                }

            }
            if(swapFlag == false) // if array is already sorted
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 4, 2, 8, 3, 1};
        System.out.println("Selection Sort");
        System.out.println("Before: " + Arrays.toString(arr1));
        selectionSort(arr1);
        System.out.println("After: " + Arrays.toString(arr1));

        int[] arr2 = {4, 9, 2, 8, 6, 1};
        System.out.println("Bubble Sort");
        System.out.println("Before: " + Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println("After: " + Arrays.toString(arr2));

    }
}
