# Revision Notes: Searching Algorithms

## 1. Linear Search

Linear Search is the most straightforward searching algorithm. It sequentially checks each element of the list until a match is found or the whole list has been searched.

### Core Concept
- Iterate through the collection from the first element (`index 0`).
- At each element, compare it to the target `key`.
- If they match, return the current index.
- If the end of the collection is reached without a match, the `key` is not present.

### Key Characteristics

| Property                  | Value                                                              |
| ------------------------- | ------------------------------------------------------------------ |
| **Time Complexity**       | `O(n)` (Worst/Average Case) <br> `O(1)` (Best Case: key is at index 0) |
| **Space Complexity**      | `O(1)` (Auxiliary Space)                                           |
| **Requires Sorted Array?** | **No**. This is its main advantage.                                |

### When to Use
- When the data is **unsorted**.
- For very **small datasets** where the overhead of sorting for a more complex search isn't worth it.

### Code Breakdown (`linearSearch`)
```java
public static int linearSearch(int[] arr, int key) {
    // Loop through every single element
    for (int i = 0; i < arr.length; i++) {
        // If a match is found, immediately exit and return the index
        if (arr[i] == key)
            return i;
    }
    // If the loop completes, no match was found
    return -1;
}
```

---

## 2. Binary Search

Binary Search is a highly efficient "Divide and Conquer" algorithm. It works by repeatedly dividing the search interval in half.

### PRE-CONDITION
The input array **MUST BE SORTED** for Binary Search to work correctly. The logic relies on being able to discard half the dataset based on an ordered comparison.

### Core Concept
1.  Compare the `key` with the middle element of the sorted array.
2.  If the `key` matches, the search is successful.
3.  If the `key` is less than the middle element, it can only be in the **left half** of the array. Discard the right half.
4.  If the `key` is greater than the middle element, it can only be in the **right half** of the array. Discard the left half.
5.  Repeat this process on the remaining (smaller) sub-array until the `key` is found or the sub-array is empty.

---

### 2.1. Iterative Binary Search

This version uses a `while` loop to manage the search space. It is generally preferred in production code.

#### Key Characteristics

| Property             | Value                                 | Notes                                                            |
| -------------------- | ------------------------------------- | ---------------------------------------------------------------- |
| **Time Complexity**  | `O(log n)` (Worst/Average) <br> `O(1)` (Best) | Halving the search space at each step is incredibly fast.        |
| **Space Complexity** | `O(1)` (Auxiliary Space)              | Only uses a few variables (`left`, `right`, `mid`). Very efficient.|

#### Code Breakdown (`iterativeBinarySearch`)
```java
public static int iterativeBinarySearch(int[] arr, int key) {
    // 'left' and 'right' define the current search window
    int left = 0, right = arr.length - 1;

    // Continue as long as the search window is valid
    while (left <= right) {
        // Calculate the middle index
        int mid = left + (right - left) / 2; // Safer way to prevent integer overflow

        if (key == arr[mid])
            return mid; // Found it!

        if (key < arr[mid]) // Key must be in the left partition
            right = mid - 1; // Discard the right half
        
        else // Key must be in the right partition
            left = mid + 1; // Discard the left half
    }
    return -1; // Search window is empty, key not found
}
```
> **Pro Tip:** Using `mid = left + (right - left) / 2` instead of `mid = (left + right) / 2` prevents a potential integer overflow bug if `left` and `right` are very large positive numbers.

---

### 2.2. Recursive Binary Search

This version uses the function call stack to implement the "divide and conquer" logic. It's often more elegant to read but can be less efficient in terms of space.

#### Key Characteristics

| Property             | Value                                 | Notes                                                              |
| -------------------- | ------------------------------------- | ------------------------------------------------------------------ |
| **Time Complexity**  | `O(log n)` (Worst/Average) <br> `O(1)` (Best) | Same as the iterative version.                                     |
| **Space Complexity** | `O(log n)` (Auxiliary Space)          | Each recursive call adds a new frame to the call stack.            |

#### Code Breakdown (`recBinarySearch`)
```java
public static int recBinarySearch(int[] arr, int left, int right, int key) {
    // Base Case: If the search window is invalid, the key is not here.
    if (right < left)
        return -1;

    int mid = left + (right - left) / 2;

    if (key == arr[mid])
        return mid; // Found it!

    // Recursive Step: Call the same function on the appropriate half
    if (key < arr[mid])
        return recBinarySearch(arr, left, mid - 1, key); // Recurse on the left
    else
        return recBinarySearch(arr, mid + 1, right, key); // Recurse on the right
}
```

## 3. Summary & Comparison

| Algorithm                 | Time Complexity (Worst) | Space Complexity (Auxiliary) | Requires Sorted Array? |
| ------------------------- | ----------------------- | ---------------------------- | ---------------------- |
| **Linear Search**         | `O(n)`                  | `O(1)`                       | No                     |
| **Iterative Binary Search** | `O(log n)`              | `O(1)`                       | **Yes**                |
| **Recursive Binary Search** | `O(log n)`              | `O(log n)`                   | **Yes**                |