// Approach:
// We first find the first spot where the target shows up by doing a binary search and moving left when we might have found it.
// Then we find the last spot where the target shows up by doing another binary search and moving right when we might have found it.
// If we never see the target, we return [-1, -1], otherwise we return the two spots we found.


// Time Complexity : O(log n)  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No  

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums == null || nums.length == 0) {
            return result;  // nothing to search
        }

        // ---- Find first position ----
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1;

        while (left <= right) {
            // pick the middle
            int mid = left + (right - left) / 2;
            // if mid is too small, throw away left side
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // if mid is big enough, maybe it's the first or we went too far
                if (nums[mid] == target) {
                    firstPos = mid;  // remember this spot
                }
                // in either case, keep looking left
                right = mid - 1;
            }
        }

        // if we never saw the target, it's not here
        if (firstPos == -1) {
            return result;
        }
        result[0] = firstPos;

        // ---- Find last position ----
        left = 0;
        right = nums.length - 1;
        int lastPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if mid is too big, throw away right side
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // if mid is small enough, maybe it's the last or we need to go further
                if (nums[mid] == target) {
                    lastPos = mid;  // remember this spot
                }
                // in either case, keep looking right
                left = mid + 1;
            }
        }

        result[1] = lastPos;
        return result;
    }
}
