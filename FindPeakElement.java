//TC: O(logn)
//SC: O(1)
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        //continuously look for the peak element
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
        
    }
}