class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        if(nums[l] <= nums[r]) {
            return nums[l];
        }
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[l] <= nums[r]) {
                return nums[l];
            }
            if((m == 0 || nums[m] < nums[m - 1]) && (m == nums.length - 1 || nums[m] < nums[m + 1])) {
                return nums[m];
            }
            if(nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}