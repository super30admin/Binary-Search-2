// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially mixed up the condition to detect the minimum element,
// but fixed it by comparing nums[mid] with its neighbors safely using bounds check.

// Your code here along with comments explaining your approach in three sentences only:
// I am using binary search to find the minimum element in a rotated sorted array with no duplicates.
// First, I check if the current subarray is sorted; if it is, the first element is the minimum.
// Otherwise, I look for the pivot where nums[mid] is less than both neighbors, or I move to the unsorted half accordingly.

public class MinRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If current segment is sorted, return first element
            if (nums[start] <= nums[end]) {
                return nums[start];
            }

            // If mid is the pivot (less than both neighbors), return it
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            // If left half is sorted, pivot must be in right half
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                // Right half is sorted or pivot is in left half
                end = mid - 1;
            }
        }

        return -1; // This should never be reached for a valid rotated array
    }
    public static void main(String[] args) {
        MinRotatedArray solution = new MinRotatedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {2, 1};

        System.out.println("Minimum in nums1: " + solution.findMin(nums1)); // Output: 1
        System.out.println("Minimum in nums2: " + solution.findMin(nums2)); // Output: 0
        System.out.println("Minimum in nums3: " + solution.findMin(nums3)); // Output: 1
        System.out.println("Minimum in nums4: " + solution.findMin(nums4)); // Output: 1
    }
}
