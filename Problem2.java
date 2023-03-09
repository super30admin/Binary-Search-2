// Time: O(Log(n))
// Space:O(1)

class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[hi] >= nums[0]) {
            // Array is not rotated
            return nums[0];
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Found the pivot element
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                // Found the pivot element
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                // Minimum element is in the right half
                lo = mid + 1;
            } else {
                // Minimum element is in the left half
                hi = mid - 1;
            }
        }

        return -1;
    }
}
