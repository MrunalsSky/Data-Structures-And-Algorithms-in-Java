package searching;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingMain {

    /**
     * Time Complexity: Worst case = O(n), Best case = O(1)
     * Space Complexity: Input Space = O(n), Auxiliary Space = O(1)
    */
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    /**
     * Time Complexity: Worst case = O(logn), Best case = O(1)
     * Space Complexity: Input Space = O(n), Auxiliary Space = O(1)
    */
    public static int iterativeBinarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (key == arr[mid]) return mid;
            if (key < arr[mid]) // focus on left partition
                right = mid - 1;
            if (key > arr[mid]) // focus on right partition
                left = mid + 1;
        }
        return -1;
    }

    /**
     * Time Complexity: Worst case = O(logn), Best case = O(1)
     * Space Complexity: Input Space = O(n), Auxiliary Space = O(1)
     */
    public static int recBinarySearch(int[] arr, int left, int right, int key) {
        int index = -1, mid = (left + right) / 2;
        if (right < left) return -1;
        if (key == arr[mid]) return mid;
        if (key < arr[mid]) index = recBinarySearch(arr, left, mid - 1, key);
        if (key > arr[mid]) index = recBinarySearch(arr, mid + 1, right, key);
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {88, 33, 66, 44, 77, 22, 55, 11};
        Arrays.sort(arr);

        System.out.println("Enter key to search:");
        int key = sc.nextInt();

        // can work on sorted or non-sorted array
        int index = linearSearch(arr, key);
        if (index != -1) System.out.println("Linear Search - Key found at index:" + index);
        else System.out.println("Key not found.");

        // can only work on sorted array
        index = iterativeBinarySearch(arr, key);
        if (index != -1) {
            System.out.println("Binary Search - Key found at index:" + index);
        } else {
            System.out.println("Key not found.");
        }

        index = recBinarySearch(arr, 0, arr.length - 1, key);
        if (index != -1) {
            System.out.println("Recursive Binary Search - Key found at index:" + index);
        } else {
            System.out.println("Key not found.");
        }
    }
}
