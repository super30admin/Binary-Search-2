//## Problem 3: (https://leetcode.com/problems/find-peak-element/)

// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// approach: We will perform a binary search. Where the check would be to see if the middle element is bigger than the neighbouring elements. And while choosing to move towards the left or right side, we compare if the element towards the right is bigger than mid, if it's true we move right otherwise we move left.


class Solution {
    public int findPeakElement(int[] nums) {

        int low =0 ;
        int high = nums.length-1;
        int mid;

        while(low<=high)
        {
            mid = low +(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid+1]>nums[mid])
            {
                low = mid+1;
            }
            else
            {
                high =mid-1;
            }
        }
        return -1;
        
    }
}