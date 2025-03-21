# Binary-Search-2

Explain your approach in **three sentences only** at the top of your code.

---

## Problem 1: Find First and Last Position of Element in Sorted Array  
(https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

### Problem Description:
Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given target value.  
Your algorithm's runtime complexity must be in the order of O(log n).  
If the target is not found in the array, return `[-1, -1]`.

### Example:
**Input:** `nums = [5,7,7,8,8,10], target = 8`  
**Output:** `[3,4]`

**Input:** `nums = [5,7,7,8,8,10], target = 6`  
**Output:** `[-1,-1]`

### Solution:
```java
public class FindFirstLast {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1}; // Initialize result array with -1, -1
        int start = search(nums, target, true); // Find the starting index of the target
        int end = search(nums, target, false); // Find the ending index of the target

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1; // Initialize answer to -1
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid to avoid overflow
            if (target < nums[mid]) {
                end = mid - 1; // Target is in the left half
            } else if (target > nums[mid]) {
                start = mid + 1; // Target is in the right half
            } else {
                // Target found, update answer
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1; // Narrow down to find the first occurrence
                } else {
                    start = mid + 1; // Narrow down to find the last occurrence
                }
            }
        }
        return ans;
    }
}
```

---

## Problem 2: Find Minimum in Rotated Sorted Array  
(https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

### Problem Description:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.  
(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).  
Find the minimum element.  
You may assume no duplicate exists in the array.

### Example:
**Input:** `[3,4,5,1,2]`  
**Output:** `1`

**Input:** `[4,5,6,7,0,1,2]`  
**Output:** `0`

### Solution:
```java
public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
            return nums[mid]; // Found the minimum element
        } else if (nums[mid] <= nums[high]) { // Right half is sorted
            high = mid - 1;
        } else { // Left half is sorted
            low = mid + 1;
        }
    }
    return -1; // Default return value (should not reach here)
}
```

---

## Problem 3: Find Peak Element  
(https://leetcode.com/problems/find-peak-element/)

### Problem Description:
A peak element is an element that is greater than its neighbors.  
Given an input array `nums`, where `nums[i] ≠ nums[i+1]`, find a peak element and return its index.  
The array may contain multiple peaks; in that case, return the index of any one of the peaks.  
You may imagine that `nums[-1] = nums[n] = -∞`.

### Example:
**Input:** `nums = [1,2,3,1]`  
**Output:** `2`  
**Explanation:** `3` is a peak element, and its index is `2`.

**Input:** `nums = [1,2,1,3,5,6,4]`  
**Output:** `1` or `5`  
**Explanation:** Your function can return either index `1` (where the peak element is `2`) or index `5` (where the peak element is `6`).

### Solution:
```java
public class FindPeak {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Identify the mid
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid; // Found a peak element
            } else if (nums[mid + 1] > nums[mid]) { // Move towards the higher number
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Default return value (should not reach here)
    }

    public static void main(String[] args) {
        FindPeak findPeak = new FindPeak();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeak.findPeakElement(nums));
    }
}
```
