/**
 * Leet Code: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 1. We use binary search to find the fist and last index.
 * 2. Use one binary search to find first occurrence and one more binary search to find last occurrence.
 * 3. Time Complexity : 0(log n)
 */
class FirstLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);

        return result;
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeftBound) {
        int start = 0;
        int end = nums.length - 1;
        int idx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (isSearchingLeftBound) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return idx;
    }
}