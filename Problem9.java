// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstBinarySearch(nums, target, 0, nums.length-1);
        if (first == -1) return new int[]{-1,-1};
        int second = secondBinarySearch(nums, target, first, nums.length-1);
        return new int[]{first, second};
    }

    public static int firstBinarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int secondBinarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}