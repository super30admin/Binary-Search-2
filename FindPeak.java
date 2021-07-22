// Time Complexity : O(Lg N) where N = size of the array.
// Space Complexity : O(1). No extra space.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Yes. On thinking how to use BS on unsorted array

class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if(nums.length > 0)
        {
            if(nums.length == 1)
            {
                // That element itself is peak
                return 0;
            }

            if(nums.length == 2)
            {
                // compare two and return the index of larger
                return nums[0] > nums[1] ? 0 : 1;
            }

            //Simple BinarySearch
            while(lo <= hi)
            {
                int mid = lo + (hi - lo) / 2;
                //check if index in range
                if(mid > 0 && nums[mid] < nums[mid - 1])
                {
                    // Means Peak is at left side
                    hi = mid - 1;
                }
                //check if index in range
                else if(mid < nums.length - 1 && nums[mid] < nums[mid + 1])
                {
                    // Means Peak is at right side
                    lo = mid + 1;
                }
                else
                {
                    // Means This is Peak
                    return mid;
                }
            }
        }
        return -1;
    }
}