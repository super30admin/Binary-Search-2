// Time: O(log N)n is length of nums
// Space: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums.length == 1) return 0;
         while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            } 
        }
        return lo;
    }
}
