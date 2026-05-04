// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
In a rotated sorted array, one half of the array is sorted and the other is not. 

Base condition - if array/subarray is sorted, return first element as that's the smallest element

If mid element is the first element or it's smaller than it's previous element and if the mid element is the last element or it's smaller
than the next element, return that element as it's the smallest element in the array.

Else if first half of the array is sorted, search through the other half for the minima or vice-versa.
*/

public class Solution {
    public int FindMin(int[] nums) {
        int low = 0, high = nums.Length - 1;

        while(low <= high)
        {
            if(nums[low] <= nums[high])
            {
                return nums[low];
            }

            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.Length - 1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }

            else if(nums[low] <= nums[mid])
            {
                low = mid + 1;
            }

            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
}