// Time Complexity : O(log(n))
// Space Complexity : O(1) 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }

        int firstIndex = findFirstIndex(nums, target);

        if (firstIndex == -1) {
            return new int[] {-1,-1};
        }

        int lastIndex = findLastIndex(nums, target);

        return new int[] {firstIndex, lastIndex};
    }

    private int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid  = low + (high - low) / 2;
            
            if (target == nums[mid] && (mid == 0 || target != nums[mid - 1])) {
                return mid;
            }

            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid  = low + (high - low) / 2;
            
            if (target == nums[mid] && (mid == nums.length - 1 || target != nums[mid + 1])) {
                return mid;
            }

            if (target >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}