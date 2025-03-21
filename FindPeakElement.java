// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Using Binary Search, finding element having value greater than its neighbours.
// Moving towards that part of array where the element is greater, as the peak lies towards the slope.



class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1])&&(mid==n-1||nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}