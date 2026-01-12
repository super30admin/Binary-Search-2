// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just needed to carefully handle first and last occurrence separately.


// Your code here along with comments explaining your approach in three sentences only
// We run binary search two times, one to find the first occurrence and one to find the last occurrence of the target.
// When we find the target, we store the index and continue searching in the required direction to extend the boundary.
// This keeps the total time complexity in O(log n).

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = findPos(nums, target, true);
        int last = findPos(nums, target, false);

        return new int[]{first, last};
    }

    private int findPos(int[] nums, int target, boolean findFirst) {

        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                if (findFirst) high = mid - 1;
                else low = mid + 1;
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
