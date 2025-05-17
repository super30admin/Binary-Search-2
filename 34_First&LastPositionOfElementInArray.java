// Time Complexity : O(log n) for both findFirst and findLast, so overall O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially ensuring correct edge condition handling for first/last position logic

// Your code here along with comments explaining your approach in three sentences only:
// I used two binary searches to locate the first and last occurrences of the target in a sorted array.
// The `findFirst` method searches for the leftmost index where the target occurs, ensuring it's either the first element or greater than its left neighbor.
// The `findLast` method searches for the rightmost index, ensuring it's the last element or less than its right neighbor, both in O(log n) time.

class Solution {

    private int findFirst(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1])
                    return mid; // First occurrence
                else
                    r = mid - 1; // Move left
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1; // Target not found
    }

    private int findLast(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1])
                    return mid; // Last occurrence
                else
                    l = mid + 1; // Move right
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1; // Target not found
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int n = nums.length - 1;
        int firstIndex = findFirst(nums, 0, n, target);
        if (firstIndex == -1) return new int[]{-1, -1}; // Target not found

        int lastIndex = findLast(nums, firstIndex, n, target);
        return new int[]{firstIndex, lastIndex};
    }
}
