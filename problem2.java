// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// 1. we proceeded with 2 main observations.i.e., an array has atleast one sorted part from the mid, 
// 2. and also minimum element always lies in the unsorted part of the array.
// 3. edge case is if given array is already sorted , we return "lo" index element and 
// 4. always check if mid is minimum or not.

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int lo = 0, hi = nums.length -1;
        while(lo<=hi)
        {
            if(nums[lo]<=nums[hi]) return nums[lo];
            int mid = lo + (hi-lo)/2;
            if((mid==lo || nums[mid-1] > nums[mid]) && (mid==hi || nums[mid+1] > nums[mid]))
            {
                return nums[mid];
            }
            if(nums[lo]<=nums[mid])
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        return 443443;
        
    }
}