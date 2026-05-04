// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Base condition - If mid element is the first element or it's greater than it's previous element and if the mid element is the last element or it's greater
than the next element, return that element as it's the smallest element in the array.

Else if element at mid + 1 index is greater, proceed to search through that part of the array or check through the first part
of the array.
*/

public class Solution {
    public int FindPeakElement(int[] nums) {
        int low = 0, high = nums.Length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if((mid==0 || nums[mid] > nums[mid - 1]) && (mid==nums.Length - 1 || nums[mid] > nums[mid +1]))
            {
                return mid;
            }

            else if(nums[mid + 1] > nums[mid])
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