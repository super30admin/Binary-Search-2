// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Here check if the left and right adjacent element are less than the mid element. If yes, then it is the peak.
 * If no, then move low to mid+1 if nums[mid] < nums[mid+1], else move high to mid-1
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if((low == mid || nums[mid] > nums[mid-1]) && (high == mid || nums[mid] > nums[mid+1]))
                return mid;
            else if(nums[mid] < nums[mid+1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}