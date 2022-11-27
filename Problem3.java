// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //if last element or mid value is greater than next value of mid
            //and if its first element or mid value is greater than previous value return mid value.
            if((mid == nums.length-1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1])) {
                return mid;
                //else if mid value is greater than next value binary search on right side else binary search on left side
            } else if(nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}