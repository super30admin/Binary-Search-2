//Time: O(logn) and Space: O(n)
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (m > 0 && nums[m] < nums[m - 1]) {
                r = m - 1;
            } else if (m < nums.length - 1 && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
