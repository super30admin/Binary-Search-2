// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// If mid is 0 or element at mid is greater than element at mid-1 AND mid is last index or element at mid is greater than element at mid +1, return mid.
// If element at mid +1 index is greater than element at mid, move low to mid+1 else move high to mid-1
class Solution3 {
    public int findPeakElement(int[] nums) {
        int low = 0,high=nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid+1]>nums[mid])
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