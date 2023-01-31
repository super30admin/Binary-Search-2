class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int l, r;
        l = 0;
        r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}