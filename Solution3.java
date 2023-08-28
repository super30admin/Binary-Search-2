// Leetcode problem : https://leetcode.com/problems/find-peak-element/description/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 I check if mid == 0 or nums[mid]>nums[mid-1] && mid==nums.length-1 and nums[mid]>nums[mid+1]. If so I return mid. Else if mid not equals 0 and nums[mid-1]>nums[mid] I set high=mid-1. Else I 
 set low = mid+1.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1])&& (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid != 0 && nums[mid-1]>nums[mid])
            {
                high=mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}