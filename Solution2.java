// Leetcode problem : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 In a rotated sorted array, one half of the array is sorted. So at first, I check if nums[low]<=nums[high], If so I return nums[low]. Then I calculate mid and check if mid is less than elements on both sides
 or mid is 0 or mid = nums.length-1. If so I return nums[mid]. If not, I set low = mid+1 if the array is left sorted or set high = mid-1 if otherwise.
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0 , high = nums.length-1;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) && (nums[mid]<nums[mid+1] || mid==nums.length-1))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low = mid+1;
            }
            else
            {
                high=mid-1;
            }

        }
        return -1;
    }
}