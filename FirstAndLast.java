class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;
            }
        }

        if (ans.length == 0) {
            return new int[] {-1, -1};
        }

        for (int i=ans[0] + 1; i<nums.length; i++) {
            if (nums[i] != target) {
                ans[1] = i - 1;
                return;
            }
        }

        return ans;
        
    }
}