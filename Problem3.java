// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo+(hi - lo) / 2;
            if (nums[mid] > nums[mid + 1])
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}