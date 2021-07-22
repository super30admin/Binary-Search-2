// Time Complexity : O(Lg N) where N = size of the array.
// Space Complexity : O(1). No extra space.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None.

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if(nums.length > 0)
        {
            if(nums[lo] < nums[hi])
            {
                // Array isn't rotated
                return nums[lo];    
            }

            if(nums.length == 1)
            {
                // only one element so return it
                return nums[0];
            }

            if(nums.length == 2)
            {
                // In case of two compare those and return min
                return Math.min(nums[0], nums[1]);    
            }
            // Simple BinSearch.
            while(lo <= hi)
            {
                int mid = lo + (hi - lo) / 2;
                //check for index in range
                if(mid > 0 && nums[mid] < nums[mid - 1])
                {
                    // This means we have found the min element at mid index
                    return nums[mid];
                }
                //check for index in range
                if(mid < nums.length - 2 && nums[mid] > nums[mid + 1])
                {
                    // This means we have found the min element at mid + 1 index
                    return nums[mid + 1];
                }

                if(nums[mid] > nums[0])
                {
                    // This means there's no rotation in array[0 to mid]
                    // so min must be in other part
                    lo = mid + 1;
                }
                else
                {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}