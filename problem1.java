//Time complexity O(logn)
//Space Complexity O(1)

class Solution {

    private int getBoundries(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] output = { -1, -1 };

        int leftIdx = getBoundries(nums, target, true);

        output[0] = leftIdx;
        output[1] = getBoundries(nums, target, false) - 1;

        return output;
    }
}