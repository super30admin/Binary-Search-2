// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Intuition:
 * Use property of rotated sorted array => one-half is sorted and the other is
 * not sorted
 * If we divide the array into 2, sorted half: lo == min index (for
 * sure); discard sorted half
 * pick the unsorted half to search for the possibility of min value in it
 * 
 * TC: O(log n)
 * SC: O(1)
 */

public class MinRotatedSortedArray {
    public MinRotatedSortedArray() {

    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid;
        int min = Integer.MAX_VALUE;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[lo] <= nums[mid]) {
                min = Math.min(nums[lo], min);
                lo = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                hi = mid - 1;
            }
        }
        return min;
    }
}