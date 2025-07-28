// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially missed checking edge conditions like mid - 1 going out of bounds.

// Your code here along with comments explaining your approach in three sentences only:
// I used binary search to find a peak element in the array. A peak is defined as an element greater than its neighbors.
// At each step, I compare nums[mid] with its neighbors and decide the direction of search accordingly.

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // Edge case: if array is empty, no peak
        if (nums.length < 1) {
            return -1;
        }
        // Edge case: single element is trivially a peak
        if (nums.length == 1) {
            return 0;
        }
        // Check if the last element is greater than its previous — it's a peak
        if (nums[end] > nums[end - 1]) {
            return end;
        }
        // Binary search for a peak
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if nums[mid] is greater than both its neighbors (or is at boundary)
            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // Peak found
            }

            // If left neighbor is greater, peak must be in left half
            else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            }

            // Else, peak must be in right half
            else {
                start = mid + 1;
            }
        }
        return -1; // No peak found (should not happen with valid input)
    }

    // Main method for basic testing
    public static void main(String[] args) {
        PeakElement sol = new PeakElement();
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};

        System.out.println("Peak index in nums1: " + sol.findPeakElement(nums1)); // Output can be 2
        System.out.println("Peak index in nums2: " + sol.findPeakElement(nums2)); // Output can be 1 or 5
    }
}

