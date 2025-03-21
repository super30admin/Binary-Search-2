// Time Complexity : O(log n) for each binary search, so overall O(log n) + O(log n) = O(log n)
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only:
// The approach uses binary search to find the first and last occurrence of the target in the sorted array.
// The `search` method is used twice: once to find the starting index and once to find the ending index.
// Depending on the `findStartIndex` flag, the binary search adjusts the search space to locate the desired index.

public class FindFirstLast {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1}; // Initialize result array with -1, -1
        int start = search(nums, target, true); // Find the starting index of the target
        int end = search(nums, target, false); // Find the ending index of the target

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1; // Initialize answer to -1
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid to avoid overflow
            if (target < nums[mid]) {
                end = mid - 1; // Target is in the left half
            } else if (target > nums[mid]) {
                start = mid + 1; // Target is in the right half
            } else {
                // Target found, update answer
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1; // Narrow down to find the first occurrence
                } else {
                    start = mid + 1; // Narrow down to find the last occurrence
                }
            }
        }
        return ans;
    }
}
