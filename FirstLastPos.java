
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach in three sentences only:
// I used binary search twice: once to find the first occurrence and once to find the last occurrence of the target.
// If the target is found, I update the answer and continue the search in the left or right half depending on whether I'm looking for the first or last position.
// This ensures we get the exact range (start and end index) of the target in O(log n) time.

public class FirstLastPos {
    public int[] searchRange(int[] nums, int target) {
        // Initialize result array with default values [-1, -1]
        int[] ans = {-1, -1};

        // Perform binary search to find the first occurrence of target
        ans[0] = binarySearch(nums, target, true);

        // Perform binary search to find the last occurrence of target
        ans[1] = binarySearch(nums, target, false);

        // Return the resulting range
        return ans;
    }

    // Helper method to perform binary search
    // If `first` is true, it finds the first occurrence of the target
    // If `first` is false, it finds the last occurrence of the target
    public int binarySearch(int[] nums, int target, boolean first) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                // Target is on the right half
                start = mid + 1;
            } else if (nums[mid] > target) {
                // Target is on the left half
                end = mid - 1;
            } else {
                // Found the target at index `mid`
                ans = mid;

                // If we're finding the first occurrence, move left
                if (first) {
                    end = mid - 1;
                } else {
                    // Otherwise, move right to find the last occurrence
                    start = mid + 1;
                }
            }
        }

        // Return the index of the first or last occurrence (or -1 if not found)
        return ans;
    }

    public static void main(String[] args) {
        FirstLastPos sol = new FirstLastPos();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        // Call searchRange method
        int[] result = sol.searchRange(nums, target);

        // Print the result
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
