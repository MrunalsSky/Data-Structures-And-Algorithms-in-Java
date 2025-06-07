
# Revision Notes: Basic Sorting Algorithms

## Selection Sort

### Core Idea

The main idea of Selection Sort is to divide the list into two parts: a **sorted part** on the left and an **unsorted part** on the right. Initially, the sorted part is empty.

In each step, the algorithm finds the **smallest** element from the unsorted part and swaps it to the end of the sorted part.

### How it Works
1.  **Select a starting point.** Let's say this is the first element (`i=0`).
2.  **Find the minimum.** Compare this element with all the other elements that come after it (`i+1`, `i+2`, ...).
3.  **Remember the smallest.** Keep track of the position of the smallest element you've found so far in the unsorted section.
4.  **Swap.** After checking all the elements, swap the element at your starting point (`i`) with the smallest element you found.
5.  **Move on.** The first element is now sorted. Move your starting point to the next position (`i=1`) and repeat the process until the entire array is sorted.

![Animation of Selection Sort](../../assets/selection-600.gif)

### Time Complexity: `O(n²)`

*   **Why?** The algorithm has two nested loops. The outer loop runs `n` times to select a position. The inner loop runs roughly `n` times for each of those selections to find the minimum element. This `n * n` behavior gives it a quadratic time complexity, making it slow for large lists.

---

## Bubble Sort

### Core Idea

The name is a great analogy! Think of the largest numbers as "bubbles" in water that slowly rise to the top.

The algorithm repeatedly steps through the list, **compares adjacent (side-by-side) elements**, and swaps them if they are in the wrong order. After the first full pass, the largest element will have "bubbled up" to its correct position at the very end of the array.

### Basic Bubble Sort

The simplest implementation involves two nested loops.

#### Pseudocode

```java
// Outer loop for each pass
for (i = 0; i < n - 1; i++) {
    // Inner loop for comparing adjacent elements
    // The "- i" is a small optimization, as the end elements are already sorted
    for (j = 0; j < n - 1 - i; j++) {
        // If the left element is greater than the right one, swap them
        if (a[j] > a[j+1]) {
            swap(a[j], a[j+1]);
        }
    }
}
```

**The Problem with the Basic Version:** It's wasteful. Even if the array becomes sorted after the first pass, the algorithm will continue running all the other passes because it has no way of knowing it's finished.

### Improved Bubble Sort (with "Early Exit")

We can easily improve this by checking if any swaps were made during a pass.

**The Logic:** If we complete a full pass through the inner loop and don't make a single swap, it means the array is already sorted! We can then break out of the main loop and finish early.

#### Pseudocode

```java
// Outer loop for each pass
for (i = 0; i < n - 1; i++) {
    // A flag to check if a swap happened in this pass
    boolean didSwap = false;

    // Inner loop for comparing adjacent elements
    for (j = 0; j < n - 1 - i; j++) {
        if (a[j] > a[j+1]) {
            swap(a[j], a[j+1]);
            // If we swap, set the flag to true
            didSwap = true;
        }
    }

    // If no swaps happened in this full pass, the array is sorted.
    if (didSwap == false) {
        break; // Exit the loop early
    }
}
```

![Animation of Bubble Sort](../../assets/bubble-640.gif)

### Time Complexity

*   **Worst & Average Case: `O(n²)`**
  *   This happens when the list is in reverse order. The algorithm needs to perform the maximum number of swaps and passes.
*   **Best Case (Improved Version): `O(n)`**
  *   This is a key advantage of the improved version. If the array is **already sorted**, the algorithm will make one full pass, see that `didSwap` is still `false`, and exit immediately.