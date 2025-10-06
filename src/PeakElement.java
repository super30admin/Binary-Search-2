// Find a peak element in an array where an element is a peak if it is greater than its neighbors.
// Time Complexity: O(log n)
// Space Complexity: O(1)
package src;

// time complexity O(log n)
// space complexity O(1)

public class PeakElement {
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high -low)/2; // to avoid integer overflow

            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])) {
                // we found the peak
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
