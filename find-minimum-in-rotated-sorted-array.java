// Time Complexity : o(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

//we are performing the binary search in the unsorted part of the array, 
//and finding the minimum element

class Solution {
    public int findMin(int[] nums) {
        // base case
        if (nums.length == 1)
            return nums[0];
        // logic
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] <= nums[r])
                return nums[l];
            int mid = l + (r - l) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if (nums[l] <= nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return 0;
    }
}