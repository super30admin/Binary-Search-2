// Time Complexity: O(log n)
// Space Complexity: O(1)
// Find the minimum element in a rotated sorted array. The array was originally sorted in ascending order and then rotated.
package src;

// time complexity O(log n)
// space complexity O(1)
public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            // If array is completely sorted, return the low index.
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low)/2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length-1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            // check if left side is sorted
            if (nums[low] <= nums[mid]) {
                low = mid + 1;

                // check if right side is sorted
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            }


        }
        return -1;
    }
}
