// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


/*
## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
 */
public class FindFirstPeek {

    public static int searchFirstPeek(int arr[]) {

        if(arr == null || arr.length == 0)
            return -1;
        if(arr.length == 1)
            return 0;

    int low = 0, high = arr.length - 1, mid;

        while(low <= high) {
        mid = low + (high - low) /2;
        if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == high || arr[mid] > arr[mid + 1] ))
            return mid;
        else if(arr[mid] < arr[mid +1])
            low = mid + 1;
        else
            high = mid - 1;
    }
        return -1;
 }

    public static void main(String ar[]) {
        int[] input = new int[]{1,2};

        int res = searchFirstPeek(input);

        System.out.println(" Peek is : " + res);
    }
}