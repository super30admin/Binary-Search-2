class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int n = nums.length;
        int[] result = new int[] {-1, -1};
        result[0] = findFirst(nums, target);
        if(result[0] != -1) {
            result[1] = findSecond(nums, result[0], target);
        }
        return result;
    }
    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                ans = m;
                r = m - 1;
            } else if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
    private int findSecond(int[] nums, int l, int target) {
        int r = nums.length - 1;
        int ans = l;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                ans = m;
                l = m + 1;
            } else if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}