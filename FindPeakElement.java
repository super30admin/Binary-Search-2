// Time Complexity : O(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Used binary search to find the index with smaller elements on its sides. Compare the mid with its immediate neighbors,
//            to find the larger neighbor and move the binary search window to that half to find a peak.

// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1, mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // else if((mid==0 && nums[mid+1]>nums[mid]) || nums[mid+1]>nums[mid-1]){
            // low=mid+1;
            // }
            // else{
            // high=mid-1;
            // }
            else if (mid != 0 && nums[mid - 1] > nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}