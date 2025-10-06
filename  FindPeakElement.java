/**
 * LeetCode 162: Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 *
 * This class provides a solution to the problem of finding a peak element in an array.
 * A peak element is an element that is strictly greater than its neighbors.
 * The algorithm uses binary search to achieve O(log n) time complexity.
 */
class Solution {
    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if( (mid ==0 || nums[mid]> nums[mid -1]) && (mid == nums.length-1 || nums[mid]> nums[mid+1]))
                return  mid;
            else if(nums[mid+1] > nums[mid])
                start = mid+1;
            else
                end = mid -1;

        }

        return -1;
    }
}