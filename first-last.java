// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach in three sentences only
//find start, end of the index by doing binary searches separately
// do binary search to find the target


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            

            if (nums[mid] == target) {
                int start = findStart(nums, target, low, high);
                int end = findEnd(nums, target, low, high);
                return new int[]{start, end};
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int findStart(int[] nums, int target, int low, int high) {
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return pos;
    }

    private int findEnd(int[] nums, int target, int low, int high) {
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) pos = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return pos;
    }
}
