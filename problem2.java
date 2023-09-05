//## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// approach: This problem will use a modified binary search. Once we enter the loop/iteration we will check if the subarray we have is sorted (and not roatated) if that's the case we will return nums[low]. If that't not the case we will check if element at mid is less than both its neighbours, if yes it's the minimum element. If not, we will try to move towards the non-sorted side of the given subarray (we know that roatated sorted array has atleast one sorted side).


class Solution {
    public int findMin(int[] nums) {
     
        int low =0;
        int high = nums.length-1;

        int mid;

        while(high>=low)
        {
            mid = low +(high-low)/2;
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }

            if((mid==0 || nums[mid-1]>nums[mid]) && (mid==nums.length-1 || nums[mid+1]>nums[mid]))
            {
                return nums[mid];
            }
            else if(nums[mid]>=nums[low])
            {
                low =mid+1;
            }
            else
            {
                high =mid-1;
            }
        }
        return 12456;
        
    }
}