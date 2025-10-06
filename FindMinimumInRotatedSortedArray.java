/**
 * Leet code : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * We wil use binary search to find the min in the rotated sorted array.
 * Time Complexity = O(log n)
 */

class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        //check if array is not rotated
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        int start = 0;
        int end = nums.length - 1;
        int currentMin = nums[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= currentMin) {
                currentMin = nums[mid];
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return currentMin;
    }

    public int findMin2(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) { // left sorted range
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}