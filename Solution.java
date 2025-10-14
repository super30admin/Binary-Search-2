// Problem Name: Find the First and Last Position of an Element in given Sorted Array

// Source Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

//Time Complexity: O(Logn)
//Space Complexity: O(1)
//Approach:
//   1. Find the middle then we will run two for loop the first will first will find the first time we see the index of targer and store in first
// 2. Simialrly we will find the second. 
// 3. First loop will move the left direction from the mid and secon d loop will find the target on right side so that way entire array is searched

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    
    // Find first occurrence
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // keep searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    // Find last occurrence
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // keep searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }
}
