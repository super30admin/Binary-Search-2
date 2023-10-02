// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Intuition:
 * Find the Lower Bound and Upper Bound for the target in the sorted array
 * Hence, ans = [lower_bound, upper_bound]
 * 
 * TC: O(2 log n)
 * SC: O(1)
 */
public class FirstLastPosition {

    public FirstLastPosition() {

    }

    public int[] searchRange(int[] nums, int target) {
        /**
         * Optimizations
         */
        int n = nums.length;
        if (n == 0 || nums[0] > target || target > nums[n - 1]) {
            return new int[] { -1, -1 };
        }

        int lb = lowerBound(nums, target);
        if (lb == -1) {
            return new int[] { -1, -1 };
        }

        int ub = upperBound(nums, target);

        return new int[] { lb, ub };
    }

    private int lowerBound(int[] nums, int target) {
        int lb = -1;
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                lb = mid;
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lb;
    }

    private int upperBound(int[] nums, int target) {
        int ub = -1;
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                ub = mid;
                lo = mid + 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ub;
    }
}