// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = searchFirst(nums, target);
        result[1] = searchLast(nums, target);

        return result;
    }

    // binary search to find the first occurrence of the target
    private int searchFirst(int[] nums, int target) {
        int left = 0; // left index
        int right = nums.length - 1; // right index
        int index = -1; // index of the first occurrence

        while (left <= right) {

            int mid = left + (right - left) / 2; // calculate the mid index

            if (nums[mid] == target) {
                index = mid; // update index of the first occurrence
                right = mid - 1; // search in the left half
            }

            else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return index;
    }

    // binary search to find the last occurrence of the target
    private int searchLast(int[] nums, int target) {
        int left = 0; // left index
        int right = nums.length - 1; // right index
        int index = -1; // index of the last occurrence

        while (left <= right) {

            int mid = left + (right - left) / 2; // calculate the mid index

            if (nums[mid] == target) {
                index = mid; // update index of the last occurrence
                left = mid + 1; // search in the right half
            }

            else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return index;
    }
}