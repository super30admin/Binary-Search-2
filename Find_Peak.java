// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((mid == high||nums[mid] > nums[mid+1]) &&
                (mid == low||nums[mid] > nums[mid-1])) {
                return mid;
            }
            else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
        
    }
}